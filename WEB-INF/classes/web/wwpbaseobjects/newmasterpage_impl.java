package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class newmasterpage_impl extends GXMasterPage
{
   public newmasterpage_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public newmasterpage_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newmasterpage_impl.class ));
   }

   public newmasterpage_impl( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavEmpcod = new HTMLChoice();
      cmbavConvecodigo = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
   }

   public void gxnrgridopciones_newrow_invoke( )
   {
      nRC_GXsfl_76 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_76"))) ;
      nGXsfl_76_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_76_idx"))) ;
      sGXsfl_76_idx = httpContext.GetPar( "sGXsfl_76_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridopciones_newrow( ) ;
      /* End function gxnrGridopciones_newrow_invoke */
   }

   public void gxgrgridopciones_refresh_invoke( )
   {
      AV90Pgmname = httpContext.GetPar( "Pgmname") ;
      cmbavEmpcod.fromJSonString( httpContext.GetNextPar( ));
      AV16EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV9CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      A2EmpNom = httpContext.GetPar( "EmpNom") ;
      A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
      A2429CliConveEsquemaEs = GXutil.strtobool( httpContext.GetPar( "CliConveEsquemaEs")) ;
      A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
      A1567CliConvenioDescrip = httpContext.GetPar( "CliConvenioDescrip") ;
      AV12contentHolder_Pgmname = httpContext.GetPar( "contentHolder_Pgmname") ;
      AV43RolId = (byte)(GXutil.lval( httpContext.GetPar( "RolId"))) ;
      AV39PerfilId = (byte)(GXutil.lval( httpContext.GetPar( "PerfilId"))) ;
      AV34MenuVerId = GXutil.lval( httpContext.GetPar( "MenuVerId")) ;
      AV51selMenuOpcCod = httpContext.GetPar( "selMenuOpcCod") ;
      A1923RolId = (byte)(GXutil.lval( httpContext.GetPar( "RolId"))) ;
      A1925PerfilId = (byte)(GXutil.lval( httpContext.GetPar( "PerfilId"))) ;
      A1928MenuVerId = GXutil.lval( httpContext.GetPar( "MenuVerId")) ;
      A1940MenuItemOrd = (byte)(GXutil.lval( httpContext.GetPar( "MenuItemOrd"))) ;
      A1933MenuOpcPadre = httpContext.GetPar( "MenuOpcPadre") ;
      n1933MenuOpcPadre = false ;
      A1935SVGId = httpContext.GetPar( "SVGId") ;
      n1935SVGId = false ;
      A1936SVGValor = httpContext.GetPar( "SVGValor") ;
      A1929MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      AV41primero_MenuOpcCod = httpContext.GetPar( "primero_MenuOpcCod") ;
      A1931MenuOpcTitulo = httpContext.GetPar( "MenuOpcTitulo") ;
      A1937MenuItemId = httpContext.GetPar( "MenuItemId") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV54urls);
      AV31MenuItemId = httpContext.GetPar( "MenuItemId") ;
      AV85hormigaURL = httpContext.GetPar( "hormigaURL") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridopciones_refresh( AV90Pgmname, AV16EmpCod, AV9CliCod, A3CliCod, A1EmpCod, A2EmpNom, A1564CliPaiConve, A2429CliConveEsquemaEs, A1565CliConvenio, A1567CliConvenioDescrip, AV12contentHolder_Pgmname, AV43RolId, AV39PerfilId, AV34MenuVerId, AV51selMenuOpcCod, A1923RolId, A1925PerfilId, A1928MenuVerId, A1940MenuItemOrd, A1933MenuOpcPadre, A1935SVGId, A1936SVGValor, A1929MenuOpcCod, AV41primero_MenuOpcCod, A1931MenuOpcTitulo, A1937MenuItemId, AV54urls, AV31MenuItemId, AV85hormigaURL) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridopciones_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         paOK2( ) ;
         if ( ! isAjaxCallMode( ) )
         {
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            wsOK2( ) ;
            if ( ! isAjaxCallMode( ) )
            {
               weOK2( ) ;
            }
         }
      }
      cleanup();
   }

   public void renderHtmlHeaders( )
   {
      if ( ! isFullAjaxMode( ) )
      {
         GXWebForm.addResponsiveMetaHeaders((getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getMeta());
         getDataAreaObject().renderHtmlHeaders();
      }
   }

   public void renderHtmlOpenForm( )
   {
      if ( ! isFullAjaxMode( ) )
      {
         getDataAreaObject().renderHtmlOpenForm();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONTENTHOLDER_PGMNAME_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV12contentHolder_Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vROLID_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV43RolId), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERFILID_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV39PerfilId), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUVERID_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV34MenuVerId), "ZZZZZZZZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSELMENUOPCCOD_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV51selMenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPRIMERO_MENUOPCCOD_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV41primero_MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUITEMID_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV31MenuItemId, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vHORMIGAURL_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV85hormigaURL, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLIPAICONVE_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICONVEESQUEMAES_MPAGE", getSecureSignedToken( "gxmpage_", A2429CliConveEsquemaEs));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICONVENIO_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( A1565CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_EMPCOD_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_EMPNOM_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( A2EmpNom, "@!"))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_76", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_76, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", true, "vDDO_TITLESETTINGSICONS_MPAGE", AV81DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS_MPAGE", AV81DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", true, "vBUSCARMENU_DATA_MPAGE", AV80BuscarMenu_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vBUSCARMENU_DATA_MPAGE", AV80BuscarMenu_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", true, "vLANGUAGESICONSDATA_MPAGE", AV28LanguagesIconsData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLANGUAGESICONSDATA_MPAGE", AV28LanguagesIconsData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME_MPAGE", GXutil.rtrim( AV90Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD_MPAGE", GXutil.ltrim( localUtil.ntoc( AV9CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD_MPAGE", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPCOD_MPAGE", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_EMPCOD_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPNOM_MPAGE", A2EmpNom);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_EMPNOM_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( A2EmpNom, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "CLIPAICONVE_MPAGE", GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLIPAICONVE_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "CLICONVEESQUEMAES_MPAGE", A2429CliConveEsquemaEs);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICONVEESQUEMAES_MPAGE", getSecureSignedToken( "gxmpage_", A2429CliConveEsquemaEs));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICONVENIO_MPAGE", GXutil.rtrim( A1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICONVENIO_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( A1565CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICONVENIODESCRIP_MPAGE", A1567CliConvenioDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "vCONTENTHOLDER_PGMNAME_MPAGE", GXutil.rtrim( AV12contentHolder_Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONTENTHOLDER_PGMNAME_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV12contentHolder_Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vROLID_MPAGE", GXutil.ltrim( localUtil.ntoc( AV43RolId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vROLID_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV43RolId), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPERFILID_MPAGE", GXutil.ltrim( localUtil.ntoc( AV39PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERFILID_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV39PerfilId), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUVERID_MPAGE", GXutil.ltrim( localUtil.ntoc( AV34MenuVerId, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUVERID_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV34MenuVerId), "ZZZZZZZZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vSELMENUOPCCOD_MPAGE", AV51selMenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSELMENUOPCCOD_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV51selMenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "ROLID_MPAGE", GXutil.ltrim( localUtil.ntoc( A1923RolId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "PERFILID_MPAGE", GXutil.ltrim( localUtil.ntoc( A1925PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUVERID_MPAGE", GXutil.ltrim( localUtil.ntoc( A1928MenuVerId, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUITEMORD_MPAGE", GXutil.ltrim( localUtil.ntoc( A1940MenuItemOrd, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUOPCPADRE_MPAGE", GXutil.rtrim( A1933MenuOpcPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "SVGID_MPAGE", GXutil.rtrim( A1935SVGId));
      web.GxWebStd.gx_hidden_field( httpContext, "SVGVALOR_MPAGE", A1936SVGValor);
      web.GxWebStd.gx_hidden_field( httpContext, "MENUOPCCOD_MPAGE", A1929MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "vPRIMERO_MENUOPCCOD_MPAGE", AV41primero_MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPRIMERO_MENUOPCCOD_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV41primero_MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUOPCTITULO_MPAGE", A1931MenuOpcTitulo);
      web.GxWebStd.gx_hidden_field( httpContext, "MENUITEMID_MPAGE", A1937MenuItemId);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", true, "vURLS_MPAGE", AV54urls);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vURLS_MPAGE", AV54urls);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUITEMID_MPAGE", AV31MenuItemId);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUITEMID_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV31MenuItemId, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vHORMIGAURL_MPAGE", AV85hormigaURL);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vHORMIGAURL_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV85hormigaURL, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", true, "vNOTIFICATIONINFO_MPAGE", AV36NotificationInfo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vNOTIFICATIONINFO_MPAGE", AV36NotificationInfo);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "DDC_ADMINAG_MPAGE_Icon", GXutil.rtrim( Ddc_adminag_Icon));
      web.GxWebStd.gx_hidden_field( httpContext, "DDC_ADMINAG_MPAGE_Cls", GXutil.rtrim( Ddc_adminag_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DDC_ADMINAG_MPAGE_Componentwidth", GXutil.ltrim( localUtil.ntoc( Ddc_adminag_Componentwidth, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDC_ADMINAG_MPAGE_Visible", GXutil.booltostr( Ddc_adminag_Visible));
      web.GxWebStd.gx_hidden_field( httpContext, "DDC_ADMINAG_MPAGE_Showloading", GXutil.booltostr( Ddc_adminag_Showloading));
      web.GxWebStd.gx_hidden_field( httpContext, "DDC_ADMINAG_MPAGE_Load", GXutil.rtrim( Ddc_adminag_Load));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BUSCARMENU_MPAGE_Cls", GXutil.rtrim( Combo_buscarmenu_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BUSCARMENU_MPAGE_Selectedvalue_set", GXutil.rtrim( Combo_buscarmenu_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BUSCARMENU_MPAGE_Selectedtext_set", GXutil.rtrim( Combo_buscarmenu_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BUSCARMENU_MPAGE_Dropdownoptionstype", GXutil.rtrim( Combo_buscarmenu_Dropdownoptionstype));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BUSCARMENU_MPAGE_Emptyitemtext", GXutil.rtrim( Combo_buscarmenu_Emptyitemtext));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_LANGUAGESICONS_MPAGE_Caption", GXutil.rtrim( Ddo_languagesicons_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_LANGUAGESICONS_MPAGE_Cls", GXutil.rtrim( Ddo_languagesicons_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_LANGUAGESICONS_MPAGE_Titlecontrolalign", GXutil.rtrim( Ddo_languagesicons_Titlecontrolalign));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Width", GXutil.rtrim( Ucmessage_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Minheight", GXutil.rtrim( Ucmessage_Minheight));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Stylingtype", GXutil.rtrim( Ucmessage_Stylingtype));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Defaultmessagetype", GXutil.rtrim( Ucmessage_Defaultmessagetype));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Stoponerror", GXutil.booltostr( Ucmessage_Stoponerror));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Titleescape", GXutil.booltostr( Ucmessage_Titleescape));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Textescape", GXutil.booltostr( Ucmessage_Textescape));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Changenewlinestobrs", GXutil.booltostr( Ucmessage_Changenewlinestobrs));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Hide", GXutil.booltostr( Ucmessage_Hide));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Delayuntilhide", GXutil.ltrim( localUtil.ntoc( Ucmessage_Delayuntilhide, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Mousehidereset", GXutil.booltostr( Ucmessage_Mousehidereset));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Effectin", GXutil.rtrim( Ucmessage_Effectin));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Effectout", GXutil.rtrim( Ucmessage_Effectout));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Animationspeed", GXutil.ltrim( localUtil.ntoc( Ucmessage_Animationspeed, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Startposition", GXutil.rtrim( Ucmessage_Startposition));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Nextmessageposition", GXutil.rtrim( Ucmessage_Nextmessageposition));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Closer", GXutil.booltostr( Ucmessage_Closer));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Sticker", GXutil.booltostr( Ucmessage_Sticker));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Stickerhover", GXutil.booltostr( Ucmessage_Stickerhover));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Labelclosebutton", GXutil.rtrim( Ucmessage_Labelclosebutton));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Labelstickbutton", GXutil.rtrim( Ucmessage_Labelstickbutton));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Showevenonnonblock", GXutil.booltostr( Ucmessage_Showevenonnonblock));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Menu", GXutil.booltostr( Ucmessage_Menu));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Maxonscreen", GXutil.rtrim( Ucmessage_Maxonscreen));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Labelredisplay", GXutil.rtrim( Ucmessage_Labelredisplay));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Labelall", GXutil.rtrim( Ucmessage_Labelall));
      web.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Labellast", GXutil.rtrim( Ucmessage_Labellast));
      web.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Enablefixobjectfitcover", GXutil.booltostr( Wwputilities_Enablefixobjectfitcover));
      web.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Empowertabs", GXutil.booltostr( Wwputilities_Empowertabs));
      web.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Enableupdaterowselectionstatus", GXutil.booltostr( Wwputilities_Enableupdaterowselectionstatus));
      web.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Enableconvertcombotobootstrapselect", GXutil.booltostr( Wwputilities_Enableconvertcombotobootstrapselect));
      web.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Allowcolumnresizing", GXutil.booltostr( Wwputilities_Allowcolumnresizing));
      web.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Allowcolumnreordering", GXutil.booltostr( Wwputilities_Allowcolumnreordering));
      web.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Allowcolumndragging", GXutil.booltostr( Wwputilities_Allowcolumndragging));
      web.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Allowcolumnsrestore", GXutil.booltostr( Wwputilities_Allowcolumnsrestore));
      web.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Pagbarincludegoto", GXutil.booltostr( Wwputilities_Pagbarincludegoto));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LLINKTABLA1_MPAGE_Linkrowid", GXutil.rtrim( A3llinktabla1_Linkrowid));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LLINKTABLA1_MPAGE_Urls", GXutil.rtrim( A3llinktabla1_Urls));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDOPCIONES_MPAGE_Class", GXutil.rtrim( subGridopciones_Class));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDOPCIONES_MPAGE_Flexdirection", GXutil.rtrim( subGridopciones_Flexdirection));
      web.GxWebStd.gx_hidden_field( httpContext, "vHTTPREQUEST_MPAGE_Baseurl", GXutil.rtrim( AV22Httprequest.getBaseURL()));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_LANGUAGESICONS_MPAGE_Activeeventkey", GXutil.rtrim( Ddo_languagesicons_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BUSCARMENU_MPAGE_Selectedvalue_get", GXutil.rtrim( Combo_buscarmenu_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "vNOTIFICATIONINFO_MPAGE_Id", GXutil.rtrim( AV36NotificationInfo.getgxTv_SdtNotificationInfo_Id()));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_LANGUAGESICONS_MPAGE_Activeeventkey", GXutil.rtrim( Ddo_languagesicons_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BUSCARMENU_MPAGE_Selectedvalue_get", GXutil.rtrim( Combo_buscarmenu_Selectedvalue_get));
   }

   public void renderHtmlCloseFormOK2( )
   {
      sendCloseFormHiddens( ) ;
      sendSecurityToken(sPrefix);
      if ( ! isFullAjaxMode( ) )
      {
         getDataAreaObject().renderHtmlCloseForm();
      }
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! ( WebComp_Ddc_adminag_wc == null ) )
      {
         WebComp_Ddc_adminag_wc.componentjscripts();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Tooltip/BootstrapTooltipRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Mask/jquery.mask.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/WorkWithPlusUtilities/BootstrapSelect.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/WorkWithPlusUtilities/WorkWithPlusUtilitiesRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DatePicker/DatePickerRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/A3LLinkTablaRender.js", "", false, true);
      httpContext.AddJavascriptSource("wwpbaseobjects/newmasterpage.js", "?2025187221934", false, true);
      httpContext.writeTextNL( "</body>") ;
      httpContext.writeTextNL( "</html>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.NewMasterPage" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Master Page", "") ;
   }

   public void wbOK0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         renderHtmlHeaders( ) ;
         renderHtmlOpenForm( ) ;
         if ( ! ShowMPWhenPopUp( ) && httpContext.isPopUpObject( ) )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableOutput();
            }
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
            /* Content placeholder */
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gx-content-placeholder");
            httpContext.writeText( ">") ;
            if ( ! isFullAjaxMode( ) )
            {
               getDataAreaObject().renderHtmlContent();
            }
            httpContext.writeText( "</div>") ;
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
            wbLoad = true ;
            return  ;
         }
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 pr0", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divParentnewcontent_Internalname, 1, 0, "px", 0, "px", "parentNewContent", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLeftcontent_Internalname, 1, 0, "px", 0, "px", "leftContent p24", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divParentmenu_Internalname, 1, 0, "px", 0, "px", "parentMenu", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divMenuheader_Internalname, 1, 0, "px", 0, "px", "MenuHeader", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableheadercontent_Internalname, 1, 0, "px", 0, "px", "MB40 pl8", "left", "top", " "+"data-gx-flex"+" ", "justify-content:center;align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablelogo_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:center;align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableisologo_Internalname, 1, 0, "px", 0, "px", "fondo_logo W100", "left", "top", " "+"data-gx-flex"+" ", "justify-content:center;align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablepay_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:center;align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblock_pay_Internalname, httpContext.getMessage( "P", ""), "", "", lblTextblock_pay_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "logo_textColor_light_new", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\NewMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         wb_table1_23_OK2( true) ;
      }
      else
      {
         wb_table1_23_OK2( false) ;
      }
      return  ;
   }

   public void wb_table1_23_OK2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "hidden-xs", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableuserrole_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divHeadercontentoptions_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableuser_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:center;align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableusuario_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "MasterTopIconsCell", "left", "top", "", "align-self:center;", "div");
         /* User Defined Control */
         ucDdc_adminag.setProperty("Caption", Ddc_adminag_Caption);
         ucDdc_adminag.setProperty("Cls", Ddc_adminag_Cls);
         ucDdc_adminag.setProperty("ComponentWidth", Ddc_adminag_Componentwidth);
         ucDdc_adminag.setProperty("ShowLoading", Ddc_adminag_Showloading);
         ucDdc_adminag.setProperty("Load", Ddc_adminag_Load);
         ucDdc_adminag.render(context, "dvelop.gxbootstrap.ddcomponent", Ddc_adminag_Internalname, "DDC_ADMINAG_MPAGEContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablealerta_Internalname, divTablealerta_Visible, 0, "px", 0, "px", "TableAlerta", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblock2_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"20\" viewBox=\"0 0 18 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M16.377 14.1005C15.2735 12.75 14.4945 12.0625 14.4945 8.33926C14.4945 4.92969 12.7534 3.71496 11.3204 3.125C11.1301 3.0468 10.9509 2.86719 10.8929 2.67168C10.6415 1.81617 9.93681 1.0625 9.00009 1.0625C8.06337 1.0625 7.35825 1.8166 7.10947 2.67254C7.05146 2.8702 6.87228 3.0468 6.68193 3.125C5.2472 3.71582 3.50782 4.92625 3.50782 8.33926C3.50568 12.0625 2.72665 12.75 1.62322 14.1005C1.16603 14.66 1.5665 15.5 2.36615 15.5H15.6383C16.4337 15.5 16.8316 14.6574 16.377 14.1005Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M11.75 15.5V16.1875C11.75 16.9168 11.4603 17.6163 10.9445 18.132C10.4288 18.6478 9.72935 18.9375 9 18.9375C8.27065 18.9375 7.57118 18.6478 7.05546 18.132C6.53973 17.6163 6.25 16.9168 6.25 16.1875V15.5\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblTextblock2_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_WWPBaseObjects\\NewMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableempresaconvenio_Internalname, 1, 0, "px", 0, "px", "CompanyConvenioButton", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesvgiconempresa_Internalname, 1, 0, "px", 0, "px", "TableSvgIconEmpresa", "left", "top", " "+"data-gx-flex"+" ", "align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblSvgempresa_Internalname, httpContext.getMessage( "<svg width=\"22\" height=\"20\" viewBox=\"0 0 22 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 19H3M21 19H19M3 19V3C3 1.89543 3.89543 1 5 1H17C18.1046 1 19 1.89543 19 3V19M3 19H19M6.5 5H9M13 5H15.5M6.5 9H9M6.5 13H9M13 9H15.5M13 13H15.5\" stroke=\"var(--colors_gray14)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblSvgempresa_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_WWPBaseObjects\\NewMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesvgtextempresa_Internalname, divTablesvgtextempresa_Visible, 0, "px", 0, "px", "W100", "left", "top", " "+"data-gx-flex"+" ", "align-items:flex-start;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTabletitulos_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTabletituloempresaconvenio_Internalname, 1, 0, "px", 0, "px", "TableTituloEmpresaConvenio", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextempresaconveniotitulo_Internalname, lblTextempresaconveniotitulo_Caption, "", "", lblTextempresaconveniotitulo_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "TextEmpresaConvenioTitulo", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\NewMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTabledoblecaret_Internalname, divTabledoblecaret_Visible, 0, "px", 0, "px", "TableDobleCaret", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblDoblecaret_Internalname, httpContext.getMessage( "<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" aria-hidden=\"true\" role=\"img\" data-slot=\"selectorIcon\" class=\"absolute right-3 rtl:left-3 rtl:right-[unset] w-4 h-4 transition-transform duration-150 ease motion-reduce:transition-none iconify iconify--lucide\" width=\"16px\" height=\"16px\" viewBox=\"0 0 24 24\" style=\"color: #71717a\"><path fill=\"none\" stroke=\"currentColor\" stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"m7 15l5 5l5-5M7 9l5-5l5 5\"></path></svg>", ""), "", "", lblDoblecaret_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_WWPBaseObjects\\NewMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablevariables_Internalname, 1, 0, "px", 0, "px", divTablevariables_Class, "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavEmpcod.getInternalname(), httpContext.getMessage( "Emp Cod", ""), "gx-form-item TextEmpresaLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',true,'" + sGXsfl_76_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavEmpcod, cmbavEmpcod.getInternalname(), GXutil.trim( GXutil.str( AV16EmpCod, 4, 0)), 1, cmbavEmpcod.getJsonclick(), 0, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "int", "", cmbavEmpcod.getVisible(), cmbavEmpcod.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "TextEmpresa", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,63);\"", "", true, (byte)(0), "HLP_WWPBaseObjects\\NewMasterPage.htm");
         cmbavEmpcod.setValue( GXutil.trim( GXutil.str( AV16EmpCod, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", true, cmbavEmpcod.getInternalname(), "Values", cmbavEmpcod.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConvecodigo.getInternalname(), httpContext.getMessage( "Convenio", ""), "gx-form-item TextEmpresaLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',true,'" + sGXsfl_76_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConvecodigo, cmbavConvecodigo.getInternalname(), GXutil.rtrim( AV13ConveCodigo), 1, cmbavConvecodigo.getJsonclick(), 0, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "char", "", cmbavConvecodigo.getVisible(), cmbavConvecodigo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "TextEmpresa", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,66);\"", "", true, (byte)(0), "HLP_WWPBaseObjects\\NewMasterPage.htm");
         cmbavConvecodigo.setValue( GXutil.rtrim( AV13ConveCodigo) );
         httpContext.ajax_rsp_assign_prop("", true, cmbavConvecodigo.getInternalname(), "Values", cmbavConvecodigo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablebuscarmenu_Internalname, 1, 0, "px", 0, "px", "TableBuscarMenu", "left", "top", " "+"data-gx-flex"+" ", "align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table2_69_OK2( true) ;
      }
      else
      {
         wb_table2_69_OK2( false) ;
      }
      return  ;
   }

   public void wb_table2_69_OK2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "ExtendedComboCell", "left", "top", "", "flex-grow:1;", "div");
         /* User Defined Control */
         ucCombo_buscarmenu.setProperty("Caption", Combo_buscarmenu_Caption);
         ucCombo_buscarmenu.setProperty("Cls", Combo_buscarmenu_Cls);
         ucCombo_buscarmenu.setProperty("DropDownOptionsType", Combo_buscarmenu_Dropdownoptionstype);
         ucCombo_buscarmenu.setProperty("EmptyItemText", Combo_buscarmenu_Emptyitemtext);
         ucCombo_buscarmenu.setProperty("DropDownOptionsTitleSettingsIcons", AV81DDO_TitleSettingsIcons);
         ucCombo_buscarmenu.setProperty("DropDownOptionsData", AV80BuscarMenu_Data);
         ucCombo_buscarmenu.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_buscarmenu_Internalname, "COMBO_BUSCARMENU_MPAGEContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divMenucenter_Internalname, 1, 0, "px", 0, "px", "MenuCenter", "left", "top", "", "", "div");
         /*  Grid Control  */
         MPGridopcionesContainer.SetIsFreestyle(true);
         MPGridopcionesContainer.SetWrapped(nGXWrapped);
         startgridcontrol76( ) ;
      }
      if ( ( wbEnd == 76 ) && ( ! httpContext.isPopUpObject( ) || ShowMPWhenPopUp( ) ) )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_76 = (int)(nGXsfl_76_idx-1) ;
         if ( MPGridopcionesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"MPGridopcionesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridopciones", MPGridopcionesContainer, subGridopciones_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "MPGridopcionesContainerData", MPGridopcionesContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "MPGridopcionesContainerData"+"V", MPGridopcionesContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"MPGridopcionesContainerData"+"V"+"\" value='"+MPGridopcionesContainer.GridValuesHidden()+"'/>") ;
            }
         }
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablepromomenu_Internalname, divTablepromomenu_Visible, 0, "px", 0, "px", "TablePromoMenu", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablefooter_new_Internalname, 1, 0, "px", 0, "px", "TableFooter_new", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;justify-content:center;align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablepromotitle_Internalname, 1, 0, "px", 0, "px", "TablePromoTitle", "left", "top", " "+"data-gx-flex"+" ", "justify-content:center;align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblPromotitle_Internalname, httpContext.getMessage( "Actualizate a Pro", ""), "", "", lblPromotitle_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "PromoTitle", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\NewMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Static images/pictures */
         ClassString = "w20 ML5" + " " + ((GXutil.strcmp(imgRocketemoji_gximage, "")==0) ? "GX_Image_rocketEmoji_Class" : "GX_Image_"+imgRocketemoji_gximage+"_Class") ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "94dc59fa-b0d8-454d-a384-fd4e3aff6444", "", context.getHttpContext().getTheme( )) ;
         web.GxWebStd.gx_bitmap( httpContext, imgRocketemoji_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", "", 0, 0, 0, "px", 0, "px", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" ", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\NewMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablepromotext_Internalname, 1, 0, "px", 0, "px", "TablePromoText", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TextAlignCenter", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblPromotext_Internalname, httpContext.getMessage( "Obtén 1 mes gratis y desbloquea todas las funciones del plan pro", ""), "", "", lblPromotext_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "PromoText", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\NewMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablebuttonupgrade_Internalname, 1, 0, "px", 0, "px", "TableButtonUpgrade", "left", "top", " "+"data-gx-flex"+" ", "justify-content:center;align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 113,'',true,'',0)\"" ;
         ClassString = "Button ButtonUpgrade" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupgradepro_Internalname, "gx.evt.setGridEvt("+GXutil.str( 76, 2, 0)+","+"null"+");", httpContext.getMessage( "Actualizar", ""), bttBtnupgradepro_Jsonclick, 7, httpContext.getMessage( "Actualizar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",true,"+"'"+"e11ok1_client"+"'", TempTags, "", 2, "HLP_WWPBaseObjects\\NewMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divMenubottom_Internalname, 1, 0, "px", 0, "px", "MenuBottom", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableversion_Internalname, 1, 0, "px", 0, "px", "W100", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;justify-content:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblVersion_Internalname, httpContext.getMessage( "beta 1.0.0", ""), "", "", lblVersion_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\NewMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divRigthcontent_Internalname, 1, 0, "px", 0, "px", divRigthcontent_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divParentrigthcontent_Internalname, 1, 0, "px", 0, "px", divParentrigthcontent_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTopcontent_Internalname, 1, 0, "px", 0, "px", "topContent", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblVolversvg_Internalname, lblVolversvg_Caption, "", "", lblVolversvg_Jsonclick, "'"+""+"'"+",true,"+"'"+"EVOLVERSVG_MPAGE.CLICK_MPAGE."+"'", "", "VolverSVG", 5, "", lblVolversvg_Visible, 1, 0, (short)(1), "HLP_WWPBaseObjects\\NewMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablevolver_pgmname_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblHtmlhormiga_Internalname, lblHtmlhormiga_Caption, "", "", lblHtmlhormiga_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "NewTextBlockTitleWWP", 0, "", lblHtmlhormiga_Visible, 1, 0, (short)(1), "HLP_WWPBaseObjects\\NewMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblPgmdesc_Internalname, lblPgmdesc_Caption, "", "", lblPgmdesc_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "PgmDesc", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\NewMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableayuda_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table3_133_OK2( true) ;
      }
      else
      {
         wb_table3_133_OK2( false) ;
      }
      return  ;
   }

   public void wb_table3_133_OK2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblAyuda_Internalname, lblAyuda_Caption, "", "", lblAyuda_Jsonclick, "'"+""+"'"+",true,"+"'"+"EAYUDA_MPAGE.CLICK_MPAGE."+"'", "", "TextBlock", 5, "", lblAyuda_Visible, 1, 0, (short)(1), "HLP_WWPBaseObjects\\NewMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divBottomcontent_Internalname, 1, 0, "px", 0, "px", divBottomcontent_Class, "left", "top", "", "", "div");
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         /* Content placeholder */
         httpContext.writeText( "<div") ;
         web.GxWebStd.classAttribute( httpContext, "gx-content-placeholder");
         httpContext.writeText( ">") ;
         if ( ! isFullAjaxMode( ) )
         {
            getDataAreaObject().renderHtmlContent();
         }
         httpContext.writeText( "</div>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 hidden-xs hidden-sm hidden-md hidden-lg TablaUserControlsCell", "left", "top", "", "", "div");
         wb_table4_143_OK2( true) ;
      }
      else
      {
         wb_table4_143_OK2( false) ;
      }
      return  ;
   }

   public void wb_table4_143_OK2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 168,'',true,'" + sGXsfl_76_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavBuscarmenu_Internalname, GXutil.rtrim( AV76BuscarMenu), GXutil.rtrim( localUtil.format( AV76BuscarMenu, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,168);\"", "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "", "", "", edtavBuscarmenu_Jsonclick, 0, "Attribute", "", "", "", "", edtavBuscarmenu_Visible, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\NewMasterPage.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 169,'',true,'" + sGXsfl_76_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavPickerdummyvariable_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavPickerdummyvariable_Internalname, localUtil.format(AV40PickerDummyVariable, "99/99/99"), localUtil.format( AV40PickerDummyVariable, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,169);\"", "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "", "", "", edtavPickerdummyvariable_Jsonclick, 0, "Invisible", "", "", "", "", 1, 1, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\NewMasterPage.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavPickerdummyvariable_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(1==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WWPBaseObjects\\NewMasterPage.htm");
         httpContext.writeTextNL( "</div>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDiv_ddc_adminag_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "MPW0171"+"", GXutil.rtrim( WebComp_Ddc_adminag_wc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpMPW0171"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( bGXsfl_76_Refreshing )
            {
               if ( GXutil.len( WebComp_Ddc_adminag_wc_Component) != 0 )
               {
                  if ( GXutil.strcmp(GXutil.lower( OldDdc_adminag_wc), GXutil.lower( WebComp_Ddc_adminag_wc_Component)) != 0 )
                  {
                     httpContext.ajax_rspStartCmp("gxHTMLWrpMPW0171"+"");
                  }
                  WebComp_Ddc_adminag_wc.componentdraw();
                  if ( GXutil.strcmp(GXutil.lower( OldDdc_adminag_wc), GXutil.lower( WebComp_Ddc_adminag_wc_Component)) != 0 )
                  {
                     httpContext.ajax_rspEndCmp();
                  }
               }
            }
            httpContext.writeText( "</div>") ;
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( ( wbEnd == 76 ) && ( ! httpContext.isPopUpObject( ) || ShowMPWhenPopUp( ) ) )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( MPGridopcionesContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"MPGridopcionesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridopciones", MPGridopcionesContainer, subGridopciones_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "MPGridopcionesContainerData", MPGridopcionesContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "MPGridopcionesContainerData"+"V", MPGridopcionesContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"MPGridopcionesContainerData"+"V"+"\" value='"+MPGridopcionesContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void startOK2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupOK0( ) ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         if ( getDataAreaObject().executeStartEvent() != 0 )
         {
            httpContext.setAjaxCallMode();
         }
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
   }

   public void wsOK2( )
   {
      startOK2( ) ;
      evtOK2( ) ;
   }

   public void evtOK2( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            sEvt = httpContext.cgiGet( "_EventName") ;
            EvtGridId = httpContext.cgiGet( "_EventGridId") ;
            EvtRowId = httpContext.cgiGet( "_EventRowId") ;
            if ( GXutil.len( sEvt) > 0 )
            {
               sEvtType = GXutil.left( sEvt, 1) ;
               sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
               if ( GXutil.strcmp(sEvtType, "E") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, 1) ;
                  if ( GXutil.strcmp(sEvtType, ".") == 0 )
                  {
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                     if ( GXutil.strcmp(sEvt, "RFR_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "COMBO_BUSCARMENU_MPAGE.ONOPTIONCLICKED_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e12OK2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "DDO_LANGUAGESICONS_MPAGE.ONOPTIONCLICKED_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e13OK2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "VOLVERSVG_MPAGE.CLICK_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e14OK2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "TABLELOGO_MPAGE.CLICK_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e15OK2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "VEMPCOD_MPAGE.CONTROLVALUECHANGED_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e16OK2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "VCONVECODIGO_MPAGE.CONTROLVALUECHANGED_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e17OK2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AYUDA_MPAGE.CLICK_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e18OK2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "ONMESSAGE_GX1_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Onmessage_gx1 */
                        e19OK2 ();
                        dynload_actions( ) ;
                     }
                  }
                  else
                  {
                     sEvtType = GXutil.right( sEvt, 4) ;
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                     if ( ( GXutil.strcmp(GXutil.left( sEvt, 11), "START_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 13), "REFRESH_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 29), "GRIDOPCIONES_MPAGE.LOAD_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 32), "GRIDOPCIONES_MPAGE.REFRESH_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 19), "ONMESSAGE_GX1_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 11), "ENTER_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 12), "CANCEL_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 11), "START_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 13), "REFRESH_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 29), "GRIDOPCIONES_MPAGE.LOAD_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 32), "GRIDOPCIONES_MPAGE.REFRESH_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 19), "ONMESSAGE_GX1_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 11), "ENTER_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 12), "CANCEL_MPAGE") == 0 ) )
                     {
                        nGXsfl_76_idx = (int)(GXutil.lval( sEvtType)) ;
                        sGXsfl_76_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_76_idx), 4, 0), (short)(4), "0") ;
                        subsflControlProps_762( ) ;
                        GXCCtl = "vNOTIFICATIONINFO_MPAGE_" + sGXsfl_76_idx ;
                        httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( GXCCtl), AV36NotificationInfo);
                        sEvtType = GXutil.right( sEvt, 1) ;
                        if ( GXutil.strcmp(sEvtType, ".") == 0 )
                        {
                           sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                           if ( GXutil.strcmp(sEvt, "START_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Start */
                              e20OK2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "REFRESH_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Refresh */
                              e21OK2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "GRIDOPCIONES_MPAGE.LOAD_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              e22OK2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "GRIDOPCIONES_MPAGE.REFRESH_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              e23OK2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "ONMESSAGE_GX1_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Onmessage_gx1 */
                              e19OK2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "ENTER_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 Rfr0gs = false ;
                                 if ( ! Rfr0gs )
                                 {
                                 }
                                 dynload_actions( ) ;
                              }
                              /* No code required for Cancel button. It is implemented as the Reset button. */
                           }
                           else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "ONMESSAGE_GX1_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Onmessage_gx1 */
                              e19OK2 ();
                           }
                        }
                        else
                        {
                           sEvtType = GXutil.right( sEvt, 4) ;
                           sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                           if ( ( GXutil.strcmp(GXutil.left( sEvt, 11), "START_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 13), "REFRESH_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 29), "GRIDOPCIONES_MPAGE.LOAD_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 32), "GRIDOPCIONES_MPAGE.REFRESH_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 19), "ONMESSAGE_GX1_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 11), "ENTER_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 12), "CANCEL_MPAGE") == 0 ) )
                           {
                              nGXsfl_76_idx = (int)(GXutil.lval( sEvtType)) ;
                              sGXsfl_76_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_76_idx), 4, 0), (short)(4), "0") ;
                              subsflControlProps_762( ) ;
                              sEvtType = GXutil.right( sEvt, 1) ;
                              if ( GXutil.strcmp(sEvtType, ".") == 0 )
                              {
                                 sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                                 if ( GXutil.strcmp(sEvt, "START_MPAGE") == 0 )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    dynload_actions( ) ;
                                    /* Execute user event: Start */
                                    e20OK2 ();
                                 }
                                 else if ( GXutil.strcmp(sEvt, "REFRESH_MPAGE") == 0 )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    dynload_actions( ) ;
                                    /* Execute user event: Refresh */
                                    e21OK2 ();
                                 }
                                 else if ( GXutil.strcmp(sEvt, "GRIDOPCIONES_MPAGE.LOAD_MPAGE") == 0 )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    dynload_actions( ) ;
                                    e22OK2 ();
                                 }
                                 else if ( GXutil.strcmp(sEvt, "GRIDOPCIONES_MPAGE.REFRESH_MPAGE") == 0 )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    dynload_actions( ) ;
                                    e23OK2 ();
                                 }
                                 else if ( GXutil.strcmp(sEvt, "ONMESSAGE_GX1_MPAGE") == 0 )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    dynload_actions( ) ;
                                    /* Execute user event: Onmessage_gx1 */
                                    e19OK2 ();
                                 }
                                 else if ( GXutil.strcmp(sEvt, "ENTER_MPAGE") == 0 )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       Rfr0gs = false ;
                                       if ( ! Rfr0gs )
                                       {
                                       }
                                       dynload_actions( ) ;
                                    }
                                    /* No code required for Cancel button. It is implemented as the Reset button. */
                                 }
                                 else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    dynload_actions( ) ;
                                 }
                                 else if ( GXutil.strcmp(sEvt, "ONMESSAGE_GX1_MPAGE") == 0 )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    dynload_actions( ) ;
                                    /* Execute user event: Onmessage_gx1 */
                                    e19OK2 ();
                                 }
                              }
                              else
                              {
                              }
                           }
                        }
                     }
                     else if ( ( GXutil.strcmp(GXutil.left( sEvt, 11), "START_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 13), "REFRESH_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 29), "GRIDOPCIONES_MPAGE.LOAD_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 32), "GRIDOPCIONES_MPAGE.REFRESH_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 19), "ONMESSAGE_GX1_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 11), "ENTER_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 12), "CANCEL_MPAGE") == 0 ) )
                     {
                        nGXsfl_76_idx = (int)(GXutil.lval( sEvtType)) ;
                        sGXsfl_76_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_76_idx), 4, 0), (short)(4), "0") ;
                        subsflControlProps_762( ) ;
                        sEvtType = GXutil.right( sEvt, 1) ;
                        if ( GXutil.strcmp(sEvtType, ".") == 0 )
                        {
                           sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                           if ( GXutil.strcmp(sEvt, "START_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Start */
                              e20OK2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "REFRESH_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Refresh */
                              e21OK2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "GRIDOPCIONES_MPAGE.LOAD_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              e22OK2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "GRIDOPCIONES_MPAGE.REFRESH_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              e23OK2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "ONMESSAGE_GX1_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Onmessage_gx1 */
                              e19OK2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "ENTER_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 Rfr0gs = false ;
                                 if ( ! Rfr0gs )
                                 {
                                 }
                                 dynload_actions( ) ;
                              }
                              /* No code required for Cancel button. It is implemented as the Reset button. */
                           }
                           else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "ONMESSAGE_GX1_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Onmessage_gx1 */
                              e19OK2 ();
                           }
                        }
                        else
                        {
                        }
                     }
                     else if ( ( GXutil.strcmp(GXutil.left( sEvt, 11), "START_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 13), "REFRESH_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 29), "GRIDOPCIONES_MPAGE.LOAD_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 32), "GRIDOPCIONES_MPAGE.REFRESH_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 19), "ONMESSAGE_GX1_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 11), "ENTER_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 12), "CANCEL_MPAGE") == 0 ) )
                     {
                        nGXsfl_76_idx = (int)(GXutil.lval( sEvtType)) ;
                        sGXsfl_76_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_76_idx), 4, 0), (short)(4), "0") ;
                        subsflControlProps_762( ) ;
                        sEvtType = GXutil.right( sEvt, 1) ;
                        if ( GXutil.strcmp(sEvtType, ".") == 0 )
                        {
                           sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                           if ( GXutil.strcmp(sEvt, "START_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Start */
                              e20OK2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "REFRESH_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Refresh */
                              e21OK2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "GRIDOPCIONES_MPAGE.LOAD_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              e22OK2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "GRIDOPCIONES_MPAGE.REFRESH_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              e23OK2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "ONMESSAGE_GX1_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Onmessage_gx1 */
                              e19OK2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "ENTER_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 Rfr0gs = false ;
                                 if ( ! Rfr0gs )
                                 {
                                 }
                                 dynload_actions( ) ;
                              }
                              /* No code required for Cancel button. It is implemented as the Reset button. */
                           }
                           else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "ONMESSAGE_GX1_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Onmessage_gx1 */
                              e19OK2 ();
                           }
                        }
                        else
                        {
                        }
                     }
                     else if ( ( GXutil.strcmp(GXutil.left( sEvt, 11), "START_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 13), "REFRESH_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 29), "GRIDOPCIONES_MPAGE.LOAD_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 32), "GRIDOPCIONES_MPAGE.REFRESH_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 19), "ONMESSAGE_GX1_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 11), "ENTER_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 12), "CANCEL_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 11), "START_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 13), "REFRESH_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 29), "GRIDOPCIONES_MPAGE.LOAD_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 32), "GRIDOPCIONES_MPAGE.REFRESH_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 19), "ONMESSAGE_GX1_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 11), "ENTER_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 12), "CANCEL_MPAGE") == 0 ) )
                     {
                        nGXsfl_76_idx = (int)(GXutil.lval( sEvtType)) ;
                        sGXsfl_76_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_76_idx), 4, 0), (short)(4), "0") ;
                        subsflControlProps_762( ) ;
                        sEvtType = GXutil.right( sEvt, 1) ;
                        if ( GXutil.strcmp(sEvtType, ".") == 0 )
                        {
                           sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                           if ( GXutil.strcmp(sEvt, "START_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Start */
                              e20OK2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "REFRESH_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Refresh */
                              e21OK2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "GRIDOPCIONES_MPAGE.LOAD_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              e22OK2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "GRIDOPCIONES_MPAGE.REFRESH_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              e23OK2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "ONMESSAGE_GX1_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Onmessage_gx1 */
                              e19OK2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "ENTER_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 Rfr0gs = false ;
                                 if ( ! Rfr0gs )
                                 {
                                 }
                                 dynload_actions( ) ;
                              }
                              /* No code required for Cancel button. It is implemented as the Reset button. */
                           }
                           else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "ONMESSAGE_GX1_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Onmessage_gx1 */
                              e19OK2 ();
                           }
                        }
                        else
                        {
                           sEvtType = GXutil.right( sEvt, 4) ;
                           sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                           if ( ( GXutil.strcmp(GXutil.left( sEvt, 11), "START_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 13), "REFRESH_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 29), "GRIDOPCIONES_MPAGE.LOAD_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 32), "GRIDOPCIONES_MPAGE.REFRESH_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 19), "ONMESSAGE_GX1_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 11), "ENTER_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 12), "CANCEL_MPAGE") == 0 ) )
                           {
                              nGXsfl_76_idx = (int)(GXutil.lval( sEvtType)) ;
                              sGXsfl_76_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_76_idx), 4, 0), (short)(4), "0") ;
                              subsflControlProps_762( ) ;
                              sEvtType = GXutil.right( sEvt, 1) ;
                              if ( GXutil.strcmp(sEvtType, ".") == 0 )
                              {
                                 sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                                 if ( GXutil.strcmp(sEvt, "START_MPAGE") == 0 )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    dynload_actions( ) ;
                                    /* Execute user event: Start */
                                    e20OK2 ();
                                 }
                                 else if ( GXutil.strcmp(sEvt, "REFRESH_MPAGE") == 0 )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    dynload_actions( ) ;
                                    /* Execute user event: Refresh */
                                    e21OK2 ();
                                 }
                                 else if ( GXutil.strcmp(sEvt, "GRIDOPCIONES_MPAGE.LOAD_MPAGE") == 0 )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    dynload_actions( ) ;
                                    e22OK2 ();
                                 }
                                 else if ( GXutil.strcmp(sEvt, "GRIDOPCIONES_MPAGE.REFRESH_MPAGE") == 0 )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    dynload_actions( ) ;
                                    e23OK2 ();
                                 }
                                 else if ( GXutil.strcmp(sEvt, "ONMESSAGE_GX1_MPAGE") == 0 )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    dynload_actions( ) ;
                                    /* Execute user event: Onmessage_gx1 */
                                    e19OK2 ();
                                 }
                                 else if ( GXutil.strcmp(sEvt, "ENTER_MPAGE") == 0 )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       Rfr0gs = false ;
                                       if ( ! Rfr0gs )
                                       {
                                       }
                                       dynload_actions( ) ;
                                    }
                                    /* No code required for Cancel button. It is implemented as the Reset button. */
                                 }
                                 else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    dynload_actions( ) ;
                                 }
                                 else if ( GXutil.strcmp(sEvt, "ONMESSAGE_GX1_MPAGE") == 0 )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    dynload_actions( ) ;
                                    /* Execute user event: Onmessage_gx1 */
                                    e19OK2 ();
                                 }
                              }
                              else
                              {
                              }
                           }
                        }
                     }
                  }
               }
               else if ( GXutil.strcmp(sEvtType, "M") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, GXutil.len( sEvt)-2) ;
                  sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-6) ;
                  nCmpId = (short)(GXutil.lval( sEvtType)) ;
                  if ( nCmpId == 171 )
                  {
                     OldDdc_adminag_wc = httpContext.cgiGet( "MPW0171") ;
                     if ( ( GXutil.len( OldDdc_adminag_wc) == 0 ) || ( GXutil.strcmp(OldDdc_adminag_wc, WebComp_Ddc_adminag_wc_Component) != 0 ) )
                     {
                        WebComp_Ddc_adminag_wc = WebUtils.getWebComponent(getClass(), "web." + OldDdc_adminag_wc + "_impl", remoteHandle, context);
                        WebComp_Ddc_adminag_wc_Component = OldDdc_adminag_wc ;
                     }
                     if ( GXutil.len( WebComp_Ddc_adminag_wc_Component) != 0 )
                     {
                        WebComp_Ddc_adminag_wc.componentprocess("MPW0171", "", sEvt);
                     }
                     WebComp_Ddc_adminag_wc_Component = OldDdc_adminag_wc ;
                  }
               }
               if ( httpContext.wbHandled == 0 )
               {
                  getDataAreaObject().dispatchEvents();
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
   }

   public void weOK2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormOK2( ) ;
         }
      }
   }

   public void paOK2( )
   {
      if ( nDonePA == 0 )
      {
         if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
         {
            gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         init_web_controls( ) ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = cmbavEmpcod.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", true, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgridopciones_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_762( ) ;
      while ( nGXsfl_76_idx <= nRC_GXsfl_76 )
      {
         sendrow_762( ) ;
         nGXsfl_76_idx = ((subGridopciones_Islastpage==1)&&(nGXsfl_76_idx+1>subgridopciones_fnc_recordsperpage( )) ? 1 : nGXsfl_76_idx+1) ;
         sGXsfl_76_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_76_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_762( ) ;
      }
      addString( httpContext.getJSONContainerResponse( MPGridopcionesContainer)) ;
      /* End function gxnrGridopciones_newrow */
   }

   public void gxgrgridopciones_refresh( String AV90Pgmname ,
                                         short AV16EmpCod ,
                                         int AV9CliCod ,
                                         int A3CliCod ,
                                         short A1EmpCod ,
                                         String A2EmpNom ,
                                         short A1564CliPaiConve ,
                                         boolean A2429CliConveEsquemaEs ,
                                         String A1565CliConvenio ,
                                         String A1567CliConvenioDescrip ,
                                         String AV12contentHolder_Pgmname ,
                                         byte AV43RolId ,
                                         byte AV39PerfilId ,
                                         long AV34MenuVerId ,
                                         String AV51selMenuOpcCod ,
                                         byte A1923RolId ,
                                         byte A1925PerfilId ,
                                         long A1928MenuVerId ,
                                         byte A1940MenuItemOrd ,
                                         String A1933MenuOpcPadre ,
                                         String A1935SVGId ,
                                         String A1936SVGValor ,
                                         String A1929MenuOpcCod ,
                                         String AV41primero_MenuOpcCod ,
                                         String A1931MenuOpcTitulo ,
                                         String A1937MenuItemId ,
                                         GXSimpleCollection<String> AV54urls ,
                                         String AV31MenuItemId ,
                                         String AV85hormigaURL )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e21OK2 ();
      GRIDOPCIONES_MPAGE_nCurrentRecord = 0 ;
      rfOK2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridopciones_refresh */
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( cmbavEmpcod.getItemCount() > 0 )
      {
         AV16EmpCod = (short)(GXutil.lval( cmbavEmpcod.getValidValue(GXutil.trim( GXutil.str( AV16EmpCod, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", true, "AV16EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16EmpCod), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavEmpcod.setValue( GXutil.trim( GXutil.str( AV16EmpCod, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", true, cmbavEmpcod.getInternalname(), "Values", cmbavEmpcod.ToJavascriptSource(), true);
      }
      if ( cmbavConvecodigo.getItemCount() > 0 )
      {
         AV13ConveCodigo = cmbavConvecodigo.getValidValue(AV13ConveCodigo) ;
         httpContext.ajax_rsp_assign_attri("", true, "AV13ConveCodigo", AV13ConveCodigo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConvecodigo.setValue( GXutil.rtrim( AV13ConveCodigo) );
         httpContext.ajax_rsp_assign_prop("", true, cmbavConvecodigo.getInternalname(), "Values", cmbavConvecodigo.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      /* Execute user event: Refresh */
      e21OK2 ();
      rfOK2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV90Pgmname = "WWPBaseObjects.NewMasterPage" ;
      Gx_err = (short)(0) ;
   }

   public void rfOK2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( ShowMPWhenPopUp( ) || ! httpContext.isPopUpObject( ) )
      {
         if ( isAjaxCallMode( ) )
         {
            MPGridopcionesContainer.ClearRows();
         }
         wbStart = (short)(76) ;
         e23OK2 ();
         nGXsfl_76_idx = 1 ;
         sGXsfl_76_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_76_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_762( ) ;
         bGXsfl_76_Refreshing = true ;
         MPGridopcionesContainer.AddObjectProperty("GridName", "Gridopciones");
         MPGridopcionesContainer.AddObjectProperty("CmpContext", "");
         MPGridopcionesContainer.AddObjectProperty("InMasterPage", "true");
         MPGridopcionesContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
         MPGridopcionesContainer.AddObjectProperty("Class", "FreeStyleGrid");
         MPGridopcionesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         MPGridopcionesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         MPGridopcionesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridopciones_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         MPGridopcionesContainer.setPageSize( subgridopciones_fnc_recordsperpage( ) );
         if ( subGridopciones_Islastpage != 0 )
         {
            GRIDOPCIONES_MPAGE_nFirstRecordOnPage = (long)(subgridopciones_fnc_recordcount( )-subgridopciones_fnc_recordsperpage( )) ;
            web.GxWebStd.gx_hidden_field( httpContext, "GRIDOPCIONES_MPAGE_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDOPCIONES_MPAGE_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
            MPGridopcionesContainer.AddObjectProperty("GRIDOPCIONES_MPAGE_nFirstRecordOnPage", GRIDOPCIONES_MPAGE_nFirstRecordOnPage);
         }
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
         {
            if ( 1 != 0 )
            {
               if ( GXutil.len( WebComp_Ddc_adminag_wc_Component) != 0 )
               {
                  WebComp_Ddc_adminag_wc.componentstart();
               }
            }
         }
         gxdyncontrolsrefreshing = true ;
         fix_multi_value_controls( ) ;
         gxdyncontrolsrefreshing = false ;
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_762( ) ;
         e22OK2 ();
         wbEnd = (short)(76) ;
         wbOK0( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
      }
      bGXsfl_76_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesOK2( )
   {
   }

   public int subgridopciones_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgridopciones_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgridopciones_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgridopciones_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      AV90Pgmname = "WWPBaseObjects.NewMasterPage" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupOK0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e20OK2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS_MPAGE"), AV81DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vBUSCARMENU_DATA_MPAGE"), AV80BuscarMenu_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLANGUAGESICONSDATA_MPAGE"), AV28LanguagesIconsData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vNOTIFICATIONINFO_MPAGE"), AV36NotificationInfo);
         /* Read saved values. */
         nRC_GXsfl_76 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_76"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddc_adminag_Icon = httpContext.cgiGet( "DDC_ADMINAG_MPAGE_Icon") ;
         Ddc_adminag_Cls = httpContext.cgiGet( "DDC_ADMINAG_MPAGE_Cls") ;
         Ddc_adminag_Componentwidth = (int)(localUtil.ctol( httpContext.cgiGet( "DDC_ADMINAG_MPAGE_Componentwidth"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddc_adminag_Visible = GXutil.strtobool( httpContext.cgiGet( "DDC_ADMINAG_MPAGE_Visible")) ;
         Ddc_adminag_Showloading = GXutil.strtobool( httpContext.cgiGet( "DDC_ADMINAG_MPAGE_Showloading")) ;
         Ddc_adminag_Load = httpContext.cgiGet( "DDC_ADMINAG_MPAGE_Load") ;
         Combo_buscarmenu_Cls = httpContext.cgiGet( "COMBO_BUSCARMENU_MPAGE_Cls") ;
         Combo_buscarmenu_Selectedvalue_set = httpContext.cgiGet( "COMBO_BUSCARMENU_MPAGE_Selectedvalue_set") ;
         Combo_buscarmenu_Selectedtext_set = httpContext.cgiGet( "COMBO_BUSCARMENU_MPAGE_Selectedtext_set") ;
         Combo_buscarmenu_Dropdownoptionstype = httpContext.cgiGet( "COMBO_BUSCARMENU_MPAGE_Dropdownoptionstype") ;
         Combo_buscarmenu_Emptyitemtext = httpContext.cgiGet( "COMBO_BUSCARMENU_MPAGE_Emptyitemtext") ;
         Ddo_languagesicons_Caption = httpContext.cgiGet( "DDO_LANGUAGESICONS_MPAGE_Caption") ;
         Ddo_languagesicons_Cls = httpContext.cgiGet( "DDO_LANGUAGESICONS_MPAGE_Cls") ;
         Ddo_languagesicons_Titlecontrolalign = httpContext.cgiGet( "DDO_LANGUAGESICONS_MPAGE_Titlecontrolalign") ;
         Ucmessage_Width = httpContext.cgiGet( "UCMESSAGE_MPAGE_Width") ;
         Ucmessage_Minheight = httpContext.cgiGet( "UCMESSAGE_MPAGE_Minheight") ;
         Ucmessage_Stylingtype = httpContext.cgiGet( "UCMESSAGE_MPAGE_Stylingtype") ;
         Ucmessage_Defaultmessagetype = httpContext.cgiGet( "UCMESSAGE_MPAGE_Defaultmessagetype") ;
         Ucmessage_Stoponerror = GXutil.strtobool( httpContext.cgiGet( "UCMESSAGE_MPAGE_Stoponerror")) ;
         Ucmessage_Titleescape = GXutil.strtobool( httpContext.cgiGet( "UCMESSAGE_MPAGE_Titleescape")) ;
         Ucmessage_Textescape = GXutil.strtobool( httpContext.cgiGet( "UCMESSAGE_MPAGE_Textescape")) ;
         Ucmessage_Changenewlinestobrs = GXutil.strtobool( httpContext.cgiGet( "UCMESSAGE_MPAGE_Changenewlinestobrs")) ;
         Ucmessage_Hide = GXutil.strtobool( httpContext.cgiGet( "UCMESSAGE_MPAGE_Hide")) ;
         Ucmessage_Delayuntilhide = (int)(localUtil.ctol( httpContext.cgiGet( "UCMESSAGE_MPAGE_Delayuntilhide"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ucmessage_Mousehidereset = GXutil.strtobool( httpContext.cgiGet( "UCMESSAGE_MPAGE_Mousehidereset")) ;
         Ucmessage_Effectin = httpContext.cgiGet( "UCMESSAGE_MPAGE_Effectin") ;
         Ucmessage_Effectout = httpContext.cgiGet( "UCMESSAGE_MPAGE_Effectout") ;
         Ucmessage_Animationspeed = (int)(localUtil.ctol( httpContext.cgiGet( "UCMESSAGE_MPAGE_Animationspeed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ucmessage_Startposition = httpContext.cgiGet( "UCMESSAGE_MPAGE_Startposition") ;
         Ucmessage_Nextmessageposition = httpContext.cgiGet( "UCMESSAGE_MPAGE_Nextmessageposition") ;
         Ucmessage_Closer = GXutil.strtobool( httpContext.cgiGet( "UCMESSAGE_MPAGE_Closer")) ;
         Ucmessage_Sticker = GXutil.strtobool( httpContext.cgiGet( "UCMESSAGE_MPAGE_Sticker")) ;
         Ucmessage_Stickerhover = GXutil.strtobool( httpContext.cgiGet( "UCMESSAGE_MPAGE_Stickerhover")) ;
         Ucmessage_Labelclosebutton = httpContext.cgiGet( "UCMESSAGE_MPAGE_Labelclosebutton") ;
         Ucmessage_Labelstickbutton = httpContext.cgiGet( "UCMESSAGE_MPAGE_Labelstickbutton") ;
         Ucmessage_Showevenonnonblock = GXutil.strtobool( httpContext.cgiGet( "UCMESSAGE_MPAGE_Showevenonnonblock")) ;
         Ucmessage_Menu = GXutil.strtobool( httpContext.cgiGet( "UCMESSAGE_MPAGE_Menu")) ;
         Ucmessage_Maxonscreen = httpContext.cgiGet( "UCMESSAGE_MPAGE_Maxonscreen") ;
         Ucmessage_Labelredisplay = httpContext.cgiGet( "UCMESSAGE_MPAGE_Labelredisplay") ;
         Ucmessage_Labelall = httpContext.cgiGet( "UCMESSAGE_MPAGE_Labelall") ;
         Ucmessage_Labellast = httpContext.cgiGet( "UCMESSAGE_MPAGE_Labellast") ;
         Wwputilities_Enablefixobjectfitcover = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Enablefixobjectfitcover")) ;
         Wwputilities_Empowertabs = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Empowertabs")) ;
         Wwputilities_Enableupdaterowselectionstatus = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Enableupdaterowselectionstatus")) ;
         Wwputilities_Enableconvertcombotobootstrapselect = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Enableconvertcombotobootstrapselect")) ;
         Wwputilities_Allowcolumnresizing = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Allowcolumnresizing")) ;
         Wwputilities_Allowcolumnreordering = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Allowcolumnreordering")) ;
         Wwputilities_Allowcolumndragging = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Allowcolumndragging")) ;
         Wwputilities_Allowcolumnsrestore = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Allowcolumnsrestore")) ;
         Wwputilities_Pagbarincludegoto = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Pagbarincludegoto")) ;
         A3llinktabla1_Linkrowid = httpContext.cgiGet( "A3LLINKTABLA1_MPAGE_Linkrowid") ;
         A3llinktabla1_Urls = httpContext.cgiGet( "A3LLINKTABLA1_MPAGE_Urls") ;
         subGridopciones_Class = httpContext.cgiGet( "GRIDOPCIONES_MPAGE_Class") ;
         subGridopciones_Flexdirection = httpContext.cgiGet( "GRIDOPCIONES_MPAGE_Flexdirection") ;
         Ddo_languagesicons_Activeeventkey = httpContext.cgiGet( "DDO_LANGUAGESICONS_MPAGE_Activeeventkey") ;
         Combo_buscarmenu_Selectedvalue_get = httpContext.cgiGet( "COMBO_BUSCARMENU_MPAGE_Selectedvalue_get") ;
         /* Read variables values. */
         cmbavEmpcod.setName( cmbavEmpcod.getInternalname() );
         cmbavEmpcod.setValue( httpContext.cgiGet( cmbavEmpcod.getInternalname()) );
         AV16EmpCod = (short)(GXutil.lval( httpContext.cgiGet( cmbavEmpcod.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", true, "AV16EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16EmpCod), 4, 0));
         cmbavConvecodigo.setName( cmbavConvecodigo.getInternalname() );
         cmbavConvecodigo.setValue( httpContext.cgiGet( cmbavConvecodigo.getInternalname()) );
         AV13ConveCodigo = httpContext.cgiGet( cmbavConvecodigo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", true, "AV13ConveCodigo", AV13ConveCodigo);
         AV76BuscarMenu = httpContext.cgiGet( edtavBuscarmenu_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", true, "AV76BuscarMenu", AV76BuscarMenu);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavPickerdummyvariable_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vPICKERDUMMYVARIABLE_MPAGE");
            GX_FocusControl = edtavPickerdummyvariable_Internalname ;
            httpContext.ajax_rsp_assign_attri("", true, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV40PickerDummyVariable = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", true, "AV40PickerDummyVariable", localUtil.format(AV40PickerDummyVariable, "99/99/99"));
         }
         else
         {
            AV40PickerDummyVariable = localUtil.ctod( httpContext.cgiGet( edtavPickerdummyvariable_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", true, "AV40PickerDummyVariable", localUtil.format(AV40PickerDummyVariable, "99/99/99"));
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e20OK2 ();
      if (returnInSub) return;
   }

   public void e20OK2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, httpContext.getMessage( "start masterpage", "")) ;
      AV84actualURL = GXutil.trim( AV22Httprequest.getBaseURL()) + GXutil.trim( AV22Httprequest.getScriptName()) + "?" + GXutil.trim( AV22Httprequest.getQuerystring()) ;
      new web.validasesion(remoteHandle, context).execute( AV84actualURL) ;
      GXt_char1 = AV49SecUserName ;
      GXv_char2[0] = GXt_char1 ;
      new web.getusulogged(remoteHandle, context).execute( GXv_char2) ;
      newmasterpage_impl.this.GXt_char1 = GXv_char2[0] ;
      AV49SecUserName = GXt_char1 ;
      GXv_char2[0] = AV50SecUserPerName ;
      GXv_char3[0] = AV73SecUserPerLastName ;
      GXv_char4[0] = AV74RolNombre ;
      new web.usergetdatosbyname(remoteHandle, context).execute( AV49SecUserName, GXv_char2, GXv_char3, GXv_char4) ;
      newmasterpage_impl.this.AV50SecUserPerName = GXv_char2[0] ;
      newmasterpage_impl.this.AV73SecUserPerLastName = GXv_char3[0] ;
      newmasterpage_impl.this.AV74RolNombre = GXv_char4[0] ;
      tblTableidioma_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", true, tblTableidioma_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTableidioma_Visible), 5, 0), true);
      divLayoutmaintable_Class = "MainContainerWithFooter" ;
      httpContext.ajax_rsp_assign_prop("", true, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXt_objcol_SdtDVelop_Menu_Item5 = AV15DVelop_Menu ;
      GXv_objcol_SdtDVelop_Menu_Item6[0] = GXt_objcol_SdtDVelop_Menu_Item5 ;
      new web.wwpbaseobjects.menuoptionsdata(remoteHandle, context).execute( GXv_objcol_SdtDVelop_Menu_Item6) ;
      GXt_objcol_SdtDVelop_Menu_Item5 = GXv_objcol_SdtDVelop_Menu_Item6[0] ;
      AV15DVelop_Menu = GXt_objcol_SdtDVelop_Menu_Item5 ;
      GXv_objcol_SdtDVelop_Menu_Item6[0] = AV15DVelop_Menu ;
      new web.wwpbaseobjects.getmenuauthorizedoptions(remoteHandle, context).execute( GXv_objcol_SdtDVelop_Menu_Item6) ;
      AV15DVelop_Menu = GXv_objcol_SdtDVelop_Menu_Item6[0] ;
      GXt_int7 = AV9CliCod ;
      GXv_int8[0] = GXt_int7 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int8) ;
      newmasterpage_impl.this.GXt_int7 = GXv_int8[0] ;
      AV9CliCod = GXt_int7 ;
      httpContext.ajax_rsp_assign_attri("", true, "AV9CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9CliCod), 6, 0));
      GXt_int9 = AV48SecUserId ;
      GXv_int10[0] = GXt_int9 ;
      new web.getusuloggedid(remoteHandle, context).execute( GXv_int10) ;
      newmasterpage_impl.this.GXt_int9 = GXv_int10[0] ;
      AV48SecUserId = GXt_int9 ;
      GXv_int11[0] = AV43RolId ;
      GXv_int12[0] = AV39PerfilId ;
      GXv_int13[0] = AV34MenuVerId ;
      new web.getusumenu(remoteHandle, context).execute( AV48SecUserId, GXv_int11, GXv_int12, GXv_int13) ;
      newmasterpage_impl.this.AV43RolId = GXv_int11[0] ;
      newmasterpage_impl.this.AV39PerfilId = GXv_int12[0] ;
      newmasterpage_impl.this.AV34MenuVerId = GXv_int13[0] ;
      httpContext.ajax_rsp_assign_attri("", true, "AV43RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43RolId), 2, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vROLID_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV43RolId), "Z9")));
      httpContext.ajax_rsp_assign_attri("", true, "AV39PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV39PerfilId), 2, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERFILID_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV39PerfilId), "Z9")));
      httpContext.ajax_rsp_assign_attri("", true, "AV34MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34MenuVerId), 15, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUVERID_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV34MenuVerId), "ZZZZZZZZZZZZZZ9")));
      /* Execute user subroutine: 'REFRESCAR EMPRESAS' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'REFRESCAR CONVENIOS' */
      S122 ();
      if (returnInSub) return;
      GXt_int9 = AV16EmpCod ;
      GXv_int10[0] = GXt_int9 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int10) ;
      newmasterpage_impl.this.GXt_int9 = GXv_int10[0] ;
      AV16EmpCod = GXt_int9 ;
      httpContext.ajax_rsp_assign_attri("", true, "AV16EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16EmpCod), 4, 0));
      GXt_char1 = AV13ConveCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char4) ;
      newmasterpage_impl.this.GXt_char1 = GXv_char4[0] ;
      AV13ConveCodigo = GXt_char1 ;
      httpContext.ajax_rsp_assign_attri("", true, "AV13ConveCodigo", AV13ConveCodigo);
      GXv_char4[0] = AV27Language ;
      if ( new web.wwpbaseobjects.wwp_loadlanguageandtheme(remoteHandle, context).executeUdp( GXv_char4) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      newmasterpage_impl.this.AV27Language = GXv_char4[0] ;
      if ( Cond_result )
      {
         httpContext.doAjaxRefresh();
      }
      Ddo_languagesicons_Titlecontrolalign = "Left" ;
      ucDdo_languagesicons.sendProperty(context, "", true, Ddo_languagesicons_Internalname, "TitleControlAlign", Ddo_languagesicons_Titlecontrolalign);
      if ( GXutil.strcmp(AV27Language, "English") == 0 )
      {
         Ddo_languagesicons_Caption = httpContext.getMessage( "EN", "") ;
         ucDdo_languagesicons.sendProperty(context, "", true, Ddo_languagesicons_Internalname, "Caption", Ddo_languagesicons_Caption);
      }
      else if ( GXutil.strcmp(AV27Language, "Spanish") == 0 )
      {
         Ddo_languagesicons_Caption = httpContext.getMessage( "ES", "") ;
         ucDdo_languagesicons.sendProperty(context, "", true, Ddo_languagesicons_Internalname, "Caption", Ddo_languagesicons_Caption);
      }
      if ( GXutil.strcmp(AV22Httprequest.getMethod(), "GET") == 0 )
      {
         GXt_SdtWWP_DesignSystemSettings14 = AV6WWP_DesignSystemSettings;
         GXv_SdtWWP_DesignSystemSettings15[0] = GXt_SdtWWP_DesignSystemSettings14;
         new web.wwpbaseobjects.wwp_getdesignsystemsettings(remoteHandle, context).execute( GXv_SdtWWP_DesignSystemSettings15) ;
         GXt_SdtWWP_DesignSystemSettings14 = GXv_SdtWWP_DesignSystemSettings15[0] ;
         AV6WWP_DesignSystemSettings = GXt_SdtWWP_DesignSystemSettings14;
         this.executeExternalObjectMethod("", true, "gx.core.ds", "setOption", new Object[] {"base-color",AV6WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Basecolor()}, false);
         this.executeExternalObjectMethod("", true, "gx.core.ds", "setOption", new Object[] {"background-color",AV6WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Backgroundstyle()}, false);
         this.executeExternalObjectMethod("", true, "gx.core.ds", "setOption", new Object[] {"font-size",AV6WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Fontsize()}, false);
         this.executeExternalObjectMethod("", true, "WWPActions", "EmpoweredGrids_Refresh", new Object[] {}, false);
      }
      GXt_char1 = "" ;
      GXt_char16 = "" ;
      GXv_char4[0] = GXt_char16 ;
      new web.svgid_volver(remoteHandle, context).execute( GXv_char4) ;
      newmasterpage_impl.this.GXt_char16 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char1 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char16, GXv_char3) ;
      newmasterpage_impl.this.GXt_char1 = GXv_char3[0] ;
      lblVolversvg_Caption = GXt_char1 ;
      httpContext.ajax_rsp_assign_prop("", true, lblVolversvg_Internalname, "Caption", lblVolversvg_Caption, true);
      /* Execute user subroutine: 'MONACO EDITOR' */
      S132 ();
      if (returnInSub) return;
      GXv_char4[0] = AV78ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.promovisible_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      newmasterpage_impl.this.AV78ParmValue = GXv_char4[0] ;
      if ( ! (GXutil.strcmp("", AV78ParmValue)==0) )
      {
         AV77promoVisible = GXutil.boolval( AV78ParmValue) ;
         httpContext.ajax_rsp_assign_attri("", true, "AV77promoVisible", AV77promoVisible);
      }
      divTablepromomenu_Visible = (AV77promoVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", true, divTablepromomenu_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablepromomenu_Visible), 5, 0), true);
      divTablealerta_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", true, divTablealerta_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablealerta_Visible), 5, 0), true);
      GXt_int7 = AV9CliCod ;
      GXv_int8[0] = GXt_int7 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int8) ;
      newmasterpage_impl.this.GXt_int7 = GXv_int8[0] ;
      AV9CliCod = GXt_int7 ;
      httpContext.ajax_rsp_assign_attri("", true, "AV9CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9CliCod), 6, 0));
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons17 = AV81DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons18[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons17;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons18) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons17 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons18[0] ;
      AV81DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons17;
      edtavBuscarmenu_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", true, edtavBuscarmenu_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBuscarmenu_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOBUSCARMENU' */
      S142 ();
      if (returnInSub) return;
      AV28LanguagesIconsData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle) ;
      AV29LanguagesIconsDataItem = (web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV29LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( httpContext.getMessage( "English", "") );
      AV29LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon( httpContext.convertURL( context.getHttpContext().getImagePath( "d17b971e-903f-42c1-8eac-c1f10bd50994", "", context.getHttpContext().getTheme( ))) );
      /* * Property gximage not supported in */
      /* * Property gximage not supported in */
      /* * Property gximage not supported in */
      /* * Property gximage not supported in */
      /*
         Assignment error:
         ================
         Expression: [ t('"EnglishIcon"',3) ]
         Target    : [ t([ t('Languagesiconsdataitem',23),t('Icon',3) ],29),t(gximage,3) ]
         ForType   : 29
         Type      : []
      */
      AV29LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "EnglishOption" );
      AV29LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
      AV28LanguagesIconsData.add(AV29LanguagesIconsDataItem, 0);
      AV29LanguagesIconsDataItem = (web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV29LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( httpContext.getMessage( "Spanish", "") );
      AV29LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon( httpContext.convertURL( context.getHttpContext().getImagePath( "673a1d61-33cb-4f10-916b-7c9fb6391c49", "", context.getHttpContext().getTheme( ))) );
      /* * Property gximage not supported in */
      /* * Property gximage not supported in */
      /* * Property gximage not supported in */
      /* * Property gximage not supported in */
      /*
         Assignment error:
         ================
         Expression: [ t('"SpanishIcon"',3) ]
         Target    : [ t([ t('Languagesiconsdataitem',23),t('Icon',3) ],29),t(gximage,3) ]
         ForType   : 29
         Type      : []
      */
      AV29LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "SpanishOption" );
      AV29LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
      AV28LanguagesIconsData.add(AV29LanguagesIconsDataItem, 0);
      if ( new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).executeUdp( "WWP_MasterPageTopActionsWC") )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         Ddc_adminag_Icon = httpContext.convertURL( context.getHttpContext().getImagePath( "49a43424-ba05-4750-b9af-2c959c70ff3a", "", context.getHttpContext().getTheme( ))) ;
         ucDdc_adminag.sendProperty(context, "", true, Ddc_adminag_Internalname, "Icon", Ddc_adminag_Icon);
         /* * Property gximage not supported in */
         /* * Property gximage not supported in */
         /* * Property gximage not supported in */
         /* * Property gximage not supported in */
         /*
            Assignment error:
            ================
            Expression: [ t('"Avatar2_b"',3) ]
            Target    : [ t([ t('Ddc_adminag',3),t('Icon',3) ],29),t(gximage,3) ]
            ForType   : 29
            Type      : []
         */
         /* Object Property */
         if ( true )
         {
            bDynCreated_Ddc_adminag_wc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Ddc_adminag_wc_Component), GXutil.lower( "WWPBaseObjects.WWP_MasterPageTopActionsWC")) != 0 )
         {
            WebComp_Ddc_adminag_wc = WebUtils.getWebComponent(getClass(), "web.wwpbaseobjects.wwp_masterpagetopactionswc_impl", remoteHandle, context);
            WebComp_Ddc_adminag_wc_Component = "WWPBaseObjects.WWP_MasterPageTopActionsWC" ;
         }
         if ( GXutil.len( WebComp_Ddc_adminag_wc_Component) != 0 )
         {
            WebComp_Ddc_adminag_wc.setjustcreated();
            WebComp_Ddc_adminag_wc.componentprepare(new Object[] {"MPW0171",""});
            WebComp_Ddc_adminag_wc.componentbind(new Object[] {});
         }
      }
   }

   public void e21OK2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      AV51selMenuOpcCod = AV57WebSession.getValue(httpContext.getMessage( "&selMenuOpcCod", "")) ;
      httpContext.ajax_rsp_assign_attri("", true, "AV51selMenuOpcCod", AV51selMenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSELMENUOPCCOD_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV51selMenuOpcCod, ""))));
      AV12contentHolder_Pgmname = Contentholder.getPgmname() ;
      httpContext.ajax_rsp_assign_attri("", true, "AV12contentHolder_Pgmname", AV12contentHolder_Pgmname);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONTENTHOLDER_PGMNAME_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV12contentHolder_Pgmname, ""))));
      AV84actualURL = GXutil.trim( AV22Httprequest.getBaseURL()) + GXutil.trim( AV22Httprequest.getScriptName()) + "?" + GXutil.trim( AV22Httprequest.getQuerystring()) ;
      new web.wwpbaseobjects.guardarnavegacion(remoteHandle, context).execute( AV84actualURL) ;
      GXv_boolean19[0] = AV25IsAuthorized ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( AV12contentHolder_Pgmname, GXv_boolean19) ;
      newmasterpage_impl.this.AV25IsAuthorized = GXv_boolean19[0] ;
      if ( ! AV25IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV12contentHolder_Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, httpContext.getMessage( "r1", "")) ;
      if ( GXutil.strcmp(AV57WebSession.getValue(httpContext.getMessage( "refrescar_empresas", "")), "") != 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, httpContext.getMessage( "r2", "")) ;
         /* Execute user subroutine: 'REFRESCAR EMPRESAS' */
         S112 ();
         if (returnInSub) return;
         AV57WebSession.remove(httpContext.getMessage( "refrescar_empresas", ""));
      }
      if ( GXutil.strcmp(AV57WebSession.getValue(httpContext.getMessage( "refrescar_convenios", "")), "") != 0 )
      {
         /* Execute user subroutine: 'REFRESCAR CONVENIOS' */
         S122 ();
         if (returnInSub) return;
         AV57WebSession.remove(httpContext.getMessage( "refrescar_convenios", ""));
      }
      if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV12contentHolder_Pgmname)), httpContext.getMessage( "LEGAJOSWW", "")) == 0 )
      {
         divParentrigthcontent_Class = httpContext.getMessage( "parentRigthContentLeg", "") ;
         httpContext.ajax_rsp_assign_prop("", true, divParentrigthcontent_Internalname, "Class", divParentrigthcontent_Class, true);
         divBottomcontent_Class = httpContext.getMessage( "bottomContentLeg", "") ;
         httpContext.ajax_rsp_assign_prop("", true, divBottomcontent_Internalname, "Class", divBottomcontent_Class, true);
         divRigthcontent_Class = httpContext.getMessage( "rigthContentLeg", "") ;
         httpContext.ajax_rsp_assign_prop("", true, divRigthcontent_Internalname, "Class", divRigthcontent_Class, true);
      }
      else
      {
         divParentrigthcontent_Class = httpContext.getMessage( "parentRigthContent", "") ;
         httpContext.ajax_rsp_assign_prop("", true, divParentrigthcontent_Internalname, "Class", divParentrigthcontent_Class, true);
         divBottomcontent_Class = httpContext.getMessage( "bottomContent", "") ;
         httpContext.ajax_rsp_assign_prop("", true, divBottomcontent_Internalname, "Class", divBottomcontent_Class, true);
         divRigthcontent_Class = httpContext.getMessage( "rigthContent", "") ;
         httpContext.ajax_rsp_assign_prop("", true, divRigthcontent_Internalname, "Class", divRigthcontent_Class, true);
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, httpContext.getMessage( "r3 empcod ", "")+GXutil.trim( GXutil.str( AV16EmpCod, 4, 0))) ;
      if ( ! new web.clienteempresamultiple(remoteHandle, context).executeUdp( AV9CliCod) || ( new web.esconceptosdefault(remoteHandle, context).executeUdp( ) ) || ( GXutil.strSearch( GXutil.upper( GXutil.trim( AV12contentHolder_Pgmname)), httpContext.getMessage( "ENTITYMANAGER", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( GXutil.trim( AV12contentHolder_Pgmname)), httpContext.getMessage( "LEGAJO_", ""), 1) != 0 ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         cmbavEmpcod.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", true, cmbavEmpcod.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavEmpcod.getEnabled(), 5, 0), true);
         divTabledoblecaret_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", true, divTabledoblecaret_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTabledoblecaret_Visible), 5, 0), true);
         divTablevariables_Class = httpContext.getMessage( "TableVariablesReadOnly", "") ;
         httpContext.ajax_rsp_assign_prop("", true, divTablevariables_Internalname, "Class", divTablevariables_Class, true);
      }
      else
      {
         if ( GXutil.strSearch( AV84actualURL, httpContext.getMessage( "&EmpCod=", ""), 1) != 0 )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            cmbavEmpcod.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", true, cmbavEmpcod.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavEmpcod.getEnabled(), 5, 0), true);
            divTabledoblecaret_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", true, divTabledoblecaret_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTabledoblecaret_Visible), 5, 0), true);
            divTablevariables_Class = httpContext.getMessage( "TableVariablesReadOnly", "") ;
            httpContext.ajax_rsp_assign_prop("", true, divTablevariables_Internalname, "Class", divTablevariables_Class, true);
         }
         else
         {
            cmbavEmpcod.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", true, cmbavEmpcod.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavEmpcod.getEnabled(), 5, 0), true);
            divTabledoblecaret_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", true, divTabledoblecaret_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTabledoblecaret_Visible), 5, 0), true);
            divTablevariables_Class = httpContext.getMessage( "TableVariables", "") ;
            httpContext.ajax_rsp_assign_prop("", true, divTablevariables_Internalname, "Class", divTablevariables_Class, true);
         }
      }
      /* Execute user subroutine: 'VISIBILIDAD COMBOS' */
      S152 ();
      if (returnInSub) return;
      GXt_int7 = AV9CliCod ;
      GXv_int8[0] = GXt_int7 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int8) ;
      newmasterpage_impl.this.GXt_int7 = GXv_int8[0] ;
      AV9CliCod = GXt_int7 ;
      httpContext.ajax_rsp_assign_attri("", true, "AV9CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9CliCod), 6, 0));
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S162 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'REFLEJAR OPCION' */
      S172 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavEmpcod.setValue( GXutil.trim( GXutil.str( AV16EmpCod, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", true, cmbavEmpcod.getInternalname(), "Values", cmbavEmpcod.ToJavascriptSource(), true);
      cmbavConvecodigo.setValue( GXutil.rtrim( AV13ConveCodigo) );
      httpContext.ajax_rsp_assign_prop("", true, cmbavConvecodigo.getInternalname(), "Values", cmbavConvecodigo.ToJavascriptSource(), true);
   }

   private void e22OK2( )
   {
      /* Gridopciones_Load Routine */
      returnInSub = false ;
      /* Using cursor H00OK2 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV43RolId), Byte.valueOf(AV39PerfilId), Long.valueOf(AV34MenuVerId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1923RolId = H00OK2_A1923RolId[0] ;
         A1925PerfilId = H00OK2_A1925PerfilId[0] ;
         A1928MenuVerId = H00OK2_A1928MenuVerId[0] ;
         A1933MenuOpcPadre = H00OK2_A1933MenuOpcPadre[0] ;
         n1933MenuOpcPadre = H00OK2_n1933MenuOpcPadre[0] ;
         A1935SVGId = H00OK2_A1935SVGId[0] ;
         n1935SVGId = H00OK2_n1935SVGId[0] ;
         A1936SVGValor = H00OK2_A1936SVGValor[0] ;
         A1929MenuOpcCod = H00OK2_A1929MenuOpcCod[0] ;
         A1931MenuOpcTitulo = H00OK2_A1931MenuOpcTitulo[0] ;
         A1937MenuItemId = H00OK2_A1937MenuItemId[0] ;
         A1940MenuItemOrd = H00OK2_A1940MenuItemOrd[0] ;
         A1936SVGValor = H00OK2_A1936SVGValor[0] ;
         if ( ! (GXutil.strcmp("", A1935SVGId)==0) )
         {
            lblSvg_opcion_Visible = 1 ;
            lblSvg_opcion_Caption = GXutil.trim( A1936SVGValor) ;
         }
         else
         {
            lblSvg_opcion_Visible = 0 ;
         }
         if ( GXutil.strcmp(A1929MenuOpcCod, AV41primero_MenuOpcCod) == 0 )
         {
            divTableopcionmenuizq_new_Class = httpContext.getMessage( "TableOpcionMenuIzqFocus_new", "") ;
            httpContext.ajax_rsp_assign_prop("", true, divTableopcionmenuizq_new_Internalname, "Class", divTableopcionmenuizq_new_Class, !bGXsfl_76_Refreshing);
            lblTextblockopcion_Class = httpContext.getMessage( "TextOptionMenuIzqBaseColor_new", "") ;
         }
         else
         {
            divTableopcionmenuizq_new_Class = httpContext.getMessage( "TableOpcionMenuIzq_new", "") ;
            httpContext.ajax_rsp_assign_prop("", true, divTableopcionmenuizq_new_Internalname, "Class", divTableopcionmenuizq_new_Class, !bGXsfl_76_Refreshing);
            lblTextblockopcion_Class = httpContext.getMessage( "TextOptionMenuIzq_new", "") ;
         }
         lblTextblockopcion_Caption = GXutil.trim( A1931MenuOpcTitulo) ;
         divTableupdatebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", true, divTableupdatebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTableupdatebadge_Visible), 5, 0), !bGXsfl_76_Refreshing);
         if ( GXutil.strcmp(A1929MenuOpcCod, httpContext.getMessage( "Actualizaciones", "")) == 0 )
         {
            GXv_int10[0] = AV75cant ;
            new web.getcantactualizaciones(remoteHandle, context).execute( AV9CliCod, GXv_int10) ;
            newmasterpage_impl.this.AV75cant = GXv_int10[0] ;
            if ( AV75cant > 0 )
            {
               divTableupdatebadge_Visible = 1 ;
               httpContext.ajax_rsp_assign_prop("", true, divTableupdatebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTableupdatebadge_Visible), 5, 0), !bGXsfl_76_Refreshing);
               lblUpdatebadge_Caption = GXutil.trim( GXutil.str( AV75cant, 4, 0)) ;
            }
         }
         GXt_char16 = AV33menuURL ;
         GXv_char4[0] = GXt_char16 ;
         new web.getlinkmenu(remoteHandle, context).execute( AV9CliCod, AV16EmpCod, AV39PerfilId, A1937MenuItemId, A1929MenuOpcCod, GXv_char4) ;
         newmasterpage_impl.this.GXt_char16 = GXv_char4[0] ;
         AV33menuURL = GXt_char16 ;
         AV54urls.add(AV33menuURL, 0);
         lblSvg_accion_Visible = 0 ;
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(76) ;
         }
         sendrow_762( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_76_Refreshing )
         {
            httpContext.doAjaxLoad(76, GridopcionesRow);
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      A3llinktabla1_Linkrowid = httpContext.getMessage( "MPGridopcionesContainerRow", "") ;
      ucA3llinktabla1.sendProperty(context, "", true, A3llinktabla1_Internalname, "linkRowId", A3llinktabla1_Linkrowid);
      A3llinktabla1_Urls = AV54urls.toJSonString(false) ;
      ucA3llinktabla1.sendProperty(context, "", true, A3llinktabla1_Internalname, "urls", A3llinktabla1_Urls);
      lblJs_Caption = httpContext.getMessage( "<script>  console.log(\"js!\");", "") ;
      httpContext.ajax_rsp_assign_prop("", true, lblJs_Internalname, "Caption", lblJs_Caption, true);
      lblJs_Caption = lblJs_Caption+httpContext.getMessage( "if (typeof setLinksMenuMPGridopcionesContainerRow === \"function\") {", "") ;
      httpContext.ajax_rsp_assign_prop("", true, lblJs_Internalname, "Caption", lblJs_Caption, true);
      lblJs_Caption = lblJs_Caption+httpContext.getMessage( "setLinksMenuMPGridopcionesContainerRow(", "")+AV54urls.toJSonString(false)+");" ;
      httpContext.ajax_rsp_assign_prop("", true, lblJs_Internalname, "Caption", lblJs_Caption, true);
      lblJs_Caption = lblJs_Caption+"}" ;
      httpContext.ajax_rsp_assign_prop("", true, lblJs_Internalname, "Caption", lblJs_Caption, true);
      lblJs_Caption = lblJs_Caption+httpContext.getMessage( "</script>", "") ;
      httpContext.ajax_rsp_assign_prop("", true, lblJs_Internalname, "Caption", lblJs_Caption, true);
      new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, httpContext.getMessage( "load", "")) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", true, "AV54urls", AV54urls);
   }

   public void e13OK2( )
   {
      /* Ddo_languagesicons_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_languagesicons_Activeeventkey, "EnglishOption") == 0 )
      {
         /* Execute user subroutine: 'DO ENGLISHOPTION' */
         S182 ();
         if (returnInSub) return;
      }
      else if ( GXutil.strcmp(Ddo_languagesicons_Activeeventkey, "SpanishOption") == 0 )
      {
         /* Execute user subroutine: 'DO SPANISHOPTION' */
         S192 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      cmbavEmpcod.setValue( GXutil.trim( GXutil.str( AV16EmpCod, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", true, cmbavEmpcod.getInternalname(), "Values", cmbavEmpcod.ToJavascriptSource(), true);
      cmbavConvecodigo.setValue( GXutil.rtrim( AV13ConveCodigo) );
      httpContext.ajax_rsp_assign_prop("", true, cmbavConvecodigo.getInternalname(), "Values", cmbavConvecodigo.ToJavascriptSource(), true);
   }

   public void e12OK2( )
   {
      /* Combo_buscarmenu_Onoptionclicked Routine */
      returnInSub = false ;
      AV76BuscarMenu = Combo_buscarmenu_Selectedvalue_get ;
      httpContext.ajax_rsp_assign_attri("", true, "AV76BuscarMenu", AV76BuscarMenu);
      GXv_char4[0] = AV33menuURL ;
      new web.getlinkmenu(remoteHandle, context).execute( AV9CliCod, AV16EmpCod, AV39PerfilId, AV31MenuItemId, AV76BuscarMenu, GXv_char4) ;
      newmasterpage_impl.this.AV33menuURL = GXv_char4[0] ;
      AV76BuscarMenu = "" ;
      httpContext.ajax_rsp_assign_attri("", true, "AV76BuscarMenu", AV76BuscarMenu);
      Combo_buscarmenu_Selectedtext_set = "" ;
      ucCombo_buscarmenu.sendProperty(context, "", true, Combo_buscarmenu_Internalname, "SelectedText_set", Combo_buscarmenu_Selectedtext_set);
      Combo_buscarmenu_Selectedvalue_set = "" ;
      ucCombo_buscarmenu.sendProperty(context, "", true, Combo_buscarmenu_Internalname, "SelectedValue_set", Combo_buscarmenu_Selectedvalue_set);
      callWebObject(formatLink(AV33menuURL, new String[] {}, new String[] {}) );
      httpContext.wjLocDisableFrm = (byte)(0) ;
      /*  Sending Event outputs  */
   }

   public void S162( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean20 = AV52TempBoolean ;
      GXv_boolean19[0] = GXt_boolean20 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWP_MasterPageTopActionsWC", GXv_boolean19) ;
      newmasterpage_impl.this.GXt_boolean20 = GXv_boolean19[0] ;
      AV52TempBoolean = GXt_boolean20 ;
      if ( AV52TempBoolean )
      {
         Ddc_adminag_Visible = true ;
         ucDdc_adminag.sendProperty(context, "", true, Ddc_adminag_Internalname, "Visible", GXutil.booltostr( Ddc_adminag_Visible));
      }
      else
      {
         Ddc_adminag_Visible = false ;
         ucDdc_adminag.sendProperty(context, "", true, Ddc_adminag_Internalname, "Visible", GXutil.booltostr( Ddc_adminag_Visible));
      }
   }

   public void S182( )
   {
      /* 'DO ENGLISHOPTION' Routine */
      returnInSub = false ;
      if ( setLanguage( "English") == 0 )
      {
         AV57WebSession.setValue("isLangLoaded", "true");
         httpContext.doAjaxRefresh();
      }
   }

   public void S192( )
   {
      /* 'DO SPANISHOPTION' Routine */
      returnInSub = false ;
      if ( setLanguage( "Spanish") == 0 )
      {
         AV57WebSession.setValue("isLangLoaded", "true");
         httpContext.doAjaxRefresh();
      }
   }

   public void S142( )
   {
      /* 'LOADCOMBOBUSCARMENU' Routine */
      returnInSub = false ;
      lV76BuscarMenu = GXutil.padr( GXutil.rtrim( AV76BuscarMenu), 40, "%") ;
      /* Using cursor H00OK3 */
      pr_default.execute(1, new Object[] {lV76BuscarMenu, Byte.valueOf(AV43RolId), Byte.valueOf(AV39PerfilId), Long.valueOf(AV34MenuVerId)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brkOK4 = false ;
         A1937MenuItemId = H00OK3_A1937MenuItemId[0] ;
         A2363MenuOpcInst = H00OK3_A2363MenuOpcInst[0] ;
         A1938MItemEsMenu = H00OK3_A1938MItemEsMenu[0] ;
         A1933MenuOpcPadre = H00OK3_A1933MenuOpcPadre[0] ;
         n1933MenuOpcPadre = H00OK3_n1933MenuOpcPadre[0] ;
         A1931MenuOpcTitulo = H00OK3_A1931MenuOpcTitulo[0] ;
         A1928MenuVerId = H00OK3_A1928MenuVerId[0] ;
         A1925PerfilId = H00OK3_A1925PerfilId[0] ;
         A1923RolId = H00OK3_A1923RolId[0] ;
         A1929MenuOpcCod = H00OK3_A1929MenuOpcCod[0] ;
         A1938MItemEsMenu = H00OK3_A1938MItemEsMenu[0] ;
         GXt_char16 = A2362MenuOpcHormiga ;
         GXv_char4[0] = "" ;
         GXv_char3[0] = "" ;
         GXv_char2[0] = "" ;
         GXv_char21[0] = GXt_char16 ;
         new web.gethtmlnewbreadcrumb(remoteHandle, context).execute( A1929MenuOpcCod, A1923RolId, A1925PerfilId, A1928MenuVerId, GXv_char4, GXv_char3, GXv_char2, GXv_char21) ;
         newmasterpage_impl.this.GXt_char16 = GXv_char21[0] ;
         A2362MenuOpcHormiga = GXt_char16 ;
         httpContext.ajax_rsp_assign_attri("", true, "A2362MenuOpcHormiga", A2362MenuOpcHormiga);
         AV82ComboCat_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV82ComboCat_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1933MenuOpcPadre );
         AV82ComboCat_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A2362MenuOpcHormiga );
         AV80BuscarMenu_Data.add(AV82ComboCat_DataItem, 0);
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(H00OK3_A1933MenuOpcPadre[0], A1933MenuOpcPadre) == 0 ) )
         {
            brkOK4 = false ;
            A1937MenuItemId = H00OK3_A1937MenuItemId[0] ;
            A2363MenuOpcInst = H00OK3_A2363MenuOpcInst[0] ;
            A1931MenuOpcTitulo = H00OK3_A1931MenuOpcTitulo[0] ;
            A1928MenuVerId = H00OK3_A1928MenuVerId[0] ;
            A1925PerfilId = H00OK3_A1925PerfilId[0] ;
            A1923RolId = H00OK3_A1923RolId[0] ;
            A1929MenuOpcCod = H00OK3_A1929MenuOpcCod[0] ;
            AV83Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV83Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1929MenuOpcCod );
            AV83Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1931MenuOpcTitulo );
            AV82ComboCat_DataItem.getgxTv_SdtDVB_SDTComboData_Item_Children().add(AV83Combo_DataItem, 0);
            brkOK4 = true ;
            pr_default.readNext(1);
         }
         if ( ! brkOK4 )
         {
            brkOK4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
      Combo_buscarmenu_Selectedvalue_set = AV76BuscarMenu ;
      ucCombo_buscarmenu.sendProperty(context, "", true, Combo_buscarmenu_Internalname, "SelectedValue_set", Combo_buscarmenu_Selectedvalue_set);
   }

   public void e14OK2( )
   {
      /* Volversvg_Click Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV90Pgmname, httpContext.getMessage( "&selMenuOpcCod ", "")+AV51selMenuOpcCod) ;
      AV53URL = "" ;
      if ( ! (GXutil.strcmp("", AV51selMenuOpcCod)==0) )
      {
         GXv_boolean19[0] = AV87MenuOpcForRet ;
         new web.getmenuopcforret(remoteHandle, context).execute( AV43RolId, AV39PerfilId, AV34MenuVerId, AV51selMenuOpcCod, GXv_boolean19) ;
         newmasterpage_impl.this.AV87MenuOpcForRet = GXv_boolean19[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV90Pgmname, httpContext.getMessage( "&MenuOpcForRet ", "")+GXutil.trim( GXutil.booltostr( AV87MenuOpcForRet))+httpContext.getMessage( " &hormigaURL ", "")+AV85hormigaURL) ;
         if ( ! AV87MenuOpcForRet && ! (GXutil.strcmp("", AV85hormigaURL)==0) )
         {
            AV53URL = GXutil.trim( AV85hormigaURL) ;
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV90Pgmname, httpContext.getMessage( "&URL ", "")+AV53URL) ;
      if ( (GXutil.strcmp("", AV53URL)==0) )
      {
         GXv_char21[0] = AV53URL ;
         new web.getnavulturl(remoteHandle, context).execute( AV9CliCod, GXv_char21) ;
         newmasterpage_impl.this.AV53URL = GXv_char21[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV90Pgmname, httpContext.getMessage( "consigue &URL ", "")+AV53URL) ;
      }
      if ( ! (GXutil.strcmp("", AV53URL)==0) )
      {
         callWebObject(formatLink(AV53URL, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
   }

   public void e23OK2( )
   {
      /* Gridopciones_Refresh Routine */
      returnInSub = false ;
      AV54urls.clear();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", true, "AV54urls", AV54urls);
   }

   public void e15OK2( )
   {
      /* Tablelogo_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'GO HOME' */
      S202 ();
      if (returnInSub) return;
   }

   public void e16OK2( )
   {
      /* Empcod_Controlvaluechanged Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, httpContext.getMessage( "changed ", "")+GXutil.trim( GXutil.str( AV16EmpCod, 4, 0))) ;
      if ( (0==AV16EmpCod) )
      {
         callWebObject(formatLink("web.empresaww", new String[] {GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"MenuOpcCod"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
         if ( AV16EmpCod == 9999 )
         {
            callWebObject(formatLink("web.empresa_cabecera", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "INS", ""))),GXutil.URLEncode(GXutil.ltrimstr(AV9CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(0,9,0)),GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "EmpresaINS", "")))}, new String[] {"TrnMode","CliCod","EmpCod","MenuOpcCod"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, httpContext.getMessage( "changed set", "")) ;
            new web.setempresa(remoteHandle, context).execute( AV16EmpCod) ;
            httpContext.doAjaxRefresh();
         }
      }
      /*  Sending Event outputs  */
      cmbavEmpcod.setValue( GXutil.trim( GXutil.str( AV16EmpCod, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", true, cmbavEmpcod.getInternalname(), "Values", cmbavEmpcod.ToJavascriptSource(), true);
      cmbavConvecodigo.setValue( GXutil.rtrim( AV13ConveCodigo) );
      httpContext.ajax_rsp_assign_prop("", true, cmbavConvecodigo.getInternalname(), "Values", cmbavConvecodigo.ToJavascriptSource(), true);
   }

   public void e19OK2( )
   {
      /* Onmessage_gx1 Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV90Pgmname, httpContext.getMessage( "!&NotificationInfo id ", "")+GXutil.trim( AV36NotificationInfo.getgxTv_SdtNotificationInfo_Id())+httpContext.getMessage( " message ", "")+AV36NotificationInfo.getgxTv_SdtNotificationInfo_Message()) ;
      if ( ( GXutil.strSearch( GXutil.upper( AV36NotificationInfo.getgxTv_SdtNotificationInfo_Id()), httpContext.getMessage( "GUARDALIQUIDACION", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( AV36NotificationInfo.getgxTv_SdtNotificationInfo_Id()), httpContext.getMessage( "PROCLIQUIDACION", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( AV36NotificationInfo.getgxTv_SdtNotificationInfo_Id()), httpContext.getMessage( "OTROS", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( AV36NotificationInfo.getgxTv_SdtNotificationInfo_Id()), httpContext.getMessage( "DEPENDENCIAS_LSD", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( AV36NotificationInfo.getgxTv_SdtNotificationInfo_Id()), httpContext.getMessage( "CONTRIBUCIONES", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( AV36NotificationInfo.getgxTv_SdtNotificationInfo_Id()), httpContext.getMessage( "GENERACION_PDFS", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( AV36NotificationInfo.getgxTv_SdtNotificationInfo_Id()), httpContext.getMessage( "DEP_y_REC", ""), 1) != 0 ) )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV90Pgmname, httpContext.getMessage( "(llama) MensajeLiquidacion...................", "")) ;
         this.executeExternalObjectMethod("", true, "GlobalEvents", "MensajeLiquidacion", new Object[] {AV36NotificationInfo.getgxTv_SdtNotificationInfo_Id()}, true);
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, httpContext.getMessage( "excel 1", "")) ;
         if ( GXutil.strSearch( GXutil.upper( AV36NotificationInfo.getgxTv_SdtNotificationInfo_Id()), httpContext.getMessage( "IMPORTARLEGAJO_EXCEL", ""), 1) != 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, httpContext.getMessage( "excel 2 ", "")) ;
            this.executeExternalObjectMethod("", true, "GlobalEvents", "importarLegajosExcel", new Object[] {AV36NotificationInfo.getgxTv_SdtNotificationInfo_Id()}, true);
         }
      }
   }

   public void e17OK2( )
   {
      /* Convecodigo_Controlvaluechanged Routine */
      returnInSub = false ;
      new web.setconvenio(remoteHandle, context).execute( AV13ConveCodigo) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      cmbavEmpcod.setValue( GXutil.trim( GXutil.str( AV16EmpCod, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", true, cmbavEmpcod.getInternalname(), "Values", cmbavEmpcod.ToJavascriptSource(), true);
      cmbavConvecodigo.setValue( GXutil.rtrim( AV13ConveCodigo) );
      httpContext.ajax_rsp_assign_prop("", true, cmbavConvecodigo.getInternalname(), "Values", cmbavConvecodigo.ToJavascriptSource(), true);
   }

   public void e18OK2( )
   {
      /* Ayuda_Click Routine */
      returnInSub = false ;
      GXv_boolean19[0] = true ;
      new web.opcionsetnomostrar(remoteHandle, context).execute( AV51selMenuOpcCod, GXv_boolean19) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      cmbavEmpcod.setValue( GXutil.trim( GXutil.str( AV16EmpCod, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", true, cmbavEmpcod.getInternalname(), "Values", cmbavEmpcod.ToJavascriptSource(), true);
      cmbavConvecodigo.setValue( GXutil.rtrim( AV13ConveCodigo) );
      httpContext.ajax_rsp_assign_prop("", true, cmbavConvecodigo.getInternalname(), "Values", cmbavConvecodigo.ToJavascriptSource(), true);
   }

   public void S112( )
   {
      /* 'REFRESCAR EMPRESAS' Routine */
      returnInSub = false ;
      cmbavEmpcod.removeAllItems();
      AV5hay = false ;
      /* Using cursor H00OK4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV9CliCod)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A3CliCod = H00OK4_A3CliCod[0] ;
         A2EmpNom = H00OK4_A2EmpNom[0] ;
         A1EmpCod = H00OK4_A1EmpCod[0] ;
         cmbavEmpcod.addItem(GXutil.trim( GXutil.str( A1EmpCod, 4, 0)), GXutil.trim( A2EmpNom), (short)(0));
         AV5hay = true ;
         pr_default.readNext(2);
      }
      pr_default.close(2);
      cmbavEmpcod.setVisible( (AV5hay ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", true, cmbavEmpcod.getInternalname(), "Visible", GXutil.ltrimstr( cmbavEmpcod.getVisible(), 5, 0), true);
      cmbavEmpcod.addItem("9999", httpContext.getMessage( "CREAR EMPRESA...", ""), (short)(0));
   }

   public void S122( )
   {
      /* 'REFRESCAR CONVENIOS' Routine */
      returnInSub = false ;
      cmbavConvecodigo.removeAllItems();
      GXv_boolean19[0] = AV10ClienteConveniador ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV9CliCod, GXv_boolean19) ;
      newmasterpage_impl.this.AV10ClienteConveniador = GXv_boolean19[0] ;
      if ( ! AV10ClienteConveniador )
      {
         cmbavConvecodigo.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", true, cmbavConvecodigo.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConvecodigo.getVisible(), 5, 0), true);
      }
      else
      {
         lblTextempresaconveniotitulo_Caption = httpContext.getMessage( "Convenio", "") ;
         httpContext.ajax_rsp_assign_prop("", true, lblTextempresaconveniotitulo_Internalname, "Caption", lblTextempresaconveniotitulo_Caption, true);
         AV5hay = false ;
         GXt_int9 = AV37PaiCod ;
         GXv_int10[0] = GXt_int9 ;
         new web.clientegetpais(remoteHandle, context).execute( AV9CliCod, GXv_int10) ;
         newmasterpage_impl.this.GXt_int9 = GXv_int10[0] ;
         AV37PaiCod = GXt_int9 ;
         httpContext.ajax_rsp_assign_attri("", true, "AV37PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37PaiCod), 4, 0));
         /* Using cursor H00OK5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV37PaiCod)});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A2429CliConveEsquemaEs = H00OK5_A2429CliConveEsquemaEs[0] ;
            A3CliCod = H00OK5_A3CliCod[0] ;
            A1564CliPaiConve = H00OK5_A1564CliPaiConve[0] ;
            A1567CliConvenioDescrip = H00OK5_A1567CliConvenioDescrip[0] ;
            A1565CliConvenio = H00OK5_A1565CliConvenio[0] ;
            A1567CliConvenioDescrip = H00OK5_A1567CliConvenioDescrip[0] ;
            cmbavConvecodigo.addItem(A1565CliConvenio, GXutil.trim( A1567CliConvenioDescrip), (short)(0));
            AV5hay = true ;
            pr_default.readNext(3);
         }
         pr_default.close(3);
         cmbavConvecodigo.setVisible( (AV5hay ? 1 : 0) );
         httpContext.ajax_rsp_assign_prop("", true, cmbavConvecodigo.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConvecodigo.getVisible(), 5, 0), true);
      }
   }

   public void S152( )
   {
      /* 'VISIBILIDAD COMBOS' Routine */
      returnInSub = false ;
      AV12contentHolder_Pgmname = Contentholder.getPgmname() ;
      httpContext.ajax_rsp_assign_attri("", true, "AV12contentHolder_Pgmname", AV12contentHolder_Pgmname);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONTENTHOLDER_PGMNAME_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV12contentHolder_Pgmname, ""))));
      GXv_boolean19[0] = AV11combosVisiblEs ;
      new web.tablecombosmastervisible(remoteHandle, context).execute( AV12contentHolder_Pgmname, GXv_boolean19) ;
      newmasterpage_impl.this.AV11combosVisiblEs = GXv_boolean19[0] ;
      divTablesvgtextempresa_Visible = (AV11combosVisiblEs ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", true, divTablesvgtextempresa_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablesvgtextempresa_Visible), 5, 0), true);
   }

   public void S202( )
   {
      /* 'GO HOME' Routine */
      returnInSub = false ;
      GXv_char21[0] = AV20homeURL ;
      GXv_char4[0] = "" ;
      new web.gethome(remoteHandle, context).execute( GXv_char21, GXv_char4) ;
      newmasterpage_impl.this.AV20homeURL = GXv_char21[0] ;
      callWebObject(formatLink(AV20homeURL, new String[] {}, new String[] {}) );
      httpContext.wjLocDisableFrm = (byte)(0) ;
   }

   public void S172( )
   {
      /* 'REFLEJAR OPCION' Routine */
      returnInSub = false ;
      AV17headTitle = "" ;
      if ( ( GXutil.strcmp(GXutil.trim( GXutil.lower( AV12contentHolder_Pgmname)), httpContext.getMessage( "home_temp", "")) == 0 ) || ( GXutil.strcmp(GXutil.trim( GXutil.lower( AV12contentHolder_Pgmname)), httpContext.getMessage( "busqueda", "")) == 0 ) )
      {
         lblAyuda_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", true, lblAyuda_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblAyuda_Visible), 5, 0), true);
         lblHtmlhormiga_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", true, lblHtmlhormiga_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblHtmlhormiga_Visible), 5, 0), true);
         if ( GXutil.strcmp(GXutil.trim( GXutil.lower( AV12contentHolder_Pgmname)), httpContext.getMessage( "home_temp", "")) == 0 )
         {
            lblPgmdesc_Caption = httpContext.getMessage( "Home", "") ;
            httpContext.ajax_rsp_assign_prop("", true, lblPgmdesc_Internalname, "Caption", lblPgmdesc_Caption, true);
         }
         else
         {
            lblPgmdesc_Caption = httpContext.getMessage( "Búsqueda", "") ;
            httpContext.ajax_rsp_assign_prop("", true, lblPgmdesc_Internalname, "Caption", lblPgmdesc_Caption, true);
         }
         lblVolversvg_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", true, lblVolversvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblVolversvg_Visible), 5, 0), true);
      }
      else
      {
         lblVolversvg_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", true, lblVolversvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblVolversvg_Visible), 5, 0), true);
         GXv_boolean19[0] = AV30MenuBienveVisible ;
         new web.getmenuopcayudavisible(remoteHandle, context).execute( AV43RolId, AV39PerfilId, AV34MenuVerId, AV51selMenuOpcCod, GXv_boolean19) ;
         newmasterpage_impl.this.AV30MenuBienveVisible = GXv_boolean19[0] ;
         if ( ! AV30MenuBienveVisible )
         {
            lblAyuda_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", true, lblAyuda_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblAyuda_Visible), 5, 0), true);
            GXt_char16 = "" ;
            GXt_char1 = "" ;
            GXv_char21[0] = GXt_char1 ;
            new web.svgid_ayuda(remoteHandle, context).execute( GXv_char21) ;
            newmasterpage_impl.this.GXt_char1 = GXv_char21[0] ;
            GXv_char4[0] = GXt_char16 ;
            new web.getsvg(remoteHandle, context).execute( GXt_char1, GXv_char4) ;
            newmasterpage_impl.this.GXt_char16 = GXv_char4[0] ;
            lblAyuda_Caption = GXt_char16 ;
            httpContext.ajax_rsp_assign_prop("", true, lblAyuda_Internalname, "Caption", lblAyuda_Caption, true);
         }
         else
         {
            lblAyuda_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", true, lblAyuda_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblAyuda_Visible), 5, 0), true);
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, httpContext.getMessage( "refresh get &selMenuOpcCod ", "")+GXutil.trim( AV51selMenuOpcCod)) ;
         AV35modoTxt = AV57WebSession.getValue(httpContext.getMessage( "&sel_Menu_Modo", "")) ;
         GXv_char21[0] = AV21html ;
         GXv_char4[0] = AV41primero_MenuOpcCod ;
         GXv_char3[0] = AV17headTitle ;
         GXv_char2[0] = "" ;
         new web.gethtmlnewbreadcrumb(remoteHandle, context).execute( AV51selMenuOpcCod, (byte)(0), (byte)(0), 0, GXv_char21, GXv_char4, GXv_char3, GXv_char2) ;
         newmasterpage_impl.this.AV21html = GXv_char21[0] ;
         newmasterpage_impl.this.AV41primero_MenuOpcCod = GXv_char4[0] ;
         newmasterpage_impl.this.AV17headTitle = GXv_char3[0] ;
         httpContext.ajax_rsp_assign_attri("", true, "AV41primero_MenuOpcCod", AV41primero_MenuOpcCod);
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPRIMERO_MENUOPCCOD_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV41primero_MenuOpcCod, ""))));
         lblHtmlhormiga_Caption = GXutil.trim( AV21html) ;
         httpContext.ajax_rsp_assign_prop("", true, lblHtmlhormiga_Internalname, "Caption", lblHtmlhormiga_Caption, true);
         lblPgmdesc_Caption = GXutil.trim( AV17headTitle) ;
         httpContext.ajax_rsp_assign_prop("", true, lblPgmdesc_Internalname, "Caption", lblPgmdesc_Caption, true);
         new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, httpContext.getMessage( "&modoTxt ", "")+AV35modoTxt) ;
         if ( (GXutil.strcmp("", AV35modoTxt)==0) )
         {
            GXv_char21[0] = AV53URL ;
            new web.getlinkpadre(remoteHandle, context).execute( AV9CliCod, AV16EmpCod, AV51selMenuOpcCod, GXv_char21) ;
            newmasterpage_impl.this.AV53URL = GXv_char21[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV90Pgmname, httpContext.getMessage( "busca padre", "")) ;
         }
         else
         {
            GXv_char21[0] = AV53URL ;
            new web.getlinkmenu(remoteHandle, context).execute( AV9CliCod, AV16EmpCod, (byte)(0), "", AV51selMenuOpcCod, GXv_char21) ;
            newmasterpage_impl.this.AV53URL = GXv_char21[0] ;
         }
         AV85hormigaURL = AV53URL ;
         httpContext.ajax_rsp_assign_attri("", true, "AV85hormigaURL", AV85hormigaURL);
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vHORMIGAURL_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV85hormigaURL, ""))));
         (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setHeaderrawhtml( "<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\""+httpContext.convertURL( context.getHttpContext().getImagePath( "b63e3a6c-8c52-46ff-a6d3-3972c374f15b", "", context.getHttpContext().getTheme( )))+"\">" );
      }
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setCaption( httpContext.getMessage( "Payday.ar ", "") );
      httpContext.ajax_rsp_assign_prop("", true, "FORM", "Caption", (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getCaption(), true);
      if ( ! (GXutil.strcmp("", AV17headTitle)==0) )
      {
         (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setCaption( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getCaption()+" | "+GXutil.trim( AV17headTitle) );
         httpContext.ajax_rsp_assign_prop("", true, "FORM", "Caption", (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getCaption(), true);
      }
   }

   public void S132( )
   {
      /* 'MONACO EDITOR' Routine */
      returnInSub = false ;
   }

   public void wb_table4_143_OK2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablausercontrols_Internalname, tblTablausercontrols_Internalname, "", "TablaUserControls", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucUcmessage.setProperty("Width", Ucmessage_Width);
         ucUcmessage.setProperty("MinHeight", Ucmessage_Minheight);
         ucUcmessage.setProperty("StylingType", Ucmessage_Stylingtype);
         ucUcmessage.setProperty("DefaultMessageType", Ucmessage_Defaultmessagetype);
         ucUcmessage.setProperty("StopOnError", Ucmessage_Stoponerror);
         ucUcmessage.setProperty("TitleEscape", Ucmessage_Titleescape);
         ucUcmessage.setProperty("TextEscape", Ucmessage_Textescape);
         ucUcmessage.setProperty("ChangeNewLinesToBRs", Ucmessage_Changenewlinestobrs);
         ucUcmessage.setProperty("Hide", Ucmessage_Hide);
         ucUcmessage.setProperty("DelayUntilHide", Ucmessage_Delayuntilhide);
         ucUcmessage.setProperty("MouseHideReset", Ucmessage_Mousehidereset);
         ucUcmessage.setProperty("EffectIn", Ucmessage_Effectin);
         ucUcmessage.setProperty("EffectOut", Ucmessage_Effectout);
         ucUcmessage.setProperty("AnimationSpeed", Ucmessage_Animationspeed);
         ucUcmessage.setProperty("StartPosition", Ucmessage_Startposition);
         ucUcmessage.setProperty("NextMessagePosition", Ucmessage_Nextmessageposition);
         ucUcmessage.setProperty("Closer", Ucmessage_Closer);
         ucUcmessage.setProperty("Sticker", Ucmessage_Sticker);
         ucUcmessage.setProperty("StickerHover", Ucmessage_Stickerhover);
         ucUcmessage.setProperty("LabelCloseButton", Ucmessage_Labelclosebutton);
         ucUcmessage.setProperty("LabelStickButton", Ucmessage_Labelstickbutton);
         ucUcmessage.setProperty("showEvenOnNonblock", Ucmessage_Showevenonnonblock);
         ucUcmessage.setProperty("Menu", Ucmessage_Menu);
         ucUcmessage.setProperty("MaxOnScreen", Ucmessage_Maxonscreen);
         ucUcmessage.setProperty("LabelRedisplay", Ucmessage_Labelredisplay);
         ucUcmessage.setProperty("LabelAll", Ucmessage_Labelall);
         ucUcmessage.setProperty("LabelLast", Ucmessage_Labellast);
         ucUcmessage.render(context, "dvelop.dvmessage", Ucmessage_Internalname, "UCMESSAGE_MPAGEContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucUctooltip.render(context, "dvelop.gxbootstrap.tooltip", Uctooltip_Internalname, "UCTOOLTIP_MPAGEContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucWwputilities.setProperty("EnableFixObjectFitCover", Wwputilities_Enablefixobjectfitcover);
         ucWwputilities.setProperty("EmpowerTabs", Wwputilities_Empowertabs);
         ucWwputilities.setProperty("EnableUpdateRowSelectionStatus", Wwputilities_Enableupdaterowselectionstatus);
         ucWwputilities.setProperty("EnableConvertComboToBootstrapSelect", Wwputilities_Enableconvertcombotobootstrapselect);
         ucWwputilities.setProperty("AllowColumnResizing", Wwputilities_Allowcolumnresizing);
         ucWwputilities.setProperty("AllowColumnReordering", Wwputilities_Allowcolumnreordering);
         ucWwputilities.setProperty("AllowColumnDragging", Wwputilities_Allowcolumndragging);
         ucWwputilities.setProperty("AllowColumnsRestore", Wwputilities_Allowcolumnsrestore);
         ucWwputilities.setProperty("PagBarIncludeGoTo", Wwputilities_Pagbarincludegoto);
         ucWwputilities.render(context, "wwp.workwithplusutilities_fal", Wwputilities_Internalname, "WWPUTILITIES_MPAGEContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucWwpdatepicker.render(context, "wwp.datepicker", Wwpdatepicker_Internalname, "WWPDATEPICKER_MPAGEContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucA3llinktabla1.render(context, "a3llinktabla", A3llinktabla1_Internalname, "A3LLINKTABLA1_MPAGEContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblJs_Internalname, lblJs_Caption, "", "", lblJs_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_WWPBaseObjects\\NewMasterPage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='displayNone'>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblock1_Internalname, httpContext.getMessage( "hola", ""), "", "", lblTextblock1_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "displayNone", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\NewMasterPage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_143_OK2e( true) ;
      }
      else
      {
         wb_table4_143_OK2e( false) ;
      }
   }

   public void wb_table3_133_OK2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblTableidioma_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         web.GxWebStd.gx_table_start( httpContext, tblTableidioma_Internalname, tblTableidioma_Internalname, "", "ml25", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Center;text-align:-moz-Center;text-align:-webkit-Center")+"\">") ;
         /* User Defined Control */
         ucDdo_languagesicons.setProperty("Caption", Ddo_languagesicons_Caption);
         ucDdo_languagesicons.setProperty("Cls", Ddo_languagesicons_Cls);
         ucDdo_languagesicons.setProperty("DropDownOptionsData", AV28LanguagesIconsData);
         ucDdo_languagesicons.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_languagesicons_Internalname, "DDO_LANGUAGESICONS_MPAGEContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_133_OK2e( true) ;
      }
      else
      {
         wb_table3_133_OK2e( false) ;
      }
   }

   public void wb_table2_69_OK2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablebuscarmenuicon_Internalname, tblTablebuscarmenuicon_Internalname, "", "TableBuscarMenuIcon", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblBuscarmenuicon_Internalname, httpContext.getMessage( "<svg width=\"16\" height=\"16\" viewBox=\"0 0 17 17\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M8.125 15.25C12.06 15.25 15.25 12.06 15.25 8.125C15.25 4.18997 12.06 1 8.125 1C4.18997 1 1 4.18997 1 8.125C1 12.06 4.18997 15.25 8.125 15.25Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.125\"/><path d=\"M13.375 13.375L16 16\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.125\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblBuscarmenuicon_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_WWPBaseObjects\\NewMasterPage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_69_OK2e( true) ;
      }
      else
      {
         wb_table2_69_OK2e( false) ;
      }
   }

   public void wb_table1_23_OK2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablelogoname_Internalname, tblTablelogoname_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTable_ar_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockar_Internalname, httpContext.getMessage( "Payday.ar", ""), "", "", lblTextblockar_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "logo_textColor_dark_New ML5", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\NewMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_23_OK2e( true) ;
      }
      else
      {
         wb_table1_23_OK2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
   }

   public String getresponse( String sGXDynURL )
   {
      initialize_properties( ) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      sDynURL = sGXDynURL ;
      nGotPars = 1 ;
      nGXWrapped = 1 ;
      httpContext.setWrapped(true);
      paOK2( ) ;
      wsOK2( ) ;
      weOK2( ) ;
      httpContext.setWrapped(false);
      httpContext.GX_msglist = BackMsgLst ;
      String response = "";
      try
      {
         response = ((java.io.ByteArrayOutputStream) httpContext.getOutputStream()).toString("UTF8");
      }
      catch (java.io.UnsupportedEncodingException e)
      {
         Application.printWarning(e.getMessage(), e);
      }
      finally
      {
         httpContext.closeOutputStream();
      }
      return response;
   }

   public void responsestatic( String sGXDynURL )
   {
   }

   public void master_styles( )
   {
      define_styles( ) ;
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("DVelop/DVMessage/DVMessage.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/fontawesome_vlatest/css/all.min.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/Shared/daterangepicker/daterangepicker.css", "");
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      if ( ! ( WebComp_Ddc_adminag_wc == null ) )
      {
         if ( GXutil.len( WebComp_Ddc_adminag_wc_Component) != 0 )
         {
            WebComp_Ddc_adminag_wc.componentthemes();
         }
      }
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().item(idxLst)), "?2025187222412", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      httpContext.AddJavascriptSource("wwpbaseobjects/newmasterpage.js", "?2025187222413", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Tooltip/BootstrapTooltipRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Mask/jquery.mask.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/WorkWithPlusUtilities/BootstrapSelect.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/WorkWithPlusUtilities/WorkWithPlusUtilitiesRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DatePicker/DatePickerRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/A3LLinkTablaRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_762( )
   {
      lblSvg_opcion_Internalname = "SVG_OPCION_MPAGE_"+sGXsfl_76_idx ;
      lblTextblockopcion_Internalname = "TEXTBLOCKOPCION_MPAGE_"+sGXsfl_76_idx ;
      lblSvg_accion_Internalname = "SVG_ACCION_MPAGE_"+sGXsfl_76_idx ;
      lblUpdatebadge_Internalname = "UPDATEBADGE_MPAGE_"+sGXsfl_76_idx ;
      subGridopciones_Internalname = "GRIDOPCIONES_MPAGE" ;
   }

   public void subsflControlProps_fel_762( )
   {
      lblSvg_opcion_Internalname = "SVG_OPCION_MPAGE_"+sGXsfl_76_fel_idx ;
      lblTextblockopcion_Internalname = "TEXTBLOCKOPCION_MPAGE_"+sGXsfl_76_fel_idx ;
      lblSvg_accion_Internalname = "SVG_ACCION_MPAGE_"+sGXsfl_76_fel_idx ;
      lblUpdatebadge_Internalname = "UPDATEBADGE_MPAGE_"+sGXsfl_76_fel_idx ;
      subGridopciones_Internalname = "GRIDOPCIONES_MPAGE" ;
   }

   public void sendrow_762( )
   {
      subsflControlProps_762( ) ;
      wbOK0( ) ;
      GridopcionesRow = GXWebRow.GetNew(context,MPGridopcionesContainer) ;
      if ( subGridopciones_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridopciones_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridopciones_Class, "") != 0 )
         {
            subGridopciones_Linesclass = subGridopciones_Class+"Odd" ;
         }
      }
      else if ( subGridopciones_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridopciones_Backstyle = (byte)(0) ;
         subGridopciones_Backcolor = subGridopciones_Allbackcolor ;
         if ( GXutil.strcmp(subGridopciones_Class, "") != 0 )
         {
            subGridopciones_Linesclass = subGridopciones_Class+"Uniform" ;
         }
      }
      else if ( subGridopciones_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridopciones_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridopciones_Class, "") != 0 )
         {
            subGridopciones_Linesclass = subGridopciones_Class+"Odd" ;
         }
         subGridopciones_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGridopciones_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridopciones_Backstyle = (byte)(1) ;
         subGridopciones_Backcolor = (int)(0xFFFFFF) ;
         if ( GXutil.strcmp(subGridopciones_Class, "") != 0 )
         {
            subGridopciones_Linesclass = subGridopciones_Class+"Odd" ;
         }
      }
      /* Start of Columns property logic. */
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableopcionmenuizq_new_Internalname+"_"+sGXsfl_76_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",divTableopcionmenuizq_new_Class,"left","top"," "+"data-gx-flex"+" ","justify-content:center;align-items:center;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","align-self:center;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableiconoopcion_Internalname+"_"+sGXsfl_76_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Flex","left","top"," "+"data-gx-flex"+" ","justify-content:center;align-items:center;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;align-self:center;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Table start */
      GridopcionesRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblTableiconsvg_Internalname+"_"+sGXsfl_76_idx,Integer.valueOf(1),"MT5","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Text block */
      GridopcionesRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblSvg_opcion_Internalname,lblSvg_opcion_Caption,"","",lblSvg_opcion_Jsonclick,"'"+""+"'"+",true,"+"'"+"E_MPAGE."+sGXsfl_76_idx+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(lblSvg_opcion_Visible),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(1)});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      if ( MPGridopcionesContainer.GetWrapped() == 1 )
      {
         MPGridopcionesContainer.CloseTag("cell");
      }
      if ( MPGridopcionesContainer.GetWrapped() == 1 )
      {
         MPGridopcionesContainer.CloseTag("row");
      }
      if ( MPGridopcionesContainer.GetWrapped() == 1 )
      {
         MPGridopcionesContainer.CloseTag("table");
      }
      /* End of table */
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTabletextopcion_Internalname+"_"+sGXsfl_76_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","ml6","left","top"," "+"data-gx-flex"+" ","","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Text block */
      GridopcionesRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTextblockopcion_Internalname,lblTextblockopcion_Caption,"","",lblTextblockopcion_Jsonclick,"'"+""+"'"+",true,"+"'"+"E_MPAGE."+sGXsfl_76_idx+"'","",lblTextblockopcion_Class,Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","align-self:center;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtable1_Internalname+"_"+sGXsfl_76_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","mt6","left","top"," "+"data-gx-flex"+" ","justify-content:center;align-items:center;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","align-self:center;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Text block */
      GridopcionesRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblSvg_accion_Internalname,httpContext.getMessage( "<svg width=\"21\" height=\"21\" viewBox=\"0 0 21 21\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><rect x=\"1\" y=\"1\" width=\"19\" height=\"19\" rx=\"9.5\" stroke=\"#D0CFD4\"/><path d=\"M7 10.5L14 10.5\" stroke=\"#A1A1AA\" stroke-width=\"1.5\"/><path d=\"M10.5 7V14\" stroke=\"#A1A1AA\" stroke-width=\"1.5\"/></svg>", ""),"","",lblSvg_accion_Jsonclick,"'"+""+"'"+",true,"+"'"+"E_MPAGE."+sGXsfl_76_idx+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(lblSvg_accion_Visible),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(1)});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","align-self:center;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableupdatebadge_Internalname+"_"+sGXsfl_76_idx,Integer.valueOf(divTableupdatebadge_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px","TableUpdateBadge","left","top"," "+"data-gx-flex"+" ","flex-direction:column;justify-content:center;align-items:center;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","align-self:center;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Text block */
      GridopcionesRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblUpdatebadge_Internalname,lblUpdatebadge_Caption,"","",lblUpdatebadge_Jsonclick,"'"+""+"'"+",true,"+"'"+"E_MPAGE."+sGXsfl_76_idx+"'","","UpdateBadge",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      send_integrity_lvl_hashesOK2( ) ;
      GXCCtl = "vPGMNAME_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV90Pgmname));
      GXCCtl = "vCLICOD_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV9CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "CLICOD_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "EMPCOD_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "EMPNOM_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, A2EmpNom);
      GXCCtl = "CLIPAICONVE_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "CLICONVEESQUEMAES_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_boolean_hidden_field( httpContext, GXCCtl, A2429CliConveEsquemaEs);
      GXCCtl = "CLICONVENIO_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( A1565CliConvenio));
      GXCCtl = "CLICONVENIODESCRIP_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, A1567CliConvenioDescrip);
      GXCCtl = "vCONTENTHOLDER_PGMNAME_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV12contentHolder_Pgmname));
      GXCCtl = "vROLID_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV43RolId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vPERFILID_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV39PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMENUVERID_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV34MenuVerId, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vSELMENUOPCCOD_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, AV51selMenuOpcCod);
      GXCCtl = "ROLID_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A1923RolId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "PERFILID_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A1925PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "MENUVERID_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A1928MenuVerId, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "MENUITEMORD_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A1940MenuItemOrd, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "MENUOPCPADRE_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( A1933MenuOpcPadre));
      GXCCtl = "SVGID_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( A1935SVGId));
      GXCCtl = "SVGVALOR_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, A1936SVGValor);
      GXCCtl = "MENUOPCCOD_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, A1929MenuOpcCod);
      GXCCtl = "vPRIMERO_MENUOPCCOD_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, AV41primero_MenuOpcCod);
      GXCCtl = "MENUOPCTITULO_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, A1931MenuOpcTitulo);
      GXCCtl = "MENUITEMID_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, A1937MenuItemId);
      GXCCtl = "vURLS_MPAGE_" + sGXsfl_76_idx ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", true, GXCCtl, AV54urls);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(GXCCtl, AV54urls);
      }
      GXCCtl = "vMENUITEMID_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, AV31MenuItemId);
      GXCCtl = "vHORMIGAURL_MPAGE_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, AV85hormigaURL);
      GXCCtl = "vNOTIFICATIONINFO_MPAGE_" + sGXsfl_76_idx ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", true, GXCCtl, AV36NotificationInfo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(GXCCtl, AV36NotificationInfo);
      }
      GXCCtl = "vHTTPREQUEST_MPAGE_Baseurl_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV22Httprequest.getBaseURL()));
      GXCCtl = "DDO_LANGUAGESICONS_MPAGE_Activeeventkey_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Ddo_languagesicons_Activeeventkey));
      GXCCtl = "COMBO_BUSCARMENU_MPAGE_Selectedvalue_get_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Combo_buscarmenu_Selectedvalue_get));
      GXCCtl = "vNOTIFICATIONINFO_MPAGE_Id_" + sGXsfl_76_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV36NotificationInfo.getgxTv_SdtNotificationInfo_Id()));
      /* End of Columns property logic. */
      MPGridopcionesContainer.AddRow(GridopcionesRow);
      nGXsfl_76_idx = ((subGridopciones_Islastpage==1)&&(nGXsfl_76_idx+1>subgridopciones_fnc_recordsperpage( )) ? 1 : nGXsfl_76_idx+1) ;
      sGXsfl_76_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_76_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_762( ) ;
      /* End function sendrow_762 */
   }

   public void startgridcontrol76( )
   {
      if ( MPGridopcionesContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"MPGridopcionesContainer"+"DivS\" data-gxgridid=\"76\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGridopciones_Internalname, subGridopciones_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         MPGridopcionesContainer.AddObjectProperty("GridName", "Gridopciones");
      }
      else
      {
         MPGridopcionesContainer.AddObjectProperty("GridName", "Gridopciones");
         MPGridopcionesContainer.AddObjectProperty("Header", subGridopciones_Header);
         MPGridopcionesContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
         MPGridopcionesContainer.AddObjectProperty("Class", "FreeStyleGrid");
         MPGridopcionesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         MPGridopcionesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         MPGridopcionesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridopciones_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         MPGridopcionesContainer.AddObjectProperty("CmpContext", "");
         MPGridopcionesContainer.AddObjectProperty("InMasterPage", "true");
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesColumn.AddObjectProperty("Value", lblSvg_opcion_Caption);
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesColumn.AddObjectProperty("Value", lblTextblockopcion_Caption);
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesColumn.AddObjectProperty("Value", lblSvg_accion_Caption);
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesColumn.AddObjectProperty("Value", lblUpdatebadge_Caption);
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         MPGridopcionesContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridopciones_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         MPGridopcionesContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridopciones_Allowselection, (byte)(1), (byte)(0), ".", "")));
         MPGridopcionesContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridopciones_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         MPGridopcionesContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridopciones_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         MPGridopcionesContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridopciones_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         MPGridopcionesContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridopciones_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         MPGridopcionesContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridopciones_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      lblTextblock_pay_Internalname = "TEXTBLOCK_PAY_MPAGE" ;
      divTablepay_Internalname = "TABLEPAY_MPAGE" ;
      divTableisologo_Internalname = "TABLEISOLOGO_MPAGE" ;
      lblTextblockar_Internalname = "TEXTBLOCKAR_MPAGE" ;
      divTable_ar_Internalname = "TABLE_AR_MPAGE" ;
      tblTablelogoname_Internalname = "TABLELOGONAME_MPAGE" ;
      divTablelogo_Internalname = "TABLELOGO_MPAGE" ;
      Ddc_adminag_Internalname = "DDC_ADMINAG_MPAGE" ;
      divTableusuario_Internalname = "TABLEUSUARIO_MPAGE" ;
      lblTextblock2_Internalname = "TEXTBLOCK2_MPAGE" ;
      divTablealerta_Internalname = "TABLEALERTA_MPAGE" ;
      divTableuser_Internalname = "TABLEUSER_MPAGE" ;
      divHeadercontentoptions_Internalname = "HEADERCONTENTOPTIONS_MPAGE" ;
      divTableuserrole_Internalname = "TABLEUSERROLE_MPAGE" ;
      divTableheadercontent_Internalname = "TABLEHEADERCONTENT_MPAGE" ;
      lblSvgempresa_Internalname = "SVGEMPRESA_MPAGE" ;
      divTablesvgiconempresa_Internalname = "TABLESVGICONEMPRESA_MPAGE" ;
      lblTextempresaconveniotitulo_Internalname = "TEXTEMPRESACONVENIOTITULO_MPAGE" ;
      lblDoblecaret_Internalname = "DOBLECARET_MPAGE" ;
      divTabledoblecaret_Internalname = "TABLEDOBLECARET_MPAGE" ;
      divTabletituloempresaconvenio_Internalname = "TABLETITULOEMPRESACONVENIO_MPAGE" ;
      cmbavEmpcod.setInternalname( "vEMPCOD_MPAGE" );
      cmbavConvecodigo.setInternalname( "vCONVECODIGO_MPAGE" );
      divTablevariables_Internalname = "TABLEVARIABLES_MPAGE" ;
      divTabletitulos_Internalname = "TABLETITULOS_MPAGE" ;
      divTablesvgtextempresa_Internalname = "TABLESVGTEXTEMPRESA_MPAGE" ;
      divTableempresaconvenio_Internalname = "TABLEEMPRESACONVENIO_MPAGE" ;
      lblBuscarmenuicon_Internalname = "BUSCARMENUICON_MPAGE" ;
      tblTablebuscarmenuicon_Internalname = "TABLEBUSCARMENUICON_MPAGE" ;
      Combo_buscarmenu_Internalname = "COMBO_BUSCARMENU_MPAGE" ;
      divTablebuscarmenu_Internalname = "TABLEBUSCARMENU_MPAGE" ;
      divMenuheader_Internalname = "MENUHEADER_MPAGE" ;
      lblSvg_opcion_Internalname = "SVG_OPCION_MPAGE" ;
      tblTableiconsvg_Internalname = "TABLEICONSVG_MPAGE" ;
      divTableiconoopcion_Internalname = "TABLEICONOOPCION_MPAGE" ;
      lblTextblockopcion_Internalname = "TEXTBLOCKOPCION_MPAGE" ;
      divTabletextopcion_Internalname = "TABLETEXTOPCION_MPAGE" ;
      lblSvg_accion_Internalname = "SVG_ACCION_MPAGE" ;
      lblUpdatebadge_Internalname = "UPDATEBADGE_MPAGE" ;
      divTableupdatebadge_Internalname = "TABLEUPDATEBADGE_MPAGE" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1_MPAGE" ;
      divTableopcionmenuizq_new_Internalname = "TABLEOPCIONMENUIZQ_NEW_MPAGE" ;
      lblPromotitle_Internalname = "PROMOTITLE_MPAGE" ;
      imgRocketemoji_Internalname = "ROCKETEMOJI_MPAGE" ;
      divTablepromotitle_Internalname = "TABLEPROMOTITLE_MPAGE" ;
      lblPromotext_Internalname = "PROMOTEXT_MPAGE" ;
      divTablepromotext_Internalname = "TABLEPROMOTEXT_MPAGE" ;
      divTablefooter_new_Internalname = "TABLEFOOTER_NEW_MPAGE" ;
      bttBtnupgradepro_Internalname = "BTNUPGRADEPRO_MPAGE" ;
      divTablebuttonupgrade_Internalname = "TABLEBUTTONUPGRADE_MPAGE" ;
      divTablepromomenu_Internalname = "TABLEPROMOMENU_MPAGE" ;
      divMenucenter_Internalname = "MENUCENTER_MPAGE" ;
      lblVersion_Internalname = "VERSION_MPAGE" ;
      divTableversion_Internalname = "TABLEVERSION_MPAGE" ;
      divMenubottom_Internalname = "MENUBOTTOM_MPAGE" ;
      divParentmenu_Internalname = "PARENTMENU_MPAGE" ;
      divLeftcontent_Internalname = "LEFTCONTENT_MPAGE" ;
      lblVolversvg_Internalname = "VOLVERSVG_MPAGE" ;
      lblHtmlhormiga_Internalname = "HTMLHORMIGA_MPAGE" ;
      lblPgmdesc_Internalname = "PGMDESC_MPAGE" ;
      divTablevolver_pgmname_Internalname = "TABLEVOLVER_PGMNAME_MPAGE" ;
      Ddo_languagesicons_Internalname = "DDO_LANGUAGESICONS_MPAGE" ;
      tblTableidioma_Internalname = "TABLEIDIOMA_MPAGE" ;
      lblAyuda_Internalname = "AYUDA_MPAGE" ;
      divTableayuda_Internalname = "TABLEAYUDA_MPAGE" ;
      divTableactions_Internalname = "TABLEACTIONS_MPAGE" ;
      divTopcontent_Internalname = "TOPCONTENT_MPAGE" ;
      divBottomcontent_Internalname = "BOTTOMCONTENT_MPAGE" ;
      divParentrigthcontent_Internalname = "PARENTRIGTHCONTENT_MPAGE" ;
      divRigthcontent_Internalname = "RIGTHCONTENT_MPAGE" ;
      divParentnewcontent_Internalname = "PARENTNEWCONTENT_MPAGE" ;
      Ucmessage_Internalname = "UCMESSAGE_MPAGE" ;
      Uctooltip_Internalname = "UCTOOLTIP_MPAGE" ;
      Wwputilities_Internalname = "WWPUTILITIES_MPAGE" ;
      Wwpdatepicker_Internalname = "WWPDATEPICKER_MPAGE" ;
      A3llinktabla1_Internalname = "A3LLINKTABLA1_MPAGE" ;
      lblJs_Internalname = "JS_MPAGE" ;
      lblTextblock1_Internalname = "TEXTBLOCK1_MPAGE" ;
      tblTablausercontrols_Internalname = "TABLAUSERCONTROLS_MPAGE" ;
      divTablemain_Internalname = "TABLEMAIN_MPAGE" ;
      edtavBuscarmenu_Internalname = "vBUSCARMENU_MPAGE" ;
      edtavPickerdummyvariable_Internalname = "vPICKERDUMMYVARIABLE_MPAGE" ;
      divDiv_ddc_adminag_Internalname = "DIV_DDC_ADMINAG_MPAGE" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS_MPAGE" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE_MPAGE" ;
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setInternalname( "FORM_MPAGE" );
      subGridopciones_Internalname = "GRIDOPCIONES_MPAGE" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      subGridopciones_Allowcollapsing = (byte)(0) ;
      lblUpdatebadge_Caption = "2" ;
      lblSvg_accion_Caption = httpContext.getMessage( "<svg width=\"21\" height=\"21\" viewBox=\"0 0 21 21\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><rect x=\"1\" y=\"1\" width=\"19\" height=\"19\" rx=\"9.5\" stroke=\"#D0CFD4\"/><path d=\"M7 10.5L14 10.5\" stroke=\"#A1A1AA\" stroke-width=\"1.5\"/><path d=\"M10.5 7V14\" stroke=\"#A1A1AA\" stroke-width=\"1.5\"/></svg>", "") ;
      lblTextblockopcion_Caption = httpContext.getMessage( "Opción", "") ;
      lblSvg_opcion_Caption = httpContext.getMessage( "svg_opcion", "") ;
      lblUpdatebadge_Caption = "2" ;
      divTableupdatebadge_Visible = 1 ;
      lblSvg_accion_Visible = 1 ;
      lblTextblockopcion_Class = "TextOptionMenuIzq_new" ;
      lblTextblockopcion_Caption = httpContext.getMessage( "Opción", "") ;
      lblSvg_opcion_Caption = httpContext.getMessage( "svg_opcion", "") ;
      lblSvg_opcion_Visible = 1 ;
      lblJs_Caption = httpContext.getMessage( "js", "") ;
      divTableopcionmenuizq_new_Class = "TableOpcionMenuIzq_new" ;
      tblTableidioma_Visible = 1 ;
      subGridopciones_Backcolorstyle = (byte)(0) ;
      edtavPickerdummyvariable_Jsonclick = "" ;
      edtavBuscarmenu_Jsonclick = "" ;
      edtavBuscarmenu_Visible = 1 ;
      divBottomcontent_Class = "bottomContent" ;
      lblAyuda_Caption = httpContext.getMessage( "svg_2", "") ;
      lblAyuda_Visible = 1 ;
      lblPgmdesc_Caption = httpContext.getMessage( "Pantalla", "") ;
      lblHtmlhormiga_Caption = httpContext.getMessage( "htmlHormiga", "") ;
      lblHtmlhormiga_Visible = 1 ;
      lblVolversvg_Caption = httpContext.getMessage( "svg_1", "") ;
      lblVolversvg_Visible = 1 ;
      divParentrigthcontent_Class = "parentRigthContent" ;
      divRigthcontent_Class = "rigthContent" ;
      divTablepromomenu_Visible = 1 ;
      Combo_buscarmenu_Caption = "" ;
      cmbavConvecodigo.setJsonclick( "" );
      cmbavConvecodigo.setVisible( 1 );
      cmbavConvecodigo.setEnabled( 1 );
      cmbavEmpcod.setJsonclick( "" );
      cmbavEmpcod.setVisible( 1 );
      cmbavEmpcod.setEnabled( 1 );
      divTablevariables_Class = "TableVariables" ;
      divTabledoblecaret_Visible = 1 ;
      lblTextempresaconveniotitulo_Caption = httpContext.getMessage( "Empresa ", "") ;
      divTablesvgtextempresa_Visible = 1 ;
      divTablealerta_Visible = 1 ;
      Ddc_adminag_Caption = "" ;
      divLayoutmaintable_Class = "Table" ;
      subGridopciones_Flexdirection = "column" ;
      subGridopciones_Class = "FreeStyleGrid" ;
      A3llinktabla1_Urls = "" ;
      A3llinktabla1_Linkrowid = "" ;
      Wwputilities_Pagbarincludegoto = GXutil.toBoolean( -1) ;
      Wwputilities_Allowcolumnsrestore = GXutil.toBoolean( -1) ;
      Wwputilities_Allowcolumndragging = GXutil.toBoolean( -1) ;
      Wwputilities_Allowcolumnreordering = GXutil.toBoolean( -1) ;
      Wwputilities_Allowcolumnresizing = GXutil.toBoolean( -1) ;
      Wwputilities_Enableconvertcombotobootstrapselect = GXutil.toBoolean( -1) ;
      Wwputilities_Enableupdaterowselectionstatus = GXutil.toBoolean( -1) ;
      Wwputilities_Empowertabs = GXutil.toBoolean( -1) ;
      Wwputilities_Enablefixobjectfitcover = GXutil.toBoolean( -1) ;
      Ucmessage_Labellast = "Last" ;
      Ucmessage_Labelall = "All" ;
      Ucmessage_Labelredisplay = "Redisplay" ;
      Ucmessage_Maxonscreen = "Infinity" ;
      Ucmessage_Menu = GXutil.toBoolean( 0) ;
      Ucmessage_Showevenonnonblock = GXutil.toBoolean( 0) ;
      Ucmessage_Labelstickbutton = "Stick" ;
      Ucmessage_Labelclosebutton = "Cerrar" ;
      Ucmessage_Stickerhover = GXutil.toBoolean( 0) ;
      Ucmessage_Sticker = GXutil.toBoolean( 0) ;
      Ucmessage_Closer = GXutil.toBoolean( -1) ;
      Ucmessage_Nextmessageposition = "down" ;
      Ucmessage_Startposition = "TopRight" ;
      Ucmessage_Animationspeed = 300 ;
      Ucmessage_Effectout = "none" ;
      Ucmessage_Effectin = "fade" ;
      Ucmessage_Mousehidereset = GXutil.toBoolean( -1) ;
      Ucmessage_Delayuntilhide = 4000 ;
      Ucmessage_Hide = GXutil.toBoolean( -1) ;
      Ucmessage_Changenewlinestobrs = GXutil.toBoolean( 0) ;
      Ucmessage_Textescape = GXutil.toBoolean( 0) ;
      Ucmessage_Titleescape = GXutil.toBoolean( -1) ;
      Ucmessage_Stoponerror = GXutil.toBoolean( 0) ;
      Ucmessage_Defaultmessagetype = "notice" ;
      Ucmessage_Stylingtype = "lighttheme" ;
      Ucmessage_Minheight = "16" ;
      Ucmessage_Width = "500" ;
      Ddo_languagesicons_Titlecontrolalign = "Automatic" ;
      Ddo_languagesicons_Cls = "DropDownOptionsHeader" ;
      Combo_buscarmenu_Emptyitemtext = " Buscar..." ;
      Combo_buscarmenu_Dropdownoptionstype = "ExtendedSuggest" ;
      Combo_buscarmenu_Cls = "ExtendedCombo AttributeBuscarMenu borderNone" ;
      Ddc_adminag_Load = "OnWebPanelLoad" ;
      Ddc_adminag_Showloading = GXutil.toBoolean( 0) ;
      Ddc_adminag_Visible = GXutil.toBoolean( -1) ;
      Ddc_adminag_Componentwidth = 260 ;
      Ddc_adminag_Cls = "DropDownOptionsNoBackHover_new" ;
      Ddc_adminag_Icon = "" ;
      Contentholder.setDataArea(getDataAreaObject());
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavEmpcod.setName( "vEMPCOD_MPAGE" );
      cmbavEmpcod.setWebtags( "" );
      if ( cmbavEmpcod.getItemCount() > 0 )
      {
         AV16EmpCod = (short)(GXutil.lval( cmbavEmpcod.getValidValue(GXutil.trim( GXutil.str( AV16EmpCod, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", true, "AV16EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16EmpCod), 4, 0));
      }
      cmbavConvecodigo.setName( "vCONVECODIGO_MPAGE" );
      cmbavConvecodigo.setWebtags( "" );
      if ( cmbavConvecodigo.getItemCount() > 0 )
      {
         AV13ConveCodigo = cmbavConvecodigo.getValidValue(AV13ConveCodigo) ;
         httpContext.ajax_rsp_assign_attri("", true, "AV13ConveCodigo", AV13ConveCodigo);
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH_MPAGE","{handler:'refresh',iparms:[{av:'GRIDOPCIONES_MPAGE_nFirstRecordOnPage'},{av:'GRIDOPCIONES_MPAGE_nEOF'},{av:'A1923RolId',fld:'ROLID_MPAGE',pic:'Z9'},{av:'A1925PerfilId',fld:'PERFILID_MPAGE',pic:'Z9'},{av:'A1928MenuVerId',fld:'MENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9'},{av:'A1940MenuItemOrd',fld:'MENUITEMORD_MPAGE',pic:'Z9'},{av:'A1933MenuOpcPadre',fld:'MENUOPCPADRE_MPAGE',pic:''},{av:'A1935SVGId',fld:'SVGID_MPAGE',pic:''},{av:'A1936SVGValor',fld:'SVGVALOR_MPAGE',pic:''},{av:'A1929MenuOpcCod',fld:'MENUOPCCOD_MPAGE',pic:''},{av:'A1931MenuOpcTitulo',fld:'MENUOPCTITULO_MPAGE',pic:''},{av:'A1937MenuItemId',fld:'MENUITEMID_MPAGE',pic:''},{av:'AV54urls',fld:'vURLS_MPAGE',pic:''},{av:'AV22Httprequest.getBaseURL()',ctrl:'vHTTPREQUEST_MPAGE',prop:'Baseurl'},{av:'AV90Pgmname',fld:'vPGMNAME_MPAGE',pic:''},{av:'cmbavEmpcod'},{av:'AV16EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9'},{av:'A3CliCod',fld:'CLICOD_MPAGE',pic:'ZZZZZ9'},{av:'A1567CliConvenioDescrip',fld:'CLICONVENIODESCRIP_MPAGE',pic:''},{av:'AV12contentHolder_Pgmname',fld:'vCONTENTHOLDER_PGMNAME_MPAGE',pic:'',hsh:true},{av:'AV43RolId',fld:'vROLID_MPAGE',pic:'Z9',hsh:true},{av:'AV39PerfilId',fld:'vPERFILID_MPAGE',pic:'Z9',hsh:true},{av:'AV34MenuVerId',fld:'vMENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9',hsh:true},{av:'AV51selMenuOpcCod',fld:'vSELMENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'AV41primero_MenuOpcCod',fld:'vPRIMERO_MENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'AV31MenuItemId',fld:'vMENUITEMID_MPAGE',pic:'',hsh:true},{av:'AV85hormigaURL',fld:'vHORMIGAURL_MPAGE',pic:'',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE_MPAGE',pic:'ZZZ9',hsh:true},{av:'A2429CliConveEsquemaEs',fld:'CLICONVEESQUEMAES_MPAGE',pic:'',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO_MPAGE',pic:'',hsh:true},{av:'A1EmpCod',fld:'EMPCOD_MPAGE',pic:'ZZZ9',hsh:true},{av:'A2EmpNom',fld:'EMPNOM_MPAGE',pic:'@!',hsh:true}]");
      setEventMetadata("REFRESH_MPAGE",",oparms:[{av:'AV51selMenuOpcCod',fld:'vSELMENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'AV12contentHolder_Pgmname',fld:'vCONTENTHOLDER_PGMNAME_MPAGE',pic:'',hsh:true},{av:'divParentrigthcontent_Class',ctrl:'PARENTRIGTHCONTENT_MPAGE',prop:'Class'},{av:'divBottomcontent_Class',ctrl:'BOTTOMCONTENT_MPAGE',prop:'Class'},{av:'divRigthcontent_Class',ctrl:'RIGTHCONTENT_MPAGE',prop:'Class'},{av:'cmbavEmpcod'},{av:'divTabledoblecaret_Visible',ctrl:'TABLEDOBLECARET_MPAGE',prop:'Visible'},{av:'divTablevariables_Class',ctrl:'TABLEVARIABLES_MPAGE',prop:'Class'},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9'},{av:'AV16EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'cmbavConvecodigo'},{av:'AV13ConveCodigo',fld:'vCONVECODIGO_MPAGE',pic:''},{av:'lblTextempresaconveniotitulo_Caption',ctrl:'TEXTEMPRESACONVENIOTITULO_MPAGE',prop:'Caption'},{av:'AV37PaiCod',fld:'vPAICOD_MPAGE',pic:'ZZZ9'},{av:'divTablesvgtextempresa_Visible',ctrl:'TABLESVGTEXTEMPRESA_MPAGE',prop:'Visible'},{av:'Ddc_adminag_Visible',ctrl:'DDC_ADMINAG_MPAGE',prop:'Visible'},{av:'lblHtmlhormiga_Visible',ctrl:'HTMLHORMIGA_MPAGE',prop:'Visible'},{av:'lblAyuda_Caption',ctrl:'AYUDA_MPAGE',prop:'Caption'},{av:'AV41primero_MenuOpcCod',fld:'vPRIMERO_MENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'lblHtmlhormiga_Caption',ctrl:'HTMLHORMIGA_MPAGE',prop:'Caption'},{av:'AV85hormigaURL',fld:'vHORMIGAURL_MPAGE',pic:'',hsh:true},{ctrl:'FORM_MPAGE',prop:'Headerrawhtml'},{av:'lblAyuda_Visible',ctrl:'AYUDA_MPAGE',prop:'Visible'},{av:'lblPgmdesc_Caption',ctrl:'PGMDESC_MPAGE',prop:'Caption'},{av:'lblVolversvg_Visible',ctrl:'VOLVERSVG_MPAGE',prop:'Visible'},{ctrl:'FORM_MPAGE',prop:'Caption'}]}");
      setEventMetadata("GRIDOPCIONES_MPAGE.LOAD_MPAGE","{handler:'e22OK2',iparms:[{av:'A1923RolId',fld:'ROLID_MPAGE',pic:'Z9'},{av:'A1925PerfilId',fld:'PERFILID_MPAGE',pic:'Z9'},{av:'A1928MenuVerId',fld:'MENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9'},{av:'A1940MenuItemOrd',fld:'MENUITEMORD_MPAGE',pic:'Z9'},{av:'AV43RolId',fld:'vROLID_MPAGE',pic:'Z9',hsh:true},{av:'AV39PerfilId',fld:'vPERFILID_MPAGE',pic:'Z9',hsh:true},{av:'AV34MenuVerId',fld:'vMENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9',hsh:true},{av:'A1933MenuOpcPadre',fld:'MENUOPCPADRE_MPAGE',pic:''},{av:'A1935SVGId',fld:'SVGID_MPAGE',pic:''},{av:'A1936SVGValor',fld:'SVGVALOR_MPAGE',pic:''},{av:'A1929MenuOpcCod',fld:'MENUOPCCOD_MPAGE',pic:''},{av:'AV41primero_MenuOpcCod',fld:'vPRIMERO_MENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'A1931MenuOpcTitulo',fld:'MENUOPCTITULO_MPAGE',pic:''},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9'},{av:'cmbavEmpcod'},{av:'AV16EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'A1937MenuItemId',fld:'MENUITEMID_MPAGE',pic:''},{av:'AV54urls',fld:'vURLS_MPAGE',pic:''},{av:'AV90Pgmname',fld:'vPGMNAME_MPAGE',pic:''}]");
      setEventMetadata("GRIDOPCIONES_MPAGE.LOAD_MPAGE",",oparms:[{av:'lblSvg_opcion_Caption',ctrl:'SVG_OPCION_MPAGE',prop:'Caption'},{av:'lblSvg_opcion_Visible',ctrl:'SVG_OPCION_MPAGE',prop:'Visible'},{av:'divTableopcionmenuizq_new_Class',ctrl:'TABLEOPCIONMENUIZQ_NEW_MPAGE',prop:'Class'},{av:'lblTextblockopcion_Class',ctrl:'TEXTBLOCKOPCION_MPAGE',prop:'Class'},{av:'lblTextblockopcion_Caption',ctrl:'TEXTBLOCKOPCION_MPAGE',prop:'Caption'},{av:'divTableupdatebadge_Visible',ctrl:'TABLEUPDATEBADGE_MPAGE',prop:'Visible'},{av:'lblUpdatebadge_Caption',ctrl:'UPDATEBADGE_MPAGE',prop:'Caption'},{av:'AV54urls',fld:'vURLS_MPAGE',pic:''},{av:'lblSvg_accion_Visible',ctrl:'SVG_ACCION_MPAGE',prop:'Visible'},{av:'A3llinktabla1_Linkrowid',ctrl:'A3LLINKTABLA1_MPAGE',prop:'linkRowId'},{av:'A3llinktabla1_Urls',ctrl:'A3LLINKTABLA1_MPAGE',prop:'urls'},{av:'lblJs_Caption',ctrl:'JS_MPAGE',prop:'Caption'}]}");
      setEventMetadata("DDO_LANGUAGESICONS_MPAGE.ONOPTIONCLICKED_MPAGE","{handler:'e13OK2',iparms:[{av:'Ddo_languagesicons_Activeeventkey',ctrl:'DDO_LANGUAGESICONS_MPAGE',prop:'ActiveEventKey'},{av:'GRIDOPCIONES_MPAGE_nFirstRecordOnPage'},{av:'GRIDOPCIONES_MPAGE_nEOF'},{av:'AV90Pgmname',fld:'vPGMNAME_MPAGE',pic:''},{av:'cmbavEmpcod'},{av:'AV16EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9'},{av:'A3CliCod',fld:'CLICOD_MPAGE',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD_MPAGE',pic:'ZZZ9',hsh:true},{av:'A2EmpNom',fld:'EMPNOM_MPAGE',pic:'@!',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE_MPAGE',pic:'ZZZ9',hsh:true},{av:'A2429CliConveEsquemaEs',fld:'CLICONVEESQUEMAES_MPAGE',pic:'',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO_MPAGE',pic:'',hsh:true},{av:'A1567CliConvenioDescrip',fld:'CLICONVENIODESCRIP_MPAGE',pic:''},{av:'AV12contentHolder_Pgmname',fld:'vCONTENTHOLDER_PGMNAME_MPAGE',pic:'',hsh:true},{av:'AV43RolId',fld:'vROLID_MPAGE',pic:'Z9',hsh:true},{av:'AV39PerfilId',fld:'vPERFILID_MPAGE',pic:'Z9',hsh:true},{av:'AV34MenuVerId',fld:'vMENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9',hsh:true},{av:'AV51selMenuOpcCod',fld:'vSELMENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'A1923RolId',fld:'ROLID_MPAGE',pic:'Z9'},{av:'A1925PerfilId',fld:'PERFILID_MPAGE',pic:'Z9'},{av:'A1928MenuVerId',fld:'MENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9'},{av:'A1940MenuItemOrd',fld:'MENUITEMORD_MPAGE',pic:'Z9'},{av:'A1933MenuOpcPadre',fld:'MENUOPCPADRE_MPAGE',pic:''},{av:'A1935SVGId',fld:'SVGID_MPAGE',pic:''},{av:'A1936SVGValor',fld:'SVGVALOR_MPAGE',pic:''},{av:'A1929MenuOpcCod',fld:'MENUOPCCOD_MPAGE',pic:''},{av:'AV41primero_MenuOpcCod',fld:'vPRIMERO_MENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'A1931MenuOpcTitulo',fld:'MENUOPCTITULO_MPAGE',pic:''},{av:'A1937MenuItemId',fld:'MENUITEMID_MPAGE',pic:''},{av:'AV54urls',fld:'vURLS_MPAGE',pic:''},{av:'AV31MenuItemId',fld:'vMENUITEMID_MPAGE',pic:'',hsh:true},{av:'AV85hormigaURL',fld:'vHORMIGAURL_MPAGE',pic:'',hsh:true},{av:'AV22Httprequest.getBaseURL()',ctrl:'vHTTPREQUEST_MPAGE',prop:'Baseurl'}]");
      setEventMetadata("DDO_LANGUAGESICONS_MPAGE.ONOPTIONCLICKED_MPAGE",",oparms:[{av:'AV51selMenuOpcCod',fld:'vSELMENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'AV12contentHolder_Pgmname',fld:'vCONTENTHOLDER_PGMNAME_MPAGE',pic:'',hsh:true},{av:'divParentrigthcontent_Class',ctrl:'PARENTRIGTHCONTENT_MPAGE',prop:'Class'},{av:'divBottomcontent_Class',ctrl:'BOTTOMCONTENT_MPAGE',prop:'Class'},{av:'divRigthcontent_Class',ctrl:'RIGTHCONTENT_MPAGE',prop:'Class'},{av:'cmbavEmpcod'},{av:'divTabledoblecaret_Visible',ctrl:'TABLEDOBLECARET_MPAGE',prop:'Visible'},{av:'divTablevariables_Class',ctrl:'TABLEVARIABLES_MPAGE',prop:'Class'},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9'},{av:'AV16EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'cmbavConvecodigo'},{av:'AV13ConveCodigo',fld:'vCONVECODIGO_MPAGE',pic:''},{av:'lblTextempresaconveniotitulo_Caption',ctrl:'TEXTEMPRESACONVENIOTITULO_MPAGE',prop:'Caption'},{av:'AV37PaiCod',fld:'vPAICOD_MPAGE',pic:'ZZZ9'},{av:'divTablesvgtextempresa_Visible',ctrl:'TABLESVGTEXTEMPRESA_MPAGE',prop:'Visible'},{av:'Ddc_adminag_Visible',ctrl:'DDC_ADMINAG_MPAGE',prop:'Visible'},{av:'lblHtmlhormiga_Visible',ctrl:'HTMLHORMIGA_MPAGE',prop:'Visible'},{av:'lblAyuda_Caption',ctrl:'AYUDA_MPAGE',prop:'Caption'},{av:'AV41primero_MenuOpcCod',fld:'vPRIMERO_MENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'lblHtmlhormiga_Caption',ctrl:'HTMLHORMIGA_MPAGE',prop:'Caption'},{av:'AV85hormigaURL',fld:'vHORMIGAURL_MPAGE',pic:'',hsh:true},{ctrl:'FORM_MPAGE',prop:'Headerrawhtml'},{av:'lblAyuda_Visible',ctrl:'AYUDA_MPAGE',prop:'Visible'},{av:'lblPgmdesc_Caption',ctrl:'PGMDESC_MPAGE',prop:'Caption'},{av:'lblVolversvg_Visible',ctrl:'VOLVERSVG_MPAGE',prop:'Visible'},{ctrl:'FORM_MPAGE',prop:'Caption'}]}");
      setEventMetadata("DOUPGRADEPRO_MPAGE","{handler:'e11OK1',iparms:[]");
      setEventMetadata("DOUPGRADEPRO_MPAGE",",oparms:[]}");
      setEventMetadata("COMBO_BUSCARMENU_MPAGE.ONOPTIONCLICKED_MPAGE","{handler:'e12OK2',iparms:[{av:'Combo_buscarmenu_Selectedvalue_get',ctrl:'COMBO_BUSCARMENU_MPAGE',prop:'SelectedValue_get'},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9'},{av:'cmbavEmpcod'},{av:'AV16EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'AV39PerfilId',fld:'vPERFILID_MPAGE',pic:'Z9',hsh:true},{av:'AV31MenuItemId',fld:'vMENUITEMID_MPAGE',pic:'',hsh:true}]");
      setEventMetadata("COMBO_BUSCARMENU_MPAGE.ONOPTIONCLICKED_MPAGE",",oparms:[{av:'AV76BuscarMenu',fld:'vBUSCARMENU_MPAGE',pic:''},{av:'Combo_buscarmenu_Selectedtext_set',ctrl:'COMBO_BUSCARMENU_MPAGE',prop:'SelectedText_set'},{av:'Combo_buscarmenu_Selectedvalue_set',ctrl:'COMBO_BUSCARMENU_MPAGE',prop:'SelectedValue_set'}]}");
      setEventMetadata("VOLVERSVG_MPAGE.CLICK_MPAGE","{handler:'e14OK2',iparms:[{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9'},{av:'AV90Pgmname',fld:'vPGMNAME_MPAGE',pic:''},{av:'AV51selMenuOpcCod',fld:'vSELMENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'AV43RolId',fld:'vROLID_MPAGE',pic:'Z9',hsh:true},{av:'AV39PerfilId',fld:'vPERFILID_MPAGE',pic:'Z9',hsh:true},{av:'AV34MenuVerId',fld:'vMENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9',hsh:true},{av:'AV85hormigaURL',fld:'vHORMIGAURL_MPAGE',pic:'',hsh:true}]");
      setEventMetadata("VOLVERSVG_MPAGE.CLICK_MPAGE",",oparms:[]}");
      setEventMetadata("GRIDOPCIONES_MPAGE.REFRESH_MPAGE","{handler:'e23OK2',iparms:[]");
      setEventMetadata("GRIDOPCIONES_MPAGE.REFRESH_MPAGE",",oparms:[{av:'AV54urls',fld:'vURLS_MPAGE',pic:''}]}");
      setEventMetadata("TABLELOGO_MPAGE.CLICK_MPAGE","{handler:'e15OK2',iparms:[]");
      setEventMetadata("TABLELOGO_MPAGE.CLICK_MPAGE",",oparms:[]}");
      setEventMetadata("VEMPCOD_MPAGE.CONTROLVALUECHANGED_MPAGE","{handler:'e16OK2',iparms:[{av:'GRIDOPCIONES_MPAGE_nFirstRecordOnPage'},{av:'GRIDOPCIONES_MPAGE_nEOF'},{av:'AV90Pgmname',fld:'vPGMNAME_MPAGE',pic:''},{av:'cmbavEmpcod'},{av:'AV16EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9'},{av:'A3CliCod',fld:'CLICOD_MPAGE',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD_MPAGE',pic:'ZZZ9',hsh:true},{av:'A2EmpNom',fld:'EMPNOM_MPAGE',pic:'@!',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE_MPAGE',pic:'ZZZ9',hsh:true},{av:'A2429CliConveEsquemaEs',fld:'CLICONVEESQUEMAES_MPAGE',pic:'',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO_MPAGE',pic:'',hsh:true},{av:'A1567CliConvenioDescrip',fld:'CLICONVENIODESCRIP_MPAGE',pic:''},{av:'AV12contentHolder_Pgmname',fld:'vCONTENTHOLDER_PGMNAME_MPAGE',pic:'',hsh:true},{av:'AV43RolId',fld:'vROLID_MPAGE',pic:'Z9',hsh:true},{av:'AV39PerfilId',fld:'vPERFILID_MPAGE',pic:'Z9',hsh:true},{av:'AV34MenuVerId',fld:'vMENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9',hsh:true},{av:'AV51selMenuOpcCod',fld:'vSELMENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'A1923RolId',fld:'ROLID_MPAGE',pic:'Z9'},{av:'A1925PerfilId',fld:'PERFILID_MPAGE',pic:'Z9'},{av:'A1928MenuVerId',fld:'MENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9'},{av:'A1940MenuItemOrd',fld:'MENUITEMORD_MPAGE',pic:'Z9'},{av:'A1933MenuOpcPadre',fld:'MENUOPCPADRE_MPAGE',pic:''},{av:'A1935SVGId',fld:'SVGID_MPAGE',pic:''},{av:'A1936SVGValor',fld:'SVGVALOR_MPAGE',pic:''},{av:'A1929MenuOpcCod',fld:'MENUOPCCOD_MPAGE',pic:''},{av:'AV41primero_MenuOpcCod',fld:'vPRIMERO_MENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'A1931MenuOpcTitulo',fld:'MENUOPCTITULO_MPAGE',pic:''},{av:'A1937MenuItemId',fld:'MENUITEMID_MPAGE',pic:''},{av:'AV54urls',fld:'vURLS_MPAGE',pic:''},{av:'AV31MenuItemId',fld:'vMENUITEMID_MPAGE',pic:'',hsh:true},{av:'AV85hormigaURL',fld:'vHORMIGAURL_MPAGE',pic:'',hsh:true},{av:'AV22Httprequest.getBaseURL()',ctrl:'vHTTPREQUEST_MPAGE',prop:'Baseurl'}]");
      setEventMetadata("VEMPCOD_MPAGE.CONTROLVALUECHANGED_MPAGE",",oparms:[{av:'AV51selMenuOpcCod',fld:'vSELMENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'AV12contentHolder_Pgmname',fld:'vCONTENTHOLDER_PGMNAME_MPAGE',pic:'',hsh:true},{av:'divParentrigthcontent_Class',ctrl:'PARENTRIGTHCONTENT_MPAGE',prop:'Class'},{av:'divBottomcontent_Class',ctrl:'BOTTOMCONTENT_MPAGE',prop:'Class'},{av:'divRigthcontent_Class',ctrl:'RIGTHCONTENT_MPAGE',prop:'Class'},{av:'cmbavEmpcod'},{av:'divTabledoblecaret_Visible',ctrl:'TABLEDOBLECARET_MPAGE',prop:'Visible'},{av:'divTablevariables_Class',ctrl:'TABLEVARIABLES_MPAGE',prop:'Class'},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9'},{av:'AV16EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'cmbavConvecodigo'},{av:'AV13ConveCodigo',fld:'vCONVECODIGO_MPAGE',pic:''},{av:'lblTextempresaconveniotitulo_Caption',ctrl:'TEXTEMPRESACONVENIOTITULO_MPAGE',prop:'Caption'},{av:'AV37PaiCod',fld:'vPAICOD_MPAGE',pic:'ZZZ9'},{av:'divTablesvgtextempresa_Visible',ctrl:'TABLESVGTEXTEMPRESA_MPAGE',prop:'Visible'},{av:'Ddc_adminag_Visible',ctrl:'DDC_ADMINAG_MPAGE',prop:'Visible'},{av:'lblHtmlhormiga_Visible',ctrl:'HTMLHORMIGA_MPAGE',prop:'Visible'},{av:'lblAyuda_Caption',ctrl:'AYUDA_MPAGE',prop:'Caption'},{av:'AV41primero_MenuOpcCod',fld:'vPRIMERO_MENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'lblHtmlhormiga_Caption',ctrl:'HTMLHORMIGA_MPAGE',prop:'Caption'},{av:'AV85hormigaURL',fld:'vHORMIGAURL_MPAGE',pic:'',hsh:true},{ctrl:'FORM_MPAGE',prop:'Headerrawhtml'},{av:'lblAyuda_Visible',ctrl:'AYUDA_MPAGE',prop:'Visible'},{av:'lblPgmdesc_Caption',ctrl:'PGMDESC_MPAGE',prop:'Caption'},{av:'lblVolversvg_Visible',ctrl:'VOLVERSVG_MPAGE',prop:'Visible'},{ctrl:'FORM_MPAGE',prop:'Caption'}]}");
      setEventMetadata("VCONVECODIGO_MPAGE.CONTROLVALUECHANGED_MPAGE","{handler:'e17OK2',iparms:[{av:'GRIDOPCIONES_MPAGE_nFirstRecordOnPage'},{av:'GRIDOPCIONES_MPAGE_nEOF'},{av:'AV90Pgmname',fld:'vPGMNAME_MPAGE',pic:''},{av:'cmbavEmpcod'},{av:'AV16EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9'},{av:'A3CliCod',fld:'CLICOD_MPAGE',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD_MPAGE',pic:'ZZZ9',hsh:true},{av:'A2EmpNom',fld:'EMPNOM_MPAGE',pic:'@!',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE_MPAGE',pic:'ZZZ9',hsh:true},{av:'A2429CliConveEsquemaEs',fld:'CLICONVEESQUEMAES_MPAGE',pic:'',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO_MPAGE',pic:'',hsh:true},{av:'A1567CliConvenioDescrip',fld:'CLICONVENIODESCRIP_MPAGE',pic:''},{av:'AV12contentHolder_Pgmname',fld:'vCONTENTHOLDER_PGMNAME_MPAGE',pic:'',hsh:true},{av:'AV43RolId',fld:'vROLID_MPAGE',pic:'Z9',hsh:true},{av:'AV39PerfilId',fld:'vPERFILID_MPAGE',pic:'Z9',hsh:true},{av:'AV34MenuVerId',fld:'vMENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9',hsh:true},{av:'AV51selMenuOpcCod',fld:'vSELMENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'A1923RolId',fld:'ROLID_MPAGE',pic:'Z9'},{av:'A1925PerfilId',fld:'PERFILID_MPAGE',pic:'Z9'},{av:'A1928MenuVerId',fld:'MENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9'},{av:'A1940MenuItemOrd',fld:'MENUITEMORD_MPAGE',pic:'Z9'},{av:'A1933MenuOpcPadre',fld:'MENUOPCPADRE_MPAGE',pic:''},{av:'A1935SVGId',fld:'SVGID_MPAGE',pic:''},{av:'A1936SVGValor',fld:'SVGVALOR_MPAGE',pic:''},{av:'A1929MenuOpcCod',fld:'MENUOPCCOD_MPAGE',pic:''},{av:'AV41primero_MenuOpcCod',fld:'vPRIMERO_MENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'A1931MenuOpcTitulo',fld:'MENUOPCTITULO_MPAGE',pic:''},{av:'A1937MenuItemId',fld:'MENUITEMID_MPAGE',pic:''},{av:'AV54urls',fld:'vURLS_MPAGE',pic:''},{av:'AV31MenuItemId',fld:'vMENUITEMID_MPAGE',pic:'',hsh:true},{av:'AV85hormigaURL',fld:'vHORMIGAURL_MPAGE',pic:'',hsh:true},{av:'cmbavConvecodigo'},{av:'AV13ConveCodigo',fld:'vCONVECODIGO_MPAGE',pic:''},{av:'AV22Httprequest.getBaseURL()',ctrl:'vHTTPREQUEST_MPAGE',prop:'Baseurl'}]");
      setEventMetadata("VCONVECODIGO_MPAGE.CONTROLVALUECHANGED_MPAGE",",oparms:[{av:'AV51selMenuOpcCod',fld:'vSELMENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'AV12contentHolder_Pgmname',fld:'vCONTENTHOLDER_PGMNAME_MPAGE',pic:'',hsh:true},{av:'divParentrigthcontent_Class',ctrl:'PARENTRIGTHCONTENT_MPAGE',prop:'Class'},{av:'divBottomcontent_Class',ctrl:'BOTTOMCONTENT_MPAGE',prop:'Class'},{av:'divRigthcontent_Class',ctrl:'RIGTHCONTENT_MPAGE',prop:'Class'},{av:'cmbavEmpcod'},{av:'divTabledoblecaret_Visible',ctrl:'TABLEDOBLECARET_MPAGE',prop:'Visible'},{av:'divTablevariables_Class',ctrl:'TABLEVARIABLES_MPAGE',prop:'Class'},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9'},{av:'AV16EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'cmbavConvecodigo'},{av:'AV13ConveCodigo',fld:'vCONVECODIGO_MPAGE',pic:''},{av:'lblTextempresaconveniotitulo_Caption',ctrl:'TEXTEMPRESACONVENIOTITULO_MPAGE',prop:'Caption'},{av:'AV37PaiCod',fld:'vPAICOD_MPAGE',pic:'ZZZ9'},{av:'divTablesvgtextempresa_Visible',ctrl:'TABLESVGTEXTEMPRESA_MPAGE',prop:'Visible'},{av:'Ddc_adminag_Visible',ctrl:'DDC_ADMINAG_MPAGE',prop:'Visible'},{av:'lblHtmlhormiga_Visible',ctrl:'HTMLHORMIGA_MPAGE',prop:'Visible'},{av:'lblAyuda_Caption',ctrl:'AYUDA_MPAGE',prop:'Caption'},{av:'AV41primero_MenuOpcCod',fld:'vPRIMERO_MENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'lblHtmlhormiga_Caption',ctrl:'HTMLHORMIGA_MPAGE',prop:'Caption'},{av:'AV85hormigaURL',fld:'vHORMIGAURL_MPAGE',pic:'',hsh:true},{ctrl:'FORM_MPAGE',prop:'Headerrawhtml'},{av:'lblAyuda_Visible',ctrl:'AYUDA_MPAGE',prop:'Visible'},{av:'lblPgmdesc_Caption',ctrl:'PGMDESC_MPAGE',prop:'Caption'},{av:'lblVolversvg_Visible',ctrl:'VOLVERSVG_MPAGE',prop:'Visible'},{ctrl:'FORM_MPAGE',prop:'Caption'}]}");
      setEventMetadata("AYUDA_MPAGE.CLICK_MPAGE","{handler:'e18OK2',iparms:[{av:'GRIDOPCIONES_MPAGE_nFirstRecordOnPage'},{av:'GRIDOPCIONES_MPAGE_nEOF'},{av:'AV90Pgmname',fld:'vPGMNAME_MPAGE',pic:''},{av:'cmbavEmpcod'},{av:'AV16EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9'},{av:'A3CliCod',fld:'CLICOD_MPAGE',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD_MPAGE',pic:'ZZZ9',hsh:true},{av:'A2EmpNom',fld:'EMPNOM_MPAGE',pic:'@!',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE_MPAGE',pic:'ZZZ9',hsh:true},{av:'A2429CliConveEsquemaEs',fld:'CLICONVEESQUEMAES_MPAGE',pic:'',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO_MPAGE',pic:'',hsh:true},{av:'A1567CliConvenioDescrip',fld:'CLICONVENIODESCRIP_MPAGE',pic:''},{av:'AV12contentHolder_Pgmname',fld:'vCONTENTHOLDER_PGMNAME_MPAGE',pic:'',hsh:true},{av:'AV43RolId',fld:'vROLID_MPAGE',pic:'Z9',hsh:true},{av:'AV39PerfilId',fld:'vPERFILID_MPAGE',pic:'Z9',hsh:true},{av:'AV34MenuVerId',fld:'vMENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9',hsh:true},{av:'AV51selMenuOpcCod',fld:'vSELMENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'A1923RolId',fld:'ROLID_MPAGE',pic:'Z9'},{av:'A1925PerfilId',fld:'PERFILID_MPAGE',pic:'Z9'},{av:'A1928MenuVerId',fld:'MENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9'},{av:'A1940MenuItemOrd',fld:'MENUITEMORD_MPAGE',pic:'Z9'},{av:'A1933MenuOpcPadre',fld:'MENUOPCPADRE_MPAGE',pic:''},{av:'A1935SVGId',fld:'SVGID_MPAGE',pic:''},{av:'A1936SVGValor',fld:'SVGVALOR_MPAGE',pic:''},{av:'A1929MenuOpcCod',fld:'MENUOPCCOD_MPAGE',pic:''},{av:'AV41primero_MenuOpcCod',fld:'vPRIMERO_MENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'A1931MenuOpcTitulo',fld:'MENUOPCTITULO_MPAGE',pic:''},{av:'A1937MenuItemId',fld:'MENUITEMID_MPAGE',pic:''},{av:'AV54urls',fld:'vURLS_MPAGE',pic:''},{av:'AV31MenuItemId',fld:'vMENUITEMID_MPAGE',pic:'',hsh:true},{av:'AV85hormigaURL',fld:'vHORMIGAURL_MPAGE',pic:'',hsh:true},{av:'AV22Httprequest.getBaseURL()',ctrl:'vHTTPREQUEST_MPAGE',prop:'Baseurl'}]");
      setEventMetadata("AYUDA_MPAGE.CLICK_MPAGE",",oparms:[{av:'AV51selMenuOpcCod',fld:'vSELMENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'AV12contentHolder_Pgmname',fld:'vCONTENTHOLDER_PGMNAME_MPAGE',pic:'',hsh:true},{av:'divParentrigthcontent_Class',ctrl:'PARENTRIGTHCONTENT_MPAGE',prop:'Class'},{av:'divBottomcontent_Class',ctrl:'BOTTOMCONTENT_MPAGE',prop:'Class'},{av:'divRigthcontent_Class',ctrl:'RIGTHCONTENT_MPAGE',prop:'Class'},{av:'cmbavEmpcod'},{av:'divTabledoblecaret_Visible',ctrl:'TABLEDOBLECARET_MPAGE',prop:'Visible'},{av:'divTablevariables_Class',ctrl:'TABLEVARIABLES_MPAGE',prop:'Class'},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9'},{av:'AV16EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'cmbavConvecodigo'},{av:'AV13ConveCodigo',fld:'vCONVECODIGO_MPAGE',pic:''},{av:'lblTextempresaconveniotitulo_Caption',ctrl:'TEXTEMPRESACONVENIOTITULO_MPAGE',prop:'Caption'},{av:'AV37PaiCod',fld:'vPAICOD_MPAGE',pic:'ZZZ9'},{av:'divTablesvgtextempresa_Visible',ctrl:'TABLESVGTEXTEMPRESA_MPAGE',prop:'Visible'},{av:'Ddc_adminag_Visible',ctrl:'DDC_ADMINAG_MPAGE',prop:'Visible'},{av:'lblHtmlhormiga_Visible',ctrl:'HTMLHORMIGA_MPAGE',prop:'Visible'},{av:'lblAyuda_Caption',ctrl:'AYUDA_MPAGE',prop:'Caption'},{av:'AV41primero_MenuOpcCod',fld:'vPRIMERO_MENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'lblHtmlhormiga_Caption',ctrl:'HTMLHORMIGA_MPAGE',prop:'Caption'},{av:'AV85hormigaURL',fld:'vHORMIGAURL_MPAGE',pic:'',hsh:true},{ctrl:'FORM_MPAGE',prop:'Headerrawhtml'},{av:'lblAyuda_Visible',ctrl:'AYUDA_MPAGE',prop:'Visible'},{av:'lblPgmdesc_Caption',ctrl:'PGMDESC_MPAGE',prop:'Caption'},{av:'lblVolversvg_Visible',ctrl:'VOLVERSVG_MPAGE',prop:'Visible'},{ctrl:'FORM_MPAGE',prop:'Caption'}]}");
      setEventMetadata("ONMESSAGE_GX1_MPAGE","{handler:'e19OK2',iparms:[{av:'AV36NotificationInfo',fld:'vNOTIFICATIONINFO_MPAGE',pic:''},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9'},{av:'AV90Pgmname',fld:'vPGMNAME_MPAGE',pic:''}]");
      setEventMetadata("ONMESSAGE_GX1_MPAGE",",oparms:[]}");
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Contentholder = new com.genexus.webpanels.GXDataAreaControl();
      AV22Httprequest = httpContext.getHttpRequest();
      Ddo_languagesicons_Activeeventkey = "" ;
      Combo_buscarmenu_Selectedvalue_get = "" ;
      AV36NotificationInfo = new com.genexuscore.genexus.server.SdtNotificationInfo(remoteHandle, context);
      AV90Pgmname = "" ;
      A2EmpNom = "" ;
      A1565CliConvenio = "" ;
      A1567CliConvenioDescrip = "" ;
      AV12contentHolder_Pgmname = "" ;
      AV51selMenuOpcCod = "" ;
      A1933MenuOpcPadre = "" ;
      A1935SVGId = "" ;
      A1936SVGValor = "" ;
      A1929MenuOpcCod = "" ;
      AV41primero_MenuOpcCod = "" ;
      A1931MenuOpcTitulo = "" ;
      A1937MenuItemId = "" ;
      AV54urls = new GXSimpleCollection<String>(String.class, "internal", "");
      AV31MenuItemId = "" ;
      AV85hormigaURL = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GXKey = "" ;
      AV81DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV80BuscarMenu_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV28LanguagesIconsData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      Combo_buscarmenu_Selectedvalue_set = "" ;
      Combo_buscarmenu_Selectedtext_set = "" ;
      Ddo_languagesicons_Caption = "" ;
      sPrefix = "" ;
      lblTextblock_pay_Jsonclick = "" ;
      ucDdc_adminag = new com.genexus.webpanels.GXUserControl();
      lblTextblock2_Jsonclick = "" ;
      lblSvgempresa_Jsonclick = "" ;
      lblTextempresaconveniotitulo_Jsonclick = "" ;
      lblDoblecaret_Jsonclick = "" ;
      TempTags = "" ;
      AV13ConveCodigo = "" ;
      ucCombo_buscarmenu = new com.genexus.webpanels.GXUserControl();
      MPGridopcionesContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      lblPromotitle_Jsonclick = "" ;
      ClassString = "" ;
      imgRocketemoji_gximage = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      lblPromotext_Jsonclick = "" ;
      bttBtnupgradepro_Jsonclick = "" ;
      lblVersion_Jsonclick = "" ;
      lblVolversvg_Jsonclick = "" ;
      lblHtmlhormiga_Jsonclick = "" ;
      lblPgmdesc_Jsonclick = "" ;
      lblAyuda_Jsonclick = "" ;
      AV76BuscarMenu = "" ;
      AV40PickerDummyVariable = GXutil.nullDate() ;
      WebComp_Ddc_adminag_wc_Component = "" ;
      OldDdc_adminag_wc = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      GXCCtl = "" ;
      GX_FocusControl = "" ;
      AV84actualURL = "" ;
      AV49SecUserName = "" ;
      AV50SecUserPerName = "" ;
      AV73SecUserPerLastName = "" ;
      AV74RolNombre = "" ;
      AV15DVelop_Menu = new GXBaseCollection<web.wwpbaseobjects.SdtDVelop_Menu_Item>(web.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "PayDay", remoteHandle);
      GXt_objcol_SdtDVelop_Menu_Item5 = new GXBaseCollection<web.wwpbaseobjects.SdtDVelop_Menu_Item>(web.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "PayDay", remoteHandle);
      GXv_objcol_SdtDVelop_Menu_Item6 = new GXBaseCollection[1] ;
      GXv_int11 = new byte[1] ;
      GXv_int12 = new byte[1] ;
      GXv_int13 = new long[1] ;
      AV27Language = "" ;
      ucDdo_languagesicons = new com.genexus.webpanels.GXUserControl();
      AV6WWP_DesignSystemSettings = new web.wwpbaseobjects.SdtWWP_DesignSystemSettings(remoteHandle, context);
      GXt_SdtWWP_DesignSystemSettings14 = new web.wwpbaseobjects.SdtWWP_DesignSystemSettings(remoteHandle, context);
      GXv_SdtWWP_DesignSystemSettings15 = new web.wwpbaseobjects.SdtWWP_DesignSystemSettings[1] ;
      AV78ParmValue = "" ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons17 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons18 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV29LanguagesIconsDataItem = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV57WebSession = httpContext.getWebSession();
      GXv_int8 = new int[1] ;
      scmdbuf = "" ;
      H00OK2_A1923RolId = new byte[1] ;
      H00OK2_A1925PerfilId = new byte[1] ;
      H00OK2_A1928MenuVerId = new long[1] ;
      H00OK2_A1933MenuOpcPadre = new String[] {""} ;
      H00OK2_n1933MenuOpcPadre = new boolean[] {false} ;
      H00OK2_A1935SVGId = new String[] {""} ;
      H00OK2_n1935SVGId = new boolean[] {false} ;
      H00OK2_A1936SVGValor = new String[] {""} ;
      H00OK2_A1929MenuOpcCod = new String[] {""} ;
      H00OK2_A1931MenuOpcTitulo = new String[] {""} ;
      H00OK2_A1937MenuItemId = new String[] {""} ;
      H00OK2_A1940MenuItemOrd = new byte[1] ;
      AV33menuURL = "" ;
      GridopcionesRow = new com.genexus.webpanels.GXWebRow();
      ucA3llinktabla1 = new com.genexus.webpanels.GXUserControl();
      lV76BuscarMenu = "" ;
      H00OK3_A1937MenuItemId = new String[] {""} ;
      H00OK3_A2363MenuOpcInst = new boolean[] {false} ;
      H00OK3_A1938MItemEsMenu = new boolean[] {false} ;
      H00OK3_A1933MenuOpcPadre = new String[] {""} ;
      H00OK3_n1933MenuOpcPadre = new boolean[] {false} ;
      H00OK3_A1931MenuOpcTitulo = new String[] {""} ;
      H00OK3_A1928MenuVerId = new long[1] ;
      H00OK3_A1925PerfilId = new byte[1] ;
      H00OK3_A1923RolId = new byte[1] ;
      H00OK3_A1929MenuOpcCod = new String[] {""} ;
      A2362MenuOpcHormiga = "" ;
      AV82ComboCat_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV83Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV53URL = "" ;
      H00OK4_A3CliCod = new int[1] ;
      H00OK4_A2EmpNom = new String[] {""} ;
      H00OK4_A1EmpCod = new short[1] ;
      GXv_int10 = new short[1] ;
      H00OK5_A2429CliConveEsquemaEs = new boolean[] {false} ;
      H00OK5_A3CliCod = new int[1] ;
      H00OK5_A1564CliPaiConve = new short[1] ;
      H00OK5_A1567CliConvenioDescrip = new String[] {""} ;
      H00OK5_A1565CliConvenio = new String[] {""} ;
      AV20homeURL = "" ;
      AV17headTitle = "" ;
      GXv_boolean19 = new boolean[1] ;
      GXt_char16 = "" ;
      GXt_char1 = "" ;
      AV35modoTxt = "" ;
      AV21html = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      GXv_char2 = new String[1] ;
      GXv_char21 = new String[1] ;
      ucUcmessage = new com.genexus.webpanels.GXUserControl();
      ucUctooltip = new com.genexus.webpanels.GXUserControl();
      ucWwputilities = new com.genexus.webpanels.GXUserControl();
      ucWwpdatepicker = new com.genexus.webpanels.GXUserControl();
      lblJs_Jsonclick = "" ;
      lblTextblock1_Jsonclick = "" ;
      lblBuscarmenuicon_Jsonclick = "" ;
      lblTextblockar_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sDynURL = "" ;
      subGridopciones_Linesclass = "" ;
      GridopcionesColumn = new com.genexus.webpanels.GXWebColumn();
      lblSvg_opcion_Jsonclick = "" ;
      lblTextblockopcion_Jsonclick = "" ;
      lblSvg_accion_Jsonclick = "" ;
      lblUpdatebadge_Jsonclick = "" ;
      subGridopciones_Header = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.newmasterpage__default(),
         new Object[] {
             new Object[] {
            H00OK2_A1923RolId, H00OK2_A1925PerfilId, H00OK2_A1928MenuVerId, H00OK2_A1933MenuOpcPadre, H00OK2_n1933MenuOpcPadre, H00OK2_A1935SVGId, H00OK2_n1935SVGId, H00OK2_A1936SVGValor, H00OK2_A1929MenuOpcCod, H00OK2_A1931MenuOpcTitulo,
            H00OK2_A1937MenuItemId, H00OK2_A1940MenuItemOrd
            }
            , new Object[] {
            H00OK3_A1937MenuItemId, H00OK3_A2363MenuOpcInst, H00OK3_A1938MItemEsMenu, H00OK3_A1933MenuOpcPadre, H00OK3_n1933MenuOpcPadre, H00OK3_A1931MenuOpcTitulo, H00OK3_A1928MenuVerId, H00OK3_A1925PerfilId, H00OK3_A1923RolId, H00OK3_A1929MenuOpcCod
            }
            , new Object[] {
            H00OK4_A3CliCod, H00OK4_A2EmpNom, H00OK4_A1EmpCod
            }
            , new Object[] {
            H00OK5_A2429CliConveEsquemaEs, H00OK5_A3CliCod, H00OK5_A1564CliPaiConve, H00OK5_A1567CliConvenioDescrip, H00OK5_A1565CliConvenio
            }
         }
      );
      AV90Pgmname = "WWPBaseObjects.NewMasterPage" ;
      /* GeneXus formulas. */
      AV90Pgmname = "WWPBaseObjects.NewMasterPage" ;
      Gx_err = (short)(0) ;
      WebComp_Ddc_adminag_wc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte GxWebError ;
   private byte AV43RolId ;
   private byte AV39PerfilId ;
   private byte A1923RolId ;
   private byte A1925PerfilId ;
   private byte A1940MenuItemOrd ;
   private byte nDonePA ;
   private byte subGridopciones_Backcolorstyle ;
   private byte GXv_int11[] ;
   private byte GXv_int12[] ;
   private byte GRIDOPCIONES_MPAGE_nEOF ;
   private byte nGotPars ;
   private byte nGXWrapped ;
   private byte subGridopciones_Backstyle ;
   private byte subGridopciones_Allowselection ;
   private byte subGridopciones_Allowhovering ;
   private byte subGridopciones_Allowcollapsing ;
   private byte subGridopciones_Collapsed ;
   private short nRcdExists_7 ;
   private short nIsMod_7 ;
   private short nRcdExists_6 ;
   private short nIsMod_6 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV16EmpCod ;
   private short A1EmpCod ;
   private short A1564CliPaiConve ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV48SecUserId ;
   private short AV75cant ;
   private short AV37PaiCod ;
   private short GXt_int9 ;
   private short GXv_int10[] ;
   private int nRC_GXsfl_76 ;
   private int nGXsfl_76_idx=1 ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private int Ddc_adminag_Componentwidth ;
   private int Ucmessage_Delayuntilhide ;
   private int Ucmessage_Animationspeed ;
   private int divTablealerta_Visible ;
   private int divTablesvgtextempresa_Visible ;
   private int divTabledoblecaret_Visible ;
   private int divTablepromomenu_Visible ;
   private int lblVolversvg_Visible ;
   private int lblHtmlhormiga_Visible ;
   private int lblAyuda_Visible ;
   private int edtavBuscarmenu_Visible ;
   private int subGridopciones_Islastpage ;
   private int tblTableidioma_Visible ;
   private int GXt_int7 ;
   private int GXv_int8[] ;
   private int lblSvg_opcion_Visible ;
   private int divTableupdatebadge_Visible ;
   private int lblSvg_accion_Visible ;
   private int idxLst ;
   private int subGridopciones_Backcolor ;
   private int subGridopciones_Allbackcolor ;
   private int subGridopciones_Selectedindex ;
   private int subGridopciones_Selectioncolor ;
   private int subGridopciones_Hoveringcolor ;
   private long AV34MenuVerId ;
   private long A1928MenuVerId ;
   private long GRIDOPCIONES_MPAGE_nCurrentRecord ;
   private long GRIDOPCIONES_MPAGE_nFirstRecordOnPage ;
   private long GXv_int13[] ;
   private String Ddo_languagesicons_Activeeventkey ;
   private String Combo_buscarmenu_Selectedvalue_get ;
   private String sGXsfl_76_idx="0001" ;
   private String AV90Pgmname ;
   private String A1565CliConvenio ;
   private String AV12contentHolder_Pgmname ;
   private String A1933MenuOpcPadre ;
   private String A1935SVGId ;
   private String GXKey ;
   private String Ddc_adminag_Icon ;
   private String Ddc_adminag_Cls ;
   private String Ddc_adminag_Load ;
   private String Combo_buscarmenu_Cls ;
   private String Combo_buscarmenu_Selectedvalue_set ;
   private String Combo_buscarmenu_Selectedtext_set ;
   private String Combo_buscarmenu_Dropdownoptionstype ;
   private String Combo_buscarmenu_Emptyitemtext ;
   private String Ddo_languagesicons_Caption ;
   private String Ddo_languagesicons_Cls ;
   private String Ddo_languagesicons_Titlecontrolalign ;
   private String Ucmessage_Width ;
   private String Ucmessage_Minheight ;
   private String Ucmessage_Stylingtype ;
   private String Ucmessage_Defaultmessagetype ;
   private String Ucmessage_Effectin ;
   private String Ucmessage_Effectout ;
   private String Ucmessage_Startposition ;
   private String Ucmessage_Nextmessageposition ;
   private String Ucmessage_Labelclosebutton ;
   private String Ucmessage_Labelstickbutton ;
   private String Ucmessage_Maxonscreen ;
   private String Ucmessage_Labelredisplay ;
   private String Ucmessage_Labelall ;
   private String Ucmessage_Labellast ;
   private String A3llinktabla1_Linkrowid ;
   private String A3llinktabla1_Urls ;
   private String subGridopciones_Class ;
   private String subGridopciones_Flexdirection ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String divParentnewcontent_Internalname ;
   private String divLeftcontent_Internalname ;
   private String divParentmenu_Internalname ;
   private String divMenuheader_Internalname ;
   private String divTableheadercontent_Internalname ;
   private String divTablelogo_Internalname ;
   private String divTableisologo_Internalname ;
   private String divTablepay_Internalname ;
   private String lblTextblock_pay_Internalname ;
   private String lblTextblock_pay_Jsonclick ;
   private String divTableuserrole_Internalname ;
   private String divHeadercontentoptions_Internalname ;
   private String divTableuser_Internalname ;
   private String divTableusuario_Internalname ;
   private String Ddc_adminag_Caption ;
   private String Ddc_adminag_Internalname ;
   private String divTablealerta_Internalname ;
   private String lblTextblock2_Internalname ;
   private String lblTextblock2_Jsonclick ;
   private String divTableempresaconvenio_Internalname ;
   private String divTablesvgiconempresa_Internalname ;
   private String lblSvgempresa_Internalname ;
   private String lblSvgempresa_Jsonclick ;
   private String divTablesvgtextempresa_Internalname ;
   private String divTabletitulos_Internalname ;
   private String divTabletituloempresaconvenio_Internalname ;
   private String lblTextempresaconveniotitulo_Internalname ;
   private String lblTextempresaconveniotitulo_Caption ;
   private String lblTextempresaconveniotitulo_Jsonclick ;
   private String divTabledoblecaret_Internalname ;
   private String lblDoblecaret_Internalname ;
   private String lblDoblecaret_Jsonclick ;
   private String divTablevariables_Internalname ;
   private String divTablevariables_Class ;
   private String TempTags ;
   private String AV13ConveCodigo ;
   private String divTablebuscarmenu_Internalname ;
   private String Combo_buscarmenu_Caption ;
   private String Combo_buscarmenu_Internalname ;
   private String divMenucenter_Internalname ;
   private String sStyleString ;
   private String subGridopciones_Internalname ;
   private String divTablepromomenu_Internalname ;
   private String divTablefooter_new_Internalname ;
   private String divTablepromotitle_Internalname ;
   private String lblPromotitle_Internalname ;
   private String lblPromotitle_Jsonclick ;
   private String ClassString ;
   private String imgRocketemoji_gximage ;
   private String StyleString ;
   private String sImgUrl ;
   private String imgRocketemoji_Internalname ;
   private String divTablepromotext_Internalname ;
   private String lblPromotext_Internalname ;
   private String lblPromotext_Jsonclick ;
   private String divTablebuttonupgrade_Internalname ;
   private String bttBtnupgradepro_Internalname ;
   private String bttBtnupgradepro_Jsonclick ;
   private String divMenubottom_Internalname ;
   private String divTableversion_Internalname ;
   private String lblVersion_Internalname ;
   private String lblVersion_Jsonclick ;
   private String divRigthcontent_Internalname ;
   private String divRigthcontent_Class ;
   private String divParentrigthcontent_Internalname ;
   private String divParentrigthcontent_Class ;
   private String divTopcontent_Internalname ;
   private String divTableactions_Internalname ;
   private String lblVolversvg_Internalname ;
   private String lblVolversvg_Caption ;
   private String lblVolversvg_Jsonclick ;
   private String divTablevolver_pgmname_Internalname ;
   private String lblHtmlhormiga_Internalname ;
   private String lblHtmlhormiga_Caption ;
   private String lblHtmlhormiga_Jsonclick ;
   private String lblPgmdesc_Internalname ;
   private String lblPgmdesc_Caption ;
   private String lblPgmdesc_Jsonclick ;
   private String divTableayuda_Internalname ;
   private String lblAyuda_Internalname ;
   private String lblAyuda_Caption ;
   private String lblAyuda_Jsonclick ;
   private String divBottomcontent_Internalname ;
   private String divBottomcontent_Class ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtavBuscarmenu_Internalname ;
   private String AV76BuscarMenu ;
   private String edtavBuscarmenu_Jsonclick ;
   private String edtavPickerdummyvariable_Internalname ;
   private String edtavPickerdummyvariable_Jsonclick ;
   private String divDiv_ddc_adminag_Internalname ;
   private String WebComp_Ddc_adminag_wc_Component ;
   private String OldDdc_adminag_wc ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String GXCCtl ;
   private String GX_FocusControl ;
   private String tblTableidioma_Internalname ;
   private String Ddo_languagesicons_Internalname ;
   private String scmdbuf ;
   private String lblSvg_opcion_Caption ;
   private String divTableopcionmenuizq_new_Class ;
   private String divTableopcionmenuizq_new_Internalname ;
   private String lblTextblockopcion_Class ;
   private String lblTextblockopcion_Caption ;
   private String divTableupdatebadge_Internalname ;
   private String lblUpdatebadge_Caption ;
   private String A3llinktabla1_Internalname ;
   private String lblJs_Caption ;
   private String lblJs_Internalname ;
   private String lV76BuscarMenu ;
   private String GXt_char16 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private String GXv_char2[] ;
   private String GXv_char21[] ;
   private String tblTablausercontrols_Internalname ;
   private String Ucmessage_Internalname ;
   private String Uctooltip_Internalname ;
   private String Wwputilities_Internalname ;
   private String Wwpdatepicker_Internalname ;
   private String lblJs_Jsonclick ;
   private String lblTextblock1_Internalname ;
   private String lblTextblock1_Jsonclick ;
   private String tblTablebuscarmenuicon_Internalname ;
   private String lblBuscarmenuicon_Internalname ;
   private String lblBuscarmenuicon_Jsonclick ;
   private String tblTablelogoname_Internalname ;
   private String divTable_ar_Internalname ;
   private String lblTextblockar_Internalname ;
   private String lblTextblockar_Jsonclick ;
   private String sDynURL ;
   private String lblSvg_opcion_Internalname ;
   private String lblTextblockopcion_Internalname ;
   private String lblSvg_accion_Internalname ;
   private String lblUpdatebadge_Internalname ;
   private String sGXsfl_76_fel_idx="0001" ;
   private String subGridopciones_Linesclass ;
   private String divTableiconoopcion_Internalname ;
   private String tblTableiconsvg_Internalname ;
   private String lblSvg_opcion_Jsonclick ;
   private String divTabletextopcion_Internalname ;
   private String lblTextblockopcion_Jsonclick ;
   private String divUnnamedtable1_Internalname ;
   private String lblSvg_accion_Jsonclick ;
   private String lblUpdatebadge_Jsonclick ;
   private String subGridopciones_Header ;
   private String lblSvg_accion_Caption ;
   private java.util.Date AV40PickerDummyVariable ;
   private boolean A2429CliConveEsquemaEs ;
   private boolean n1933MenuOpcPadre ;
   private boolean n1935SVGId ;
   private boolean Ddc_adminag_Visible ;
   private boolean Ddc_adminag_Showloading ;
   private boolean Ucmessage_Stoponerror ;
   private boolean Ucmessage_Titleescape ;
   private boolean Ucmessage_Textescape ;
   private boolean Ucmessage_Changenewlinestobrs ;
   private boolean Ucmessage_Hide ;
   private boolean Ucmessage_Mousehidereset ;
   private boolean Ucmessage_Closer ;
   private boolean Ucmessage_Sticker ;
   private boolean Ucmessage_Stickerhover ;
   private boolean Ucmessage_Showevenonnonblock ;
   private boolean Ucmessage_Menu ;
   private boolean Wwputilities_Enablefixobjectfitcover ;
   private boolean Wwputilities_Empowertabs ;
   private boolean Wwputilities_Enableupdaterowselectionstatus ;
   private boolean Wwputilities_Enableconvertcombotobootstrapselect ;
   private boolean Wwputilities_Allowcolumnresizing ;
   private boolean Wwputilities_Allowcolumnreordering ;
   private boolean Wwputilities_Allowcolumndragging ;
   private boolean Wwputilities_Allowcolumnsrestore ;
   private boolean Wwputilities_Pagbarincludegoto ;
   private boolean wbLoad ;
   private boolean bGXsfl_76_Refreshing=false ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean toggleJsOutput ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private boolean AV77promoVisible ;
   private boolean bDynCreated_Ddc_adminag_wc ;
   private boolean gx_refresh_fired ;
   private boolean AV25IsAuthorized ;
   private boolean AV52TempBoolean ;
   private boolean GXt_boolean20 ;
   private boolean brkOK4 ;
   private boolean A2363MenuOpcInst ;
   private boolean A1938MItemEsMenu ;
   private boolean AV87MenuOpcForRet ;
   private boolean AV5hay ;
   private boolean AV10ClienteConveniador ;
   private boolean AV11combosVisiblEs ;
   private boolean AV30MenuBienveVisible ;
   private boolean GXv_boolean19[] ;
   private String A1936SVGValor ;
   private String AV78ParmValue ;
   private String AV21html ;
   private String A2EmpNom ;
   private String A1567CliConvenioDescrip ;
   private String AV51selMenuOpcCod ;
   private String A1929MenuOpcCod ;
   private String AV41primero_MenuOpcCod ;
   private String A1931MenuOpcTitulo ;
   private String A1937MenuItemId ;
   private String AV31MenuItemId ;
   private String AV85hormigaURL ;
   private String AV84actualURL ;
   private String AV49SecUserName ;
   private String AV50SecUserPerName ;
   private String AV73SecUserPerLastName ;
   private String AV74RolNombre ;
   private String AV27Language ;
   private String AV33menuURL ;
   private String A2362MenuOpcHormiga ;
   private String AV53URL ;
   private String AV20homeURL ;
   private String AV17headTitle ;
   private String AV35modoTxt ;
   private com.genexus.webpanels.GXWebGrid MPGridopcionesContainer ;
   private com.genexus.webpanels.GXWebRow GridopcionesRow ;
   private com.genexus.webpanels.GXWebColumn GridopcionesColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Ddc_adminag_wc ;
   private com.genexus.internet.HttpRequest AV22Httprequest ;
   private com.genexus.webpanels.WebSession AV57WebSession ;
   private com.genexus.webpanels.GXUserControl ucDdc_adminag ;
   private com.genexus.webpanels.GXUserControl ucCombo_buscarmenu ;
   private com.genexus.webpanels.GXUserControl ucDdo_languagesicons ;
   private com.genexus.webpanels.GXUserControl ucA3llinktabla1 ;
   private com.genexus.webpanels.GXUserControl ucUcmessage ;
   private com.genexus.webpanels.GXUserControl ucUctooltip ;
   private com.genexus.webpanels.GXUserControl ucWwputilities ;
   private com.genexus.webpanels.GXUserControl ucWwpdatepicker ;
   private com.genexuscore.genexus.server.SdtNotificationInfo AV36NotificationInfo ;
   private HTMLChoice cmbavEmpcod ;
   private HTMLChoice cmbavConvecodigo ;
   private com.genexus.webpanels.GXDataAreaControl Contentholder ;
   private IDataStoreProvider pr_default ;
   private byte[] H00OK2_A1923RolId ;
   private byte[] H00OK2_A1925PerfilId ;
   private long[] H00OK2_A1928MenuVerId ;
   private String[] H00OK2_A1933MenuOpcPadre ;
   private boolean[] H00OK2_n1933MenuOpcPadre ;
   private String[] H00OK2_A1935SVGId ;
   private boolean[] H00OK2_n1935SVGId ;
   private String[] H00OK2_A1936SVGValor ;
   private String[] H00OK2_A1929MenuOpcCod ;
   private String[] H00OK2_A1931MenuOpcTitulo ;
   private String[] H00OK2_A1937MenuItemId ;
   private byte[] H00OK2_A1940MenuItemOrd ;
   private String[] H00OK3_A1937MenuItemId ;
   private boolean[] H00OK3_A2363MenuOpcInst ;
   private boolean[] H00OK3_A1938MItemEsMenu ;
   private String[] H00OK3_A1933MenuOpcPadre ;
   private boolean[] H00OK3_n1933MenuOpcPadre ;
   private String[] H00OK3_A1931MenuOpcTitulo ;
   private long[] H00OK3_A1928MenuVerId ;
   private byte[] H00OK3_A1925PerfilId ;
   private byte[] H00OK3_A1923RolId ;
   private String[] H00OK3_A1929MenuOpcCod ;
   private int[] H00OK4_A3CliCod ;
   private String[] H00OK4_A2EmpNom ;
   private short[] H00OK4_A1EmpCod ;
   private boolean[] H00OK5_A2429CliConveEsquemaEs ;
   private int[] H00OK5_A3CliCod ;
   private short[] H00OK5_A1564CliPaiConve ;
   private String[] H00OK5_A1567CliConvenioDescrip ;
   private String[] H00OK5_A1565CliConvenio ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV54urls ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV28LanguagesIconsData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVelop_Menu_Item> AV15DVelop_Menu ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVelop_Menu_Item> GXt_objcol_SdtDVelop_Menu_Item5 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVelop_Menu_Item> GXv_objcol_SdtDVelop_Menu_Item6[] ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV80BuscarMenu_Data ;
   private web.wwpbaseobjects.SdtWWP_DesignSystemSettings AV6WWP_DesignSystemSettings ;
   private web.wwpbaseobjects.SdtWWP_DesignSystemSettings GXt_SdtWWP_DesignSystemSettings14 ;
   private web.wwpbaseobjects.SdtWWP_DesignSystemSettings GXv_SdtWWP_DesignSystemSettings15[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item AV29LanguagesIconsDataItem ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV82ComboCat_DataItem ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV83Combo_DataItem ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV81DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons17 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons18[] ;
}

final  class newmasterpage__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00OK2", "SELECT T1.RolId, T1.PerfilId, T1.MenuVerId, T1.MenuOpcPadre, T1.SVGId, T2.SVGValor, T1.MenuOpcCod, T1.MenuOpcTitulo, T1.MenuItemId, T1.MenuItemOrd FROM (MenuVersionesOpciones T1 LEFT JOIN SVG T2 ON T2.SVGId = T1.SVGId) WHERE (T1.RolId = ? and T1.PerfilId = ? and T1.MenuVerId = ?) AND (T1.MenuOpcPadre IS NULL or (char_length(trim(trailing ' ' from T1.MenuOpcPadre))=0)) ORDER BY T1.RolId, T1.PerfilId, T1.MenuVerId, T1.MenuItemOrd ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00OK3", "SELECT T1.MenuItemId, T1.MenuOpcInst, T2.MItemEsMenu, T1.MenuOpcPadre, T1.MenuOpcTitulo, T1.MenuVerId, T1.PerfilId, T1.RolId, T1.MenuOpcCod FROM (MenuVersionesOpciones T1 INNER JOIN MenuItem T2 ON T2.PerfilId = T1.PerfilId AND T2.MenuItemId = T1.MenuItemId) WHERE (Not T1.MenuOpcPadre IS NULL) AND (LOWER(T1.MenuOpcTitulo) like '%' || LOWER(?)) AND (T1.RolId = ?) AND (T1.PerfilId = ?) AND (T1.MenuVerId = ?) AND (T1.MenuOpcInst = FALSE) AND (T2.MItemEsMenu = FALSE) ORDER BY T1.MenuOpcPadre ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00OK4", "SELECT CliCod, EmpNom, EmpCod FROM Empresa WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00OK5", "SELECT T1.CliConveEsquemaEs, T1.CliCod, T1.CliPaiConve AS CliPaiConve, T2.ConveDescri AS CliConvenioDescrip, T1.CliConvenio AS CliConvenio FROM (ClienteConvenios T1 INNER JOIN Convenio T2 ON T2.PaiCod = T1.CliPaiConve AND T2.ConveCodigo = T1.CliConvenio) WHERE (T1.CliCod = ? and T1.CliPaiConve = ?) AND (T1.CliConveEsquemaEs = FALSE) ORDER BY T1.CliCod, T1.CliPaiConve ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((long[]) buf[6])[0] = rslt.getLong(6);
               ((byte[]) buf[7])[0] = rslt.getByte(7);
               ((byte[]) buf[8])[0] = rslt.getByte(8);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 3 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
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
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setLong(4, ((Number) parms[3]).longValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

