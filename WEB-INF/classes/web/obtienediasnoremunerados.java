package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtienediasnoremunerados extends GXProcedure
{
   public obtienediasnoremunerados( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtienediasnoremunerados.class ), "" );
   }

   public obtienediasnoremunerados( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             String[] aP7 )
   {
      obtienediasnoremunerados.this.aP8 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        String[] aP7 ,
                        String[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 )
   {
      obtienediasnoremunerados.this.AV8CliCod = aP0;
      obtienediasnoremunerados.this.AV9EmpCod = aP1;
      obtienediasnoremunerados.this.AV10LiqNro = aP2;
      obtienediasnoremunerados.this.AV11LegNumero = aP3;
      obtienediasnoremunerados.this.AV12desdeTipoConCod = aP4;
      obtienediasnoremunerados.this.AV13hastaTipoConCod = aP5;
      obtienediasnoremunerados.this.aP6 = aP6;
      obtienediasnoremunerados.this.aP7 = aP7;
      obtienediasnoremunerados.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV21GXLvl1 = (byte)(0) ;
      /* Using cursor P026V2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LiqNro), Integer.valueOf(AV11LegNumero), AV12desdeTipoConCod, AV13hastaTipoConCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A464DTipoConCod = P026V2_A464DTipoConCod[0] ;
         A275LiqDImpCalcu = P026V2_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = P026V2_n275LiqDImpCalcu[0] ;
         A6LegNumero = P026V2_A6LegNumero[0] ;
         A31LiqNro = P026V2_A31LiqNro[0] ;
         A1EmpCod = P026V2_A1EmpCod[0] ;
         A3CliCod = P026V2_A3CliCod[0] ;
         A1487DConCondicion = P026V2_A1487DConCondicion[0] ;
         A468DSubTipoConCod1 = P026V2_A468DSubTipoConCod1[0] ;
         n468DSubTipoConCod1 = P026V2_n468DSubTipoConCod1[0] ;
         A507LiqDCalculado = P026V2_A507LiqDCalculado[0] ;
         A393DConDescrip = P026V2_A393DConDescrip[0] ;
         A269LiqDCanti = P026V2_A269LiqDCanti[0] ;
         n269LiqDCanti = P026V2_n269LiqDCanti[0] ;
         A81LiqDSecuencial = P026V2_A81LiqDSecuencial[0] ;
         AV21GXLvl1 = (byte)(1) ;
         GXv_boolean1[0] = AV14incluir ;
         new web.restardiaseguncondicionytipo(remoteHandle, context).execute( A1487DConCondicion, A464DTipoConCod, A468DSubTipoConCod1, GXv_boolean1) ;
         obtienediasnoremunerados.this.AV14incluir = GXv_boolean1[0] ;
         if ( AV14incluir )
         {
            if ( A507LiqDCalculado == 0 )
            {
               AV15error = httpContext.getMessage( "Falta calcular ", "") + GXutil.trim( A393DConDescrip) ;
               AV16LiqDLog = GXutil.trim( AV15error) ;
               AV17LiqDCalculado = (byte)(0) ;
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            if ( A275LiqDImpCalcu.doubleValue() < 0 )
            {
               AV18LiqDCanti = AV18LiqDCanti.add(A269LiqDCanti) ;
               AV16LiqDLog += httpContext.getMessage( ". Resta ", "") + GXutil.trim( GXutil.str( A269LiqDCanti, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( A393DConDescrip) ;
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV21GXLvl1 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "none resta", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = obtienediasnoremunerados.this.AV18LiqDCanti;
      this.aP7[0] = obtienediasnoremunerados.this.AV15error;
      this.aP8[0] = obtienediasnoremunerados.this.AV16LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18LiqDCanti = DecimalUtil.ZERO ;
      AV15error = "" ;
      AV16LiqDLog = "" ;
      scmdbuf = "" ;
      P026V2_A464DTipoConCod = new String[] {""} ;
      P026V2_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P026V2_n275LiqDImpCalcu = new boolean[] {false} ;
      P026V2_A6LegNumero = new int[1] ;
      P026V2_A31LiqNro = new int[1] ;
      P026V2_A1EmpCod = new short[1] ;
      P026V2_A3CliCod = new int[1] ;
      P026V2_A1487DConCondicion = new String[] {""} ;
      P026V2_A468DSubTipoConCod1 = new String[] {""} ;
      P026V2_n468DSubTipoConCod1 = new boolean[] {false} ;
      P026V2_A507LiqDCalculado = new byte[1] ;
      P026V2_A393DConDescrip = new String[] {""} ;
      P026V2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P026V2_n269LiqDCanti = new boolean[] {false} ;
      P026V2_A81LiqDSecuencial = new int[1] ;
      A464DTipoConCod = "" ;
      A275LiqDImpCalcu = DecimalUtil.ZERO ;
      A1487DConCondicion = "" ;
      A468DSubTipoConCod1 = "" ;
      A393DConDescrip = "" ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      GXv_boolean1 = new boolean[1] ;
      AV22Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obtienediasnoremunerados__default(),
         new Object[] {
             new Object[] {
            P026V2_A464DTipoConCod, P026V2_A275LiqDImpCalcu, P026V2_n275LiqDImpCalcu, P026V2_A6LegNumero, P026V2_A31LiqNro, P026V2_A1EmpCod, P026V2_A3CliCod, P026V2_A1487DConCondicion, P026V2_A468DSubTipoConCod1, P026V2_n468DSubTipoConCod1,
            P026V2_A507LiqDCalculado, P026V2_A393DConDescrip, P026V2_A269LiqDCanti, P026V2_n269LiqDCanti, P026V2_A81LiqDSecuencial
            }
         }
      );
      AV22Pgmname = "obtieneDiasNoRemunerados" ;
      /* GeneXus formulas. */
      AV22Pgmname = "obtieneDiasNoRemunerados" ;
      Gx_err = (short)(0) ;
   }

   private byte AV21GXLvl1 ;
   private byte A507LiqDCalculado ;
   private byte AV17LiqDCalculado ;
   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LiqNro ;
   private int AV11LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV18LiqDCanti ;
   private java.math.BigDecimal A275LiqDImpCalcu ;
   private java.math.BigDecimal A269LiqDCanti ;
   private String AV12desdeTipoConCod ;
   private String AV13hastaTipoConCod ;
   private String scmdbuf ;
   private String A464DTipoConCod ;
   private String A1487DConCondicion ;
   private String A468DSubTipoConCod1 ;
   private String AV22Pgmname ;
   private boolean n275LiqDImpCalcu ;
   private boolean n468DSubTipoConCod1 ;
   private boolean n269LiqDCanti ;
   private boolean AV14incluir ;
   private boolean GXv_boolean1[] ;
   private boolean returnInSub ;
   private String AV16LiqDLog ;
   private String AV15error ;
   private String A393DConDescrip ;
   private String[] aP8 ;
   private java.math.BigDecimal[] aP6 ;
   private String[] aP7 ;
   private IDataStoreProvider pr_default ;
   private String[] P026V2_A464DTipoConCod ;
   private java.math.BigDecimal[] P026V2_A275LiqDImpCalcu ;
   private boolean[] P026V2_n275LiqDImpCalcu ;
   private int[] P026V2_A6LegNumero ;
   private int[] P026V2_A31LiqNro ;
   private short[] P026V2_A1EmpCod ;
   private int[] P026V2_A3CliCod ;
   private String[] P026V2_A1487DConCondicion ;
   private String[] P026V2_A468DSubTipoConCod1 ;
   private boolean[] P026V2_n468DSubTipoConCod1 ;
   private byte[] P026V2_A507LiqDCalculado ;
   private String[] P026V2_A393DConDescrip ;
   private java.math.BigDecimal[] P026V2_A269LiqDCanti ;
   private boolean[] P026V2_n269LiqDCanti ;
   private int[] P026V2_A81LiqDSecuencial ;
}

final  class obtienediasnoremunerados__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P026V2", "SELECT DTipoConCod, LiqDImpCalcu, LegNumero, LiqNro, EmpCod, CliCod, DConCondicion, DSubTipoConCod1, LiqDCalculado, DConDescrip, LiqDCanti, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?) AND (LiqDImpCalcu <= 0) AND (DTipoConCod >= ( ?)) AND (DTipoConCod <= ( ?)) ORDER BY CliCod, EmpCod, LiqNro, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((byte[]) buf[10])[0] = rslt.getByte(9);
               ((String[]) buf[11])[0] = rslt.getVarchar(10);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((int[]) buf[14])[0] = rslt.getInt(12);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
      }
   }

}

