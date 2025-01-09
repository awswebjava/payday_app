package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class descuentosobteneralicuotas extends GXProcedure
{
   public descuentosobteneralicuotas( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( descuentosobteneralicuotas.class ), "" );
   }

   public descuentosobteneralicuotas( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             boolean aP4 ,
                             String aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             byte[] aP8 )
   {
      descuentosobteneralicuotas.this.aP9 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        boolean aP4 ,
                        String aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        byte[] aP8 ,
                        String[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             boolean aP4 ,
                             String aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             byte[] aP8 ,
                             String[] aP9 )
   {
      descuentosobteneralicuotas.this.AV12CliCod = aP0;
      descuentosobteneralicuotas.this.AV13EmpCod = aP1;
      descuentosobteneralicuotas.this.AV14LegNumero = aP2;
      descuentosobteneralicuotas.this.AV23LiqNro = aP3;
      descuentosobteneralicuotas.this.AV15finalEs = aP4;
      descuentosobteneralicuotas.this.AV17parametroPalabra = aP5;
      descuentosobteneralicuotas.this.aP6 = aP6;
      descuentosobteneralicuotas.this.aP7 = aP7;
      descuentosobteneralicuotas.this.aP8 = aP8;
      descuentosobteneralicuotas.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10LiqDCalculado = (byte)(1) ;
      AV8DLiqPerAno = (short)(GXutil.year( AV11LiqPeriodo)) ;
      if ( false )
      {
         new web.pendientescrearindices(remoteHandle, context).execute( ) ;
      }
      AV29GXLvl8 = (byte)(0) ;
      /* Using cursor P00YR2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV13EmpCod), Integer.valueOf(AV14LegNumero), Integer.valueOf(AV23LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00YR2_A3CliCod[0] ;
         A1EmpCod = P00YR2_A1EmpCod[0] ;
         A6LegNumero = P00YR2_A6LegNumero[0] ;
         A31LiqNro = P00YR2_A31LiqNro[0] ;
         A464DTipoConCod = P00YR2_A464DTipoConCod[0] ;
         A468DSubTipoConCod1 = P00YR2_A468DSubTipoConCod1[0] ;
         n468DSubTipoConCod1 = P00YR2_n468DSubTipoConCod1[0] ;
         A394DConCodigo = P00YR2_A394DConCodigo[0] ;
         A763LiqDRecalculado = P00YR2_A763LiqDRecalculado[0] ;
         A764LiqDImpReCalcu = P00YR2_A764LiqDImpReCalcu[0] ;
         A277LiqDValUni = P00YR2_A277LiqDValUni[0] ;
         n277LiqDValUni = P00YR2_n277LiqDValUni[0] ;
         A393DConDescrip = P00YR2_A393DConDescrip[0] ;
         A507LiqDCalculado = P00YR2_A507LiqDCalculado[0] ;
         A81LiqDSecuencial = P00YR2_A81LiqDSecuencial[0] ;
         AV29GXLvl8 = (byte)(1) ;
         GXv_boolean1[0] = AV16SubTDescuLey ;
         new web.gettipodescuentoley(remoteHandle, context).execute( A464DTipoConCod, A468DSubTipoConCod1, GXv_boolean1) ;
         descuentosobteneralicuotas.this.AV16SubTDescuLey = GXv_boolean1[0] ;
         if ( AV16SubTDescuLey )
         {
            new web.dependenciasesion(remoteHandle, context).execute( A394DConCodigo) ;
            GXv_int2[0] = AV25auxLiqDCalculado ;
            new web.dependenciaresuelta2(remoteHandle, context).execute( AV12CliCod, A394DConCodigo, AV24ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int2) ;
            descuentosobteneralicuotas.this.AV25auxLiqDCalculado = GXv_int2[0] ;
            if ( AV25auxLiqDCalculado == 0 )
            {
               AV10LiqDCalculado = (byte)(0) ;
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV18AuxLiqDImpCalcu = A764LiqDImpReCalcu ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&AuxLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV18AuxLiqDImpCalcu, 14, 2))) ;
            if ( ( AV18AuxLiqDImpCalcu.doubleValue() > 0 ) && ( DecimalUtil.compareTo(A277LiqDValUni, AV18AuxLiqDImpCalcu) != 0 ) )
            {
               AV19descuentosDeLeyLiqDImpCalcu = AV19descuentosDeLeyLiqDImpCalcu.add(AV18AuxLiqDImpCalcu) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "final ", "")+GXutil.trim( GXutil.booltostr( AV15finalEs))) ;
               if ( ! AV15finalEs )
               {
                  if ( A277LiqDValUni.doubleValue() > 0 )
                  {
                     AV20alicuota = AV18AuxLiqDImpCalcu.divide(A277LiqDValUni, 18, java.math.RoundingMode.DOWN) ;
                  }
                  else
                  {
                     AV20alicuota = DecimalUtil.ZERO ;
                  }
                  new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&alicuota ", "")+GXutil.trim( GXutil.str( AV20alicuota, 6, 4))+httpContext.getMessage( " LiqDValUni ", "")+GXutil.trim( GXutil.str( A277LiqDValUni, 14, 2))) ;
                  AV21descuentos = AV21descuentos.add(AV20alicuota) ;
                  if ( ! (GXutil.strcmp("", AV26LiqDLog)==0) )
                  {
                     AV26LiqDLog += ", " ;
                  }
                  AV26LiqDLog += GXutil.trim( GXutil.str( AV20alicuota, 6, 4)) + httpContext.getMessage( " de ", "") + GXutil.trim( A393DConDescrip) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&&descuentos ", "")+GXutil.trim( GXutil.str( AV21descuentos, 14, 2))) ;
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&alicuota ", "")+GXutil.trim( GXutil.str( AV20alicuota, 6, 4))+httpContext.getMessage( " &descuentos ", "")+GXutil.trim( GXutil.str( AV21descuentos, 14, 2))) ;
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV29GXLvl8 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "none", "")) ;
         if ( AV22insertandoConceptos )
         {
            AV10LiqDCalculado = (byte)(0) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = descuentosobteneralicuotas.this.AV19descuentosDeLeyLiqDImpCalcu;
      this.aP7[0] = descuentosobteneralicuotas.this.AV21descuentos;
      this.aP8[0] = descuentosobteneralicuotas.this.AV10LiqDCalculado;
      this.aP9[0] = descuentosobteneralicuotas.this.AV26LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19descuentosDeLeyLiqDImpCalcu = DecimalUtil.ZERO ;
      AV21descuentos = DecimalUtil.ZERO ;
      AV26LiqDLog = "" ;
      AV11LiqPeriodo = GXutil.nullDate() ;
      scmdbuf = "" ;
      P00YR2_A3CliCod = new int[1] ;
      P00YR2_A1EmpCod = new short[1] ;
      P00YR2_A6LegNumero = new int[1] ;
      P00YR2_A31LiqNro = new int[1] ;
      P00YR2_A464DTipoConCod = new String[] {""} ;
      P00YR2_A468DSubTipoConCod1 = new String[] {""} ;
      P00YR2_n468DSubTipoConCod1 = new boolean[] {false} ;
      P00YR2_A394DConCodigo = new String[] {""} ;
      P00YR2_A763LiqDRecalculado = new short[1] ;
      P00YR2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00YR2_A277LiqDValUni = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00YR2_n277LiqDValUni = new boolean[] {false} ;
      P00YR2_A393DConDescrip = new String[] {""} ;
      P00YR2_A507LiqDCalculado = new byte[1] ;
      P00YR2_A81LiqDSecuencial = new int[1] ;
      A464DTipoConCod = "" ;
      A468DSubTipoConCod1 = "" ;
      A394DConCodigo = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A277LiqDValUni = DecimalUtil.ZERO ;
      A393DConDescrip = "" ;
      GXv_boolean1 = new boolean[1] ;
      AV24ProcesoLiquidacion = "" ;
      GXv_int2 = new byte[1] ;
      AV18AuxLiqDImpCalcu = DecimalUtil.ZERO ;
      AV30Pgmname = "" ;
      AV20alicuota = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.descuentosobteneralicuotas__default(),
         new Object[] {
             new Object[] {
            P00YR2_A3CliCod, P00YR2_A1EmpCod, P00YR2_A6LegNumero, P00YR2_A31LiqNro, P00YR2_A464DTipoConCod, P00YR2_A468DSubTipoConCod1, P00YR2_n468DSubTipoConCod1, P00YR2_A394DConCodigo, P00YR2_A763LiqDRecalculado, P00YR2_A764LiqDImpReCalcu,
            P00YR2_A277LiqDValUni, P00YR2_n277LiqDValUni, P00YR2_A393DConDescrip, P00YR2_A507LiqDCalculado, P00YR2_A81LiqDSecuencial
            }
         }
      );
      AV30Pgmname = "DescuentosObtenerAlicuotas" ;
      /* GeneXus formulas. */
      AV30Pgmname = "DescuentosObtenerAlicuotas" ;
      Gx_err = (short)(0) ;
   }

   private byte AV10LiqDCalculado ;
   private byte AV29GXLvl8 ;
   private byte A507LiqDCalculado ;
   private byte AV25auxLiqDCalculado ;
   private byte GXv_int2[] ;
   private short AV13EmpCod ;
   private short AV8DLiqPerAno ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV14LegNumero ;
   private int AV23LiqNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV19descuentosDeLeyLiqDImpCalcu ;
   private java.math.BigDecimal AV21descuentos ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal A277LiqDValUni ;
   private java.math.BigDecimal AV18AuxLiqDImpCalcu ;
   private java.math.BigDecimal AV20alicuota ;
   private String AV17parametroPalabra ;
   private String scmdbuf ;
   private String A464DTipoConCod ;
   private String A468DSubTipoConCod1 ;
   private String A394DConCodigo ;
   private String AV24ProcesoLiquidacion ;
   private String AV30Pgmname ;
   private java.util.Date AV11LiqPeriodo ;
   private boolean AV15finalEs ;
   private boolean n468DSubTipoConCod1 ;
   private boolean n277LiqDValUni ;
   private boolean AV16SubTDescuLey ;
   private boolean GXv_boolean1[] ;
   private boolean returnInSub ;
   private boolean AV22insertandoConceptos ;
   private String AV26LiqDLog ;
   private String A393DConDescrip ;
   private String[] aP9 ;
   private java.math.BigDecimal[] aP6 ;
   private java.math.BigDecimal[] aP7 ;
   private byte[] aP8 ;
   private IDataStoreProvider pr_default ;
   private int[] P00YR2_A3CliCod ;
   private short[] P00YR2_A1EmpCod ;
   private int[] P00YR2_A6LegNumero ;
   private int[] P00YR2_A31LiqNro ;
   private String[] P00YR2_A464DTipoConCod ;
   private String[] P00YR2_A468DSubTipoConCod1 ;
   private boolean[] P00YR2_n468DSubTipoConCod1 ;
   private String[] P00YR2_A394DConCodigo ;
   private short[] P00YR2_A763LiqDRecalculado ;
   private java.math.BigDecimal[] P00YR2_A764LiqDImpReCalcu ;
   private java.math.BigDecimal[] P00YR2_A277LiqDValUni ;
   private boolean[] P00YR2_n277LiqDValUni ;
   private String[] P00YR2_A393DConDescrip ;
   private byte[] P00YR2_A507LiqDCalculado ;
   private int[] P00YR2_A81LiqDSecuencial ;
}

final  class descuentosobteneralicuotas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00YR2", "SELECT CliCod, EmpCod, LegNumero, LiqNro, DTipoConCod, DSubTipoConCod1, DConCodigo, LiqDRecalculado, LiqDImpReCalcu, LiqDValUni, DConDescrip, LiqDCalculado, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and DTipoConCod = ( 'DES_ARG')) AND (LiqNro = ?) ORDER BY CliCod, EmpCod, LegNumero, DTipoConCod, LiqDCalculado ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getString(7, 10);
               ((short[]) buf[8])[0] = rslt.getShort(8);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getVarchar(11);
               ((byte[]) buf[13])[0] = rslt.getByte(12);
               ((int[]) buf[14])[0] = rslt.getInt(13);
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

