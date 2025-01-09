package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getareagendeactlabclasporcod extends GXProcedure
{
   public getareagendeactlabclasporcod( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getareagendeactlabclasporcod.class ), "" );
   }

   public getareagendeactlabclasporcod( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 ,
                             int aP1 )
   {
      getareagendeactlabclasporcod.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        int aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             int aP1 ,
                             String[] aP2 )
   {
      getareagendeactlabclasporcod.this.AV9PaiCod = aP0;
      getareagendeactlabclasporcod.this.AV11ActLabNro = aP1;
      getareagendeactlabclasporcod.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P025A2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV9PaiCod), Integer.valueOf(AV11ActLabNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2217ActLabNro = P025A2_A2217ActLabNro[0] ;
         A46PaiCod = P025A2_A46PaiCod[0] ;
         A2219ActLabAreaGen = P025A2_A2219ActLabAreaGen[0] ;
         A2220ActLabDesSinAc = P025A2_A2220ActLabDesSinAc[0] ;
         if ( ! (GXutil.strcmp("", A2219ActLabAreaGen)==0) )
         {
            AV10ActLabAreaGen = A2219ActLabAreaGen ;
         }
         else
         {
            AV10ActLabAreaGen = A2220ActLabDesSinAc ;
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getareagendeactlabclasporcod.this.AV10ActLabAreaGen;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ActLabAreaGen = "" ;
      scmdbuf = "" ;
      P025A2_A2217ActLabNro = new int[1] ;
      P025A2_A46PaiCod = new short[1] ;
      P025A2_A2219ActLabAreaGen = new String[] {""} ;
      P025A2_A2220ActLabDesSinAc = new String[] {""} ;
      A2219ActLabAreaGen = "" ;
      A2220ActLabDesSinAc = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getareagendeactlabclasporcod__default(),
         new Object[] {
             new Object[] {
            P025A2_A2217ActLabNro, P025A2_A46PaiCod, P025A2_A2219ActLabAreaGen, P025A2_A2220ActLabDesSinAc
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV11ActLabNro ;
   private int A2217ActLabNro ;
   private String scmdbuf ;
   private String AV10ActLabAreaGen ;
   private String A2219ActLabAreaGen ;
   private String A2220ActLabDesSinAc ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P025A2_A2217ActLabNro ;
   private short[] P025A2_A46PaiCod ;
   private String[] P025A2_A2219ActLabAreaGen ;
   private String[] P025A2_A2220ActLabDesSinAc ;
}

final  class getareagendeactlabclasporcod__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P025A2", "SELECT ActLabNro, PaiCod, ActLabAreaGen, ActLabDesSinAc FROM ActividadLaboralClasificada WHERE PaiCod = ? and ActLabNro = ? ORDER BY PaiCod, ActLabNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

