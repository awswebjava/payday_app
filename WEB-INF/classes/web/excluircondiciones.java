package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class excluircondiciones extends GXProcedure
{
   public excluircondiciones( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( excluircondiciones.class ), "" );
   }

   public excluircondiciones( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<String> executeUdp( int aP0 ,
                                                 short aP1 ,
                                                 int aP2 ,
                                                 int aP3 ,
                                                 java.util.Date aP4 ,
                                                 boolean aP5 ,
                                                 boolean aP6 ,
                                                 boolean aP7 ,
                                                 GXSimpleCollection<String>[] aP8 )
   {
      excluircondiciones.this.aP9 = new GXSimpleCollection[] {new GXSimpleCollection<String>(String.class, "internal", "")};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        boolean aP5 ,
                        boolean aP6 ,
                        boolean aP7 ,
                        GXSimpleCollection<String>[] aP8 ,
                        GXSimpleCollection<String>[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             boolean aP5 ,
                             boolean aP6 ,
                             boolean aP7 ,
                             GXSimpleCollection<String>[] aP8 ,
                             GXSimpleCollection<String>[] aP9 )
   {
      excluircondiciones.this.AV13CliCod = aP0;
      excluircondiciones.this.AV14EmpCod = aP1;
      excluircondiciones.this.AV27LiqNro = aP2;
      excluircondiciones.this.AV15LegNumero = aP3;
      excluircondiciones.this.AV20LiqPeriodo = aP4;
      excluircondiciones.this.AV9liquidacionSimple = aP5;
      excluircondiciones.this.AV10resolver = aP6;
      excluircondiciones.this.AV11chequearExistencia = aP7;
      excluircondiciones.this.aP8 = aP8;
      excluircondiciones.this.AV62excluConCodigo = aP9[0];
      this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "liqnro ", "")+GXutil.trim( GXutil.str( AV27LiqNro, 8, 0))) ;
      GXv_char1[0] = AV16ConveCodigo ;
      GXv_boolean2[0] = AV12LegAgenReten ;
      GXv_int3[0] = AV17LegClase ;
      GXv_char4[0] = AV118LegModTra ;
      GXv_char5[0] = AV92LegTitulo ;
      GXv_char6[0] = AV97LegCatCodigo ;
      GXv_char7[0] = AV119tipo_tarifa ;
      new web.getdatoslegparaliq(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV27LiqNro, AV15LegNumero, GXv_char1, GXv_boolean2, GXv_int3, GXv_char4, GXv_char5, GXv_char6, GXv_char7) ;
      excluircondiciones.this.AV16ConveCodigo = GXv_char1[0] ;
      excluircondiciones.this.AV12LegAgenReten = GXv_boolean2[0] ;
      excluircondiciones.this.AV17LegClase = GXv_int3[0] ;
      excluircondiciones.this.AV118LegModTra = GXv_char4[0] ;
      excluircondiciones.this.AV92LegTitulo = GXv_char5[0] ;
      excluircondiciones.this.AV97LegCatCodigo = GXv_char6[0] ;
      excluircondiciones.this.AV119tipo_tarifa = GXv_char7[0] ;
      AV9liquidacionSimple = false ;
      GXv_char7[0] = AV31TLiqCod ;
      new web.gettipoliq(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV27LiqNro, GXv_char7) ;
      excluircondiciones.this.AV31TLiqCod = GXv_char7[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "&liquidacionSimple ", "")+GXutil.trim( GXutil.booltostr( AV9liquidacionSimple))+httpContext.getMessage( " &CliCod ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV14EmpCod, 4, 0))+httpContext.getMessage( " liqnro ", "")+GXutil.trim( GXutil.str( AV27LiqNro, 8, 0))+httpContext.getMessage( " &TLiqCod ", "")+GXutil.trim( AV31TLiqCod)) ;
      if ( ! AV9liquidacionSimple )
      {
         if ( (GXutil.strcmp("", AV16ConveCodigo)==0) )
         {
            AV18exluirConCondicion.add("B24", 0);
         }
         else
         {
            GXt_char8 = AV68parmValue ;
            GXt_char9 = AV68parmValue ;
            GXv_char7[0] = GXt_char9 ;
            new web.desglosaradicional_codigoparam(remoteHandle, context).execute( GXv_char7) ;
            excluircondiciones.this.GXt_char9 = GXv_char7[0] ;
            GXv_char6[0] = GXt_char8 ;
            new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char9, GXv_char6) ;
            excluircondiciones.this.GXt_char8 = GXv_char6[0] ;
            AV68parmValue = GXt_char8 ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "parmvalue ", "")+GXutil.trim( AV68parmValue)) ;
            AV100desglozar = GXutil.boolval( AV68parmValue) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "&desglozar ", "")+GXutil.trim( GXutil.booltostr( AV100desglozar))) ;
            if ( ! AV100desglozar )
            {
               AV18exluirConCondicion.add("B24", 0);
            }
            else
            {
               GXt_int10 = AV82PaiCod ;
               GXv_int11[0] = GXt_int10 ;
               new web.clientegetpais(remoteHandle, context).execute( AV13CliCod, GXv_int11) ;
               excluircondiciones.this.GXt_int10 = GXv_int11[0] ;
               AV82PaiCod = GXt_int10 ;
               GXv_int12[0] = AV96CliConveVer ;
               new web.getversiondelegajo(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LegNumero, GXv_int12) ;
               excluircondiciones.this.AV96CliConveVer = GXv_int12[0] ;
               GXv_int11[0] = AV120CliPaiConve ;
               new web.getpaisdeconvenio(remoteHandle, context).execute( AV16ConveCodigo, AV82PaiCod, GXv_int11) ;
               excluircondiciones.this.AV120CliPaiConve = GXv_int11[0] ;
               GXv_boolean2[0] = false ;
               GXv_char7[0] = AV98error ;
               GXv_decimal13[0] = AV99CatValorHora ;
               new web.getescalasalarialvigente3(remoteHandle, context).execute( AV96CliConveVer, AV120CliPaiConve, AV16ConveCodigo, AV97LegCatCodigo, AV20LiqPeriodo, AV17LegClase, httpContext.getMessage( "ADICIONAL", ""), GXv_boolean2, GXv_char7, GXv_decimal13) ;
               excluircondiciones.this.AV98error = GXv_char7[0] ;
               excluircondiciones.this.AV99CatValorHora = GXv_decimal13[0] ;
               if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV99CatValorHora)==0) )
               {
                  AV18exluirConCondicion.add("B24", 0);
               }
            }
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV123Pgmname, httpContext.getMessage( "gros &LegClase ", "")+GXutil.trim( GXutil.str( AV17LegClase, 1, 0))) ;
         if ( ( AV17LegClase != 1 ) || ( GXutil.strcmp(AV119tipo_tarifa, "P") != 0 ) )
         {
            AV18exluirConCondicion.add("GU", 0);
            new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV123Pgmname, httpContext.getMessage( "gros exlu 3", "")) ;
         }
         else
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV123Pgmname, httpContext.getMessage( "gros &ConveCodigo ", "")+AV16ConveCodigo) ;
            if ( ! (GXutil.strcmp("", AV16ConveCodigo)==0) )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV123Pgmname, httpContext.getMessage( "gros exclu 2", "")) ;
               AV18exluirConCondicion.add("GU", 0);
            }
            else
            {
               GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
               GXv_char7[0] = AV117tipo_sueldo ;
               GXv_int11[0] = (short)(0) ;
               GXv_boolean2[0] = false ;
               new web.getlegajosueldoultimo(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, 0, AV15LegNumero, AV20LiqPeriodo, GXv_decimal13, GXv_char7, GXv_int11, GXv_boolean2) ;
               excluircondiciones.this.AV117tipo_sueldo = GXv_char7[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV123Pgmname, httpContext.getMessage( "gros &tipo_sueldo ", "")+GXutil.trim( AV117tipo_sueldo)) ;
               if ( GXutil.strcmp(AV117tipo_sueldo, "GrossingUp") != 0 )
               {
                  AV18exluirConCondicion.add("GU", 0);
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV123Pgmname, httpContext.getMessage( "gros exclu1", "")) ;
               }
            }
         }
         GXv_char7[0] = AV68parmValue ;
         new web.getparametro(remoteHandle, context).execute( AV13CliCod, new web.redondeo_codigoparam(remoteHandle, context).executeUdp( ), GXv_char7) ;
         excluircondiciones.this.AV68parmValue = GXv_char7[0] ;
         GXv_int3[0] = AV113LegFormaPago ;
         new web.getlegformapago(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LegNumero, GXv_int3) ;
         excluircondiciones.this.AV113LegFormaPago = GXv_int3[0] ;
         if ( ( GXutil.strcmp(AV68parmValue, httpContext.getMessage( "SIEMPRE", "")) != 0 ) && ( AV113LegFormaPago == 3 ) )
         {
            AV18exluirConCondicion.add("R1", 0);
         }
         if ( (GXutil.strcmp("", AV92LegTitulo)==0) )
         {
            AV18exluirConCondicion.add("B23", 0);
         }
         else
         {
            /* Using cursor P01EC2 */
            pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), AV92LegTitulo});
            while ( (pr_default.getStatus(0) != 101) )
            {
               A954ConCondCodigo = P01EC2_A954ConCondCodigo[0] ;
               A150ConHabilitado = P01EC2_A150ConHabilitado[0] ;
               A953ConCondicion = P01EC2_A953ConCondicion[0] ;
               n953ConCondicion = P01EC2_n953ConCondicion[0] ;
               A3CliCod = P01EC2_A3CliCod[0] ;
               A26ConCodigo = P01EC2_A26ConCodigo[0] ;
               AV62excluConCodigo.add(GXutil.trim( A26ConCodigo), 0);
               pr_default.readNext(0);
            }
            pr_default.close(0);
         }
         if ( ( AV17LegClase != 1 ) || ( GXutil.strcmp(AV119tipo_tarifa, "P") != 0 ) )
         {
            AV18exluirConCondicion.add("B16", 0);
         }
         else
         {
            GXv_boolean2[0] = AV43existe ;
            new web.excluirporyaliquidado(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV27LiqNro, AV15LegNumero, AV20LiqPeriodo, AV59ProcesoLiquidacion, "B16", GXv_boolean2) ;
            excluircondiciones.this.AV43existe = GXv_boolean2[0] ;
            if ( AV43existe )
            {
               AV18exluirConCondicion.add("B16", 0);
            }
         }
         AV18exluirConCondicion.add("N01", 0);
         new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "&resolver  ", "")+GXutil.trim( GXutil.booltostr( AV10resolver))) ;
         if ( AV10resolver )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "&chequearExistencia ", "")+GXutil.trim( GXutil.booltostr( AV11chequearExistencia))) ;
            if ( ! AV11chequearExistencia )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "&LegAgenReten ", "")+GXutil.trim( GXutil.booltostr( AV12LegAgenReten))) ;
               if ( ! AV12LegAgenReten )
               {
                  AV18exluirConCondicion.add("A13", 0);
                  AV18exluirConCondicion.add("A14", 0);
                  AV79excluyeGanancias = true ;
                  GXv_int3[0] = AV42liquidaSAC ;
                  GXv_char7[0] = "" ;
                  new web.liquidar_sac(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV27LiqNro, AV31TLiqCod, AV20LiqPeriodo, GXv_int3, GXv_char7) ;
                  excluircondiciones.this.AV42liquidaSAC = GXv_int3[0] ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "&TLiqCod ", "")+GXutil.trim( AV31TLiqCod)+httpContext.getMessage( " clico ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))+httpContext.getMessage( " liqperiodo ", "")+GXutil.trim( localUtil.dtoc( AV20LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " liquidasac ", "")+GXutil.trim( GXutil.str( AV42liquidaSAC, 1, 0))) ;
                  if ( AV42liquidaSAC == 0 )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "excluye sac", "")) ;
                     AV18exluirConCondicion.add("B10", 0);
                     AV18exluirConCondicion.add("B11", 0);
                  }
               }
               else
               {
                  GXv_int3[0] = AV42liquidaSAC ;
                  GXv_char7[0] = "" ;
                  new web.liquidar_sac(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV27LiqNro, AV31TLiqCod, AV20LiqPeriodo, GXv_int3, GXv_char7) ;
                  excluircondiciones.this.AV42liquidaSAC = GXv_int3[0] ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "&TLiqCod ", "")+GXutil.trim( AV31TLiqCod)+httpContext.getMessage( " clico ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))+httpContext.getMessage( " liqperiodo ", "")+GXutil.trim( localUtil.dtoc( AV20LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " liquidasac ", "")+GXutil.trim( GXutil.str( AV42liquidaSAC, 1, 0))) ;
                  if ( AV42liquidaSAC == 0 )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "excluye sac", "")) ;
                     AV18exluirConCondicion.add("B10", 0);
                  }
               }
               AV35validar = false ;
               GXv_decimal13[0] = AV57EmpAntiguedad ;
               new web.getantiguedadporempresa(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, GXv_decimal13) ;
               excluircondiciones.this.AV57EmpAntiguedad = GXv_decimal13[0] ;
               if ( AV57EmpAntiguedad.doubleValue() != 0 )
               {
                  AV35validar = true ;
               }
               else
               {
                  GXv_char7[0] = AV16ConveCodigo ;
                  new web.empleadogetconvenio(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LegNumero, GXv_char7) ;
                  excluircondiciones.this.AV16ConveCodigo = GXv_char7[0] ;
                  if ( ! (GXutil.strcmp("", AV16ConveCodigo)==0) )
                  {
                     GXv_decimal13[0] = AV125Importe ;
                     GXv_char7[0] = "" ;
                     new web.conveniogetadicional2(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV27LiqNro, AV15LegNumero, AV20LiqPeriodo, AV58ConCodigo, httpContext.getMessage( "antiguedad", ""), "", AV59ProcesoLiquidacion, GXv_decimal13, GXv_char7) ;
                     excluircondiciones.this.AV125Importe = GXv_decimal13[0] ;
                     if ( AV125Importe.doubleValue() != 0 )
                     {
                        AV35validar = true ;
                     }
                  }
               }
               if ( ! AV35validar )
               {
                  AV18exluirConCondicion.add("B12", 0);
               }
               AV35validar = false ;
               GXv_decimal13[0] = AV60EmpPresentismo ;
               new web.getpresentismoporempresa(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, GXv_decimal13) ;
               excluircondiciones.this.AV60EmpPresentismo = GXv_decimal13[0] ;
               if ( AV60EmpPresentismo.doubleValue() != 0 )
               {
                  AV35validar = true ;
               }
               else
               {
                  GXv_char7[0] = AV16ConveCodigo ;
                  new web.empleadogetconvenio(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LegNumero, GXv_char7) ;
                  excluircondiciones.this.AV16ConveCodigo = GXv_char7[0] ;
                  if ( ! (GXutil.strcmp("", AV16ConveCodigo)==0) )
                  {
                     GXv_decimal13[0] = AV125Importe ;
                     GXv_char7[0] = "" ;
                     new web.conveniogetadicional2(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV27LiqNro, AV15LegNumero, AV20LiqPeriodo, AV58ConCodigo, httpContext.getMessage( "asistencia", ""), "", AV59ProcesoLiquidacion, GXv_decimal13, GXv_char7) ;
                     excluircondiciones.this.AV125Importe = GXv_decimal13[0] ;
                     if ( AV125Importe.doubleValue() != 0 )
                     {
                        AV35validar = true ;
                     }
                  }
               }
               if ( ! AV35validar )
               {
                  AV18exluirConCondicion.add("B13", 0);
               }
            }
            AV84LiqDPlus = DecimalUtil.doubleToDec(0) ;
            AV55plusDeLicencia = DecimalUtil.doubleToDec(0) ;
            AV89validarExistencia = true ;
            AV25LegLicCntDias = (short)(0) ;
            GXv_date14[0] = AV33iniPeriodo ;
            GXv_date15[0] = AV32finPeriodo ;
            new web.getrangoperiodos(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV27LiqNro, AV15LegNumero, AV31TLiqCod, AV17LegClase, AV20LiqPeriodo, false, GXv_date14, GXv_date15) ;
            excluircondiciones.this.AV33iniPeriodo = GXv_date14[0] ;
            excluircondiciones.this.AV32finPeriodo = GXv_date15[0] ;
            GXv_char7[0] = "" ;
            GXv_int11[0] = AV25LegLicCntDias ;
            GXv_date15[0] = AV26date ;
            GXv_date14[0] = AV26date ;
            GXv_date16[0] = AV26date ;
            GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
            GXv_boolean2[0] = false ;
            GXv_char6[0] = "" ;
            new web.legajodevuelvelicencia2(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LegNumero, AV27LiqNro, AV89validarExistencia, AV33iniPeriodo, true, AV32finPeriodo, "", false, false, false, GXv_char7, GXv_int11, GXv_date15, GXv_date14, GXv_date16, GXv_decimal13, GXv_boolean2, GXv_char6) ;
            excluircondiciones.this.AV25LegLicCntDias = GXv_int11[0] ;
            excluircondiciones.this.AV26date = GXv_date15[0] ;
            excluircondiciones.this.AV26date = GXv_date14[0] ;
            excluircondiciones.this.AV26date = GXv_date16[0] ;
            AV91licenciaNoVacacionesExcluye = true ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "licencias todas &LegLicCntDias ", "")+GXutil.trim( GXutil.str( AV25LegLicCntDias, 4, 0))) ;
            GXv_int3[0] = AV81EmpTipoExp ;
            new web.getemptipoexp(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, GXv_int3) ;
            excluircondiciones.this.AV81EmpTipoExp = GXv_int3[0] ;
            if ( ( AV81EmpTipoExp == 1 ) || ( AV17LegClase != 1 ) || ( GXutil.strcmp(AV118LegModTra, "E") != 0 ) || ( GXutil.strcmp(AV119tipo_tarifa, "P") != 0 ) )
            {
               AV18exluirConCondicion.add("MI", 0);
               new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "excluye .MesIncompleto", "")) ;
            }
            else
            {
               GXv_date16[0] = AV112LegFecIngreso ;
               GXv_date15[0] = AV101LegFecEgreso ;
               new web.getfecingresoyegreso(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LegNumero, GXv_date16, GXv_date15) ;
               excluircondiciones.this.AV112LegFecIngreso = GXv_date16[0] ;
               excluircondiciones.this.AV101LegFecEgreso = GXv_date15[0] ;
               if ( ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV101LegFecEgreso)) || GXutil.dateCompare(GXutil.resetTime(AV101LegFecEgreso), GXutil.resetTime(GXutil.eomdate( AV101LegFecEgreso))) ) && ( ( GXutil.day( AV112LegFecIngreso) == 1 ) || GXutil.resetTime(AV112LegFecIngreso).before( GXutil.resetTime( AV20LiqPeriodo )) ) )
               {
                  AV18exluirConCondicion.add("MI", 0);
                  new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "excluye .MesIncompleto2", "")) ;
               }
               else
               {
                  GXv_boolean2[0] = AV43existe ;
                  new web.excluirporyaliquidado(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV27LiqNro, AV15LegNumero, AV20LiqPeriodo, AV59ProcesoLiquidacion, "MI", GXv_boolean2) ;
                  excluircondiciones.this.AV43existe = GXv_boolean2[0] ;
                  if ( AV43existe )
                  {
                     AV18exluirConCondicion.add("MI", 0);
                     new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "excluye .MesIncompleto3", "")) ;
                  }
               }
            }
            if ( (0==AV25LegLicCntDias) )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "excluye .licencia 1", "")) ;
               AV18exluirConCondicion.add("B1", 0);
               AV18exluirConCondicion.add("B19", 0);
               AV18exluirConCondicion.add("B20", 0);
            }
            else
            {
               AV85buscaConPlus = false ;
               AV86cnt = (short)(0) ;
               AV87cnt2 = (short)(0) ;
               AV126GXLvl243 = (byte)(0) ;
               /* Using cursor P01EC3 */
               pr_default.execute(1, new Object[] {Integer.valueOf(AV13CliCod)});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A150ConHabilitado = P01EC3_A150ConHabilitado[0] ;
                  A953ConCondicion = P01EC3_A953ConCondicion[0] ;
                  n953ConCondicion = P01EC3_n953ConCondicion[0] ;
                  A3CliCod = P01EC3_A3CliCod[0] ;
                  A954ConCondCodigo = P01EC3_A954ConCondCodigo[0] ;
                  A41ConDescrip = P01EC3_A41ConDescrip[0] ;
                  A26ConCodigo = P01EC3_A26ConCodigo[0] ;
                  AV126GXLvl243 = (byte)(1) ;
                  AV86cnt = (short)(AV86cnt+1) ;
                  AV25LegLicCntDias = (short)(0) ;
                  GXv_char7[0] = "" ;
                  GXv_int11[0] = AV25LegLicCntDias ;
                  GXv_date16[0] = AV26date ;
                  GXv_date15[0] = AV26date ;
                  GXv_date14[0] = AV26date ;
                  GXv_decimal13[0] = AV55plusDeLicencia ;
                  GXv_boolean2[0] = false ;
                  GXv_char6[0] = "" ;
                  new web.legajodevuelvelicencia2(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LegNumero, AV27LiqNro, true, AV33iniPeriodo, true, AV32finPeriodo, A954ConCondCodigo, false, AV85buscaConPlus, true, GXv_char7, GXv_int11, GXv_date16, GXv_date15, GXv_date14, GXv_decimal13, GXv_boolean2, GXv_char6) ;
                  excluircondiciones.this.AV25LegLicCntDias = GXv_int11[0] ;
                  excluircondiciones.this.AV26date = GXv_date16[0] ;
                  excluircondiciones.this.AV26date = GXv_date15[0] ;
                  excluircondiciones.this.AV26date = GXv_date14[0] ;
                  excluircondiciones.this.AV55plusDeLicencia = GXv_decimal13[0] ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "condescrip", "")+GXutil.trim( A41ConDescrip)+httpContext.getMessage( " &LegLicCntDias ", "")+GXutil.trim( GXutil.str( AV25LegLicCntDias, 4, 0))) ;
                  if ( (0==AV25LegLicCntDias) )
                  {
                     AV62excluConCodigo.add(GXutil.trim( A26ConCodigo), 0);
                     if ( GXutil.strcmp(A954ConCondCodigo, new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV13CliCod)) == 0 )
                     {
                        Cond_result = true ;
                     }
                     else
                     {
                        Cond_result = false ;
                     }
                     if ( Cond_result )
                     {
                        AV90vacacionesExcluye = true ;
                     }
                     else
                     {
                     }
                     AV87cnt2 = (short)(AV87cnt2+1) ;
                  }
                  else
                  {
                     if ( GXutil.strcmp(A954ConCondCodigo, new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV13CliCod)) != 0 )
                     {
                        Cond_result = true ;
                     }
                     else
                     {
                        Cond_result = false ;
                     }
                     if ( Cond_result )
                     {
                        if ( AV84LiqDPlus.doubleValue() == 0 )
                        {
                           AV84LiqDPlus = AV55plusDeLicencia ;
                        }
                     }
                     else
                     {
                        if ( AV114vacacionesLiqDPlus.doubleValue() == 0 )
                        {
                           AV114vacacionesLiqDPlus = AV55plusDeLicencia ;
                        }
                     }
                     if ( GXutil.strcmp(A954ConCondCodigo, new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV13CliCod)) != 0 )
                     {
                        Cond_result = true ;
                     }
                     else
                     {
                        Cond_result = false ;
                     }
                     if ( Cond_result )
                     {
                        AV91licenciaNoVacacionesExcluye = false ;
                     }
                  }
                  pr_default.readNext(1);
               }
               pr_default.close(1);
               if ( AV126GXLvl243 == 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "none .licencia", "")) ;
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( ".licencia &cnt ", "")+GXutil.trim( GXutil.str( AV86cnt, 4, 0))+httpContext.getMessage( " &cnt2 ", "")+GXutil.trim( GXutil.str( AV87cnt2, 4, 0))) ;
               if ( AV86cnt == AV87cnt2 )
               {
                  AV18exluirConCondicion.add("B1", 0);
                  new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "excluye .licencia 2", "")) ;
                  AV84LiqDPlus = DecimalUtil.doubleToDec(0) ;
                  AV114vacacionesLiqDPlus = DecimalUtil.doubleToDec(0) ;
               }
               if ( ( AV81EmpTipoExp == 1 ) || ( AV17LegClase != 1 ) || ( GXutil.strcmp(AV118LegModTra, "E") != 0 ) || ( GXutil.strcmp(AV119tipo_tarifa, "P") != 0 ) )
               {
                  AV18exluirConCondicion.add("B19", 0);
                  AV18exluirConCondicion.add("B20", 0);
                  new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "excluye .NoTrabLic 1", "")) ;
               }
               else
               {
                  AV85buscaConPlus = true ;
                  AV86cnt = (short)(0) ;
                  AV87cnt2 = (short)(0) ;
                  if ( AV90vacacionesExcluye )
                  {
                     AV18exluirConCondicion.add("B19", 0);
                     new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "excluye .NoTrabLic 2", "")) ;
                  }
                  else
                  {
                     GXv_boolean2[0] = AV43existe ;
                     new web.excluirporyaliquidado(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV27LiqNro, AV15LegNumero, AV20LiqPeriodo, AV59ProcesoLiquidacion, "B19", GXv_boolean2) ;
                     excluircondiciones.this.AV43existe = GXv_boolean2[0] ;
                     if ( AV43existe )
                     {
                        AV18exluirConCondicion.add("B19", 0);
                     }
                  }
                  if ( AV91licenciaNoVacacionesExcluye )
                  {
                     AV18exluirConCondicion.add("B20", 0);
                     new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "excluye .NoTrabLic 3", "")) ;
                  }
                  else
                  {
                     GXv_boolean2[0] = AV43existe ;
                     new web.excluirporyaliquidado(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV27LiqNro, AV15LegNumero, AV20LiqPeriodo, AV59ProcesoLiquidacion, "B20", GXv_boolean2) ;
                     excluircondiciones.this.AV43existe = GXv_boolean2[0] ;
                     if ( AV43existe )
                     {
                        AV18exluirConCondicion.add("B20", 0);
                     }
                  }
               }
            }
            GXv_decimal13[0] = AV28OsoAporteAdic ;
            new web.aporteadicionalos(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LegNumero, GXv_decimal13) ;
            excluircondiciones.this.AV28OsoAporteAdic = GXv_decimal13[0] ;
            if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV28OsoAporteAdic)==0) )
            {
               AV18exluirConCondicion.add("A12", 0);
            }
            AV43existe = false ;
            /* Using cursor P01EC4 */
            pr_default.execute(2, new Object[] {Integer.valueOf(AV13CliCod)});
            while ( (pr_default.getStatus(2) != 101) )
            {
               brk1EC4 = false ;
               A26ConCodigo = P01EC4_A26ConCodigo[0] ;
               A953ConCondicion = P01EC4_A953ConCondicion[0] ;
               n953ConCondicion = P01EC4_n953ConCondicion[0] ;
               A3CliCod = P01EC4_A3CliCod[0] ;
               A954ConCondCodigo = P01EC4_A954ConCondCodigo[0] ;
               GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean2[0] = AV43existe ;
               GXv_int3[0] = (byte)(0) ;
               new web.getliqdimpcalcu(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV27LiqNro, AV15LegNumero, GXutil.trim( A954ConCondCodigo), "Calculo", false, GXv_decimal13, GXv_boolean2, GXv_int3) ;
               excluircondiciones.this.AV43existe = GXv_boolean2[0] ;
               if ( AV43existe )
               {
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
               }
               while ( (pr_default.getStatus(2) != 101) && ( P01EC4_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P01EC4_A953ConCondicion[0], A953ConCondicion) == 0 ) && ( GXutil.strcmp(P01EC4_A26ConCodigo[0], A26ConCodigo) == 0 ) )
               {
                  brk1EC4 = false ;
                  brk1EC4 = true ;
                  pr_default.readNext(2);
               }
               if ( ! brk1EC4 )
               {
                  brk1EC4 = true ;
                  pr_default.readNext(2);
               }
            }
            pr_default.close(2);
            if ( ! AV43existe )
            {
               AV18exluirConCondicion.add("A1", 0);
            }
            AV69boolean = false ;
            GXv_boolean2[0] = AV80hay ;
            new web.condicionaplicaatipoliq(remoteHandle, context).execute( AV13CliCod, AV31TLiqCod, "A5", GXv_boolean2) ;
            excluircondiciones.this.AV80hay = GXv_boolean2[0] ;
            if ( AV80hay )
            {
               if ( ! AV79excluyeGanancias )
               {
                  GXv_char7[0] = new web.adelantoretencionganancias_codigoparam(remoteHandle, context).executeUdp( ) ;
                  new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXutil.trim( A954ConCondCodigo), GXv_char7) ;
                  AV69boolean = GXutil.boolval( AV68parmValue) ;
               }
            }
            if ( ! AV69boolean )
            {
               AV18exluirConCondicion.add("A5", 0);
            }
            AV35validar = false ;
            GXv_int12[0] = AV44antLiqNro ;
            new web.getliquidacionanteriornosac(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LegNumero, AV27LiqNro, false, AV20LiqPeriodo, GXv_int12) ;
            excluircondiciones.this.AV44antLiqNro = GXv_int12[0] ;
            AV48Importes = DecimalUtil.ZERO ;
            AV104auxExcluConCodigo.clear();
            if ( ! (0==AV44antLiqNro) )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "&antLiqNro ", "")+GXutil.trim( GXutil.str( AV44antLiqNro, 8, 0))) ;
               /* Using cursor P01EC5 */
               pr_default.execute(3, new Object[] {Integer.valueOf(AV13CliCod)});
               while ( (pr_default.getStatus(3) != 101) )
               {
                  A953ConCondicion = P01EC5_A953ConCondicion[0] ;
                  n953ConCondicion = P01EC5_n953ConCondicion[0] ;
                  A3CliCod = P01EC5_A3CliCod[0] ;
                  A38SubTipoConCod1 = P01EC5_A38SubTipoConCod1[0] ;
                  n38SubTipoConCod1 = P01EC5_n38SubTipoConCod1[0] ;
                  A954ConCondCodigo = P01EC5_A954ConCondCodigo[0] ;
                  A26ConCodigo = P01EC5_A26ConCodigo[0] ;
                  GXv_decimal13[0] = AV48Importes ;
                  GXv_decimal17[0] = DecimalUtil.doubleToDec(0) ;
                  GXv_boolean2[0] = false ;
                  GXv_int11[0] = (short)(0) ;
                  GXv_int3[0] = (byte)(0) ;
                  new web.getimporteporclassubclasytipoliq(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LegNumero, AV44antLiqNro, A38SubTipoConCod1, "", A954ConCondCodigo, AV20LiqPeriodo, "Calculo", false, GXv_decimal13, GXv_decimal17, GXv_boolean2, GXv_int11, GXv_int3) ;
                  excluircondiciones.this.AV48Importes = GXv_decimal13[0] ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "CONSIGUE &Importes ", "")+GXutil.trim( GXutil.str( AV48Importes, 14, 2))+httpContext.getMessage( " de SubTipoConCod1 ", "")+GXutil.trim( A38SubTipoConCod1)+" ") ;
                  if ( AV48Importes.doubleValue() > 0 )
                  {
                     AV35validar = true ;
                  }
                  else
                  {
                     AV104auxExcluConCodigo.add(GXutil.trim( A26ConCodigo), 0);
                  }
                  pr_default.readNext(3);
               }
               pr_default.close(3);
            }
            if ( ! AV35validar )
            {
               AV18exluirConCondicion.add("A4", 0);
            }
            else
            {
               AV105i = (short)(1) ;
               while ( AV105i <= AV104auxExcluConCodigo.size() )
               {
                  AV62excluConCodigo.add((String)AV104auxExcluConCodigo.elementAt(-1+AV105i), 0);
                  AV105i = (short)(AV105i+1) ;
               }
            }
            GXv_decimal17[0] = AV29F1357Importes ;
            new web.saldof1357(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LegNumero, AV20LiqPeriodo, GXv_decimal17) ;
            excluircondiciones.this.AV29F1357Importes = GXv_decimal17[0] ;
            if ( AV29F1357Importes.doubleValue() == 0 )
            {
               AV18exluirConCondicion.add("A8", 0);
            }
            GXt_char9 = AV110egresoTLiqCod ;
            GXt_char8 = AV110egresoTLiqCod ;
            GXv_char7[0] = GXt_char8 ;
            new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char7) ;
            excluircondiciones.this.GXt_char8 = GXv_char7[0] ;
            GXv_char6[0] = GXt_char9 ;
            new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char8, GXv_char6) ;
            excluircondiciones.this.GXt_char9 = GXv_char6[0] ;
            AV110egresoTLiqCod = GXt_char9 ;
            if ( GXutil.strcmp(AV31TLiqCod, AV110egresoTLiqCod) == 0 )
            {
               AV30manejaFondoCese = false ;
               GXv_boolean2[0] = AV30manejaFondoCese ;
               GXv_boolean18[0] = false ;
               GXv_char7[0] = "" ;
               new web.getmanejafondocese(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LegNumero, AV20LiqPeriodo, GXv_boolean2, GXv_boolean18, GXv_char7) ;
               excluircondiciones.this.AV30manejaFondoCese = GXv_boolean2[0] ;
               if ( AV30manejaFondoCese )
               {
                  AV18exluirConCondicion.add("B9", 0);
               }
            }
            AV53hayFeriadoConPlus = true ;
            AV52hayNoLaborableConPlus = true ;
            GXt_char9 = AV77ferTrabConCodigo ;
            GXt_char8 = AV77ferTrabConCodigo ;
            GXv_char7[0] = GXt_char8 ;
            new web.feriadostrabajados_codigoparam(remoteHandle, context).execute( GXv_char7) ;
            excluircondiciones.this.GXt_char8 = GXv_char7[0] ;
            GXv_char6[0] = GXt_char9 ;
            new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char8, GXv_char6) ;
            excluircondiciones.this.GXt_char9 = GXv_char6[0] ;
            AV77ferTrabConCodigo = GXt_char9 ;
            GXv_decimal17[0] = DecimalUtil.doubleToDec(0) ;
            GXv_boolean18[0] = AV78feriadoTrabajadoHay ;
            GXv_int3[0] = (byte)(0) ;
            new web.getliqdimpcalcu(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV27LiqNro, AV15LegNumero, AV77ferTrabConCodigo, AV59ProcesoLiquidacion, false, GXv_decimal17, GXv_boolean18, GXv_int3) ;
            excluircondiciones.this.AV78feriadoTrabajadoHay = GXv_boolean18[0] ;
            GXv_boolean18[0] = AV61EmpLiqFer ;
            new web.getempliqfer(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV27LiqNro, AV15LegNumero, AV17LegClase, AV118LegModTra, GXv_boolean18) ;
            excluircondiciones.this.AV61EmpLiqFer = GXv_boolean18[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "&EmpLiqFer ", "")+GXutil.trim( GXutil.booltostr( AV61EmpLiqFer))+httpContext.getMessage( " hayferiado (default) ", "")+GXutil.trim( GXutil.booltostr( AV53hayFeriadoConPlus))) ;
            GXv_int3[0] = AV81EmpTipoExp ;
            new web.getemptipoexp(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, GXv_int3) ;
            excluircondiciones.this.AV81EmpTipoExp = GXv_int3[0] ;
            if ( ! AV61EmpLiqFer || ( GXutil.strcmp(AV118LegModTra, "E") != 0 ) )
            {
               AV18exluirConCondicion.add("B5", 0);
               AV18exluirConCondicion.add("B6", 0);
               AV18exluirConCondicion.add("B21", 0);
               new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "EXCLUYE NoTrabFer 1", "")) ;
               AV18exluirConCondicion.add("B22", 0);
               AV53hayFeriadoConPlus = false ;
               AV52hayNoLaborableConPlus = false ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "excluye feriado 1", "")) ;
            }
            else
            {
               if ( ( AV81EmpTipoExp == 1 ) || ( AV17LegClase != 1 ) || ( GXutil.strcmp(AV118LegModTra, "E") != 0 ) || ( GXutil.strcmp(AV119tipo_tarifa, "P") != 0 ) )
               {
                  AV18exluirConCondicion.add("B21", 0);
                  new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "EXCLUYE NoTrabFer 3", "")) ;
               }
               if ( ! AV78feriadoTrabajadoHay )
               {
                  GXv_boolean18[0] = AV35validar ;
                  GXv_boolean2[0] = AV53hayFeriadoConPlus ;
                  new web.hayferiadoenperiodo(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV31TLiqCod, AV15LegNumero, AV20LiqPeriodo, "inamovible", true, GXv_boolean18, GXv_boolean2) ;
                  excluircondiciones.this.AV35validar = GXv_boolean18[0] ;
                  excluircondiciones.this.AV53hayFeriadoConPlus = GXv_boolean2[0] ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "hay feriado en periodo? ", "")+GXutil.trim( GXutil.booltostr( AV35validar))) ;
                  if ( ! AV35validar )
                  {
                     AV18exluirConCondicion.add("B5", 0);
                     if ( ( AV81EmpTipoExp != 1 ) && ( AV17LegClase == 1 ) && ( GXutil.strcmp(AV118LegModTra, "E") == 0 ) )
                     {
                        AV18exluirConCondicion.add("B21", 0);
                     }
                     else
                     {
                        GXv_boolean18[0] = AV43existe ;
                        new web.excluirporyaliquidado(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV27LiqNro, AV15LegNumero, AV20LiqPeriodo, AV59ProcesoLiquidacion, "B21", GXv_boolean18) ;
                        excluircondiciones.this.AV43existe = GXv_boolean18[0] ;
                        if ( AV43existe )
                        {
                           AV18exluirConCondicion.add("B21", 0);
                        }
                     }
                     new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "EXCLUYE NoTrabFer 2", "")) ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "excluye feriado 2", "")) ;
                  }
                  else
                  {
                     GXv_boolean18[0] = AV43existe ;
                     new web.excluirporyaliquidado(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV27LiqNro, AV15LegNumero, AV20LiqPeriodo, AV59ProcesoLiquidacion, "B5", GXv_boolean18) ;
                     excluircondiciones.this.AV43existe = GXv_boolean18[0] ;
                     if ( AV43existe )
                     {
                        AV18exluirConCondicion.add("B5", 0);
                     }
                  }
               }
               GXv_boolean18[0] = AV35validar ;
               GXv_boolean2[0] = AV52hayNoLaborableConPlus ;
               new web.hayferiadoenperiodo(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV31TLiqCod, AV15LegNumero, AV20LiqPeriodo, "nolaborable", true, GXv_boolean18, GXv_boolean2) ;
               excluircondiciones.this.AV35validar = GXv_boolean18[0] ;
               excluircondiciones.this.AV52hayNoLaborableConPlus = GXv_boolean2[0] ;
               if ( ! AV35validar )
               {
                  AV18exluirConCondicion.add("B6", 0);
                  AV18exluirConCondicion.add("B22", 0);
                  new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "excluye nolaborable 1", "")) ;
               }
               else
               {
                  if ( ( AV81EmpTipoExp == 1 ) || ( AV17LegClase != 1 ) || ( GXutil.strcmp(AV118LegModTra, "E") != 0 ) || ( GXutil.strcmp(AV119tipo_tarifa, "P") != 0 ) )
                  {
                     AV18exluirConCondicion.add("B22", 0);
                  }
                  else
                  {
                     GXv_boolean18[0] = AV43existe ;
                     new web.excluirporyaliquidado(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV27LiqNro, AV15LegNumero, AV20LiqPeriodo, AV59ProcesoLiquidacion, "B22", GXv_boolean18) ;
                     excluircondiciones.this.AV43existe = GXv_boolean18[0] ;
                     if ( AV43existe )
                     {
                        AV18exluirConCondicion.add("B22", 0);
                     }
                  }
               }
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "&hayFeriadoConPlus ", "")+GXutil.trim( GXutil.booltostr( AV53hayFeriadoConPlus))+httpContext.getMessage( " &hayNoLaborable ", "")+GXutil.trim( GXutil.booltostr( AV52hayNoLaborableConPlus))+" "+GXutil.trim( GXutil.booltostr( AV52hayNoLaborableConPlus))+httpContext.getMessage( " &plusDeLIcencia ", "")+GXutil.trim( GXutil.str( AV55plusDeLicencia, 6, 4))) ;
            if ( ( ( AV81EmpTipoExp == 2 ) && ( AV17LegClase == 1 ) && ( GXutil.strcmp(AV118LegModTra, "E") == 0 ) ) || ( ! AV53hayFeriadoConPlus && ! AV52hayNoLaborableConPlus && ( AV84LiqDPlus.doubleValue() == 0 ) ) )
            {
               AV18exluirConCondicion.add("B4", 0);
            }
            if ( ( ( AV81EmpTipoExp == 2 ) && ( AV17LegClase == 1 ) && ( GXutil.strcmp(AV118LegModTra, "E") == 0 ) ) || ( AV114vacacionesLiqDPlus.doubleValue() == 0 ) )
            {
               AV18exluirConCondicion.add("VP", 0);
            }
            AV25LegLicCntDias = (short)(0) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "evalua sin goce", "")) ;
            if ( ( AV17LegClase == 1 ) && ( GXutil.strcmp(AV118LegModTra, "E") == 0 ) )
            {
               GXv_char7[0] = "" ;
               GXv_int11[0] = AV25LegLicCntDias ;
               GXv_date16[0] = AV26date ;
               GXv_date15[0] = AV26date ;
               GXv_date14[0] = AV26date ;
               GXv_decimal17[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean18[0] = false ;
               GXv_char6[0] = "" ;
               new web.legajodevuelvelicencia2(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LegNumero, AV27LiqNro, true, AV33iniPeriodo, false, AV32finPeriodo, "", false, false, false, GXv_char7, GXv_int11, GXv_date16, GXv_date15, GXv_date14, GXv_decimal17, GXv_boolean18, GXv_char6) ;
               excluircondiciones.this.AV25LegLicCntDias = GXv_int11[0] ;
               excluircondiciones.this.AV26date = GXv_date16[0] ;
               excluircondiciones.this.AV26date = GXv_date15[0] ;
               excluircondiciones.this.AV26date = GXv_date14[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "evalua sin goce &LegLicCntDias ", "")+GXutil.trim( GXutil.str( AV25LegLicCntDias, 4, 0))) ;
            }
            if ( AV25LegLicCntDias == 0 )
            {
               AV18exluirConCondicion.add("B7", 0);
            }
            else
            {
               GXv_boolean18[0] = AV43existe ;
               new web.excluirporyaliquidado(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV27LiqNro, AV15LegNumero, AV20LiqPeriodo, AV59ProcesoLiquidacion, "B7", GXv_boolean18) ;
               excluircondiciones.this.AV43existe = GXv_boolean18[0] ;
               if ( AV43existe )
               {
                  AV18exluirConCondicion.add("B7", 0);
               }
            }
            AV25LegLicCntDias = (short)(0) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV123Pgmname, httpContext.getMessage( "evalua ausencias injustificadas", "")) ;
            if ( ( AV17LegClase == 1 ) && ( GXutil.strcmp(AV118LegModTra, "E") == 0 ) )
            {
               GXv_char7[0] = "" ;
               GXv_int11[0] = AV25LegLicCntDias ;
               GXv_date16[0] = AV26date ;
               GXv_date15[0] = AV26date ;
               GXv_date14[0] = AV26date ;
               GXv_decimal17[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean18[0] = false ;
               GXv_char6[0] = "" ;
               new web.legajodevuelvelicencia2(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LegNumero, AV27LiqNro, true, AV33iniPeriodo, false, AV32finPeriodo, new web.estadoausenciasinjustificadas(remoteHandle, context).executeUdp( AV13CliCod), false, false, false, GXv_char7, GXv_int11, GXv_date16, GXv_date15, GXv_date14, GXv_decimal17, GXv_boolean18, GXv_char6) ;
               excluircondiciones.this.AV25LegLicCntDias = GXv_int11[0] ;
               excluircondiciones.this.AV26date = GXv_date16[0] ;
               excluircondiciones.this.AV26date = GXv_date15[0] ;
               excluircondiciones.this.AV26date = GXv_date14[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV123Pgmname, httpContext.getMessage( "injustificadas &LegLicCntDias ", "")+GXutil.trim( GXutil.str( AV25LegLicCntDias, 4, 0))) ;
            }
            if ( AV25LegLicCntDias == 0 )
            {
               AV18exluirConCondicion.add("AI", 0);
               new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV123Pgmname, httpContext.getMessage( "exluye injus 1", "")) ;
            }
            else
            {
               GXv_boolean18[0] = AV43existe ;
               new web.excluirporyaliquidado(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV27LiqNro, AV15LegNumero, AV20LiqPeriodo, AV59ProcesoLiquidacion, "AI", GXv_boolean18) ;
               excluircondiciones.this.AV43existe = GXv_boolean18[0] ;
               if ( AV43existe )
               {
                  AV18exluirConCondicion.add("AI", 0);
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV123Pgmname, httpContext.getMessage( "exluye injus 2", "")) ;
               }
            }
            GXt_boolean19 = AV35validar ;
            GXv_boolean18[0] = GXt_boolean19 ;
            new web.tienefamiliaradherente(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LegNumero, GXv_boolean18) ;
            excluircondiciones.this.GXt_boolean19 = GXv_boolean18[0] ;
            AV35validar = GXt_boolean19 ;
            if ( ! AV35validar )
            {
               AV18exluirConCondicion.add("A9", 0);
            }
            GXv_char7[0] = AV36SinCod ;
            new web.empleadogetsindicato(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LegNumero, GXv_char7) ;
            excluircondiciones.this.AV36SinCod = GXv_char7[0] ;
            if ( (GXutil.strcmp("", AV36SinCod)==0) )
            {
               AV18exluirConCondicion.add("A10", 0);
            }
            GXv_boolean18[0] = AV74dedExiste ;
            GXv_decimal17[0] = AV19LegDedImporte ;
            new web.obtenerimportededuccion(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV27LiqNro, AV15LegNumero, "[monto_siradig]", AV20LiqPeriodo, "", false, (byte)(0), "", true, GXv_boolean18, GXv_decimal17) ;
            excluircondiciones.this.AV74dedExiste = GXv_boolean18[0] ;
            excluircondiciones.this.AV19LegDedImporte = GXv_decimal17[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "&LegDedImporte ", "")+GXutil.trim( GXutil.str( AV19LegDedImporte, 14, 2))) ;
            if ( ! AV74dedExiste )
            {
               AV73LiqLegConAnio = (short)(GXutil.year( AV20LiqPeriodo)) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "&LiqLegConAnio ", "")+GXutil.trim( GXutil.str( AV73LiqLegConAnio, 4, 0))+httpContext.getMessage( " &ConCodigo ", "")+GXutil.trim( AV58ConCodigo)) ;
               GXv_decimal17[0] = AV75LiqLegConSaldo ;
               GXv_boolean18[0] = false ;
               new web.cuentasaldoanterior(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, (short)(GXutil.year( AV20LiqPeriodo)), AV15LegNumero, "", AV27LiqNro, false, GXv_decimal17, GXv_boolean18) ;
               excluircondiciones.this.AV75LiqLegConSaldo = GXv_decimal17[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "&LiqLegConSaldo ", "")+GXutil.trim( GXutil.str( AV75LiqLegConSaldo, 14, 2))) ;
               if ( AV75LiqLegConSaldo.doubleValue() == 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "excluye siradigs", "")) ;
                  AV18exluirConCondicion.add("B2", 0);
               }
            }
            else
            {
               GXt_char9 = AV106pagosACuentaConCodigo ;
               GXt_char8 = AV106pagosACuentaConCodigo ;
               GXv_char7[0] = GXt_char8 ;
               new web.pagosacuenta_codigoparam(remoteHandle, context).execute( GXv_char7) ;
               excluircondiciones.this.GXt_char8 = GXv_char7[0] ;
               GXv_char6[0] = GXt_char9 ;
               new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char8, GXv_char6) ;
               excluircondiciones.this.GXt_char9 = GXv_char6[0] ;
               AV106pagosACuentaConCodigo = GXt_char9 ;
               GXv_boolean18[0] = AV74dedExiste ;
               GXv_decimal17[0] = AV19LegDedImporte ;
               new web.obtenerimportededuccion(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV27LiqNro, AV15LegNumero, "[monto_siradig]", AV20LiqPeriodo, AV106pagosACuentaConCodigo, false, (byte)(0), "", true, GXv_boolean18, GXv_decimal17) ;
               excluircondiciones.this.AV74dedExiste = GXv_boolean18[0] ;
               excluircondiciones.this.AV19LegDedImporte = GXv_decimal17[0] ;
               if ( ! AV74dedExiste )
               {
                  AV62excluConCodigo.add(AV106pagosACuentaConCodigo, 0);
               }
            }
            GXv_decimal17[0] = AV19LegDedImporte ;
            GXv_boolean18[0] = AV74dedExiste ;
            new web.obtenerimportededucciondeperiodo(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LegNumero, AV20LiqPeriodo, "", "reintegro", AV63operandos, true, GXv_decimal17, GXv_boolean18) ;
            excluircondiciones.this.AV19LegDedImporte = GXv_decimal17[0] ;
            excluircondiciones.this.AV74dedExiste = GXv_boolean18[0] ;
            if ( ! AV74dedExiste )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "excluye reintegros", "")) ;
               AV18exluirConCondicion.add("B14", 0);
            }
            AV130GXLvl639 = (byte)(0) ;
            /* Using cursor P01EC6 */
            pr_default.execute(4, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV14EmpCod), Integer.valueOf(AV15LegNumero)});
            while ( (pr_default.getStatus(4) != 101) )
            {
               A1547GuarCod = P01EC6_A1547GuarCod[0] ;
               n1547GuarCod = P01EC6_n1547GuarCod[0] ;
               A6LegNumero = P01EC6_A6LegNumero[0] ;
               A1EmpCod = P01EC6_A1EmpCod[0] ;
               A3CliCod = P01EC6_A3CliCod[0] ;
               A29LegOrden = P01EC6_A29LegOrden[0] ;
               AV130GXLvl639 = (byte)(1) ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               pr_default.readNext(4);
            }
            pr_default.close(4);
            if ( AV130GXLvl639 == 0 )
            {
               AV18exluirConCondicion.add("B15", 0);
            }
            GXv_boolean18[0] = AV22tiene ;
            new web.tieneobligacionactiva(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LegNumero, AV21TipoOblSec, "", GXv_boolean18) ;
            excluircondiciones.this.AV22tiene = GXv_boolean18[0] ;
            if ( ! AV22tiene )
            {
               AV18exluirConCondicion.add("B3", 0);
            }
            else
            {
               AV95incluyoAlgunaObligacion = false ;
               /* Using cursor P01EC7 */
               pr_default.execute(5, new Object[] {Integer.valueOf(AV13CliCod)});
               while ( (pr_default.getStatus(5) != 101) )
               {
                  A953ConCondicion = P01EC7_A953ConCondicion[0] ;
                  n953ConCondicion = P01EC7_n953ConCondicion[0] ;
                  A3CliCod = P01EC7_A3CliCod[0] ;
                  A148ConFormula = P01EC7_A148ConFormula[0] ;
                  n148ConFormula = P01EC7_n148ConFormula[0] ;
                  A26ConCodigo = P01EC7_A26ConCodigo[0] ;
                  GXv_boolean18[0] = AV22tiene ;
                  new web.conceptotienetipoliq(remoteHandle, context).execute( AV13CliCod, A26ConCodigo, AV31TLiqCod, GXv_boolean18) ;
                  excluircondiciones.this.AV22tiene = GXv_boolean18[0] ;
                  if ( ! AV22tiene )
                  {
                     AV62excluConCodigo.add(GXutil.trim( A26ConCodigo), 0);
                  }
                  else
                  {
                     if ( (0==AV82PaiCod) )
                     {
                        GXt_int10 = AV82PaiCod ;
                        GXv_int11[0] = GXt_int10 ;
                        new web.clientegetpais(remoteHandle, context).execute( AV13CliCod, GXv_int11) ;
                        excluircondiciones.this.GXt_int10 = GXv_int11[0] ;
                        AV82PaiCod = GXt_int10 ;
                     }
                     GXv_char7[0] = AV93busca2Palabra ;
                     GXv_char6[0] = "" ;
                     GXv_char5[0] = "" ;
                     GXv_char4[0] = "" ;
                     new web.legoperandogetvalores(remoteHandle, context).execute( A148ConFormula, GXv_char7, GXv_char6, GXv_char5, GXv_char4) ;
                     excluircondiciones.this.AV93busca2Palabra = GXv_char7[0] ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "conformula ", "")+A148ConFormula+httpContext.getMessage( " buscapalabra ", "")+AV93busca2Palabra+httpContext.getMessage( " paicod ", "")+GXutil.trim( GXutil.str( AV82PaiCod, 4, 0))) ;
                     GXv_int11[0] = AV21TipoOblSec ;
                     GXv_boolean18[0] = false ;
                     GXv_int3[0] = AV94tipo_total_embargo ;
                     GXv_int20[0] = (short)(0) ;
                     GXv_char7[0] = "" ;
                     GXv_int21[0] = (byte)(0) ;
                     new web.gettipooblsecporcodigo(remoteHandle, context).execute( AV82PaiCod, AV93busca2Palabra, GXv_int11, GXv_boolean18, GXv_int3, GXv_int20, GXv_char7, GXv_int21) ;
                     excluircondiciones.this.AV21TipoOblSec = GXv_int11[0] ;
                     excluircondiciones.this.AV94tipo_total_embargo = GXv_int3[0] ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "&TipoOblSec ", "")+GXutil.trim( GXutil.str( AV21TipoOblSec, 4, 0))) ;
                     GXv_boolean18[0] = AV35validar ;
                     new web.tieneobligacionactiva(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LegNumero, AV21TipoOblSec, A26ConCodigo, GXv_boolean18) ;
                     excluircondiciones.this.AV35validar = GXv_boolean18[0] ;
                     if ( ! AV35validar )
                     {
                        AV62excluConCodigo.add(GXutil.trim( A26ConCodigo), 0);
                     }
                     else
                     {
                        AV95incluyoAlgunaObligacion = true ;
                     }
                     new web.msgdebug_prod(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "&validar ", "")+GXutil.trim( GXutil.booltostr( AV35validar))) ;
                  }
                  pr_default.readNext(5);
               }
               pr_default.close(5);
               if ( ! AV95incluyoAlgunaObligacion )
               {
                  AV18exluirConCondicion.add("B3", 0);
               }
            }
            if ( GXutil.strcmp(AV118LegModTra, "E") != 0 )
            {
               AV18exluirConCondicion.add("A3", 0);
               AV18exluirConCondicion.add("LA", 0);
            }
            else
            {
               GXv_boolean18[0] = AV116LegLiqApo ;
               new web.getlegliqapo(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LegNumero, GXv_boolean18) ;
               excluircondiciones.this.AV116LegLiqApo = GXv_boolean18[0] ;
               if ( ! AV116LegLiqApo )
               {
                  AV18exluirConCondicion.add("A3", 0);
                  AV18exluirConCondicion.add("LA", 0);
               }
               else
               {
                  GXv_boolean18[0] = AV23LegJubilado ;
                  new web.getlegjubilado(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LegNumero, GXv_boolean18) ;
                  excluircondiciones.this.AV23LegJubilado = GXv_boolean18[0] ;
                  if ( AV23LegJubilado )
                  {
                     AV18exluirConCondicion.add("A3", 0);
                  }
               }
            }
            AV22tiene = false ;
            GXt_char9 = AV107auxConCodigo ;
            GXt_char8 = AV107auxConCodigo ;
            GXv_char7[0] = GXt_char8 ;
            new web.concepto_sueldomensual_codigoparam(remoteHandle, context).execute( GXv_char7) ;
            excluircondiciones.this.GXt_char8 = GXv_char7[0] ;
            GXv_char6[0] = GXt_char9 ;
            new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char8, GXv_char6) ;
            excluircondiciones.this.GXt_char9 = GXv_char6[0] ;
            AV107auxConCodigo = GXt_char9 ;
            GXv_decimal17[0] = AV108LiqDCanti ;
            GXv_boolean18[0] = AV43existe ;
            GXv_int21[0] = (byte)(0) ;
            new web.getliqdcantidad(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV27LiqNro, AV15LegNumero, AV107auxConCodigo, GXv_decimal17, GXv_boolean18, GXv_int21) ;
            excluircondiciones.this.AV108LiqDCanti = GXv_decimal17[0] ;
            excluircondiciones.this.AV43existe = GXv_boolean18[0] ;
            if ( AV43existe )
            {
               GXv_int20[0] = AV109diasMes ;
               new web.diasmes(remoteHandle, context).execute( AV13CliCod, AV20LiqPeriodo, GXv_int20) ;
               excluircondiciones.this.AV109diasMes = (byte)((byte)(GXv_int20[0])) ;
               if ( ( AV108LiqDCanti.doubleValue() > 0 ) && ( AV108LiqDCanti.doubleValue() < AV109diasMes ) )
               {
                  AV22tiene = true ;
               }
            }
            if ( ! AV22tiene )
            {
               GXv_char7[0] = AV24MprCod ;
               new web.getlegajomodalidad(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV15LegNumero, GXv_char7) ;
               excluircondiciones.this.AV24MprCod = GXv_char7[0] ;
               GXt_boolean19 = AV22tiene ;
               GXv_boolean18[0] = GXt_boolean19 ;
               new web.getmodalidadparcial(remoteHandle, context).execute( AV24MprCod, GXv_boolean18) ;
               excluircondiciones.this.GXt_boolean19 = GXv_boolean18[0] ;
               AV22tiene = GXt_boolean19 ;
               if ( ! AV22tiene )
               {
                  AV18exluirConCondicion.add("A11", 0);
               }
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = excluircondiciones.this.AV18exluirConCondicion;
      this.aP9[0] = excluircondiciones.this.AV62excluConCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18exluirConCondicion = new GXSimpleCollection<String>(String.class, "internal", "");
      AV123Pgmname = "" ;
      AV16ConveCodigo = "" ;
      GXv_char1 = new String[1] ;
      AV118LegModTra = "" ;
      AV92LegTitulo = "" ;
      AV97LegCatCodigo = "" ;
      AV119tipo_tarifa = "" ;
      AV31TLiqCod = "" ;
      AV68parmValue = "" ;
      AV98error = "" ;
      AV99CatValorHora = DecimalUtil.ZERO ;
      AV117tipo_sueldo = "" ;
      scmdbuf = "" ;
      P01EC2_A954ConCondCodigo = new String[] {""} ;
      P01EC2_A150ConHabilitado = new boolean[] {false} ;
      P01EC2_A953ConCondicion = new String[] {""} ;
      P01EC2_n953ConCondicion = new boolean[] {false} ;
      P01EC2_A3CliCod = new int[1] ;
      P01EC2_A26ConCodigo = new String[] {""} ;
      A954ConCondCodigo = "" ;
      A953ConCondicion = "" ;
      A26ConCodigo = "" ;
      AV59ProcesoLiquidacion = "" ;
      AV57EmpAntiguedad = DecimalUtil.ZERO ;
      AV58ConCodigo = "" ;
      AV125Importe = DecimalUtil.ZERO ;
      AV60EmpPresentismo = DecimalUtil.ZERO ;
      AV84LiqDPlus = DecimalUtil.ZERO ;
      AV55plusDeLicencia = DecimalUtil.ZERO ;
      AV33iniPeriodo = GXutil.nullDate() ;
      AV32finPeriodo = GXutil.nullDate() ;
      AV26date = GXutil.nullDate() ;
      AV112LegFecIngreso = GXutil.nullDate() ;
      AV101LegFecEgreso = GXutil.nullDate() ;
      P01EC3_A150ConHabilitado = new boolean[] {false} ;
      P01EC3_A953ConCondicion = new String[] {""} ;
      P01EC3_n953ConCondicion = new boolean[] {false} ;
      P01EC3_A3CliCod = new int[1] ;
      P01EC3_A954ConCondCodigo = new String[] {""} ;
      P01EC3_A41ConDescrip = new String[] {""} ;
      P01EC3_A26ConCodigo = new String[] {""} ;
      A41ConDescrip = "" ;
      AV114vacacionesLiqDPlus = DecimalUtil.ZERO ;
      AV28OsoAporteAdic = DecimalUtil.ZERO ;
      P01EC4_A26ConCodigo = new String[] {""} ;
      P01EC4_A953ConCondicion = new String[] {""} ;
      P01EC4_n953ConCondicion = new boolean[] {false} ;
      P01EC4_A3CliCod = new int[1] ;
      P01EC4_A954ConCondCodigo = new String[] {""} ;
      GXv_int12 = new int[1] ;
      AV48Importes = DecimalUtil.ZERO ;
      AV104auxExcluConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      P01EC5_A953ConCondicion = new String[] {""} ;
      P01EC5_n953ConCondicion = new boolean[] {false} ;
      P01EC5_A3CliCod = new int[1] ;
      P01EC5_A38SubTipoConCod1 = new String[] {""} ;
      P01EC5_n38SubTipoConCod1 = new boolean[] {false} ;
      P01EC5_A954ConCondCodigo = new String[] {""} ;
      P01EC5_A26ConCodigo = new String[] {""} ;
      A38SubTipoConCod1 = "" ;
      GXv_decimal13 = new java.math.BigDecimal[1] ;
      AV29F1357Importes = DecimalUtil.ZERO ;
      AV110egresoTLiqCod = "" ;
      AV77ferTrabConCodigo = "" ;
      GXv_boolean2 = new boolean[1] ;
      GXv_date16 = new java.util.Date[1] ;
      GXv_date15 = new java.util.Date[1] ;
      GXv_date14 = new java.util.Date[1] ;
      AV36SinCod = "" ;
      AV19LegDedImporte = DecimalUtil.ZERO ;
      AV75LiqLegConSaldo = DecimalUtil.ZERO ;
      AV106pagosACuentaConCodigo = "" ;
      AV63operandos = "" ;
      P01EC6_A1547GuarCod = new short[1] ;
      P01EC6_n1547GuarCod = new boolean[] {false} ;
      P01EC6_A6LegNumero = new int[1] ;
      P01EC6_A1EmpCod = new short[1] ;
      P01EC6_A3CliCod = new int[1] ;
      P01EC6_A29LegOrden = new short[1] ;
      P01EC7_A953ConCondicion = new String[] {""} ;
      P01EC7_n953ConCondicion = new boolean[] {false} ;
      P01EC7_A3CliCod = new int[1] ;
      P01EC7_A148ConFormula = new String[] {""} ;
      P01EC7_n148ConFormula = new boolean[] {false} ;
      P01EC7_A26ConCodigo = new String[] {""} ;
      A148ConFormula = "" ;
      AV93busca2Palabra = "" ;
      GXv_char5 = new String[1] ;
      GXv_char4 = new String[1] ;
      GXv_int11 = new short[1] ;
      GXv_int3 = new byte[1] ;
      AV107auxConCodigo = "" ;
      GXt_char9 = "" ;
      GXt_char8 = "" ;
      GXv_char6 = new String[1] ;
      AV108LiqDCanti = DecimalUtil.ZERO ;
      GXv_decimal17 = new java.math.BigDecimal[1] ;
      GXv_int21 = new byte[1] ;
      GXv_int20 = new short[1] ;
      AV24MprCod = "" ;
      GXv_char7 = new String[1] ;
      GXv_boolean18 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.excluircondiciones__default(),
         new Object[] {
             new Object[] {
            P01EC2_A954ConCondCodigo, P01EC2_A150ConHabilitado, P01EC2_A953ConCondicion, P01EC2_n953ConCondicion, P01EC2_A3CliCod, P01EC2_A26ConCodigo
            }
            , new Object[] {
            P01EC3_A150ConHabilitado, P01EC3_A953ConCondicion, P01EC3_n953ConCondicion, P01EC3_A3CliCod, P01EC3_A954ConCondCodigo, P01EC3_A41ConDescrip, P01EC3_A26ConCodigo
            }
            , new Object[] {
            P01EC4_A26ConCodigo, P01EC4_A953ConCondicion, P01EC4_n953ConCondicion, P01EC4_A3CliCod, P01EC4_A954ConCondCodigo
            }
            , new Object[] {
            P01EC5_A953ConCondicion, P01EC5_n953ConCondicion, P01EC5_A3CliCod, P01EC5_A38SubTipoConCod1, P01EC5_n38SubTipoConCod1, P01EC5_A954ConCondCodigo, P01EC5_A26ConCodigo
            }
            , new Object[] {
            P01EC6_A1547GuarCod, P01EC6_n1547GuarCod, P01EC6_A6LegNumero, P01EC6_A1EmpCod, P01EC6_A3CliCod, P01EC6_A29LegOrden
            }
            , new Object[] {
            P01EC7_A953ConCondicion, P01EC7_n953ConCondicion, P01EC7_A3CliCod, P01EC7_A148ConFormula, P01EC7_n148ConFormula, P01EC7_A26ConCodigo
            }
         }
      );
      AV123Pgmname = "excluirCondiciones" ;
      /* GeneXus formulas. */
      AV123Pgmname = "excluirCondiciones" ;
      Gx_err = (short)(0) ;
   }

   private byte AV17LegClase ;
   private byte AV113LegFormaPago ;
   private byte AV42liquidaSAC ;
   private byte AV81EmpTipoExp ;
   private byte AV126GXLvl243 ;
   private byte AV130GXLvl639 ;
   private byte AV94tipo_total_embargo ;
   private byte GXv_int3[] ;
   private byte GXv_int21[] ;
   private byte AV109diasMes ;
   private short AV14EmpCod ;
   private short AV82PaiCod ;
   private short AV120CliPaiConve ;
   private short AV25LegLicCntDias ;
   private short AV86cnt ;
   private short AV87cnt2 ;
   private short AV105i ;
   private short AV73LiqLegConAnio ;
   private short A1547GuarCod ;
   private short A1EmpCod ;
   private short A29LegOrden ;
   private short AV21TipoOblSec ;
   private short GXt_int10 ;
   private short GXv_int11[] ;
   private short GXv_int20[] ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV27LiqNro ;
   private int AV15LegNumero ;
   private int AV96CliConveVer ;
   private int A3CliCod ;
   private int AV44antLiqNro ;
   private int GXv_int12[] ;
   private int A6LegNumero ;
   private java.math.BigDecimal AV99CatValorHora ;
   private java.math.BigDecimal AV57EmpAntiguedad ;
   private java.math.BigDecimal AV125Importe ;
   private java.math.BigDecimal AV60EmpPresentismo ;
   private java.math.BigDecimal AV84LiqDPlus ;
   private java.math.BigDecimal AV55plusDeLicencia ;
   private java.math.BigDecimal AV114vacacionesLiqDPlus ;
   private java.math.BigDecimal AV28OsoAporteAdic ;
   private java.math.BigDecimal AV48Importes ;
   private java.math.BigDecimal GXv_decimal13[] ;
   private java.math.BigDecimal AV29F1357Importes ;
   private java.math.BigDecimal AV19LegDedImporte ;
   private java.math.BigDecimal AV75LiqLegConSaldo ;
   private java.math.BigDecimal AV108LiqDCanti ;
   private java.math.BigDecimal GXv_decimal17[] ;
   private String AV123Pgmname ;
   private String AV16ConveCodigo ;
   private String GXv_char1[] ;
   private String AV118LegModTra ;
   private String AV92LegTitulo ;
   private String AV97LegCatCodigo ;
   private String AV119tipo_tarifa ;
   private String AV31TLiqCod ;
   private String AV117tipo_sueldo ;
   private String scmdbuf ;
   private String A954ConCondCodigo ;
   private String A953ConCondicion ;
   private String A26ConCodigo ;
   private String AV59ProcesoLiquidacion ;
   private String AV58ConCodigo ;
   private String A38SubTipoConCod1 ;
   private String AV110egresoTLiqCod ;
   private String AV77ferTrabConCodigo ;
   private String AV36SinCod ;
   private String AV106pagosACuentaConCodigo ;
   private String AV63operandos ;
   private String AV93busca2Palabra ;
   private String GXv_char5[] ;
   private String GXv_char4[] ;
   private String AV107auxConCodigo ;
   private String GXt_char9 ;
   private String GXt_char8 ;
   private String GXv_char6[] ;
   private String AV24MprCod ;
   private String GXv_char7[] ;
   private java.util.Date AV20LiqPeriodo ;
   private java.util.Date AV33iniPeriodo ;
   private java.util.Date AV32finPeriodo ;
   private java.util.Date AV26date ;
   private java.util.Date AV112LegFecIngreso ;
   private java.util.Date AV101LegFecEgreso ;
   private java.util.Date GXv_date16[] ;
   private java.util.Date GXv_date15[] ;
   private java.util.Date GXv_date14[] ;
   private boolean AV9liquidacionSimple ;
   private boolean AV10resolver ;
   private boolean AV11chequearExistencia ;
   private boolean AV12LegAgenReten ;
   private boolean AV100desglozar ;
   private boolean A150ConHabilitado ;
   private boolean n953ConCondicion ;
   private boolean AV43existe ;
   private boolean AV79excluyeGanancias ;
   private boolean AV35validar ;
   private boolean AV89validarExistencia ;
   private boolean AV91licenciaNoVacacionesExcluye ;
   private boolean AV85buscaConPlus ;
   private boolean Cond_result ;
   private boolean AV90vacacionesExcluye ;
   private boolean brk1EC4 ;
   private boolean AV69boolean ;
   private boolean AV80hay ;
   private boolean n38SubTipoConCod1 ;
   private boolean AV30manejaFondoCese ;
   private boolean AV53hayFeriadoConPlus ;
   private boolean AV52hayNoLaborableConPlus ;
   private boolean AV78feriadoTrabajadoHay ;
   private boolean AV61EmpLiqFer ;
   private boolean GXv_boolean2[] ;
   private boolean AV74dedExiste ;
   private boolean n1547GuarCod ;
   private boolean AV22tiene ;
   private boolean AV95incluyoAlgunaObligacion ;
   private boolean n148ConFormula ;
   private boolean AV116LegLiqApo ;
   private boolean AV23LegJubilado ;
   private boolean GXt_boolean19 ;
   private boolean GXv_boolean18[] ;
   private String AV68parmValue ;
   private String A148ConFormula ;
   private String AV98error ;
   private String A41ConDescrip ;
   private GXSimpleCollection<String>[] aP9 ;
   private GXSimpleCollection<String>[] aP8 ;
   private IDataStoreProvider pr_default ;
   private String[] P01EC2_A954ConCondCodigo ;
   private boolean[] P01EC2_A150ConHabilitado ;
   private String[] P01EC2_A953ConCondicion ;
   private boolean[] P01EC2_n953ConCondicion ;
   private int[] P01EC2_A3CliCod ;
   private String[] P01EC2_A26ConCodigo ;
   private boolean[] P01EC3_A150ConHabilitado ;
   private String[] P01EC3_A953ConCondicion ;
   private boolean[] P01EC3_n953ConCondicion ;
   private int[] P01EC3_A3CliCod ;
   private String[] P01EC3_A954ConCondCodigo ;
   private String[] P01EC3_A41ConDescrip ;
   private String[] P01EC3_A26ConCodigo ;
   private String[] P01EC4_A26ConCodigo ;
   private String[] P01EC4_A953ConCondicion ;
   private boolean[] P01EC4_n953ConCondicion ;
   private int[] P01EC4_A3CliCod ;
   private String[] P01EC4_A954ConCondCodigo ;
   private String[] P01EC5_A953ConCondicion ;
   private boolean[] P01EC5_n953ConCondicion ;
   private int[] P01EC5_A3CliCod ;
   private String[] P01EC5_A38SubTipoConCod1 ;
   private boolean[] P01EC5_n38SubTipoConCod1 ;
   private String[] P01EC5_A954ConCondCodigo ;
   private String[] P01EC5_A26ConCodigo ;
   private short[] P01EC6_A1547GuarCod ;
   private boolean[] P01EC6_n1547GuarCod ;
   private int[] P01EC6_A6LegNumero ;
   private short[] P01EC6_A1EmpCod ;
   private int[] P01EC6_A3CliCod ;
   private short[] P01EC6_A29LegOrden ;
   private String[] P01EC7_A953ConCondicion ;
   private boolean[] P01EC7_n953ConCondicion ;
   private int[] P01EC7_A3CliCod ;
   private String[] P01EC7_A148ConFormula ;
   private boolean[] P01EC7_n148ConFormula ;
   private String[] P01EC7_A26ConCodigo ;
   private GXSimpleCollection<String> AV18exluirConCondicion ;
   private GXSimpleCollection<String> AV62excluConCodigo ;
   private GXSimpleCollection<String> AV104auxExcluConCodigo ;
}

