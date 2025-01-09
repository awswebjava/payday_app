package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calparvalidavalor extends GXProcedure
{
   public calparvalidavalor( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calparvalidavalor.class ), "" );
   }

   public calparvalidavalor( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<String> executeUdp( int aP0 ,
                                                 short aP1 ,
                                                 GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> aP2 ,
                                                 web.Sdtcal_par_valores_cal_par_valoresItem[] aP3 ,
                                                 GXSimpleCollection<String>[] aP4 ,
                                                 String[] aP5 )
   {
      calparvalidavalor.this.aP6 = new GXSimpleCollection[] {new GXSimpleCollection<String>(String.class, "internal", "")};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> aP2 ,
                        web.Sdtcal_par_valores_cal_par_valoresItem[] aP3 ,
                        GXSimpleCollection<String>[] aP4 ,
                        String[] aP5 ,
                        GXSimpleCollection<String>[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> aP2 ,
                             web.Sdtcal_par_valores_cal_par_valoresItem[] aP3 ,
                             GXSimpleCollection<String>[] aP4 ,
                             String[] aP5 ,
                             GXSimpleCollection<String>[] aP6 )
   {
      calparvalidavalor.this.AV10CliCod = aP0;
      calparvalidavalor.this.AV27PaiCod = aP1;
      calparvalidavalor.this.AV31auxCal_par_valores = aP2;
      calparvalidavalor.this.AV13item = aP3[0];
      this.aP3 = aP3;
      calparvalidavalor.this.AV19split = aP4[0];
      this.aP4 = aP4;
      calparvalidavalor.this.aP5 = aP5;
      calparvalidavalor.this.AV23invalidasPalabra = aP6[0];
      this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV18parmCalParCampo = AV13item.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparcampo() ;
      AV9CalParValLista = AV13item.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparvallista() ;
      AV17CalParNombre = AV13item.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparnombre() ;
      AV26CalParId = AV13item.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid() ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "...........&&CalParNombre--> ", "")+AV17CalParNombre) ;
      AV20s = (short)(1) ;
      if ( AV19split.size() == 0 )
      {
         AV11error = httpContext.getMessage( "No hay relación para parámetro ", "") + GXutil.trim( AV17CalParNombre) ;
      }
      else
      {
         while ( AV20s <= AV19split.size() )
         {
            AV15palabra = (String)AV19split.elementAt(-1+AV20s) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "...........&&&palabra ", "")+AV15palabra) ;
            AV33entroPorOther = false ;
            if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV18parmCalParCampo)), httpContext.getMessage( "MOTIVOS_EGRESO.MEGCODIGO", "")) == 0 )
            {
               GXv_boolean1[0] = AV14ok ;
               new web.getmotivodeegreso(remoteHandle, context).execute( AV10CliCod, GXutil.trim( AV15palabra), "", GXv_boolean1) ;
               calparvalidavalor.this.AV14ok = GXv_boolean1[0] ;
               /* Execute user subroutine: 'EVALUAR RESULTADO' */
               S121 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV18parmCalParCampo)), httpContext.getMessage( "OBRAS_SOCIALES.OSOCODIGO", "")) == 0 )
            {
               AV11error = "" ;
               GXv_char2[0] = "" ;
               GXv_boolean1[0] = AV14ok ;
               new web.getobrasocial(remoteHandle, context).execute( AV10CliCod, GXutil.trim( AV15palabra), GXv_char2, GXv_boolean1) ;
               calparvalidavalor.this.AV14ok = GXv_boolean1[0] ;
               /* Execute user subroutine: 'EVALUAR RESULTADO' */
               S121 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV18parmCalParCampo)), httpContext.getMessage( "SEXOS.SEXOID", "")) == 0 )
            {
               GXv_int3[0] = (byte)(0) ;
               GXv_boolean1[0] = AV14ok ;
               new web.getsexoidporcodfor(remoteHandle, context).execute( AV27PaiCod, GXutil.trim( AV15palabra), GXv_int3, GXv_boolean1) ;
               calparvalidavalor.this.AV14ok = GXv_boolean1[0] ;
               /* Execute user subroutine: 'EVALUAR RESULTADO' */
               S121 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV18parmCalParCampo)), httpContext.getMessage( "PROPIEDAD_ADICIONAL.PROPCOD", "")) == 0 )
            {
               GXv_char2[0] = "" ;
               GXv_boolean1[0] = AV14ok ;
               new web.getpropiedadadicional(remoteHandle, context).execute( GXutil.trim( AV15palabra), GXv_char2, GXv_boolean1) ;
               calparvalidavalor.this.AV14ok = GXv_boolean1[0] ;
               /* Execute user subroutine: 'EVALUAR RESULTADO' */
               S121 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV18parmCalParCampo)), httpContext.getMessage( "SINDICATOS.SINCODIGO", "")) == 0 )
            {
               GXv_char2[0] = "" ;
               GXv_boolean1[0] = AV14ok ;
               new web.getsindicato(remoteHandle, context).execute( AV10CliCod, GXutil.trim( AV15palabra), GXv_char2, GXv_boolean1) ;
               calparvalidavalor.this.AV14ok = GXv_boolean1[0] ;
               /* Execute user subroutine: 'EVALUAR RESULTADO' */
               S121 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV18parmCalParCampo)), httpContext.getMessage( "PERIODO.PERIODOANIOMES", "")) == 0 )
            {
               GXv_date4[0] = AV34fecha ;
               GXv_boolean1[0] = AV14ok ;
               new web.getperiodoporaniomes(remoteHandle, context).execute( AV10CliCod, (short)(0), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV15palabra, "."))), GXv_date4, GXv_boolean1) ;
               calparvalidavalor.this.AV34fecha = GXv_date4[0] ;
               calparvalidavalor.this.AV14ok = GXv_boolean1[0] ;
               /* Execute user subroutine: 'EVALUAR RESULTADO' */
               S121 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV18parmCalParCampo)), httpContext.getMessage( "TIPO_APLICACION_GANANCIAS.APLIIGG	", "")) == 0 )
            {
               GXv_char2[0] = "" ;
               GXv_boolean1[0] = AV14ok ;
               new web.gettipoaplganancias(remoteHandle, context).execute( AV10CliCod, (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV15palabra, "."))), GXv_char2, GXv_boolean1) ;
               calparvalidavalor.this.AV14ok = GXv_boolean1[0] ;
               /* Execute user subroutine: 'EVALUAR RESULTADO' */
               S121 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV18parmCalParCampo)), httpContext.getMessage( "AREAS.SECCODIGO", "")) == 0 )
            {
               GXv_char2[0] = "" ;
               GXv_boolean1[0] = AV14ok ;
               new web.getseccion(remoteHandle, context).execute( AV10CliCod, GXutil.trim( AV15palabra), GXv_char2, GXv_boolean1) ;
               calparvalidavalor.this.AV14ok = GXv_boolean1[0] ;
               /* Execute user subroutine: 'EVALUAR RESULTADO' */
               S121 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV18parmCalParCampo)), httpContext.getMessage( "PAIS_TIPO_TRABAJO.PAITIPOTRAID", "")) == 0 )
            {
               AV35PaiTipoTraId = GXutil.trim( "") ;
               GXv_char2[0] = "" ;
               GXv_boolean1[0] = AV14ok ;
               new web.gettipotrabajo(remoteHandle, context).execute( AV27PaiCod, AV35PaiTipoTraId, GXv_char2, GXv_boolean1) ;
               calparvalidavalor.this.AV14ok = GXv_boolean1[0] ;
               /* Execute user subroutine: 'EVALUAR RESULTADO' */
               S121 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV18parmCalParCampo)), httpContext.getMessage( "CLIENTE_CCT.CLICONVENIO", "")) == 0 )
            {
               GXv_char2[0] = "" ;
               GXv_boolean1[0] = AV14ok ;
               new web.getconvenio(remoteHandle, context).execute( AV10CliCod, GXutil.trim( AV15palabra), GXv_char2, GXv_boolean1) ;
               calparvalidavalor.this.AV14ok = GXv_boolean1[0] ;
               /* Execute user subroutine: 'EVALUAR RESULTADO' */
               S121 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV18parmCalParCampo)), httpContext.getMessage( "CONVENIO_ADICIONAL_OPCIONES.CONVEADIOPCFOR", "")) == 0 )
            {
               AV44GXV1 = 1 ;
               while ( AV44GXV1 <= AV31auxCal_par_valores.size() )
               {
                  AV32auxItem = (web.Sdtcal_par_valores_cal_par_valoresItem)((web.Sdtcal_par_valores_cal_par_valoresItem)AV31auxCal_par_valores.elementAt(-1+AV44GXV1));
                  if ( GXutil.strcmp(AV32auxItem.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid(), "Adicional") == 0 )
                  {
                     AV30ConveAdicod = GXutil.trim( AV32auxItem.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value()) ;
                     if (true) break;
                  }
                  AV44GXV1 = (int)(AV44GXV1+1) ;
               }
               if ( (GXutil.strcmp("", AV30ConveAdicod)==0) )
               {
                  AV11error = httpContext.getMessage( "No se pudo recuperar adicional para buscar opción de adicional", "") ;
               }
               else
               {
                  GXv_boolean1[0] = AV14ok ;
                  new web.convenioadicionalopcionexiste(remoteHandle, context).execute( AV10CliCod, AV27PaiCod, "", AV30ConveAdicod, (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.trim( AV15palabra), "."))), GXv_boolean1) ;
                  calparvalidavalor.this.AV14ok = GXv_boolean1[0] ;
                  /* Execute user subroutine: 'EVALUAR RESULTADO' */
                  S121 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
            }
            else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV18parmCalParCampo)), httpContext.getMessage( "CONVENIO_ADICIONALES.CONVEADICOD", "")) == 0 )
            {
               AV45GXV2 = 1 ;
               while ( AV45GXV2 <= AV31auxCal_par_valores.size() )
               {
                  AV32auxItem = (web.Sdtcal_par_valores_cal_par_valoresItem)((web.Sdtcal_par_valores_cal_par_valoresItem)AV31auxCal_par_valores.elementAt(-1+AV45GXV2));
                  if ( GXutil.strcmp(AV32auxItem.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid(), "Convenio") == 0 )
                  {
                     AV36ConveCodigo = GXutil.trim( AV32auxItem.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value()) ;
                     if (true) break;
                  }
                  AV45GXV2 = (int)(AV45GXV2+1) ;
               }
               if ( (GXutil.strcmp("", AV36ConveCodigo)==0) )
               {
                  AV11error = httpContext.getMessage( "No se pudo recuperar convenio para buscar adicional", "") ;
               }
               else
               {
                  GXv_boolean1[0] = AV14ok ;
                  new web.convenioadicionalexiste(remoteHandle, context).execute( AV10CliCod, AV27PaiCod, AV30ConveAdicod, GXutil.trim( AV15palabra), GXv_boolean1) ;
                  calparvalidavalor.this.AV14ok = GXv_boolean1[0] ;
                  /* Execute user subroutine: 'EVALUAR RESULTADO' */
                  S121 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
            }
            else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV18parmCalParCampo)), httpContext.getMessage( "PAIS_TIPO_OBLIGACION.TIPOOBLCODIGO", "")) == 0 )
            {
               GXv_int5[0] = (short)(0) ;
               GXv_boolean1[0] = false ;
               GXv_int3[0] = AV28tipo_total_embargo ;
               GXv_int6[0] = (short)(0) ;
               GXv_char2[0] = AV29auxError ;
               GXv_int7[0] = (byte)(0) ;
               new web.gettipooblsecporcodigo(remoteHandle, context).execute( AV27PaiCod, GXutil.trim( AV15palabra), GXv_int5, GXv_boolean1, GXv_int3, GXv_int6, GXv_char2, GXv_int7) ;
               calparvalidavalor.this.AV28tipo_total_embargo = GXv_int3[0] ;
               calparvalidavalor.this.AV29auxError = GXv_char2[0] ;
               if ( ! (GXutil.strcmp("", AV29auxError)==0) )
               {
                  AV14ok = false ;
               }
               else
               {
                  AV14ok = true ;
               }
               /* Execute user subroutine: 'EVALUAR RESULTADO' */
               S121 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else if ( GXutil.strcmp(AV26CalParId, "SueldoBasico") == 0 )
            {
               AV22coincide = false ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "sueldo basico fix &palabra ", "")+AV15palabra) ;
               if ( CommonUtil.decimalVal( AV15palabra, ".").doubleValue() > 0 )
               {
                  if ( ( GXutil.strSearch( AV15palabra, ".", 1) != 0 ) || ( GXutil.strSearch( AV15palabra, ",", 1) != 0 ) )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "fix sieñdp coincide!", "")) ;
                     /* Execute user subroutine: 'COINCIDENCIA' */
                     S111 ();
                     if ( returnInSub )
                     {
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                  }
               }
               AV23invalidasPalabra.add(GXutil.trim( AV15palabra), 0);
               AV11error = httpContext.getMessage( "Formato incorrecto para ", "") + GXutil.trim( AV17CalParNombre) + httpContext.getMessage( ". Debe ser un número con decimales", "") ;
            }
            else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV18parmCalParCampo)), httpContext.getMessage( "CONCEPTOS.CONCODIGO", "")) == 0 )
            {
               GXv_boolean1[0] = AV14ok ;
               new web.existeconcepto(remoteHandle, context).execute( AV10CliCod, GXutil.trim( AV15palabra), GXv_boolean1) ;
               calparvalidavalor.this.AV14ok = GXv_boolean1[0] ;
               /* Execute user subroutine: 'EVALUAR RESULTADO' */
               S121 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV18parmCalParCampo)), httpContext.getMessage( "PAIS_TIPOS_DE_LIQUIDACION.TLIQCOD", "")) == 0 )
            {
               GXv_char2[0] = "" ;
               GXv_boolean1[0] = AV14ok ;
               new web.gettipoliqdepalabra(remoteHandle, context).execute( AV10CliCod, GXutil.trim( AV15palabra), GXv_char2, GXv_boolean1) ;
               calparvalidavalor.this.AV14ok = GXv_boolean1[0] ;
               /* Execute user subroutine: 'EVALUAR RESULTADO' */
               S121 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV18parmCalParCampo)), httpContext.getMessage( "CLIENTE_CCT_CATEGORIAS.CATCODIGO", "")) == 0 )
            {
               GXv_boolean1[0] = AV14ok ;
               new web.existecategoria(remoteHandle, context).execute( AV10CliCod, AV27PaiCod, GXutil.trim( AV15palabra), GXv_boolean1) ;
               calparvalidavalor.this.AV14ok = GXv_boolean1[0] ;
               /* Execute user subroutine: 'EVALUAR RESULTADO' */
               S121 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else
            {
               AV33entroPorOther = true ;
               AV37lista_validos = "" ;
               AV38sdt_ParValLista.fromJSonString(AV9CalParValLista, null);
               AV40v = (short)(1) ;
               AV46GXV3 = 1 ;
               while ( AV46GXV3 <= AV38sdt_ParValLista.size() )
               {
                  AV39itemSdtParValLista = (web.Sdtsdt_ParValLista_sdt_ParValListaItem)((web.Sdtsdt_ParValLista_sdt_ParValListaItem)AV38sdt_ParValLista.elementAt(-1+AV46GXV3));
                  AV37lista_validos += GXutil.trim( AV39itemSdtParValLista.getgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Valor()) ;
                  if ( AV40v != AV38sdt_ParValLista.size() )
                  {
                     AV37lista_validos += "|" ;
                  }
                  AV40v = (short)(AV40v+1) ;
                  AV46GXV3 = (int)(AV46GXV3+1) ;
               }
               AV8CalParCampo = GXutil.strReplace( AV18parmCalParCampo, httpContext.getMessage( "{LISTA_VALIDOS}", ""), GXutil.trim( AV37lista_validos)) ;
               AV8CalParCampo = GXutil.upper( AV8CalParCampo) ;
               if ( ! GxRegex.IsMatch(AV15palabra,AV8CalParCampo) )
               {
                  AV22coincide = false ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "hay fix? &CalParId ", "")+AV26CalParId) ;
                  if ( GXutil.strcmp(AV26CalParId, "Periodo") == 0 )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "periodo fix &palabra ", "")+AV15palabra) ;
                     if ( CommonUtil.decimalVal( AV15palabra, ".").doubleValue() > 0 )
                     {
                        new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "es numero lenght ", "")+GXutil.str( GXutil.len( GXutil.trim( AV15palabra)), 10, 0)) ;
                        if ( GXutil.len( GXutil.trim( AV15palabra)) == 6 )
                        {
                           new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "cuatro primeros ", "")+GXutil.substring( AV15palabra, 1, 4)) ;
                           if ( CommonUtil.decimalVal( GXutil.substring( AV15palabra, 1, 4), ".").doubleValue() >= 1900 )
                           {
                              new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "dos ultimos ", "")+GXutil.substring( AV15palabra, 5, 2)) ;
                              if ( ( CommonUtil.decimalVal( GXutil.substring( AV15palabra, 5, 2), ".").doubleValue() >= 1 ) && ( CommonUtil.decimalVal( GXutil.substring( AV15palabra, 5, 2), ".").doubleValue() <= 12 ) )
                              {
                                 AV22coincide = true ;
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "fix coincide", "")) ;
                              }
                           }
                        }
                     }
                  }
                  else
                  {
                  }
               }
               else
               {
                  AV22coincide = true ;
               }
               if ( ! AV22coincide )
               {
                  AV23invalidasPalabra.add(GXutil.trim( AV15palabra), 0);
                  new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "!&CalParCampo ", "")+AV8CalParCampo+httpContext.getMessage( " NO coincide con ", "")+AV15palabra) ;
                  if ( ! (GXutil.strcmp("", AV9CalParValLista)==0) )
                  {
                     AV37lista_validos = "" ;
                     AV38sdt_ParValLista.fromJSonString(AV9CalParValLista, null);
                     AV40v = (short)(1) ;
                     AV47GXV4 = 1 ;
                     while ( AV47GXV4 <= AV38sdt_ParValLista.size() )
                     {
                        AV39itemSdtParValLista = (web.Sdtsdt_ParValLista_sdt_ParValListaItem)((web.Sdtsdt_ParValLista_sdt_ParValListaItem)AV38sdt_ParValLista.elementAt(-1+AV47GXV4));
                        AV16palabras.add(GXutil.trim( AV39itemSdtParValLista.getgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Valor()), 0);
                        AV40v = (short)(AV40v+1) ;
                        AV47GXV4 = (int)(AV47GXV4+1) ;
                     }
                     if ( AV16palabras.size() > 0 )
                     {
                        AV11error = httpContext.getMessage( ". Valores permitidos para ", "") + GXutil.trim( AV17CalParNombre) + ": " ;
                        AV12i = (short)(1) ;
                        while ( AV12i <= AV16palabras.size() )
                        {
                           AV11error += GXutil.trim( (String)AV16palabras.elementAt(-1+AV12i)) + ", " ;
                           AV12i = (short)(AV12i+1) ;
                        }
                     }
                     else
                     {
                        AV11error = httpContext.getMessage( "LISTA VACIA", "") ;
                     }
                  }
                  else
                  {
                     AV11error = httpContext.getMessage( ". Formato incorrecto para ", "") + GXutil.trim( AV17CalParNombre) + ", " ;
                  }
               }
               else
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "!&CalParCampo ", "")+AV8CalParCampo+httpContext.getMessage( " COINCIDE con ", "")+AV15palabra) ;
                  /* Execute user subroutine: 'COINCIDENCIA' */
                  S111 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
            }
            AV20s = (short)(AV20s+1) ;
         }
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "fin &error sdfgfd ", "")+GXutil.trim( AV11error)) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'COINCIDENCIA' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "coincide ", "")+AV15palabra+httpContext.getMessage( " con ", "")+AV17CalParNombre) ;
      AV13item.setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value( AV15palabra );
      AV11error = "" ;
      AV24r = (short)(1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "&invalidasPalabra ", "")+AV23invalidasPalabra.toJSonString(false)) ;
      while ( AV24r <= AV23invalidasPalabra.size() )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "&invalidasPalabra ", "")+GXutil.upper( GXutil.trim( (String)AV23invalidasPalabra.elementAt(-1+AV24r)))+httpContext.getMessage( " palabra ", "")+GXutil.upper( GXutil.trim( AV15palabra))) ;
         if ( GXutil.strcmp(GXutil.upper( GXutil.trim( (String)AV23invalidasPalabra.elementAt(-1+AV24r))), GXutil.upper( GXutil.trim( AV15palabra))) == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "remueve ", "")) ;
            AV23invalidasPalabra.removeItem(AV24r);
         }
         else
         {
            AV24r = (short)(AV24r+1) ;
         }
      }
      AV19split.removeItem(AV20s);
      returnInSub = true;
      if (true) return;
   }

   public void S121( )
   {
      /* 'EVALUAR RESULTADO' Routine */
      returnInSub = false ;
      if ( ! AV14ok )
      {
         AV11error = httpContext.getMessage( "Código de ", "") + GXutil.trim( AV17CalParNombre) + httpContext.getMessage( " inexistente \"", "") + GXutil.trim( AV15palabra) + "\"" ;
         AV23invalidasPalabra.add(GXutil.trim( AV15palabra), 0);
      }
      else
      {
         /* Execute user subroutine: 'COINCIDENCIA' */
         S111 ();
         if (returnInSub) return;
      }
   }

   protected void cleanup( )
   {
      this.aP3[0] = calparvalidavalor.this.AV13item;
      this.aP4[0] = calparvalidavalor.this.AV19split;
      this.aP5[0] = calparvalidavalor.this.AV11error;
      this.aP6[0] = calparvalidavalor.this.AV23invalidasPalabra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11error = "" ;
      AV18parmCalParCampo = "" ;
      AV9CalParValLista = "" ;
      AV17CalParNombre = "" ;
      AV26CalParId = "" ;
      AV43Pgmname = "" ;
      AV15palabra = "" ;
      AV34fecha = GXutil.nullDate() ;
      GXv_date4 = new java.util.Date[1] ;
      AV35PaiTipoTraId = "" ;
      AV32auxItem = new web.Sdtcal_par_valores_cal_par_valoresItem(remoteHandle, context);
      AV30ConveAdicod = "" ;
      AV36ConveCodigo = "" ;
      GXv_int5 = new short[1] ;
      GXv_int3 = new byte[1] ;
      GXv_int6 = new short[1] ;
      AV29auxError = "" ;
      GXv_int7 = new byte[1] ;
      GXv_char2 = new String[1] ;
      GXv_boolean1 = new boolean[1] ;
      AV37lista_validos = "" ;
      AV38sdt_ParValLista = new GXBaseCollection<web.Sdtsdt_ParValLista_sdt_ParValListaItem>(web.Sdtsdt_ParValLista_sdt_ParValListaItem.class, "sdt_ParValListaItem", "PayDay", remoteHandle);
      AV39itemSdtParValLista = new web.Sdtsdt_ParValLista_sdt_ParValListaItem(remoteHandle, context);
      AV8CalParCampo = "" ;
      AV16palabras = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43Pgmname = "CalParValidaValor" ;
      /* GeneXus formulas. */
      AV43Pgmname = "CalParValidaValor" ;
      Gx_err = (short)(0) ;
   }

   private byte AV28tipo_total_embargo ;
   private byte GXv_int3[] ;
   private byte GXv_int7[] ;
   private short AV27PaiCod ;
   private short AV20s ;
   private short GXv_int5[] ;
   private short GXv_int6[] ;
   private short AV40v ;
   private short AV12i ;
   private short AV24r ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV44GXV1 ;
   private int AV45GXV2 ;
   private int AV46GXV3 ;
   private int AV47GXV4 ;
   private String AV26CalParId ;
   private String AV43Pgmname ;
   private String AV15palabra ;
   private String AV35PaiTipoTraId ;
   private String AV30ConveAdicod ;
   private String AV36ConveCodigo ;
   private String GXv_char2[] ;
   private java.util.Date AV34fecha ;
   private java.util.Date GXv_date4[] ;
   private boolean AV33entroPorOther ;
   private boolean AV14ok ;
   private boolean returnInSub ;
   private boolean AV22coincide ;
   private boolean GXv_boolean1[] ;
   private String AV11error ;
   private String AV18parmCalParCampo ;
   private String AV9CalParValLista ;
   private String AV17CalParNombre ;
   private String AV29auxError ;
   private String AV37lista_validos ;
   private String AV8CalParCampo ;
   private GXSimpleCollection<String>[] aP6 ;
   private web.Sdtcal_par_valores_cal_par_valoresItem[] aP3 ;
   private GXSimpleCollection<String>[] aP4 ;
   private String[] aP5 ;
   private GXSimpleCollection<String> AV19split ;
   private GXSimpleCollection<String> AV23invalidasPalabra ;
   private GXSimpleCollection<String> AV16palabras ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> AV31auxCal_par_valores ;
   private GXBaseCollection<web.Sdtsdt_ParValLista_sdt_ParValListaItem> AV38sdt_ParValLista ;
   private web.Sdtcal_par_valores_cal_par_valoresItem AV13item ;
   private web.Sdtcal_par_valores_cal_par_valoresItem AV32auxItem ;
   private web.Sdtsdt_ParValLista_sdt_ParValListaItem AV39itemSdtParValLista ;
}

