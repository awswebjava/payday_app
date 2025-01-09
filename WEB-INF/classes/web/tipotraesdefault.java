package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tipotraesdefault extends GXProcedure
{
   public tipotraesdefault( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipotraesdefault.class ), "" );
   }

   public tipotraesdefault( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( short aP0 ,
                              String aP1 ,
                              java.math.BigDecimal aP2 ,
                              java.math.BigDecimal aP3 ,
                              java.math.BigDecimal aP4 ,
                              java.math.BigDecimal aP5 ,
                              java.math.BigDecimal aP6 ,
                              java.math.BigDecimal aP7 ,
                              java.math.BigDecimal aP8 ,
                              java.math.BigDecimal aP9 )
   {
      tipotraesdefault.this.aP10 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        java.math.BigDecimal aP2 ,
                        java.math.BigDecimal aP3 ,
                        java.math.BigDecimal aP4 ,
                        java.math.BigDecimal aP5 ,
                        java.math.BigDecimal aP6 ,
                        java.math.BigDecimal aP7 ,
                        java.math.BigDecimal aP8 ,
                        java.math.BigDecimal aP9 ,
                        boolean[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             java.math.BigDecimal aP2 ,
                             java.math.BigDecimal aP3 ,
                             java.math.BigDecimal aP4 ,
                             java.math.BigDecimal aP5 ,
                             java.math.BigDecimal aP6 ,
                             java.math.BigDecimal aP7 ,
                             java.math.BigDecimal aP8 ,
                             java.math.BigDecimal aP9 ,
                             boolean[] aP10 )
   {
      tipotraesdefault.this.AV20PaiCod = aP0;
      tipotraesdefault.this.AV8PaiTipoTraId = aP1;
      tipotraesdefault.this.AV11PaiTipoHsDia = aP2;
      tipotraesdefault.this.AV19PaiTipoHsSem = aP3;
      tipotraesdefault.this.AV18PaiTipoTarifaXLim = aP4;
      tipotraesdefault.this.AV12PaiTipoTarifaRec = aP5;
      tipotraesdefault.this.AV17PaiTipoHsMaxDia = aP6;
      tipotraesdefault.this.AV13PaiTipoHsMaxSem = aP7;
      tipotraesdefault.this.AV16PaiTipoHsMaxMes = aP8;
      tipotraesdefault.this.AV14PaiTipoHsMaxAnu = aP9;
      tipotraesdefault.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01SU2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV20PaiCod), AV8PaiTipoTraId, AV11PaiTipoHsDia, AV19PaiTipoHsSem, AV18PaiTipoTarifaXLim, AV12PaiTipoTarifaRec, AV17PaiTipoHsMaxDia, AV13PaiTipoHsMaxSem, AV16PaiTipoHsMaxMes, AV14PaiTipoHsMaxAnu});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1390PaiTipoHsMaxAnu = P01SU2_A1390PaiTipoHsMaxAnu[0] ;
         A1385PaiTipoHsMaxMes = P01SU2_A1385PaiTipoHsMaxMes[0] ;
         A1384PaiTipoHsMaxSem = P01SU2_A1384PaiTipoHsMaxSem[0] ;
         A1383PaiTipoHsMaxDia = P01SU2_A1383PaiTipoHsMaxDia[0] ;
         A1347PaiTipoTarifaRec = P01SU2_A1347PaiTipoTarifaRec[0] ;
         A1338PaiTipoTarifaXLim = P01SU2_A1338PaiTipoTarifaXLim[0] ;
         A1337PaiTipoHsSem = P01SU2_A1337PaiTipoHsSem[0] ;
         A1336PaiTipoHsDia = P01SU2_A1336PaiTipoHsDia[0] ;
         A1294PaiTipoTraId = P01SU2_A1294PaiTipoTraId[0] ;
         A46PaiCod = P01SU2_A46PaiCod[0] ;
         AV15defaultEs = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP10[0] = tipotraesdefault.this.AV15defaultEs;
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
      P01SU2_A1390PaiTipoHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01SU2_A1385PaiTipoHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01SU2_A1384PaiTipoHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01SU2_A1383PaiTipoHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01SU2_A1347PaiTipoTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01SU2_A1338PaiTipoTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01SU2_A1337PaiTipoHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01SU2_A1336PaiTipoHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01SU2_A1294PaiTipoTraId = new String[] {""} ;
      P01SU2_A46PaiCod = new short[1] ;
      A1390PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
      A1385PaiTipoHsMaxMes = DecimalUtil.ZERO ;
      A1384PaiTipoHsMaxSem = DecimalUtil.ZERO ;
      A1383PaiTipoHsMaxDia = DecimalUtil.ZERO ;
      A1347PaiTipoTarifaRec = DecimalUtil.ZERO ;
      A1338PaiTipoTarifaXLim = DecimalUtil.ZERO ;
      A1337PaiTipoHsSem = DecimalUtil.ZERO ;
      A1336PaiTipoHsDia = DecimalUtil.ZERO ;
      A1294PaiTipoTraId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tipotraesdefault__default(),
         new Object[] {
             new Object[] {
            P01SU2_A1390PaiTipoHsMaxAnu, P01SU2_A1385PaiTipoHsMaxMes, P01SU2_A1384PaiTipoHsMaxSem, P01SU2_A1383PaiTipoHsMaxDia, P01SU2_A1347PaiTipoTarifaRec, P01SU2_A1338PaiTipoTarifaXLim, P01SU2_A1337PaiTipoHsSem, P01SU2_A1336PaiTipoHsDia, P01SU2_A1294PaiTipoTraId, P01SU2_A46PaiCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV20PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private java.math.BigDecimal AV11PaiTipoHsDia ;
   private java.math.BigDecimal AV19PaiTipoHsSem ;
   private java.math.BigDecimal AV18PaiTipoTarifaXLim ;
   private java.math.BigDecimal AV12PaiTipoTarifaRec ;
   private java.math.BigDecimal AV17PaiTipoHsMaxDia ;
   private java.math.BigDecimal AV13PaiTipoHsMaxSem ;
   private java.math.BigDecimal AV16PaiTipoHsMaxMes ;
   private java.math.BigDecimal AV14PaiTipoHsMaxAnu ;
   private java.math.BigDecimal A1390PaiTipoHsMaxAnu ;
   private java.math.BigDecimal A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal A1347PaiTipoTarifaRec ;
   private java.math.BigDecimal A1338PaiTipoTarifaXLim ;
   private java.math.BigDecimal A1337PaiTipoHsSem ;
   private java.math.BigDecimal A1336PaiTipoHsDia ;
   private String AV8PaiTipoTraId ;
   private String scmdbuf ;
   private String A1294PaiTipoTraId ;
   private boolean AV15defaultEs ;
   private boolean[] aP10 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P01SU2_A1390PaiTipoHsMaxAnu ;
   private java.math.BigDecimal[] P01SU2_A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal[] P01SU2_A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal[] P01SU2_A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal[] P01SU2_A1347PaiTipoTarifaRec ;
   private java.math.BigDecimal[] P01SU2_A1338PaiTipoTarifaXLim ;
   private java.math.BigDecimal[] P01SU2_A1337PaiTipoHsSem ;
   private java.math.BigDecimal[] P01SU2_A1336PaiTipoHsDia ;
   private String[] P01SU2_A1294PaiTipoTraId ;
   private short[] P01SU2_A46PaiCod ;
}

final  class tipotraesdefault__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01SU2", "SELECT PaiTipoHsMaxAnu, PaiTipoHsMaxMes, PaiTipoHsMaxSem, PaiTipoHsMaxDia, PaiTipoTarifaRec, PaiTipoTarifaXLim, PaiTipoHsSem, PaiTipoHsDia, PaiTipoTraId, PaiCod FROM PaisTipoTrabajo WHERE (PaiCod = ? and PaiTipoTraId = ( ?)) AND (PaiTipoHsDia = ?) AND (PaiTipoHsSem = ?) AND (PaiTipoTarifaXLim = ?) AND (PaiTipoTarifaRec = ?) AND (PaiTipoHsMaxDia = ?) AND (PaiTipoHsMaxSem = ?) AND (PaiTipoHsMaxMes = ?) AND (PaiTipoHsMaxAnu = ?) ORDER BY PaiCod, PaiTipoTraId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,1);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,1);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((short[]) buf[9])[0] = rslt.getShort(10);
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
               stmt.setString(2, (String)parms[1], 20);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 1);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 1);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 4);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 1);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 1);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[8], 1);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[9], 1);
               return;
      }
   }

}

