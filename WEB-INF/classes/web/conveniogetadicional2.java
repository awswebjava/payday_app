package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conveniogetadicional2 extends GXProcedure
{
   public conveniogetadicional2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conveniogetadicional2.class ), "" );
   }

   public conveniogetadicional2( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             java.math.BigDecimal[] aP9 )
   {
      conveniogetadicional2.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        String[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             String[] aP10 )
   {
      conveniogetadicional2.this.AV12CliCod = aP0;
      conveniogetadicional2.this.AV19EmpCod = aP1;
      conveniogetadicional2.this.AV22LiqNro = aP2;
      conveniogetadicional2.this.AV13LegNumero = aP3;
      conveniogetadicional2.this.AV15LiqPeriodo = aP4;
      conveniogetadicional2.this.AV27ConCodigo = aP5;
      conveniogetadicional2.this.AV10primeraPalabra = aP6;
      conveniogetadicional2.this.AV14segundaPalabra = aP7;
      conveniogetadicional2.this.AV26ProcesoLiquidacion = aP8;
      conveniogetadicional2.this.aP9 = aP9;
      conveniogetadicional2.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV9ConveCodigo ;
      GXv_char2[0] = GXt_char1 ;
      new web.empleadogetconvenio(remoteHandle, context).execute( AV12CliCod, AV19EmpCod, AV13LegNumero, GXv_char2) ;
      conveniogetadicional2.this.GXt_char1 = GXv_char2[0] ;
      AV9ConveCodigo = GXt_char1 ;
      GXt_int3 = AV8PaiCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getpaicod(remoteHandle, context).execute( AV12CliCod, GXv_int4) ;
      conveniogetadicional2.this.GXt_int3 = GXv_int4[0] ;
      AV8PaiCod = GXt_int3 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "!&primeraPalabra \"", "")+AV10primeraPalabra+httpContext.getMessage( "\" &concodigo ", "")+GXutil.trim( AV27ConCodigo)) ;
      if ( ! (GXutil.strcmp("", AV9ConveCodigo)==0) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "&ConveCodigo", "")+GXutil.trim( AV9ConveCodigo)+httpContext.getMessage( " &primeraPalabra ", "")+GXutil.trim( AV10primeraPalabra)+httpContext.getMessage( " paicod ", "")+GXutil.trim( GXutil.str( AV8PaiCod, 4, 0))) ;
         GXv_int5[0] = AV28CliConveVer ;
         new web.getversiondelegajo(remoteHandle, context).execute( AV12CliCod, AV19EmpCod, AV13LegNumero, GXv_int5) ;
         conveniogetadicional2.this.AV28CliConveVer = GXv_int5[0] ;
         GXv_char2[0] = AV29TLiqCod ;
         new web.gettipoliq(remoteHandle, context).execute( AV12CliCod, AV19EmpCod, AV22LiqNro, GXv_char2) ;
         conveniogetadicional2.this.AV29TLiqCod = GXv_char2[0] ;
         GXv_int6[0] = AV30LegClase ;
         new web.getlegajoclase(remoteHandle, context).execute( AV12CliCod, AV19EmpCod, AV13LegNumero, GXv_int6) ;
         conveniogetadicional2.this.AV30LegClase = GXv_int6[0] ;
         GXv_date7[0] = AV31primerDiaPeriodo ;
         GXv_date8[0] = AV32ultimoDiaPeriodo ;
         new web.getrangoperiodos(remoteHandle, context).execute( AV12CliCod, AV19EmpCod, AV22LiqNro, AV13LegNumero, AV29TLiqCod, AV30LegClase, AV15LiqPeriodo, false, GXv_date7, GXv_date8) ;
         conveniogetadicional2.this.AV31primerDiaPeriodo = GXv_date7[0] ;
         conveniogetadicional2.this.AV32ultimoDiaPeriodo = GXv_date8[0] ;
         GXv_boolean9[0] = AV34seCancela ;
         GXv_char2[0] = AV33auxLiqDLog ;
         new web.getestadocancelaadicional(remoteHandle, context).execute( AV12CliCod, AV28CliConveVer, AV19EmpCod, AV13LegNumero, AV8PaiCod, AV9ConveCodigo, AV10primeraPalabra, AV31primerDiaPeriodo, AV32ultimoDiaPeriodo, GXv_boolean9, GXv_char2) ;
         conveniogetadicional2.this.AV34seCancela = GXv_boolean9[0] ;
         conveniogetadicional2.this.AV33auxLiqDLog = GXv_char2[0] ;
         if ( AV34seCancela )
         {
            AV35LiqDLog = AV33auxLiqDLog ;
         }
         else
         {
            AV39GXLvl22 = (byte)(0) ;
            /* Using cursor P01342 */
            pr_default.execute(0, new Object[] {Integer.valueOf(AV28CliConveVer), Short.valueOf(AV8PaiCod), AV9ConveCodigo, AV10primeraPalabra});
            while ( (pr_default.getStatus(0) != 101) )
            {
               A996ConveAdicod = P01342_A996ConveAdicod[0] ;
               A1565CliConvenio = P01342_A1565CliConvenio[0] ;
               A1564CliPaiConve = P01342_A1564CliPaiConve[0] ;
               A3CliCod = P01342_A3CliCod[0] ;
               A998ConveAdiAli = P01342_A998ConveAdiAli[0] ;
               AV39GXLvl22 = (byte)(1) ;
               AV11valor = A998ConveAdiAli ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "&valor ", "")+GXutil.trim( GXutil.str( AV11valor, 18, 4))+httpContext.getMessage( " ConveAdicod \"", "")+A996ConveAdicod+"\"") ;
               pr_default.readNext(0);
            }
            pr_default.close(0);
            if ( AV39GXLvl22 == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "none", "")) ;
            }
            if ( false )
            {
               new web.pendientesdeoptimizarcasesensitive(remoteHandle, context).execute( ) ;
            }
            if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV11valor)==0) )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "&segundaPalabra ", "")+GXutil.trim( AV14segundaPalabra)) ;
               if ( (GXutil.strcmp("", AV14segundaPalabra)==0) )
               {
                  /* Using cursor P01343 */
                  pr_default.execute(1, new Object[] {Integer.valueOf(AV28CliConveVer), Short.valueOf(AV8PaiCod), AV9ConveCodigo, AV10primeraPalabra, AV15LiqPeriodo});
                  while ( (pr_default.getStatus(1) != 101) )
                  {
                     A3CliCod = P01343_A3CliCod[0] ;
                     A1564CliPaiConve = P01343_A1564CliPaiConve[0] ;
                     A1565CliConvenio = P01343_A1565CliConvenio[0] ;
                     A999ConveAdiVig = P01343_A999ConveAdiVig[0] ;
                     A996ConveAdicod = P01343_A996ConveAdicod[0] ;
                     A1000ConveAdiImporte = P01343_A1000ConveAdiImporte[0] ;
                     AV11valor = A1000ConveAdiImporte ;
                     AV24importeEs = true ;
                     /* Exit For each command. Update data (if necessary), close cursors & exit. */
                     if (true) break;
                     pr_default.readNext(1);
                  }
                  pr_default.close(1);
               }
               else
               {
                  AV23ConveAdiOpcFor = GXutil.trim( AV14segundaPalabra) ;
                  /* Using cursor P01344 */
                  pr_default.execute(2, new Object[] {Integer.valueOf(AV28CliConveVer), Short.valueOf(AV8PaiCod), AV9ConveCodigo, AV10primeraPalabra, AV23ConveAdiOpcFor});
                  while ( (pr_default.getStatus(2) != 101) )
                  {
                     A1021ConveAdiOpcFor = P01344_A1021ConveAdiOpcFor[0] ;
                     A996ConveAdicod = P01344_A996ConveAdicod[0] ;
                     A1565CliConvenio = P01344_A1565CliConvenio[0] ;
                     A1564CliPaiConve = P01344_A1564CliPaiConve[0] ;
                     A3CliCod = P01344_A3CliCod[0] ;
                     A1013ConveAdiOpcAli = P01344_A1013ConveAdiOpcAli[0] ;
                     A1011ConveAdiOpcCod = P01344_A1011ConveAdiOpcCod[0] ;
                     AV11valor = A1013ConveAdiOpcAli ;
                     /* Exit For each command. Update data (if necessary), close cursors & exit. */
                     if (true) break;
                     pr_default.readNext(2);
                  }
                  pr_default.close(2);
               }
            }
            if ( ( AV24importeEs ) && ( AV11valor.doubleValue() > 0 ) )
            {
               AV25originalValor = AV11valor ;
               GXv_decimal10[0] = AV11valor ;
               GXv_decimal11[0] = DecimalUtil.doubleToDec(0) ;
               GXv_decimal12[0] = DecimalUtil.doubleToDec(0) ;
               new web.reducirporparcial(remoteHandle, context).execute( AV12CliCod, AV19EmpCod, AV13LegNumero, AV15LiqPeriodo, AV25originalValor, GXv_decimal10, GXv_decimal11, GXv_decimal12) ;
               conveniogetadicional2.this.AV11valor = GXv_decimal10[0] ;
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = conveniogetadicional2.this.AV11valor;
      this.aP10[0] = conveniogetadicional2.this.AV35LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11valor = DecimalUtil.ZERO ;
      AV35LiqDLog = "" ;
      AV9ConveCodigo = "" ;
      GXt_char1 = "" ;
      GXv_int4 = new short[1] ;
      AV38Pgmname = "" ;
      GXv_int5 = new int[1] ;
      AV29TLiqCod = "" ;
      GXv_int6 = new byte[1] ;
      AV31primerDiaPeriodo = GXutil.nullDate() ;
      GXv_date7 = new java.util.Date[1] ;
      AV32ultimoDiaPeriodo = GXutil.nullDate() ;
      GXv_date8 = new java.util.Date[1] ;
      GXv_boolean9 = new boolean[1] ;
      AV33auxLiqDLog = "" ;
      GXv_char2 = new String[1] ;
      scmdbuf = "" ;
      P01342_A996ConveAdicod = new String[] {""} ;
      P01342_A1565CliConvenio = new String[] {""} ;
      P01342_A1564CliPaiConve = new short[1] ;
      P01342_A3CliCod = new int[1] ;
      P01342_A998ConveAdiAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A996ConveAdicod = "" ;
      A1565CliConvenio = "" ;
      A998ConveAdiAli = DecimalUtil.ZERO ;
      P01343_A3CliCod = new int[1] ;
      P01343_A1564CliPaiConve = new short[1] ;
      P01343_A1565CliConvenio = new String[] {""} ;
      P01343_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01343_A996ConveAdicod = new String[] {""} ;
      P01343_A1000ConveAdiImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A999ConveAdiVig = GXutil.nullDate() ;
      A1000ConveAdiImporte = DecimalUtil.ZERO ;
      AV23ConveAdiOpcFor = "" ;
      P01344_A1021ConveAdiOpcFor = new String[] {""} ;
      P01344_A996ConveAdicod = new String[] {""} ;
      P01344_A1565CliConvenio = new String[] {""} ;
      P01344_A1564CliPaiConve = new short[1] ;
      P01344_A3CliCod = new int[1] ;
      P01344_A1013ConveAdiOpcAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01344_A1011ConveAdiOpcCod = new short[1] ;
      A1021ConveAdiOpcFor = "" ;
      A1013ConveAdiOpcAli = DecimalUtil.ZERO ;
      AV25originalValor = DecimalUtil.ZERO ;
      GXv_decimal10 = new java.math.BigDecimal[1] ;
      GXv_decimal11 = new java.math.BigDecimal[1] ;
      GXv_decimal12 = new java.math.BigDecimal[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conveniogetadicional2__default(),
         new Object[] {
             new Object[] {
            P01342_A996ConveAdicod, P01342_A1565CliConvenio, P01342_A1564CliPaiConve, P01342_A3CliCod, P01342_A998ConveAdiAli
            }
            , new Object[] {
            P01343_A3CliCod, P01343_A1564CliPaiConve, P01343_A1565CliConvenio, P01343_A999ConveAdiVig, P01343_A996ConveAdicod, P01343_A1000ConveAdiImporte
            }
            , new Object[] {
            P01344_A1021ConveAdiOpcFor, P01344_A996ConveAdicod, P01344_A1565CliConvenio, P01344_A1564CliPaiConve, P01344_A3CliCod, P01344_A1013ConveAdiOpcAli, P01344_A1011ConveAdiOpcCod
            }
         }
      );
      AV38Pgmname = "ConvenioGetAdicional2" ;
      /* GeneXus formulas. */
      AV38Pgmname = "ConvenioGetAdicional2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV30LegClase ;
   private byte GXv_int6[] ;
   private byte AV39GXLvl22 ;
   private short AV19EmpCod ;
   private short AV8PaiCod ;
   private short GXt_int3 ;
   private short GXv_int4[] ;
   private short A1564CliPaiConve ;
   private short A1011ConveAdiOpcCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV22LiqNro ;
   private int AV13LegNumero ;
   private int AV28CliConveVer ;
   private int GXv_int5[] ;
   private int A3CliCod ;
   private java.math.BigDecimal AV11valor ;
   private java.math.BigDecimal A998ConveAdiAli ;
   private java.math.BigDecimal A1000ConveAdiImporte ;
   private java.math.BigDecimal A1013ConveAdiOpcAli ;
   private java.math.BigDecimal AV25originalValor ;
   private java.math.BigDecimal GXv_decimal10[] ;
   private java.math.BigDecimal GXv_decimal11[] ;
   private java.math.BigDecimal GXv_decimal12[] ;
   private String AV27ConCodigo ;
   private String AV10primeraPalabra ;
   private String AV14segundaPalabra ;
   private String AV26ProcesoLiquidacion ;
   private String AV9ConveCodigo ;
   private String GXt_char1 ;
   private String AV38Pgmname ;
   private String AV29TLiqCod ;
   private String GXv_char2[] ;
   private String scmdbuf ;
   private String A996ConveAdicod ;
   private String A1565CliConvenio ;
   private String AV23ConveAdiOpcFor ;
   private String A1021ConveAdiOpcFor ;
   private java.util.Date AV15LiqPeriodo ;
   private java.util.Date AV31primerDiaPeriodo ;
   private java.util.Date GXv_date7[] ;
   private java.util.Date AV32ultimoDiaPeriodo ;
   private java.util.Date GXv_date8[] ;
   private java.util.Date A999ConveAdiVig ;
   private boolean AV34seCancela ;
   private boolean GXv_boolean9[] ;
   private boolean AV24importeEs ;
   private String AV35LiqDLog ;
   private String AV33auxLiqDLog ;
   private String[] aP10 ;
   private java.math.BigDecimal[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P01342_A996ConveAdicod ;
   private String[] P01342_A1565CliConvenio ;
   private short[] P01342_A1564CliPaiConve ;
   private int[] P01342_A3CliCod ;
   private java.math.BigDecimal[] P01342_A998ConveAdiAli ;
   private int[] P01343_A3CliCod ;
   private short[] P01343_A1564CliPaiConve ;
   private String[] P01343_A1565CliConvenio ;
   private java.util.Date[] P01343_A999ConveAdiVig ;
   private String[] P01343_A996ConveAdicod ;
   private java.math.BigDecimal[] P01343_A1000ConveAdiImporte ;
   private String[] P01344_A1021ConveAdiOpcFor ;
   private String[] P01344_A996ConveAdicod ;
   private String[] P01344_A1565CliConvenio ;
   private short[] P01344_A1564CliPaiConve ;
   private int[] P01344_A3CliCod ;
   private java.math.BigDecimal[] P01344_A1013ConveAdiOpcAli ;
   private short[] P01344_A1011ConveAdiOpcCod ;
}

final  class conveniogetadicional2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01342", "SELECT ConveAdicod, CliConvenio, CliPaiConve, CliCod, ConveAdiAli FROM convenio_adicional WHERE (CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?)) AND (UPPER(RTRIM(LTRIM(ConveAdicod))) = ( UPPER(RTRIM(LTRIM(?))))) ORDER BY CliCod, CliPaiConve, CliConvenio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01343", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdiVig, ConveAdicod, ConveAdiImporte FROM convenio_adicionalimportes WHERE (CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?)) AND (UPPER(RTRIM(LTRIM(ConveAdicod))) = ( UPPER(RTRIM(LTRIM(?))))) AND (ConveAdiVig <= ?) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiVig DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01344", "SELECT ConveAdiOpcFor, ConveAdicod, CliConvenio, CliPaiConve, CliCod, ConveAdiOpcAli, ConveAdiOpcCod FROM convenio_adicionalalicuotas WHERE (CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?)) AND (UPPER(RTRIM(LTRIM(ConveAdicod))) = ( UPPER(RTRIM(LTRIM(?))))) AND (UPPER(RTRIM(LTRIM(ConveAdiOpcFor))) = ( UPPER(RTRIM(LTRIM(?))))) ORDER BY CliCod, CliPaiConve, CliConvenio  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((short[]) buf[6])[0] = rslt.getShort(7);
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
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               return;
      }
   }

}

