package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpaitipotra extends GXProcedure
{
   public getpaitipotra( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpaitipotra.class ), "" );
   }

   public getpaitipotra( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( short aP0 ,
                                           String aP1 ,
                                           boolean[] aP2 ,
                                           java.math.BigDecimal[] aP3 ,
                                           java.math.BigDecimal[] aP4 ,
                                           java.math.BigDecimal[] aP5 ,
                                           java.math.BigDecimal[] aP6 ,
                                           java.math.BigDecimal[] aP7 ,
                                           java.math.BigDecimal[] aP8 ,
                                           java.math.BigDecimal[] aP9 )
   {
      getpaitipotra.this.aP10 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        boolean[] aP2 ,
                        java.math.BigDecimal[] aP3 ,
                        java.math.BigDecimal[] aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        java.math.BigDecimal[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             boolean[] aP2 ,
                             java.math.BigDecimal[] aP3 ,
                             java.math.BigDecimal[] aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             java.math.BigDecimal[] aP10 )
   {
      getpaitipotra.this.AV18PaiCod = aP0;
      getpaitipotra.this.AV17PaiTipoTraId = aP1;
      getpaitipotra.this.aP2 = aP2;
      getpaitipotra.this.aP3 = aP3;
      getpaitipotra.this.aP4 = aP4;
      getpaitipotra.this.aP5 = aP5;
      getpaitipotra.this.aP6 = aP6;
      getpaitipotra.this.aP7 = aP7;
      getpaitipotra.this.aP8 = aP8;
      getpaitipotra.this.aP9 = aP9;
      getpaitipotra.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02M72 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV18PaiCod), AV17PaiTipoTraId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1294PaiTipoTraId = P02M72_A1294PaiTipoTraId[0] ;
         A46PaiCod = P02M72_A46PaiCod[0] ;
         A1297PaiTipoTraIns = P02M72_A1297PaiTipoTraIns[0] ;
         A1336PaiTipoHsDia = P02M72_A1336PaiTipoHsDia[0] ;
         A1337PaiTipoHsSem = P02M72_A1337PaiTipoHsSem[0] ;
         A1338PaiTipoTarifaXLim = P02M72_A1338PaiTipoTarifaXLim[0] ;
         A1347PaiTipoTarifaRec = P02M72_A1347PaiTipoTarifaRec[0] ;
         A1383PaiTipoHsMaxDia = P02M72_A1383PaiTipoHsMaxDia[0] ;
         A1384PaiTipoHsMaxSem = P02M72_A1384PaiTipoHsMaxSem[0] ;
         A1385PaiTipoHsMaxMes = P02M72_A1385PaiTipoHsMaxMes[0] ;
         A1390PaiTipoHsMaxAnu = P02M72_A1390PaiTipoHsMaxAnu[0] ;
         AV16PaiTipoTraIns = A1297PaiTipoTraIns ;
         AV15PaiTipoHsDia = A1336PaiTipoHsDia ;
         AV14PaiTipoHsSem = A1337PaiTipoHsSem ;
         AV13PaiTipoTarifaXLim = A1338PaiTipoTarifaXLim ;
         AV12PaiTipoTarifaRec = A1347PaiTipoTarifaRec ;
         AV11PaiTipoHsMaxDia = A1383PaiTipoHsMaxDia ;
         AV10PaiTipoHsMaxSem = A1384PaiTipoHsMaxSem ;
         AV9PaiTipoHsMaxMes = A1385PaiTipoHsMaxMes ;
         AV8PaiTipoHsMaxAnu = A1390PaiTipoHsMaxAnu ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getpaitipotra.this.AV16PaiTipoTraIns;
      this.aP3[0] = getpaitipotra.this.AV15PaiTipoHsDia;
      this.aP4[0] = getpaitipotra.this.AV14PaiTipoHsSem;
      this.aP5[0] = getpaitipotra.this.AV13PaiTipoTarifaXLim;
      this.aP6[0] = getpaitipotra.this.AV12PaiTipoTarifaRec;
      this.aP7[0] = getpaitipotra.this.AV11PaiTipoHsMaxDia;
      this.aP8[0] = getpaitipotra.this.AV10PaiTipoHsMaxSem;
      this.aP9[0] = getpaitipotra.this.AV9PaiTipoHsMaxMes;
      this.aP10[0] = getpaitipotra.this.AV8PaiTipoHsMaxAnu;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15PaiTipoHsDia = DecimalUtil.ZERO ;
      AV14PaiTipoHsSem = DecimalUtil.ZERO ;
      AV13PaiTipoTarifaXLim = DecimalUtil.ZERO ;
      AV12PaiTipoTarifaRec = DecimalUtil.ZERO ;
      AV11PaiTipoHsMaxDia = DecimalUtil.ZERO ;
      AV10PaiTipoHsMaxSem = DecimalUtil.ZERO ;
      AV9PaiTipoHsMaxMes = DecimalUtil.ZERO ;
      AV8PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P02M72_A1294PaiTipoTraId = new String[] {""} ;
      P02M72_A46PaiCod = new short[1] ;
      P02M72_A1297PaiTipoTraIns = new boolean[] {false} ;
      P02M72_A1336PaiTipoHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02M72_A1337PaiTipoHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02M72_A1338PaiTipoTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02M72_A1347PaiTipoTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02M72_A1383PaiTipoHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02M72_A1384PaiTipoHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02M72_A1385PaiTipoHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02M72_A1390PaiTipoHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1294PaiTipoTraId = "" ;
      A1336PaiTipoHsDia = DecimalUtil.ZERO ;
      A1337PaiTipoHsSem = DecimalUtil.ZERO ;
      A1338PaiTipoTarifaXLim = DecimalUtil.ZERO ;
      A1347PaiTipoTarifaRec = DecimalUtil.ZERO ;
      A1383PaiTipoHsMaxDia = DecimalUtil.ZERO ;
      A1384PaiTipoHsMaxSem = DecimalUtil.ZERO ;
      A1385PaiTipoHsMaxMes = DecimalUtil.ZERO ;
      A1390PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpaitipotra__default(),
         new Object[] {
             new Object[] {
            P02M72_A1294PaiTipoTraId, P02M72_A46PaiCod, P02M72_A1297PaiTipoTraIns, P02M72_A1336PaiTipoHsDia, P02M72_A1337PaiTipoHsSem, P02M72_A1338PaiTipoTarifaXLim, P02M72_A1347PaiTipoTarifaRec, P02M72_A1383PaiTipoHsMaxDia, P02M72_A1384PaiTipoHsMaxSem, P02M72_A1385PaiTipoHsMaxMes,
            P02M72_A1390PaiTipoHsMaxAnu
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV18PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private java.math.BigDecimal AV15PaiTipoHsDia ;
   private java.math.BigDecimal AV14PaiTipoHsSem ;
   private java.math.BigDecimal AV13PaiTipoTarifaXLim ;
   private java.math.BigDecimal AV12PaiTipoTarifaRec ;
   private java.math.BigDecimal AV11PaiTipoHsMaxDia ;
   private java.math.BigDecimal AV10PaiTipoHsMaxSem ;
   private java.math.BigDecimal AV9PaiTipoHsMaxMes ;
   private java.math.BigDecimal AV8PaiTipoHsMaxAnu ;
   private java.math.BigDecimal A1336PaiTipoHsDia ;
   private java.math.BigDecimal A1337PaiTipoHsSem ;
   private java.math.BigDecimal A1338PaiTipoTarifaXLim ;
   private java.math.BigDecimal A1347PaiTipoTarifaRec ;
   private java.math.BigDecimal A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal A1390PaiTipoHsMaxAnu ;
   private String AV17PaiTipoTraId ;
   private String scmdbuf ;
   private String A1294PaiTipoTraId ;
   private boolean AV16PaiTipoTraIns ;
   private boolean A1297PaiTipoTraIns ;
   private java.math.BigDecimal[] aP10 ;
   private boolean[] aP2 ;
   private java.math.BigDecimal[] aP3 ;
   private java.math.BigDecimal[] aP4 ;
   private java.math.BigDecimal[] aP5 ;
   private java.math.BigDecimal[] aP6 ;
   private java.math.BigDecimal[] aP7 ;
   private java.math.BigDecimal[] aP8 ;
   private java.math.BigDecimal[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P02M72_A1294PaiTipoTraId ;
   private short[] P02M72_A46PaiCod ;
   private boolean[] P02M72_A1297PaiTipoTraIns ;
   private java.math.BigDecimal[] P02M72_A1336PaiTipoHsDia ;
   private java.math.BigDecimal[] P02M72_A1337PaiTipoHsSem ;
   private java.math.BigDecimal[] P02M72_A1338PaiTipoTarifaXLim ;
   private java.math.BigDecimal[] P02M72_A1347PaiTipoTarifaRec ;
   private java.math.BigDecimal[] P02M72_A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal[] P02M72_A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal[] P02M72_A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal[] P02M72_A1390PaiTipoHsMaxAnu ;
}

final  class getpaitipotra__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02M72", "SELECT PaiTipoTraId, PaiCod, PaiTipoTraIns, PaiTipoHsDia, PaiTipoHsSem, PaiTipoTarifaXLim, PaiTipoTarifaRec, PaiTipoHsMaxDia, PaiTipoHsMaxSem, PaiTipoHsMaxMes, PaiTipoHsMaxAnu FROM PaisTipoTrabajo WHERE PaiCod = ? and PaiTipoTraId = ( ?) ORDER BY PaiCod, PaiTipoTraId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,1);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,1);
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
               return;
      }
   }

}

