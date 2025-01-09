package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class workwithplusmasterpage_impl extends GXMasterPage
{
   public workwithplusmasterpage_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public workwithplusmasterpage_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( workwithplusmasterpage_impl.class ));
   }

   public workwithplusmasterpage_impl( int remoteHandle ,
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
      nRC_GXsfl_78 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_78"))) ;
      nGXsfl_78_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_78_idx"))) ;
      sGXsfl_78_idx = httpContext.GetPar( "sGXsfl_78_idx") ;
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
      AV116Pgmname = httpContext.GetPar( "Pgmname") ;
      cmbavEmpcod.fromJSonString( httpContext.GetNextPar( ));
      AV5EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV9CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      A2EmpNom = httpContext.GetPar( "EmpNom") ;
      A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
      A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
      A1567CliConvenioDescrip = httpContext.GetPar( "CliConvenioDescrip") ;
      AV62contentHolder_Pgmname = httpContext.GetPar( "contentHolder_Pgmname") ;
      AV72RolId = (byte)(GXutil.lval( httpContext.GetPar( "RolId"))) ;
      AV73PerfilId = (byte)(GXutil.lval( httpContext.GetPar( "PerfilId"))) ;
      AV74MenuVerId = GXutil.lval( httpContext.GetPar( "MenuVerId")) ;
      A1923RolId = (byte)(GXutil.lval( httpContext.GetPar( "RolId"))) ;
      A1925PerfilId = (byte)(GXutil.lval( httpContext.GetPar( "PerfilId"))) ;
      A1928MenuVerId = GXutil.lval( httpContext.GetPar( "MenuVerId")) ;
      A1940MenuItemOrd = (byte)(GXutil.lval( httpContext.GetPar( "MenuItemOrd"))) ;
      A1933MenuOpcPadre = httpContext.GetPar( "MenuOpcPadre") ;
      n1933MenuOpcPadre = false ;
      A1935SVGId = httpContext.GetPar( "SVGId") ;
      n1935SVGId = false ;
      A1936SVGValor = httpContext.GetPar( "SVGValor") ;
      A1941MenuItemImg = httpContext.GetPar( "MenuItemImg") ;
      A1943MenuItemImgNom = httpContext.GetPar( "MenuItemImgNom") ;
      A1942MenuItemImgExt = httpContext.GetPar( "MenuItemImgExt") ;
      A1929MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      AV84primero_MenuOpcCod = httpContext.GetPar( "primero_MenuOpcCod") ;
      A1931MenuOpcTitulo = httpContext.GetPar( "MenuOpcTitulo") ;
      A1937MenuItemId = httpContext.GetPar( "MenuItemId") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV88urls);
      AV81selMenuOpcCod = httpContext.GetPar( "selMenuOpcCod") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridopciones_refresh( AV116Pgmname, AV5EmpCod, AV9CliCod, A3CliCod, A1EmpCod, A2EmpNom, A1564CliPaiConve, A1565CliConvenio, A1567CliConvenioDescrip, AV62contentHolder_Pgmname, AV72RolId, AV73PerfilId, AV74MenuVerId, A1923RolId, A1925PerfilId, A1928MenuVerId, A1940MenuItemOrd, A1933MenuOpcPadre, A1935SVGId, A1936SVGValor, A1941MenuItemImg, A1943MenuItemImgNom, A1942MenuItemImgExt, A1929MenuOpcCod, AV84primero_MenuOpcCod, A1931MenuOpcTitulo, A1937MenuItemId, AV88urls, AV81selMenuOpcCod) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridopciones_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa092( ) ;
         if ( ! isAjaxCallMode( ) )
         {
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            ws092( ) ;
            if ( ! isAjaxCallMode( ) )
            {
               we092( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV9CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONTENTHOLDER_PGMNAME_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV62contentHolder_Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vROLID_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV72RolId), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERFILID_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV73PerfilId), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUVERID_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV74MenuVerId), "ZZZZZZZZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPRIMERO_MENUOPCCOD_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV84primero_MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSELMENUOPCCOD_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV81selMenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLIPAICONVE_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")));
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
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_78", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_78, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", true, "vLANGUAGESICONSDATA_MPAGE", AV25LanguagesIconsData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLANGUAGESICONSDATA_MPAGE", AV25LanguagesIconsData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME_MPAGE", GXutil.rtrim( AV116Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD_MPAGE", GXutil.ltrim( localUtil.ntoc( AV9CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV9CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD_MPAGE", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPCOD_MPAGE", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_EMPCOD_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPNOM_MPAGE", A2EmpNom);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_EMPNOM_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( A2EmpNom, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "CLIPAICONVE_MPAGE", GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLIPAICONVE_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICONVENIO_MPAGE", GXutil.rtrim( A1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICONVENIO_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( A1565CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICONVENIODESCRIP_MPAGE", A1567CliConvenioDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "vCONTENTHOLDER_PGMNAME_MPAGE", GXutil.rtrim( AV62contentHolder_Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONTENTHOLDER_PGMNAME_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV62contentHolder_Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vROLID_MPAGE", GXutil.ltrim( localUtil.ntoc( AV72RolId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vROLID_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV72RolId), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPERFILID_MPAGE", GXutil.ltrim( localUtil.ntoc( AV73PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERFILID_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV73PerfilId), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUVERID_MPAGE", GXutil.ltrim( localUtil.ntoc( AV74MenuVerId, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUVERID_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV74MenuVerId), "ZZZZZZZZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "ROLID_MPAGE", GXutil.ltrim( localUtil.ntoc( A1923RolId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "PERFILID_MPAGE", GXutil.ltrim( localUtil.ntoc( A1925PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUVERID_MPAGE", GXutil.ltrim( localUtil.ntoc( A1928MenuVerId, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUITEMORD_MPAGE", GXutil.ltrim( localUtil.ntoc( A1940MenuItemOrd, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUOPCPADRE_MPAGE", GXutil.rtrim( A1933MenuOpcPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "SVGID_MPAGE", GXutil.rtrim( A1935SVGId));
      web.GxWebStd.gx_hidden_field( httpContext, "SVGVALOR_MPAGE", A1936SVGValor);
      web.GxWebStd.gx_hidden_field( httpContext, "MENUITEMIMG_MPAGE", A1941MenuItemImg);
      web.GxWebStd.gx_hidden_field( httpContext, "MENUITEMIMGNOM_MPAGE", A1943MenuItemImgNom);
      web.GxWebStd.gx_hidden_field( httpContext, "MENUITEMIMGEXT_MPAGE", GXutil.rtrim( A1942MenuItemImgExt));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUOPCCOD_MPAGE", A1929MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "vPRIMERO_MENUOPCCOD_MPAGE", AV84primero_MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPRIMERO_MENUOPCCOD_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV84primero_MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUOPCTITULO_MPAGE", A1931MenuOpcTitulo);
      web.GxWebStd.gx_hidden_field( httpContext, "MENUITEMID_MPAGE", A1937MenuItemId);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", true, "vURLS_MPAGE", AV88urls);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vURLS_MPAGE", AV88urls);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vSELMENUOPCCOD_MPAGE", AV81selMenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSELMENUOPCCOD_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV81selMenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", true, "vNOTIFICATIONINFO_MPAGE", AV66NotificationInfo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vNOTIFICATIONINFO_MPAGE", AV66NotificationInfo);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_LANGUAGESICONS_MPAGE_Caption", GXutil.rtrim( Ddo_languagesicons_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_LANGUAGESICONS_MPAGE_Cls", GXutil.rtrim( Ddo_languagesicons_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_LANGUAGESICONS_MPAGE_Titlecontrolalign", GXutil.rtrim( Ddo_languagesicons_Titlecontrolalign));
      web.GxWebStd.gx_hidden_field( httpContext, "DDC_ADMINAG_MPAGE_Icon", GXutil.rtrim( Ddc_adminag_Icon));
      web.GxWebStd.gx_hidden_field( httpContext, "DDC_ADMINAG_MPAGE_Caption", GXutil.rtrim( Ddc_adminag_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "DDC_ADMINAG_MPAGE_Cls", GXutil.rtrim( Ddc_adminag_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DDC_ADMINAG_MPAGE_Componentwidth", GXutil.ltrim( localUtil.ntoc( Ddc_adminag_Componentwidth, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDC_ADMINAG_MPAGE_Visible", GXutil.booltostr( Ddc_adminag_Visible));
      web.GxWebStd.gx_hidden_field( httpContext, "DDC_ADMINAG_MPAGE_Showloading", GXutil.booltostr( Ddc_adminag_Showloading));
      web.GxWebStd.gx_hidden_field( httpContext, "DDC_ADMINAG_MPAGE_Load", GXutil.rtrim( Ddc_adminag_Load));
      web.GxWebStd.gx_hidden_field( httpContext, "DDC_ADMINAG_MPAGE_Trigger", GXutil.rtrim( Ddc_adminag_Trigger));
      web.GxWebStd.gx_hidden_field( httpContext, "DDC_RUNTIMEDESIGNSETTINGS_MPAGE_Icon", GXutil.rtrim( Ddc_runtimedesignsettings_Icon));
      web.GxWebStd.gx_hidden_field( httpContext, "DDC_RUNTIMEDESIGNSETTINGS_MPAGE_Tooltip", GXutil.rtrim( Ddc_runtimedesignsettings_Tooltip));
      web.GxWebStd.gx_hidden_field( httpContext, "DDC_RUNTIMEDESIGNSETTINGS_MPAGE_Cls", GXutil.rtrim( Ddc_runtimedesignsettings_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DDC_RUNTIMEDESIGNSETTINGS_MPAGE_Componentwidth", GXutil.ltrim( localUtil.ntoc( Ddc_runtimedesignsettings_Componentwidth, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDC_RUNTIMEDESIGNSETTINGS_MPAGE_Visible", GXutil.booltostr( Ddc_runtimedesignsettings_Visible));
      web.GxWebStd.gx_hidden_field( httpContext, "DDC_RUNTIMEDESIGNSETTINGS_MPAGE_Showloading", GXutil.booltostr( Ddc_runtimedesignsettings_Showloading));
      web.GxWebStd.gx_hidden_field( httpContext, "DDC_RUNTIMEDESIGNSETTINGS_MPAGE_Load", GXutil.rtrim( Ddc_runtimedesignsettings_Load));
      web.GxWebStd.gx_hidden_field( httpContext, "DDC_RUNTIMEDESIGNSETTINGS_MPAGE_Trigger", GXutil.rtrim( Ddc_runtimedesignsettings_Trigger));
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
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_LANGUAGESICONS_MPAGE_Activeeventkey", GXutil.rtrim( Ddo_languagesicons_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "vNOTIFICATIONINFO_MPAGE_Id", GXutil.rtrim( AV66NotificationInfo.getgxTv_SdtNotificationInfo_Id()));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_LANGUAGESICONS_MPAGE_Activeeventkey", GXutil.rtrim( Ddo_languagesicons_Activeeventkey));
   }

   public void renderHtmlCloseForm092( )
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
      if ( ! ( WebComp_Ddc_runtimedesignsettings_wc == null ) )
      {
         WebComp_Ddc_runtimedesignsettings_wc.componentjscripts();
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
      httpContext.AddJavascriptSource("wwpbaseobjects/workwithplusmasterpage.js", "?2025187222780", false, true);
      httpContext.writeTextNL( "</body>") ;
      httpContext.writeTextNL( "</html>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.WorkWithPlusMasterPage" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Master Page", "") ;
   }

   public void wb090( )
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 payday_parent_cell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDiv_parent_Internalname, 1, 0, "px", 0, "px", "payday_parent", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDiv_header_Internalname, 1, 0, "px", 0, "px", "payday_header", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableheadercontent_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:space-between;align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablelogo_Internalname, 1, 0, "px", 0, "px", "ML24", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_15_092( true) ;
      }
      else
      {
         wb_table1_15_092( false) ;
      }
      return  ;
   }

   public void wb_table1_15_092e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table2_24_092( true) ;
      }
      else
      {
         wb_table2_24_092( false) ;
      }
      return  ;
   }

   public void wb_table2_24_092e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "hidden-xs", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableempresaconvenio_Internalname, 1, 0, "px", 0, "px", "MR40", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         wb_table3_32_092( true) ;
      }
      else
      {
         wb_table3_32_092( false) ;
      }
      return  ;
   }

   public void wb_table3_32_092e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         wb_table4_37_092( true) ;
      }
      else
      {
         wb_table4_37_092( false) ;
      }
      return  ;
   }

   public void wb_table4_37_092e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "hidden-xs", "left", "top", "", "align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableuserrole_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table5_49_092( true) ;
      }
      else
      {
         wb_table5_49_092( false) ;
      }
      return  ;
   }

   public void wb_table5_49_092e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDiv_subheader_Internalname, 1, 0, "px", 0, "px", "payday_subHeader", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablevolver_pgmname_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblVolversvg_Internalname, lblVolversvg_Caption, lblVolversvg_Link, "", lblVolversvg_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "VolverSVG", 0, "", lblVolversvg_Visible, 1, 0, (short)(1), "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblHtmlhormiga_Internalname, lblHtmlhormiga_Caption, "", "", lblHtmlhormiga_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "TextBlockTitleWWP ML10", 0, "", 1, 1, 0, (short)(1), "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableayuda_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblAyuda_Internalname, lblAyuda_Caption, "", "", lblAyuda_Jsonclick, "'"+""+"'"+",true,"+"'"+"EAYUDA_MPAGE.CLICK_MPAGE."+"'", "", "TextBlock", 5, "", lblAyuda_Visible, 1, 0, (short)(1), "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDiv_menu_Internalname, 1, 0, "px", 0, "px", "payday_menu", "left", "top", "", "", "div");
         /*  Grid Control  */
         MPGridopcionesContainer.SetIsFreestyle(true);
         MPGridopcionesContainer.SetWrapped(nGXWrapped);
         startgridcontrol78( ) ;
      }
      if ( ( wbEnd == 78 ) && ( ! httpContext.isPopUpObject( ) || ShowMPWhenPopUp( ) ) )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_78 = (int)(nGXsfl_78_idx-1) ;
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
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDiv_footer_Internalname, 1, 0, "px", 0, "px", "payday_footer", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablefooter_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockfooter_Internalname, httpContext.getMessage( "payday.ar - copyright - 2024", ""), "", "", lblTextblockfooter_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "FooterText", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDiv_contentplaceholder_Internalname, 1, 0, "px", 0, "px", divDiv_contentplaceholder_Class, "left", "top", "", "", "div");
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
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablemenuconfig_Internalname, 1, 0, "px", 0, "px", "payday_menu_config", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableversion_Internalname, 1, 0, "px", 0, "px", "W100", "left", "top", " "+"data-gx-flex"+" ", "justify-content:center;align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table6_100_092( true) ;
      }
      else
      {
         wb_table6_100_092( false) ;
      }
      return  ;
   }

   public void wb_table6_100_092e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblVersion_Internalname, httpContext.getMessage( "beta 1.0.0", ""), "", "", lblVersion_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
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
         wb_table7_108_092( true) ;
      }
      else
      {
         wb_table7_108_092( false) ;
      }
      return  ;
   }

   public void wb_table7_108_092e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 133,'',true,'" + sGXsfl_78_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavPickerdummyvariable_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavPickerdummyvariable_Internalname, localUtil.format(AV29PickerDummyVariable, "99/99/99"), localUtil.format( AV29PickerDummyVariable, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,133);\"", "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "", "", "", edtavPickerdummyvariable_Jsonclick, 0, "Invisible", "", "", "", "", 1, 1, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavPickerdummyvariable_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(1==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         httpContext.writeTextNL( "</div>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDiv_ddc_runtimedesignsettings_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "MPW0135"+"", GXutil.rtrim( WebComp_Ddc_runtimedesignsettings_wc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpMPW0135"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( bGXsfl_78_Refreshing )
            {
               if ( GXutil.len( WebComp_Ddc_runtimedesignsettings_wc_Component) != 0 )
               {
                  if ( GXutil.strcmp(GXutil.lower( OldDdc_runtimedesignsettings_wc), GXutil.lower( WebComp_Ddc_runtimedesignsettings_wc_Component)) != 0 )
                  {
                     httpContext.ajax_rspStartCmp("gxHTMLWrpMPW0135"+"");
                  }
                  WebComp_Ddc_runtimedesignsettings_wc.componentdraw();
                  if ( GXutil.strcmp(GXutil.lower( OldDdc_runtimedesignsettings_wc), GXutil.lower( WebComp_Ddc_runtimedesignsettings_wc_Component)) != 0 )
                  {
                     httpContext.ajax_rspEndCmp();
                  }
               }
            }
            httpContext.writeText( "</div>") ;
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDiv_ddc_adminag_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "MPW0137"+"", GXutil.rtrim( WebComp_Ddc_adminag_wc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpMPW0137"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( bGXsfl_78_Refreshing )
            {
               if ( GXutil.len( WebComp_Ddc_adminag_wc_Component) != 0 )
               {
                  if ( GXutil.strcmp(GXutil.lower( OldDdc_adminag_wc), GXutil.lower( WebComp_Ddc_adminag_wc_Component)) != 0 )
                  {
                     httpContext.ajax_rspStartCmp("gxHTMLWrpMPW0137"+"");
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
      if ( ( wbEnd == 78 ) && ( ! httpContext.isPopUpObject( ) || ShowMPWhenPopUp( ) ) )
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

   public void start092( )
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
      strup090( ) ;
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

   public void ws092( )
   {
      start092( ) ;
      evt092( ) ;
   }

   public void evt092( )
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
                     else if ( GXutil.strcmp(sEvt, "DDO_LANGUAGESICONS_MPAGE.ONOPTIONCLICKED_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e11092 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "TABLELOGO_MPAGE.CLICK_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e12092 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "VEMPCOD_MPAGE.CONTROLVALUECHANGED_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e13092 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "VCONVECODIGO_MPAGE.CONTROLVALUECHANGED_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e14092 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AYUDA_MPAGE.CLICK_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e15092 ();
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
                        e16092 ();
                        dynload_actions( ) ;
                     }
                  }
                  else
                  {
                     sEvtType = GXutil.right( sEvt, 4) ;
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                     if ( ( GXutil.strcmp(GXutil.left( sEvt, 11), "START_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 13), "REFRESH_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 29), "GRIDOPCIONES_MPAGE.LOAD_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 32), "GRIDOPCIONES_MPAGE.REFRESH_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 19), "ONMESSAGE_GX1_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 11), "ENTER_MPAGE") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 12), "CANCEL_MPAGE") == 0 ) )
                     {
                        nGXsfl_78_idx = (int)(GXutil.lval( sEvtType)) ;
                        sGXsfl_78_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_78_idx), 4, 0), (short)(4), "0") ;
                        subsflControlProps_782( ) ;
                        AV79ImageMenuItemIcon = httpContext.cgiGet( edtavImagemenuitemicon_Internalname) ;
                        httpContext.ajax_rsp_assign_prop("", true, edtavImagemenuitemicon_Internalname, "Bitmap", ((GXutil.strcmp("", AV79ImageMenuItemIcon)==0) ? AV118Imagemenuitemicon_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV79ImageMenuItemIcon))), !bGXsfl_78_Refreshing);
                        httpContext.ajax_rsp_assign_prop("", true, edtavImagemenuitemicon_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV79ImageMenuItemIcon), true);
                        GXCCtl = "vNOTIFICATIONINFO_MPAGE_" + sGXsfl_78_idx ;
                        httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( GXCCtl), AV66NotificationInfo);
                        sEvtType = GXutil.right( sEvt, 1) ;
                        if ( GXutil.strcmp(sEvtType, ".") == 0 )
                        {
                           sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                           if ( GXutil.strcmp(sEvt, "START_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Start */
                              e17092 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "REFRESH_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Refresh */
                              e18092 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "GRIDOPCIONES_MPAGE.LOAD_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              e19092 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "GRIDOPCIONES_MPAGE.REFRESH_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              e20092 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "ONMESSAGE_GX1_MPAGE") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Onmessage_gx1 */
                              e16092 ();
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
                              e16092 ();
                           }
                        }
                        else
                        {
                        }
                     }
                  }
               }
               else if ( GXutil.strcmp(sEvtType, "M") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, GXutil.len( sEvt)-2) ;
                  sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-6) ;
                  nCmpId = (short)(GXutil.lval( sEvtType)) ;
                  if ( nCmpId == 135 )
                  {
                     OldDdc_runtimedesignsettings_wc = httpContext.cgiGet( "MPW0135") ;
                     if ( ( GXutil.len( OldDdc_runtimedesignsettings_wc) == 0 ) || ( GXutil.strcmp(OldDdc_runtimedesignsettings_wc, WebComp_Ddc_runtimedesignsettings_wc_Component) != 0 ) )
                     {
                        WebComp_Ddc_runtimedesignsettings_wc = WebUtils.getWebComponent(getClass(), "web." + OldDdc_runtimedesignsettings_wc + "_impl", remoteHandle, context);
                        WebComp_Ddc_runtimedesignsettings_wc_Component = OldDdc_runtimedesignsettings_wc ;
                     }
                     if ( GXutil.len( WebComp_Ddc_runtimedesignsettings_wc_Component) != 0 )
                     {
                        WebComp_Ddc_runtimedesignsettings_wc.componentprocess("MPW0135", "", sEvt);
                     }
                     WebComp_Ddc_runtimedesignsettings_wc_Component = OldDdc_runtimedesignsettings_wc ;
                  }
                  else if ( nCmpId == 137 )
                  {
                     OldDdc_adminag_wc = httpContext.cgiGet( "MPW0137") ;
                     if ( ( GXutil.len( OldDdc_adminag_wc) == 0 ) || ( GXutil.strcmp(OldDdc_adminag_wc, WebComp_Ddc_adminag_wc_Component) != 0 ) )
                     {
                        WebComp_Ddc_adminag_wc = WebUtils.getWebComponent(getClass(), "web." + OldDdc_adminag_wc + "_impl", remoteHandle, context);
                        WebComp_Ddc_adminag_wc_Component = OldDdc_adminag_wc ;
                     }
                     if ( GXutil.len( WebComp_Ddc_adminag_wc_Component) != 0 )
                     {
                        WebComp_Ddc_adminag_wc.componentprocess("MPW0137", "", sEvt);
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

   public void we092( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm092( ) ;
         }
      }
   }

   public void pa092( )
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
      subsflControlProps_782( ) ;
      while ( nGXsfl_78_idx <= nRC_GXsfl_78 )
      {
         sendrow_782( ) ;
         nGXsfl_78_idx = ((subGridopciones_Islastpage==1)&&(nGXsfl_78_idx+1>subgridopciones_fnc_recordsperpage( )) ? 1 : nGXsfl_78_idx+1) ;
         sGXsfl_78_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_78_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_782( ) ;
      }
      addString( httpContext.getJSONContainerResponse( MPGridopcionesContainer)) ;
      /* End function gxnrGridopciones_newrow */
   }

   public void gxgrgridopciones_refresh( String AV116Pgmname ,
                                         short AV5EmpCod ,
                                         int AV9CliCod ,
                                         int A3CliCod ,
                                         short A1EmpCod ,
                                         String A2EmpNom ,
                                         short A1564CliPaiConve ,
                                         String A1565CliConvenio ,
                                         String A1567CliConvenioDescrip ,
                                         String AV62contentHolder_Pgmname ,
                                         byte AV72RolId ,
                                         byte AV73PerfilId ,
                                         long AV74MenuVerId ,
                                         byte A1923RolId ,
                                         byte A1925PerfilId ,
                                         long A1928MenuVerId ,
                                         byte A1940MenuItemOrd ,
                                         String A1933MenuOpcPadre ,
                                         String A1935SVGId ,
                                         String A1936SVGValor ,
                                         String A1941MenuItemImg ,
                                         String A1943MenuItemImgNom ,
                                         String A1942MenuItemImgExt ,
                                         String A1929MenuOpcCod ,
                                         String AV84primero_MenuOpcCod ,
                                         String A1931MenuOpcTitulo ,
                                         String A1937MenuItemId ,
                                         GXSimpleCollection<String> AV88urls ,
                                         String AV81selMenuOpcCod )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e18092 ();
      GRIDOPCIONES_MPAGE_nCurrentRecord = 0 ;
      rf092( ) ;
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
         AV5EmpCod = (short)(GXutil.lval( cmbavEmpcod.getValidValue(GXutil.trim( GXutil.str( AV5EmpCod, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", true, "AV5EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5EmpCod), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavEmpcod.setValue( GXutil.trim( GXutil.str( AV5EmpCod, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", true, cmbavEmpcod.getInternalname(), "Values", cmbavEmpcod.ToJavascriptSource(), true);
      }
      if ( cmbavConvecodigo.getItemCount() > 0 )
      {
         AV63ConveCodigo = cmbavConvecodigo.getValidValue(AV63ConveCodigo) ;
         httpContext.ajax_rsp_assign_attri("", true, "AV63ConveCodigo", AV63ConveCodigo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConvecodigo.setValue( GXutil.rtrim( AV63ConveCodigo) );
         httpContext.ajax_rsp_assign_prop("", true, cmbavConvecodigo.getInternalname(), "Values", cmbavConvecodigo.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      /* Execute user event: Refresh */
      e18092 ();
      rf092( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV116Pgmname = "WWPBaseObjects.WorkWithPlusMasterPage" ;
      Gx_err = (short)(0) ;
   }

   public void rf092( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( ShowMPWhenPopUp( ) || ! httpContext.isPopUpObject( ) )
      {
         if ( isAjaxCallMode( ) )
         {
            MPGridopcionesContainer.ClearRows();
         }
         wbStart = (short)(78) ;
         e20092 ();
         nGXsfl_78_idx = 1 ;
         sGXsfl_78_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_78_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_782( ) ;
         bGXsfl_78_Refreshing = true ;
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
               if ( GXutil.len( WebComp_Ddc_runtimedesignsettings_wc_Component) != 0 )
               {
                  WebComp_Ddc_runtimedesignsettings_wc.componentstart();
               }
            }
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
         subsflControlProps_782( ) ;
         e19092 ();
         wbEnd = (short)(78) ;
         wb090( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
      }
      bGXsfl_78_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes092( )
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
      AV116Pgmname = "WWPBaseObjects.WorkWithPlusMasterPage" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup090( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e17092 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLANGUAGESICONSDATA_MPAGE"), AV25LanguagesIconsData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vNOTIFICATIONINFO_MPAGE"), AV66NotificationInfo);
         /* Read saved values. */
         nRC_GXsfl_78 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_78"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddo_languagesicons_Caption = httpContext.cgiGet( "DDO_LANGUAGESICONS_MPAGE_Caption") ;
         Ddo_languagesicons_Cls = httpContext.cgiGet( "DDO_LANGUAGESICONS_MPAGE_Cls") ;
         Ddo_languagesicons_Titlecontrolalign = httpContext.cgiGet( "DDO_LANGUAGESICONS_MPAGE_Titlecontrolalign") ;
         Ddc_adminag_Icon = httpContext.cgiGet( "DDC_ADMINAG_MPAGE_Icon") ;
         Ddc_adminag_Caption = httpContext.cgiGet( "DDC_ADMINAG_MPAGE_Caption") ;
         Ddc_adminag_Cls = httpContext.cgiGet( "DDC_ADMINAG_MPAGE_Cls") ;
         Ddc_adminag_Componentwidth = (int)(localUtil.ctol( httpContext.cgiGet( "DDC_ADMINAG_MPAGE_Componentwidth"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddc_adminag_Visible = GXutil.strtobool( httpContext.cgiGet( "DDC_ADMINAG_MPAGE_Visible")) ;
         Ddc_adminag_Showloading = GXutil.strtobool( httpContext.cgiGet( "DDC_ADMINAG_MPAGE_Showloading")) ;
         Ddc_adminag_Load = httpContext.cgiGet( "DDC_ADMINAG_MPAGE_Load") ;
         Ddc_adminag_Trigger = httpContext.cgiGet( "DDC_ADMINAG_MPAGE_Trigger") ;
         Ddc_runtimedesignsettings_Icon = httpContext.cgiGet( "DDC_RUNTIMEDESIGNSETTINGS_MPAGE_Icon") ;
         Ddc_runtimedesignsettings_Tooltip = httpContext.cgiGet( "DDC_RUNTIMEDESIGNSETTINGS_MPAGE_Tooltip") ;
         Ddc_runtimedesignsettings_Cls = httpContext.cgiGet( "DDC_RUNTIMEDESIGNSETTINGS_MPAGE_Cls") ;
         Ddc_runtimedesignsettings_Componentwidth = (int)(localUtil.ctol( httpContext.cgiGet( "DDC_RUNTIMEDESIGNSETTINGS_MPAGE_Componentwidth"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddc_runtimedesignsettings_Visible = GXutil.strtobool( httpContext.cgiGet( "DDC_RUNTIMEDESIGNSETTINGS_MPAGE_Visible")) ;
         Ddc_runtimedesignsettings_Showloading = GXutil.strtobool( httpContext.cgiGet( "DDC_RUNTIMEDESIGNSETTINGS_MPAGE_Showloading")) ;
         Ddc_runtimedesignsettings_Load = httpContext.cgiGet( "DDC_RUNTIMEDESIGNSETTINGS_MPAGE_Load") ;
         Ddc_runtimedesignsettings_Trigger = httpContext.cgiGet( "DDC_RUNTIMEDESIGNSETTINGS_MPAGE_Trigger") ;
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
         /* Read variables values. */
         cmbavEmpcod.setName( cmbavEmpcod.getInternalname() );
         cmbavEmpcod.setValue( httpContext.cgiGet( cmbavEmpcod.getInternalname()) );
         AV5EmpCod = (short)(GXutil.lval( httpContext.cgiGet( cmbavEmpcod.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", true, "AV5EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5EmpCod), 4, 0));
         cmbavConvecodigo.setName( cmbavConvecodigo.getInternalname() );
         cmbavConvecodigo.setValue( httpContext.cgiGet( cmbavConvecodigo.getInternalname()) );
         AV63ConveCodigo = httpContext.cgiGet( cmbavConvecodigo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", true, "AV63ConveCodigo", AV63ConveCodigo);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavPickerdummyvariable_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vPICKERDUMMYVARIABLE_MPAGE");
            GX_FocusControl = edtavPickerdummyvariable_Internalname ;
            httpContext.ajax_rsp_assign_attri("", true, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV29PickerDummyVariable = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", true, "AV29PickerDummyVariable", localUtil.format(AV29PickerDummyVariable, "99/99/99"));
         }
         else
         {
            AV29PickerDummyVariable = localUtil.ctod( httpContext.cgiGet( edtavPickerdummyvariable_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", true, "AV29PickerDummyVariable", localUtil.format(AV29PickerDummyVariable, "99/99/99"));
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
      e17092 ();
      if (returnInSub) return;
   }

   public void e17092( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV116Pgmname, httpContext.getMessage( "start masterpage", "")) ;
      new web.validasesion(remoteHandle, context).execute( "") ;
      GXt_char1 = AV69SecUserName ;
      GXv_char2[0] = GXt_char1 ;
      new web.getusulogged(remoteHandle, context).execute( GXv_char2) ;
      workwithplusmasterpage_impl.this.GXt_char1 = GXv_char2[0] ;
      AV69SecUserName = GXt_char1 ;
      GXv_char2[0] = AV70SecUserPerName ;
      GXv_char3[0] = AV111SecUserPerLastName ;
      GXv_char4[0] = AV112RolNombre ;
      new web.usergetdatosbyname(remoteHandle, context).execute( AV69SecUserName, GXv_char2, GXv_char3, GXv_char4) ;
      workwithplusmasterpage_impl.this.AV70SecUserPerName = GXv_char2[0] ;
      workwithplusmasterpage_impl.this.AV111SecUserPerLastName = GXv_char3[0] ;
      workwithplusmasterpage_impl.this.AV112RolNombre = GXv_char4[0] ;
      lblTextblock2_Caption = AV112RolNombre ;
      httpContext.ajax_rsp_assign_prop("", true, lblTextblock2_Internalname, "Caption", lblTextblock2_Caption, true);
      Ddc_adminag_Caption = GXutil.trim( AV70SecUserPerName)+" "+GXutil.trim( AV111SecUserPerLastName) ;
      ucDdc_adminag.sendProperty(context, "", true, Ddc_adminag_Internalname, "Caption", Ddc_adminag_Caption);
      tblTableidioma_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", true, tblTableidioma_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTableidioma_Visible), 5, 0), true);
      divLayoutmaintable_Class = "MainContainerWithFooter" ;
      httpContext.ajax_rsp_assign_prop("", true, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXt_objcol_SdtDVelop_Menu_Item5 = AV12DVelop_Menu ;
      GXv_objcol_SdtDVelop_Menu_Item6[0] = GXt_objcol_SdtDVelop_Menu_Item5 ;
      new web.wwpbaseobjects.menuoptionsdata(remoteHandle, context).execute( GXv_objcol_SdtDVelop_Menu_Item6) ;
      GXt_objcol_SdtDVelop_Menu_Item5 = GXv_objcol_SdtDVelop_Menu_Item6[0] ;
      AV12DVelop_Menu = GXt_objcol_SdtDVelop_Menu_Item5 ;
      GXv_objcol_SdtDVelop_Menu_Item6[0] = AV12DVelop_Menu ;
      new web.wwpbaseobjects.getmenuauthorizedoptions(remoteHandle, context).execute( GXv_objcol_SdtDVelop_Menu_Item6) ;
      AV12DVelop_Menu = GXv_objcol_SdtDVelop_Menu_Item6[0] ;
      GXt_int7 = AV9CliCod ;
      GXv_int8[0] = GXt_int7 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int8) ;
      workwithplusmasterpage_impl.this.GXt_int7 = GXv_int8[0] ;
      AV9CliCod = GXt_int7 ;
      httpContext.ajax_rsp_assign_attri("", true, "AV9CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV9CliCod), "ZZZZZ9")));
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
         Ddc_runtimedesignsettings_Icon = httpContext.convertURL( context.getHttpContext().getImagePath( "e91796ef-b550-40f1-abb4-86f5bc2cc93c", "", context.getHttpContext().getTheme( ))) ;
         ucDdc_runtimedesignsettings.sendProperty(context, "", true, Ddc_runtimedesignsettings_Internalname, "Icon", Ddc_runtimedesignsettings_Icon);
         /* * Property gximage not supported in */
         /* * Property gximage not supported in */
         /* * Property gximage not supported in */
         /* * Property gximage not supported in */
         /*
            Assignment error:
            ================
            Expression: [ t('"svgCog"',3) ]
            Target    : [ t([ t('Ddc_runtimedesignsettings',3),t('Icon',3) ],29),t(gximage,3) ]
            ForType   : 29
            Type      : []
         */
         /* Object Property */
         if ( true )
         {
            bDynCreated_Ddc_runtimedesignsettings_wc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Ddc_runtimedesignsettings_wc_Component), GXutil.lower( "WWPBaseObjects.WWP_MasterPageRuntimeSettings")) != 0 )
         {
            WebComp_Ddc_runtimedesignsettings_wc = WebUtils.getWebComponent(getClass(), "web.wwpbaseobjects.wwp_masterpageruntimesettings_impl", remoteHandle, context);
            WebComp_Ddc_runtimedesignsettings_wc_Component = "WWPBaseObjects.WWP_MasterPageRuntimeSettings" ;
         }
         if ( GXutil.len( WebComp_Ddc_runtimedesignsettings_wc_Component) != 0 )
         {
            WebComp_Ddc_runtimedesignsettings_wc.setjustcreated();
            WebComp_Ddc_runtimedesignsettings_wc.componentprepare(new Object[] {"MPW0135",""});
            WebComp_Ddc_runtimedesignsettings_wc.componentbind(new Object[] {});
         }
      }
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
            WebComp_Ddc_adminag_wc.componentprepare(new Object[] {"MPW0137",""});
            WebComp_Ddc_adminag_wc.componentbind(new Object[] {});
         }
      }
      AV25LanguagesIconsData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle) ;
      AV26LanguagesIconsDataItem = (web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV26LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( httpContext.getMessage( "English", "") );
      AV26LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon( httpContext.convertURL( context.getHttpContext().getImagePath( "d17b971e-903f-42c1-8eac-c1f10bd50994", "", context.getHttpContext().getTheme( ))) );
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
      AV26LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "EnglishOption" );
      AV26LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
      AV25LanguagesIconsData.add(AV26LanguagesIconsDataItem, 0);
      AV26LanguagesIconsDataItem = (web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV26LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( httpContext.getMessage( "Spanish", "") );
      AV26LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon( httpContext.convertURL( context.getHttpContext().getImagePath( "673a1d61-33cb-4f10-916b-7c9fb6391c49", "", context.getHttpContext().getTheme( ))) );
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
      AV26LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "SpanishOption" );
      AV26LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
      AV25LanguagesIconsData.add(AV26LanguagesIconsDataItem, 0);
      /* Execute user subroutine: 'REFRESCAR EMPRESAS' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'REFRESCAR CONVENIOS' */
      S122 ();
      if (returnInSub) return;
      GXt_int9 = AV5EmpCod ;
      GXv_int10[0] = GXt_int9 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int10) ;
      workwithplusmasterpage_impl.this.GXt_int9 = GXv_int10[0] ;
      AV5EmpCod = GXt_int9 ;
      httpContext.ajax_rsp_assign_attri("", true, "AV5EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5EmpCod), 4, 0));
      GXt_char1 = AV63ConveCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char4) ;
      workwithplusmasterpage_impl.this.GXt_char1 = GXv_char4[0] ;
      AV63ConveCodigo = GXt_char1 ;
      httpContext.ajax_rsp_assign_attri("", true, "AV63ConveCodigo", AV63ConveCodigo);
      GXv_char4[0] = AV56Language ;
      if ( new web.wwpbaseobjects.wwp_loadlanguageandtheme(remoteHandle, context).executeUdp( GXv_char4) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      workwithplusmasterpage_impl.this.AV56Language = GXv_char4[0] ;
      if ( Cond_result )
      {
         httpContext.doAjaxRefresh();
      }
      Ddo_languagesicons_Titlecontrolalign = "Left" ;
      ucDdo_languagesicons.sendProperty(context, "", true, Ddo_languagesicons_Internalname, "TitleControlAlign", Ddo_languagesicons_Titlecontrolalign);
      if ( GXutil.strcmp(AV56Language, "English") == 0 )
      {
         Ddo_languagesicons_Caption = httpContext.getMessage( "EN", "") ;
         ucDdo_languagesicons.sendProperty(context, "", true, Ddo_languagesicons_Internalname, "Caption", Ddo_languagesicons_Caption);
      }
      else if ( GXutil.strcmp(AV56Language, "Spanish") == 0 )
      {
         Ddo_languagesicons_Caption = httpContext.getMessage( "ES", "") ;
         ucDdo_languagesicons.sendProperty(context, "", true, Ddo_languagesicons_Internalname, "Caption", Ddo_languagesicons_Caption);
      }
      if ( GXutil.strcmp(AV17Httprequest.getMethod(), "GET") == 0 )
      {
         GXt_SdtWWP_DesignSystemSettings11 = AV6WWP_DesignSystemSettings;
         GXv_SdtWWP_DesignSystemSettings12[0] = GXt_SdtWWP_DesignSystemSettings11;
         new web.wwpbaseobjects.wwp_getdesignsystemsettings(remoteHandle, context).execute( GXv_SdtWWP_DesignSystemSettings12) ;
         GXt_SdtWWP_DesignSystemSettings11 = GXv_SdtWWP_DesignSystemSettings12[0] ;
         AV6WWP_DesignSystemSettings = GXt_SdtWWP_DesignSystemSettings11;
         this.executeExternalObjectMethod("", true, "gx.core.ds", "setOption", new Object[] {"base-color",AV6WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Basecolor()}, false);
         this.executeExternalObjectMethod("", true, "gx.core.ds", "setOption", new Object[] {"background-color",AV6WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Backgroundstyle()}, false);
         this.executeExternalObjectMethod("", true, "gx.core.ds", "setOption", new Object[] {"font-size",AV6WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Fontsize()}, false);
         this.executeExternalObjectMethod("", true, "WWPActions", "EmpoweredGrids_Refresh", new Object[] {}, false);
      }
      GXt_char1 = "" ;
      GXv_char4[0] = GXt_char1 ;
      new web.svg_emp_masterpage(remoteHandle, context).execute( GXv_char4) ;
      workwithplusmasterpage_impl.this.GXt_char1 = GXv_char4[0] ;
      lblSvgempresa_Caption = GXt_char1 ;
      httpContext.ajax_rsp_assign_prop("", true, lblSvgempresa_Internalname, "Caption", lblSvgempresa_Caption, true);
      GXt_int9 = AV75SecUserId ;
      GXv_int10[0] = GXt_int9 ;
      new web.getusuloggedid(remoteHandle, context).execute( GXv_int10) ;
      workwithplusmasterpage_impl.this.GXt_int9 = GXv_int10[0] ;
      AV75SecUserId = GXt_int9 ;
      GXv_int13[0] = AV72RolId ;
      GXv_int14[0] = AV73PerfilId ;
      GXv_int15[0] = AV74MenuVerId ;
      new web.getusumenu(remoteHandle, context).execute( AV75SecUserId, GXv_int13, GXv_int14, GXv_int15) ;
      workwithplusmasterpage_impl.this.AV72RolId = GXv_int13[0] ;
      workwithplusmasterpage_impl.this.AV73PerfilId = GXv_int14[0] ;
      workwithplusmasterpage_impl.this.AV74MenuVerId = GXv_int15[0] ;
      httpContext.ajax_rsp_assign_attri("", true, "AV72RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV72RolId), 2, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vROLID_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV72RolId), "Z9")));
      httpContext.ajax_rsp_assign_attri("", true, "AV73PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV73PerfilId), 2, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERFILID_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV73PerfilId), "Z9")));
      httpContext.ajax_rsp_assign_attri("", true, "AV74MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV74MenuVerId), 15, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUVERID_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV74MenuVerId), "ZZZZZZZZZZZZZZ9")));
      GXt_char1 = "" ;
      GXt_char16 = "" ;
      GXv_char4[0] = GXt_char16 ;
      new web.svgid_volver(remoteHandle, context).execute( GXv_char4) ;
      workwithplusmasterpage_impl.this.GXt_char16 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char1 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char16, GXv_char3) ;
      workwithplusmasterpage_impl.this.GXt_char1 = GXv_char3[0] ;
      lblVolversvg_Caption = GXt_char1 ;
      httpContext.ajax_rsp_assign_prop("", true, lblVolversvg_Internalname, "Caption", lblVolversvg_Caption, true);
      /* Execute user subroutine: 'MONACO EDITOR' */
      S132 ();
      if (returnInSub) return;
   }

   public void e18092( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV116Pgmname, httpContext.getMessage( "r1", "")) ;
      if ( GXutil.strcmp(AV37WebSession.getValue(httpContext.getMessage( "refrescar_empresas", "")), "") != 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV116Pgmname, httpContext.getMessage( "r2", "")) ;
         /* Execute user subroutine: 'REFRESCAR EMPRESAS' */
         S112 ();
         if (returnInSub) return;
         AV37WebSession.remove(httpContext.getMessage( "refrescar_empresas", ""));
      }
      if ( GXutil.strcmp(AV37WebSession.getValue(httpContext.getMessage( "refrescar_convenios", "")), "") != 0 )
      {
         /* Execute user subroutine: 'REFRESCAR CONVENIOS' */
         S122 ();
         if (returnInSub) return;
         AV37WebSession.remove(httpContext.getMessage( "refrescar_convenios", ""));
      }
      AV62contentHolder_Pgmname = Contentholder.getPgmname() ;
      httpContext.ajax_rsp_assign_attri("", true, "AV62contentHolder_Pgmname", AV62contentHolder_Pgmname);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONTENTHOLDER_PGMNAME_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV62contentHolder_Pgmname, ""))));
      if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV62contentHolder_Pgmname)), httpContext.getMessage( "LEGAJOSWW", "")) == 0 )
      {
         divDiv_contentplaceholder_Class = httpContext.getMessage( "payday_contentPlaceHolderOverflowHidden ", "") ;
         httpContext.ajax_rsp_assign_prop("", true, divDiv_contentplaceholder_Internalname, "Class", divDiv_contentplaceholder_Class, true);
      }
      else
      {
         divDiv_contentplaceholder_Class = httpContext.getMessage( "payday_contentPlaceHolder", "") ;
         httpContext.ajax_rsp_assign_prop("", true, divDiv_contentplaceholder_Internalname, "Class", divDiv_contentplaceholder_Class, true);
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV116Pgmname, httpContext.getMessage( "r3 empcod ", "")+GXutil.trim( GXutil.str( AV5EmpCod, 4, 0))) ;
      if ( ! new web.clienteempresamultiple(remoteHandle, context).executeUdp( AV9CliCod) || ( new web.esconceptosdefault(remoteHandle, context).executeUdp( ) ) || ( GXutil.strSearch( GXutil.upper( GXutil.trim( AV62contentHolder_Pgmname)), httpContext.getMessage( "ENTITYMANAGER", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( GXutil.trim( AV62contentHolder_Pgmname)), httpContext.getMessage( "LEGAJO_", ""), 1) != 0 ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
      }
      else
      {
         cmbavEmpcod.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", true, cmbavEmpcod.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavEmpcod.getEnabled(), 5, 0), true);
      }
      /* Execute user subroutine: 'VISIBILIDAD COMBOS' */
      S142 ();
      if (returnInSub) return;
      GXt_int7 = AV9CliCod ;
      GXv_int8[0] = GXt_int7 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int8) ;
      workwithplusmasterpage_impl.this.GXt_int7 = GXv_int8[0] ;
      AV9CliCod = GXt_int7 ;
      httpContext.ajax_rsp_assign_attri("", true, "AV9CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV9CliCod), "ZZZZZ9")));
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'REFLEJAR OPCION' */
      S162 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavEmpcod.setValue( GXutil.trim( GXutil.str( AV5EmpCod, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", true, cmbavEmpcod.getInternalname(), "Values", cmbavEmpcod.ToJavascriptSource(), true);
      cmbavConvecodigo.setValue( GXutil.rtrim( AV63ConveCodigo) );
      httpContext.ajax_rsp_assign_prop("", true, cmbavConvecodigo.getInternalname(), "Values", cmbavConvecodigo.ToJavascriptSource(), true);
   }

   private void e19092( )
   {
      /* Gridopciones_Load Routine */
      returnInSub = false ;
      /* Using cursor H00092 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV72RolId), Byte.valueOf(AV73PerfilId), Long.valueOf(AV74MenuVerId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1923RolId = H00092_A1923RolId[0] ;
         A1925PerfilId = H00092_A1925PerfilId[0] ;
         A1928MenuVerId = H00092_A1928MenuVerId[0] ;
         A1933MenuOpcPadre = H00092_A1933MenuOpcPadre[0] ;
         n1933MenuOpcPadre = H00092_n1933MenuOpcPadre[0] ;
         A1943MenuItemImgNom = H00092_A1943MenuItemImgNom[0] ;
         A1941MenuItemImg_Filename = A1943MenuItemImgNom ;
         A1942MenuItemImgExt = H00092_A1942MenuItemImgExt[0] ;
         A1941MenuItemImg_Filetype = A1942MenuItemImgExt ;
         A1935SVGId = H00092_A1935SVGId[0] ;
         n1935SVGId = H00092_n1935SVGId[0] ;
         A1936SVGValor = H00092_A1936SVGValor[0] ;
         A1941MenuItemImg = H00092_A1941MenuItemImg[0] ;
         A1929MenuOpcCod = H00092_A1929MenuOpcCod[0] ;
         A1931MenuOpcTitulo = H00092_A1931MenuOpcTitulo[0] ;
         A1937MenuItemId = H00092_A1937MenuItemId[0] ;
         A1940MenuItemOrd = H00092_A1940MenuItemOrd[0] ;
         A1936SVGValor = H00092_A1936SVGValor[0] ;
         if ( ! (GXutil.strcmp("", A1935SVGId)==0) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            edtavImagemenuitemicon_Visible = 0 ;
            lblSvg_opcion_Visible = 1 ;
            lblSvg_opcion_Caption = GXutil.trim( A1936SVGValor) ;
         }
         else
         {
            edtavImagemenuitemicon_Visible = 1 ;
            lblSvg_opcion_Visible = 0 ;
            AV79ImageMenuItemIcon = A1941MenuItemImg ;
            httpContext.ajax_rsp_assign_attri("", true, edtavImagemenuitemicon_Internalname, AV79ImageMenuItemIcon);
            AV118Imagemenuitemicon_GXI = com.genexus.GXDbFile.getUriFromFile( A1943MenuItemImgNom, A1942MenuItemImgExt, A1941MenuItemImg) ;
         }
         if ( GXutil.strcmp(A1929MenuOpcCod, AV84primero_MenuOpcCod) == 0 )
         {
            divGridopcioneslayouttable_Class = httpContext.getMessage( "TableOpcionMenuIzqFocus", "") ;
            httpContext.ajax_rsp_assign_prop("", true, divGridopcioneslayouttable_Internalname, "Class", divGridopcioneslayouttable_Class, !bGXsfl_78_Refreshing);
            lblTextblockopcion_Class = httpContext.getMessage( "TextOptionMenuIzqBaseColor", "") ;
         }
         else
         {
            divGridopcioneslayouttable_Class = httpContext.getMessage( "TableOpcionMenuIzq", "") ;
            httpContext.ajax_rsp_assign_prop("", true, divGridopcioneslayouttable_Internalname, "Class", divGridopcioneslayouttable_Class, !bGXsfl_78_Refreshing);
            lblTextblockopcion_Class = httpContext.getMessage( "TextOptionMenuIzq", "") ;
         }
         lblTextblockopcion_Caption = GXutil.trim( A1931MenuOpcTitulo) ;
         if ( GXutil.strcmp(A1929MenuOpcCod, httpContext.getMessage( "Actualizaciones", "")) == 0 )
         {
            GXv_int10[0] = AV113cant ;
            new web.getcantactualizaciones(remoteHandle, context).execute( AV9CliCod, GXv_int10) ;
            workwithplusmasterpage_impl.this.AV113cant = GXv_int10[0] ;
            if ( AV113cant > 0 )
            {
               lblTextblockopcion_Caption = lblTextblockopcion_Caption+"("+GXutil.trim( GXutil.str( AV113cant, 4, 0))+")" ;
            }
         }
         GXt_char16 = AV80menuURL ;
         GXv_char4[0] = GXt_char16 ;
         new web.getlinkmenu(remoteHandle, context).execute( AV9CliCod, AV5EmpCod, AV73PerfilId, A1937MenuItemId, A1929MenuOpcCod, GXv_char4) ;
         workwithplusmasterpage_impl.this.GXt_char16 = GXv_char4[0] ;
         AV80menuURL = GXt_char16 ;
         AV88urls.add(AV80menuURL, 0);
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(78) ;
         }
         sendrow_782( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_78_Refreshing )
         {
            httpContext.doAjaxLoad(78, GridopcionesRow);
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      A3llinktabla1_Linkrowid = httpContext.getMessage( "MPGridopcionesContainerRow", "") ;
      ucA3llinktabla1.sendProperty(context, "", true, A3llinktabla1_Internalname, "linkRowId", A3llinktabla1_Linkrowid);
      A3llinktabla1_Urls = AV88urls.toJSonString(false) ;
      ucA3llinktabla1.sendProperty(context, "", true, A3llinktabla1_Internalname, "urls", A3llinktabla1_Urls);
      lblJs_Caption = httpContext.getMessage( "<script>  console.log(\"js!\");", "") ;
      httpContext.ajax_rsp_assign_prop("", true, lblJs_Internalname, "Caption", lblJs_Caption, true);
      lblJs_Caption = lblJs_Caption+httpContext.getMessage( "if (typeof setLinksMenuMPGridopcionesContainerRow === \"function\") {", "") ;
      httpContext.ajax_rsp_assign_prop("", true, lblJs_Internalname, "Caption", lblJs_Caption, true);
      lblJs_Caption = lblJs_Caption+httpContext.getMessage( "setLinksMenuMPGridopcionesContainerRow(", "")+AV88urls.toJSonString(false)+");" ;
      httpContext.ajax_rsp_assign_prop("", true, lblJs_Internalname, "Caption", lblJs_Caption, true);
      lblJs_Caption = lblJs_Caption+"}" ;
      httpContext.ajax_rsp_assign_prop("", true, lblJs_Internalname, "Caption", lblJs_Caption, true);
      lblJs_Caption = lblJs_Caption+httpContext.getMessage( "</script>", "") ;
      httpContext.ajax_rsp_assign_prop("", true, lblJs_Internalname, "Caption", lblJs_Caption, true);
      new web.msgdebug_prod(remoteHandle, context).execute( AV116Pgmname, httpContext.getMessage( "load", "")) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", true, "AV88urls", AV88urls);
   }

   public void e11092( )
   {
      /* Ddo_languagesicons_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_languagesicons_Activeeventkey, "EnglishOption") == 0 )
      {
         /* Execute user subroutine: 'DO ENGLISHOPTION' */
         S172 ();
         if (returnInSub) return;
      }
      else if ( GXutil.strcmp(Ddo_languagesicons_Activeeventkey, "SpanishOption") == 0 )
      {
         /* Execute user subroutine: 'DO SPANISHOPTION' */
         S182 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      cmbavEmpcod.setValue( GXutil.trim( GXutil.str( AV5EmpCod, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", true, cmbavEmpcod.getInternalname(), "Values", cmbavEmpcod.ToJavascriptSource(), true);
      cmbavConvecodigo.setValue( GXutil.rtrim( AV63ConveCodigo) );
      httpContext.ajax_rsp_assign_prop("", true, cmbavConvecodigo.getInternalname(), "Values", cmbavConvecodigo.ToJavascriptSource(), true);
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean17 = AV35TempBoolean ;
      GXv_boolean18[0] = GXt_boolean17 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWP_MasterPageTopActionsWC", GXv_boolean18) ;
      workwithplusmasterpage_impl.this.GXt_boolean17 = GXv_boolean18[0] ;
      AV35TempBoolean = GXt_boolean17 ;
      if ( AV35TempBoolean )
      {
         Ddc_runtimedesignsettings_Visible = true ;
         ucDdc_runtimedesignsettings.sendProperty(context, "", true, Ddc_runtimedesignsettings_Internalname, "Visible", GXutil.booltostr( Ddc_runtimedesignsettings_Visible));
      }
      else
      {
         Ddc_runtimedesignsettings_Visible = false ;
         ucDdc_runtimedesignsettings.sendProperty(context, "", true, Ddc_runtimedesignsettings_Internalname, "Visible", GXutil.booltostr( Ddc_runtimedesignsettings_Visible));
      }
      GXt_boolean17 = AV35TempBoolean ;
      GXv_boolean18[0] = GXt_boolean17 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWP_MasterPageTopActionsWC", GXv_boolean18) ;
      workwithplusmasterpage_impl.this.GXt_boolean17 = GXv_boolean18[0] ;
      AV35TempBoolean = GXt_boolean17 ;
      if ( AV35TempBoolean )
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

   public void S172( )
   {
      /* 'DO ENGLISHOPTION' Routine */
      returnInSub = false ;
      if ( setLanguage( "English") == 0 )
      {
         AV37WebSession.setValue("isLangLoaded", "true");
         httpContext.doAjaxRefresh();
      }
   }

   public void S182( )
   {
      /* 'DO SPANISHOPTION' Routine */
      returnInSub = false ;
      if ( setLanguage( "Spanish") == 0 )
      {
         AV37WebSession.setValue("isLangLoaded", "true");
         httpContext.doAjaxRefresh();
      }
   }

   public void e20092( )
   {
      /* Gridopciones_Refresh Routine */
      returnInSub = false ;
      AV88urls.clear();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", true, "AV88urls", AV88urls);
   }

   public void e12092( )
   {
      /* Tablelogo_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'GO HOME' */
      S192 ();
      if (returnInSub) return;
   }

   public void e13092( )
   {
      /* Empcod_Controlvaluechanged Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV116Pgmname, httpContext.getMessage( "changed ", "")+GXutil.trim( GXutil.str( AV5EmpCod, 4, 0))) ;
      if ( (0==AV5EmpCod) )
      {
         callWebObject(formatLink("web.empresaww", new String[] {GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"MenuOpcCod"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
         if ( AV5EmpCod == 9999 )
         {
            callWebObject(formatLink("web.empresa_cabecera", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "INS", ""))),GXutil.URLEncode(GXutil.ltrimstr(AV9CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(0,9,0)),GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "Datos principales", "")))}, new String[] {"TrnMode","CliCod","EmpCod","MenuOpcCod"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV116Pgmname, httpContext.getMessage( "changed set", "")) ;
            new web.setempresa(remoteHandle, context).execute( AV5EmpCod) ;
            httpContext.doAjaxRefresh();
         }
      }
      /*  Sending Event outputs  */
      cmbavEmpcod.setValue( GXutil.trim( GXutil.str( AV5EmpCod, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", true, cmbavEmpcod.getInternalname(), "Values", cmbavEmpcod.ToJavascriptSource(), true);
      cmbavConvecodigo.setValue( GXutil.rtrim( AV63ConveCodigo) );
      httpContext.ajax_rsp_assign_prop("", true, cmbavConvecodigo.getInternalname(), "Values", cmbavConvecodigo.ToJavascriptSource(), true);
   }

   public void e16092( )
   {
      /* Onmessage_gx1 Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV116Pgmname, httpContext.getMessage( "!&NotificationInfo id ", "")+GXutil.trim( AV66NotificationInfo.getgxTv_SdtNotificationInfo_Id())+httpContext.getMessage( " message ", "")+AV66NotificationInfo.getgxTv_SdtNotificationInfo_Message()) ;
      if ( ( GXutil.strSearch( GXutil.upper( AV66NotificationInfo.getgxTv_SdtNotificationInfo_Id()), httpContext.getMessage( "GUARDALIQUIDACION", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( AV66NotificationInfo.getgxTv_SdtNotificationInfo_Id()), httpContext.getMessage( "PROCLIQUIDACION", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( AV66NotificationInfo.getgxTv_SdtNotificationInfo_Id()), httpContext.getMessage( "CONCEPTOSAUXILIARES", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( AV66NotificationInfo.getgxTv_SdtNotificationInfo_Id()), httpContext.getMessage( "DEPENDENCIAS_LSD", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( AV66NotificationInfo.getgxTv_SdtNotificationInfo_Id()), httpContext.getMessage( "CONTRIBUCIONES", ""), 1) != 0 ) || ( GXutil.strSearch( GXutil.upper( AV66NotificationInfo.getgxTv_SdtNotificationInfo_Id()), httpContext.getMessage( "GENERACION_PDFS", ""), 1) != 0 ) )
      {
         this.executeExternalObjectMethod("", true, "GlobalEvents", "MensajeLiquidacion", new Object[] {AV66NotificationInfo.getgxTv_SdtNotificationInfo_Id()}, true);
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV116Pgmname, httpContext.getMessage( "excel 1", "")) ;
         if ( GXutil.strSearch( GXutil.upper( AV66NotificationInfo.getgxTv_SdtNotificationInfo_Id()), httpContext.getMessage( "IMPORTARLEGAJO_EXCEL", ""), 1) != 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV116Pgmname, httpContext.getMessage( "excel 2 ", "")) ;
            this.executeExternalObjectMethod("", true, "GlobalEvents", "importarLegajosExcel", new Object[] {AV66NotificationInfo.getgxTv_SdtNotificationInfo_Id()}, true);
         }
      }
   }

   public void e14092( )
   {
      /* Convecodigo_Controlvaluechanged Routine */
      returnInSub = false ;
      new web.setconvenio(remoteHandle, context).execute( AV63ConveCodigo) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      cmbavEmpcod.setValue( GXutil.trim( GXutil.str( AV5EmpCod, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", true, cmbavEmpcod.getInternalname(), "Values", cmbavEmpcod.ToJavascriptSource(), true);
      cmbavConvecodigo.setValue( GXutil.rtrim( AV63ConveCodigo) );
      httpContext.ajax_rsp_assign_prop("", true, cmbavConvecodigo.getInternalname(), "Values", cmbavConvecodigo.ToJavascriptSource(), true);
   }

   public void e15092( )
   {
      /* Ayuda_Click Routine */
      returnInSub = false ;
      GXv_boolean18[0] = true ;
      new web.opcionsetnomostrar(remoteHandle, context).execute( AV81selMenuOpcCod, GXv_boolean18) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      cmbavEmpcod.setValue( GXutil.trim( GXutil.str( AV5EmpCod, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", true, cmbavEmpcod.getInternalname(), "Values", cmbavEmpcod.ToJavascriptSource(), true);
      cmbavConvecodigo.setValue( GXutil.rtrim( AV63ConveCodigo) );
      httpContext.ajax_rsp_assign_prop("", true, cmbavConvecodigo.getInternalname(), "Values", cmbavConvecodigo.ToJavascriptSource(), true);
   }

   public void S112( )
   {
      /* 'REFRESCAR EMPRESAS' Routine */
      returnInSub = false ;
      cmbavEmpcod.removeAllItems();
      AV58hay = false ;
      /* Using cursor H00093 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV9CliCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A3CliCod = H00093_A3CliCod[0] ;
         A2EmpNom = H00093_A2EmpNom[0] ;
         A1EmpCod = H00093_A1EmpCod[0] ;
         cmbavEmpcod.addItem(GXutil.trim( GXutil.str( A1EmpCod, 4, 0)), GXutil.trim( A2EmpNom), (short)(0));
         AV58hay = true ;
         pr_default.readNext(1);
      }
      pr_default.close(1);
      cmbavEmpcod.setVisible( (AV58hay ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", true, cmbavEmpcod.getInternalname(), "Visible", GXutil.ltrimstr( cmbavEmpcod.getVisible(), 5, 0), true);
      cmbavEmpcod.addItem("9999", httpContext.getMessage( "CREAR EMPRESA...", ""), (short)(0));
   }

   public void S122( )
   {
      /* 'REFRESCAR CONVENIOS' Routine */
      returnInSub = false ;
      cmbavConvecodigo.removeAllItems();
      GXv_boolean18[0] = AV60ClienteConveniador ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV9CliCod, GXv_boolean18) ;
      workwithplusmasterpage_impl.this.AV60ClienteConveniador = GXv_boolean18[0] ;
      if ( ! AV60ClienteConveniador )
      {
         cmbavConvecodigo.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", true, cmbavConvecodigo.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConvecodigo.getVisible(), 5, 0), true);
      }
      else
      {
         AV58hay = false ;
         GXt_int9 = AV67PaiCod ;
         GXv_int10[0] = GXt_int9 ;
         new web.clientegetpais(remoteHandle, context).execute( AV9CliCod, GXv_int10) ;
         workwithplusmasterpage_impl.this.GXt_int9 = GXv_int10[0] ;
         AV67PaiCod = GXt_int9 ;
         httpContext.ajax_rsp_assign_attri("", true, "AV67PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67PaiCod), 4, 0));
         /* Using cursor H00094 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV67PaiCod)});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A3CliCod = H00094_A3CliCod[0] ;
            A1564CliPaiConve = H00094_A1564CliPaiConve[0] ;
            A1567CliConvenioDescrip = H00094_A1567CliConvenioDescrip[0] ;
            A1565CliConvenio = H00094_A1565CliConvenio[0] ;
            A1567CliConvenioDescrip = H00094_A1567CliConvenioDescrip[0] ;
            cmbavConvecodigo.addItem(A1565CliConvenio, GXutil.trim( A1567CliConvenioDescrip), (short)(0));
            AV58hay = true ;
            pr_default.readNext(2);
         }
         pr_default.close(2);
         cmbavConvecodigo.setVisible( (AV58hay ? 1 : 0) );
         httpContext.ajax_rsp_assign_prop("", true, cmbavConvecodigo.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConvecodigo.getVisible(), 5, 0), true);
      }
   }

   public void S142( )
   {
      /* 'VISIBILIDAD COMBOS' Routine */
      returnInSub = false ;
      AV62contentHolder_Pgmname = Contentholder.getPgmname() ;
      httpContext.ajax_rsp_assign_attri("", true, "AV62contentHolder_Pgmname", AV62contentHolder_Pgmname);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONTENTHOLDER_PGMNAME_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV62contentHolder_Pgmname, ""))));
      GXv_boolean18[0] = AV61combosVisiblEs ;
      new web.tablecombosmastervisible(remoteHandle, context).execute( AV62contentHolder_Pgmname, GXv_boolean18) ;
      workwithplusmasterpage_impl.this.AV61combosVisiblEs = GXv_boolean18[0] ;
      tblTablesvgtextempresa_Visible = (AV61combosVisiblEs ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", true, tblTablesvgtextempresa_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTablesvgtextempresa_Visible), 5, 0), true);
   }

   public void S192( )
   {
      /* 'GO HOME' Routine */
      returnInSub = false ;
      GXv_char4[0] = AV78homeURL ;
      GXv_char3[0] = "" ;
      new web.gethome(remoteHandle, context).execute( GXv_char4, GXv_char3) ;
      workwithplusmasterpage_impl.this.AV78homeURL = GXv_char4[0] ;
      callWebObject(formatLink(AV78homeURL, new String[] {}, new String[] {}) );
      httpContext.wjLocDisableFrm = (byte)(0) ;
   }

   public void S162( )
   {
      /* 'REFLEJAR OPCION' Routine */
      returnInSub = false ;
      AV81selMenuOpcCod = AV37WebSession.getValue(httpContext.getMessage( "&selMenuOpcCod", "")) ;
      httpContext.ajax_rsp_assign_attri("", true, "AV81selMenuOpcCod", AV81selMenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSELMENUOPCCOD_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV81selMenuOpcCod, ""))));
      AV85headTitle = "" ;
      if ( GXutil.strcmp(GXutil.trim( GXutil.lower( AV62contentHolder_Pgmname)), httpContext.getMessage( "home_temp", "")) == 0 )
      {
         lblVolversvg_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", true, lblVolversvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblVolversvg_Visible), 5, 0), true);
         lblAyuda_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", true, lblAyuda_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblAyuda_Visible), 5, 0), true);
         lblHtmlhormiga_Caption = httpContext.getMessage( "<span class=\"TextBlockTitleWWP\" id=\"TEXTBLOCKTITLE\">Home</span>", "") ;
         httpContext.ajax_rsp_assign_prop("", true, lblHtmlhormiga_Internalname, "Caption", lblHtmlhormiga_Caption, true);
      }
      else
      {
         lblVolversvg_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", true, lblVolversvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblVolversvg_Visible), 5, 0), true);
         GXv_boolean18[0] = AV86MenuBienveVisible ;
         new web.getmenuopcayudavisible(remoteHandle, context).execute( AV72RolId, AV73PerfilId, AV74MenuVerId, AV81selMenuOpcCod, GXv_boolean18) ;
         workwithplusmasterpage_impl.this.AV86MenuBienveVisible = GXv_boolean18[0] ;
         if ( ! AV86MenuBienveVisible )
         {
            lblAyuda_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", true, lblAyuda_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblAyuda_Visible), 5, 0), true);
            GXt_char16 = "" ;
            GXt_char1 = "" ;
            GXv_char4[0] = GXt_char1 ;
            new web.svgid_ayuda(remoteHandle, context).execute( GXv_char4) ;
            workwithplusmasterpage_impl.this.GXt_char1 = GXv_char4[0] ;
            GXv_char3[0] = GXt_char16 ;
            new web.getsvg(remoteHandle, context).execute( GXt_char1, GXv_char3) ;
            workwithplusmasterpage_impl.this.GXt_char16 = GXv_char3[0] ;
            lblAyuda_Caption = GXt_char16 ;
            httpContext.ajax_rsp_assign_prop("", true, lblAyuda_Internalname, "Caption", lblAyuda_Caption, true);
         }
         else
         {
            lblAyuda_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", true, lblAyuda_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblAyuda_Visible), 5, 0), true);
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV116Pgmname, httpContext.getMessage( "refresh get &selMenuOpcCod ", "")+GXutil.trim( AV81selMenuOpcCod)) ;
         AV83modoTxt = AV37WebSession.getValue(httpContext.getMessage( "&sel_Menu_Modo", "")) ;
         GXv_char4[0] = AV82html ;
         GXv_char3[0] = AV84primero_MenuOpcCod ;
         GXv_char2[0] = AV85headTitle ;
         new web.gethtmlbreadcrumb(remoteHandle, context).execute( AV81selMenuOpcCod, GXv_char4, GXv_char3, GXv_char2) ;
         workwithplusmasterpage_impl.this.AV82html = GXv_char4[0] ;
         workwithplusmasterpage_impl.this.AV84primero_MenuOpcCod = GXv_char3[0] ;
         workwithplusmasterpage_impl.this.AV85headTitle = GXv_char2[0] ;
         httpContext.ajax_rsp_assign_attri("", true, "AV84primero_MenuOpcCod", AV84primero_MenuOpcCod);
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPRIMERO_MENUOPCCOD_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV84primero_MenuOpcCod, ""))));
         lblHtmlhormiga_Caption = GXutil.trim( AV82html) ;
         httpContext.ajax_rsp_assign_prop("", true, lblHtmlhormiga_Internalname, "Caption", lblHtmlhormiga_Caption, true);
         new web.msgdebug_prod(remoteHandle, context).execute( AV116Pgmname, httpContext.getMessage( "&modoTxt ", "")+AV83modoTxt) ;
         if ( (GXutil.strcmp("", AV83modoTxt)==0) )
         {
            GXv_char4[0] = AV77URL ;
            new web.getlinkpadre(remoteHandle, context).execute( AV9CliCod, AV5EmpCod, AV81selMenuOpcCod, GXv_char4) ;
            workwithplusmasterpage_impl.this.AV77URL = GXv_char4[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV116Pgmname, httpContext.getMessage( "busca padre", "")) ;
         }
         else
         {
            GXv_char4[0] = AV77URL ;
            new web.getlinkmenu(remoteHandle, context).execute( AV9CliCod, AV5EmpCod, (byte)(0), "", AV81selMenuOpcCod, GXv_char4) ;
            workwithplusmasterpage_impl.this.AV77URL = GXv_char4[0] ;
         }
         lblVolversvg_Link = AV77URL ;
         httpContext.ajax_rsp_assign_prop("", true, lblVolversvg_Internalname, "Link", lblVolversvg_Link, true);
         (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setHeaderrawhtml( "<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\""+httpContext.convertURL( context.getHttpContext().getImagePath( "76359733-d133-4eeb-8fa0-7d83575ab670", "", context.getHttpContext().getTheme( )))+"\">" );
      }
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setCaption( httpContext.getMessage( "Payday.ar ", "") );
      httpContext.ajax_rsp_assign_prop("", true, "FORM", "Caption", (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getCaption(), true);
      if ( ! (GXutil.strcmp("", AV85headTitle)==0) )
      {
         (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setCaption( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getCaption()+" | "+GXutil.trim( AV85headTitle) );
         httpContext.ajax_rsp_assign_prop("", true, "FORM", "Caption", (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getCaption(), true);
      }
   }

   public void S132( )
   {
      /* 'MONACO EDITOR' Routine */
      returnInSub = false ;
   }

   public void wb_table7_108_092( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblJs_Internalname, lblJs_Caption, "", "", lblJs_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='displayNone'>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblock1_Internalname, httpContext.getMessage( "hola", ""), "", "", lblTextblock1_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "displayNone", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_108_092e( true) ;
      }
      else
      {
         wb_table7_108_092e( false) ;
      }
   }

   public void wb_table6_100_092( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablesettings_Internalname, tblTablesettings_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDdc_runtimedesignsettings.setProperty("Caption", Ddc_runtimedesignsettings_Caption);
         ucDdc_runtimedesignsettings.setProperty("Tooltip", Ddc_runtimedesignsettings_Tooltip);
         ucDdc_runtimedesignsettings.setProperty("Cls", Ddc_runtimedesignsettings_Cls);
         ucDdc_runtimedesignsettings.setProperty("ComponentWidth", Ddc_runtimedesignsettings_Componentwidth);
         ucDdc_runtimedesignsettings.setProperty("ShowLoading", Ddc_runtimedesignsettings_Showloading);
         ucDdc_runtimedesignsettings.setProperty("Load", Ddc_runtimedesignsettings_Load);
         ucDdc_runtimedesignsettings.setProperty("Trigger", Ddc_runtimedesignsettings_Trigger);
         ucDdc_runtimedesignsettings.render(context, "dvelop.gxbootstrap.ddcomponent", Ddc_runtimedesignsettings_Internalname, "DDC_RUNTIMEDESIGNSETTINGS_MPAGEContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table6_100_092e( true) ;
      }
      else
      {
         wb_table6_100_092e( false) ;
      }
   }

   public void wb_table5_49_092( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblHeadercontentoptions_Internalname, tblHeadercontentoptions_Internalname, "", "HeaderContentTable", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Center;text-align:-moz-Center;text-align:-webkit-Center")+"\">") ;
         wb_table8_52_092( true) ;
      }
      else
      {
         wb_table8_52_092( false) ;
      }
      return  ;
   }

   public void wb_table8_52_092e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         wb_table9_57_092( true) ;
      }
      else
      {
         wb_table9_57_092( false) ;
      }
      return  ;
   }

   public void wb_table9_57_092e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_49_092e( true) ;
      }
      else
      {
         wb_table5_49_092e( false) ;
      }
   }

   public void wb_table9_57_092( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTableuser_Internalname, tblTableuser_Internalname, "", "HeaderTable ml25", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Center;text-align:-moz-Center;text-align:-webkit-Center")+"\" class='MasterTopIconsCell'>") ;
         /* User Defined Control */
         ucDdc_adminag.setProperty("Caption", Ddc_adminag_Caption);
         ucDdc_adminag.setProperty("Cls", Ddc_adminag_Cls);
         ucDdc_adminag.setProperty("ComponentWidth", Ddc_adminag_Componentwidth);
         ucDdc_adminag.setProperty("ShowLoading", Ddc_adminag_Showloading);
         ucDdc_adminag.setProperty("Load", Ddc_adminag_Load);
         ucDdc_adminag.setProperty("Trigger", Ddc_adminag_Trigger);
         ucDdc_adminag.render(context, "dvelop.gxbootstrap.ddcomponent", Ddc_adminag_Internalname, "DDC_ADMINAG_MPAGEContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Center;text-align:-moz-Center;text-align:-webkit-Center")+"\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablepuesto_Internalname, 1, 0, "px", 0, "px", "tablePuesto", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblock2_Internalname, lblTextblock2_Caption, "", "", lblTextblock2_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "avatarPuesto", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table9_57_092e( true) ;
      }
      else
      {
         wb_table9_57_092e( false) ;
      }
   }

   public void wb_table8_52_092( boolean wbgen )
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
         ucDdo_languagesicons.setProperty("DropDownOptionsData", AV25LanguagesIconsData);
         ucDdo_languagesicons.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_languagesicons_Internalname, "DDO_LANGUAGESICONS_MPAGEContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table8_52_092e( true) ;
      }
      else
      {
         wb_table8_52_092e( false) ;
      }
   }

   public void wb_table4_37_092( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblTablesvgtextempresa_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         web.GxWebStd.gx_table_start( httpContext, tblTablesvgtextempresa_Internalname, tblTablesvgtextempresa_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavEmpcod.getInternalname(), httpContext.getMessage( "Emp Cod", ""), "gx-form-item TextEmpresaLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 41,'',true,'" + sGXsfl_78_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavEmpcod, cmbavEmpcod.getInternalname(), GXutil.trim( GXutil.str( AV5EmpCod, 4, 0)), 1, cmbavEmpcod.getJsonclick(), 0, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "int", "", cmbavEmpcod.getVisible(), cmbavEmpcod.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "TextEmpresa", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,41);\"", "", true, (byte)(0), "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         cmbavEmpcod.setValue( GXutil.trim( GXutil.str( AV5EmpCod, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", true, cmbavEmpcod.getInternalname(), "Values", cmbavEmpcod.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavConvecodigo.getVisible(), 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConvecodigo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConvecodigo.getInternalname(), httpContext.getMessage( "Convenio", ""), "gx-form-item TextEmpresaLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',true,'" + sGXsfl_78_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConvecodigo, cmbavConvecodigo.getInternalname(), GXutil.rtrim( AV63ConveCodigo), 1, cmbavConvecodigo.getJsonclick(), 0, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "char", "", cmbavConvecodigo.getVisible(), cmbavConvecodigo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "TextEmpresa", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,45);\"", "", true, (byte)(0), "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         cmbavConvecodigo.setValue( GXutil.rtrim( AV63ConveCodigo) );
         httpContext.ajax_rsp_assign_prop("", true, cmbavConvecodigo.getInternalname(), "Values", cmbavConvecodigo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_37_092e( true) ;
      }
      else
      {
         wb_table4_37_092e( false) ;
      }
   }

   public void wb_table3_32_092( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablesvgiconempresa_Internalname, tblTablesvgiconempresa_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblSvgempresa_Internalname, lblSvgempresa_Caption, "", "", lblSvgempresa_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_32_092e( true) ;
      }
      else
      {
         wb_table3_32_092e( false) ;
      }
   }

   public void wb_table2_24_092( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablear_Internalname, tblTablear_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTable_ar_Internalname, 1, 0, "px", 0, "px", "mb5 ml2n", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockar_Internalname, httpContext.getMessage( ".ar", ""), "", "", lblTextblockar_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "logo_textColor_dark", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_24_092e( true) ;
      }
      else
      {
         wb_table2_24_092e( false) ;
      }
   }

   public void wb_table1_15_092( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablepayday_Internalname, tblTablepayday_Internalname, "", "logo_fondo", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablepay_Internalname, 1, 0, "px", 0, "px", "ML10", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblock_pay_Internalname, httpContext.getMessage( "Pay", ""), "", "", lblTextblock_pay_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "logo_textColor_light", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableday_Internalname, 1, 0, "px", 0, "px", "mr10 ml2n", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockday_Internalname, httpContext.getMessage( "Day", ""), "", "", lblTextblockday_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "logo_textColor_light", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_15_092e( true) ;
      }
      else
      {
         wb_table1_15_092e( false) ;
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
      pa092( ) ;
      ws092( ) ;
      we092( ) ;
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
      if ( ! ( WebComp_Ddc_runtimedesignsettings_wc == null ) )
      {
         if ( GXutil.len( WebComp_Ddc_runtimedesignsettings_wc_Component) != 0 )
         {
            WebComp_Ddc_runtimedesignsettings_wc.componentthemes();
         }
      }
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
         httpContext.AddJavascriptSource(GXutil.rtrim( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().item(idxLst)), "?2025187223085", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/workwithplusmasterpage.js", "?2025187223085", false, true);
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

   public void subsflControlProps_782( )
   {
      lblSvg_opcion_Internalname = "SVG_OPCION_MPAGE_"+sGXsfl_78_idx ;
      edtavImagemenuitemicon_Internalname = "vIMAGEMENUITEMICON_MPAGE_"+sGXsfl_78_idx ;
      lblTextblockopcion_Internalname = "TEXTBLOCKOPCION_MPAGE_"+sGXsfl_78_idx ;
   }

   public void subsflControlProps_fel_782( )
   {
      lblSvg_opcion_Internalname = "SVG_OPCION_MPAGE_"+sGXsfl_78_fel_idx ;
      edtavImagemenuitemicon_Internalname = "vIMAGEMENUITEMICON_MPAGE_"+sGXsfl_78_fel_idx ;
      lblTextblockopcion_Internalname = "TEXTBLOCKOPCION_MPAGE_"+sGXsfl_78_fel_idx ;
   }

   public void sendrow_782( )
   {
      subsflControlProps_782( ) ;
      wb090( ) ;
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
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGridopcioneslayouttable_Internalname+"_"+sGXsfl_78_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",divGridopcioneslayouttable_Class,"left","top"," "+"data-gx-flex"+" ","flex-direction:column;justify-content:center;align-items:center;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableiconoopcion_Internalname+"_"+sGXsfl_78_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Flex","left","top"," "+"data-gx-flex"+" ","flex-direction:column;justify-content:flex-end;align-items:center;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Text block */
      GridopcionesRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblSvg_opcion_Internalname,lblSvg_opcion_Caption,"","",lblSvg_opcion_Jsonclick,"'"+""+"'"+",true,"+"'"+"E_MPAGE."+sGXsfl_78_idx+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(lblSvg_opcion_Visible),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(1)});
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
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Attribute/Variable Label */
      GridopcionesRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {"",httpContext.getMessage( "Image Menu Item Icon", ""),"gx-form-item avatarLegajoLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Static Bitmap Variable */
      ClassString = "avatarLegajo" + " " + ((GXutil.strcmp(edtavImagemenuitemicon_gximage, "")==0) ? "" : "GX_Image_"+edtavImagemenuitemicon_gximage+"_Class") ;
      StyleString = "" ;
      AV79ImageMenuItemIcon_IsBlob = (boolean)(((GXutil.strcmp("", AV79ImageMenuItemIcon)==0)&&(GXutil.strcmp("", AV118Imagemenuitemicon_GXI)==0))||!(GXutil.strcmp("", AV79ImageMenuItemIcon)==0)) ;
      sImgUrl = ((GXutil.strcmp("", AV79ImageMenuItemIcon)==0) ? AV118Imagemenuitemicon_GXI : httpContext.getResourceRelative(AV79ImageMenuItemIcon)) ;
      GridopcionesRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavImagemenuitemicon_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(edtavImagemenuitemicon_Visible),Integer.valueOf(edtavImagemenuitemicon_Enabled),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(AV79ImageMenuItemIcon_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
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
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTabletextopcion_Internalname+"_"+sGXsfl_78_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Flex","left","top"," "+"data-gx-flex"+" ","flex-direction:column;align-items:center;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Text block */
      GridopcionesRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTextblockopcion_Internalname,lblTextblockopcion_Caption,"","",lblTextblockopcion_Jsonclick,"'"+""+"'"+",true,"+"'"+"E_MPAGE."+sGXsfl_78_idx+"'","",lblTextblockopcion_Class,Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
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
      send_integrity_lvl_hashes092( ) ;
      GXCCtl = "vPGMNAME_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV116Pgmname));
      GXCCtl = "vCLICOD_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV9CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "CLICOD_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "EMPCOD_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "EMPNOM_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, A2EmpNom);
      GXCCtl = "CLIPAICONVE_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "CLICONVENIO_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( A1565CliConvenio));
      GXCCtl = "CLICONVENIODESCRIP_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, A1567CliConvenioDescrip);
      GXCCtl = "vCONTENTHOLDER_PGMNAME_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV62contentHolder_Pgmname));
      GXCCtl = "vROLID_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV72RolId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vPERFILID_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV73PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMENUVERID_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV74MenuVerId, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "ROLID_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A1923RolId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "PERFILID_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A1925PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "MENUVERID_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A1928MenuVerId, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "MENUITEMORD_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A1940MenuItemOrd, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "MENUOPCPADRE_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( A1933MenuOpcPadre));
      GXCCtl = "SVGID_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( A1935SVGId));
      GXCCtl = "SVGVALOR_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, A1936SVGValor);
      GXCCtl = "MENUITEMIMG_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, A1941MenuItemImg);
      GXCCtl = "MENUITEMIMGNOM_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, A1943MenuItemImgNom);
      GXCCtl = "MENUITEMIMGEXT_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( A1942MenuItemImgExt));
      GXCCtl = "MENUOPCCOD_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, A1929MenuOpcCod);
      GXCCtl = "vPRIMERO_MENUOPCCOD_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, AV84primero_MenuOpcCod);
      GXCCtl = "MENUOPCTITULO_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, A1931MenuOpcTitulo);
      GXCCtl = "MENUITEMID_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, A1937MenuItemId);
      GXCCtl = "vURLS_MPAGE_" + sGXsfl_78_idx ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", true, GXCCtl, AV88urls);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(GXCCtl, AV88urls);
      }
      GXCCtl = "vSELMENUOPCCOD_MPAGE_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, AV81selMenuOpcCod);
      GXCCtl = "vNOTIFICATIONINFO_MPAGE_" + sGXsfl_78_idx ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", true, GXCCtl, AV66NotificationInfo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(GXCCtl, AV66NotificationInfo);
      }
      GXCCtl = "DDO_LANGUAGESICONS_MPAGE_Activeeventkey_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Ddo_languagesicons_Activeeventkey));
      GXCCtl = "vNOTIFICATIONINFO_MPAGE_Id_" + sGXsfl_78_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV66NotificationInfo.getgxTv_SdtNotificationInfo_Id()));
      /* End of Columns property logic. */
      MPGridopcionesContainer.AddRow(GridopcionesRow);
      nGXsfl_78_idx = ((subGridopciones_Islastpage==1)&&(nGXsfl_78_idx+1>subgridopciones_fnc_recordsperpage( )) ? 1 : nGXsfl_78_idx+1) ;
      sGXsfl_78_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_78_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_782( ) ;
      /* End function sendrow_782 */
   }

   public void startgridcontrol78( )
   {
      if ( MPGridopcionesContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"MPGridopcionesContainer"+"DivS\" data-gxgridid=\"78\">") ;
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
         GridopcionesColumn.AddObjectProperty("Value", lblSvg_opcion_Caption);
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         MPGridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesColumn.AddObjectProperty("Value", httpContext.convertURL( AV79ImageMenuItemIcon));
         GridopcionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavImagemenuitemicon_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridopcionesColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavImagemenuitemicon_Visible, (byte)(5), (byte)(0), ".", "")));
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
      lblTextblockday_Internalname = "TEXTBLOCKDAY_MPAGE" ;
      divTableday_Internalname = "TABLEDAY_MPAGE" ;
      tblTablepayday_Internalname = "TABLEPAYDAY_MPAGE" ;
      lblTextblockar_Internalname = "TEXTBLOCKAR_MPAGE" ;
      divTable_ar_Internalname = "TABLE_AR_MPAGE" ;
      tblTablear_Internalname = "TABLEAR_MPAGE" ;
      divTablelogo_Internalname = "TABLELOGO_MPAGE" ;
      lblSvgempresa_Internalname = "SVGEMPRESA_MPAGE" ;
      tblTablesvgiconempresa_Internalname = "TABLESVGICONEMPRESA_MPAGE" ;
      cmbavEmpcod.setInternalname( "vEMPCOD_MPAGE" );
      cmbavConvecodigo.setInternalname( "vCONVECODIGO_MPAGE" );
      tblTablesvgtextempresa_Internalname = "TABLESVGTEXTEMPRESA_MPAGE" ;
      divTableempresaconvenio_Internalname = "TABLEEMPRESACONVENIO_MPAGE" ;
      Ddo_languagesicons_Internalname = "DDO_LANGUAGESICONS_MPAGE" ;
      tblTableidioma_Internalname = "TABLEIDIOMA_MPAGE" ;
      Ddc_adminag_Internalname = "DDC_ADMINAG_MPAGE" ;
      lblTextblock2_Internalname = "TEXTBLOCK2_MPAGE" ;
      divTablepuesto_Internalname = "TABLEPUESTO_MPAGE" ;
      tblTableuser_Internalname = "TABLEUSER_MPAGE" ;
      tblHeadercontentoptions_Internalname = "HEADERCONTENTOPTIONS_MPAGE" ;
      divTableuserrole_Internalname = "TABLEUSERROLE_MPAGE" ;
      divTableheadercontent_Internalname = "TABLEHEADERCONTENT_MPAGE" ;
      divDiv_header_Internalname = "DIV_HEADER_MPAGE" ;
      lblVolversvg_Internalname = "VOLVERSVG_MPAGE" ;
      lblHtmlhormiga_Internalname = "HTMLHORMIGA_MPAGE" ;
      divTablevolver_pgmname_Internalname = "TABLEVOLVER_PGMNAME_MPAGE" ;
      lblAyuda_Internalname = "AYUDA_MPAGE" ;
      divTableayuda_Internalname = "TABLEAYUDA_MPAGE" ;
      divTableactions_Internalname = "TABLEACTIONS_MPAGE" ;
      divDiv_subheader_Internalname = "DIV_SUBHEADER_MPAGE" ;
      lblSvg_opcion_Internalname = "SVG_OPCION_MPAGE" ;
      edtavImagemenuitemicon_Internalname = "vIMAGEMENUITEMICON_MPAGE" ;
      divTableiconoopcion_Internalname = "TABLEICONOOPCION_MPAGE" ;
      lblTextblockopcion_Internalname = "TEXTBLOCKOPCION_MPAGE" ;
      divTabletextopcion_Internalname = "TABLETEXTOPCION_MPAGE" ;
      divGridopcioneslayouttable_Internalname = "GRIDOPCIONESLAYOUTTABLE_MPAGE" ;
      divDiv_menu_Internalname = "DIV_MENU_MPAGE" ;
      lblTextblockfooter_Internalname = "TEXTBLOCKFOOTER_MPAGE" ;
      divTablefooter_Internalname = "TABLEFOOTER_MPAGE" ;
      divDiv_footer_Internalname = "DIV_FOOTER_MPAGE" ;
      divDiv_contentplaceholder_Internalname = "DIV_CONTENTPLACEHOLDER_MPAGE" ;
      Ddc_runtimedesignsettings_Internalname = "DDC_RUNTIMEDESIGNSETTINGS_MPAGE" ;
      tblTablesettings_Internalname = "TABLESETTINGS_MPAGE" ;
      lblVersion_Internalname = "VERSION_MPAGE" ;
      divTableversion_Internalname = "TABLEVERSION_MPAGE" ;
      divTablemenuconfig_Internalname = "TABLEMENUCONFIG_MPAGE" ;
      divDiv_parent_Internalname = "DIV_PARENT_MPAGE" ;
      Ucmessage_Internalname = "UCMESSAGE_MPAGE" ;
      Uctooltip_Internalname = "UCTOOLTIP_MPAGE" ;
      Wwputilities_Internalname = "WWPUTILITIES_MPAGE" ;
      Wwpdatepicker_Internalname = "WWPDATEPICKER_MPAGE" ;
      A3llinktabla1_Internalname = "A3LLINKTABLA1_MPAGE" ;
      lblJs_Internalname = "JS_MPAGE" ;
      lblTextblock1_Internalname = "TEXTBLOCK1_MPAGE" ;
      tblTablausercontrols_Internalname = "TABLAUSERCONTROLS_MPAGE" ;
      divTablemain_Internalname = "TABLEMAIN_MPAGE" ;
      edtavPickerdummyvariable_Internalname = "vPICKERDUMMYVARIABLE_MPAGE" ;
      divDiv_ddc_runtimedesignsettings_Internalname = "DIV_DDC_RUNTIMEDESIGNSETTINGS_MPAGE" ;
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
      lblTextblockopcion_Caption = httpContext.getMessage( "Opción", "") ;
      lblSvg_opcion_Caption = httpContext.getMessage( "svg_opcion", "") ;
      lblTextblockopcion_Class = "TextOptionMenuIzq" ;
      edtavImagemenuitemicon_gximage = "" ;
      edtavImagemenuitemicon_Enabled = 0 ;
      edtavImagemenuitemicon_Visible = 1 ;
      lblSvg_opcion_Caption = httpContext.getMessage( "svg_opcion", "") ;
      lblSvg_opcion_Visible = 1 ;
      cmbavConvecodigo.setJsonclick( "" );
      cmbavConvecodigo.setEnabled( 1 );
      cmbavEmpcod.setJsonclick( "" );
      Ddc_runtimedesignsettings_Caption = "" ;
      tblTablesvgtextempresa_Visible = 1 ;
      cmbavConvecodigo.setVisible( 1 );
      cmbavEmpcod.setVisible( 1 );
      lblJs_Caption = httpContext.getMessage( "js", "") ;
      lblTextblockopcion_Caption = httpContext.getMessage( "Opción", "") ;
      divGridopcioneslayouttable_Class = "TableOpcionMenuIzq" ;
      cmbavEmpcod.setEnabled( 1 );
      lblSvgempresa_Caption = httpContext.getMessage( "svgEmpresa", "") ;
      tblTableidioma_Visible = 1 ;
      lblTextblock2_Caption = httpContext.getMessage( "Administrador", "") ;
      subGridopciones_Backcolorstyle = (byte)(0) ;
      edtavPickerdummyvariable_Jsonclick = "" ;
      divDiv_contentplaceholder_Class = "payday_contentPlaceHolder" ;
      lblAyuda_Caption = httpContext.getMessage( "svg_2", "") ;
      lblAyuda_Visible = 1 ;
      lblHtmlhormiga_Caption = httpContext.getMessage( "htmlHormiga ", "") ;
      lblVolversvg_Link = "" ;
      lblVolversvg_Caption = httpContext.getMessage( "svg_1", "") ;
      lblVolversvg_Visible = 1 ;
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
      Ddc_runtimedesignsettings_Trigger = "Hover" ;
      Ddc_runtimedesignsettings_Load = "OnWebPanelLoad" ;
      Ddc_runtimedesignsettings_Showloading = GXutil.toBoolean( 0) ;
      Ddc_runtimedesignsettings_Visible = GXutil.toBoolean( -1) ;
      Ddc_runtimedesignsettings_Componentwidth = 240 ;
      Ddc_runtimedesignsettings_Cls = "DropDownOptionsNoBackHover mt11n" ;
      Ddc_runtimedesignsettings_Tooltip = "WWP_StyleCustomizations" ;
      Ddc_runtimedesignsettings_Icon = "" ;
      Ddc_adminag_Trigger = "Hover" ;
      Ddc_adminag_Load = "OnWebPanelLoad" ;
      Ddc_adminag_Showloading = GXutil.toBoolean( 0) ;
      Ddc_adminag_Visible = GXutil.toBoolean( -1) ;
      Ddc_adminag_Componentwidth = 260 ;
      Ddc_adminag_Cls = "DropDownOptionsNoBackHover" ;
      Ddc_adminag_Caption = httpContext.getMessage( "Leonardo Lucas Osso", "") ;
      Ddc_adminag_Icon = "" ;
      Ddo_languagesicons_Titlecontrolalign = "Automatic" ;
      Ddo_languagesicons_Cls = "DropDownOptionsHeader" ;
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
         AV5EmpCod = (short)(GXutil.lval( cmbavEmpcod.getValidValue(GXutil.trim( GXutil.str( AV5EmpCod, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", true, "AV5EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5EmpCod), 4, 0));
      }
      cmbavConvecodigo.setName( "vCONVECODIGO_MPAGE" );
      cmbavConvecodigo.setWebtags( "" );
      if ( cmbavConvecodigo.getItemCount() > 0 )
      {
         AV63ConveCodigo = cmbavConvecodigo.getValidValue(AV63ConveCodigo) ;
         httpContext.ajax_rsp_assign_attri("", true, "AV63ConveCodigo", AV63ConveCodigo);
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH_MPAGE","{handler:'refresh',iparms:[{av:'GRIDOPCIONES_MPAGE_nFirstRecordOnPage'},{av:'GRIDOPCIONES_MPAGE_nEOF'},{av:'A1923RolId',fld:'ROLID_MPAGE',pic:'Z9'},{av:'A1925PerfilId',fld:'PERFILID_MPAGE',pic:'Z9'},{av:'A1928MenuVerId',fld:'MENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9'},{av:'A1940MenuItemOrd',fld:'MENUITEMORD_MPAGE',pic:'Z9'},{av:'A1933MenuOpcPadre',fld:'MENUOPCPADRE_MPAGE',pic:''},{av:'A1935SVGId',fld:'SVGID_MPAGE',pic:''},{av:'A1936SVGValor',fld:'SVGVALOR_MPAGE',pic:''},{av:'A1941MenuItemImg',fld:'MENUITEMIMG_MPAGE',pic:''},{av:'A1943MenuItemImgNom',fld:'MENUITEMIMGNOM_MPAGE',pic:''},{av:'A1942MenuItemImgExt',fld:'MENUITEMIMGEXT_MPAGE',pic:''},{av:'A1929MenuOpcCod',fld:'MENUOPCCOD_MPAGE',pic:''},{av:'A1931MenuOpcTitulo',fld:'MENUOPCTITULO_MPAGE',pic:''},{av:'A1937MenuItemId',fld:'MENUITEMID_MPAGE',pic:''},{av:'AV88urls',fld:'vURLS_MPAGE',pic:''},{av:'AV116Pgmname',fld:'vPGMNAME_MPAGE',pic:''},{av:'cmbavEmpcod'},{av:'AV5EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'A3CliCod',fld:'CLICOD_MPAGE',pic:'ZZZZZ9'},{av:'A1567CliConvenioDescrip',fld:'CLICONVENIODESCRIP_MPAGE',pic:''},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9',hsh:true},{av:'AV62contentHolder_Pgmname',fld:'vCONTENTHOLDER_PGMNAME_MPAGE',pic:'',hsh:true},{av:'AV72RolId',fld:'vROLID_MPAGE',pic:'Z9',hsh:true},{av:'AV73PerfilId',fld:'vPERFILID_MPAGE',pic:'Z9',hsh:true},{av:'AV74MenuVerId',fld:'vMENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9',hsh:true},{av:'AV84primero_MenuOpcCod',fld:'vPRIMERO_MENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'AV81selMenuOpcCod',fld:'vSELMENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE_MPAGE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO_MPAGE',pic:'',hsh:true},{av:'A1EmpCod',fld:'EMPCOD_MPAGE',pic:'ZZZ9',hsh:true},{av:'A2EmpNom',fld:'EMPNOM_MPAGE',pic:'@!',hsh:true}]");
      setEventMetadata("REFRESH_MPAGE",",oparms:[{av:'AV62contentHolder_Pgmname',fld:'vCONTENTHOLDER_PGMNAME_MPAGE',pic:'',hsh:true},{av:'divDiv_contentplaceholder_Class',ctrl:'DIV_CONTENTPLACEHOLDER_MPAGE',prop:'Class'},{av:'cmbavEmpcod'},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9',hsh:true},{av:'AV5EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'cmbavConvecodigo'},{av:'AV63ConveCodigo',fld:'vCONVECODIGO_MPAGE',pic:''},{av:'AV67PaiCod',fld:'vPAICOD_MPAGE',pic:'ZZZ9'},{av:'tblTablesvgtextempresa_Visible',ctrl:'TABLESVGTEXTEMPRESA_MPAGE',prop:'Visible'},{av:'Ddc_runtimedesignsettings_Visible',ctrl:'DDC_RUNTIMEDESIGNSETTINGS_MPAGE',prop:'Visible'},{av:'Ddc_adminag_Visible',ctrl:'DDC_ADMINAG_MPAGE',prop:'Visible'},{av:'AV81selMenuOpcCod',fld:'vSELMENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'lblAyuda_Caption',ctrl:'AYUDA_MPAGE',prop:'Caption'},{av:'AV84primero_MenuOpcCod',fld:'vPRIMERO_MENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'lblVolversvg_Link',ctrl:'VOLVERSVG_MPAGE',prop:'Link'},{ctrl:'FORM_MPAGE',prop:'Headerrawhtml'},{av:'lblVolversvg_Visible',ctrl:'VOLVERSVG_MPAGE',prop:'Visible'},{av:'lblAyuda_Visible',ctrl:'AYUDA_MPAGE',prop:'Visible'},{av:'lblHtmlhormiga_Caption',ctrl:'HTMLHORMIGA_MPAGE',prop:'Caption'},{ctrl:'FORM_MPAGE',prop:'Caption'}]}");
      setEventMetadata("GRIDOPCIONES_MPAGE.LOAD_MPAGE","{handler:'e19092',iparms:[{av:'A1923RolId',fld:'ROLID_MPAGE',pic:'Z9'},{av:'A1925PerfilId',fld:'PERFILID_MPAGE',pic:'Z9'},{av:'A1928MenuVerId',fld:'MENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9'},{av:'A1940MenuItemOrd',fld:'MENUITEMORD_MPAGE',pic:'Z9'},{av:'AV72RolId',fld:'vROLID_MPAGE',pic:'Z9',hsh:true},{av:'AV73PerfilId',fld:'vPERFILID_MPAGE',pic:'Z9',hsh:true},{av:'AV74MenuVerId',fld:'vMENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9',hsh:true},{av:'A1933MenuOpcPadre',fld:'MENUOPCPADRE_MPAGE',pic:''},{av:'A1935SVGId',fld:'SVGID_MPAGE',pic:''},{av:'A1936SVGValor',fld:'SVGVALOR_MPAGE',pic:''},{av:'A1941MenuItemImg',fld:'MENUITEMIMG_MPAGE',pic:''},{av:'A1943MenuItemImgNom',fld:'MENUITEMIMGNOM_MPAGE',pic:''},{av:'A1942MenuItemImgExt',fld:'MENUITEMIMGEXT_MPAGE',pic:''},{av:'A1929MenuOpcCod',fld:'MENUOPCCOD_MPAGE',pic:''},{av:'AV84primero_MenuOpcCod',fld:'vPRIMERO_MENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'A1931MenuOpcTitulo',fld:'MENUOPCTITULO_MPAGE',pic:''},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9',hsh:true},{av:'cmbavEmpcod'},{av:'AV5EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'A1937MenuItemId',fld:'MENUITEMID_MPAGE',pic:''},{av:'AV88urls',fld:'vURLS_MPAGE',pic:''},{av:'AV116Pgmname',fld:'vPGMNAME_MPAGE',pic:''}]");
      setEventMetadata("GRIDOPCIONES_MPAGE.LOAD_MPAGE",",oparms:[{av:'lblSvg_opcion_Caption',ctrl:'SVG_OPCION_MPAGE',prop:'Caption'},{av:'AV79ImageMenuItemIcon',fld:'vIMAGEMENUITEMICON_MPAGE',pic:''},{av:'edtavImagemenuitemicon_Visible',ctrl:'vIMAGEMENUITEMICON_MPAGE',prop:'Visible'},{av:'lblSvg_opcion_Visible',ctrl:'SVG_OPCION_MPAGE',prop:'Visible'},{av:'divGridopcioneslayouttable_Class',ctrl:'GRIDOPCIONESLAYOUTTABLE_MPAGE',prop:'Class'},{av:'lblTextblockopcion_Class',ctrl:'TEXTBLOCKOPCION_MPAGE',prop:'Class'},{av:'lblTextblockopcion_Caption',ctrl:'TEXTBLOCKOPCION_MPAGE',prop:'Caption'},{av:'AV88urls',fld:'vURLS_MPAGE',pic:''},{av:'A3llinktabla1_Linkrowid',ctrl:'A3LLINKTABLA1_MPAGE',prop:'linkRowId'},{av:'A3llinktabla1_Urls',ctrl:'A3LLINKTABLA1_MPAGE',prop:'urls'},{av:'lblJs_Caption',ctrl:'JS_MPAGE',prop:'Caption'}]}");
      setEventMetadata("DDO_LANGUAGESICONS_MPAGE.ONOPTIONCLICKED_MPAGE","{handler:'e11092',iparms:[{av:'Ddo_languagesicons_Activeeventkey',ctrl:'DDO_LANGUAGESICONS_MPAGE',prop:'ActiveEventKey'},{av:'GRIDOPCIONES_MPAGE_nFirstRecordOnPage'},{av:'GRIDOPCIONES_MPAGE_nEOF'},{av:'AV116Pgmname',fld:'vPGMNAME_MPAGE',pic:''},{av:'cmbavEmpcod'},{av:'AV5EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9',hsh:true},{av:'A3CliCod',fld:'CLICOD_MPAGE',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD_MPAGE',pic:'ZZZ9',hsh:true},{av:'A2EmpNom',fld:'EMPNOM_MPAGE',pic:'@!',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE_MPAGE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO_MPAGE',pic:'',hsh:true},{av:'A1567CliConvenioDescrip',fld:'CLICONVENIODESCRIP_MPAGE',pic:''},{av:'AV62contentHolder_Pgmname',fld:'vCONTENTHOLDER_PGMNAME_MPAGE',pic:'',hsh:true},{av:'AV72RolId',fld:'vROLID_MPAGE',pic:'Z9',hsh:true},{av:'AV73PerfilId',fld:'vPERFILID_MPAGE',pic:'Z9',hsh:true},{av:'AV74MenuVerId',fld:'vMENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9',hsh:true},{av:'A1923RolId',fld:'ROLID_MPAGE',pic:'Z9'},{av:'A1925PerfilId',fld:'PERFILID_MPAGE',pic:'Z9'},{av:'A1928MenuVerId',fld:'MENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9'},{av:'A1940MenuItemOrd',fld:'MENUITEMORD_MPAGE',pic:'Z9'},{av:'A1933MenuOpcPadre',fld:'MENUOPCPADRE_MPAGE',pic:''},{av:'A1935SVGId',fld:'SVGID_MPAGE',pic:''},{av:'A1936SVGValor',fld:'SVGVALOR_MPAGE',pic:''},{av:'A1941MenuItemImg',fld:'MENUITEMIMG_MPAGE',pic:''},{av:'A1943MenuItemImgNom',fld:'MENUITEMIMGNOM_MPAGE',pic:''},{av:'A1942MenuItemImgExt',fld:'MENUITEMIMGEXT_MPAGE',pic:''},{av:'A1929MenuOpcCod',fld:'MENUOPCCOD_MPAGE',pic:''},{av:'AV84primero_MenuOpcCod',fld:'vPRIMERO_MENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'A1931MenuOpcTitulo',fld:'MENUOPCTITULO_MPAGE',pic:''},{av:'A1937MenuItemId',fld:'MENUITEMID_MPAGE',pic:''},{av:'AV88urls',fld:'vURLS_MPAGE',pic:''},{av:'AV81selMenuOpcCod',fld:'vSELMENUOPCCOD_MPAGE',pic:'',hsh:true}]");
      setEventMetadata("DDO_LANGUAGESICONS_MPAGE.ONOPTIONCLICKED_MPAGE",",oparms:[{av:'AV62contentHolder_Pgmname',fld:'vCONTENTHOLDER_PGMNAME_MPAGE',pic:'',hsh:true},{av:'divDiv_contentplaceholder_Class',ctrl:'DIV_CONTENTPLACEHOLDER_MPAGE',prop:'Class'},{av:'cmbavEmpcod'},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9',hsh:true},{av:'AV5EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'cmbavConvecodigo'},{av:'AV63ConveCodigo',fld:'vCONVECODIGO_MPAGE',pic:''},{av:'AV67PaiCod',fld:'vPAICOD_MPAGE',pic:'ZZZ9'},{av:'tblTablesvgtextempresa_Visible',ctrl:'TABLESVGTEXTEMPRESA_MPAGE',prop:'Visible'},{av:'Ddc_runtimedesignsettings_Visible',ctrl:'DDC_RUNTIMEDESIGNSETTINGS_MPAGE',prop:'Visible'},{av:'Ddc_adminag_Visible',ctrl:'DDC_ADMINAG_MPAGE',prop:'Visible'},{av:'AV81selMenuOpcCod',fld:'vSELMENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'lblAyuda_Caption',ctrl:'AYUDA_MPAGE',prop:'Caption'},{av:'AV84primero_MenuOpcCod',fld:'vPRIMERO_MENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'lblVolversvg_Link',ctrl:'VOLVERSVG_MPAGE',prop:'Link'},{ctrl:'FORM_MPAGE',prop:'Headerrawhtml'},{av:'lblVolversvg_Visible',ctrl:'VOLVERSVG_MPAGE',prop:'Visible'},{av:'lblAyuda_Visible',ctrl:'AYUDA_MPAGE',prop:'Visible'},{av:'lblHtmlhormiga_Caption',ctrl:'HTMLHORMIGA_MPAGE',prop:'Caption'},{ctrl:'FORM_MPAGE',prop:'Caption'}]}");
      setEventMetadata("GRIDOPCIONES_MPAGE.REFRESH_MPAGE","{handler:'e20092',iparms:[]");
      setEventMetadata("GRIDOPCIONES_MPAGE.REFRESH_MPAGE",",oparms:[{av:'AV88urls',fld:'vURLS_MPAGE',pic:''}]}");
      setEventMetadata("TABLELOGO_MPAGE.CLICK_MPAGE","{handler:'e12092',iparms:[]");
      setEventMetadata("TABLELOGO_MPAGE.CLICK_MPAGE",",oparms:[]}");
      setEventMetadata("VEMPCOD_MPAGE.CONTROLVALUECHANGED_MPAGE","{handler:'e13092',iparms:[{av:'GRIDOPCIONES_MPAGE_nFirstRecordOnPage'},{av:'GRIDOPCIONES_MPAGE_nEOF'},{av:'AV116Pgmname',fld:'vPGMNAME_MPAGE',pic:''},{av:'cmbavEmpcod'},{av:'AV5EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9',hsh:true},{av:'A3CliCod',fld:'CLICOD_MPAGE',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD_MPAGE',pic:'ZZZ9',hsh:true},{av:'A2EmpNom',fld:'EMPNOM_MPAGE',pic:'@!',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE_MPAGE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO_MPAGE',pic:'',hsh:true},{av:'A1567CliConvenioDescrip',fld:'CLICONVENIODESCRIP_MPAGE',pic:''},{av:'AV62contentHolder_Pgmname',fld:'vCONTENTHOLDER_PGMNAME_MPAGE',pic:'',hsh:true},{av:'AV72RolId',fld:'vROLID_MPAGE',pic:'Z9',hsh:true},{av:'AV73PerfilId',fld:'vPERFILID_MPAGE',pic:'Z9',hsh:true},{av:'AV74MenuVerId',fld:'vMENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9',hsh:true},{av:'A1923RolId',fld:'ROLID_MPAGE',pic:'Z9'},{av:'A1925PerfilId',fld:'PERFILID_MPAGE',pic:'Z9'},{av:'A1928MenuVerId',fld:'MENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9'},{av:'A1940MenuItemOrd',fld:'MENUITEMORD_MPAGE',pic:'Z9'},{av:'A1933MenuOpcPadre',fld:'MENUOPCPADRE_MPAGE',pic:''},{av:'A1935SVGId',fld:'SVGID_MPAGE',pic:''},{av:'A1936SVGValor',fld:'SVGVALOR_MPAGE',pic:''},{av:'A1941MenuItemImg',fld:'MENUITEMIMG_MPAGE',pic:''},{av:'A1943MenuItemImgNom',fld:'MENUITEMIMGNOM_MPAGE',pic:''},{av:'A1942MenuItemImgExt',fld:'MENUITEMIMGEXT_MPAGE',pic:''},{av:'A1929MenuOpcCod',fld:'MENUOPCCOD_MPAGE',pic:''},{av:'AV84primero_MenuOpcCod',fld:'vPRIMERO_MENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'A1931MenuOpcTitulo',fld:'MENUOPCTITULO_MPAGE',pic:''},{av:'A1937MenuItemId',fld:'MENUITEMID_MPAGE',pic:''},{av:'AV88urls',fld:'vURLS_MPAGE',pic:''},{av:'AV81selMenuOpcCod',fld:'vSELMENUOPCCOD_MPAGE',pic:'',hsh:true}]");
      setEventMetadata("VEMPCOD_MPAGE.CONTROLVALUECHANGED_MPAGE",",oparms:[{av:'AV62contentHolder_Pgmname',fld:'vCONTENTHOLDER_PGMNAME_MPAGE',pic:'',hsh:true},{av:'divDiv_contentplaceholder_Class',ctrl:'DIV_CONTENTPLACEHOLDER_MPAGE',prop:'Class'},{av:'cmbavEmpcod'},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9',hsh:true},{av:'AV5EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'cmbavConvecodigo'},{av:'AV63ConveCodigo',fld:'vCONVECODIGO_MPAGE',pic:''},{av:'AV67PaiCod',fld:'vPAICOD_MPAGE',pic:'ZZZ9'},{av:'tblTablesvgtextempresa_Visible',ctrl:'TABLESVGTEXTEMPRESA_MPAGE',prop:'Visible'},{av:'Ddc_runtimedesignsettings_Visible',ctrl:'DDC_RUNTIMEDESIGNSETTINGS_MPAGE',prop:'Visible'},{av:'Ddc_adminag_Visible',ctrl:'DDC_ADMINAG_MPAGE',prop:'Visible'},{av:'AV81selMenuOpcCod',fld:'vSELMENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'lblAyuda_Caption',ctrl:'AYUDA_MPAGE',prop:'Caption'},{av:'AV84primero_MenuOpcCod',fld:'vPRIMERO_MENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'lblVolversvg_Link',ctrl:'VOLVERSVG_MPAGE',prop:'Link'},{ctrl:'FORM_MPAGE',prop:'Headerrawhtml'},{av:'lblVolversvg_Visible',ctrl:'VOLVERSVG_MPAGE',prop:'Visible'},{av:'lblAyuda_Visible',ctrl:'AYUDA_MPAGE',prop:'Visible'},{av:'lblHtmlhormiga_Caption',ctrl:'HTMLHORMIGA_MPAGE',prop:'Caption'},{ctrl:'FORM_MPAGE',prop:'Caption'}]}");
      setEventMetadata("VCONVECODIGO_MPAGE.CONTROLVALUECHANGED_MPAGE","{handler:'e14092',iparms:[{av:'GRIDOPCIONES_MPAGE_nFirstRecordOnPage'},{av:'GRIDOPCIONES_MPAGE_nEOF'},{av:'AV116Pgmname',fld:'vPGMNAME_MPAGE',pic:''},{av:'cmbavEmpcod'},{av:'AV5EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9',hsh:true},{av:'A3CliCod',fld:'CLICOD_MPAGE',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD_MPAGE',pic:'ZZZ9',hsh:true},{av:'A2EmpNom',fld:'EMPNOM_MPAGE',pic:'@!',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE_MPAGE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO_MPAGE',pic:'',hsh:true},{av:'A1567CliConvenioDescrip',fld:'CLICONVENIODESCRIP_MPAGE',pic:''},{av:'AV62contentHolder_Pgmname',fld:'vCONTENTHOLDER_PGMNAME_MPAGE',pic:'',hsh:true},{av:'AV72RolId',fld:'vROLID_MPAGE',pic:'Z9',hsh:true},{av:'AV73PerfilId',fld:'vPERFILID_MPAGE',pic:'Z9',hsh:true},{av:'AV74MenuVerId',fld:'vMENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9',hsh:true},{av:'A1923RolId',fld:'ROLID_MPAGE',pic:'Z9'},{av:'A1925PerfilId',fld:'PERFILID_MPAGE',pic:'Z9'},{av:'A1928MenuVerId',fld:'MENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9'},{av:'A1940MenuItemOrd',fld:'MENUITEMORD_MPAGE',pic:'Z9'},{av:'A1933MenuOpcPadre',fld:'MENUOPCPADRE_MPAGE',pic:''},{av:'A1935SVGId',fld:'SVGID_MPAGE',pic:''},{av:'A1936SVGValor',fld:'SVGVALOR_MPAGE',pic:''},{av:'A1941MenuItemImg',fld:'MENUITEMIMG_MPAGE',pic:''},{av:'A1943MenuItemImgNom',fld:'MENUITEMIMGNOM_MPAGE',pic:''},{av:'A1942MenuItemImgExt',fld:'MENUITEMIMGEXT_MPAGE',pic:''},{av:'A1929MenuOpcCod',fld:'MENUOPCCOD_MPAGE',pic:''},{av:'AV84primero_MenuOpcCod',fld:'vPRIMERO_MENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'A1931MenuOpcTitulo',fld:'MENUOPCTITULO_MPAGE',pic:''},{av:'A1937MenuItemId',fld:'MENUITEMID_MPAGE',pic:''},{av:'AV88urls',fld:'vURLS_MPAGE',pic:''},{av:'AV81selMenuOpcCod',fld:'vSELMENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'cmbavConvecodigo'},{av:'AV63ConveCodigo',fld:'vCONVECODIGO_MPAGE',pic:''}]");
      setEventMetadata("VCONVECODIGO_MPAGE.CONTROLVALUECHANGED_MPAGE",",oparms:[{av:'AV62contentHolder_Pgmname',fld:'vCONTENTHOLDER_PGMNAME_MPAGE',pic:'',hsh:true},{av:'divDiv_contentplaceholder_Class',ctrl:'DIV_CONTENTPLACEHOLDER_MPAGE',prop:'Class'},{av:'cmbavEmpcod'},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9',hsh:true},{av:'AV5EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'cmbavConvecodigo'},{av:'AV63ConveCodigo',fld:'vCONVECODIGO_MPAGE',pic:''},{av:'AV67PaiCod',fld:'vPAICOD_MPAGE',pic:'ZZZ9'},{av:'tblTablesvgtextempresa_Visible',ctrl:'TABLESVGTEXTEMPRESA_MPAGE',prop:'Visible'},{av:'Ddc_runtimedesignsettings_Visible',ctrl:'DDC_RUNTIMEDESIGNSETTINGS_MPAGE',prop:'Visible'},{av:'Ddc_adminag_Visible',ctrl:'DDC_ADMINAG_MPAGE',prop:'Visible'},{av:'AV81selMenuOpcCod',fld:'vSELMENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'lblAyuda_Caption',ctrl:'AYUDA_MPAGE',prop:'Caption'},{av:'AV84primero_MenuOpcCod',fld:'vPRIMERO_MENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'lblVolversvg_Link',ctrl:'VOLVERSVG_MPAGE',prop:'Link'},{ctrl:'FORM_MPAGE',prop:'Headerrawhtml'},{av:'lblVolversvg_Visible',ctrl:'VOLVERSVG_MPAGE',prop:'Visible'},{av:'lblAyuda_Visible',ctrl:'AYUDA_MPAGE',prop:'Visible'},{av:'lblHtmlhormiga_Caption',ctrl:'HTMLHORMIGA_MPAGE',prop:'Caption'},{ctrl:'FORM_MPAGE',prop:'Caption'}]}");
      setEventMetadata("AYUDA_MPAGE.CLICK_MPAGE","{handler:'e15092',iparms:[{av:'GRIDOPCIONES_MPAGE_nFirstRecordOnPage'},{av:'GRIDOPCIONES_MPAGE_nEOF'},{av:'AV116Pgmname',fld:'vPGMNAME_MPAGE',pic:''},{av:'cmbavEmpcod'},{av:'AV5EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9',hsh:true},{av:'A3CliCod',fld:'CLICOD_MPAGE',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD_MPAGE',pic:'ZZZ9',hsh:true},{av:'A2EmpNom',fld:'EMPNOM_MPAGE',pic:'@!',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE_MPAGE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO_MPAGE',pic:'',hsh:true},{av:'A1567CliConvenioDescrip',fld:'CLICONVENIODESCRIP_MPAGE',pic:''},{av:'AV62contentHolder_Pgmname',fld:'vCONTENTHOLDER_PGMNAME_MPAGE',pic:'',hsh:true},{av:'AV72RolId',fld:'vROLID_MPAGE',pic:'Z9',hsh:true},{av:'AV73PerfilId',fld:'vPERFILID_MPAGE',pic:'Z9',hsh:true},{av:'AV74MenuVerId',fld:'vMENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9',hsh:true},{av:'A1923RolId',fld:'ROLID_MPAGE',pic:'Z9'},{av:'A1925PerfilId',fld:'PERFILID_MPAGE',pic:'Z9'},{av:'A1928MenuVerId',fld:'MENUVERID_MPAGE',pic:'ZZZZZZZZZZZZZZ9'},{av:'A1940MenuItemOrd',fld:'MENUITEMORD_MPAGE',pic:'Z9'},{av:'A1933MenuOpcPadre',fld:'MENUOPCPADRE_MPAGE',pic:''},{av:'A1935SVGId',fld:'SVGID_MPAGE',pic:''},{av:'A1936SVGValor',fld:'SVGVALOR_MPAGE',pic:''},{av:'A1941MenuItemImg',fld:'MENUITEMIMG_MPAGE',pic:''},{av:'A1943MenuItemImgNom',fld:'MENUITEMIMGNOM_MPAGE',pic:''},{av:'A1942MenuItemImgExt',fld:'MENUITEMIMGEXT_MPAGE',pic:''},{av:'A1929MenuOpcCod',fld:'MENUOPCCOD_MPAGE',pic:''},{av:'AV84primero_MenuOpcCod',fld:'vPRIMERO_MENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'A1931MenuOpcTitulo',fld:'MENUOPCTITULO_MPAGE',pic:''},{av:'A1937MenuItemId',fld:'MENUITEMID_MPAGE',pic:''},{av:'AV88urls',fld:'vURLS_MPAGE',pic:''},{av:'AV81selMenuOpcCod',fld:'vSELMENUOPCCOD_MPAGE',pic:'',hsh:true}]");
      setEventMetadata("AYUDA_MPAGE.CLICK_MPAGE",",oparms:[{av:'AV62contentHolder_Pgmname',fld:'vCONTENTHOLDER_PGMNAME_MPAGE',pic:'',hsh:true},{av:'divDiv_contentplaceholder_Class',ctrl:'DIV_CONTENTPLACEHOLDER_MPAGE',prop:'Class'},{av:'cmbavEmpcod'},{av:'AV9CliCod',fld:'vCLICOD_MPAGE',pic:'ZZZZZ9',hsh:true},{av:'AV5EmpCod',fld:'vEMPCOD_MPAGE',pic:'ZZZ9'},{av:'cmbavConvecodigo'},{av:'AV63ConveCodigo',fld:'vCONVECODIGO_MPAGE',pic:''},{av:'AV67PaiCod',fld:'vPAICOD_MPAGE',pic:'ZZZ9'},{av:'tblTablesvgtextempresa_Visible',ctrl:'TABLESVGTEXTEMPRESA_MPAGE',prop:'Visible'},{av:'Ddc_runtimedesignsettings_Visible',ctrl:'DDC_RUNTIMEDESIGNSETTINGS_MPAGE',prop:'Visible'},{av:'Ddc_adminag_Visible',ctrl:'DDC_ADMINAG_MPAGE',prop:'Visible'},{av:'AV81selMenuOpcCod',fld:'vSELMENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'lblAyuda_Caption',ctrl:'AYUDA_MPAGE',prop:'Caption'},{av:'AV84primero_MenuOpcCod',fld:'vPRIMERO_MENUOPCCOD_MPAGE',pic:'',hsh:true},{av:'lblVolversvg_Link',ctrl:'VOLVERSVG_MPAGE',prop:'Link'},{ctrl:'FORM_MPAGE',prop:'Headerrawhtml'},{av:'lblVolversvg_Visible',ctrl:'VOLVERSVG_MPAGE',prop:'Visible'},{av:'lblAyuda_Visible',ctrl:'AYUDA_MPAGE',prop:'Visible'},{av:'lblHtmlhormiga_Caption',ctrl:'HTMLHORMIGA_MPAGE',prop:'Caption'},{ctrl:'FORM_MPAGE',prop:'Caption'}]}");
      setEventMetadata("ONMESSAGE_GX1_MPAGE","{handler:'e16092',iparms:[{av:'AV66NotificationInfo',fld:'vNOTIFICATIONINFO_MPAGE',pic:''},{av:'AV116Pgmname',fld:'vPGMNAME_MPAGE',pic:''}]");
      setEventMetadata("ONMESSAGE_GX1_MPAGE",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Imagemenuitemicon',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
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
      Ddo_languagesicons_Activeeventkey = "" ;
      AV66NotificationInfo = new com.genexuscore.genexus.server.SdtNotificationInfo(remoteHandle, context);
      AV116Pgmname = "" ;
      A2EmpNom = "" ;
      A1565CliConvenio = "" ;
      A1567CliConvenioDescrip = "" ;
      AV62contentHolder_Pgmname = "" ;
      A1933MenuOpcPadre = "" ;
      A1935SVGId = "" ;
      A1936SVGValor = "" ;
      A1941MenuItemImg = "" ;
      A1943MenuItemImgNom = "" ;
      A1942MenuItemImgExt = "" ;
      A1929MenuOpcCod = "" ;
      AV84primero_MenuOpcCod = "" ;
      A1931MenuOpcTitulo = "" ;
      A1937MenuItemId = "" ;
      AV88urls = new GXSimpleCollection<String>(String.class, "internal", "");
      AV81selMenuOpcCod = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GXKey = "" ;
      AV25LanguagesIconsData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      Ddo_languagesicons_Caption = "" ;
      sPrefix = "" ;
      lblVolversvg_Jsonclick = "" ;
      lblHtmlhormiga_Jsonclick = "" ;
      lblAyuda_Jsonclick = "" ;
      MPGridopcionesContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      lblTextblockfooter_Jsonclick = "" ;
      lblVersion_Jsonclick = "" ;
      TempTags = "" ;
      AV29PickerDummyVariable = GXutil.nullDate() ;
      WebComp_Ddc_runtimedesignsettings_wc_Component = "" ;
      OldDdc_runtimedesignsettings_wc = "" ;
      WebComp_Ddc_adminag_wc_Component = "" ;
      OldDdc_adminag_wc = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV79ImageMenuItemIcon = "" ;
      AV118Imagemenuitemicon_GXI = "" ;
      GXCCtl = "" ;
      GX_FocusControl = "" ;
      AV63ConveCodigo = "" ;
      AV69SecUserName = "" ;
      AV70SecUserPerName = "" ;
      AV111SecUserPerLastName = "" ;
      AV112RolNombre = "" ;
      ucDdc_adminag = new com.genexus.webpanels.GXUserControl();
      AV12DVelop_Menu = new GXBaseCollection<web.wwpbaseobjects.SdtDVelop_Menu_Item>(web.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "PayDay", remoteHandle);
      GXt_objcol_SdtDVelop_Menu_Item5 = new GXBaseCollection<web.wwpbaseobjects.SdtDVelop_Menu_Item>(web.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "PayDay", remoteHandle);
      GXv_objcol_SdtDVelop_Menu_Item6 = new GXBaseCollection[1] ;
      ucDdc_runtimedesignsettings = new com.genexus.webpanels.GXUserControl();
      AV26LanguagesIconsDataItem = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV56Language = "" ;
      ucDdo_languagesicons = new com.genexus.webpanels.GXUserControl();
      AV17Httprequest = httpContext.getHttpRequest();
      AV6WWP_DesignSystemSettings = new web.wwpbaseobjects.SdtWWP_DesignSystemSettings(remoteHandle, context);
      GXt_SdtWWP_DesignSystemSettings11 = new web.wwpbaseobjects.SdtWWP_DesignSystemSettings(remoteHandle, context);
      GXv_SdtWWP_DesignSystemSettings12 = new web.wwpbaseobjects.SdtWWP_DesignSystemSettings[1] ;
      GXv_int13 = new byte[1] ;
      GXv_int14 = new byte[1] ;
      GXv_int15 = new long[1] ;
      AV37WebSession = httpContext.getWebSession();
      GXv_int8 = new int[1] ;
      scmdbuf = "" ;
      H00092_A1923RolId = new byte[1] ;
      H00092_A1925PerfilId = new byte[1] ;
      H00092_A1928MenuVerId = new long[1] ;
      H00092_A1933MenuOpcPadre = new String[] {""} ;
      H00092_n1933MenuOpcPadre = new boolean[] {false} ;
      H00092_A1943MenuItemImgNom = new String[] {""} ;
      H00092_A1942MenuItemImgExt = new String[] {""} ;
      H00092_A1935SVGId = new String[] {""} ;
      H00092_n1935SVGId = new boolean[] {false} ;
      H00092_A1936SVGValor = new String[] {""} ;
      H00092_A1941MenuItemImg = new String[] {""} ;
      H00092_A1929MenuOpcCod = new String[] {""} ;
      H00092_A1931MenuOpcTitulo = new String[] {""} ;
      H00092_A1937MenuItemId = new String[] {""} ;
      H00092_A1940MenuItemOrd = new byte[1] ;
      A1941MenuItemImg_Filename = "" ;
      A1941MenuItemImg_Filetype = "" ;
      AV80menuURL = "" ;
      GridopcionesRow = new com.genexus.webpanels.GXWebRow();
      ucA3llinktabla1 = new com.genexus.webpanels.GXUserControl();
      H00093_A3CliCod = new int[1] ;
      H00093_A2EmpNom = new String[] {""} ;
      H00093_A1EmpCod = new short[1] ;
      GXv_int10 = new short[1] ;
      H00094_A3CliCod = new int[1] ;
      H00094_A1564CliPaiConve = new short[1] ;
      H00094_A1567CliConvenioDescrip = new String[] {""} ;
      H00094_A1565CliConvenio = new String[] {""} ;
      AV78homeURL = "" ;
      AV85headTitle = "" ;
      GXv_boolean18 = new boolean[1] ;
      GXt_char16 = "" ;
      GXt_char1 = "" ;
      AV83modoTxt = "" ;
      AV82html = "" ;
      GXv_char3 = new String[1] ;
      GXv_char2 = new String[1] ;
      AV77URL = "" ;
      GXv_char4 = new String[1] ;
      ucUcmessage = new com.genexus.webpanels.GXUserControl();
      ucUctooltip = new com.genexus.webpanels.GXUserControl();
      ucWwputilities = new com.genexus.webpanels.GXUserControl();
      ucWwpdatepicker = new com.genexus.webpanels.GXUserControl();
      lblJs_Jsonclick = "" ;
      lblTextblock1_Jsonclick = "" ;
      lblTextblock2_Jsonclick = "" ;
      lblSvgempresa_Jsonclick = "" ;
      lblTextblockar_Jsonclick = "" ;
      lblTextblock_pay_Jsonclick = "" ;
      lblTextblockday_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sDynURL = "" ;
      subGridopciones_Linesclass = "" ;
      GridopcionesColumn = new com.genexus.webpanels.GXWebColumn();
      lblSvg_opcion_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      lblTextblockopcion_Jsonclick = "" ;
      subGridopciones_Header = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.workwithplusmasterpage__default(),
         new Object[] {
             new Object[] {
            H00092_A1923RolId, H00092_A1925PerfilId, H00092_A1928MenuVerId, H00092_A1933MenuOpcPadre, H00092_n1933MenuOpcPadre, H00092_A1943MenuItemImgNom, H00092_A1942MenuItemImgExt, H00092_A1935SVGId, H00092_n1935SVGId, H00092_A1936SVGValor,
            H00092_A1941MenuItemImg, H00092_A1929MenuOpcCod, H00092_A1931MenuOpcTitulo, H00092_A1937MenuItemId, H00092_A1940MenuItemOrd
            }
            , new Object[] {
            H00093_A3CliCod, H00093_A2EmpNom, H00093_A1EmpCod
            }
            , new Object[] {
            H00094_A3CliCod, H00094_A1564CliPaiConve, H00094_A1567CliConvenioDescrip, H00094_A1565CliConvenio
            }
         }
      );
      AV116Pgmname = "WWPBaseObjects.WorkWithPlusMasterPage" ;
      /* GeneXus formulas. */
      AV116Pgmname = "WWPBaseObjects.WorkWithPlusMasterPage" ;
      Gx_err = (short)(0) ;
      WebComp_Ddc_runtimedesignsettings_wc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Ddc_adminag_wc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte GxWebError ;
   private byte AV72RolId ;
   private byte AV73PerfilId ;
   private byte A1923RolId ;
   private byte A1925PerfilId ;
   private byte A1940MenuItemOrd ;
   private byte nDonePA ;
   private byte subGridopciones_Backcolorstyle ;
   private byte GXv_int13[] ;
   private byte GXv_int14[] ;
   private byte GRIDOPCIONES_MPAGE_nEOF ;
   private byte nGotPars ;
   private byte nGXWrapped ;
   private byte subGridopciones_Backstyle ;
   private byte subGridopciones_Allowselection ;
   private byte subGridopciones_Allowhovering ;
   private byte subGridopciones_Allowcollapsing ;
   private byte subGridopciones_Collapsed ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV5EmpCod ;
   private short A1EmpCod ;
   private short A1564CliPaiConve ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV75SecUserId ;
   private short AV113cant ;
   private short AV67PaiCod ;
   private short GXt_int9 ;
   private short GXv_int10[] ;
   private int nRC_GXsfl_78 ;
   private int nGXsfl_78_idx=1 ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private int Ddc_adminag_Componentwidth ;
   private int Ddc_runtimedesignsettings_Componentwidth ;
   private int Ucmessage_Delayuntilhide ;
   private int Ucmessage_Animationspeed ;
   private int lblVolversvg_Visible ;
   private int lblAyuda_Visible ;
   private int subGridopciones_Islastpage ;
   private int tblTableidioma_Visible ;
   private int GXt_int7 ;
   private int GXv_int8[] ;
   private int edtavImagemenuitemicon_Visible ;
   private int lblSvg_opcion_Visible ;
   private int tblTablesvgtextempresa_Visible ;
   private int idxLst ;
   private int subGridopciones_Backcolor ;
   private int subGridopciones_Allbackcolor ;
   private int edtavImagemenuitemicon_Enabled ;
   private int subGridopciones_Selectedindex ;
   private int subGridopciones_Selectioncolor ;
   private int subGridopciones_Hoveringcolor ;
   private long AV74MenuVerId ;
   private long A1928MenuVerId ;
   private long GRIDOPCIONES_MPAGE_nCurrentRecord ;
   private long GRIDOPCIONES_MPAGE_nFirstRecordOnPage ;
   private long GXv_int15[] ;
   private String Ddo_languagesicons_Activeeventkey ;
   private String sGXsfl_78_idx="0001" ;
   private String AV116Pgmname ;
   private String A1565CliConvenio ;
   private String AV62contentHolder_Pgmname ;
   private String A1933MenuOpcPadre ;
   private String A1935SVGId ;
   private String A1942MenuItemImgExt ;
   private String GXKey ;
   private String Ddo_languagesicons_Caption ;
   private String Ddo_languagesicons_Cls ;
   private String Ddo_languagesicons_Titlecontrolalign ;
   private String Ddc_adminag_Icon ;
   private String Ddc_adminag_Caption ;
   private String Ddc_adminag_Cls ;
   private String Ddc_adminag_Load ;
   private String Ddc_adminag_Trigger ;
   private String Ddc_runtimedesignsettings_Icon ;
   private String Ddc_runtimedesignsettings_Tooltip ;
   private String Ddc_runtimedesignsettings_Cls ;
   private String Ddc_runtimedesignsettings_Load ;
   private String Ddc_runtimedesignsettings_Trigger ;
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
   private String divDiv_parent_Internalname ;
   private String divDiv_header_Internalname ;
   private String divTableheadercontent_Internalname ;
   private String divTablelogo_Internalname ;
   private String divTableempresaconvenio_Internalname ;
   private String divTableuserrole_Internalname ;
   private String divDiv_subheader_Internalname ;
   private String divTableactions_Internalname ;
   private String divTablevolver_pgmname_Internalname ;
   private String lblVolversvg_Internalname ;
   private String lblVolversvg_Caption ;
   private String lblVolversvg_Link ;
   private String lblVolversvg_Jsonclick ;
   private String lblHtmlhormiga_Internalname ;
   private String lblHtmlhormiga_Caption ;
   private String lblHtmlhormiga_Jsonclick ;
   private String divTableayuda_Internalname ;
   private String lblAyuda_Internalname ;
   private String lblAyuda_Caption ;
   private String lblAyuda_Jsonclick ;
   private String divDiv_menu_Internalname ;
   private String sStyleString ;
   private String subGridopciones_Internalname ;
   private String divDiv_footer_Internalname ;
   private String divTablefooter_Internalname ;
   private String lblTextblockfooter_Internalname ;
   private String lblTextblockfooter_Jsonclick ;
   private String divDiv_contentplaceholder_Internalname ;
   private String divDiv_contentplaceholder_Class ;
   private String divTablemenuconfig_Internalname ;
   private String divTableversion_Internalname ;
   private String lblVersion_Internalname ;
   private String lblVersion_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String TempTags ;
   private String edtavPickerdummyvariable_Internalname ;
   private String edtavPickerdummyvariable_Jsonclick ;
   private String divDiv_ddc_runtimedesignsettings_Internalname ;
   private String WebComp_Ddc_runtimedesignsettings_wc_Component ;
   private String OldDdc_runtimedesignsettings_wc ;
   private String divDiv_ddc_adminag_Internalname ;
   private String WebComp_Ddc_adminag_wc_Component ;
   private String OldDdc_adminag_wc ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavImagemenuitemicon_Internalname ;
   private String GXCCtl ;
   private String GX_FocusControl ;
   private String AV63ConveCodigo ;
   private String lblTextblock2_Caption ;
   private String lblTextblock2_Internalname ;
   private String Ddc_adminag_Internalname ;
   private String tblTableidioma_Internalname ;
   private String Ddc_runtimedesignsettings_Internalname ;
   private String Ddo_languagesicons_Internalname ;
   private String lblSvgempresa_Caption ;
   private String lblSvgempresa_Internalname ;
   private String scmdbuf ;
   private String A1941MenuItemImg_Filename ;
   private String A1941MenuItemImg_Filetype ;
   private String lblSvg_opcion_Caption ;
   private String divGridopcioneslayouttable_Class ;
   private String divGridopcioneslayouttable_Internalname ;
   private String lblTextblockopcion_Class ;
   private String lblTextblockopcion_Caption ;
   private String A3llinktabla1_Internalname ;
   private String lblJs_Caption ;
   private String lblJs_Internalname ;
   private String tblTablesvgtextempresa_Internalname ;
   private String GXt_char16 ;
   private String GXt_char1 ;
   private String GXv_char3[] ;
   private String GXv_char2[] ;
   private String GXv_char4[] ;
   private String tblTablausercontrols_Internalname ;
   private String Ucmessage_Internalname ;
   private String Uctooltip_Internalname ;
   private String Wwputilities_Internalname ;
   private String Wwpdatepicker_Internalname ;
   private String lblJs_Jsonclick ;
   private String lblTextblock1_Internalname ;
   private String lblTextblock1_Jsonclick ;
   private String tblTablesettings_Internalname ;
   private String Ddc_runtimedesignsettings_Caption ;
   private String tblHeadercontentoptions_Internalname ;
   private String tblTableuser_Internalname ;
   private String divTablepuesto_Internalname ;
   private String lblTextblock2_Jsonclick ;
   private String tblTablesvgiconempresa_Internalname ;
   private String lblSvgempresa_Jsonclick ;
   private String tblTablear_Internalname ;
   private String divTable_ar_Internalname ;
   private String lblTextblockar_Internalname ;
   private String lblTextblockar_Jsonclick ;
   private String tblTablepayday_Internalname ;
   private String divTablepay_Internalname ;
   private String lblTextblock_pay_Internalname ;
   private String lblTextblock_pay_Jsonclick ;
   private String divTableday_Internalname ;
   private String lblTextblockday_Internalname ;
   private String lblTextblockday_Jsonclick ;
   private String sDynURL ;
   private String lblSvg_opcion_Internalname ;
   private String lblTextblockopcion_Internalname ;
   private String sGXsfl_78_fel_idx="0001" ;
   private String subGridopciones_Linesclass ;
   private String divTableiconoopcion_Internalname ;
   private String lblSvg_opcion_Jsonclick ;
   private String ClassString ;
   private String edtavImagemenuitemicon_gximage ;
   private String StyleString ;
   private String sImgUrl ;
   private String divTabletextopcion_Internalname ;
   private String lblTextblockopcion_Jsonclick ;
   private String subGridopciones_Header ;
   private java.util.Date AV29PickerDummyVariable ;
   private boolean n1933MenuOpcPadre ;
   private boolean n1935SVGId ;
   private boolean Ddc_adminag_Visible ;
   private boolean Ddc_adminag_Showloading ;
   private boolean Ddc_runtimedesignsettings_Visible ;
   private boolean Ddc_runtimedesignsettings_Showloading ;
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
   private boolean bGXsfl_78_Refreshing=false ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean toggleJsOutput ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private boolean bDynCreated_Ddc_runtimedesignsettings_wc ;
   private boolean bDynCreated_Ddc_adminag_wc ;
   private boolean gx_refresh_fired ;
   private boolean AV35TempBoolean ;
   private boolean GXt_boolean17 ;
   private boolean AV58hay ;
   private boolean AV60ClienteConveniador ;
   private boolean AV61combosVisiblEs ;
   private boolean AV86MenuBienveVisible ;
   private boolean GXv_boolean18[] ;
   private boolean AV79ImageMenuItemIcon_IsBlob ;
   private String A1936SVGValor ;
   private String AV82html ;
   private String A1941MenuItemImg ;
   private String A2EmpNom ;
   private String A1567CliConvenioDescrip ;
   private String A1943MenuItemImgNom ;
   private String A1929MenuOpcCod ;
   private String AV84primero_MenuOpcCod ;
   private String A1931MenuOpcTitulo ;
   private String A1937MenuItemId ;
   private String AV81selMenuOpcCod ;
   private String AV118Imagemenuitemicon_GXI ;
   private String AV69SecUserName ;
   private String AV70SecUserPerName ;
   private String AV111SecUserPerLastName ;
   private String AV112RolNombre ;
   private String AV56Language ;
   private String AV80menuURL ;
   private String AV78homeURL ;
   private String AV85headTitle ;
   private String AV83modoTxt ;
   private String AV77URL ;
   private String AV79ImageMenuItemIcon ;
   private com.genexus.webpanels.GXWebGrid MPGridopcionesContainer ;
   private com.genexus.webpanels.GXWebRow GridopcionesRow ;
   private com.genexus.webpanels.GXWebColumn GridopcionesColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Ddc_runtimedesignsettings_wc ;
   private GXWebComponent WebComp_Ddc_adminag_wc ;
   private com.genexus.internet.HttpRequest AV17Httprequest ;
   private com.genexus.webpanels.WebSession AV37WebSession ;
   private com.genexus.webpanels.GXUserControl ucDdc_adminag ;
   private com.genexus.webpanels.GXUserControl ucDdc_runtimedesignsettings ;
   private com.genexus.webpanels.GXUserControl ucDdo_languagesicons ;
   private com.genexus.webpanels.GXUserControl ucA3llinktabla1 ;
   private com.genexus.webpanels.GXUserControl ucUcmessage ;
   private com.genexus.webpanels.GXUserControl ucUctooltip ;
   private com.genexus.webpanels.GXUserControl ucWwputilities ;
   private com.genexus.webpanels.GXUserControl ucWwpdatepicker ;
   private com.genexuscore.genexus.server.SdtNotificationInfo AV66NotificationInfo ;
   private HTMLChoice cmbavEmpcod ;
   private HTMLChoice cmbavConvecodigo ;
   private com.genexus.webpanels.GXDataAreaControl Contentholder ;
   private IDataStoreProvider pr_default ;
   private byte[] H00092_A1923RolId ;
   private byte[] H00092_A1925PerfilId ;
   private long[] H00092_A1928MenuVerId ;
   private String[] H00092_A1933MenuOpcPadre ;
   private boolean[] H00092_n1933MenuOpcPadre ;
   private String[] H00092_A1943MenuItemImgNom ;
   private String[] H00092_A1942MenuItemImgExt ;
   private String[] H00092_A1935SVGId ;
   private boolean[] H00092_n1935SVGId ;
   private String[] H00092_A1936SVGValor ;
   private String[] H00092_A1941MenuItemImg ;
   private String[] H00092_A1929MenuOpcCod ;
   private String[] H00092_A1931MenuOpcTitulo ;
   private String[] H00092_A1937MenuItemId ;
   private byte[] H00092_A1940MenuItemOrd ;
   private int[] H00093_A3CliCod ;
   private String[] H00093_A2EmpNom ;
   private short[] H00093_A1EmpCod ;
   private int[] H00094_A3CliCod ;
   private short[] H00094_A1564CliPaiConve ;
   private String[] H00094_A1567CliConvenioDescrip ;
   private String[] H00094_A1565CliConvenio ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV88urls ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV25LanguagesIconsData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVelop_Menu_Item> AV12DVelop_Menu ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVelop_Menu_Item> GXt_objcol_SdtDVelop_Menu_Item5 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVelop_Menu_Item> GXv_objcol_SdtDVelop_Menu_Item6[] ;
   private web.wwpbaseobjects.SdtWWP_DesignSystemSettings AV6WWP_DesignSystemSettings ;
   private web.wwpbaseobjects.SdtWWP_DesignSystemSettings GXt_SdtWWP_DesignSystemSettings11 ;
   private web.wwpbaseobjects.SdtWWP_DesignSystemSettings GXv_SdtWWP_DesignSystemSettings12[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item AV26LanguagesIconsDataItem ;
}

final  class workwithplusmasterpage__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00092", "SELECT T1.RolId, T1.PerfilId, T1.MenuVerId, T1.MenuOpcPadre, T1.MenuItemImgNom, T1.MenuItemImgExt, T1.SVGId, T2.SVGValor, T1.MenuItemImg, T1.MenuOpcCod, T1.MenuOpcTitulo, T1.MenuItemId, T1.MenuItemOrd FROM (MenuVersionesOpciones T1 LEFT JOIN SVG T2 ON T2.SVGId = T1.SVGId) WHERE (T1.RolId = ? and T1.PerfilId = ? and T1.MenuVerId = ?) AND (T1.MenuOpcPadre IS NULL or (char_length(trim(trailing ' ' from T1.MenuOpcPadre))=0)) ORDER BY T1.RolId, T1.PerfilId, T1.MenuVerId, T1.MenuItemOrd ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00093", "SELECT CliCod, EmpNom, EmpCod FROM Empresa WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00094", "SELECT T1.CliCod, T1.CliPaiConve AS CliPaiConve, T2.ConveDescri AS CliConvenioDescrip, T1.CliConvenio AS CliConvenio FROM (ClienteConvenios T1 INNER JOIN Convenio T2 ON T2.PaiCod = T1.CliPaiConve AND T2.ConveCodigo = T1.CliConvenio) WHERE T1.CliCod = ? and T1.CliPaiConve = ? ORDER BY T1.CliCod, T1.CliPaiConve ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[10])[0] = rslt.getBLOBFile(9, rslt.getString(6, 20), rslt.getVarchar(5));
               ((String[]) buf[11])[0] = rslt.getVarchar(10);
               ((String[]) buf[12])[0] = rslt.getVarchar(11);
               ((String[]) buf[13])[0] = rslt.getVarchar(12);
               ((byte[]) buf[14])[0] = rslt.getByte(13);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

