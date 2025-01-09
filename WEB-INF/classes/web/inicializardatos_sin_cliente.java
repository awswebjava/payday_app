package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inicializardatos_sin_cliente extends GXProcedure
{
   public inicializardatos_sin_cliente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inicializardatos_sin_cliente.class ), "" );
   }

   public inicializardatos_sin_cliente( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( short aP0 )
   {
      inicializardatos_sin_cliente.this.AV30PaiCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "11 &PaiCod ", "")+GXutil.str( AV30PaiCod, 4, 0)) ;
      AV73GXLvl9 = (byte)(0) ;
      /* Using cursor P001N2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1923RolId = P001N2_A1923RolId[0] ;
         AV73GXLvl9 = (byte)(1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV73GXLvl9 == 0 )
      {
         /*
            INSERT RECORD ON TABLE RolUsuario

         */
         A1923RolId = (byte)(1) ;
         A1924RolNombre = httpContext.getMessage( "Backend", "") ;
         /* Using cursor P001N3 */
         pr_default.execute(1, new Object[] {Byte.valueOf(A1923RolId), A1924RolNombre});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("RolUsuario");
         if ( (pr_default.getStatus(1) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      AV74GXLvl21 = (byte)(0) ;
      /* Using cursor P001N4 */
      pr_default.execute(2);
      while ( (pr_default.getStatus(2) != 101) )
      {
         A1923RolId = P001N4_A1923RolId[0] ;
         AV74GXLvl21 = (byte)(1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
      if ( AV74GXLvl21 == 0 )
      {
         /*
            INSERT RECORD ON TABLE RolUsuario

         */
         A1923RolId = (byte)(2) ;
         A1924RolNombre = httpContext.getMessage( "Liquidador", "") ;
         /* Using cursor P001N5 */
         pr_default.execute(3, new Object[] {Byte.valueOf(A1923RolId), A1924RolNombre});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("RolUsuario");
         if ( (pr_default.getStatus(3) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      AV75GXLvl31 = (byte)(0) ;
      /* Using cursor P001N6 */
      pr_default.execute(4);
      while ( (pr_default.getStatus(4) != 101) )
      {
         A1925PerfilId = P001N6_A1925PerfilId[0] ;
         AV75GXLvl31 = (byte)(1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(4);
      if ( AV75GXLvl31 == 0 )
      {
         /*
            INSERT RECORD ON TABLE Perfil

         */
         A1925PerfilId = (byte)(1) ;
         A1926PerfilNombre = httpContext.getMessage( "Núcleo", "") ;
         /* Using cursor P001N7 */
         pr_default.execute(5, new Object[] {Byte.valueOf(A1925PerfilId), A1926PerfilNombre});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Perfil");
         if ( (pr_default.getStatus(5) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      AV76GXLvl42 = (byte)(0) ;
      /* Using cursor P001N8 */
      pr_default.execute(6);
      while ( (pr_default.getStatus(6) != 101) )
      {
         A1925PerfilId = P001N8_A1925PerfilId[0] ;
         AV76GXLvl42 = (byte)(1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(6);
      if ( AV76GXLvl42 == 0 )
      {
         /*
            INSERT RECORD ON TABLE Perfil

         */
         A1925PerfilId = (byte)(2) ;
         A1926PerfilNombre = httpContext.getMessage( "País", "") ;
         /* Using cursor P001N9 */
         pr_default.execute(7, new Object[] {Byte.valueOf(A1925PerfilId), A1926PerfilNombre});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Perfil");
         if ( (pr_default.getStatus(7) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      AV77GXLvl52 = (byte)(0) ;
      /* Using cursor P001N10 */
      pr_default.execute(8);
      while ( (pr_default.getStatus(8) != 101) )
      {
         A1925PerfilId = P001N10_A1925PerfilId[0] ;
         AV77GXLvl52 = (byte)(1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(8);
      if ( AV77GXLvl52 == 0 )
      {
         /*
            INSERT RECORD ON TABLE Perfil

         */
         A1925PerfilId = (byte)(3) ;
         A1926PerfilNombre = httpContext.getMessage( "Convenio", "") ;
         /* Using cursor P001N11 */
         pr_default.execute(9, new Object[] {Byte.valueOf(A1925PerfilId), A1926PerfilNombre});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Perfil");
         if ( (pr_default.getStatus(9) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      AV78GXLvl61 = (byte)(0) ;
      /* Using cursor P001N12 */
      pr_default.execute(10);
      while ( (pr_default.getStatus(10) != 101) )
      {
         A1925PerfilId = P001N12_A1925PerfilId[0] ;
         AV78GXLvl61 = (byte)(1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(10);
      if ( AV78GXLvl61 == 0 )
      {
         /*
            INSERT RECORD ON TABLE Perfil

         */
         A1925PerfilId = (byte)(4) ;
         A1926PerfilNombre = httpContext.getMessage( "Usuario", "") ;
         /* Using cursor P001N13 */
         pr_default.execute(11, new Object[] {Byte.valueOf(A1925PerfilId), A1926PerfilNombre});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Perfil");
         if ( (pr_default.getStatus(11) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      new web.inipropiedadesadicionales(remoteHandle, context).execute( ) ;
      new web.inisvg(remoteHandle, context).execute( ) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "ini menu 1", "")) ;
      new web.inimenuitemsnucleo(remoteHandle, context).execute( ) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "ini menu 2", "")) ;
      new web.inimenuitemspais(remoteHandle, context).execute( ) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "ini menu 3", "")) ;
      new web.inimenuitemsconvenio(remoteHandle, context).execute( ) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "ini menu 4", "")) ;
      new web.inimenuitemsusuario(remoteHandle, context).execute( ) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "ini menu 5", "")) ;
      /*
         INSERT RECORD ON TABLE MetaParam

      */
      A1790MetaParmCod = httpContext.getMessage( "register_enable", "") ;
      A1791MetaParmValue = httpContext.getMessage( "true", "") ;
      /* Using cursor P001N14 */
      pr_default.execute(12, new Object[] {A1790MetaParmCod, A1791MetaParmValue});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("MetaParam");
      if ( (pr_default.getStatus(12) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      /*
         INSERT RECORD ON TABLE MetaParam

      */
      A1790MetaParmCod = httpContext.getMessage( "app_name", "") ;
      A1791MetaParmValue = httpContext.getMessage( "PagaJavaPostgreSQL", "") ;
      /* Using cursor P001N15 */
      pr_default.execute(13, new Object[] {A1790MetaParmCod, A1791MetaParmValue});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("MetaParam");
      if ( (pr_default.getStatus(13) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      if ( (0==AV30PaiCod) )
      {
         new web.grabarpuestosafipdesdejson(remoteHandle, context).execute( ) ;
         new web.ini_tipo_trabajos(remoteHandle, context).execute( ) ;
         new web.ini_religion_y_origenes(remoteHandle, context).execute( ) ;
         new web.ini_pais_cabecera(remoteHandle, context).execute( new web.paisargentina(remoteHandle, context).executeUdp( ), httpContext.getMessage( "ARGENTINA", "")) ;
         new web.inicializartipoconceptos(remoteHandle, context).execute( ) ;
         new web.inimenunucleo(remoteHandle, context).execute( (byte)(1)) ;
         new web.inimenupais(remoteHandle, context).execute( (byte)(1)) ;
         new web.inimenuconvenio(remoteHandle, context).execute( (byte)(1)) ;
         new web.inimenuusuario(remoteHandle, context).execute( (byte)(1)) ;
         new web.inimenuusuario(remoteHandle, context).execute( (byte)(2)) ;
         new web.ini_tablas_afip(remoteHandle, context).execute( ) ;
         AV79GXLvl124 = (byte)(0) ;
         /* Using cursor P001N16 */
         pr_default.execute(14);
         while ( (pr_default.getStatus(14) != 101) )
         {
            A20ZonCod = P001N16_A20ZonCod[0] ;
            AV79GXLvl124 = (byte)(1) ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(14);
         }
         pr_default.close(14);
         if ( AV79GXLvl124 == 0 )
         {
            new web.ini_zona(remoteHandle, context).execute( ) ;
         }
      }
      else
      {
         new web.ini_condiciones_concepto(remoteHandle, context).execute( AV30PaiCod) ;
         new web.ini_pais_sexos(remoteHandle, context).execute( AV30PaiCod) ;
         new web.ini_pais_estadosciviles(remoteHandle, context).execute( AV30PaiCod) ;
         new web.ini_pais_preaviso(remoteHandle, context).execute( AV30PaiCod) ;
         new web.ini_pais_tipotrayextraordinarias(remoteHandle, context).execute( AV30PaiCod) ;
         new web.inicializarferiados(remoteHandle, context).execute( AV30PaiCod) ;
         new web.inicializarpaisreligionyorigen(remoteHandle, context).execute( AV30PaiCod) ;
         /* Using cursor P001N17 */
         pr_default.execute(15, new Object[] {Short.valueOf(AV30PaiCod)});
         while ( (pr_default.getStatus(15) != 101) )
         {
            A46PaiCod = P001N17_A46PaiCod[0] ;
            A1252PaiReligDefault = P001N17_A1252PaiReligDefault[0] ;
            n1252PaiReligDefault = P001N17_n1252PaiReligDefault[0] ;
            A1252PaiReligDefault = httpContext.getMessage( "cristianismo", "") ;
            n1252PaiReligDefault = false ;
            /* Using cursor P001N18 */
            pr_default.execute(16, new Object[] {Boolean.valueOf(n1252PaiReligDefault), A1252PaiReligDefault, Short.valueOf(A46PaiCod)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("Pais");
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(15);
         new web.ini_pais_embargo(remoteHandle, context).execute( AV30PaiCod) ;
         AV81GXLvl150 = (byte)(0) ;
         /* Using cursor P001N19 */
         pr_default.execute(17);
         while ( (pr_default.getStatus(17) != 101) )
         {
            A1151ARTSec = P001N19_A1151ARTSec[0] ;
            AV81GXLvl150 = (byte)(1) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, "--2") ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(17);
         }
         pr_default.close(17);
         if ( AV81GXLvl150 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, "--3") ;
            GXv_char1[0] = AV28json ;
            new web.otros_desdearchivo(remoteHandle, context).execute( httpContext.getMessage( "arts", ""), GXv_char1) ;
            inicializardatos_sin_cliente.this.AV28json = GXv_char1[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, "--4") ;
            AV56sdt_art.fromJSonString(AV28json, null);
            new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "json ", "")+AV28json) ;
            AV82GXV1 = 1 ;
            while ( AV82GXV1 <= AV56sdt_art.size() )
            {
               AV58itemART = (web.Sdtsdt_art_sdt_artItem)((web.Sdtsdt_art_sdt_artItem)AV56sdt_art.elementAt(-1+AV82GXV1));
               /*
                  INSERT RECORD ON TABLE ART

               */
               A1149ARTPaiCod = AV30PaiCod ;
               A1152ARTNom = AV58itemART.getgxTv_Sdtsdt_art_sdt_artItem_Artnom() ;
               A1153ARTAli = AV58itemART.getgxTv_Sdtsdt_art_sdt_artItem_Artali() ;
               /* Using cursor P001N20 */
               pr_default.execute(18, new Object[] {Short.valueOf(A1149ARTPaiCod), A1152ARTNom, A1153ARTAli});
               /* Retrieving last key number assigned */
               /* Using cursor P001N21 */
               pr_default.execute(19);
               A1151ARTSec = P001N21_A1151ARTSec[0] ;
               pr_default.close(19);
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ART");
               if ( (pr_default.getStatus(18) == 1) )
               {
                  Gx_err = (short)(1) ;
                  Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
               }
               else
               {
                  Gx_err = (short)(0) ;
                  Gx_emsg = "" ;
               }
               /* End Insert */
               AV59ARTSec = A1151ARTSec ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "&ARTSec ", "")+GXutil.trim( GXutil.str( AV59ARTSec, 4, 0))) ;
               /*
                  INSERT RECORD ON TABLE ARTImportesFijos

               */
               A1151ARTSec = AV59ARTSec ;
               A1155ARTImpFijSec = (short)(1) ;
               A1156ARTImpFijFecha = localUtil.ymdtod( 2022, 1, 1) ;
               A1154ARTFijo = DecimalUtil.doubleToDec(262) ;
               /* Using cursor P001N22 */
               pr_default.execute(20, new Object[] {Short.valueOf(A1151ARTSec), Short.valueOf(A1155ARTImpFijSec), A1156ARTImpFijFecha, A1154ARTFijo});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ARTImportesFijos");
               if ( (pr_default.getStatus(20) == 1) )
               {
                  Gx_err = (short)(1) ;
                  Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
               }
               else
               {
                  Gx_err = (short)(0) ;
                  Gx_emsg = "" ;
               }
               /* End Insert */
               AV82GXV1 = (int)(AV82GXV1+1) ;
            }
         }
         GXt_objcol_SdtProvincia2 = AV16provincia ;
         GXv_objcol_SdtProvincia3[0] = GXt_objcol_SdtProvincia2 ;
         new web.provincia_dataprovider(remoteHandle, context).execute( GXv_objcol_SdtProvincia3) ;
         GXt_objcol_SdtProvincia2 = GXv_objcol_SdtProvincia3[0] ;
         AV16provincia = GXt_objcol_SdtProvincia2 ;
         AV83GXV2 = 1 ;
         while ( AV83GXV2 <= AV16provincia.size() )
         {
            AV15pr = (web.SdtProvincia)((web.SdtProvincia)AV16provincia.elementAt(-1+AV83GXV2));
            AV15pr.Save();
            Application.commitDataStores(context, remoteHandle, pr_default, "inicializardatos_sin_cliente");
            AV83GXV2 = (int)(AV83GXV2+1) ;
         }
         GXv_Sdtlocalidades_sdt4[0] = AV12localidades_sdt;
         new web.localidadesdesdearchivo(remoteHandle, context).execute( GXv_Sdtlocalidades_sdt4) ;
         AV12localidades_sdt = GXv_Sdtlocalidades_sdt4[0] ;
         AV10i = (short)(1) ;
         while ( AV10i <= AV12localidades_sdt.getgxTv_Sdtlocalidades_sdt_Localidades().getgxTv_Sdtlocalidades_sdt_Localidades_Item().size() )
         {
            /*
               INSERT RECORD ON TABLE Localidad

            */
            A46PaiCod = ((web.Sdtlocalidades_sdt_Localidades_ItemItem)AV12localidades_sdt.getgxTv_Sdtlocalidades_sdt_Localidades().getgxTv_Sdtlocalidades_sdt_Localidades_Item().elementAt(-1+AV10i)).getgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Paicod() ;
            A47ProvCod = ((web.Sdtlocalidades_sdt_Localidades_ItemItem)AV12localidades_sdt.getgxTv_Sdtlocalidades_sdt_Localidades().getgxTv_Sdtlocalidades_sdt_Localidades_Item().elementAt(-1+AV10i)).getgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Provcod() ;
            A48LocCod = ((web.Sdtlocalidades_sdt_Localidades_ItemItem)AV12localidades_sdt.getgxTv_Sdtlocalidades_sdt_Localidades().getgxTv_Sdtlocalidades_sdt_Localidades_Item().elementAt(-1+AV10i)).getgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccod() ;
            GXv_char1[0] = AV68LocNom ;
            new web.capitalizartexto(remoteHandle, context).execute( ((web.Sdtlocalidades_sdt_Localidades_ItemItem)AV12localidades_sdt.getgxTv_Sdtlocalidades_sdt_Localidades().getgxTv_Sdtlocalidades_sdt_Localidades_Item().elementAt(-1+AV10i)).getgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Locnom(), GXv_char1) ;
            inicializardatos_sin_cliente.this.AV68LocNom = GXv_char1[0] ;
            A286LocNom = GXutil.trim( AV68LocNom) ;
            A285LocCP = GXutil.trim( GXutil.str( ((web.Sdtlocalidades_sdt_Localidades_ItemItem)AV12localidades_sdt.getgxTv_Sdtlocalidades_sdt_Localidades().getgxTv_Sdtlocalidades_sdt_Localidades_Item().elementAt(-1+AV10i)).getgxTv_Sdtlocalidades_sdt_Localidades_ItemItem_Loccp(), 8, 0)) ;
            GXv_char1[0] = AV69ZonCod ;
            new web.inigetzonaafipdelocalidad(remoteHandle, context).execute( A46PaiCod, A47ProvCod, A286LocNom, GXv_char1) ;
            inicializardatos_sin_cliente.this.AV69ZonCod = GXv_char1[0] ;
            if ( (GXutil.strcmp("", AV69ZonCod)==0) )
            {
               A2207LocaZona = "" ;
               n2207LocaZona = false ;
               n2207LocaZona = true ;
            }
            else
            {
               A2207LocaZona = AV69ZonCod ;
               n2207LocaZona = false ;
            }
            /* Using cursor P001N23 */
            pr_default.execute(21, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A47ProvCod), Short.valueOf(A48LocCod), A286LocNom, A285LocCP, Boolean.valueOf(n2207LocaZona), A2207LocaZona});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("Localidad");
            if ( (pr_default.getStatus(21) == 1) )
            {
               Gx_err = (short)(1) ;
               Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
            }
            else
            {
               Gx_err = (short)(0) ;
               Gx_emsg = "" ;
            }
            /* End Insert */
            AV10i = (short)(AV10i+1) ;
         }
         GXv_objcol_Sdtsdt_sindicato_sdt_sindicatoItem5[0] = AV26sdt_sindicato ;
         new web.ini_sindicatos(remoteHandle, context).execute( AV25CliCod, GXv_objcol_Sdtsdt_sindicato_sdt_sindicatoItem5) ;
         AV26sdt_sindicato = GXv_objcol_Sdtsdt_sindicato_sdt_sindicatoItem5[0] ;
         /*
            INSERT RECORD ON TABLE Convenio

         */
         GXt_char6 = A9ConveCodigo ;
         GXv_char1[0] = GXt_char6 ;
         new web.conveniouecara(remoteHandle, context).execute( GXv_char1) ;
         inicializardatos_sin_cliente.this.GXt_char6 = GXv_char1[0] ;
         A9ConveCodigo = GXt_char6 ;
         A160ConveDescri = httpContext.getMessage( "UECARA", "") ;
         A161ConveHabilitada = true ;
         GXt_char6 = A687ConveDescriSinAc ;
         GXv_char1[0] = GXt_char6 ;
         new web.sacaracentos2(remoteHandle, context).execute( A160ConveDescri, GXv_char1) ;
         inicializardatos_sin_cliente.this.GXt_char6 = GXv_char1[0] ;
         A687ConveDescriSinAc = GXt_char6 ;
         A935ConveSinCod = httpContext.getMessage( "UECARA", "") ;
         n935ConveSinCod = false ;
         A46PaiCod = AV30PaiCod ;
         A1915ConvBusGoogle = httpContext.getMessage( "uecara escala salarial %m %aaaa", "") ;
         n1915ConvBusGoogle = false ;
         A1916ConvBusWeb = httpContext.getMessage( "a partir del %d de %m de %aaaa", "") ;
         n1916ConvBusWeb = false ;
         A1917ConvBaseURL = httpContext.getMessage( "https://uecara.org.ar/", "") ;
         n1917ConvBaseURL = false ;
         A1918ConvScrapTipo = "Imagen" ;
         n1918ConvScrapTipo = false ;
         A1919ConvScrapTDoc = "PDF" ;
         n1919ConvScrapTDoc = false ;
         A2131ConveEscFrecAct = (short)(1) ;
         /* Using cursor P001N24 */
         pr_default.execute(22, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo, A160ConveDescri, Boolean.valueOf(A161ConveHabilitada), A687ConveDescriSinAc, Boolean.valueOf(n935ConveSinCod), A935ConveSinCod, Boolean.valueOf(n1915ConvBusGoogle), A1915ConvBusGoogle, Boolean.valueOf(n1916ConvBusWeb), A1916ConvBusWeb, Boolean.valueOf(n1917ConvBaseURL), A1917ConvBaseURL, Boolean.valueOf(n1918ConvScrapTipo), A1918ConvScrapTipo, Boolean.valueOf(n1919ConvScrapTDoc), A1919ConvScrapTDoc, Short.valueOf(A2131ConveEscFrecAct)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio");
         if ( (pr_default.getStatus(22) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE Adicional

         */
         A46PaiCod = AV30PaiCod ;
         AV37asistemnciaAdicionalCod = "asistencia" ;
         A988AdicionalCod = AV37asistemnciaAdicionalCod ;
         A989AdicionalDescrip = httpContext.getMessage( "Asistencia perfecta", "") ;
         A991AdicionalUniMed = "" ;
         A992AdicionalTipo = "NUM" ;
         A1784AdicionalReservado = "presentismo" ;
         /* Using cursor P001N25 */
         pr_default.execute(23, new Object[] {Short.valueOf(A46PaiCod), A988AdicionalCod, A989AdicionalDescrip, A991AdicionalUniMed, A992AdicionalTipo, A1784AdicionalReservado});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Adicional");
         if ( (pr_default.getStatus(23) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE Adicional

         */
         A46PaiCod = AV30PaiCod ;
         AV32antiguedadAdicionalCod = "antiguedad" ;
         A988AdicionalCod = AV32antiguedadAdicionalCod ;
         A989AdicionalDescrip = httpContext.getMessage( "Antiguedad", "") ;
         A991AdicionalUniMed = httpContext.getMessage( "años", "") ;
         A992AdicionalTipo = "NUM" ;
         A1784AdicionalReservado = "antiguedad" ;
         /* Using cursor P001N26 */
         pr_default.execute(24, new Object[] {Short.valueOf(A46PaiCod), A988AdicionalCod, A989AdicionalDescrip, A991AdicionalUniMed, A992AdicionalTipo, A1784AdicionalReservado});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Adicional");
         if ( (pr_default.getStatus(24) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE Convenio

         */
         A46PaiCod = AV30PaiCod ;
         GXt_char6 = A9ConveCodigo ;
         GXv_char1[0] = GXt_char6 ;
         new web.conveniouocra(remoteHandle, context).execute( GXv_char1) ;
         inicializardatos_sin_cliente.this.GXt_char6 = GXv_char1[0] ;
         A9ConveCodigo = GXt_char6 ;
         A160ConveDescri = httpContext.getMessage( "UOCRA", "") ;
         A161ConveHabilitada = true ;
         GXt_char6 = A687ConveDescriSinAc ;
         GXv_char1[0] = GXt_char6 ;
         new web.sacaracentos2(remoteHandle, context).execute( A160ConveDescri, GXv_char1) ;
         inicializardatos_sin_cliente.this.GXt_char6 = GXv_char1[0] ;
         A687ConveDescriSinAc = GXt_char6 ;
         A935ConveSinCod = httpContext.getMessage( "UOCRA", "") ;
         n935ConveSinCod = false ;
         A1915ConvBusGoogle = httpContext.getMessage( "uocra acuerdo paritario %m %aaaa", "") ;
         n1915ConvBusGoogle = false ;
         A1916ConvBusWeb = httpContext.getMessage( "mes de %m de %aaaa del", "") ;
         n1916ConvBusWeb = false ;
         A1917ConvBaseURL = httpContext.getMessage( "https://www.uocra.org/", "") ;
         n1917ConvBaseURL = false ;
         A1918ConvScrapTipo = "Texto" ;
         n1918ConvScrapTipo = false ;
         A1919ConvScrapTDoc = "PDF" ;
         n1919ConvScrapTDoc = false ;
         A2131ConveEscFrecAct = (short)(1) ;
         /* Using cursor P001N27 */
         pr_default.execute(25, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo, A160ConveDescri, Boolean.valueOf(A161ConveHabilitada), A687ConveDescriSinAc, Boolean.valueOf(n935ConveSinCod), A935ConveSinCod, Boolean.valueOf(n1915ConvBusGoogle), A1915ConvBusGoogle, Boolean.valueOf(n1916ConvBusWeb), A1916ConvBusWeb, Boolean.valueOf(n1917ConvBaseURL), A1917ConvBaseURL, Boolean.valueOf(n1918ConvScrapTipo), A1918ConvScrapTipo, Boolean.valueOf(n1919ConvScrapTDoc), A1919ConvScrapTDoc, Short.valueOf(A2131ConveEscFrecAct)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio");
         if ( (pr_default.getStatus(25) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /*
            INSERT RECORD ON TABLE Convenio

         */
         A46PaiCod = AV30PaiCod ;
         GXt_char6 = A9ConveCodigo ;
         GXv_char1[0] = GXt_char6 ;
         new web.conveniouocrayac(remoteHandle, context).execute( GXv_char1) ;
         inicializardatos_sin_cliente.this.GXt_char6 = GXv_char1[0] ;
         A9ConveCodigo = GXt_char6 ;
         A160ConveDescri = httpContext.getMessage( "UOCRA YACIMIENTO", "") ;
         A161ConveHabilitada = true ;
         GXt_char6 = A687ConveDescriSinAc ;
         GXv_char1[0] = GXt_char6 ;
         new web.sacaracentos2(remoteHandle, context).execute( A160ConveDescri, GXv_char1) ;
         inicializardatos_sin_cliente.this.GXt_char6 = GXv_char1[0] ;
         A687ConveDescriSinAc = GXt_char6 ;
         A935ConveSinCod = httpContext.getMessage( "UOCRAYAC", "") ;
         n935ConveSinCod = false ;
         A1915ConvBusGoogle = httpContext.getMessage( "uocra acuerdo paritario %m %aaaa", "") ;
         n1915ConvBusGoogle = false ;
         A1916ConvBusWeb = httpContext.getMessage( "mes de %m de %aaaa del", "") ;
         n1916ConvBusWeb = false ;
         A1917ConvBaseURL = httpContext.getMessage( "https://www.uocra.org/", "") ;
         n1917ConvBaseURL = false ;
         A1918ConvScrapTipo = "Texto" ;
         n1918ConvScrapTipo = false ;
         A1919ConvScrapTDoc = "PDF" ;
         n1919ConvScrapTDoc = false ;
         A2131ConveEscFrecAct = (short)(1) ;
         /* Using cursor P001N28 */
         pr_default.execute(26, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo, A160ConveDescri, Boolean.valueOf(A161ConveHabilitada), A687ConveDescriSinAc, Boolean.valueOf(n935ConveSinCod), A935ConveSinCod, Boolean.valueOf(n1915ConvBusGoogle), A1915ConvBusGoogle, Boolean.valueOf(n1916ConvBusWeb), A1916ConvBusWeb, Boolean.valueOf(n1917ConvBaseURL), A1917ConvBaseURL, Boolean.valueOf(n1918ConvScrapTipo), A1918ConvScrapTipo, Boolean.valueOf(n1919ConvScrapTDoc), A1919ConvScrapTDoc, Short.valueOf(A2131ConveEscFrecAct)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio");
         if ( (pr_default.getStatus(26) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         new web.newconvenioprops(remoteHandle, context).execute( AV30PaiCod, new web.conveniouocrayac(remoteHandle, context).executeUdp( ), httpContext.getMessage( "ES_DE_POZO", "")) ;
         new web.inicializarferiadosgremio(remoteHandle, context).execute( AV30PaiCod) ;
         AV84GXLvl336 = (byte)(0) ;
         /* Using cursor P001N29 */
         pr_default.execute(27);
         while ( (pr_default.getStatus(27) != 101) )
         {
            A16SitCodigo = P001N29_A16SitCodigo[0] ;
            AV84GXLvl336 = (byte)(1) ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(27);
         }
         pr_default.close(27);
         if ( AV84GXLvl336 == 0 )
         {
            GXv_char1[0] = AV28json ;
            new web.otros_desdearchivo(remoteHandle, context).execute( httpContext.getMessage( "situacion", ""), GXv_char1) ;
            inicializardatos_sin_cliente.this.AV28json = GXv_char1[0] ;
            AV27sdt_situacion.fromJSonString(AV28json, null);
            new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "json ", "")+AV28json) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "situacion sdt ", "")+GXutil.trim( AV27sdt_situacion.toJSonString(false))) ;
            AV85GXV3 = 1 ;
            while ( AV85GXV3 <= AV27sdt_situacion.size() )
            {
               AV29itemSituacion = (web.Sdtsdt_situacion_sdt_situacionItem)((web.Sdtsdt_situacion_sdt_situacionItem)AV27sdt_situacion.elementAt(-1+AV85GXV3));
               new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "estado insert 1", "")) ;
               /*
                  INSERT RECORD ON TABLE Estado

               */
               A16SitCodigo = AV29itemSituacion.getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitcodigo() ;
               A334SitDescrip = AV29itemSituacion.getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescrip() ;
               GXt_char6 = A685SitDescripSinAc ;
               GXv_char1[0] = GXt_char6 ;
               new web.sacaracentos2(remoteHandle, context).execute( AV29itemSituacion.getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescrip(), GXv_char1) ;
               inicializardatos_sin_cliente.this.GXt_char6 = GXv_char1[0] ;
               A685SitDescripSinAc = GXt_char6 ;
               A738SitEsLicencia = AV29itemSituacion.getgxTv_Sdtsdt_situacion_sdt_situacionItem_Siteslicencia() ;
               A739SitLicCuentaTrab = AV29itemSituacion.getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitliccuentatrab() ;
               A897SitLicMesesProm = AV29itemSituacion.getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitlicmesesprom() ;
               A898SitLicMesesProm2 = AV29itemSituacion.getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitlicmesesprom2() ;
               A913sItDescAbrev = AV29itemSituacion.getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdescabrev() ;
               A915SitDiasDivision = AV29itemSituacion.getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitdiasdivision() ;
               A916SitEsAusencia = AV29itemSituacion.getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitesausencia() ;
               A1217SitAplicaPlus = AV29itemSituacion.getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitaplicaplus() ;
               A1220SitAbsorbeFer = AV29itemSituacion.getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitabsorbefer() ;
               A1593SitPaiCod = AV30PaiCod ;
               n1593SitPaiCod = false ;
               if ( ( GXutil.strcmp(A16SitCodigo, "10") == 0 ) || ( GXutil.strcmp(A16SitCodigo, "11") == 0 ) || ( GXutil.strcmp(A16SitCodigo, "12") == 0 ) || ( GXutil.strcmp(A16SitCodigo, "13") == 0 ) || ( GXutil.strcmp(A16SitCodigo, "14") == 0 ) || ( GXutil.strcmp(A16SitCodigo, "15") == 0 ) || ( GXutil.strcmp(A16SitCodigo, "18") == 0 ) || ( GXutil.strcmp(A16SitCodigo, "19") == 0 ) || ( GXutil.strcmp(A16SitCodigo, "32") == 0 ) || ( GXutil.strcmp(A16SitCodigo, "33") == 0 ) || ( GXutil.strcmp(A16SitCodigo, "5") == 0 ) || ( GXutil.strcmp(A16SitCodigo, "6") == 0 ) || ( GXutil.strcmp(A16SitCodigo, "9") == 0 ) )
               {
                  A1598EstadoSitRevista = (short)(GXutil.lval( A16SitCodigo)) ;
                  n1598EstadoSitRevista = false ;
               }
               else
               {
                  A1598EstadoSitRevista = (short)(0) ;
                  n1598EstadoSitRevista = false ;
                  n1598EstadoSitRevista = true ;
               }
               if ( ( GXutil.strcmp(A16SitCodigo, "18") == 0 ) || ( GXutil.strcmp(A16SitCodigo, "19") == 0 ) )
               {
                  A1600EstadoSiniestro = "1" ;
                  n1600EstadoSiniestro = false ;
               }
               else
               {
                  A1600EstadoSiniestro = "0" ;
                  n1600EstadoSiniestro = false ;
               }
               if ( ( GXutil.strcmp(AV29itemSituacion.getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitcodigo(), httpContext.getMessage( "A1", "")) == 0 ) || ( GXutil.strcmp(AV29itemSituacion.getgxTv_Sdtsdt_situacion_sdt_situacionItem_Sitcodigo(), httpContext.getMessage( "T1", "")) == 0 ) )
               {
                  A1807EstadoCanPresen = true ;
               }
               else
               {
                  A1807EstadoCanPresen = false ;
               }
               if ( GXutil.strcmp(A16SitCodigo, new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV25CliCod)) == 0 )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  A1809EstadoRemCorr = true ;
               }
               else
               {
                  A1809EstadoRemCorr = false ;
               }
               A1489SitLicLimiteDef = (short)(0) ;
               A1490SitLicAdjunDef = false ;
               A1491SitLicAdjOblDef = false ;
               A1492SitLicNecApr = false ;
               A1493SitLIcIngMot = false ;
               A1494SitLicOblIngMot = false ;
               /* Using cursor P001N30 */
               pr_default.execute(28, new Object[] {A16SitCodigo, A334SitDescrip, A685SitDescripSinAc, Boolean.valueOf(A738SitEsLicencia), Boolean.valueOf(A739SitLicCuentaTrab), Byte.valueOf(A897SitLicMesesProm), Byte.valueOf(A898SitLicMesesProm2), A913sItDescAbrev, A915SitDiasDivision, Boolean.valueOf(A916SitEsAusencia), Byte.valueOf(A1217SitAplicaPlus), Boolean.valueOf(A1220SitAbsorbeFer), Short.valueOf(A1489SitLicLimiteDef), Boolean.valueOf(A1490SitLicAdjunDef), Boolean.valueOf(A1491SitLicAdjOblDef), Boolean.valueOf(A1492SitLicNecApr), Boolean.valueOf(A1493SitLIcIngMot), Boolean.valueOf(A1494SitLicOblIngMot), Boolean.valueOf(n1593SitPaiCod), Short.valueOf(A1593SitPaiCod), Boolean.valueOf(n1598EstadoSitRevista), Short.valueOf(A1598EstadoSitRevista), Boolean.valueOf(n1600EstadoSiniestro), A1600EstadoSiniestro, Boolean.valueOf(A1807EstadoCanPresen), Boolean.valueOf(A1809EstadoRemCorr)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Estado");
               if ( (pr_default.getStatus(28) == 1) )
               {
                  Gx_err = (short)(1) ;
                  Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
               }
               else
               {
                  Gx_err = (short)(0) ;
                  Gx_emsg = "" ;
               }
               /* End Insert */
               new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "estado insert 2", "")) ;
               AV85GXV3 = (int)(AV85GXV3+1) ;
            }
         }
         /*
            INSERT RECORD ON TABLE Paispromedio_horanormal_mensualizados

         */
         A46PaiCod = AV30PaiCod ;
         A37TipoConCod = "REM_ARG" ;
         A1361PaiPromFijVar = "variable" ;
         A1362PaiPromHabitual = true ;
         /* Using cursor P001N31 */
         pr_default.execute(29, new Object[] {Short.valueOf(A46PaiCod), A37TipoConCod, A1361PaiPromFijVar, Boolean.valueOf(A1362PaiPromHabitual)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Paispromedio_horanormal_mensualizados");
         if ( (pr_default.getStatus(29) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         new web.msgdebug_prod(remoteHandle, context).execute( AV72Pgmname, httpContext.getMessage( "paicod ", "")+GXutil.trim( GXutil.str( AV30PaiCod, 4, 0))) ;
         new web.grabaractlabafipdesdejson(remoteHandle, context).execute( AV30PaiCod) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "inicializardatos_sin_cliente");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV72Pgmname = "" ;
      scmdbuf = "" ;
      P001N2_A1923RolId = new byte[1] ;
      A1924RolNombre = "" ;
      Gx_emsg = "" ;
      P001N4_A1923RolId = new byte[1] ;
      P001N6_A1925PerfilId = new byte[1] ;
      A1926PerfilNombre = "" ;
      P001N8_A1925PerfilId = new byte[1] ;
      P001N10_A1925PerfilId = new byte[1] ;
      P001N12_A1925PerfilId = new byte[1] ;
      A1790MetaParmCod = "" ;
      A1791MetaParmValue = "" ;
      P001N16_A20ZonCod = new String[] {""} ;
      A20ZonCod = "" ;
      P001N17_A46PaiCod = new short[1] ;
      P001N17_A1252PaiReligDefault = new String[] {""} ;
      P001N17_n1252PaiReligDefault = new boolean[] {false} ;
      A1252PaiReligDefault = "" ;
      P001N19_A1151ARTSec = new short[1] ;
      AV28json = "" ;
      AV56sdt_art = new GXBaseCollection<web.Sdtsdt_art_sdt_artItem>(web.Sdtsdt_art_sdt_artItem.class, "sdt_artItem", "PayDay", remoteHandle);
      AV58itemART = new web.Sdtsdt_art_sdt_artItem(remoteHandle, context);
      A1152ARTNom = "" ;
      A1153ARTAli = DecimalUtil.ZERO ;
      P001N21_A1151ARTSec = new short[1] ;
      A1156ARTImpFijFecha = GXutil.nullDate() ;
      A1154ARTFijo = DecimalUtil.ZERO ;
      AV16provincia = new GXBCCollection<web.SdtProvincia>(web.SdtProvincia.class, "Provincia", "PayDay", remoteHandle);
      GXt_objcol_SdtProvincia2 = new GXBCCollection<web.SdtProvincia>(web.SdtProvincia.class, "Provincia", "PayDay", remoteHandle);
      GXv_objcol_SdtProvincia3 = new GXBCCollection[1] ;
      AV15pr = new web.SdtProvincia(remoteHandle);
      AV12localidades_sdt = new web.Sdtlocalidades_sdt(remoteHandle, context);
      GXv_Sdtlocalidades_sdt4 = new web.Sdtlocalidades_sdt[1] ;
      AV68LocNom = "" ;
      A286LocNom = "" ;
      A285LocCP = "" ;
      AV69ZonCod = "" ;
      A2207LocaZona = "" ;
      AV26sdt_sindicato = new GXBaseCollection<web.Sdtsdt_sindicato_sdt_sindicatoItem>(web.Sdtsdt_sindicato_sdt_sindicatoItem.class, "sdt_sindicatoItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtsdt_sindicato_sdt_sindicatoItem5 = new GXBaseCollection[1] ;
      A9ConveCodigo = "" ;
      A160ConveDescri = "" ;
      A687ConveDescriSinAc = "" ;
      A935ConveSinCod = "" ;
      A1915ConvBusGoogle = "" ;
      A1916ConvBusWeb = "" ;
      A1917ConvBaseURL = "" ;
      A1918ConvScrapTipo = "" ;
      A1919ConvScrapTDoc = "" ;
      AV37asistemnciaAdicionalCod = "" ;
      A988AdicionalCod = "" ;
      A989AdicionalDescrip = "" ;
      A991AdicionalUniMed = "" ;
      A992AdicionalTipo = "" ;
      A1784AdicionalReservado = "" ;
      AV32antiguedadAdicionalCod = "" ;
      P001N29_A16SitCodigo = new String[] {""} ;
      A16SitCodigo = "" ;
      AV27sdt_situacion = new GXBaseCollection<web.Sdtsdt_situacion_sdt_situacionItem>(web.Sdtsdt_situacion_sdt_situacionItem.class, "sdt_situacionItem", "PayDay", remoteHandle);
      AV29itemSituacion = new web.Sdtsdt_situacion_sdt_situacionItem(remoteHandle, context);
      A334SitDescrip = "" ;
      A685SitDescripSinAc = "" ;
      GXt_char6 = "" ;
      GXv_char1 = new String[1] ;
      A913sItDescAbrev = "" ;
      A915SitDiasDivision = DecimalUtil.ZERO ;
      A1600EstadoSiniestro = "" ;
      A37TipoConCod = "" ;
      A1361PaiPromFijVar = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.inicializardatos_sin_cliente__default(),
         new Object[] {
             new Object[] {
            P001N2_A1923RolId
            }
            , new Object[] {
            }
            , new Object[] {
            P001N4_A1923RolId
            }
            , new Object[] {
            }
            , new Object[] {
            P001N6_A1925PerfilId
            }
            , new Object[] {
            }
            , new Object[] {
            P001N8_A1925PerfilId
            }
            , new Object[] {
            }
            , new Object[] {
            P001N10_A1925PerfilId
            }
            , new Object[] {
            }
            , new Object[] {
            P001N12_A1925PerfilId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P001N16_A20ZonCod
            }
            , new Object[] {
            P001N17_A46PaiCod, P001N17_A1252PaiReligDefault, P001N17_n1252PaiReligDefault
            }
            , new Object[] {
            }
            , new Object[] {
            P001N19_A1151ARTSec
            }
            , new Object[] {
            }
            , new Object[] {
            P001N21_A1151ARTSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P001N29_A16SitCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV72Pgmname = "InicializarDatos_sin_cliente" ;
      /* GeneXus formulas. */
      AV72Pgmname = "InicializarDatos_sin_cliente" ;
      Gx_err = (short)(0) ;
   }

   private byte AV73GXLvl9 ;
   private byte A1923RolId ;
   private byte AV74GXLvl21 ;
   private byte AV75GXLvl31 ;
   private byte A1925PerfilId ;
   private byte AV76GXLvl42 ;
   private byte AV77GXLvl52 ;
   private byte AV78GXLvl61 ;
   private byte AV79GXLvl124 ;
   private byte AV81GXLvl150 ;
   private byte AV84GXLvl336 ;
   private byte A897SitLicMesesProm ;
   private byte A898SitLicMesesProm2 ;
   private byte A1217SitAplicaPlus ;
   private short AV30PaiCod ;
   private short Gx_err ;
   private short A46PaiCod ;
   private short A1151ARTSec ;
   private short A1149ARTPaiCod ;
   private short AV59ARTSec ;
   private short A1155ARTImpFijSec ;
   private short AV10i ;
   private short A47ProvCod ;
   private short A48LocCod ;
   private short A2131ConveEscFrecAct ;
   private short A1593SitPaiCod ;
   private short A1598EstadoSitRevista ;
   private short A1489SitLicLimiteDef ;
   private int GX_INS253 ;
   private int GX_INS254 ;
   private int GX_INS242 ;
   private int AV82GXV1 ;
   private int GX_INS130 ;
   private int GX_INS131 ;
   private int AV83GXV2 ;
   private int GX_INS31 ;
   private int AV25CliCod ;
   private int GX_INS106 ;
   private int GX_INS112 ;
   private int AV85GXV3 ;
   private int GX_INS46 ;
   private int GX_INS169 ;
   private java.math.BigDecimal A1153ARTAli ;
   private java.math.BigDecimal A1154ARTFijo ;
   private java.math.BigDecimal A915SitDiasDivision ;
   private String AV72Pgmname ;
   private String scmdbuf ;
   private String Gx_emsg ;
   private String A1790MetaParmCod ;
   private String A20ZonCod ;
   private String A1252PaiReligDefault ;
   private String A285LocCP ;
   private String AV69ZonCod ;
   private String A2207LocaZona ;
   private String A9ConveCodigo ;
   private String A935ConveSinCod ;
   private String A1918ConvScrapTipo ;
   private String A1919ConvScrapTDoc ;
   private String AV37asistemnciaAdicionalCod ;
   private String A988AdicionalCod ;
   private String A991AdicionalUniMed ;
   private String A992AdicionalTipo ;
   private String A1784AdicionalReservado ;
   private String AV32antiguedadAdicionalCod ;
   private String A16SitCodigo ;
   private String GXt_char6 ;
   private String GXv_char1[] ;
   private String A1600EstadoSiniestro ;
   private String A37TipoConCod ;
   private String A1361PaiPromFijVar ;
   private java.util.Date A1156ARTImpFijFecha ;
   private boolean n1252PaiReligDefault ;
   private boolean n2207LocaZona ;
   private boolean A161ConveHabilitada ;
   private boolean n935ConveSinCod ;
   private boolean n1915ConvBusGoogle ;
   private boolean n1916ConvBusWeb ;
   private boolean n1917ConvBaseURL ;
   private boolean n1918ConvScrapTipo ;
   private boolean n1919ConvScrapTDoc ;
   private boolean A738SitEsLicencia ;
   private boolean A739SitLicCuentaTrab ;
   private boolean A916SitEsAusencia ;
   private boolean A1220SitAbsorbeFer ;
   private boolean n1593SitPaiCod ;
   private boolean n1598EstadoSitRevista ;
   private boolean n1600EstadoSiniestro ;
   private boolean A1807EstadoCanPresen ;
   private boolean Cond_result ;
   private boolean A1809EstadoRemCorr ;
   private boolean A1490SitLicAdjunDef ;
   private boolean A1491SitLicAdjOblDef ;
   private boolean A1492SitLicNecApr ;
   private boolean A1493SitLIcIngMot ;
   private boolean A1494SitLicOblIngMot ;
   private boolean A1362PaiPromHabitual ;
   private String A1924RolNombre ;
   private String A1926PerfilNombre ;
   private String A1791MetaParmValue ;
   private String AV28json ;
   private String A1152ARTNom ;
   private String AV68LocNom ;
   private String A286LocNom ;
   private String A160ConveDescri ;
   private String A687ConveDescriSinAc ;
   private String A1915ConvBusGoogle ;
   private String A1916ConvBusWeb ;
   private String A1917ConvBaseURL ;
   private String A989AdicionalDescrip ;
   private String A334SitDescrip ;
   private String A685SitDescripSinAc ;
   private String A913sItDescAbrev ;
   private IDataStoreProvider pr_default ;
   private byte[] P001N2_A1923RolId ;
   private byte[] P001N4_A1923RolId ;
   private byte[] P001N6_A1925PerfilId ;
   private byte[] P001N8_A1925PerfilId ;
   private byte[] P001N10_A1925PerfilId ;
   private byte[] P001N12_A1925PerfilId ;
   private String[] P001N16_A20ZonCod ;
   private short[] P001N17_A46PaiCod ;
   private String[] P001N17_A1252PaiReligDefault ;
   private boolean[] P001N17_n1252PaiReligDefault ;
   private short[] P001N19_A1151ARTSec ;
   private short[] P001N21_A1151ARTSec ;
   private String[] P001N29_A16SitCodigo ;
   private GXBaseCollection<web.Sdtsdt_situacion_sdt_situacionItem> AV27sdt_situacion ;
   private GXBaseCollection<web.Sdtsdt_sindicato_sdt_sindicatoItem> AV26sdt_sindicato ;
   private GXBaseCollection<web.Sdtsdt_sindicato_sdt_sindicatoItem> GXv_objcol_Sdtsdt_sindicato_sdt_sindicatoItem5[] ;
   private GXBaseCollection<web.Sdtsdt_art_sdt_artItem> AV56sdt_art ;
   private GXBCCollection<web.SdtProvincia> AV16provincia ;
   private GXBCCollection<web.SdtProvincia> GXt_objcol_SdtProvincia2 ;
   private GXBCCollection<web.SdtProvincia> GXv_objcol_SdtProvincia3[] ;
   private web.Sdtsdt_situacion_sdt_situacionItem AV29itemSituacion ;
   private web.Sdtsdt_art_sdt_artItem AV58itemART ;
   private web.Sdtlocalidades_sdt AV12localidades_sdt ;
   private web.Sdtlocalidades_sdt GXv_Sdtlocalidades_sdt4[] ;
   private web.SdtProvincia AV15pr ;
}

final  class inicializardatos_sin_cliente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P001N2", "SELECT RolId FROM RolUsuario WHERE RolId = 1 ORDER BY RolId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P001N3", "SAVEPOINT gxupdate;INSERT INTO RolUsuario(RolId, RolNombre) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P001N4", "SELECT RolId FROM RolUsuario WHERE RolId = 2 ORDER BY RolId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P001N5", "SAVEPOINT gxupdate;INSERT INTO RolUsuario(RolId, RolNombre) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P001N6", "SELECT PerfilId FROM Perfil WHERE PerfilId = 1 ORDER BY PerfilId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P001N7", "SAVEPOINT gxupdate;INSERT INTO Perfil(PerfilId, PerfilNombre) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P001N8", "SELECT PerfilId FROM Perfil WHERE PerfilId = 2 ORDER BY PerfilId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P001N9", "SAVEPOINT gxupdate;INSERT INTO Perfil(PerfilId, PerfilNombre) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P001N10", "SELECT PerfilId FROM Perfil WHERE PerfilId = 3 ORDER BY PerfilId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P001N11", "SAVEPOINT gxupdate;INSERT INTO Perfil(PerfilId, PerfilNombre) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P001N12", "SELECT PerfilId FROM Perfil WHERE PerfilId = 4 ORDER BY PerfilId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P001N13", "SAVEPOINT gxupdate;INSERT INTO Perfil(PerfilId, PerfilNombre) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001N14", "SAVEPOINT gxupdate;INSERT INTO MetaParam(MetaParmCod, MetaParmValue) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001N15", "SAVEPOINT gxupdate;INSERT INTO MetaParam(MetaParmCod, MetaParmValue) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P001N16", "SELECT ZonCod FROM Zona ORDER BY ZonCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P001N17", "SELECT PaiCod, PaiReligDefault FROM Pais WHERE PaiCod = ? ORDER BY PaiCod  FOR UPDATE OF Pais",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P001N18", "SAVEPOINT gxupdate;UPDATE Pais SET PaiReligDefault=?  WHERE PaiCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P001N19", "SELECT ARTSec FROM ART ORDER BY ARTSec  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P001N20", "SAVEPOINT gxupdate;INSERT INTO ART(ARTPaiCod, ARTNom, ARTAli) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P001N21", "SELECT currval('ARTSec') ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P001N22", "SAVEPOINT gxupdate;INSERT INTO ARTImportesFijos(ARTSec, ARTImpFijSec, ARTImpFijFecha, ARTFijo) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001N23", "SAVEPOINT gxupdate;INSERT INTO Localidad(PaiCod, ProvCod, LocCod, LocNom, LocCP, LocaZona) VALUES(?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001N24", "SAVEPOINT gxupdate;INSERT INTO Convenio(PaiCod, ConveCodigo, ConveDescri, ConveHabilitada, ConveDescriSinAc, ConveSinCod, ConvBusGoogle, ConvBusWeb, ConvBaseURL, ConvScrapTipo, ConvScrapTDoc, ConveEscFrecAct, ConveEsquemaEs) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001N25", "SAVEPOINT gxupdate;INSERT INTO Adicional(PaiCod, AdicionalCod, AdicionalDescrip, AdicionalUniMed, AdicionalTipo, AdicionalReservado) VALUES(?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001N26", "SAVEPOINT gxupdate;INSERT INTO Adicional(PaiCod, AdicionalCod, AdicionalDescrip, AdicionalUniMed, AdicionalTipo, AdicionalReservado) VALUES(?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001N27", "SAVEPOINT gxupdate;INSERT INTO Convenio(PaiCod, ConveCodigo, ConveDescri, ConveHabilitada, ConveDescriSinAc, ConveSinCod, ConvBusGoogle, ConvBusWeb, ConvBaseURL, ConvScrapTipo, ConvScrapTDoc, ConveEscFrecAct, ConveEsquemaEs) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001N28", "SAVEPOINT gxupdate;INSERT INTO Convenio(PaiCod, ConveCodigo, ConveDescri, ConveHabilitada, ConveDescriSinAc, ConveSinCod, ConvBusGoogle, ConvBusWeb, ConvBaseURL, ConvScrapTipo, ConvScrapTDoc, ConveEscFrecAct, ConveEsquemaEs) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P001N29", "SELECT SitCodigo FROM Estado ORDER BY SitCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P001N30", "SAVEPOINT gxupdate;INSERT INTO Estado(SitCodigo, SitDescrip, SitDescripSinAc, SitEsLicencia, SitLicCuentaTrab, SitLicMesesProm, SitLicMesesProm2, sItDescAbrev, SitDiasDivision, SitEsAusencia, SitAplicaPlus, SitAbsorbeFer, SitLicLimiteDef, SitLicAdjunDef, SitLicAdjOblDef, SitLicNecApr, SitLIcIngMot, SitLicOblIngMot, SitPaiCod, EstadoSitRevista, EstadoSiniestro, EstadoCanPresen, EstadoRemCorr) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001N31", "SAVEPOINT gxupdate;INSERT INTO Paispromedio_horanormal_mensualizados(PaiCod, TipoConCod, PaiPromFijVar, PaiPromHabitual) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               return;
            case 2 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 4 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 6 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 8 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 10 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 19 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 27 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setVarchar(2, (String)parms[1], 30, false);
               return;
            case 3 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setVarchar(2, (String)parms[1], 30, false);
               return;
            case 5 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setVarchar(2, (String)parms[1], 30, false);
               return;
            case 7 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setVarchar(2, (String)parms[1], 30, false);
               return;
            case 9 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setVarchar(2, (String)parms[1], 30, false);
               return;
            case 11 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setVarchar(2, (String)parms[1], 30, false);
               return;
            case 12 :
               stmt.setString(1, (String)parms[0], 30);
               stmt.setVarchar(2, (String)parms[1], 40, false);
               return;
            case 13 :
               stmt.setString(1, (String)parms[0], 30);
               stmt.setVarchar(2, (String)parms[1], 40, false);
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 16 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               stmt.setShort(2, ((Number) parms[2]).shortValue());
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 4);
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               return;
            case 21 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setString(5, (String)parms[4], 20);
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[6], 20);
               }
               return;
            case 22 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setVarchar(5, (String)parms[4], 400, false);
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[6], 20);
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(7, (String)parms[8], 100);
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(8, (String)parms[10], 100);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(9, (String)parms[12], 1000);
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(10, (String)parms[14], 20);
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(11, (String)parms[16], 20);
               }
               stmt.setShort(12, ((Number) parms[17]).shortValue());
               return;
            case 23 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 24 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 25 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setVarchar(5, (String)parms[4], 400, false);
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[6], 20);
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(7, (String)parms[8], 100);
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(8, (String)parms[10], 100);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(9, (String)parms[12], 1000);
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(10, (String)parms[14], 20);
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(11, (String)parms[16], 20);
               }
               stmt.setShort(12, ((Number) parms[17]).shortValue());
               return;
            case 26 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setVarchar(5, (String)parms[4], 400, false);
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[6], 20);
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(7, (String)parms[8], 100);
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(8, (String)parms[10], 100);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(9, (String)parms[12], 1000);
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(10, (String)parms[14], 20);
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(11, (String)parms[16], 20);
               }
               stmt.setShort(12, ((Number) parms[17]).shortValue());
               return;
            case 28 :
               stmt.setString(1, (String)parms[0], 4);
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setVarchar(3, (String)parms[2], 40, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setVarchar(8, (String)parms[7], 40, false);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[8], 1);
               stmt.setBoolean(10, ((Boolean) parms[9]).booleanValue());
               stmt.setByte(11, ((Number) parms[10]).byteValue());
               stmt.setBoolean(12, ((Boolean) parms[11]).booleanValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setBoolean(14, ((Boolean) parms[13]).booleanValue());
               stmt.setBoolean(15, ((Boolean) parms[14]).booleanValue());
               stmt.setBoolean(16, ((Boolean) parms[15]).booleanValue());
               stmt.setBoolean(17, ((Boolean) parms[16]).booleanValue());
               stmt.setBoolean(18, ((Boolean) parms[17]).booleanValue());
               if ( ((Boolean) parms[18]).booleanValue() )
               {
                  stmt.setNull( 19 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(19, ((Number) parms[19]).shortValue());
               }
               if ( ((Boolean) parms[20]).booleanValue() )
               {
                  stmt.setNull( 20 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(20, ((Number) parms[21]).shortValue());
               }
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 21 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(21, (String)parms[23], 4);
               }
               stmt.setBoolean(22, ((Boolean) parms[24]).booleanValue());
               stmt.setBoolean(23, ((Boolean) parms[25]).booleanValue());
               return;
            case 29 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               return;
      }
   }

}