final  class excluircondiciones__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01EC2", "SELECT ConCondCodigo, ConHabilitado, ConCondicion, CliCod, ConCodigo FROM Concepto WHERE (CliCod = ? and ConCondicion = ( 'B23')) AND (ConCondCodigo <> ( ?)) AND (ConHabilitado = TRUE) ORDER BY CliCod, ConCondicion ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01EC3", "SELECT ConHabilitado, ConCondicion, CliCod, ConCondCodigo, ConDescrip, ConCodigo FROM Concepto WHERE (CliCod = ? and ConCondicion = ( 'B1')) AND (ConHabilitado = TRUE) ORDER BY CliCod, ConCondicion ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01EC4", "SELECT ConCodigo, ConCondicion, CliCod, ConCondCodigo FROM Concepto WHERE CliCod = ? and ConCondicion = ( 'A1') ORDER BY CliCod, ConCondicion, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01EC5", "SELECT ConCondicion, CliCod, SubTipoConCod1, ConCondCodigo, ConCodigo FROM Concepto WHERE CliCod = ? and ConCondicion = ( 'A4') ORDER BY CliCod, ConCondicion ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01EC6", "SELECT GuarCod, LegNumero, EmpCod, CliCod, LegOrden FROM LegajoFamilia WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (Not (GuarCod = 0) and Not GuarCod IS NULL) ORDER BY CliCod, EmpCod, LegNumero  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01EC7", "SELECT ConCondicion, CliCod, ConFormula, ConCodigo FROM Concepto WHERE CliCod = ? and ConCondicion = ( 'B3') ORDER BY CliCod, ConCondicion, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((String[]) buf[5])[0] = rslt.getString(5, 10);
               return;
            case 1 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getString(6, 10);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((String[]) buf[6])[0] = rslt.getString(5, 10);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 10);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

