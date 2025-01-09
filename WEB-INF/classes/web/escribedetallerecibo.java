package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class escribedetallerecibo extends GXProcedure
{
   public escribedetallerecibo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( escribedetallerecibo.class ), "" );
   }

   public escribedetallerecibo( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 ,
                            int aP3 ,
                            String aP4 ,
                            short aP5 ,
                            short aP6 ,
                            String[] aP7 ,
                            byte[] aP8 ,
                            java.util.Date[] aP9 ,
                            String[] aP10 )
   {
      escribedetallerecibo.this.aP11 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        short aP5 ,
                        short aP6 ,
                        String[] aP7 ,
                        byte[] aP8 ,
                        java.util.Date[] aP9 ,
                        String[] aP10 ,
                        short[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             short aP5 ,
                             short aP6 ,
                             String[] aP7 ,
                             byte[] aP8 ,
                             java.util.Date[] aP9 ,
                             String[] aP10 ,
                             short[] aP11 )
   {
      escribedetallerecibo.this.AV18CliCod = aP0;
      escribedetallerecibo.this.AV16EmpCod = aP1;
      escribedetallerecibo.this.AV19LiqNro = aP2;
      escribedetallerecibo.this.AV20LegNumero = aP3;
      escribedetallerecibo.this.AV8TempRecHTMLRow = aP4;
      escribedetallerecibo.this.AV15TempRecPageSize = aP5;
      escribedetallerecibo.this.AV17pageNumber = aP6;
      escribedetallerecibo.this.AV30TLiqCod = aP7[0];
      this.aP7 = aP7;
      escribedetallerecibo.this.AV31LegClase = aP8[0];
      this.aP8 = aP8;
      escribedetallerecibo.this.AV32LiqPeriodo = aP9[0];
      this.aP9 = aP9;
      escribedetallerecibo.this.aP10 = aP10;
      escribedetallerecibo.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV39skip = (short)(AV15TempRecPageSize*(AV17pageNumber-1)) ;
      AV25i = (short)(0) ;
      AV41i2 = (short)(1) ;
      /* Using cursor P00KP2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV16EmpCod), Integer.valueOf(AV19LiqNro), Integer.valueOf(AV20LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A502LiqDMostrar = P00KP2_A502LiqDMostrar[0] ;
         A6LegNumero = P00KP2_A6LegNumero[0] ;
         A31LiqNro = P00KP2_A31LiqNro[0] ;
         A1EmpCod = P00KP2_A1EmpCod[0] ;
         A3CliCod = P00KP2_A3CliCod[0] ;
         A464DTipoConCod = P00KP2_A464DTipoConCod[0] ;
         A764LiqDImpReCalcu = P00KP2_A764LiqDImpReCalcu[0] ;
         A394DConCodigo = P00KP2_A394DConCodigo[0] ;
         A1487DConCondicion = P00KP2_A1487DConCondicion[0] ;
         A393DConDescrip = P00KP2_A393DConDescrip[0] ;
         A269LiqDCanti = P00KP2_A269LiqDCanti[0] ;
         n269LiqDCanti = P00KP2_n269LiqDCanti[0] ;
         A968LiqDUniMed = P00KP2_A968LiqDUniMed[0] ;
         A471DConOrden = P00KP2_A471DConOrden[0] ;
         A81LiqDSecuencial = P00KP2_A81LiqDSecuencial[0] ;
         AV25i = (short)(AV25i+1) ;
         if ( ( AV25i > AV39skip ) && ( AV41i2 <= AV15TempRecPageSize ) )
         {
            AV10fila = GXutil.trim( AV8TempRecHTMLRow) ;
            if ( GXutil.strcmp(A464DTipoConCod, "DES_ARG") == 0 )
            {
               AV13Remunerativo = DecimalUtil.ZERO ;
               AV11NoRemunerativo = DecimalUtil.ZERO ;
               AV12Descuento = A764LiqDImpReCalcu ;
            }
            else if ( GXutil.strcmp(A464DTipoConCod, "NRE_ARG") == 0 )
            {
               AV13Remunerativo = DecimalUtil.ZERO ;
               AV11NoRemunerativo = A764LiqDImpReCalcu ;
               AV12Descuento = DecimalUtil.ZERO ;
            }
            else if ( GXutil.strcmp(A464DTipoConCod, "REM_ARG") == 0 )
            {
               AV13Remunerativo = A764LiqDImpReCalcu ;
               AV11NoRemunerativo = DecimalUtil.ZERO ;
               AV12Descuento = DecimalUtil.ZERO ;
            }
            else
            {
               AV13Remunerativo = DecimalUtil.ZERO ;
               AV11NoRemunerativo = A764LiqDImpReCalcu ;
               AV12Descuento = DecimalUtil.ZERO ;
            }
            AV10fila = GXutil.strReplace( AV10fila, httpContext.getMessage( "$codigo", ""), GXutil.trim( A394DConCodigo)) ;
            if ( GXutil.strcmp(A1487DConCondicion, "B7") == 0 )
            {
               GXv_date1[0] = AV33iniPeriodo ;
               GXv_date2[0] = AV34finPeriodo ;
               new web.getrangoperiodos(remoteHandle, context).execute( AV18CliCod, AV16EmpCod, AV19LiqNro, AV20LegNumero, AV30TLiqCod, AV31LegClase, AV32LiqPeriodo, false, GXv_date1, GXv_date2) ;
               escribedetallerecibo.this.AV33iniPeriodo = GXv_date1[0] ;
               escribedetallerecibo.this.AV34finPeriodo = GXv_date2[0] ;
               GXv_int3[0] = (short)(0) ;
               GXv_boolean4[0] = AV28masDeUnaHay ;
               new web.devuelvecantlic(remoteHandle, context).execute( AV18CliCod, AV16EmpCod, AV20LegNumero, AV33iniPeriodo, AV34finPeriodo, (byte)(0), GXv_int3, GXv_boolean4) ;
               escribedetallerecibo.this.AV28masDeUnaHay = GXv_boolean4[0] ;
               if ( AV28masDeUnaHay )
               {
                  AV27DConDescrip = GXutil.trim( A393DConDescrip) ;
               }
               else
               {
                  AV27DConDescrip = GXutil.trim( AV29SitDescrip) ;
               }
            }
            else
            {
               AV27DConDescrip = GXutil.trim( A393DConDescrip) ;
            }
            AV10fila = GXutil.strReplace( AV10fila, httpContext.getMessage( "$descripcion", ""), GXutil.trim( AV27DConDescrip)) ;
            AV26cantidadPalabra = localUtil.format( A269LiqDCanti, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
            AV26cantidadPalabra = GXutil.strReplace( AV26cantidadPalabra, ".00", "") ;
            AV26cantidadPalabra = GXutil.strReplace( AV26cantidadPalabra, ",00", "") ;
            AV10fila = GXutil.strReplace( AV10fila, httpContext.getMessage( "$cant", ""), GXutil.trim( AV26cantidadPalabra)+GXutil.trim( A968LiqDUniMed)) ;
            AV10fila = GXutil.strReplace( AV10fila, httpContext.getMessage( "$remu", ""), localUtil.format( AV13Remunerativo, "ZZ,ZZZ,ZZZ,ZZ9.99")) ;
            AV10fila = GXutil.strReplace( AV10fila, httpContext.getMessage( "$descu", ""), localUtil.format( AV12Descuento, "ZZ,ZZZ,ZZZ,ZZ9.99")) ;
            AV10fila = GXutil.strReplace( AV10fila, httpContext.getMessage( "$noRemu", ""), localUtil.format( AV11NoRemunerativo, "ZZ,ZZZ,ZZZ,ZZ9.99")) ;
            AV9filas += GXutil.trim( AV10fila) ;
            AV22cntFilas = (short)(AV22cntFilas+1) ;
            AV41i2 = (short)(AV41i2+1) ;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV24filaVacia = GXutil.trim( AV8TempRecHTMLRow) ;
      AV24filaVacia = GXutil.strReplace( AV24filaVacia, httpContext.getMessage( "$codigo", ""), "") ;
      AV24filaVacia = GXutil.strReplace( AV24filaVacia, httpContext.getMessage( "$descripcion", ""), "") ;
      AV24filaVacia = GXutil.strReplace( AV24filaVacia, httpContext.getMessage( "$cant", ""), "") ;
      AV24filaVacia = GXutil.strReplace( AV24filaVacia, httpContext.getMessage( "$remu", ""), "") ;
      AV24filaVacia = GXutil.strReplace( AV24filaVacia, httpContext.getMessage( "$descu", ""), "") ;
      AV24filaVacia = GXutil.strReplace( AV24filaVacia, httpContext.getMessage( "$noRemu", ""), "") ;
      AV23lineasFaltantes = (short)(AV15TempRecPageSize-AV22cntFilas) ;
      AV25i = (short)(0) ;
      while ( AV25i <= AV23lineasFaltantes )
      {
         AV9filas += GXutil.trim( AV24filaVacia) ;
         AV25i = (short)(AV25i+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = escribedetallerecibo.this.AV30TLiqCod;
      this.aP8[0] = escribedetallerecibo.this.AV31LegClase;
      this.aP9[0] = escribedetallerecibo.this.AV32LiqPeriodo;
      this.aP10[0] = escribedetallerecibo.this.AV9filas;
      this.aP11[0] = escribedetallerecibo.this.AV22cntFilas;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9filas = "" ;
      scmdbuf = "" ;
      P00KP2_A502LiqDMostrar = new byte[1] ;
      P00KP2_A6LegNumero = new int[1] ;
      P00KP2_A31LiqNro = new int[1] ;
      P00KP2_A1EmpCod = new short[1] ;
      P00KP2_A3CliCod = new int[1] ;
      P00KP2_A464DTipoConCod = new String[] {""} ;
      P00KP2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00KP2_A394DConCodigo = new String[] {""} ;
      P00KP2_A1487DConCondicion = new String[] {""} ;
      P00KP2_A393DConDescrip = new String[] {""} ;
      P00KP2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00KP2_n269LiqDCanti = new boolean[] {false} ;
      P00KP2_A968LiqDUniMed = new String[] {""} ;
      P00KP2_A471DConOrden = new int[1] ;
      P00KP2_A81LiqDSecuencial = new int[1] ;
      A464DTipoConCod = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A394DConCodigo = "" ;
      A1487DConCondicion = "" ;
      A393DConDescrip = "" ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      A968LiqDUniMed = "" ;
      AV10fila = "" ;
      AV13Remunerativo = DecimalUtil.ZERO ;
      AV11NoRemunerativo = DecimalUtil.ZERO ;
      AV12Descuento = DecimalUtil.ZERO ;
      AV33iniPeriodo = GXutil.nullDate() ;
      GXv_date1 = new java.util.Date[1] ;
      AV34finPeriodo = GXutil.nullDate() ;
      GXv_date2 = new java.util.Date[1] ;
      GXv_int3 = new short[1] ;
      GXv_boolean4 = new boolean[1] ;
      AV27DConDescrip = "" ;
      AV29SitDescrip = "" ;
      AV26cantidadPalabra = "" ;
      AV24filaVacia = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.escribedetallerecibo__default(),
         new Object[] {
             new Object[] {
            P00KP2_A502LiqDMostrar, P00KP2_A6LegNumero, P00KP2_A31LiqNro, P00KP2_A1EmpCod, P00KP2_A3CliCod, P00KP2_A464DTipoConCod, P00KP2_A764LiqDImpReCalcu, P00KP2_A394DConCodigo, P00KP2_A1487DConCondicion, P00KP2_A393DConDescrip,
            P00KP2_A269LiqDCanti, P00KP2_n269LiqDCanti, P00KP2_A968LiqDUniMed, P00KP2_A471DConOrden, P00KP2_A81LiqDSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV31LegClase ;
   private byte A502LiqDMostrar ;
   private short AV16EmpCod ;
   private short AV15TempRecPageSize ;
   private short AV17pageNumber ;
   private short AV22cntFilas ;
   private short AV39skip ;
   private short AV25i ;
   private short AV41i2 ;
   private short A1EmpCod ;
   private short GXv_int3[] ;
   private short AV23lineasFaltantes ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV19LiqNro ;
   private int AV20LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A471DConOrden ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal AV13Remunerativo ;
   private java.math.BigDecimal AV11NoRemunerativo ;
   private java.math.BigDecimal AV12Descuento ;
   private String AV30TLiqCod ;
   private String scmdbuf ;
   private String A464DTipoConCod ;
   private String A394DConCodigo ;
   private String A1487DConCondicion ;
   private String A968LiqDUniMed ;
   private String AV26cantidadPalabra ;
   private java.util.Date AV32LiqPeriodo ;
   private java.util.Date AV33iniPeriodo ;
   private java.util.Date GXv_date1[] ;
   private java.util.Date AV34finPeriodo ;
   private java.util.Date GXv_date2[] ;
   private boolean n269LiqDCanti ;
   private boolean AV28masDeUnaHay ;
   private boolean GXv_boolean4[] ;
   private String AV9filas ;
   private String AV8TempRecHTMLRow ;
   private String A393DConDescrip ;
   private String AV10fila ;
   private String AV27DConDescrip ;
   private String AV29SitDescrip ;
   private String AV24filaVacia ;
   private short[] aP11 ;
   private String[] aP7 ;
   private byte[] aP8 ;
   private java.util.Date[] aP9 ;
   private String[] aP10 ;
   private IDataStoreProvider pr_default ;
   private byte[] P00KP2_A502LiqDMostrar ;
   private int[] P00KP2_A6LegNumero ;
   private int[] P00KP2_A31LiqNro ;
   private short[] P00KP2_A1EmpCod ;
   private int[] P00KP2_A3CliCod ;
   private String[] P00KP2_A464DTipoConCod ;
   private java.math.BigDecimal[] P00KP2_A764LiqDImpReCalcu ;
   private String[] P00KP2_A394DConCodigo ;
   private String[] P00KP2_A1487DConCondicion ;
   private String[] P00KP2_A393DConDescrip ;
   private java.math.BigDecimal[] P00KP2_A269LiqDCanti ;
   private boolean[] P00KP2_n269LiqDCanti ;
   private String[] P00KP2_A968LiqDUniMed ;
   private int[] P00KP2_A471DConOrden ;
   private int[] P00KP2_A81LiqDSecuencial ;
}

final  class escribedetallerecibo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00KP2", "SELECT LiqDMostrar, LegNumero, LiqNro, EmpCod, CliCod, DTipoConCod, LiqDImpReCalcu, DConCodigo, DConCondicion, DConDescrip, LiqDCanti, LiqDUniMed, DConOrden, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and LiqDMostrar = 3 ORDER BY CliCod, EmpCod, LiqNro, LegNumero, LiqDMostrar, DConOrden ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((String[]) buf[7])[0] = rslt.getString(8, 10);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getString(12, 20);
               ((int[]) buf[13])[0] = rslt.getInt(13);
               ((int[]) buf[14])[0] = rslt.getInt(14);
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
               return;
      }
   }

}

