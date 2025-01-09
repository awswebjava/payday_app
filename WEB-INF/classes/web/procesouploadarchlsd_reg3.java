package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class procesouploadarchlsd_reg3 extends GXProcedure
{
   public procesouploadarchlsd_reg3( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( procesouploadarchlsd_reg3.class ), "" );
   }

   public procesouploadarchlsd_reg3( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            short aP2 ,
                            short aP3 ,
                            GXSimpleCollection<String>[] aP4 )
   {
      procesouploadarchlsd_reg3.this.aP5 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        short aP3 ,
                        GXSimpleCollection<String>[] aP4 ,
                        short[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             short aP3 ,
                             GXSimpleCollection<String>[] aP4 ,
                             short[] aP5 )
   {
      procesouploadarchlsd_reg3.this.AV11CliCod = aP0;
      procesouploadarchlsd_reg3.this.AV13EmpCod = aP1;
      procesouploadarchlsd_reg3.this.AV24ImpLiqSec = aP2;
      procesouploadarchlsd_reg3.this.AV29ImpLiqLSDSec = aP3;
      procesouploadarchlsd_reg3.this.aP4 = aP4;
      procesouploadarchlsd_reg3.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, "1") ;
      AV28vez = (short)(1) ;
      AV25seguir = true ;
      while ( ( AV28vez <= 2 ) && ( AV25seguir ) )
      {
         if ( AV14errores.size() > 0 )
         {
            if (true) break;
         }
         AV14errores.clear();
         AV9ahora = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
         AV73GXLvl11 = (byte)(0) ;
         /* Using cursor P025Y2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV13EmpCod), Short.valueOf(AV24ImpLiqSec), Short.valueOf(AV29ImpLiqLSDSec)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A704ImpLiqLSDSec = P025Y2_A704ImpLiqLSDSec[0] ;
            A88ImpLiqSec = P025Y2_A88ImpLiqSec[0] ;
            A1EmpCod = P025Y2_A1EmpCod[0] ;
            A3CliCod = P025Y2_A3CliCod[0] ;
            A706ImpLiqLSDFileName = P025Y2_A706ImpLiqLSDFileName[0] ;
            A707ImpLiqLSDFileType = P025Y2_A707ImpLiqLSDFileType[0] ;
            A705ImpLiqLSDFile = P025Y2_A705ImpLiqLSDFile[0] ;
            A708ImpLiqLSDFileNameAndType = P025Y2_A708ImpLiqLSDFileNameAndType[0] ;
            AV73GXLvl11 = (byte)(1) ;
            new web.msgdebug7(remoteHandle, context).execute( AV72Pgmname, "2") ;
            AV18File.setSource( A705ImpLiqLSDFile );
            if ( AV18File.exists() )
            {
               AV17f = (short)(0) ;
               AV27varcharcollection = new GXSimpleCollection<String>(String.class, "internal", "", AV18File.readAllLines()) ;
               AV47completo = false ;
               AV49algunoCompleto = false ;
               AV74GXV1 = 1 ;
               while ( AV74GXV1 <= AV27varcharcollection.size() )
               {
                  AV19fileLine = (String)AV27varcharcollection.elementAt(-1+AV74GXV1) ;
                  AV17f = (short)(AV17f+1) ;
                  AV15errorFormato = "" ;
                  if ( AV28vez > 1 )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "fila ", "")+GXutil.trim( GXutil.str( AV17f, 4, 0))+" "+GXutil.trim( AV19fileLine)) ;
                  }
                  AV31tipoRegistro = GXutil.trim( GXutil.substring( AV19fileLine, 1, 2)) ;
                  if ( AV28vez > 1 )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "&tipoRegistro ", "")+GXutil.trim( AV31tipoRegistro)) ;
                  }
                  if ( GXutil.strcmp(AV31tipoRegistro, "03") == 0 )
                  {
                     AV37ImpLiqDetConCod = GXutil.trim( GXutil.substring( AV19fileLine, 14, 10)) ;
                     AV38ImpLiqDetCant = GXutil.trim( GXutil.substring( AV19fileLine, 24, 5)) ;
                     AV39ImpLiqDetUni = GXutil.trim( GXutil.substring( AV19fileLine, 29, 1)) ;
                     AV40ImpLiqDetImp = GXutil.trim( GXutil.substring( AV19fileLine, 30, 15)) ;
                     AV41ImpLiqDetSigno = GXutil.trim( GXutil.substring( AV19fileLine, 45, 1)) ;
                     AV47completo = true ;
                     AV49algunoCompleto = true ;
                     AV56registro3Hay = true ;
                     AV34ImpLiqDetCUIL = GXutil.trim( GXutil.substring( AV19fileLine, 3, 11)) ;
                  }
                  else
                  {
                     if ( GXutil.strcmp(AV31tipoRegistro, "01") == 0 )
                     {
                        AV53registro1Hay = true ;
                        AV30ImpLiqDetPer = GXutil.trim( GXutil.substring( AV19fileLine, 16, 6)) ;
                        AV33ImpLiqDetLiqN = GXutil.trim( GXutil.substring( AV19fileLine, 23, 5)) ;
                        AV52ImpLiqDetLiqClase = GXutil.trim( GXutil.substring( AV19fileLine, 22, 1)) ;
                     }
                     else
                     {
                        if ( ( ( GXutil.strcmp(AV31tipoRegistro, "02") == 0 ) || ( GXutil.strcmp(AV31tipoRegistro, "04") == 0 ) ) && ( AV28vez > 1 ) )
                        {
                           if ( GXutil.strcmp(AV31tipoRegistro, "02") == 0 )
                           {
                              AV62ImpLiqLSDCuil = GXutil.lval( GXutil.trim( GXutil.substring( AV19fileLine, 3, 11))) ;
                              AV63ImpLiqLSDLegId = GXutil.trim( GXutil.substring( AV19fileLine, 14, 10)) ;
                              AV64ImpLiqLSDLegCBU = GXutil.trim( GXutil.substring( AV19fileLine, 74, 22)) ;
                              AV60ImpLiqLSDLegDiasLiq = (short)(GXutil.lval( GXutil.trim( GXutil.substring( AV19fileLine, 96, 3)))) ;
                              AV69fechaStr = GXutil.trim( GXutil.substring( AV19fileLine, 99, 8)) ;
                              AV61ImpLiqLSDLegFecPag = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( AV69fechaStr, 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( AV69fechaStr, 5, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( AV69fechaStr, 7, 2), ".")))) ;
                              AV65ImpLiqLSDLegCony = false ;
                              AV66ImpLiqLSDLegHijos = (byte)(0) ;
                              AV67ImpLiqLSDDepRev = GXutil.trim( GXutil.substring( AV19fileLine, 24, 50)) ;
                              AV68ImpLiqLSDForPag = GXutil.trim( GXutil.substring( AV19fileLine, 115, 1)) ;
                           }
                           else
                           {
                              AV65ImpLiqLSDLegCony = GXutil.boolval( GXutil.trim( GXutil.substring( AV19fileLine, 14, 1))) ;
                              AV66ImpLiqLSDLegHijos = (byte)(GXutil.lval( GXutil.trim( GXutil.substring( AV19fileLine, 15, 2)))) ;
                              AV62ImpLiqLSDCuil = GXutil.lval( GXutil.trim( GXutil.substring( AV19fileLine, 3, 11))) ;
                              AV63ImpLiqLSDLegId = "" ;
                              AV64ImpLiqLSDLegCBU = "" ;
                              AV60ImpLiqLSDLegDiasLiq = (short)(0) ;
                              AV61ImpLiqLSDLegFecPag = GXutil.nullDate() ;
                              AV67ImpLiqLSDDepRev = "" ;
                              AV68ImpLiqLSDForPag = "" ;
                           }
                           new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "tiporeg ", "")+AV31tipoRegistro+httpContext.getMessage( " llama a liqleg ", "")+GXutil.trim( localUtil.dtoc( AV61ImpLiqLSDLegFecPag, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
                           new web.grabaliqleglsd(remoteHandle, context).execute( AV11CliCod, AV13EmpCod, AV24ImpLiqSec, AV62ImpLiqLSDCuil, AV63ImpLiqLSDLegId, AV64ImpLiqLSDLegCBU, AV60ImpLiqLSDLegDiasLiq, AV61ImpLiqLSDLegFecPag, AV65ImpLiqLSDLegCony, AV66ImpLiqLSDLegHijos, AV67ImpLiqLSDDepRev, AV68ImpLiqLSDForPag) ;
                        }
                     }
                  }
                  if ( AV28vez > 2 )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "completo ", "")+GXutil.trim( GXutil.booltostr( AV47completo))) ;
                  }
                  if ( AV47completo )
                  {
                     if ( AV28vez == 1 )
                     {
                        if ( (GXutil.strcmp("", AV31tipoRegistro)==0) || (GXutil.strcmp("", AV30ImpLiqDetPer)==0) || (GXutil.strcmp("", AV33ImpLiqDetLiqN)==0) || (GXutil.strcmp("", AV34ImpLiqDetCUIL)==0) || (GXutil.strcmp("", AV37ImpLiqDetConCod)==0) || (GXutil.strcmp("", AV40ImpLiqDetImp)==0) || (GXutil.strcmp("", AV41ImpLiqDetSigno)==0) )
                        {
                           if ( (GXutil.strcmp("", AV31tipoRegistro)==0) )
                           {
                              AV15errorFormato = httpContext.getMessage( "Tipo de Registro vacío.", "") ;
                           }
                           if ( (GXutil.strcmp("", AV30ImpLiqDetPer)==0) )
                           {
                              AV15errorFormato += httpContext.getMessage( " Periodo vacío.", "") ;
                           }
                           if ( (GXutil.strcmp("", AV33ImpLiqDetLiqN)==0) )
                           {
                              AV15errorFormato += httpContext.getMessage( " Nro Liq vacío.", "") ;
                           }
                           if ( (GXutil.strcmp("", AV34ImpLiqDetCUIL)==0) )
                           {
                              AV15errorFormato += httpContext.getMessage( "CUIL vacío.", "") ;
                           }
                           if ( (GXutil.strcmp("", AV37ImpLiqDetConCod)==0) )
                           {
                              AV15errorFormato += httpContext.getMessage( " Concepto vacío.", "") ;
                           }
                           if ( (GXutil.strcmp("", AV40ImpLiqDetImp)==0) )
                           {
                              AV15errorFormato += httpContext.getMessage( " Importe vacío.", "") ;
                           }
                           if ( (GXutil.strcmp("", AV41ImpLiqDetSigno)==0) )
                           {
                              AV15errorFormato += httpContext.getMessage( " Signo vacío.", "") ;
                           }
                           new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "fi 1", "")) ;
                           /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                           S111 ();
                           if ( returnInSub )
                           {
                              pr_default.close(0);
                              returnInSub = true;
                              cleanup();
                              if (true) return;
                           }
                           if (true) break;
                        }
                        else
                        {
                           AV32tipoDeRegistroInvalido = false ;
                           GXv_boolean1[0] = AV16esNumero ;
                           new web.esnumero(remoteHandle, context).execute( AV31tipoRegistro, GXv_boolean1) ;
                           procesouploadarchlsd_reg3.this.AV16esNumero = GXv_boolean1[0] ;
                           if ( ! AV16esNumero )
                           {
                              AV32tipoDeRegistroInvalido = true ;
                           }
                           else
                           {
                              if ( CommonUtil.decimalVal( AV31tipoRegistro, ".").doubleValue() > 5 )
                              {
                                 AV32tipoDeRegistroInvalido = true ;
                              }
                           }
                           if ( AV32tipoDeRegistroInvalido )
                           {
                              AV15errorFormato = httpContext.getMessage( "Tipo de Registro Inválido ", "") + AV31tipoRegistro ;
                              new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "fi 2", "")) ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              if (true) break;
                           }
                           if ( ! (GXutil.strcmp("", AV30ImpLiqDetPer)==0) )
                           {
                              GXv_boolean1[0] = AV16esNumero ;
                              new web.esnumero(remoteHandle, context).execute( AV30ImpLiqDetPer, GXv_boolean1) ;
                              procesouploadarchlsd_reg3.this.AV16esNumero = GXv_boolean1[0] ;
                              if ( ! AV16esNumero )
                              {
                                 AV15errorFormato = httpContext.getMessage( "Periodo inválido ", "") + AV30ImpLiqDetPer ;
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "fi 3", "")) ;
                                 /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                                 S111 ();
                                 if ( returnInSub )
                                 {
                                    pr_default.close(0);
                                    returnInSub = true;
                                    cleanup();
                                    if (true) return;
                                 }
                                 if (true) break;
                              }
                           }
                           if ( ! (GXutil.strcmp("", AV33ImpLiqDetLiqN)==0) )
                           {
                              GXv_boolean1[0] = AV16esNumero ;
                              new web.esnumero(remoteHandle, context).execute( AV33ImpLiqDetLiqN, GXv_boolean1) ;
                              procesouploadarchlsd_reg3.this.AV16esNumero = GXv_boolean1[0] ;
                              if ( ! AV16esNumero )
                              {
                                 AV15errorFormato = httpContext.getMessage( "Nro de liquidación inválido ", "") + AV33ImpLiqDetLiqN ;
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "fi 4", "")) ;
                                 /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                                 S111 ();
                                 if ( returnInSub )
                                 {
                                    pr_default.close(0);
                                    returnInSub = true;
                                    cleanup();
                                    if (true) return;
                                 }
                                 if (true) break;
                              }
                           }
                           if ( ! (GXutil.strcmp("", AV34ImpLiqDetCUIL)==0) )
                           {
                              GXv_boolean1[0] = AV16esNumero ;
                              new web.esnumero(remoteHandle, context).execute( AV34ImpLiqDetCUIL, GXv_boolean1) ;
                              procesouploadarchlsd_reg3.this.AV16esNumero = GXv_boolean1[0] ;
                              if ( ! AV16esNumero )
                              {
                                 AV15errorFormato = httpContext.getMessage( "Nro de liquidación inválido ", "") + AV34ImpLiqDetCUIL ;
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "fi 5", "")) ;
                                 /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                                 S111 ();
                                 if ( returnInSub )
                                 {
                                    pr_default.close(0);
                                    returnInSub = true;
                                    cleanup();
                                    if (true) return;
                                 }
                                 if (true) break;
                              }
                           }
                           if ( ! (GXutil.strcmp("", AV38ImpLiqDetCant)==0) )
                           {
                              GXv_boolean1[0] = AV16esNumero ;
                              new web.esnumero(remoteHandle, context).execute( AV38ImpLiqDetCant, GXv_boolean1) ;
                              procesouploadarchlsd_reg3.this.AV16esNumero = GXv_boolean1[0] ;
                              if ( ! AV16esNumero )
                              {
                                 AV15errorFormato = httpContext.getMessage( "cantidad inválida ", "") + AV38ImpLiqDetCant ;
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "fi 6", "")) ;
                                 /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                                 S111 ();
                                 if ( returnInSub )
                                 {
                                    pr_default.close(0);
                                    returnInSub = true;
                                    cleanup();
                                    if (true) return;
                                 }
                                 if (true) break;
                              }
                           }
                           if ( ! (GXutil.strcmp("", AV40ImpLiqDetImp)==0) )
                           {
                              GXv_boolean1[0] = AV16esNumero ;
                              new web.esnumero(remoteHandle, context).execute( AV40ImpLiqDetImp, GXv_boolean1) ;
                              procesouploadarchlsd_reg3.this.AV16esNumero = GXv_boolean1[0] ;
                              if ( ! AV16esNumero )
                              {
                                 AV15errorFormato = httpContext.getMessage( "importe inválido ", "") + AV40ImpLiqDetImp ;
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "fi 7", "")) ;
                                 /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                                 S111 ();
                                 if ( returnInSub )
                                 {
                                    pr_default.close(0);
                                    returnInSub = true;
                                    cleanup();
                                    if (true) return;
                                 }
                                 if (true) break;
                              }
                           }
                           if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV41ImpLiqDetSigno)), httpContext.getMessage( "D", "")) != 0 ) && ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV41ImpLiqDetSigno)), httpContext.getMessage( "C", "")) != 0 ) )
                           {
                              AV15errorFormato = httpContext.getMessage( "Signo inválido ", "") + AV41ImpLiqDetSigno ;
                              new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "fi 8", "")) ;
                              /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                              S111 ();
                              if ( returnInSub )
                              {
                                 pr_default.close(0);
                                 returnInSub = true;
                                 cleanup();
                                 if (true) return;
                              }
                              if (true) break;
                           }
                        }
                     }
                     else
                     {
                        new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "graba detalle", "")) ;
                        new web.grabaliqdeimplsd(remoteHandle, context).execute( AV11CliCod, AV13EmpCod, AV24ImpLiqSec, AV45ImpLiqDetSCVO, AV44ImpLiqDetCCT, AV43ImpLiqDetHijos, AV42ImpLiqDetConyu, AV41ImpLiqDetSigno, AV40ImpLiqDetImp, AV39ImpLiqDetUni, AV37ImpLiqDetConCod, AV38ImpLiqDetCant, AV36ImpLiqDetCBU, AV35ImpLiqDetLegId, AV34ImpLiqDetCUIL, AV33ImpLiqDetLiqN, AV30ImpLiqDetPer, AV52ImpLiqDetLiqClase, AV59ImpLiqDetTipoCon) ;
                        AV10altas = (short)(AV10altas+1) ;
                     }
                     AV47completo = false ;
                     AV37ImpLiqDetConCod = "" ;
                     AV38ImpLiqDetCant = "" ;
                     AV39ImpLiqDetUni = "" ;
                     AV40ImpLiqDetImp = "" ;
                     AV41ImpLiqDetSigno = "" ;
                  }
                  AV74GXV1 = (int)(AV74GXV1+1) ;
               }
               if ( ! AV49algunoCompleto )
               {
                  AV15errorFormato = "" ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "fi 9", "")) ;
                  /* Execute user subroutine: 'FORMATO INVÁLIDO' */
                  S111 ();
                  if ( returnInSub )
                  {
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
               AV18File.close();
            }
            else
            {
               AV14errores.add(httpContext.getMessage( "No se pudo abrir el archivo de LSD ", "")+GXutil.trim( A708ImpLiqLSDFileNameAndType), 0);
            }
            if ( ( AV14errores.size() == 0 ) && ( AV28vez == 2 ) )
            {
            }
            else
            {
               if ( ( AV14errores.size() > 0 ) && ( AV28vez == 1 ) )
               {
                  AV25seguir = false ;
               }
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         if ( AV73GXLvl11 == 0 )
         {
            AV14errores.add(httpContext.getMessage( "No se encuentra el registro del archivo LSD ", "")+GXutil.trim( GXutil.str( AV11CliCod, 6, 0))+"/"+GXutil.trim( GXutil.str( AV13EmpCod, 4, 0))+"/"+GXutil.trim( GXutil.str( AV24ImpLiqSec, 4, 0))+"/"+GXutil.trim( GXutil.str( AV29ImpLiqLSDSec, 4, 0)), 0);
         }
         if ( AV28vez == 1 )
         {
            if ( ! AV53registro1Hay || ! AV56registro3Hay )
            {
               AV15errorFormato = httpContext.getMessage( "No hay registro", "") ;
               if ( ! AV53registro1Hay )
               {
                  AV15errorFormato += " 01" ;
               }
               if ( ! AV56registro3Hay )
               {
                  AV15errorFormato += " 03" ;
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "fi 10", "")) ;
               /* Execute user subroutine: 'FORMATO INVÁLIDO' */
               S111 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
         }
         AV28vez = (short)(AV28vez+1) ;
      }
      if ( AV14errores.size() > 0 )
      {
         AV12e = (short)(1) ;
         AV14errores.sort("");
         while ( AV12e <= AV14errores.size() )
         {
            if ( GXutil.strcmp((String)AV14errores.elementAt(-1+AV12e), AV8ultiError) == 0 )
            {
               AV14errores.removeItem(AV12e);
            }
            else
            {
               AV8ultiError = (String)AV14errores.elementAt(-1+AV12e) ;
               AV12e = (short)(AV12e+1) ;
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'FORMATO INVÁLIDO' Routine */
      returnInSub = false ;
      AV51error = httpContext.getMessage( "Archivo con formato inválido ", "") ;
      if ( ! (GXutil.strcmp("", AV15errorFormato)==0) )
      {
         AV51error += "(" + GXutil.trim( AV15errorFormato) + ")" ;
      }
      AV14errores.add(AV51error, 0);
      AV14errores.add(AV19fileLine, 0);
      new web.msgdebug7(remoteHandle, context).execute( AV72Pgmname, AV19fileLine) ;
   }

   protected void cleanup( )
   {
      this.aP4[0] = procesouploadarchlsd_reg3.this.AV14errores;
      this.aP5[0] = procesouploadarchlsd_reg3.this.AV10altas;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14errores = new GXSimpleCollection<String>(String.class, "internal", "");
      AV72Pgmname = "" ;
      AV9ahora = GXutil.resetTime( GXutil.nullDate() );
      scmdbuf = "" ;
      P025Y2_A704ImpLiqLSDSec = new short[1] ;
      P025Y2_A88ImpLiqSec = new short[1] ;
      P025Y2_A1EmpCod = new short[1] ;
      P025Y2_A3CliCod = new int[1] ;
      P025Y2_A706ImpLiqLSDFileName = new String[] {""} ;
      P025Y2_A707ImpLiqLSDFileType = new String[] {""} ;
      P025Y2_A705ImpLiqLSDFile = new String[] {""} ;
      P025Y2_A708ImpLiqLSDFileNameAndType = new String[] {""} ;
      A706ImpLiqLSDFileName = "" ;
      A707ImpLiqLSDFileType = "" ;
      A705ImpLiqLSDFile = "" ;
      A708ImpLiqLSDFileNameAndType = "" ;
      AV18File = new com.genexus.util.GXFile();
      AV27varcharcollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19fileLine = "" ;
      AV15errorFormato = "" ;
      AV31tipoRegistro = "" ;
      AV37ImpLiqDetConCod = "" ;
      AV38ImpLiqDetCant = "" ;
      AV39ImpLiqDetUni = "" ;
      AV40ImpLiqDetImp = "" ;
      AV41ImpLiqDetSigno = "" ;
      AV34ImpLiqDetCUIL = "" ;
      AV30ImpLiqDetPer = "" ;
      AV33ImpLiqDetLiqN = "" ;
      AV52ImpLiqDetLiqClase = "" ;
      AV63ImpLiqLSDLegId = "" ;
      AV64ImpLiqLSDLegCBU = "" ;
      AV69fechaStr = "" ;
      AV61ImpLiqLSDLegFecPag = GXutil.nullDate() ;
      AV67ImpLiqLSDDepRev = "" ;
      AV68ImpLiqLSDForPag = "" ;
      GXv_boolean1 = new boolean[1] ;
      AV45ImpLiqDetSCVO = "" ;
      AV44ImpLiqDetCCT = "" ;
      AV43ImpLiqDetHijos = "" ;
      AV42ImpLiqDetConyu = "" ;
      AV36ImpLiqDetCBU = "" ;
      AV35ImpLiqDetLegId = "" ;
      AV59ImpLiqDetTipoCon = "" ;
      AV8ultiError = "" ;
      AV51error = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.procesouploadarchlsd_reg3__default(),
         new Object[] {
             new Object[] {
            P025Y2_A704ImpLiqLSDSec, P025Y2_A88ImpLiqSec, P025Y2_A1EmpCod, P025Y2_A3CliCod, P025Y2_A706ImpLiqLSDFileName, P025Y2_A707ImpLiqLSDFileType, P025Y2_A705ImpLiqLSDFile, P025Y2_A708ImpLiqLSDFileNameAndType
            }
         }
      );
      AV72Pgmname = "ProcesoUploadArchLSD_Reg3" ;
      /* GeneXus formulas. */
      AV72Pgmname = "ProcesoUploadArchLSD_Reg3" ;
      Gx_err = (short)(0) ;
   }

   private byte AV73GXLvl11 ;
   private byte AV66ImpLiqLSDLegHijos ;
   private short AV13EmpCod ;
   private short AV24ImpLiqSec ;
   private short AV29ImpLiqLSDSec ;
   private short AV10altas ;
   private short AV28vez ;
   private short A704ImpLiqLSDSec ;
   private short A88ImpLiqSec ;
   private short A1EmpCod ;
   private short AV17f ;
   private short AV60ImpLiqLSDLegDiasLiq ;
   private short AV12e ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private int AV74GXV1 ;
   private long AV62ImpLiqLSDCuil ;
   private String AV72Pgmname ;
   private String scmdbuf ;
   private String A707ImpLiqLSDFileType ;
   private String AV19fileLine ;
   private String AV31tipoRegistro ;
   private String AV37ImpLiqDetConCod ;
   private String AV38ImpLiqDetCant ;
   private String AV39ImpLiqDetUni ;
   private String AV40ImpLiqDetImp ;
   private String AV41ImpLiqDetSigno ;
   private String AV34ImpLiqDetCUIL ;
   private String AV30ImpLiqDetPer ;
   private String AV33ImpLiqDetLiqN ;
   private String AV52ImpLiqDetLiqClase ;
   private String AV63ImpLiqLSDLegId ;
   private String AV64ImpLiqLSDLegCBU ;
   private String AV69fechaStr ;
   private String AV67ImpLiqLSDDepRev ;
   private String AV68ImpLiqLSDForPag ;
   private String AV45ImpLiqDetSCVO ;
   private String AV44ImpLiqDetCCT ;
   private String AV43ImpLiqDetHijos ;
   private String AV42ImpLiqDetConyu ;
   private String AV35ImpLiqDetLegId ;
   private String AV59ImpLiqDetTipoCon ;
   private java.util.Date AV9ahora ;
   private java.util.Date AV61ImpLiqLSDLegFecPag ;
   private boolean AV25seguir ;
   private boolean AV47completo ;
   private boolean AV49algunoCompleto ;
   private boolean AV56registro3Hay ;
   private boolean AV53registro1Hay ;
   private boolean AV65ImpLiqLSDLegCony ;
   private boolean returnInSub ;
   private boolean AV32tipoDeRegistroInvalido ;
   private boolean AV16esNumero ;
   private boolean GXv_boolean1[] ;
   private String A705ImpLiqLSDFile ;
   private String A706ImpLiqLSDFileName ;
   private String A708ImpLiqLSDFileNameAndType ;
   private String AV15errorFormato ;
   private String AV36ImpLiqDetCBU ;
   private String AV8ultiError ;
   private String AV51error ;
   private com.genexus.util.GXFile AV18File ;
   private short[] aP5 ;
   private GXSimpleCollection<String>[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P025Y2_A704ImpLiqLSDSec ;
   private short[] P025Y2_A88ImpLiqSec ;
   private short[] P025Y2_A1EmpCod ;
   private int[] P025Y2_A3CliCod ;
   private String[] P025Y2_A706ImpLiqLSDFileName ;
   private String[] P025Y2_A707ImpLiqLSDFileType ;
   private String[] P025Y2_A705ImpLiqLSDFile ;
   private String[] P025Y2_A708ImpLiqLSDFileNameAndType ;
   private GXSimpleCollection<String> AV27varcharcollection ;
   private GXSimpleCollection<String> AV14errores ;
}

final  class procesouploadarchlsd_reg3__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P025Y2", "SELECT ImpLiqLSDSec, ImpLiqSec, EmpCod, CliCod, ImpLiqLSDFileName, ImpLiqLSDFileType, ImpLiqLSDFile, ImpLiqLSDFileNameAndType FROM importacion_liquidacion_lsd WHERE CliCod = ? and EmpCod = ? and ImpLiqSec = ? and ImpLiqLSDSec = ? ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqLSDSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getBLOBFile(7, rslt.getString(6, 20), rslt.getVarchar(5));
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
      }
   }

}

