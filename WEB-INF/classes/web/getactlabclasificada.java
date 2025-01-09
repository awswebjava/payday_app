package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getactlabclasificada extends GXProcedure
{
   public getactlabclasificada( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getactlabclasificada.class ), "" );
   }

   public getactlabclasificada( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( short aP0 ,
                              int aP1 ,
                              String[] aP2 ,
                              String[] aP3 )
   {
      getactlabclasificada.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( short aP0 ,
                        int aP1 ,
                        String[] aP2 ,
                        String[] aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( short aP0 ,
                             int aP1 ,
                             String[] aP2 ,
                             String[] aP3 ,
                             boolean[] aP4 )
   {
      getactlabclasificada.this.AV11PaiCod = aP0;
      getactlabclasificada.this.AV10ActLabNro = aP1;
      getactlabclasificada.this.aP2 = aP2;
      getactlabclasificada.this.aP3 = aP3;
      getactlabclasificada.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P025O2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV11PaiCod), Integer.valueOf(AV10ActLabNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2217ActLabNro = P025O2_A2217ActLabNro[0] ;
         A46PaiCod = P025O2_A46PaiCod[0] ;
         A2218ActLabDescrip = P025O2_A2218ActLabDescrip[0] ;
         A2220ActLabDesSinAc = P025O2_A2220ActLabDesSinAc[0] ;
         AV8ActLabDescrip = A2218ActLabDescrip ;
         AV9ActLabDesSinAc = A2220ActLabDesSinAc ;
         AV12existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getactlabclasificada.this.AV8ActLabDescrip;
      this.aP3[0] = getactlabclasificada.this.AV9ActLabDesSinAc;
      this.aP4[0] = getactlabclasificada.this.AV12existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ActLabDescrip = "" ;
      AV9ActLabDesSinAc = "" ;
      scmdbuf = "" ;
      P025O2_A2217ActLabNro = new int[1] ;
      P025O2_A46PaiCod = new short[1] ;
      P025O2_A2218ActLabDescrip = new String[] {""} ;
      P025O2_A2220ActLabDesSinAc = new String[] {""} ;
      A2218ActLabDescrip = "" ;
      A2220ActLabDesSinAc = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getactlabclasificada__default(),
         new Object[] {
             new Object[] {
            P025O2_A2217ActLabNro, P025O2_A46PaiCod, P025O2_A2218ActLabDescrip, P025O2_A2220ActLabDesSinAc
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV10ActLabNro ;
   private int A2217ActLabNro ;
   private String scmdbuf ;
   private boolean AV12existe ;
   private String AV8ActLabDescrip ;
   private String AV9ActLabDesSinAc ;
   private String A2218ActLabDescrip ;
   private String A2220ActLabDesSinAc ;
   private boolean[] aP4 ;
   private String[] aP2 ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P025O2_A2217ActLabNro ;
   private short[] P025O2_A46PaiCod ;
   private String[] P025O2_A2218ActLabDescrip ;
   private String[] P025O2_A2220ActLabDesSinAc ;
}

final  class getactlabclasificada__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P025O2", "SELECT ActLabNro, PaiCod, ActLabDescrip, ActLabDesSinAc FROM ActividadLaboralClasificada WHERE PaiCod = ? and ActLabNro = ? ORDER BY PaiCod, ActLabNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
      }
   }

}

