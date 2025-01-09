package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class confirmarimportacionliquidacionlsd2 extends GXProcedure
{
   public confirmarimportacionliquidacionlsd2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( confirmarimportacionliquidacionlsd2.class ), "" );
   }

   public confirmarimportacionliquidacionlsd2( int remoteHandle ,
                                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             short aP2 )
   {
      confirmarimportacionliquidacionlsd2.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String[] aP3 )
   {
      confirmarimportacionliquidacionlsd2.this.AV8CliCod = aP0;
      confirmarimportacionliquidacionlsd2.this.AV9EmpCod = aP1;
      confirmarimportacionliquidacionlsd2.this.AV36ImpLiqSec = aP2;
      confirmarimportacionliquidacionlsd2.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV153daemonUUID = httpContext.getMessage( "IMPORTACION", "") ;
      AV87liquidaciones_generadas.clear();
      AV12ahora = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      GXt_char1 = AV119ParmValue ;
      GXt_char2 = AV119ParmValue ;
      GXv_char3[0] = GXt_char2 ;
      new web.liquidarauxparalelos_param(remoteHandle, context).execute( GXv_char3) ;
      confirmarimportacionliquidacionlsd2.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char4) ;
      confirmarimportacionliquidacionlsd2.this.GXt_char1 = GXv_char4[0] ;
      AV119ParmValue = GXt_char1 ;
      if ( (GXutil.strcmp("", AV119ParmValue)==0) )
      {
         AV119ParmValue = httpContext.getMessage( "false", "") ;
      }
      AV120segundoPlano = GXutil.boolval( AV119ParmValue) ;
      AV101resolver = false ;
      GXt_char2 = AV100quincenaTLiqCod ;
      GXt_char1 = AV100quincenaTLiqCod ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqquincena_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      confirmarimportacionliquidacionlsd2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      confirmarimportacionliquidacionlsd2.this.GXt_char2 = GXv_char3[0] ;
      AV100quincenaTLiqCod = GXt_char2 ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV162Pgmname, httpContext.getMessage( "hola", "")) ;
      /* Using cursor P027X2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Short.valueOf(AV36ImpLiqSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk27X2 = false ;
         A3CliCod = P027X2_A3CliCod[0] ;
         A1EmpCod = P027X2_A1EmpCod[0] ;
         A88ImpLiqSec = P027X2_A88ImpLiqSec[0] ;
         A666ImpLiqDetConCod = P027X2_A666ImpLiqDetConCod[0] ;
         A713ImpLiqDetConSis = P027X2_A713ImpLiqDetConSis[0] ;
         A716ImpLiqDetImpNum = P027X2_A716ImpLiqDetImpNum[0] ;
         A670ImpLiqDetSigno = P027X2_A670ImpLiqDetSigno[0] ;
         A715ImpLiqDetCantNum = P027X2_A715ImpLiqDetCantNum[0] ;
         A90ImpLiqDetSec = P027X2_A90ImpLiqDetSec[0] ;
         A663ImpLiqDetCUIL = P027X2_A663ImpLiqDetCUIL[0] ;
         A662ImpLiqDetLiqN = P027X2_A662ImpLiqDetLiqN[0] ;
         A661ImpLiqDetPer = P027X2_A661ImpLiqDetPer[0] ;
         A709ImpLiqDetError = P027X2_A709ImpLiqDetError[0] ;
         A718ImpLiqDetLiqClase = P027X2_A718ImpLiqDetLiqClase[0] ;
         AV122item = (web.Sdtimportacion_sdt_importacion_sdtItem)new web.Sdtimportacion_sdt_importacion_sdtItem(remoteHandle, context);
         AV139itemJornal = (web.Sdtimportacion_sdt_importacion_sdtItem)new web.Sdtimportacion_sdt_importacion_sdtItem(remoteHandle, context);
         AV140mensualHay = false ;
         AV141jornalHay = false ;
         AV146pagoFecha = GXutil.nullDate() ;
         AV150Sec = (short)(AV150Sec+1) ;
         AV122item.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Impliqdetper( A661ImpLiqDetPer );
         AV81LiqPerAno = (short)(GXutil.lval( GXutil.substring( A661ImpLiqDetPer, 1, 4))) ;
         AV83LiqPerMes = (byte)(GXutil.lval( GXutil.substring( A661ImpLiqDetPer, 5, 2))) ;
         AV122item.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperano( AV81LiqPerAno );
         AV122item.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqpermes( AV83LiqPerMes );
         AV122item.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo( localUtil.ymdtod( AV81LiqPerAno, AV83LiqPerMes, 1) );
         AV122item.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Sec( AV150Sec );
         AV139itemJornal.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Impliqdetper( A661ImpLiqDetPer );
         AV139itemJornal.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperano( AV81LiqPerAno );
         AV139itemJornal.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqpermes( AV83LiqPerMes );
         AV139itemJornal.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo( localUtil.ymdtod( AV81LiqPerAno, AV83LiqPerMes, 1) );
         AV139itemJornal.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Sec( AV150Sec );
         while ( (pr_default.getStatus(0) != 101) && ( P027X2_A3CliCod[0] == A3CliCod ) && ( P027X2_A1EmpCod[0] == A1EmpCod ) && ( P027X2_A88ImpLiqSec[0] == A88ImpLiqSec ) && ( GXutil.strcmp(P027X2_A661ImpLiqDetPer[0], A661ImpLiqDetPer) == 0 ) )
         {
            if ( ! ( ( GXutil.strcmp(P027X2_A662ImpLiqDetLiqN[0], A662ImpLiqDetLiqN) == 0 ) ) )
            {
               if (true) break;
            }
            brk27X2 = false ;
            A666ImpLiqDetConCod = P027X2_A666ImpLiqDetConCod[0] ;
            A713ImpLiqDetConSis = P027X2_A713ImpLiqDetConSis[0] ;
            A716ImpLiqDetImpNum = P027X2_A716ImpLiqDetImpNum[0] ;
            A670ImpLiqDetSigno = P027X2_A670ImpLiqDetSigno[0] ;
            A715ImpLiqDetCantNum = P027X2_A715ImpLiqDetCantNum[0] ;
            A90ImpLiqDetSec = P027X2_A90ImpLiqDetSec[0] ;
            A663ImpLiqDetCUIL = P027X2_A663ImpLiqDetCUIL[0] ;
            if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV146pagoFecha)) )
            {
               GXv_Sdtsdt_LiqLegLSD5[0] = AV130sdt_LiqLegLSD;
               new web.getdatosliqleglsd(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, A88ImpLiqSec, (long)(DecimalUtil.decToDouble(CommonUtil.decimalVal( A663ImpLiqDetCUIL, "."))), GXv_Sdtsdt_LiqLegLSD5) ;
               AV130sdt_LiqLegLSD = GXv_Sdtsdt_LiqLegLSD5[0] ;
               AV146pagoFecha = AV130sdt_LiqLegLSD.getgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag() ;
            }
            AV123legajoItem = (web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem)new web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem(remoteHandle, context);
            AV137legajoJornalItem = (web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem)new web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem(remoteHandle, context);
            AV134netoImportes = DecimalUtil.doubleToDec(0) ;
            GXv_int6[0] = AV65LegNumero ;
            new web.obtenerlegajoporcuit(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, (long)(DecimalUtil.decToDouble(CommonUtil.decimalVal( A663ImpLiqDetCUIL, "."))), GXv_int6) ;
            confirmarimportacionliquidacionlsd2.this.AV65LegNumero = GXv_int6[0] ;
            GXv_int7[0] = AV46LegClase ;
            new web.getlegajoclase(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV65LegNumero, GXv_int7) ;
            confirmarimportacionliquidacionlsd2.this.AV46LegClase = GXv_int7[0] ;
            if ( AV46LegClase == 2 )
            {
               AV141jornalHay = true ;
               AV137legajoJornalItem.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero( AV65LegNumero );
            }
            else
            {
               AV140mensualHay = true ;
               AV123legajoItem.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero( AV65LegNumero );
            }
            while ( (pr_default.getStatus(0) != 101) && ( P027X2_A3CliCod[0] == A3CliCod ) && ( P027X2_A1EmpCod[0] == A1EmpCod ) && ( P027X2_A88ImpLiqSec[0] == A88ImpLiqSec ) && ( GXutil.strcmp(P027X2_A661ImpLiqDetPer[0], A661ImpLiqDetPer) == 0 ) )
            {
               if ( ! ( ( GXutil.strcmp(P027X2_A662ImpLiqDetLiqN[0], A662ImpLiqDetLiqN) == 0 ) && ( GXutil.strcmp(P027X2_A663ImpLiqDetCUIL[0], A663ImpLiqDetCUIL) == 0 ) ) )
               {
                  if (true) break;
               }
               brk27X2 = false ;
               A666ImpLiqDetConCod = P027X2_A666ImpLiqDetConCod[0] ;
               A713ImpLiqDetConSis = P027X2_A713ImpLiqDetConSis[0] ;
               A716ImpLiqDetImpNum = P027X2_A716ImpLiqDetImpNum[0] ;
               A670ImpLiqDetSigno = P027X2_A670ImpLiqDetSigno[0] ;
               A715ImpLiqDetCantNum = P027X2_A715ImpLiqDetCantNum[0] ;
               A90ImpLiqDetSec = P027X2_A90ImpLiqDetSec[0] ;
               AV124itemDetalle = (web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem)new web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem(remoteHandle, context);
               AV138itemJornalDetalle = (web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem)new web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem(remoteHandle, context);
               GXv_char4[0] = AV124itemDetalle.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqconextdescrip() ;
               new web.getdescripexternaimportacionafip(remoteHandle, context).execute( A3CliCod, A1EmpCod, A88ImpLiqSec, A666ImpLiqDetConCod, GXv_char4) ;
               AV124itemDetalle.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqconextdescrip( GXv_char4[0] );
               if ( AV46LegClase == 2 )
               {
                  AV138itemJornalDetalle.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetconsis( A713ImpLiqDetConSis );
               }
               else
               {
                  AV124itemDetalle.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetconsis( A713ImpLiqDetConSis );
               }
               AV114ImpLiqDetImpNum = A716ImpLiqDetImpNum ;
               AV21ConCodigo = A713ImpLiqDetConSis ;
               GXv_char4[0] = AV115TipoConCod ;
               new web.conceptogettipo(remoteHandle, context).execute( AV8CliCod, AV21ConCodigo, GXv_char4) ;
               confirmarimportacionliquidacionlsd2.this.AV115TipoConCod = GXv_char4[0] ;
               if ( ( GXutil.strcmp(A670ImpLiqDetSigno, httpContext.getMessage( "D", "")) == 0 ) && ( GXutil.strcmp(AV115TipoConCod, "DES_ARG") != 0 ) )
               {
                  AV114ImpLiqDetImpNum = AV114ImpLiqDetImpNum.multiply(DecimalUtil.doubleToDec(-1)) ;
               }
               if ( GXutil.strcmp(A670ImpLiqDetSigno, httpContext.getMessage( "D", "")) == 0 )
               {
                  AV134netoImportes = AV134netoImportes.subtract(A716ImpLiqDetImpNum) ;
               }
               else
               {
                  AV134netoImportes = AV134netoImportes.add(A716ImpLiqDetImpNum) ;
               }
               if ( AV46LegClase == 2 )
               {
                  AV138itemJornalDetalle.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetimpnum( AV114ImpLiqDetImpNum );
                  AV138itemJornalDetalle.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetsigno( A670ImpLiqDetSigno );
                  AV138itemJornalDetalle.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetcantnum( A715ImpLiqDetCantNum );
                  AV137legajoJornalItem.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle().add(AV138itemJornalDetalle, 0);
               }
               else
               {
                  AV124itemDetalle.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetimpnum( AV114ImpLiqDetImpNum );
                  AV124itemDetalle.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetsigno( A670ImpLiqDetSigno );
                  AV124itemDetalle.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetcantnum( A715ImpLiqDetCantNum );
                  AV123legajoItem.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle().add(AV124itemDetalle, 0);
               }
               brk27X2 = true ;
               pr_default.readNext(0);
            }
            GXv_boolean8[0] = AV135duplicaEs ;
            GXv_int6[0] = AV136dupliLiqnro ;
            new web.validarliqdupliporimporte(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV134netoImportes, 0, AV65LegNumero, AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo(), false, GXv_boolean8, GXv_int6) ;
            confirmarimportacionliquidacionlsd2.this.AV135duplicaEs = GXv_boolean8[0] ;
            confirmarimportacionliquidacionlsd2.this.AV136dupliLiqnro = GXv_int6[0] ;
            if ( ! AV135duplicaEs )
            {
               if ( AV46LegClase == 2 )
               {
                  AV166GXV1 = 1 ;
                  while ( AV166GXV1 <= AV142importacion_sdt_jornales.size() )
                  {
                     AV149item2 = (web.Sdtimportacion_sdt_importacion_sdtItem)((web.Sdtimportacion_sdt_importacion_sdtItem)AV142importacion_sdt_jornales.elementAt(-1+AV166GXV1));
                     if ( AV149item2.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Sec() != AV139itemJornal.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Sec() )
                     {
                        AV167GXV2 = 1 ;
                        while ( AV167GXV2 <= AV149item2.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos().size() )
                        {
                           AV148legajoItem2 = (web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem)((web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem)AV149item2.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos().elementAt(-1+AV167GXV2));
                           if ( ( AV148legajoItem2.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero() == AV65LegNumero ) && ( DecimalUtil.compareTo(AV148legajoItem2.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Netoimportes(), AV134netoImportes) == 0 ) )
                           {
                              AV135duplicaEs = true ;
                              if (true) break;
                           }
                           AV167GXV2 = (int)(AV167GXV2+1) ;
                        }
                     }
                     if ( AV135duplicaEs )
                     {
                        if (true) break;
                     }
                     AV166GXV1 = (int)(AV166GXV1+1) ;
                  }
               }
               else
               {
                  AV168GXV3 = 1 ;
                  while ( AV168GXV3 <= AV121importacion_sdt.size() )
                  {
                     AV149item2 = (web.Sdtimportacion_sdt_importacion_sdtItem)((web.Sdtimportacion_sdt_importacion_sdtItem)AV121importacion_sdt.elementAt(-1+AV168GXV3));
                     if ( AV149item2.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Sec() != AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Sec() )
                     {
                        AV169GXV4 = 1 ;
                        while ( AV169GXV4 <= AV149item2.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos().size() )
                        {
                           AV148legajoItem2 = (web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem)((web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem)AV149item2.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos().elementAt(-1+AV169GXV4));
                           if ( ( AV148legajoItem2.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero() == AV65LegNumero ) && ( DecimalUtil.compareTo(AV148legajoItem2.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Netoimportes(), AV134netoImportes) == 0 ) )
                           {
                              AV135duplicaEs = true ;
                              if (true) break;
                           }
                           AV169GXV4 = (int)(AV169GXV4+1) ;
                        }
                     }
                     if ( AV135duplicaEs )
                     {
                        if (true) break;
                     }
                     AV168GXV3 = (int)(AV168GXV3+1) ;
                  }
               }
               if ( ! AV135duplicaEs )
               {
                  if ( AV46LegClase == 2 )
                  {
                     AV137legajoJornalItem.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Netoimportes( AV134netoImportes );
                     AV139itemJornal.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos().add(AV137legajoJornalItem, 0);
                  }
                  else
                  {
                     AV123legajoItem.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Netoimportes( AV134netoImportes );
                     AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos().add(AV123legajoItem, 0);
                  }
                  AV147coll_ImpLiqLSDCuil.add((long)(DecimalUtil.decToDouble(CommonUtil.decimalVal( A663ImpLiqDetCUIL, "."))), 0);
               }
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV162Pgmname, httpContext.getMessage( "asdf2", "")) ;
            if ( ! brk27X2 )
            {
               brk27X2 = true ;
               pr_default.readNext(0);
            }
         }
         AV122item.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqfrecpag( (byte)(1) );
         AV122item.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqtipotarifa( "P" );
         AV139itemJornal.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqfrecpag( (byte)(2) );
         AV139itemJornal.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqtipotarifa( "H" );
         AV36ImpLiqSec = A88ImpLiqSec ;
         AV35ImpLiqLSDSec = A90ImpLiqDetSec ;
         AV33ImpLiqDetLiqClase = A718ImpLiqDetLiqClase ;
         AV116ImpLiqDetLiqN = A662ImpLiqDetLiqN ;
         AV118ImpLiqDetPer = A661ImpLiqDetPer ;
         /* Execute user subroutine: 'BUSCAR TIPO DE LIQUIDACION' */
         S111 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV11LiqPerPalabra = "" ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV162Pgmname, httpContext.getMessage( "mensualhay ", "")+GXutil.trim( GXutil.booltostr( AV140mensualHay))+httpContext.getMessage( " jornalhay ", "")+GXutil.trim( GXutil.booltostr( AV141jornalHay))) ;
         if ( AV140mensualHay )
         {
            if ( (GXutil.strcmp("", AV110TLiqCod)==0) )
            {
               GXt_char2 = AV110TLiqCod ;
               GXt_char1 = AV110TLiqCod ;
               GXv_char4[0] = GXt_char1 ;
               new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char4) ;
               confirmarimportacionliquidacionlsd2.this.GXt_char1 = GXv_char4[0] ;
               GXv_char3[0] = GXt_char2 ;
               new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
               confirmarimportacionliquidacionlsd2.this.GXt_char2 = GXv_char3[0] ;
               AV110TLiqCod = GXt_char2 ;
            }
            AV122item.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod( AV110TLiqCod );
            AV122item.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqdescrip( httpContext.getMessage( "Importación de Liquidación ", "")+GXutil.trim( A661ImpLiqDetPer)+" / "+GXutil.trim( A662ImpLiqDetLiqN) );
            GXv_char4[0] = AV11LiqPerPalabra ;
            GXv_char3[0] = AV79LiqNombre ;
            new web.armaliqnombre(remoteHandle, context).execute( AV8CliCod, AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo(), GXv_char4, AV110TLiqCod, "E", AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqfrecpag(), GXv_char3) ;
            confirmarimportacionliquidacionlsd2.this.AV11LiqPerPalabra = GXv_char4[0] ;
            confirmarimportacionliquidacionlsd2.this.AV79LiqNombre = GXv_char3[0] ;
            AV79LiqNombre += httpContext.getMessage( " (importada)", "") ;
            AV122item.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnombre( AV79LiqNombre );
            AV121importacion_sdt.add(AV122item, 0);
         }
         if ( AV141jornalHay )
         {
            if ( (GXutil.strcmp("", AV110TLiqCod)==0) )
            {
               if ( GXutil.day( AV146pagoFecha) <= 10 )
               {
                  GXt_char2 = AV110TLiqCod ;
                  GXt_char1 = AV110TLiqCod ;
                  GXv_char4[0] = GXt_char1 ;
                  new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char4) ;
                  confirmarimportacionliquidacionlsd2.this.GXt_char1 = GXv_char4[0] ;
                  GXv_char3[0] = GXt_char2 ;
                  new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
                  confirmarimportacionliquidacionlsd2.this.GXt_char2 = GXv_char3[0] ;
                  AV110TLiqCod = GXt_char2 ;
               }
               else
               {
                  AV110TLiqCod = AV100quincenaTLiqCod ;
               }
            }
            AV139itemJornal.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod( AV110TLiqCod );
            AV139itemJornal.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqdescrip( httpContext.getMessage( "Importación de Liquidación ", "")+GXutil.trim( A661ImpLiqDetPer)+" / "+GXutil.trim( A662ImpLiqDetLiqN) );
            GXv_char4[0] = AV11LiqPerPalabra ;
            GXv_char3[0] = AV79LiqNombre ;
            new web.armaliqnombre(remoteHandle, context).execute( AV8CliCod, AV139itemJornal.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo(), GXv_char4, AV110TLiqCod, "E", AV139itemJornal.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqfrecpag(), GXv_char3) ;
            confirmarimportacionliquidacionlsd2.this.AV11LiqPerPalabra = GXv_char4[0] ;
            confirmarimportacionliquidacionlsd2.this.AV79LiqNombre = GXv_char3[0] ;
            AV79LiqNombre += httpContext.getMessage( " (importada)", "") ;
            AV139itemJornal.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnombre( AV79LiqNombre );
            AV142importacion_sdt_jornales.add(AV139itemJornal, 0);
         }
         if ( ! brk27X2 )
         {
            brk27X2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
      AV75LiqEstado = (byte)(4) ;
      GXt_char2 = AV126sueldoConCodigo ;
      GXt_char1 = AV126sueldoConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_sueldomensual_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      confirmarimportacionliquidacionlsd2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      confirmarimportacionliquidacionlsd2.this.GXt_char2 = GXv_char3[0] ;
      AV126sueldoConCodigo = GXt_char2 ;
      AV144i = (short)(1) ;
      while ( AV144i <= 2 )
      {
         AV143aux_importacion_sdt = new GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem>(web.Sdtimportacion_sdt_importacion_sdtItem.class, "importacion_sdtItem", "PayDay", remoteHandle) ;
         if ( AV144i == 1 )
         {
            AV143aux_importacion_sdt.fromJSonString(AV121importacion_sdt.toJSonString(false), null);
         }
         else
         {
            AV143aux_importacion_sdt.fromJSonString(AV142importacion_sdt_jornales.toJSonString(false), null);
         }
         AV170GXV5 = 1 ;
         while ( AV170GXV5 <= AV143aux_importacion_sdt.size() )
         {
            AV122item = (web.Sdtimportacion_sdt_importacion_sdtItem)((web.Sdtimportacion_sdt_importacion_sdtItem)AV143aux_importacion_sdt.elementAt(-1+AV170GXV5));
            AV171GXV6 = 1 ;
            while ( AV171GXV6 <= AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos().size() )
            {
               AV123legajoItem = (web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem)((web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem)AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos().elementAt(-1+AV171GXV6));
               AV125sueldoImportes = DecimalUtil.ZERO ;
               AV128descuentoDiasHay = false ;
               AV172GXV7 = 1 ;
               while ( AV172GXV7 <= AV123legajoItem.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle().size() )
               {
                  AV124itemDetalle = (web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem)((web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem)AV123legajoItem.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle().elementAt(-1+AV172GXV7));
                  if ( GXutil.strcmp(AV124itemDetalle.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetconsis(), AV126sueldoConCodigo) == 0 )
                  {
                     AV125sueldoImportes = AV124itemDetalle.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetimpnum() ;
                  }
                  else
                  {
                     GXv_char4[0] = AV115TipoConCod ;
                     new web.conceptogettipo(remoteHandle, context).execute( AV8CliCod, AV124itemDetalle.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetconsis(), GXv_char4) ;
                     confirmarimportacionliquidacionlsd2.this.AV115TipoConCod = GXv_char4[0] ;
                     if ( ( GXutil.strcmp(AV124itemDetalle.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetsigno(), httpContext.getMessage( "D", "")) == 0 ) && ( GXutil.strcmp(AV115TipoConCod, "DES_ARG") != 0 ) )
                     {
                        if ( AV124itemDetalle.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetcantnum().doubleValue() <= 1 )
                        {
                           AV124itemDetalle.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Esdescuentodias( true );
                           AV128descuentoDiasHay = true ;
                        }
                     }
                  }
                  AV172GXV7 = (int)(AV172GXV7+1) ;
               }
               if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV125sueldoImportes)==0) && ( AV128descuentoDiasHay ) )
               {
                  AV173GXV8 = 1 ;
                  while ( AV173GXV8 <= AV123legajoItem.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle().size() )
                  {
                     AV124itemDetalle = (web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem)((web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem)AV123legajoItem.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle().elementAt(-1+AV173GXV8));
                     if ( AV124itemDetalle.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Esdescuentodias() )
                     {
                        GXv_int9[0] = (short)(DecimalUtil.decToDouble(AV127LiqDCanti)) ;
                        new web.calculacantdescuento(remoteHandle, context).execute( AV124itemDetalle.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetimpnum(), AV125sueldoImportes, GXv_int9) ;
                        confirmarimportacionliquidacionlsd2.this.AV127LiqDCanti = DecimalUtil.doubleToDec(GXv_int9[0]) ;
                        AV124itemDetalle.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetcantnum( AV127LiqDCanti );
                     }
                     AV173GXV8 = (int)(AV173GXV8+1) ;
                  }
               }
               AV171GXV6 = (int)(AV171GXV6+1) ;
            }
            AV170GXV5 = (int)(AV170GXV5+1) ;
         }
         AV144i = (short)(AV144i+1) ;
      }
      GXt_char2 = AV129egresoTLiqCod ;
      GXt_char1 = AV129egresoTLiqCod ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      confirmarimportacionliquidacionlsd2.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      confirmarimportacionliquidacionlsd2.this.GXt_char2 = GXv_char3[0] ;
      AV129egresoTLiqCod = GXt_char2 ;
      AV144i = (short)(1) ;
      while ( AV144i <= 2 )
      {
         AV143aux_importacion_sdt = new GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem>(web.Sdtimportacion_sdt_importacion_sdtItem.class, "importacion_sdtItem", "PayDay", remoteHandle) ;
         if ( AV144i == 1 )
         {
            AV143aux_importacion_sdt.fromJSonString(AV121importacion_sdt.toJSonString(false), null);
         }
         else
         {
            AV143aux_importacion_sdt.fromJSonString(AV142importacion_sdt_jornales.toJSonString(false), null);
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV162Pgmname, httpContext.getMessage( "&i ", "")+GXutil.trim( GXutil.str( AV144i, 4, 0))+httpContext.getMessage( " &aux_importacion_sdt ", "")+GXutil.trim( GXutil.str( AV143aux_importacion_sdt.size(), 9, 0))+httpContext.getMessage( " &importacion_sdt ", "")+GXutil.trim( GXutil.str( AV121importacion_sdt.size(), 9, 0))+httpContext.getMessage( " &importacion_sdt_jornales ", "")+GXutil.trim( GXutil.str( AV142importacion_sdt_jornales.size(), 9, 0))) ;
         AV174GXV9 = 1 ;
         while ( AV174GXV9 <= AV143aux_importacion_sdt.size() )
         {
            AV122item = (web.Sdtimportacion_sdt_importacion_sdtItem)((web.Sdtimportacion_sdt_importacion_sdtItem)AV143aux_importacion_sdt.elementAt(-1+AV174GXV9));
            if ( AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos().size() > 0 )
            {
               GXt_int10 = AV80LiqNro ;
               GXv_int6[0] = GXt_int10 ;
               new web.obtnumliquidacion(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, GXv_int6) ;
               confirmarimportacionliquidacionlsd2.this.GXt_int10 = GXv_int6[0] ;
               AV80LiqNro = GXt_int10 ;
               GXv_int11[0] = AV34ImpLiqLSDCuil ;
               new web.obtcuillegajo(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, ((web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem)AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos().elementAt(-1+1)).getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero(), GXv_int11) ;
               confirmarimportacionliquidacionlsd2.this.AV34ImpLiqLSDCuil = GXv_int11[0] ;
               GXv_Sdtsdt_LiqLegLSD5[0] = AV130sdt_LiqLegLSD;
               new web.getdatosliqleglsd(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV36ImpLiqSec, AV34ImpLiqLSDCuil, GXv_Sdtsdt_LiqLegLSD5) ;
               AV130sdt_LiqLegLSD = GXv_Sdtsdt_LiqLegLSD5[0] ;
               AV76LiqFecPago = AV130sdt_LiqLegLSD.getgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag() ;
               AV82LiqPeriodo = localUtil.ymdtod( AV81LiqPerAno, AV83LiqPerMes, 1) ;
               GXv_int7[0] = (byte)(AV132liquidaSac) ;
               GXv_char4[0] = AV131LiqSacLog ;
               new web.liquidar_sac(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, 0, AV110TLiqCod, AV82LiqPeriodo, GXv_int7, GXv_char4) ;
               confirmarimportacionliquidacionlsd2.this.AV132liquidaSac = GXv_int7[0] ;
               confirmarimportacionliquidacionlsd2.this.AV131LiqSacLog = GXv_char4[0] ;
               if ( AV132liquidaSac == 1 )
               {
                  AV133LiqSac = true ;
               }
               else
               {
                  AV133LiqSac = false ;
               }
               GXv_date12[0] = AV159LiqPerDes ;
               GXv_date13[0] = AV158LiqPerHas ;
               new web.getrangoperiodos(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, 0, 0, AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod(), AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqfrecpag(), AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo(), false, GXv_date12, GXv_date13) ;
               confirmarimportacionliquidacionlsd2.this.AV159LiqPerDes = GXv_date12[0] ;
               confirmarimportacionliquidacionlsd2.this.AV158LiqPerHas = GXv_date13[0] ;
               GXv_boolean8[0] = false ;
               new web.guardaliquidacion(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV80LiqNro, AV30hoy, AV76LiqFecPago, AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqdescrip(), AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqclase(), "E", AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqfrecpag(), AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqtipotarifa(), AV159LiqPerDes, AV158LiqPerHas, AV75LiqEstado, AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod(), httpContext.getMessage( "ALGUNOS", ""), AV39legajosDummy, "", AV29dummyDate, (short)(0), AV93Mes, AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqpermes(), AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperano(), true, AV12ahora, "", AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnombre(), 0, "", "", DecimalUtil.doubleToDec(0), "", AV133LiqSac, AV131LiqSacLog, AV153daemonUUID, false, GXv_boolean8) ;
               AV20collection_LegNumero.clear();
               AV175GXV10 = 1 ;
               while ( AV175GXV10 <= AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos().size() )
               {
                  AV123legajoItem = (web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem)((web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem)AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos().elementAt(-1+AV175GXV10));
                  AV20collection_LegNumero.add((int)(AV123legajoItem.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero()), 0);
                  AV135duplicaEs = false ;
                  if ( ! AV135duplicaEs )
                  {
                     GXv_date13[0] = AV53LegFecIngreso ;
                     GXv_date12[0] = AV52LegFecEgreso ;
                     new web.getfecingresoyegreso(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV123legajoItem.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero(), GXv_date13, GXv_date12) ;
                     confirmarimportacionliquidacionlsd2.this.AV53LegFecIngreso = GXv_date13[0] ;
                     confirmarimportacionliquidacionlsd2.this.AV52LegFecEgreso = GXv_date12[0] ;
                     if ( GXutil.strcmp(AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod(), AV129egresoTLiqCod) == 0 )
                     {
                        new web.actualizarlegajoactivo(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV123legajoItem.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero(), (byte)(2)) ;
                        AV52LegFecEgreso = GXutil.eomdate( AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo()) ;
                        new web.setearlegajofecegreso(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV123legajoItem.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero(), AV52LegFecEgreso) ;
                        new web.new_legajo_permanencia(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV123legajoItem.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero(), AV53LegFecIngreso, AV52LegFecEgreso, AV151vaciaFecha, "", true, "", true) ;
                     }
                     new web.newliquidacionlegajo(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV80LiqNro, AV123legajoItem.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero(), AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo(), AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod(), (byte)(3), "", "", "", DecimalUtil.doubleToDec(0)) ;
                     Application.commitDataStores(context, remoteHandle, pr_default, "confirmarimportacionliquidacionlsd2");
                     AV10LiqDSecuencial = 0 ;
                     AV176GXV11 = 1 ;
                     while ( AV176GXV11 <= AV123legajoItem.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle().size() )
                     {
                        AV124itemDetalle = (web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem)((web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem)AV123legajoItem.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle().elementAt(-1+AV176GXV11));
                        AV10LiqDSecuencial = (int)(AV10LiqDSecuencial+1) ;
                        GXv_decimal14[0] = DecimalUtil.doubleToDec(0) ;
                        GXv_boolean8[0] = false ;
                        GXv_char4[0] = "" ;
                        GXv_char3[0] = "" ;
                        new web.newliquidaciondetalle3(remoteHandle, context).execute( A3CliCod, A1EmpCod, AV80LiqNro, 0, AV123legajoItem.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero(), AV124itemDetalle.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetconsis(), AV101resolver, AV10LiqDSecuencial, AV124itemDetalle.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetimpnum(), AV124itemDetalle.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetcantnum(), DecimalUtil.doubleToDec(0), AV26date, AV26date, AV124itemDetalle.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetimpnum(), false, (byte)(3), AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo(), AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod(), false, (byte)(4), false, AV124itemDetalle.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqconextdescrip(), GXv_decimal14, GXv_boolean8, GXv_char4, GXv_char3) ;
                        AV176GXV11 = (int)(AV176GXV11+1) ;
                     }
                  }
                  AV175GXV10 = (int)(AV175GXV10+1) ;
               }
               AV122item.setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnro( AV80LiqNro );
               new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV162Pgmname, httpContext.getMessage( "&LiqNro ", "")+GXutil.trim( GXutil.str( AV80LiqNro, 8, 0))+httpContext.getMessage( " &item.LiqNro ", "")+GXutil.trim( GXutil.str( AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnro(), 8, 0))) ;
               AV87liquidaciones_generadas.add((int)(AV80LiqNro), 0);
               GXv_decimal14[0] = AV78LiqImpNeto ;
               GXv_decimal15[0] = AV77LiqImpBruto ;
               GXv_int9[0] = AV72LiqCntLeg ;
               GXv_boolean8[0] = false ;
               new web.calculaimporteliquidacionlegajo(remoteHandle, context).execute( A3CliCod, A1EmpCod, AV80LiqNro, AV20collection_LegNumero, "", GXv_decimal14, GXv_decimal15, GXv_int9, GXv_boolean8) ;
               confirmarimportacionliquidacionlsd2.this.AV78LiqImpNeto = GXv_decimal14[0] ;
               confirmarimportacionliquidacionlsd2.this.AV77LiqImpBruto = GXv_decimal15[0] ;
               confirmarimportacionliquidacionlsd2.this.AV72LiqCntLeg = GXv_int9[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV162Pgmname, ".4") ;
               new web.seteaimportesliquidacion(remoteHandle, context).execute( A3CliCod, A1EmpCod, AV80LiqNro, AV78LiqImpNeto, AV77LiqImpBruto, AV72LiqCntLeg) ;
               new web.bajalegajossiegreso(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV80LiqNro, AV122item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod()) ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV162Pgmname, ".5") ;
               new web.setliqestado(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV80LiqNro, (byte)(4)) ;
               Application.commitDataStores(context, remoteHandle, pr_default, "confirmarimportacionliquidacionlsd2");
            }
            AV174GXV9 = (int)(AV174GXV9+1) ;
         }
         if ( AV144i == 1 )
         {
            AV121importacion_sdt = new GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem>(web.Sdtimportacion_sdt_importacion_sdtItem.class, "importacion_sdtItem", "PayDay", remoteHandle) ;
            AV121importacion_sdt.fromJSonString(AV143aux_importacion_sdt.toJSonString(false), null);
         }
         else
         {
            AV142importacion_sdt_jornales = new GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem>(web.Sdtimportacion_sdt_importacion_sdtItem.class, "importacion_sdtItem", "PayDay", remoteHandle) ;
            AV142importacion_sdt_jornales.fromJSonString(AV143aux_importacion_sdt.toJSonString(false), null);
         }
         AV144i = (short)(AV144i+1) ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV162Pgmname, httpContext.getMessage( "&segundoPlano ", "")+GXutil.trim( GXutil.booltostr( AV120segundoPlano))+httpContext.getMessage( " &mensualHay ", "")+GXutil.trim( GXutil.booltostr( AV140mensualHay))) ;
      if ( ( AV120segundoPlano ) && ( AV140mensualHay ) )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV162Pgmname, httpContext.getMessage( "submitttt", "")) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV162Pgmname, httpContext.getMessage( "&importacion_sdt count ", "")+GXutil.trim( GXutil.str( AV121importacion_sdt.size(), 9, 0))+httpContext.getMessage( " json ", "")+AV121importacion_sdt.toJSonString(false)) ;
         callSubmit( 1 , new Object[]{ Integer.valueOf(AV8CliCod),Short.valueOf(AV9EmpCod),AV121importacion_sdt });
      }
      if ( ( AV120segundoPlano ) && ( AV141jornalHay ) )
      {
         callSubmit( 2 , new Object[]{ Integer.valueOf(AV8CliCod),Short.valueOf(AV9EmpCod),AV142importacion_sdt_jornales });
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV162Pgmname, "8") ;
      new web.eliminarimportaciondetalle(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV36ImpLiqSec, (short)(0), AV147coll_ImpLiqLSDCuil.toJSonString(false)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV162Pgmname, "9") ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV162Pgmname, "10") ;
      AV88liquidaciones_generadasJSON = AV87liquidaciones_generadas.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'BUSCAR TIPO DE LIQUIDACION' Routine */
      returnInSub = false ;
      AV110TLiqCod = "" ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV162Pgmname, httpContext.getMessage( "&ImpLiqDetLiqN ", "")+GXutil.trim( AV116ImpLiqDetLiqN)+httpContext.getMessage( " &ImpLiqDetPer ", "")+AV118ImpLiqDetPer) ;
      /* Using cursor P027X3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Short.valueOf(AV36ImpLiqSec), AV116ImpLiqDetLiqN, AV118ImpLiqDetPer});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A662ImpLiqDetLiqN = P027X3_A662ImpLiqDetLiqN[0] ;
         A661ImpLiqDetPer = P027X3_A661ImpLiqDetPer[0] ;
         A88ImpLiqSec = P027X3_A88ImpLiqSec[0] ;
         A1EmpCod = P027X3_A1EmpCod[0] ;
         A3CliCod = P027X3_A3CliCod[0] ;
         A713ImpLiqDetConSis = P027X3_A713ImpLiqDetConSis[0] ;
         A90ImpLiqDetSec = P027X3_A90ImpLiqDetSec[0] ;
         GXv_objcol_char16[0] = AV117tiposLiq ;
         new web.gettiposliqdeconcepto(remoteHandle, context).execute( AV8CliCod, A713ImpLiqDetConSis, GXv_objcol_char16) ;
         AV117tiposLiq = GXv_objcol_char16[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV162Pgmname, httpContext.getMessage( "ImpLiqDetConSis ", "")+GXutil.trim( A713ImpLiqDetConSis)+httpContext.getMessage( " &tiposLiq ", "")+GXutil.trim( GXutil.str( AV117tiposLiq.size(), 9, 0))) ;
         if ( AV117tiposLiq.size() == 1 )
         {
            AV110TLiqCod = (String)AV117tiposLiq.elementAt(-1+1) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV162Pgmname, httpContext.getMessage( "&TLiqCod ", "")+AV110TLiqCod) ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = confirmarimportacionliquidacionlsd2.this.AV88liquidaciones_generadasJSON;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void submit( int submitId ,
                       Object [] submitParms ,
                       ModelContext submitContext )
   {
      UserInformation submitUI = (UserInformation) GXObjectHelper.getUserInformation(context, -1);
      int remoteHandle = submitUI.getHandle();
      try
      {
         switch ( submitId )
         {
               case 1 :
                  new web.generarauxiliaresliqsimportadas(remoteHandle, submitContext).execute( ((Number) submitParms[0]).intValue(), ((Number) submitParms[1]).shortValue(), (GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem>)submitParms[2]) ;
                  try { Application.getConnectionManager().disconnect(remoteHandle); } catch(Exception submitExc) { ; }
                  break;
               case 2 :
                  new web.generarauxiliaresliqsimportadas(remoteHandle, submitContext).execute( ((Number) submitParms[0]).intValue(), ((Number) submitParms[1]).shortValue(), (GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem>)submitParms[2]) ;
                  try { Application.getConnectionManager().disconnect(remoteHandle); } catch(Exception submitExc) { ; }
                  break;
         }
      }
      catch ( Exception e )
      {
         Application.cleanupConnection(remoteHandle);
         e.printStackTrace();
      }
   }

   public void initialize( )
   {
      AV88liquidaciones_generadasJSON = "" ;
      AV153daemonUUID = "" ;
      AV87liquidaciones_generadas = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV12ahora = GXutil.resetTime( GXutil.nullDate() );
      AV119ParmValue = "" ;
      AV100quincenaTLiqCod = "" ;
      AV162Pgmname = "" ;
      scmdbuf = "" ;
      P027X2_A3CliCod = new int[1] ;
      P027X2_A1EmpCod = new short[1] ;
      P027X2_A88ImpLiqSec = new short[1] ;
      P027X2_A666ImpLiqDetConCod = new String[] {""} ;
      P027X2_A713ImpLiqDetConSis = new String[] {""} ;
      P027X2_A716ImpLiqDetImpNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P027X2_A670ImpLiqDetSigno = new String[] {""} ;
      P027X2_A715ImpLiqDetCantNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P027X2_A90ImpLiqDetSec = new short[1] ;
      P027X2_A663ImpLiqDetCUIL = new String[] {""} ;
      P027X2_A662ImpLiqDetLiqN = new String[] {""} ;
      P027X2_A661ImpLiqDetPer = new String[] {""} ;
      P027X2_A709ImpLiqDetError = new String[] {""} ;
      P027X2_A718ImpLiqDetLiqClase = new String[] {""} ;
      A666ImpLiqDetConCod = "" ;
      A713ImpLiqDetConSis = "" ;
      A716ImpLiqDetImpNum = DecimalUtil.ZERO ;
      A670ImpLiqDetSigno = "" ;
      A715ImpLiqDetCantNum = DecimalUtil.ZERO ;
      A663ImpLiqDetCUIL = "" ;
      A662ImpLiqDetLiqN = "" ;
      A661ImpLiqDetPer = "" ;
      A709ImpLiqDetError = "" ;
      A718ImpLiqDetLiqClase = "" ;
      AV122item = new web.Sdtimportacion_sdt_importacion_sdtItem(remoteHandle, context);
      AV139itemJornal = new web.Sdtimportacion_sdt_importacion_sdtItem(remoteHandle, context);
      AV146pagoFecha = GXutil.nullDate() ;
      AV130sdt_LiqLegLSD = new web.Sdtsdt_LiqLegLSD(remoteHandle, context);
      AV123legajoItem = new web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem(remoteHandle, context);
      AV137legajoJornalItem = new web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem(remoteHandle, context);
      AV134netoImportes = DecimalUtil.ZERO ;
      AV124itemDetalle = new web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem(remoteHandle, context);
      AV138itemJornalDetalle = new web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem(remoteHandle, context);
      AV114ImpLiqDetImpNum = DecimalUtil.ZERO ;
      AV21ConCodigo = "" ;
      AV115TipoConCod = "" ;
      AV142importacion_sdt_jornales = new GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem>(web.Sdtimportacion_sdt_importacion_sdtItem.class, "importacion_sdtItem", "PayDay", remoteHandle);
      AV149item2 = new web.Sdtimportacion_sdt_importacion_sdtItem(remoteHandle, context);
      AV148legajoItem2 = new web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem(remoteHandle, context);
      AV121importacion_sdt = new GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem>(web.Sdtimportacion_sdt_importacion_sdtItem.class, "importacion_sdtItem", "PayDay", remoteHandle);
      AV147coll_ImpLiqLSDCuil = new GXSimpleCollection<Long>(Long.class, "internal", "");
      AV33ImpLiqDetLiqClase = "" ;
      AV116ImpLiqDetLiqN = "" ;
      AV118ImpLiqDetPer = "" ;
      AV11LiqPerPalabra = "" ;
      AV110TLiqCod = "" ;
      AV79LiqNombre = "" ;
      AV126sueldoConCodigo = "" ;
      AV143aux_importacion_sdt = new GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem>(web.Sdtimportacion_sdt_importacion_sdtItem.class, "importacion_sdtItem", "PayDay", remoteHandle);
      AV125sueldoImportes = DecimalUtil.ZERO ;
      AV127LiqDCanti = DecimalUtil.ZERO ;
      AV129egresoTLiqCod = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_int6 = new int[1] ;
      GXv_int11 = new long[1] ;
      GXv_Sdtsdt_LiqLegLSD5 = new web.Sdtsdt_LiqLegLSD[1] ;
      AV76LiqFecPago = GXutil.nullDate() ;
      AV82LiqPeriodo = GXutil.nullDate() ;
      GXv_int7 = new byte[1] ;
      AV131LiqSacLog = "" ;
      AV159LiqPerDes = GXutil.nullDate() ;
      AV158LiqPerHas = GXutil.nullDate() ;
      AV30hoy = GXutil.nullDate() ;
      AV39legajosDummy = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV29dummyDate = GXutil.nullDate() ;
      AV20collection_LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV53LegFecIngreso = GXutil.nullDate() ;
      GXv_date13 = new java.util.Date[1] ;
      AV52LegFecEgreso = GXutil.nullDate() ;
      GXv_date12 = new java.util.Date[1] ;
      AV151vaciaFecha = GXutil.nullDate() ;
      AV26date = GXutil.nullDate() ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      AV78LiqImpNeto = DecimalUtil.ZERO ;
      GXv_decimal14 = new java.math.BigDecimal[1] ;
      AV77LiqImpBruto = DecimalUtil.ZERO ;
      GXv_decimal15 = new java.math.BigDecimal[1] ;
      GXv_int9 = new short[1] ;
      GXv_boolean8 = new boolean[1] ;
      P027X3_A662ImpLiqDetLiqN = new String[] {""} ;
      P027X3_A661ImpLiqDetPer = new String[] {""} ;
      P027X3_A88ImpLiqSec = new short[1] ;
      P027X3_A1EmpCod = new short[1] ;
      P027X3_A3CliCod = new int[1] ;
      P027X3_A713ImpLiqDetConSis = new String[] {""} ;
      P027X3_A90ImpLiqDetSec = new short[1] ;
      AV117tiposLiq = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char16 = new GXSimpleCollection[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.confirmarimportacionliquidacionlsd2__default(),
         new Object[] {
             new Object[] {
            P027X2_A3CliCod, P027X2_A1EmpCod, P027X2_A88ImpLiqSec, P027X2_A666ImpLiqDetConCod, P027X2_A713ImpLiqDetConSis, P027X2_A716ImpLiqDetImpNum, P027X2_A670ImpLiqDetSigno, P027X2_A715ImpLiqDetCantNum, P027X2_A90ImpLiqDetSec, P027X2_A663ImpLiqDetCUIL,
            P027X2_A662ImpLiqDetLiqN, P027X2_A661ImpLiqDetPer, P027X2_A709ImpLiqDetError, P027X2_A718ImpLiqDetLiqClase
            }
            , new Object[] {
            P027X3_A662ImpLiqDetLiqN, P027X3_A661ImpLiqDetPer, P027X3_A88ImpLiqSec, P027X3_A1EmpCod, P027X3_A3CliCod, P027X3_A713ImpLiqDetConSis, P027X3_A90ImpLiqDetSec
            }
         }
      );
      AV162Pgmname = "ConfirmarImportacionLiquidacionLSD2" ;
      /* GeneXus formulas. */
      AV162Pgmname = "ConfirmarImportacionLiquidacionLSD2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV83LiqPerMes ;
   private byte AV46LegClase ;
   private byte AV75LiqEstado ;
   private byte GXv_int7[] ;
   private byte AV93Mes ;
   private short AV9EmpCod ;
   private short AV36ImpLiqSec ;
   private short A1EmpCod ;
   private short A88ImpLiqSec ;
   private short A90ImpLiqDetSec ;
   private short AV150Sec ;
   private short AV81LiqPerAno ;
   private short AV35ImpLiqLSDSec ;
   private short AV144i ;
   private short AV132liquidaSac ;
   private short AV72LiqCntLeg ;
   private short GXv_int9[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private int AV65LegNumero ;
   private int AV136dupliLiqnro ;
   private int AV166GXV1 ;
   private int AV167GXV2 ;
   private int AV168GXV3 ;
   private int AV169GXV4 ;
   private int AV170GXV5 ;
   private int AV171GXV6 ;
   private int AV172GXV7 ;
   private int AV173GXV8 ;
   private int AV174GXV9 ;
   private int AV80LiqNro ;
   private int GXt_int10 ;
   private int GXv_int6[] ;
   private int AV175GXV10 ;
   private int AV10LiqDSecuencial ;
   private int AV176GXV11 ;
   private long AV34ImpLiqLSDCuil ;
   private long GXv_int11[] ;
   private java.math.BigDecimal A716ImpLiqDetImpNum ;
   private java.math.BigDecimal A715ImpLiqDetCantNum ;
   private java.math.BigDecimal AV134netoImportes ;
   private java.math.BigDecimal AV114ImpLiqDetImpNum ;
   private java.math.BigDecimal AV125sueldoImportes ;
   private java.math.BigDecimal AV127LiqDCanti ;
   private java.math.BigDecimal AV78LiqImpNeto ;
   private java.math.BigDecimal GXv_decimal14[] ;
   private java.math.BigDecimal AV77LiqImpBruto ;
   private java.math.BigDecimal GXv_decimal15[] ;
   private String AV153daemonUUID ;
   private String AV100quincenaTLiqCod ;
   private String AV162Pgmname ;
   private String scmdbuf ;
   private String A666ImpLiqDetConCod ;
   private String A713ImpLiqDetConSis ;
   private String A670ImpLiqDetSigno ;
   private String A663ImpLiqDetCUIL ;
   private String A662ImpLiqDetLiqN ;
   private String A661ImpLiqDetPer ;
   private String A718ImpLiqDetLiqClase ;
   private String AV21ConCodigo ;
   private String AV115TipoConCod ;
   private String AV33ImpLiqDetLiqClase ;
   private String AV116ImpLiqDetLiqN ;
   private String AV118ImpLiqDetPer ;
   private String AV11LiqPerPalabra ;
   private String AV110TLiqCod ;
   private String AV126sueldoConCodigo ;
   private String AV129egresoTLiqCod ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private java.util.Date AV12ahora ;
   private java.util.Date AV146pagoFecha ;
   private java.util.Date AV76LiqFecPago ;
   private java.util.Date AV82LiqPeriodo ;
   private java.util.Date AV159LiqPerDes ;
   private java.util.Date AV158LiqPerHas ;
   private java.util.Date AV30hoy ;
   private java.util.Date AV29dummyDate ;
   private java.util.Date AV53LegFecIngreso ;
   private java.util.Date GXv_date13[] ;
   private java.util.Date AV52LegFecEgreso ;
   private java.util.Date GXv_date12[] ;
   private java.util.Date AV151vaciaFecha ;
   private java.util.Date AV26date ;
   private boolean AV120segundoPlano ;
   private boolean AV101resolver ;
   private boolean brk27X2 ;
   private boolean AV140mensualHay ;
   private boolean AV141jornalHay ;
   private boolean AV135duplicaEs ;
   private boolean returnInSub ;
   private boolean AV128descuentoDiasHay ;
   private boolean AV133LiqSac ;
   private boolean GXv_boolean8[] ;
   private String AV119ParmValue ;
   private String AV88liquidaciones_generadasJSON ;
   private String A709ImpLiqDetError ;
   private String AV79LiqNombre ;
   private String AV131LiqSacLog ;
   private GXSimpleCollection<Integer> AV87liquidaciones_generadas ;
   private GXSimpleCollection<Integer> AV39legajosDummy ;
   private GXSimpleCollection<Integer> AV20collection_LegNumero ;
   private GXSimpleCollection<Long> AV147coll_ImpLiqLSDCuil ;
   private GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem> AV142importacion_sdt_jornales ;
   private GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem> AV121importacion_sdt ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P027X2_A3CliCod ;
   private short[] P027X2_A1EmpCod ;
   private short[] P027X2_A88ImpLiqSec ;
   private String[] P027X2_A666ImpLiqDetConCod ;
   private String[] P027X2_A713ImpLiqDetConSis ;
   private java.math.BigDecimal[] P027X2_A716ImpLiqDetImpNum ;
   private String[] P027X2_A670ImpLiqDetSigno ;
   private java.math.BigDecimal[] P027X2_A715ImpLiqDetCantNum ;
   private short[] P027X2_A90ImpLiqDetSec ;
   private String[] P027X2_A663ImpLiqDetCUIL ;
   private String[] P027X2_A662ImpLiqDetLiqN ;
   private String[] P027X2_A661ImpLiqDetPer ;
   private String[] P027X2_A709ImpLiqDetError ;
   private String[] P027X2_A718ImpLiqDetLiqClase ;
   private String[] P027X3_A662ImpLiqDetLiqN ;
   private String[] P027X3_A661ImpLiqDetPer ;
   private short[] P027X3_A88ImpLiqSec ;
   private short[] P027X3_A1EmpCod ;
   private int[] P027X3_A3CliCod ;
   private String[] P027X3_A713ImpLiqDetConSis ;
   private short[] P027X3_A90ImpLiqDetSec ;
   private GXSimpleCollection<String> AV117tiposLiq ;
   private GXSimpleCollection<String> GXv_objcol_char16[] ;
   private GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem> AV143aux_importacion_sdt ;
   private web.Sdtimportacion_sdt_importacion_sdtItem AV122item ;
   private web.Sdtimportacion_sdt_importacion_sdtItem AV139itemJornal ;
   private web.Sdtimportacion_sdt_importacion_sdtItem AV149item2 ;
   private web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem AV123legajoItem ;
   private web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem AV137legajoJornalItem ;
   private web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem AV148legajoItem2 ;
   private web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem AV124itemDetalle ;
   private web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem AV138itemJornalDetalle ;
   private web.Sdtsdt_LiqLegLSD AV130sdt_LiqLegLSD ;
   private web.Sdtsdt_LiqLegLSD GXv_Sdtsdt_LiqLegLSD5[] ;
}

