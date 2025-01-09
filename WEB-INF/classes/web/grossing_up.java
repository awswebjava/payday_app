package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grossing_up extends GXProcedure
{
   public grossing_up( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grossing_up.class ), "" );
   }

   public grossing_up( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           int aP3 ,
                           String aP4 ,
                           String aP5 ,
                           java.util.Date aP6 ,
                           java.math.BigDecimal[] aP7 ,
                           String[] aP8 ,
                           String[] aP9 )
   {
      grossing_up.this.aP10 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        java.util.Date aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        String[] aP8 ,
                        String[] aP9 ,
                        byte[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             java.util.Date aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             byte[] aP10 )
   {
      grossing_up.this.AV16CliCod = aP0;
      grossing_up.this.AV19EmpCod = aP1;
      grossing_up.this.AV30LegNumero = aP2;
      grossing_up.this.AV36LiqNro = aP3;
      grossing_up.this.AV50TLiqCod = aP4;
      grossing_up.this.AV41ProcesoLiquidacion = aP5;
      grossing_up.this.AV8LiqPeriodo = aP6;
      grossing_up.this.aP7 = aP7;
      grossing_up.this.aP8 = aP8;
      grossing_up.this.aP9 = aP9;
      grossing_up.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV34LiqDCalculado = (byte)(1) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV67Pgmname, httpContext.getMessage( "ini &LiqNro ", "")+GXutil.trim( GXutil.str( AV36LiqNro, 8, 0))) ;
      if ( ! (0==AV36LiqNro) )
      {
         AV29keyPalabra = httpContext.getMessage( "grossingup_calculo_", "") + GXutil.trim( GXutil.str( AV16CliCod, 6, 0)) + "_" + GXutil.trim( GXutil.str( AV19EmpCod, 4, 0)) + "_" + GXutil.trim( GXutil.str( AV30LegNumero, 8, 0)) ;
         AV25grossingup_calculo.fromJSonString(AV9websession.getValue(AV29keyPalabra), null);
         new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV67Pgmname, httpContext.getMessage( "&grossingup_calculo ", "")+AV25grossingup_calculo.toJSonString(false)) ;
         GXv_char1[0] = AV40ParmValue ;
         new web.getparametro(remoteHandle, context).execute( AV16CliCod, new web.grossigup_excluir_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
         grossing_up.this.AV40ParmValue = GXv_char1[0] ;
         AV22excluirConCodigo.fromJSonString(AV40ParmValue, null);
         GXv_char1[0] = AV40ParmValue ;
         new web.getparametro(remoteHandle, context).execute( AV16CliCod, new web.grossigup_multiplicador_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
         grossing_up.this.AV40ParmValue = GXv_char1[0] ;
         AV39parmMultiplicador = CommonUtil.decimalVal( AV40ParmValue, ".") ;
         GXv_decimal2[0] = AV32LegSuelImporte ;
         GXv_char1[0] = AV49tipo_sueldo ;
         GXv_int3[0] = AV33LegSuelSec ;
         GXv_boolean4[0] = AV23existe ;
         new web.getlegajosueldoultimo(remoteHandle, context).execute( AV16CliCod, AV19EmpCod, 0, AV30LegNumero, AV8LiqPeriodo, GXv_decimal2, GXv_char1, GXv_int3, GXv_boolean4) ;
         grossing_up.this.AV32LegSuelImporte = GXv_decimal2[0] ;
         grossing_up.this.AV49tipo_sueldo = GXv_char1[0] ;
         grossing_up.this.AV33LegSuelSec = GXv_int3[0] ;
         grossing_up.this.AV23existe = GXv_boolean4[0] ;
         if ( ! AV23existe )
         {
            AV20Error = httpContext.getMessage( "No existe dato de sueldo para ", "") + GXutil.trim( localUtil.dtoc( AV8LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) ;
            AV34LiqDCalculado = (byte)(0) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV67Pgmname, httpContext.getMessage( "err1 ", "")+AV20Error) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXv_decimal2[0] = AV15base_imp_min ;
         GXv_decimal5[0] = AV14base_imp_max ;
         GXv_char1[0] = AV12auxError ;
         new web.getbaseimpmaxymin(remoteHandle, context).execute( AV16CliCod, AV8LiqPeriodo, "Calculo", false, GXv_decimal2, GXv_decimal5, GXv_char1) ;
         grossing_up.this.AV15base_imp_min = GXv_decimal2[0] ;
         grossing_up.this.AV14base_imp_max = GXv_decimal5[0] ;
         grossing_up.this.AV12auxError = GXv_char1[0] ;
         /* Execute user subroutine: 'DEVOLVER ERROR' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV67Pgmname, httpContext.getMessage( "count ", "")+GXutil.str( AV25grossingup_calculo.size(), 9, 0)) ;
         if ( AV25grossingup_calculo.size() == 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV67Pgmname, "1") ;
            GXv_boolean4[0] = AV31LegSuelBasica ;
            new web.getlegsuelbasica(remoteHandle, context).execute( AV16CliCod, AV19EmpCod, AV30LegNumero, AV33LegSuelSec, AV8LiqPeriodo, GXv_boolean4) ;
            grossing_up.this.AV31LegSuelBasica = GXv_boolean4[0] ;
            if ( AV31LegSuelBasica )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV67Pgmname, "2") ;
               /* Execute user subroutine: 'AGREGAR ITEM' */
               S131 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV67Pgmname, "3") ;
               AV21errorHay = false ;
               GXt_char6 = AV48sueldoConCodigo ;
               GXt_char7 = AV48sueldoConCodigo ;
               GXv_char1[0] = GXt_char7 ;
               new web.concepto_sueldomensual_codigoparam(remoteHandle, context).execute( GXv_char1) ;
               grossing_up.this.GXt_char7 = GXv_char1[0] ;
               GXv_char8[0] = GXt_char6 ;
               new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char7, GXv_char8) ;
               grossing_up.this.GXt_char6 = GXv_char8[0] ;
               AV48sueldoConCodigo = GXt_char6 ;
               GXt_char7 = AV64grossConCodigo ;
               GXt_char6 = AV64grossConCodigo ;
               GXv_char8[0] = GXt_char6 ;
               new web.grossigup_concepto_codigoparam(remoteHandle, context).execute( GXv_char8) ;
               grossing_up.this.GXt_char6 = GXv_char8[0] ;
               GXv_char1[0] = GXt_char7 ;
               new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char6, GXv_char1) ;
               grossing_up.this.GXt_char7 = GXv_char1[0] ;
               AV64grossConCodigo = GXt_char7 ;
               AV26grossingupImportes = DecimalUtil.ZERO ;
               GXv_char8[0] = AV43remuTipoConCod ;
               GXv_char1[0] = AV38noRemuTipoConCod ;
               GXv_char9[0] = AV18descuTipoConCod ;
               new web.gettiposconceptocod(remoteHandle, context).execute( AV16CliCod, GXv_char8, GXv_char1, GXv_char9) ;
               grossing_up.this.AV43remuTipoConCod = GXv_char8[0] ;
               grossing_up.this.AV38noRemuTipoConCod = GXv_char1[0] ;
               grossing_up.this.AV18descuTipoConCod = GXv_char9[0] ;
               AV68GXLvl42 = (byte)(0) ;
               /* Using cursor P02E22 */
               pr_default.execute(0, new Object[] {Integer.valueOf(AV16CliCod), Short.valueOf(AV19EmpCod), Integer.valueOf(AV36LiqNro), AV48sueldoConCodigo, AV64grossConCodigo});
               while ( (pr_default.getStatus(0) != 101) )
               {
                  A394DConCodigo = P02E22_A394DConCodigo[0] ;
                  A31LiqNro = P02E22_A31LiqNro[0] ;
                  A1EmpCod = P02E22_A1EmpCod[0] ;
                  A3CliCod = P02E22_A3CliCod[0] ;
                  A464DTipoConCod = P02E22_A464DTipoConCod[0] ;
                  A468DSubTipoConCod1 = P02E22_A468DSubTipoConCod1[0] ;
                  n468DSubTipoConCod1 = P02E22_n468DSubTipoConCod1[0] ;
                  A393DConDescrip = P02E22_A393DConDescrip[0] ;
                  A507LiqDCalculado = P02E22_A507LiqDCalculado[0] ;
                  A275LiqDImpCalcu = P02E22_A275LiqDImpCalcu[0] ;
                  n275LiqDImpCalcu = P02E22_n275LiqDImpCalcu[0] ;
                  A6LegNumero = P02E22_A6LegNumero[0] ;
                  A81LiqDSecuencial = P02E22_A81LiqDSecuencial[0] ;
                  AV68GXLvl42 = (byte)(1) ;
                  GXv_boolean4[0] = AV47SubTDescuLey ;
                  new web.gettipodescuentoley(remoteHandle, context).execute( A464DTipoConCod, A468DSubTipoConCod1, GXv_boolean4) ;
                  grossing_up.this.AV47SubTDescuLey = GXv_boolean4[0] ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV67Pgmname, "4") ;
                  if ( ! AV47SubTDescuLey )
                  {
                     AV56DTipoConCod = A464DTipoConCod ;
                     AV57DConDescrip = A393DConDescrip ;
                     if ( A507LiqDCalculado == 1 )
                     {
                        AV46resolverOK = true ;
                        AV44resImportes = A275LiqDImpCalcu ;
                     }
                     else
                     {
                        GXv_decimal5[0] = DecimalUtil.doubleToDec(0) ;
                        GXv_char9[0] = AV45resolverError ;
                        GXv_decimal2[0] = AV44resImportes ;
                        GXv_char8[0] = "" ;
                        new web.previsualizacionnovedad(remoteHandle, context).execute( AV16CliCod, AV19EmpCod, AV30LegNumero, A394DConCodigo, DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(0), AV8LiqPeriodo, GXutil.eomdate( AV8LiqPeriodo), true, GXv_decimal5, GXv_char9, GXv_decimal2, GXv_char8) ;
                        grossing_up.this.AV45resolverError = GXv_char9[0] ;
                        grossing_up.this.AV44resImportes = GXv_decimal2[0] ;
                        new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV67Pgmname, GXutil.trim( A393DConDescrip)+httpContext.getMessage( " &&resImportes ", "")+GXutil.trim( GXutil.str( AV44resImportes, 14, 2))) ;
                        if ( ! (GXutil.strcmp("", AV45resolverError)==0) )
                        {
                           AV46resolverOK = false ;
                        }
                        else
                        {
                           AV46resolverOK = true ;
                        }
                     }
                     if ( ! AV46resolverOK )
                     {
                        AV21errorHay = true ;
                     }
                     else
                     {
                        AV58ConCodigo = A394DConCodigo ;
                        /* Execute user subroutine: 'ACUMULA' */
                        S141 ();
                        if ( returnInSub )
                        {
                           pr_default.close(0);
                           returnInSub = true;
                           cleanup();
                           if (true) return;
                        }
                     }
                  }
                  pr_default.readNext(0);
               }
               pr_default.close(0);
               if ( AV68GXLvl42 == 0 )
               {
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV67Pgmname, httpContext.getMessage( "none", "")) ;
               }
               new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV67Pgmname, "5") ;
               if ( AV21errorHay )
               {
                  AV37multiplicador = AV39parmMultiplicador ;
                  if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV37multiplicador)==0) )
                  {
                     AV26grossingupImportes = AV26grossingupImportes.multiply(AV37multiplicador) ;
                     /* Execute user subroutine: 'PUNTO' */
                     S111 ();
                     if ( returnInSub )
                     {
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                     AV35LiqDLog += httpContext.getMessage( "Incrementa a ", "") + GXutil.trim( GXutil.str( AV26grossingupImportes, 14, 2)) + httpContext.getMessage( " usando multiplicador ", "") + GXutil.trim( GXutil.str( AV37multiplicador, 6, 4)) ;
                  }
               }
               /* Execute user subroutine: 'AGREGAR ITEM' */
               S131 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
         }
         else
         {
            AV54ultResultado = ((web.Sdtgrossingup_calculo_grossingup_calculoItem)AV25grossingup_calculo.elementAt(-1+AV25grossingup_calculo.size())).getgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Resultado() ;
            AV53ultNeto = ((web.Sdtgrossingup_calculo_grossingup_calculoItem)AV25grossingup_calculo.elementAt(-1+AV25grossingup_calculo.size())).getgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Neto() ;
            AV51ultCalculo = ((web.Sdtgrossingup_calculo_grossingup_calculoItem)AV25grossingup_calculo.elementAt(-1+AV25grossingup_calculo.size())).getgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Calculo() ;
            AV63ultFalto = ((web.Sdtgrossingup_calculo_grossingup_calculoItem)AV25grossingup_calculo.elementAt(-1+AV25grossingup_calculo.size())).getgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Falta() ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV67Pgmname, httpContext.getMessage( "&ultResultado ", "")+AV54ultResultado) ;
            AV26grossingupImportes = AV51ultCalculo ;
            AV35LiqDLog = httpContext.getMessage( "Inicializa con último cálculo ", "") + GXutil.trim( GXutil.str( AV51ultCalculo, 14, 2)) ;
            if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63ultFalto)==0) )
            {
               if ( GXutil.strcmp(AV54ultResultado, httpContext.getMessage( "Mayor", "")) == 0 )
               {
                  AV37multiplicador = DecimalUtil.doubleToDec(1).subtract(AV39parmMultiplicador) ;
               }
               else
               {
                  AV37multiplicador = DecimalUtil.doubleToDec(1).add(AV39parmMultiplicador) ;
               }
            }
            else
            {
               AV37multiplicador = AV63ultFalto ;
               if ( ( GXutil.strcmp(AV54ultResultado, httpContext.getMessage( "Menor", "")) == 0 ) && ( AV25grossingup_calculo.size() == 1 ) )
               {
                  AV37multiplicador = AV37multiplicador.add(AV39parmMultiplicador) ;
               }
            }
            AV35LiqDLog += httpContext.getMessage( ". Multiplica por ", "") + GXutil.trim( GXutil.str( AV37multiplicador, 6, 4)) ;
            AV26grossingupImportes = AV26grossingupImportes.multiply(AV37multiplicador) ;
            /* Execute user subroutine: 'AGREGAR ITEM' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         AV9websession.setValue(AV29keyPalabra, AV25grossingup_calculo.toJSonString(false));
         AV35LiqDLog += httpContext.getMessage( ". Sesión: ", "") + AV25grossingup_calculo.toJSonString(false) ;
      }
      if ( AV26grossingupImportes.doubleValue() < 0 )
      {
         AV26grossingupImportes = DecimalUtil.doubleToDec(0) ;
         AV35LiqDLog += httpContext.getMessage( ". Establece en cero por quedar negativo", "") ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV67Pgmname, httpContext.getMessage( "liqdlog ", "")+GXutil.trim( AV35LiqDLog)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV67Pgmname, httpContext.getMessage( "fin ", "")+AV25grossingup_calculo.toJSonString(false)) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'PUNTO' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV35LiqDLog)==0) )
      {
         AV35LiqDLog += ". " ;
      }
   }

   public void S121( )
   {
      /* 'DEVOLVER ERROR' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV12auxError)==0) )
      {
         AV34LiqDCalculado = (byte)(0) ;
         AV20Error = GXutil.trim( AV12auxError) ;
         returnInSub = true;
         if (true) return;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV67Pgmname, httpContext.getMessage( "errx ", "")+AV20Error) ;
      }
   }

   public void S131( )
   {
      /* 'AGREGAR ITEM' Routine */
      returnInSub = false ;
      AV28item = (web.Sdtgrossingup_calculo_grossingup_calculoItem)new web.Sdtgrossingup_calculo_grossingup_calculoItem(remoteHandle, context);
      AV28item.setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Calculo( AV26grossingupImportes );
      AV28item.setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Neto( DecimalUtil.doubleToDec(0) );
      AV28item.setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Resultado( "" );
      AV28item.setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Multiplicador( AV37multiplicador );
      AV28item.setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Descuentosexcluidos( AV60descuentosExcluidosImportes );
      AV28item.setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Liqdlog( GXutil.trim( AV35LiqDLog) );
      AV25grossingup_calculo.add(AV28item, 0);
      new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV67Pgmname, httpContext.getMessage( "agregó item hay ", "")+GXutil.trim( GXutil.str( AV25grossingup_calculo.size(), 9, 0))) ;
   }

   public void S141( )
   {
      /* 'ACUMULA' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV56DTipoConCod, AV18descuTipoConCod) == 0 )
      {
         if ( AV44resImportes.doubleValue() > 0 )
         {
            if ( ! ((AV22excluirConCodigo.indexof(GXutil.rtrim( AV58ConCodigo))>0)) )
            {
               AV26grossingupImportes = AV26grossingupImportes.add(AV44resImportes) ;
               /* Execute user subroutine: 'PUNTO' */
               S111 ();
               if (returnInSub) return;
               AV35LiqDLog += httpContext.getMessage( "2)Suma ", "") + GXutil.trim( GXutil.str( AV44resImportes, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( AV57DConDescrip) ;
            }
            else
            {
               AV60descuentosExcluidosImportes = AV60descuentosExcluidosImportes.add(AV44resImportes) ;
            }
         }
         else
         {
            if ( ! ((AV22excluirConCodigo.indexof(GXutil.rtrim( AV58ConCodigo))>0)) )
            {
               if ( AV44resImportes.doubleValue() < 0 )
               {
                  AV26grossingupImportes = AV26grossingupImportes.subtract(AV44resImportes) ;
                  /* Execute user subroutine: 'PUNTO' */
                  S111 ();
                  if (returnInSub) return;
                  AV35LiqDLog += httpContext.getMessage( "2)Resta ", "") + GXutil.trim( GXutil.str( AV44resImportes, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( AV57DConDescrip) ;
               }
            }
         }
      }
      else
      {
         if ( AV44resImportes.doubleValue() < 0 )
         {
            AV44resImportes = AV44resImportes.multiply(DecimalUtil.doubleToDec(-1)) ;
            if ( ! ((AV22excluirConCodigo.indexof(GXutil.rtrim( AV58ConCodigo))>0)) )
            {
               AV26grossingupImportes = AV26grossingupImportes.add(AV44resImportes) ;
               /* Execute user subroutine: 'PUNTO' */
               S111 ();
               if (returnInSub) return;
               AV35LiqDLog += httpContext.getMessage( "3)Suma ", "") + GXutil.trim( GXutil.str( AV44resImportes, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( AV57DConDescrip) ;
            }
            else
            {
               AV60descuentosExcluidosImportes = AV60descuentosExcluidosImportes.add(AV44resImportes) ;
            }
         }
         else
         {
            if ( ! ((AV22excluirConCodigo.indexof(GXutil.rtrim( AV58ConCodigo))>0)) )
            {
               if ( AV44resImportes.doubleValue() > 0 )
               {
                  AV26grossingupImportes = AV26grossingupImportes.subtract(AV44resImportes) ;
                  /* Execute user subroutine: 'PUNTO' */
                  S111 ();
                  if (returnInSub) return;
                  AV35LiqDLog += httpContext.getMessage( "3)Resta ", "") + GXutil.trim( GXutil.str( AV44resImportes, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( AV57DConDescrip) ;
               }
            }
         }
      }
   }

   protected void cleanup( )
   {
      this.aP7[0] = grossing_up.this.AV26grossingupImportes;
      this.aP8[0] = grossing_up.this.AV35LiqDLog;
      this.aP9[0] = grossing_up.this.AV20Error;
      this.aP10[0] = grossing_up.this.AV34LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV26grossingupImportes = DecimalUtil.ZERO ;
      AV35LiqDLog = "" ;
      AV20Error = "" ;
      AV67Pgmname = "" ;
      AV29keyPalabra = "" ;
      AV25grossingup_calculo = new GXBaseCollection<web.Sdtgrossingup_calculo_grossingup_calculoItem>(web.Sdtgrossingup_calculo_grossingup_calculoItem.class, "grossingup_calculoItem", "PayDay", remoteHandle);
      AV9websession = httpContext.getWebSession();
      AV40ParmValue = "" ;
      AV22excluirConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39parmMultiplicador = DecimalUtil.ZERO ;
      AV32LegSuelImporte = DecimalUtil.ZERO ;
      AV49tipo_sueldo = "" ;
      GXv_int3 = new short[1] ;
      AV15base_imp_min = DecimalUtil.ZERO ;
      AV14base_imp_max = DecimalUtil.ZERO ;
      AV12auxError = "" ;
      AV48sueldoConCodigo = "" ;
      AV64grossConCodigo = "" ;
      GXt_char7 = "" ;
      GXt_char6 = "" ;
      AV43remuTipoConCod = "" ;
      AV38noRemuTipoConCod = "" ;
      GXv_char1 = new String[1] ;
      AV18descuTipoConCod = "" ;
      scmdbuf = "" ;
      P02E22_A394DConCodigo = new String[] {""} ;
      P02E22_A31LiqNro = new int[1] ;
      P02E22_A1EmpCod = new short[1] ;
      P02E22_A3CliCod = new int[1] ;
      P02E22_A464DTipoConCod = new String[] {""} ;
      P02E22_A468DSubTipoConCod1 = new String[] {""} ;
      P02E22_n468DSubTipoConCod1 = new boolean[] {false} ;
      P02E22_A393DConDescrip = new String[] {""} ;
      P02E22_A507LiqDCalculado = new byte[1] ;
      P02E22_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02E22_n275LiqDImpCalcu = new boolean[] {false} ;
      P02E22_A6LegNumero = new int[1] ;
      P02E22_A81LiqDSecuencial = new int[1] ;
      A394DConCodigo = "" ;
      A464DTipoConCod = "" ;
      A468DSubTipoConCod1 = "" ;
      A393DConDescrip = "" ;
      A275LiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_boolean4 = new boolean[1] ;
      AV56DTipoConCod = "" ;
      AV57DConDescrip = "" ;
      AV44resImportes = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      AV45resolverError = "" ;
      GXv_char9 = new String[1] ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      GXv_char8 = new String[1] ;
      AV58ConCodigo = "" ;
      AV37multiplicador = DecimalUtil.ZERO ;
      AV54ultResultado = "" ;
      AV53ultNeto = DecimalUtil.ZERO ;
      AV51ultCalculo = DecimalUtil.ZERO ;
      AV63ultFalto = DecimalUtil.ZERO ;
      AV28item = new web.Sdtgrossingup_calculo_grossingup_calculoItem(remoteHandle, context);
      AV60descuentosExcluidosImportes = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.grossing_up__default(),
         new Object[] {
             new Object[] {
            P02E22_A394DConCodigo, P02E22_A31LiqNro, P02E22_A1EmpCod, P02E22_A3CliCod, P02E22_A464DTipoConCod, P02E22_A468DSubTipoConCod1, P02E22_n468DSubTipoConCod1, P02E22_A393DConDescrip, P02E22_A507LiqDCalculado, P02E22_A275LiqDImpCalcu,
            P02E22_n275LiqDImpCalcu, P02E22_A6LegNumero, P02E22_A81LiqDSecuencial
            }
         }
      );
      AV67Pgmname = "grossing_up" ;
      /* GeneXus formulas. */
      AV67Pgmname = "grossing_up" ;
      Gx_err = (short)(0) ;
   }

   private byte AV34LiqDCalculado ;
   private byte AV68GXLvl42 ;
   private byte A507LiqDCalculado ;
   private short AV19EmpCod ;
   private short AV33LegSuelSec ;
   private short GXv_int3[] ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV16CliCod ;
   private int AV30LegNumero ;
   private int AV36LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV26grossingupImportes ;
   private java.math.BigDecimal AV39parmMultiplicador ;
   private java.math.BigDecimal AV32LegSuelImporte ;
   private java.math.BigDecimal AV15base_imp_min ;
   private java.math.BigDecimal AV14base_imp_max ;
   private java.math.BigDecimal A275LiqDImpCalcu ;
   private java.math.BigDecimal AV44resImportes ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private java.math.BigDecimal AV37multiplicador ;
   private java.math.BigDecimal AV53ultNeto ;
   private java.math.BigDecimal AV51ultCalculo ;
   private java.math.BigDecimal AV63ultFalto ;
   private java.math.BigDecimal AV60descuentosExcluidosImportes ;
   private String AV50TLiqCod ;
   private String AV41ProcesoLiquidacion ;
   private String AV67Pgmname ;
   private String AV29keyPalabra ;
   private String AV49tipo_sueldo ;
   private String AV48sueldoConCodigo ;
   private String AV64grossConCodigo ;
   private String GXt_char7 ;
   private String GXt_char6 ;
   private String AV43remuTipoConCod ;
   private String AV38noRemuTipoConCod ;
   private String GXv_char1[] ;
   private String AV18descuTipoConCod ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String A464DTipoConCod ;
   private String A468DSubTipoConCod1 ;
   private String AV56DTipoConCod ;
   private String GXv_char9[] ;
   private String GXv_char8[] ;
   private String AV58ConCodigo ;
   private String AV54ultResultado ;
   private java.util.Date AV8LiqPeriodo ;
   private boolean AV23existe ;
   private boolean returnInSub ;
   private boolean AV31LegSuelBasica ;
   private boolean AV21errorHay ;
   private boolean n468DSubTipoConCod1 ;
   private boolean n275LiqDImpCalcu ;
   private boolean AV47SubTDescuLey ;
   private boolean GXv_boolean4[] ;
   private boolean AV46resolverOK ;
   private String AV35LiqDLog ;
   private String AV40ParmValue ;
   private String AV20Error ;
   private String AV12auxError ;
   private String A393DConDescrip ;
   private String AV57DConDescrip ;
   private String AV45resolverError ;
   private com.genexus.webpanels.WebSession AV9websession ;
   private byte[] aP10 ;
   private java.math.BigDecimal[] aP7 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P02E22_A394DConCodigo ;
   private int[] P02E22_A31LiqNro ;
   private short[] P02E22_A1EmpCod ;
   private int[] P02E22_A3CliCod ;
   private String[] P02E22_A464DTipoConCod ;
   private String[] P02E22_A468DSubTipoConCod1 ;
   private boolean[] P02E22_n468DSubTipoConCod1 ;
   private String[] P02E22_A393DConDescrip ;
   private byte[] P02E22_A507LiqDCalculado ;
   private java.math.BigDecimal[] P02E22_A275LiqDImpCalcu ;
   private boolean[] P02E22_n275LiqDImpCalcu ;
   private int[] P02E22_A6LegNumero ;
   private int[] P02E22_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV22excluirConCodigo ;
   private GXBaseCollection<web.Sdtgrossingup_calculo_grossingup_calculoItem> AV25grossingup_calculo ;
   private web.Sdtgrossingup_calculo_grossingup_calculoItem AV28item ;
}

final  class grossing_up__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02E22", "SELECT DConCodigo, LiqNro, EmpCod, CliCod, DTipoConCod, DSubTipoConCod1, DConDescrip, LiqDCalculado, LiqDImpCalcu, LegNumero, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ?) AND (DConCodigo <> ( ?)) AND (DConCodigo <> ( ?)) ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((byte[]) buf[8])[0] = rslt.getByte(8);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,2);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((int[]) buf[11])[0] = rslt.getInt(10);
               ((int[]) buf[12])[0] = rslt.getInt(11);
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
               stmt.setString(4, (String)parms[3], 10);
               stmt.setString(5, (String)parms[4], 10);
               return;
      }
   }

}

