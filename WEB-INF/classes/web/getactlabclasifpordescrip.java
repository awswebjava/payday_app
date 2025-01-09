package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getactlabclasifpordescrip extends GXProcedure
{
   public getactlabclasifpordescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getactlabclasifpordescrip.class ), "" );
   }

   public getactlabclasifpordescrip( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( short aP0 ,
                              String aP1 ,
                              int[] aP2 )
   {
      getactlabclasifpordescrip.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        int[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             int[] aP2 ,
                             boolean[] aP3 )
   {
      getactlabclasifpordescrip.this.AV11PaiCod = aP0;
      getactlabclasifpordescrip.this.AV9ActLabDesSinAc = aP1;
      getactlabclasifpordescrip.this.aP2 = aP2;
      getactlabclasifpordescrip.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P025P2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV11PaiCod), AV9ActLabDesSinAc});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2220ActLabDesSinAc = P025P2_A2220ActLabDesSinAc[0] ;
         A46PaiCod = P025P2_A46PaiCod[0] ;
         A2217ActLabNro = P025P2_A2217ActLabNro[0] ;
         AV10ActLabNro = A2217ActLabNro ;
         AV12existe = true ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getactlabclasifpordescrip.this.AV10ActLabNro;
      this.aP3[0] = getactlabclasifpordescrip.this.AV12existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P025P2_A2220ActLabDesSinAc = new String[] {""} ;
      P025P2_A46PaiCod = new short[1] ;
      P025P2_A2217ActLabNro = new int[1] ;
      A2220ActLabDesSinAc = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getactlabclasifpordescrip__default(),
         new Object[] {
             new Object[] {
            P025P2_A2220ActLabDesSinAc, P025P2_A46PaiCod, P025P2_A2217ActLabNro
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
   private String AV9ActLabDesSinAc ;
   private String A2220ActLabDesSinAc ;
   private boolean[] aP3 ;
   private int[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P025P2_A2220ActLabDesSinAc ;
   private short[] P025P2_A46PaiCod ;
   private int[] P025P2_A2217ActLabNro ;
}

final  class getactlabclasifpordescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P025P2", "SELECT ActLabDesSinAc, PaiCod, ActLabNro FROM ActividadLaboralClasificada WHERE (PaiCod = ?) AND (ActLabDesSinAc = ( ?)) ORDER BY PaiCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
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
               stmt.setVarchar(2, (String)parms[1], 400);
               return;
      }
   }

}