final  class confirmarimportacionliquidacionlsd2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P027X2", "SELECT CliCod, EmpCod, ImpLiqSec, ImpLiqDetConCod, ImpLiqDetConSis, ImpLiqDetImpNum, ImpLiqDetSigno, ImpLiqDetCantNum, ImpLiqDetSec, ImpLiqDetCUIL, ImpLiqDetLiqN, ImpLiqDetPer, ImpLiqDetError, ImpLiqDetLiqClase FROM importacion_liquidacion_detalle WHERE (CliCod = ? and EmpCod = ? and ImpLiqSec = ?) AND ((char_length(trim(trailing ' ' from ImpLiqDetError))=0)) ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqDetPer, ImpLiqDetLiqN, ImpLiqDetCUIL, ImpLiqDetSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P027X3", "SELECT ImpLiqDetLiqN, ImpLiqDetPer, ImpLiqSec, EmpCod, CliCod, ImpLiqDetConSis, ImpLiqDetSec FROM importacion_liquidacion_detalle WHERE (CliCod = ? and EmpCod = ? and ImpLiqSec = ? and ImpLiqDetLiqN = ( ?)) AND (ImpLiqDetPer = ( ?)) ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqDetLiqN ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 11);
               ((String[]) buf[10])[0] = rslt.getString(11, 5);
               ((String[]) buf[11])[0] = rslt.getString(12, 6);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getString(14, 1);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 5);
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 5);
               stmt.setString(5, (String)parms[4], 6);
               return;
      }
   }

}

