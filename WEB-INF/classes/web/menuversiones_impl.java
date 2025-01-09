package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class menuversiones_impl extends GXDataArea
{
   public void initenv( )
   {
      if ( GxWebError != 0 )
      {
         return  ;
      }
   }

   public void inittrn( )
   {
      initialize_properties( ) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      gxfirstwebparm_bkp = gxfirstwebparm ;
      gxfirstwebparm = httpContext.DecryptAjaxCall( gxfirstwebparm) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      if ( GXutil.strcmp(gxfirstwebparm, "dyncall") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         dyncall( httpContext.GetNextPar( )) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action26") == 0 )
      {
         A1925PerfilId = (byte)(GXutil.lval( httpContext.GetPar( "PerfilId"))) ;
         n1925PerfilId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
         A1937MenuItemId = httpContext.GetPar( "MenuItemId") ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_26_5V256( A1925PerfilId, A1937MenuItemId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"MENUPAIS") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlamenupais5V255( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"MENUOPCPADRE") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlamenuopcpadre5V256( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"SVGID") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlasvgid5V256( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel16"+"_"+"MENUOPCHORMIGA") == 0 )
      {
         A1929MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
         A1923RolId = (byte)(GXutil.lval( httpContext.GetPar( "RolId"))) ;
         n1923RolId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
         A1925PerfilId = (byte)(GXutil.lval( httpContext.GetPar( "PerfilId"))) ;
         n1925PerfilId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
         A1928MenuVerId = GXutil.lval( httpContext.GetPar( "MenuVerId")) ;
         n1928MenuVerId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1928MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1928MenuVerId), 15, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx16asamenuopchormiga5V256( A1929MenuOpcCod, A1923RolId, A1925PerfilId, A1928MenuVerId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_28") == 0 )
      {
         A1923RolId = (byte)(GXutil.lval( httpContext.GetPar( "RolId"))) ;
         n1923RolId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_28( A1923RolId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_29") == 0 )
      {
         A1925PerfilId = (byte)(GXutil.lval( httpContext.GetPar( "PerfilId"))) ;
         n1925PerfilId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_29( A1925PerfilId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_30") == 0 )
      {
         A1927MenuPais = (short)(GXutil.lval( httpContext.GetPar( "MenuPais"))) ;
         n1927MenuPais = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1927MenuPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1927MenuPais), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_30( A1927MenuPais) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_33") == 0 )
      {
         A1925PerfilId = (byte)(GXutil.lval( httpContext.GetPar( "PerfilId"))) ;
         n1925PerfilId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
         A1937MenuItemId = httpContext.GetPar( "MenuItemId") ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_33( A1925PerfilId, A1937MenuItemId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_32") == 0 )
      {
         A1935SVGId = httpContext.GetPar( "SVGId") ;
         n1935SVGId = false ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_32( A1935SVGId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
      {
         httpContext.setAjaxEventMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_opciones") == 0 )
      {
         gxnrgridlevel_opciones_newrow_invoke( ) ;
         return  ;
      }
      else
      {
         if ( ! httpContext.IsValidAjaxCall( false) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = gxfirstwebparm_bkp ;
      }
      if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
      {
         Gx_mode = gxfirstwebparm ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV7RolId = (byte)(GXutil.lval( httpContext.GetPar( "RolId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7RolId), 2, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vROLID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7RolId), "Z9")));
            AV8PerfilId = (byte)(GXutil.lval( httpContext.GetPar( "PerfilId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8PerfilId), 2, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERFILID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8PerfilId), "Z9")));
            AV9MenuVerId = GXutil.lval( httpContext.GetPar( "MenuVerId")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9MenuVerId), 15, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUVERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9MenuVerId), "ZZZZZZZZZZZZZZ9")));
         }
      }
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
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
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "Menu Versiones", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = dynPerfilId.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridlevel_opciones_newrow_invoke( )
   {
      nRC_GXsfl_41 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_41"))) ;
      nGXsfl_41_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_41_idx"))) ;
      sGXsfl_41_idx = httpContext.GetPar( "sGXsfl_41_idx") ;
      Gx_BScreen = (byte)(GXutil.lval( httpContext.GetPar( "Gx_BScreen"))) ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_opciones_newrow( ) ;
      /* End function gxnrGridlevel_opciones_newrow_invoke */
   }

   public menuversiones_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public menuversiones_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( menuversiones_impl.class ));
   }

   public menuversiones_impl( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynPerfilId = new HTMLChoice();
      dynMenuPais = new HTMLChoice();
      dynMenuOpcPadre = new HTMLChoice();
      dynSVGId = new HTMLChoice();
      chkMenuHomeEs = UIFactory.getCheckbox(this);
      chkMenuBienveVisible = UIFactory.getCheckbox(this);
      chkMenuOpcInst = UIFactory.getCheckbox(this);
      chkMenuOpcForRet = UIFactory.getCheckbox(this);
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.newmasterpage");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
         if ( ( GxWebError == 0 ) && httpContext.isAjaxRequest( ) )
         {
            httpContext.enableOutput();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
            }
            if ( ! httpContext.willRedirect( ) )
            {
               addString( httpContext.getJSONResponse( )) ;
            }
            else
            {
               if ( httpContext.isAjaxRequest( ) )
               {
                  httpContext.disableOutput();
               }
               renderHtmlHeaders( ) ;
               httpContext.redirect( httpContext.wjLoc );
               httpContext.dispatchAjaxCommands();
            }
         }
      }
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( dynPerfilId.getItemCount() > 0 )
      {
         A1925PerfilId = (byte)(GXutil.lval( dynPerfilId.getValidValue(GXutil.trim( GXutil.str( A1925PerfilId, 2, 0))))) ;
         n1925PerfilId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynPerfilId.setValue( GXutil.trim( GXutil.str( A1925PerfilId, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynPerfilId.getInternalname(), "Values", dynPerfilId.ToJavascriptSource(), true);
      }
      if ( dynMenuPais.getItemCount() > 0 )
      {
         A1927MenuPais = (short)(GXutil.lval( dynMenuPais.getValidValue(GXutil.trim( GXutil.str( A1927MenuPais, 4, 0))))) ;
         n1927MenuPais = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1927MenuPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1927MenuPais), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynMenuPais.setValue( GXutil.trim( GXutil.str( A1927MenuPais, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynMenuPais.getInternalname(), "Values", dynMenuPais.ToJavascriptSource(), true);
      }
   }

   public void draw( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         disable_std_buttons( ) ;
         enableDisable( ) ;
         set_caption( ) ;
         /* Form start */
         drawControls( ) ;
         fix_multi_value_controls( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Padding0", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "TableContentPadding", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucDvpanel_tableattributes.setProperty("Width", Dvpanel_tableattributes_Width);
      ucDvpanel_tableattributes.setProperty("AutoWidth", Dvpanel_tableattributes_Autowidth);
      ucDvpanel_tableattributes.setProperty("AutoHeight", Dvpanel_tableattributes_Autoheight);
      ucDvpanel_tableattributes.setProperty("Cls", Dvpanel_tableattributes_Cls);
      ucDvpanel_tableattributes.setProperty("Title", Dvpanel_tableattributes_Title);
      ucDvpanel_tableattributes.setProperty("Collapsible", Dvpanel_tableattributes_Collapsible);
      ucDvpanel_tableattributes.setProperty("Collapsed", Dvpanel_tableattributes_Collapsed);
      ucDvpanel_tableattributes.setProperty("ShowCollapseIcon", Dvpanel_tableattributes_Showcollapseicon);
      ucDvpanel_tableattributes.setProperty("IconPosition", Dvpanel_tableattributes_Iconposition);
      ucDvpanel_tableattributes.setProperty("AutoScroll", Dvpanel_tableattributes_Autoscroll);
      ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, "DVPANEL_TABLEATTRIBUTESContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynPerfilId.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynPerfilId.getInternalname(), httpContext.getMessage( "Perfil", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynPerfilId, dynPerfilId.getInternalname(), GXutil.trim( GXutil.str( A1925PerfilId, 2, 0)), 1, dynPerfilId.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynPerfilId.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "", true, (byte)(0), "HLP_MenuVersiones.htm");
      dynPerfilId.setValue( GXutil.trim( GXutil.str( A1925PerfilId, 2, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynPerfilId.getInternalname(), "Values", dynPerfilId.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMenuVerId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMenuVerId_Internalname, httpContext.getMessage( "Versión de menú", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMenuVerId_Internalname, GXutil.ltrim( localUtil.ntoc( A1928MenuVerId, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1928MenuVerId), "ZZZZZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMenuVerId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMenuVerId_Enabled, 1, "text", "1", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "ID", "right", false, "", "HLP_MenuVersiones.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynMenuPais.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynMenuPais.getInternalname(), httpContext.getMessage( "Pais", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynMenuPais, dynMenuPais.getInternalname(), GXutil.trim( GXutil.str( A1927MenuPais, 4, 0)), 1, dynMenuPais.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynMenuPais.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "", true, (byte)(0), "HLP_MenuVersiones.htm");
      dynMenuPais.setValue( GXutil.trim( GXutil.str( A1927MenuPais, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynMenuPais.getInternalname(), "Values", dynMenuPais.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      ClassString = "ErrorViewer" ;
      StyleString = "" ;
      web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='CellMarginTop'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableleaflevel_opciones_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell", "left", "top", "", "", "div");
      /*  Grid Control  */
      startgridcontrol41( ) ;
      nGXsfl_41_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount256 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_256 = (short)(1) ;
            scanStart5V256( ) ;
            while ( RcdFound256 != 0 )
            {
               init_level_properties256( ) ;
               getByPrimaryKey5V256( ) ;
               addRow5V256( ) ;
               scanNext5V256( ) ;
            }
            scanEnd5V256( ) ;
            nBlankRcdCount256 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal5V256( ) ;
         standaloneModal5V256( ) ;
         sMode256 = Gx_mode ;
         while ( nGXsfl_41_idx < nRC_GXsfl_41 )
         {
            bGXsfl_41_Refreshing = true ;
            readRow5V256( ) ;
            edtMenuOpcCod_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MENUOPCCOD_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtMenuOpcCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuOpcCod_Enabled), 5, 0), !bGXsfl_41_Refreshing);
            edtMenuItemId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MENUITEMID_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtMenuItemId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemId_Enabled), 5, 0), !bGXsfl_41_Refreshing);
            edtMenuOpcTitulo_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MENUOPCTITULO_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtMenuOpcTitulo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuOpcTitulo_Enabled), 5, 0), !bGXsfl_41_Refreshing);
            dynMenuOpcPadre.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "MENUOPCPADRE_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, dynMenuOpcPadre.getInternalname(), "Enabled", GXutil.ltrimstr( dynMenuOpcPadre.getEnabled(), 5, 0), !bGXsfl_41_Refreshing);
            dynSVGId.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "SVGID_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, dynSVGId.getInternalname(), "Enabled", GXutil.ltrimstr( dynSVGId.getEnabled(), 5, 0), !bGXsfl_41_Refreshing);
            edtMenuItemImg_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MENUITEMIMG_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtMenuItemImg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemImg_Enabled), 5, 0), !bGXsfl_41_Refreshing);
            chkMenuHomeEs.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "MENUHOMEES_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, chkMenuHomeEs.getInternalname(), "Enabled", GXutil.ltrimstr( chkMenuHomeEs.getEnabled(), 5, 0), !bGXsfl_41_Refreshing);
            edtMenuItemOrd_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MENUITEMORD_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtMenuItemOrd_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemOrd_Enabled), 5, 0), !bGXsfl_41_Refreshing);
            edtMenuBienveTitulo_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MENUBIENVETITULO_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtMenuBienveTitulo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuBienveTitulo_Enabled), 5, 0), !bGXsfl_41_Refreshing);
            edtMenuBienveTexto_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MENUBIENVETEXTO_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtMenuBienveTexto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuBienveTexto_Enabled), 5, 0), !bGXsfl_41_Refreshing);
            edtMenuBienveImg_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MENUBIENVEIMG_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtMenuBienveImg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuBienveImg_Enabled), 5, 0), !bGXsfl_41_Refreshing);
            chkMenuBienveVisible.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "MENUBIENVEVISIBLE_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, chkMenuBienveVisible.getInternalname(), "Enabled", GXutil.ltrimstr( chkMenuBienveVisible.getEnabled(), 5, 0), !bGXsfl_41_Refreshing);
            chkMenuOpcInst.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "MENUOPCINST_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, chkMenuOpcInst.getInternalname(), "Enabled", GXutil.ltrimstr( chkMenuOpcInst.getEnabled(), 5, 0), !bGXsfl_41_Refreshing);
            chkMenuOpcForRet.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "MENUOPCFORRET_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, chkMenuOpcForRet.getInternalname(), "Enabled", GXutil.ltrimstr( chkMenuOpcForRet.getEnabled(), 5, 0), !bGXsfl_41_Refreshing);
            if ( ( nRcdExists_256 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal5V256( ) ;
            }
            sendRow5V256( ) ;
            bGXsfl_41_Refreshing = false ;
         }
         Gx_mode = sMode256 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount256 = (short)(5) ;
         nRcdExists_256 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart5V256( ) ;
            while ( RcdFound256 != 0 )
            {
               sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_41256( ) ;
               init_level_properties256( ) ;
               standaloneNotModal5V256( ) ;
               getByPrimaryKey5V256( ) ;
               standaloneModal5V256( ) ;
               addRow5V256( ) ;
               scanNext5V256( ) ;
            }
            scanEnd5V256( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode256 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_41256( ) ;
         initAll5V256( ) ;
         init_level_properties256( ) ;
         nRcdExists_256 = (short)(0) ;
         nIsMod_256 = (short)(0) ;
         nRcdDeleted_256 = (short)(0) ;
         nBlankRcdCount256 = (short)(nBlankRcdUsr256+nBlankRcdCount256) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount256 > 0 )
         {
            standaloneNotModal5V256( ) ;
            standaloneModal5V256( ) ;
            addRow5V256( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtMenuOpcCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount256 = (short)(nBlankRcdCount256-1) ;
         }
         Gx_mode = sMode256 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel_opcionesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_opciones", Gridlevel_opcionesContainer, subGridlevel_opciones_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_opcionesContainerData", Gridlevel_opcionesContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_opcionesContainerData"+"V", Gridlevel_opcionesContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_opcionesContainerData"+"V"+"\" value='"+Gridlevel_opcionesContainer.GridValuesHidden()+"'/>") ;
      }
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_MenuVersiones.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_MenuVersiones.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_MenuVersiones.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      /* End of table */
      httpContext.writeText( "</table>") ;
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtRolId_Internalname, GXutil.ltrim( localUtil.ntoc( A1923RolId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1923RolId), "Z9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,68);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRolId_Jsonclick, 0, "Attribute", "", "", "", "", edtRolId_Visible, edtRolId_Enabled, 1, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_MenuVersiones.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void userMain( )
   {
      standaloneStartup( ) ;
   }

   public void userMainFullajax( )
   {
      initenv( ) ;
      inittrn( ) ;
      userMain( ) ;
      draw( ) ;
      sendCloseFormHiddens( ) ;
   }

   public void standaloneStartup( )
   {
      standaloneStartupServer( ) ;
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e115V2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z1923RolId = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1923RolId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1925PerfilId = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1925PerfilId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1928MenuVerId = localUtil.ctol( httpContext.cgiGet( "Z1928MenuVerId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z1927MenuPais = (short)(localUtil.ctol( httpContext.cgiGet( "Z1927MenuPais"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1927MenuPais = ((0==A1927MenuPais) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_41 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_41"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            N1927MenuPais = (short)(localUtil.ctol( httpContext.cgiGet( "N1927MenuPais"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1927MenuPais = ((0==A1927MenuPais) ? true : false) ;
            AV7RolId = (byte)(localUtil.ctol( httpContext.cgiGet( "vROLID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8PerfilId = (byte)(localUtil.ctol( httpContext.cgiGet( "vPERFILID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9MenuVerId = localUtil.ctol( httpContext.cgiGet( "vMENUVERID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV15Insert_MenuPais = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_MENUPAIS"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV31Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            A2362MenuOpcHormiga = httpContext.cgiGet( "MENUOPCHORMIGA") ;
            A1939MenuItemTitulo = httpContext.cgiGet( "MENUITEMTITULO") ;
            AV21MitemIcoImg = httpContext.cgiGet( "vMITEMICOIMG") ;
            AV22MItemBienImgDef = httpContext.cgiGet( "vMITEMBIENIMGDEF") ;
            AV23MItemBienTitDef = httpContext.cgiGet( "vMITEMBIENTITDEF") ;
            AV24MItemBienTextDef = httpContext.cgiGet( "vMITEMBIENTEXTDEF") ;
            AV20MItemIcoSVG = httpContext.cgiGet( "vMITEMICOSVG") ;
            A2361MenuOpcObj = httpContext.cgiGet( "MENUOPCOBJ") ;
            A1942MenuItemImgExt = httpContext.cgiGet( "MENUITEMIMGEXT") ;
            A1947MenuBienveImgExt = httpContext.cgiGet( "MENUBIENVEIMGEXT") ;
            A1943MenuItemImgNom = httpContext.cgiGet( "MENUITEMIMGNOM") ;
            A1948MenuBienveImgNom = httpContext.cgiGet( "MENUBIENVEIMGNOM") ;
            Dvpanel_tableattributes_Objectcall = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Objectcall") ;
            Dvpanel_tableattributes_Class = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Class") ;
            Dvpanel_tableattributes_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Enabled")) ;
            Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
            Dvpanel_tableattributes_Height = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Height") ;
            Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
            Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
            Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
            Dvpanel_tableattributes_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showheader")) ;
            Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
            Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
            Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
            Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
            Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
            Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
            Dvpanel_tableattributes_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Visible")) ;
            Dvpanel_tableattributes_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            dynPerfilId.setName( dynPerfilId.getInternalname() );
            dynPerfilId.setValue( httpContext.cgiGet( dynPerfilId.getInternalname()) );
            A1925PerfilId = (byte)(GXutil.lval( httpContext.cgiGet( dynPerfilId.getInternalname()))) ;
            n1925PerfilId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtMenuVerId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtMenuVerId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "MENUVERID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMenuVerId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1928MenuVerId = 0 ;
               n1928MenuVerId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1928MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1928MenuVerId), 15, 0));
            }
            else
            {
               A1928MenuVerId = localUtil.ctol( httpContext.cgiGet( edtMenuVerId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               n1928MenuVerId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1928MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1928MenuVerId), 15, 0));
            }
            dynMenuPais.setName( dynMenuPais.getInternalname() );
            dynMenuPais.setValue( httpContext.cgiGet( dynMenuPais.getInternalname()) );
            A1927MenuPais = (short)(GXutil.lval( httpContext.cgiGet( dynMenuPais.getInternalname()))) ;
            n1927MenuPais = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1927MenuPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1927MenuPais), 4, 0));
            n1927MenuPais = ((0==A1927MenuPais) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtRolId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtRolId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "ROLID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtRolId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1923RolId = (byte)(0) ;
               n1923RolId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
            }
            else
            {
               A1923RolId = (byte)(localUtil.ctol( httpContext.cgiGet( edtRolId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n1923RolId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"MenuVersiones");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A1923RolId != Z1923RolId ) || ( A1925PerfilId != Z1925PerfilId ) || ( A1928MenuVerId != Z1928MenuVerId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("menuversiones:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            /* Check if conditions changed and reset current page numbers */
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A1923RolId = (byte)(GXutil.lval( httpContext.GetPar( "RolId"))) ;
               n1923RolId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
               A1925PerfilId = (byte)(GXutil.lval( httpContext.GetPar( "PerfilId"))) ;
               n1925PerfilId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
               A1928MenuVerId = GXutil.lval( httpContext.GetPar( "MenuVerId")) ;
               n1928MenuVerId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1928MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1928MenuVerId), 15, 0));
               getEqualNoModal( ) ;
               if ( ! (0==AV7RolId) )
               {
                  A1923RolId = AV7RolId ;
                  n1923RolId = false ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
               }
               else
               {
                  if ( isIns( )  && (0==A1923RolId) && ( Gx_BScreen == 0 ) )
                  {
                     A1923RolId = (byte)(1) ;
                     n1923RolId = false ;
                     httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
                  }
               }
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode255 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  if ( ! (0==AV7RolId) )
                  {
                     A1923RolId = AV7RolId ;
                     n1923RolId = false ;
                     httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
                  }
                  else
                  {
                     if ( isIns( )  && (0==A1923RolId) && ( Gx_BScreen == 0 ) )
                     {
                        A1923RolId = (byte)(1) ;
                        n1923RolId = false ;
                        httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
                     }
                  }
                  Gx_mode = sMode255 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound255 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_5V0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "ROLID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtRolId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
   }

   public void process( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read Transaction buttons. */
         sEvt = httpContext.cgiGet( "_EventName") ;
         EvtGridId = httpContext.cgiGet( "_EventGridId") ;
         EvtRowId = httpContext.cgiGet( "_EventRowId") ;
         if ( GXutil.len( sEvt) > 0 )
         {
            sEvtType = GXutil.left( sEvt, 1) ;
            sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
            if ( GXutil.strcmp(sEvtType, "M") != 0 )
            {
               if ( GXutil.strcmp(sEvtType, "E") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, 1) ;
                  if ( GXutil.strcmp(sEvtType, ".") == 0 )
                  {
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                     if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e115V2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e125V2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! isDsp( ) )
                        {
                           btn_enter( ) ;
                        }
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                  }
                  else
                  {
                     sEvtType = GXutil.right( sEvt, 4) ;
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                  }
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e125V2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll5V255( ) ;
            standaloneNotModal( ) ;
            standaloneModal( ) ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public void disable_std_buttons( )
   {
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) || isDlt( ) )
      {
         bttBtntrn_delete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
         if ( isDsp( ) )
         {
            bttBtntrn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
         }
         disableAttributes5V255( ) ;
      }
   }

   public void set_caption( )
   {
      if ( ( IsConfirmed == 1 ) && ( AnyError == 0 ) )
      {
         if ( isDlt( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_confdelete"), 0, "", true);
         }
         else
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_mustconfirm"), 0, "", true);
         }
      }
   }

   public void confirm_5V0( )
   {
      beforeValidate5V255( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls5V255( ) ;
         }
         else
         {
            checkExtendedTable5V255( ) ;
            closeExtendedTableCursors5V255( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode255 = Gx_mode ;
         confirm_5V256( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode255 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode255 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_5V256( )
   {
      nGXsfl_41_idx = 0 ;
      while ( nGXsfl_41_idx < nRC_GXsfl_41 )
      {
         readRow5V256( ) ;
         if ( ( nRcdExists_256 != 0 ) || ( nIsMod_256 != 0 ) )
         {
            getKey5V256( ) ;
            if ( ( nRcdExists_256 == 0 ) && ( nRcdDeleted_256 == 0 ) )
            {
               if ( RcdFound256 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate5V256( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable5V256( ) ;
                     closeExtendedTableCursors5V256( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "MENUOPCCOD_" + sGXsfl_41_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtMenuOpcCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound256 != 0 )
               {
                  if ( nRcdDeleted_256 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey5V256( ) ;
                     load5V256( ) ;
                     beforeValidate5V256( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls5V256( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_256 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate5V256( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable5V256( ) ;
                           closeExtendedTableCursors5V256( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_256 == 0 )
                  {
                     GXCCtl = "MENUOPCCOD_" + sGXsfl_41_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtMenuOpcCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtMenuOpcCod_Internalname, A1929MenuOpcCod) ;
         httpContext.changePostValue( edtMenuItemId_Internalname, A1937MenuItemId) ;
         httpContext.changePostValue( edtMenuOpcTitulo_Internalname, A1931MenuOpcTitulo) ;
         httpContext.changePostValue( dynMenuOpcPadre.getInternalname(), GXutil.rtrim( A1933MenuOpcPadre)) ;
         httpContext.changePostValue( dynSVGId.getInternalname(), GXutil.rtrim( A1935SVGId)) ;
         httpContext.changePostValue( edtMenuItemImg_Internalname, A1941MenuItemImg) ;
         httpContext.changePostValue( chkMenuHomeEs.getInternalname(), GXutil.booltostr( A1934MenuHomeEs)) ;
         httpContext.changePostValue( edtMenuItemOrd_Internalname, GXutil.ltrim( localUtil.ntoc( A1940MenuItemOrd, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtMenuBienveTitulo_Internalname, A1949MenuBienveTitulo) ;
         httpContext.changePostValue( edtMenuBienveTexto_Internalname, A1950MenuBienveTexto) ;
         httpContext.changePostValue( edtMenuBienveImg_Internalname, A1946MenuBienveImg) ;
         httpContext.changePostValue( chkMenuBienveVisible.getInternalname(), GXutil.booltostr( A1951MenuBienveVisible)) ;
         httpContext.changePostValue( chkMenuOpcInst.getInternalname(), GXutil.booltostr( A2363MenuOpcInst)) ;
         httpContext.changePostValue( chkMenuOpcForRet.getInternalname(), GXutil.booltostr( A2367MenuOpcForRet)) ;
         httpContext.changePostValue( "ZT_"+"Z1929MenuOpcCod_"+sGXsfl_41_idx, Z1929MenuOpcCod) ;
         httpContext.changePostValue( "ZT_"+"Z1931MenuOpcTitulo_"+sGXsfl_41_idx, Z1931MenuOpcTitulo) ;
         httpContext.changePostValue( "ZT_"+"Z1951MenuBienveVisible_"+sGXsfl_41_idx, GXutil.booltostr( Z1951MenuBienveVisible)) ;
         httpContext.changePostValue( "ZT_"+"Z1933MenuOpcPadre_"+sGXsfl_41_idx, GXutil.rtrim( Z1933MenuOpcPadre)) ;
         httpContext.changePostValue( "ZT_"+"Z1934MenuHomeEs_"+sGXsfl_41_idx, GXutil.booltostr( Z1934MenuHomeEs)) ;
         httpContext.changePostValue( "ZT_"+"Z1940MenuItemOrd_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( Z1940MenuItemOrd, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1949MenuBienveTitulo_"+sGXsfl_41_idx, Z1949MenuBienveTitulo) ;
         httpContext.changePostValue( "ZT_"+"Z2361MenuOpcObj_"+sGXsfl_41_idx, GXutil.rtrim( Z2361MenuOpcObj)) ;
         httpContext.changePostValue( "ZT_"+"Z2363MenuOpcInst_"+sGXsfl_41_idx, GXutil.booltostr( Z2363MenuOpcInst)) ;
         httpContext.changePostValue( "ZT_"+"Z2367MenuOpcForRet_"+sGXsfl_41_idx, GXutil.booltostr( Z2367MenuOpcForRet)) ;
         httpContext.changePostValue( "ZT_"+"Z1935SVGId_"+sGXsfl_41_idx, GXutil.rtrim( Z1935SVGId)) ;
         httpContext.changePostValue( "ZT_"+"Z1937MenuItemId_"+sGXsfl_41_idx, Z1937MenuItemId) ;
         httpContext.changePostValue( "nRcdDeleted_256_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_256, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_256_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_256, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_256_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_256, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_256 != 0 )
         {
            httpContext.changePostValue( "MENUOPCCOD_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuOpcCod_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUITEMID_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuItemId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUOPCTITULO_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuOpcTitulo_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUOPCPADRE_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynMenuOpcPadre.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SVGID_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynSVGId.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUITEMIMG_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuItemImg_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUHOMEES_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkMenuHomeEs.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUITEMORD_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuItemOrd_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUBIENVETITULO_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuBienveTitulo_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUBIENVETEXTO_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuBienveTexto_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUBIENVEIMG_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuBienveImg_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUBIENVEVISIBLE_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkMenuBienveVisible.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUOPCINST_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkMenuOpcInst.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUOPCFORRET_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkMenuOpcForRet.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption5V0( )
   {
   }

   public void e115V2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV10WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV10WWPContext = GXv_SdtWWPContext1[0] ;
      AV11IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMenuVersiones_Insert", GXv_boolean3) ;
         menuversiones_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMenuVersiones_Update", GXv_boolean3) ;
         menuversiones_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMenuVersiones_Delete", GXv_boolean3) ;
         menuversiones_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( ! AV11IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV31Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV13TrnContext.fromxml(AV14WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV13TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV31Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV32GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV32GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32GXV1), 8, 0));
         while ( AV32GXV1 <= AV13TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV16TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV13TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV32GXV1));
            if ( GXutil.strcmp(AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "MenuPais") == 0 )
            {
               AV15Insert_MenuPais = (short)(GXutil.lval( AV16TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV15Insert_MenuPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15Insert_MenuPais), 4, 0));
            }
            AV32GXV1 = (int)(AV32GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32GXV1), 8, 0));
         }
      }
      edtRolId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRolId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRolId_Visible), 5, 0), true);
   }

   public void e125V2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(8);
      pr_default.close(7);
      pr_default.close(6);
      pr_default.close(5);
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm5V255( int GX_JID )
   {
      if ( ( GX_JID == 27 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1927MenuPais = T005V7_A1927MenuPais[0] ;
         }
         else
         {
            Z1927MenuPais = A1927MenuPais ;
         }
      }
      if ( GX_JID == -27 )
      {
         Z1928MenuVerId = A1928MenuVerId ;
         Z1923RolId = A1923RolId ;
         Z1925PerfilId = A1925PerfilId ;
         Z1927MenuPais = A1927MenuPais ;
      }
   }

   public void standaloneNotModal( )
   {
      gxamenupais_html5V255( ) ;
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7RolId) )
      {
         edtRolId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtRolId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRolId_Enabled), 5, 0), true);
      }
      else
      {
         edtRolId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtRolId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRolId_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7RolId) )
      {
         edtRolId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtRolId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRolId_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8PerfilId) )
      {
         A1925PerfilId = AV8PerfilId ;
         n1925PerfilId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
      }
      if ( ! (0==AV8PerfilId) )
      {
         dynPerfilId.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynPerfilId.getInternalname(), "Enabled", GXutil.ltrimstr( dynPerfilId.getEnabled(), 5, 0), true);
      }
      else
      {
         dynPerfilId.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynPerfilId.getInternalname(), "Enabled", GXutil.ltrimstr( dynPerfilId.getEnabled(), 5, 0), true);
      }
      if ( ! (0==AV8PerfilId) )
      {
         dynPerfilId.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynPerfilId.getInternalname(), "Enabled", GXutil.ltrimstr( dynPerfilId.getEnabled(), 5, 0), true);
      }
      if ( ! (0==AV9MenuVerId) )
      {
         A1928MenuVerId = AV9MenuVerId ;
         n1928MenuVerId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1928MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1928MenuVerId), 15, 0));
      }
      if ( ! (0==AV9MenuVerId) )
      {
         edtMenuVerId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuVerId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuVerId_Enabled), 5, 0), true);
      }
      else
      {
         edtMenuVerId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuVerId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuVerId_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9MenuVerId) )
      {
         edtMenuVerId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuVerId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuVerId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV15Insert_MenuPais) )
      {
         dynMenuPais.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynMenuPais.getInternalname(), "Enabled", GXutil.ltrimstr( dynMenuPais.getEnabled(), 5, 0), true);
      }
      else
      {
         dynMenuPais.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynMenuPais.getInternalname(), "Enabled", GXutil.ltrimstr( dynMenuPais.getEnabled(), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV15Insert_MenuPais) )
      {
         A1927MenuPais = AV15Insert_MenuPais ;
         n1927MenuPais = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1927MenuPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1927MenuPais), 4, 0));
      }
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtntrn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7RolId) )
      {
         A1923RolId = AV7RolId ;
         n1923RolId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
      }
      else
      {
         if ( isIns( )  && (0==A1923RolId) && ( Gx_BScreen == 0 ) )
         {
            A1923RolId = (byte)(1) ;
            n1923RolId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV31Pgmname = "MenuVersiones" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31Pgmname", AV31Pgmname);
      }
   }

   public void load5V255( )
   {
      /* Using cursor T005V11 */
      pr_default.execute(9, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound255 = (short)(1) ;
         A1927MenuPais = T005V11_A1927MenuPais[0] ;
         n1927MenuPais = T005V11_n1927MenuPais[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1927MenuPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1927MenuPais), 4, 0));
         zm5V255( -27) ;
      }
      pr_default.close(9);
      onLoadActions5V255( ) ;
   }

   public void onLoadActions5V255( )
   {
      AV31Pgmname = "MenuVersiones" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31Pgmname", AV31Pgmname);
   }

   public void checkExtendedTable5V255( )
   {
      nIsDirty_255 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV31Pgmname = "MenuVersiones" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31Pgmname", AV31Pgmname);
      /* Using cursor T005V8 */
      pr_default.execute(6, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "RolUsuario", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ROLID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtRolId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(6);
      /* Using cursor T005V9 */
      pr_default.execute(7, new Object[] {Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Perfil", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PERFILID");
         AnyError = (short)(1) ;
         GX_FocusControl = dynPerfilId.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(7);
      /* Using cursor T005V10 */
      pr_default.execute(8, new Object[] {Boolean.valueOf(n1927MenuPais), Short.valueOf(A1927MenuPais)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         if ( ! ( (0==A1927MenuPais) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais Menu", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MENUPAIS");
            AnyError = (short)(1) ;
            GX_FocusControl = dynMenuPais.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(8);
   }

   public void closeExtendedTableCursors5V255( )
   {
      pr_default.close(6);
      pr_default.close(7);
      pr_default.close(8);
   }

   public void enableDisable( )
   {
   }

   public void gxload_28( byte A1923RolId )
   {
      /* Using cursor T005V12 */
      pr_default.execute(10, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "RolUsuario", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ROLID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtRolId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(10) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(10);
   }

   public void gxload_29( byte A1925PerfilId )
   {
      /* Using cursor T005V13 */
      pr_default.execute(11, new Object[] {Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Perfil", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PERFILID");
         AnyError = (short)(1) ;
         GX_FocusControl = dynPerfilId.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(11) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(11);
   }

   public void gxload_30( short A1927MenuPais )
   {
      /* Using cursor T005V14 */
      pr_default.execute(12, new Object[] {Boolean.valueOf(n1927MenuPais), Short.valueOf(A1927MenuPais)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         if ( ! ( (0==A1927MenuPais) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais Menu", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MENUPAIS");
            AnyError = (short)(1) ;
            GX_FocusControl = dynMenuPais.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(12) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(12);
   }

   public void getKey5V255( )
   {
      /* Using cursor T005V15 */
      pr_default.execute(13, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId)});
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound255 = (short)(1) ;
      }
      else
      {
         RcdFound255 = (short)(0) ;
      }
      pr_default.close(13);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T005V7 */
      pr_default.execute(5, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         zm5V255( 27) ;
         RcdFound255 = (short)(1) ;
         A1928MenuVerId = T005V7_A1928MenuVerId[0] ;
         n1928MenuVerId = T005V7_n1928MenuVerId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1928MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1928MenuVerId), 15, 0));
         A1923RolId = T005V7_A1923RolId[0] ;
         n1923RolId = T005V7_n1923RolId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
         A1925PerfilId = T005V7_A1925PerfilId[0] ;
         n1925PerfilId = T005V7_n1925PerfilId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
         A1927MenuPais = T005V7_A1927MenuPais[0] ;
         n1927MenuPais = T005V7_n1927MenuPais[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1927MenuPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1927MenuPais), 4, 0));
         Z1923RolId = A1923RolId ;
         Z1925PerfilId = A1925PerfilId ;
         Z1928MenuVerId = A1928MenuVerId ;
         sMode255 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load5V255( ) ;
         if ( AnyError == 1 )
         {
            RcdFound255 = (short)(0) ;
            initializeNonKey5V255( ) ;
         }
         Gx_mode = sMode255 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound255 = (short)(0) ;
         initializeNonKey5V255( ) ;
         sMode255 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode255 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(5);
   }

   public void getEqualNoModal( )
   {
      getKey5V255( ) ;
      if ( RcdFound255 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound255 = (short)(0) ;
      /* Using cursor T005V16 */
      pr_default.execute(14, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId)});
      if ( (pr_default.getStatus(14) != 101) )
      {
         while ( (pr_default.getStatus(14) != 101) && ( ( T005V16_A1923RolId[0] < A1923RolId ) || ( T005V16_A1923RolId[0] == A1923RolId ) && ( T005V16_A1925PerfilId[0] < A1925PerfilId ) || ( T005V16_A1925PerfilId[0] == A1925PerfilId ) && ( T005V16_A1923RolId[0] == A1923RolId ) && ( T005V16_A1928MenuVerId[0] < A1928MenuVerId ) ) )
         {
            pr_default.readNext(14);
         }
         if ( (pr_default.getStatus(14) != 101) && ( ( T005V16_A1923RolId[0] > A1923RolId ) || ( T005V16_A1923RolId[0] == A1923RolId ) && ( T005V16_A1925PerfilId[0] > A1925PerfilId ) || ( T005V16_A1925PerfilId[0] == A1925PerfilId ) && ( T005V16_A1923RolId[0] == A1923RolId ) && ( T005V16_A1928MenuVerId[0] > A1928MenuVerId ) ) )
         {
            A1923RolId = T005V16_A1923RolId[0] ;
            n1923RolId = T005V16_n1923RolId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
            A1925PerfilId = T005V16_A1925PerfilId[0] ;
            n1925PerfilId = T005V16_n1925PerfilId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
            A1928MenuVerId = T005V16_A1928MenuVerId[0] ;
            n1928MenuVerId = T005V16_n1928MenuVerId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1928MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1928MenuVerId), 15, 0));
            RcdFound255 = (short)(1) ;
         }
      }
      pr_default.close(14);
   }

   public void move_previous( )
   {
      RcdFound255 = (short)(0) ;
      /* Using cursor T005V17 */
      pr_default.execute(15, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         while ( (pr_default.getStatus(15) != 101) && ( ( T005V17_A1923RolId[0] > A1923RolId ) || ( T005V17_A1923RolId[0] == A1923RolId ) && ( T005V17_A1925PerfilId[0] > A1925PerfilId ) || ( T005V17_A1925PerfilId[0] == A1925PerfilId ) && ( T005V17_A1923RolId[0] == A1923RolId ) && ( T005V17_A1928MenuVerId[0] > A1928MenuVerId ) ) )
         {
            pr_default.readNext(15);
         }
         if ( (pr_default.getStatus(15) != 101) && ( ( T005V17_A1923RolId[0] < A1923RolId ) || ( T005V17_A1923RolId[0] == A1923RolId ) && ( T005V17_A1925PerfilId[0] < A1925PerfilId ) || ( T005V17_A1925PerfilId[0] == A1925PerfilId ) && ( T005V17_A1923RolId[0] == A1923RolId ) && ( T005V17_A1928MenuVerId[0] < A1928MenuVerId ) ) )
         {
            A1923RolId = T005V17_A1923RolId[0] ;
            n1923RolId = T005V17_n1923RolId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
            A1925PerfilId = T005V17_A1925PerfilId[0] ;
            n1925PerfilId = T005V17_n1925PerfilId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
            A1928MenuVerId = T005V17_A1928MenuVerId[0] ;
            n1928MenuVerId = T005V17_n1928MenuVerId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1928MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1928MenuVerId), 15, 0));
            RcdFound255 = (short)(1) ;
         }
      }
      pr_default.close(15);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey5V255( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = dynPerfilId.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert5V255( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound255 == 1 )
         {
            if ( ( A1923RolId != Z1923RolId ) || ( A1925PerfilId != Z1925PerfilId ) || ( A1928MenuVerId != Z1928MenuVerId ) )
            {
               A1923RolId = Z1923RolId ;
               n1923RolId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
               A1925PerfilId = Z1925PerfilId ;
               n1925PerfilId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
               A1928MenuVerId = Z1928MenuVerId ;
               n1928MenuVerId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1928MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1928MenuVerId), 15, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "ROLID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtRolId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = dynPerfilId.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update5V255( ) ;
               GX_FocusControl = dynPerfilId.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A1923RolId != Z1923RolId ) || ( A1925PerfilId != Z1925PerfilId ) || ( A1928MenuVerId != Z1928MenuVerId ) )
            {
               /* Insert record */
               GX_FocusControl = dynPerfilId.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert5V255( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "ROLID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtRolId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = dynPerfilId.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert5V255( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
      if ( isUpd( ) || isDlt( ) )
      {
         if ( AnyError == 0 )
         {
            httpContext.nUserReturn = (byte)(1) ;
         }
      }
   }

   public void btn_delete( )
   {
      if ( ( A1923RolId != Z1923RolId ) || ( A1925PerfilId != Z1925PerfilId ) || ( A1928MenuVerId != Z1928MenuVerId ) )
      {
         A1923RolId = Z1923RolId ;
         n1923RolId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
         A1925PerfilId = Z1925PerfilId ;
         n1925PerfilId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
         A1928MenuVerId = Z1928MenuVerId ;
         n1928MenuVerId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1928MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1928MenuVerId), 15, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "ROLID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtRolId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = dynPerfilId.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency5V255( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T005V6 */
         pr_default.execute(4, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId)});
         if ( (pr_default.getStatus(4) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"MenuVersiones"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(4) == 101) || ( Z1927MenuPais != T005V6_A1927MenuPais[0] ) )
         {
            if ( Z1927MenuPais != T005V6_A1927MenuPais[0] )
            {
               GXutil.writeLogln("menuversiones:[seudo value changed for attri]"+"MenuPais");
               GXutil.writeLogRaw("Old: ",Z1927MenuPais);
               GXutil.writeLogRaw("Current: ",T005V6_A1927MenuPais[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"MenuVersiones"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert5V255( )
   {
      beforeValidate5V255( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5V255( ) ;
      }
      if ( AnyError == 0 )
      {
         zm5V255( 0) ;
         checkOptimisticConcurrency5V255( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5V255( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert5V255( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005V18 */
                  pr_default.execute(16, new Object[] {Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId), Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1927MenuPais), Short.valueOf(A1927MenuPais)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuVersiones");
                  if ( (pr_default.getStatus(16) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel5V255( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption5V0( ) ;
                        }
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load5V255( ) ;
         }
         endLevel5V255( ) ;
      }
      closeExtendedTableCursors5V255( ) ;
   }

   public void update5V255( )
   {
      beforeValidate5V255( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5V255( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5V255( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5V255( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate5V255( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005V19 */
                  pr_default.execute(17, new Object[] {Boolean.valueOf(n1927MenuPais), Short.valueOf(A1927MenuPais), Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuVersiones");
                  if ( (pr_default.getStatus(17) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"MenuVersiones"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate5V255( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel5V255( ) ;
                        if ( AnyError == 0 )
                        {
                           if ( isUpd( ) || isDlt( ) )
                           {
                              if ( AnyError == 0 )
                              {
                                 httpContext.nUserReturn = (byte)(1) ;
                              }
                           }
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel5V255( ) ;
      }
      closeExtendedTableCursors5V255( ) ;
   }

   public void deferredUpdate5V255( )
   {
   }

   public void delete( )
   {
      beforeValidate5V255( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5V255( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls5V255( ) ;
         afterConfirm5V255( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete5V255( ) ;
            if ( AnyError == 0 )
            {
               scanStart5V256( ) ;
               while ( RcdFound256 != 0 )
               {
                  getByPrimaryKey5V256( ) ;
                  delete5V256( ) ;
                  scanNext5V256( ) ;
               }
               scanEnd5V256( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005V20 */
                  pr_default.execute(18, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuVersiones");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( delete) rules */
                     /* End of After( delete) rules */
                     if ( AnyError == 0 )
                     {
                        if ( isUpd( ) || isDlt( ) )
                        {
                           if ( AnyError == 0 )
                           {
                              httpContext.nUserReturn = (byte)(1) ;
                           }
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
      }
      sMode255 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel5V255( ) ;
      Gx_mode = sMode255 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls5V255( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV31Pgmname = "MenuVersiones" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31Pgmname", AV31Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T005V21 */
         pr_default.execute(19, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId)});
         if ( (pr_default.getStatus(19) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "User", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(19);
         /* Using cursor T005V22 */
         pr_default.execute(20, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId)});
         if ( (pr_default.getStatus(20) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "MenuVerOpcPermisos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(20);
      }
   }

   public void processNestedLevel5V256( )
   {
      nGXsfl_41_idx = 0 ;
      while ( nGXsfl_41_idx < nRC_GXsfl_41 )
      {
         readRow5V256( ) ;
         if ( ( nRcdExists_256 != 0 ) || ( nIsMod_256 != 0 ) )
         {
            standaloneNotModal5V256( ) ;
            getKey5V256( ) ;
            if ( ( nRcdExists_256 == 0 ) && ( nRcdDeleted_256 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert5V256( ) ;
            }
            else
            {
               if ( RcdFound256 != 0 )
               {
                  if ( ( nRcdDeleted_256 != 0 ) && ( nRcdExists_256 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete5V256( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_256 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update5V256( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_256 == 0 )
                  {
                     GXCCtl = "MENUOPCCOD_" + sGXsfl_41_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtMenuOpcCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtMenuOpcCod_Internalname, A1929MenuOpcCod) ;
         httpContext.changePostValue( edtMenuItemId_Internalname, A1937MenuItemId) ;
         httpContext.changePostValue( edtMenuOpcTitulo_Internalname, A1931MenuOpcTitulo) ;
         httpContext.changePostValue( dynMenuOpcPadre.getInternalname(), GXutil.rtrim( A1933MenuOpcPadre)) ;
         httpContext.changePostValue( dynSVGId.getInternalname(), GXutil.rtrim( A1935SVGId)) ;
         httpContext.changePostValue( edtMenuItemImg_Internalname, A1941MenuItemImg) ;
         httpContext.changePostValue( chkMenuHomeEs.getInternalname(), GXutil.booltostr( A1934MenuHomeEs)) ;
         httpContext.changePostValue( edtMenuItemOrd_Internalname, GXutil.ltrim( localUtil.ntoc( A1940MenuItemOrd, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtMenuBienveTitulo_Internalname, A1949MenuBienveTitulo) ;
         httpContext.changePostValue( edtMenuBienveTexto_Internalname, A1950MenuBienveTexto) ;
         httpContext.changePostValue( edtMenuBienveImg_Internalname, A1946MenuBienveImg) ;
         httpContext.changePostValue( chkMenuBienveVisible.getInternalname(), GXutil.booltostr( A1951MenuBienveVisible)) ;
         httpContext.changePostValue( chkMenuOpcInst.getInternalname(), GXutil.booltostr( A2363MenuOpcInst)) ;
         httpContext.changePostValue( chkMenuOpcForRet.getInternalname(), GXutil.booltostr( A2367MenuOpcForRet)) ;
         httpContext.changePostValue( "ZT_"+"Z1929MenuOpcCod_"+sGXsfl_41_idx, Z1929MenuOpcCod) ;
         httpContext.changePostValue( "ZT_"+"Z1931MenuOpcTitulo_"+sGXsfl_41_idx, Z1931MenuOpcTitulo) ;
         httpContext.changePostValue( "ZT_"+"Z1951MenuBienveVisible_"+sGXsfl_41_idx, GXutil.booltostr( Z1951MenuBienveVisible)) ;
         httpContext.changePostValue( "ZT_"+"Z1933MenuOpcPadre_"+sGXsfl_41_idx, GXutil.rtrim( Z1933MenuOpcPadre)) ;
         httpContext.changePostValue( "ZT_"+"Z1934MenuHomeEs_"+sGXsfl_41_idx, GXutil.booltostr( Z1934MenuHomeEs)) ;
         httpContext.changePostValue( "ZT_"+"Z1940MenuItemOrd_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( Z1940MenuItemOrd, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1949MenuBienveTitulo_"+sGXsfl_41_idx, Z1949MenuBienveTitulo) ;
         httpContext.changePostValue( "ZT_"+"Z2361MenuOpcObj_"+sGXsfl_41_idx, GXutil.rtrim( Z2361MenuOpcObj)) ;
         httpContext.changePostValue( "ZT_"+"Z2363MenuOpcInst_"+sGXsfl_41_idx, GXutil.booltostr( Z2363MenuOpcInst)) ;
         httpContext.changePostValue( "ZT_"+"Z2367MenuOpcForRet_"+sGXsfl_41_idx, GXutil.booltostr( Z2367MenuOpcForRet)) ;
         httpContext.changePostValue( "ZT_"+"Z1935SVGId_"+sGXsfl_41_idx, GXutil.rtrim( Z1935SVGId)) ;
         httpContext.changePostValue( "ZT_"+"Z1937MenuItemId_"+sGXsfl_41_idx, Z1937MenuItemId) ;
         httpContext.changePostValue( "nRcdDeleted_256_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_256, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_256_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_256, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_256_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_256, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_256 != 0 )
         {
            httpContext.changePostValue( "MENUOPCCOD_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuOpcCod_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUITEMID_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuItemId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUOPCTITULO_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuOpcTitulo_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUOPCPADRE_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynMenuOpcPadre.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SVGID_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynSVGId.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUITEMIMG_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuItemImg_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUHOMEES_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkMenuHomeEs.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUITEMORD_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuItemOrd_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUBIENVETITULO_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuBienveTitulo_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUBIENVETEXTO_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuBienveTexto_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUBIENVEIMG_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuBienveImg_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUBIENVEVISIBLE_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkMenuBienveVisible.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUOPCINST_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkMenuOpcInst.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MENUOPCFORRET_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkMenuOpcForRet.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll5V256( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_256 = (short)(0) ;
      nIsMod_256 = (short)(0) ;
      nRcdDeleted_256 = (short)(0) ;
   }

   public void processLevel5V255( )
   {
      /* Save parent mode. */
      sMode255 = Gx_mode ;
      processNestedLevel5V256( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode255 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel5V255( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(4);
      }
      if ( AnyError == 0 )
      {
         beforeComplete5V255( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "menuversiones");
         if ( AnyError == 0 )
         {
            confirmValues5V0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "menuversiones");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart5V255( )
   {
      /* Scan By routine */
      /* Using cursor T005V23 */
      pr_default.execute(21);
      RcdFound255 = (short)(0) ;
      if ( (pr_default.getStatus(21) != 101) )
      {
         RcdFound255 = (short)(1) ;
         A1923RolId = T005V23_A1923RolId[0] ;
         n1923RolId = T005V23_n1923RolId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
         A1925PerfilId = T005V23_A1925PerfilId[0] ;
         n1925PerfilId = T005V23_n1925PerfilId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
         A1928MenuVerId = T005V23_A1928MenuVerId[0] ;
         n1928MenuVerId = T005V23_n1928MenuVerId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1928MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1928MenuVerId), 15, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext5V255( )
   {
      /* Scan next routine */
      pr_default.readNext(21);
      RcdFound255 = (short)(0) ;
      if ( (pr_default.getStatus(21) != 101) )
      {
         RcdFound255 = (short)(1) ;
         A1923RolId = T005V23_A1923RolId[0] ;
         n1923RolId = T005V23_n1923RolId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
         A1925PerfilId = T005V23_A1925PerfilId[0] ;
         n1925PerfilId = T005V23_n1925PerfilId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
         A1928MenuVerId = T005V23_A1928MenuVerId[0] ;
         n1928MenuVerId = T005V23_n1928MenuVerId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1928MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1928MenuVerId), 15, 0));
      }
   }

   public void scanEnd5V255( )
   {
      pr_default.close(21);
   }

   public void afterConfirm5V255( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert5V255( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate5V255( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete5V255( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete5V255( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate5V255( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes5V255( )
   {
      dynPerfilId.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynPerfilId.getInternalname(), "Enabled", GXutil.ltrimstr( dynPerfilId.getEnabled(), 5, 0), true);
      edtMenuVerId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuVerId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuVerId_Enabled), 5, 0), true);
      dynMenuPais.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynMenuPais.getInternalname(), "Enabled", GXutil.ltrimstr( dynMenuPais.getEnabled(), 5, 0), true);
      edtRolId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRolId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRolId_Enabled), 5, 0), true);
   }

   public void zm5V256( int GX_JID )
   {
      if ( ( GX_JID == 31 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1931MenuOpcTitulo = T005V3_A1931MenuOpcTitulo[0] ;
            Z1951MenuBienveVisible = T005V3_A1951MenuBienveVisible[0] ;
            Z1933MenuOpcPadre = T005V3_A1933MenuOpcPadre[0] ;
            Z1934MenuHomeEs = T005V3_A1934MenuHomeEs[0] ;
            Z1940MenuItemOrd = T005V3_A1940MenuItemOrd[0] ;
            Z1949MenuBienveTitulo = T005V3_A1949MenuBienveTitulo[0] ;
            Z2361MenuOpcObj = T005V3_A2361MenuOpcObj[0] ;
            Z2363MenuOpcInst = T005V3_A2363MenuOpcInst[0] ;
            Z2367MenuOpcForRet = T005V3_A2367MenuOpcForRet[0] ;
            Z1935SVGId = T005V3_A1935SVGId[0] ;
            Z1937MenuItemId = T005V3_A1937MenuItemId[0] ;
         }
         else
         {
            Z1931MenuOpcTitulo = A1931MenuOpcTitulo ;
            Z1951MenuBienveVisible = A1951MenuBienveVisible ;
            Z1933MenuOpcPadre = A1933MenuOpcPadre ;
            Z1934MenuHomeEs = A1934MenuHomeEs ;
            Z1940MenuItemOrd = A1940MenuItemOrd ;
            Z1949MenuBienveTitulo = A1949MenuBienveTitulo ;
            Z2361MenuOpcObj = A2361MenuOpcObj ;
            Z2363MenuOpcInst = A2363MenuOpcInst ;
            Z2367MenuOpcForRet = A2367MenuOpcForRet ;
            Z1935SVGId = A1935SVGId ;
            Z1937MenuItemId = A1937MenuItemId ;
         }
      }
      if ( GX_JID == -31 )
      {
         Z1923RolId = A1923RolId ;
         Z1928MenuVerId = A1928MenuVerId ;
         Z1929MenuOpcCod = A1929MenuOpcCod ;
         Z1931MenuOpcTitulo = A1931MenuOpcTitulo ;
         Z1951MenuBienveVisible = A1951MenuBienveVisible ;
         Z1933MenuOpcPadre = A1933MenuOpcPadre ;
         Z1934MenuHomeEs = A1934MenuHomeEs ;
         Z1940MenuItemOrd = A1940MenuItemOrd ;
         Z1941MenuItemImg = A1941MenuItemImg ;
         Z1946MenuBienveImg = A1946MenuBienveImg ;
         Z1949MenuBienveTitulo = A1949MenuBienveTitulo ;
         Z1950MenuBienveTexto = A1950MenuBienveTexto ;
         Z2361MenuOpcObj = A2361MenuOpcObj ;
         Z2363MenuOpcInst = A2363MenuOpcInst ;
         Z2367MenuOpcForRet = A2367MenuOpcForRet ;
         Z1942MenuItemImgExt = A1942MenuItemImgExt ;
         Z1947MenuBienveImgExt = A1947MenuBienveImgExt ;
         Z1943MenuItemImgNom = A1943MenuItemImgNom ;
         Z1948MenuBienveImgNom = A1948MenuBienveImgNom ;
         Z1935SVGId = A1935SVGId ;
         Z1925PerfilId = A1925PerfilId ;
         Z1937MenuItemId = A1937MenuItemId ;
         Z1939MenuItemTitulo = A1939MenuItemTitulo ;
      }
   }

   public void standaloneNotModal5V256( )
   {
      gxamenuopcpadre_html5V256( ) ;
      gxasvgid_html5V256( ) ;
   }

   public void standaloneModal5V256( )
   {
      if ( isIns( )  && (false==A1951MenuBienveVisible) && ( Gx_BScreen == 0 ) )
      {
         A1951MenuBienveVisible = true ;
      }
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtMenuOpcCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuOpcCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuOpcCod_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      }
      else
      {
         edtMenuOpcCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuOpcCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuOpcCod_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      }
   }

   public void load5V256( )
   {
      /* Using cursor T005V24 */
      pr_default.execute(22, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId), A1929MenuOpcCod});
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound256 = (short)(1) ;
         A1931MenuOpcTitulo = T005V24_A1931MenuOpcTitulo[0] ;
         A1951MenuBienveVisible = T005V24_A1951MenuBienveVisible[0] ;
         A1933MenuOpcPadre = T005V24_A1933MenuOpcPadre[0] ;
         n1933MenuOpcPadre = T005V24_n1933MenuOpcPadre[0] ;
         A1934MenuHomeEs = T005V24_A1934MenuHomeEs[0] ;
         A1940MenuItemOrd = T005V24_A1940MenuItemOrd[0] ;
         A1941MenuItemImg = T005V24_A1941MenuItemImg[0] ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuItemImg_Internalname, "URL", httpContext.getResourceRelative(A1941MenuItemImg), !bGXsfl_41_Refreshing);
         A1939MenuItemTitulo = T005V24_A1939MenuItemTitulo[0] ;
         A1946MenuBienveImg = T005V24_A1946MenuBienveImg[0] ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuBienveImg_Internalname, "URL", httpContext.getResourceRelative(A1946MenuBienveImg), !bGXsfl_41_Refreshing);
         A1949MenuBienveTitulo = T005V24_A1949MenuBienveTitulo[0] ;
         A1950MenuBienveTexto = T005V24_A1950MenuBienveTexto[0] ;
         A2361MenuOpcObj = T005V24_A2361MenuOpcObj[0] ;
         A2363MenuOpcInst = T005V24_A2363MenuOpcInst[0] ;
         A2367MenuOpcForRet = T005V24_A2367MenuOpcForRet[0] ;
         A1942MenuItemImgExt = T005V24_A1942MenuItemImgExt[0] ;
         edtMenuItemImg_Filetype = A1942MenuItemImgExt ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuItemImg_Internalname, "Filetype", edtMenuItemImg_Filetype, !bGXsfl_41_Refreshing);
         A1947MenuBienveImgExt = T005V24_A1947MenuBienveImgExt[0] ;
         edtMenuBienveImg_Filetype = A1947MenuBienveImgExt ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuBienveImg_Internalname, "Filetype", edtMenuBienveImg_Filetype, !bGXsfl_41_Refreshing);
         A1943MenuItemImgNom = T005V24_A1943MenuItemImgNom[0] ;
         edtMenuItemImg_Filename = A1943MenuItemImgNom ;
         A1948MenuBienveImgNom = T005V24_A1948MenuBienveImgNom[0] ;
         edtMenuBienveImg_Filename = A1948MenuBienveImgNom ;
         A1935SVGId = T005V24_A1935SVGId[0] ;
         n1935SVGId = T005V24_n1935SVGId[0] ;
         A1937MenuItemId = T005V24_A1937MenuItemId[0] ;
         zm5V256( -31) ;
      }
      pr_default.close(22);
      onLoadActions5V256( ) ;
   }

   public void onLoadActions5V256( )
   {
      if ( isIns( )  && (GXutil.strcmp("", A1931MenuOpcTitulo)==0) && ( Gx_BScreen == 0 ) )
      {
         A1931MenuOpcTitulo = A1939MenuItemTitulo ;
      }
      if ( isIns( )  && (GXutil.strcmp("", A1941MenuItemImg)==0) && ( Gx_BScreen == 0 ) )
      {
         A1941MenuItemImg = AV21MitemIcoImg ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuItemImg_Internalname, "URL", httpContext.getResourceRelative(A1941MenuItemImg), !bGXsfl_41_Refreshing);
      }
      if ( isIns( )  && (GXutil.strcmp("", A1946MenuBienveImg)==0) && ( Gx_BScreen == 0 ) )
      {
         A1946MenuBienveImg = AV22MItemBienImgDef ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuBienveImg_Internalname, "URL", httpContext.getResourceRelative(A1946MenuBienveImg), !bGXsfl_41_Refreshing);
      }
      if ( isIns( )  && (GXutil.strcmp("", A1949MenuBienveTitulo)==0) && ( Gx_BScreen == 0 ) )
      {
         A1949MenuBienveTitulo = AV23MItemBienTitDef ;
      }
      if ( isIns( )  && (GXutil.strcmp("", A1950MenuBienveTexto)==0) && ( Gx_BScreen == 0 ) )
      {
         A1950MenuBienveTexto = AV24MItemBienTextDef ;
      }
      if ( isIns( )  && (GXutil.strcmp("", A1935SVGId)==0) && ( Gx_BScreen == 0 ) )
      {
         A1935SVGId = AV20MItemIcoSVG ;
         n1935SVGId = false ;
      }
      GXt_char4 = A2362MenuOpcHormiga ;
      GXv_char5[0] = "" ;
      GXv_char6[0] = "" ;
      GXv_char7[0] = "" ;
      GXv_char8[0] = GXt_char4 ;
      new web.gethtmlnewbreadcrumb(remoteHandle, context).execute( A1929MenuOpcCod, A1923RolId, A1925PerfilId, A1928MenuVerId, GXv_char5, GXv_char6, GXv_char7, GXv_char8) ;
      menuversiones_impl.this.GXt_char4 = GXv_char8[0] ;
      A2362MenuOpcHormiga = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "A2362MenuOpcHormiga", A2362MenuOpcHormiga);
   }

   public void checkExtendedTable5V256( )
   {
      nIsDirty_256 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal5V256( ) ;
      /* Using cursor T005V5 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), A1937MenuItemId});
      if ( (pr_default.getStatus(3) == 101) )
      {
         GXCCtl = "MENUITEMID_" + sGXsfl_41_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "MenuItem", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtMenuItemId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A1939MenuItemTitulo = T005V5_A1939MenuItemTitulo[0] ;
      pr_default.close(3);
      GXv_char8[0] = "" ;
      GXv_char7[0] = AV20MItemIcoSVG ;
      GXv_char6[0] = AV21MitemIcoImg ;
      GXv_char5[0] = AV22MItemBienImgDef ;
      GXv_char9[0] = AV23MItemBienTitDef ;
      GXv_char10[0] = AV24MItemBienTextDef ;
      new web.getmenuitempredeterminados(remoteHandle, context).execute( A1925PerfilId, A1937MenuItemId, GXv_char8, GXv_char7, GXv_char6, GXv_char5, GXv_char9, GXv_char10) ;
      menuversiones_impl.this.AV20MItemIcoSVG = GXv_char7[0] ;
      menuversiones_impl.this.AV21MitemIcoImg = GXv_char6[0] ;
      menuversiones_impl.this.AV22MItemBienImgDef = GXv_char5[0] ;
      menuversiones_impl.this.AV23MItemBienTitDef = GXv_char9[0] ;
      menuversiones_impl.this.AV24MItemBienTextDef = GXv_char10[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20MItemIcoSVG", AV20MItemIcoSVG);
      httpContext.ajax_rsp_assign_attri("", false, "AV21MitemIcoImg", AV21MitemIcoImg);
      httpContext.ajax_rsp_assign_attri("", false, "AV22MItemBienImgDef", AV22MItemBienImgDef);
      httpContext.ajax_rsp_assign_attri("", false, "AV23MItemBienTitDef", AV23MItemBienTitDef);
      httpContext.ajax_rsp_assign_attri("", false, "AV24MItemBienTextDef", AV24MItemBienTextDef);
      if ( isIns( )  && (GXutil.strcmp("", A1931MenuOpcTitulo)==0) && ( Gx_BScreen == 0 ) )
      {
         nIsDirty_256 = (short)(1) ;
         A1931MenuOpcTitulo = A1939MenuItemTitulo ;
      }
      if ( isIns( )  && (GXutil.strcmp("", A1941MenuItemImg)==0) && ( Gx_BScreen == 0 ) )
      {
         nIsDirty_256 = (short)(1) ;
         A1941MenuItemImg = AV21MitemIcoImg ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuItemImg_Internalname, "URL", httpContext.getResourceRelative(A1941MenuItemImg), !bGXsfl_41_Refreshing);
      }
      if ( isIns( )  && (GXutil.strcmp("", A1946MenuBienveImg)==0) && ( Gx_BScreen == 0 ) )
      {
         nIsDirty_256 = (short)(1) ;
         A1946MenuBienveImg = AV22MItemBienImgDef ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuBienveImg_Internalname, "URL", httpContext.getResourceRelative(A1946MenuBienveImg), !bGXsfl_41_Refreshing);
      }
      if ( isIns( )  && (GXutil.strcmp("", A1949MenuBienveTitulo)==0) && ( Gx_BScreen == 0 ) )
      {
         nIsDirty_256 = (short)(1) ;
         A1949MenuBienveTitulo = AV23MItemBienTitDef ;
      }
      if ( isIns( )  && (GXutil.strcmp("", A1950MenuBienveTexto)==0) && ( Gx_BScreen == 0 ) )
      {
         nIsDirty_256 = (short)(1) ;
         A1950MenuBienveTexto = AV24MItemBienTextDef ;
      }
      if ( isIns( )  && (GXutil.strcmp("", A1935SVGId)==0) && ( Gx_BScreen == 0 ) )
      {
         nIsDirty_256 = (short)(1) ;
         A1935SVGId = AV20MItemIcoSVG ;
         n1935SVGId = false ;
      }
      nIsDirty_256 = (short)(1) ;
      GXt_char4 = A2362MenuOpcHormiga ;
      GXv_char10[0] = "" ;
      GXv_char9[0] = "" ;
      GXv_char8[0] = "" ;
      GXv_char7[0] = GXt_char4 ;
      new web.gethtmlnewbreadcrumb(remoteHandle, context).execute( A1929MenuOpcCod, A1923RolId, A1925PerfilId, A1928MenuVerId, GXv_char10, GXv_char9, GXv_char8, GXv_char7) ;
      menuversiones_impl.this.GXt_char4 = GXv_char7[0] ;
      A2362MenuOpcHormiga = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "A2362MenuOpcHormiga", A2362MenuOpcHormiga);
      /* Using cursor T005V4 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n1935SVGId), A1935SVGId});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A1935SVGId)==0) ) )
         {
            GXCCtl = "SVGID_" + sGXsfl_41_idx ;
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "SVG", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
            AnyError = (short)(1) ;
            GX_FocusControl = dynSVGId.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(2);
   }

   public void closeExtendedTableCursors5V256( )
   {
      pr_default.close(3);
      pr_default.close(2);
   }

   public void enableDisable5V256( )
   {
   }

   public void gxload_33( byte A1925PerfilId ,
                          String A1937MenuItemId )
   {
      /* Using cursor T005V25 */
      pr_default.execute(23, new Object[] {Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), A1937MenuItemId});
      if ( (pr_default.getStatus(23) == 101) )
      {
         GXCCtl = "MENUITEMID_" + sGXsfl_41_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "MenuItem", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtMenuItemId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A1939MenuItemTitulo = T005V25_A1939MenuItemTitulo[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1939MenuItemTitulo)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(23) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(23);
   }

   public void gxload_32( String A1935SVGId )
   {
      /* Using cursor T005V26 */
      pr_default.execute(24, new Object[] {Boolean.valueOf(n1935SVGId), A1935SVGId});
      if ( (pr_default.getStatus(24) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A1935SVGId)==0) ) )
         {
            GXCCtl = "SVGID_" + sGXsfl_41_idx ;
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "SVG", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
            AnyError = (short)(1) ;
            GX_FocusControl = dynSVGId.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(24) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(24);
   }

   public void getKey5V256( )
   {
      /* Using cursor T005V27 */
      pr_default.execute(25, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId), A1929MenuOpcCod});
      if ( (pr_default.getStatus(25) != 101) )
      {
         RcdFound256 = (short)(1) ;
      }
      else
      {
         RcdFound256 = (short)(0) ;
      }
      pr_default.close(25);
   }

   public void getByPrimaryKey5V256( )
   {
      /* Using cursor T005V3 */
      pr_default.execute(1, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId), A1929MenuOpcCod});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm5V256( 31) ;
         RcdFound256 = (short)(1) ;
         initializeNonKey5V256( ) ;
         A1929MenuOpcCod = T005V3_A1929MenuOpcCod[0] ;
         A1931MenuOpcTitulo = T005V3_A1931MenuOpcTitulo[0] ;
         A1951MenuBienveVisible = T005V3_A1951MenuBienveVisible[0] ;
         A1933MenuOpcPadre = T005V3_A1933MenuOpcPadre[0] ;
         n1933MenuOpcPadre = T005V3_n1933MenuOpcPadre[0] ;
         A1934MenuHomeEs = T005V3_A1934MenuHomeEs[0] ;
         A1940MenuItemOrd = T005V3_A1940MenuItemOrd[0] ;
         A1941MenuItemImg = T005V3_A1941MenuItemImg[0] ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuItemImg_Internalname, "URL", httpContext.getResourceRelative(A1941MenuItemImg), !bGXsfl_41_Refreshing);
         A1946MenuBienveImg = T005V3_A1946MenuBienveImg[0] ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuBienveImg_Internalname, "URL", httpContext.getResourceRelative(A1946MenuBienveImg), !bGXsfl_41_Refreshing);
         A1949MenuBienveTitulo = T005V3_A1949MenuBienveTitulo[0] ;
         A1950MenuBienveTexto = T005V3_A1950MenuBienveTexto[0] ;
         A2361MenuOpcObj = T005V3_A2361MenuOpcObj[0] ;
         A2363MenuOpcInst = T005V3_A2363MenuOpcInst[0] ;
         A2367MenuOpcForRet = T005V3_A2367MenuOpcForRet[0] ;
         A1942MenuItemImgExt = T005V3_A1942MenuItemImgExt[0] ;
         edtMenuItemImg_Filetype = A1942MenuItemImgExt ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuItemImg_Internalname, "Filetype", edtMenuItemImg_Filetype, !bGXsfl_41_Refreshing);
         A1947MenuBienveImgExt = T005V3_A1947MenuBienveImgExt[0] ;
         edtMenuBienveImg_Filetype = A1947MenuBienveImgExt ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuBienveImg_Internalname, "Filetype", edtMenuBienveImg_Filetype, !bGXsfl_41_Refreshing);
         A1943MenuItemImgNom = T005V3_A1943MenuItemImgNom[0] ;
         edtMenuItemImg_Filename = A1943MenuItemImgNom ;
         A1948MenuBienveImgNom = T005V3_A1948MenuBienveImgNom[0] ;
         edtMenuBienveImg_Filename = A1948MenuBienveImgNom ;
         A1935SVGId = T005V3_A1935SVGId[0] ;
         n1935SVGId = T005V3_n1935SVGId[0] ;
         A1937MenuItemId = T005V3_A1937MenuItemId[0] ;
         Z1923RolId = A1923RolId ;
         Z1925PerfilId = A1925PerfilId ;
         Z1928MenuVerId = A1928MenuVerId ;
         Z1929MenuOpcCod = A1929MenuOpcCod ;
         sMode256 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load5V256( ) ;
         Gx_mode = sMode256 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound256 = (short)(0) ;
         initializeNonKey5V256( ) ;
         sMode256 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal5V256( ) ;
         Gx_mode = sMode256 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes5V256( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency5V256( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T005V2 */
         pr_default.execute(0, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId), A1929MenuOpcCod});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"MenuVersionesOpciones"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z1931MenuOpcTitulo, T005V2_A1931MenuOpcTitulo[0]) != 0 ) || ( Z1951MenuBienveVisible != T005V2_A1951MenuBienveVisible[0] ) || ( GXutil.strcmp(Z1933MenuOpcPadre, T005V2_A1933MenuOpcPadre[0]) != 0 ) || ( Z1934MenuHomeEs != T005V2_A1934MenuHomeEs[0] ) || ( Z1940MenuItemOrd != T005V2_A1940MenuItemOrd[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1949MenuBienveTitulo, T005V2_A1949MenuBienveTitulo[0]) != 0 ) || ( GXutil.strcmp(Z2361MenuOpcObj, T005V2_A2361MenuOpcObj[0]) != 0 ) || ( Z2363MenuOpcInst != T005V2_A2363MenuOpcInst[0] ) || ( Z2367MenuOpcForRet != T005V2_A2367MenuOpcForRet[0] ) || ( GXutil.strcmp(Z1935SVGId, T005V2_A1935SVGId[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1937MenuItemId, T005V2_A1937MenuItemId[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z1931MenuOpcTitulo, T005V2_A1931MenuOpcTitulo[0]) != 0 )
            {
               GXutil.writeLogln("menuversiones:[seudo value changed for attri]"+"MenuOpcTitulo");
               GXutil.writeLogRaw("Old: ",Z1931MenuOpcTitulo);
               GXutil.writeLogRaw("Current: ",T005V2_A1931MenuOpcTitulo[0]);
            }
            if ( Z1951MenuBienveVisible != T005V2_A1951MenuBienveVisible[0] )
            {
               GXutil.writeLogln("menuversiones:[seudo value changed for attri]"+"MenuBienveVisible");
               GXutil.writeLogRaw("Old: ",Z1951MenuBienveVisible);
               GXutil.writeLogRaw("Current: ",T005V2_A1951MenuBienveVisible[0]);
            }
            if ( GXutil.strcmp(Z1933MenuOpcPadre, T005V2_A1933MenuOpcPadre[0]) != 0 )
            {
               GXutil.writeLogln("menuversiones:[seudo value changed for attri]"+"MenuOpcPadre");
               GXutil.writeLogRaw("Old: ",Z1933MenuOpcPadre);
               GXutil.writeLogRaw("Current: ",T005V2_A1933MenuOpcPadre[0]);
            }
            if ( Z1934MenuHomeEs != T005V2_A1934MenuHomeEs[0] )
            {
               GXutil.writeLogln("menuversiones:[seudo value changed for attri]"+"MenuHomeEs");
               GXutil.writeLogRaw("Old: ",Z1934MenuHomeEs);
               GXutil.writeLogRaw("Current: ",T005V2_A1934MenuHomeEs[0]);
            }
            if ( Z1940MenuItemOrd != T005V2_A1940MenuItemOrd[0] )
            {
               GXutil.writeLogln("menuversiones:[seudo value changed for attri]"+"MenuItemOrd");
               GXutil.writeLogRaw("Old: ",Z1940MenuItemOrd);
               GXutil.writeLogRaw("Current: ",T005V2_A1940MenuItemOrd[0]);
            }
            if ( GXutil.strcmp(Z1949MenuBienveTitulo, T005V2_A1949MenuBienveTitulo[0]) != 0 )
            {
               GXutil.writeLogln("menuversiones:[seudo value changed for attri]"+"MenuBienveTitulo");
               GXutil.writeLogRaw("Old: ",Z1949MenuBienveTitulo);
               GXutil.writeLogRaw("Current: ",T005V2_A1949MenuBienveTitulo[0]);
            }
            if ( GXutil.strcmp(Z2361MenuOpcObj, T005V2_A2361MenuOpcObj[0]) != 0 )
            {
               GXutil.writeLogln("menuversiones:[seudo value changed for attri]"+"MenuOpcObj");
               GXutil.writeLogRaw("Old: ",Z2361MenuOpcObj);
               GXutil.writeLogRaw("Current: ",T005V2_A2361MenuOpcObj[0]);
            }
            if ( Z2363MenuOpcInst != T005V2_A2363MenuOpcInst[0] )
            {
               GXutil.writeLogln("menuversiones:[seudo value changed for attri]"+"MenuOpcInst");
               GXutil.writeLogRaw("Old: ",Z2363MenuOpcInst);
               GXutil.writeLogRaw("Current: ",T005V2_A2363MenuOpcInst[0]);
            }
            if ( Z2367MenuOpcForRet != T005V2_A2367MenuOpcForRet[0] )
            {
               GXutil.writeLogln("menuversiones:[seudo value changed for attri]"+"MenuOpcForRet");
               GXutil.writeLogRaw("Old: ",Z2367MenuOpcForRet);
               GXutil.writeLogRaw("Current: ",T005V2_A2367MenuOpcForRet[0]);
            }
            if ( GXutil.strcmp(Z1935SVGId, T005V2_A1935SVGId[0]) != 0 )
            {
               GXutil.writeLogln("menuversiones:[seudo value changed for attri]"+"SVGId");
               GXutil.writeLogRaw("Old: ",Z1935SVGId);
               GXutil.writeLogRaw("Current: ",T005V2_A1935SVGId[0]);
            }
            if ( GXutil.strcmp(Z1937MenuItemId, T005V2_A1937MenuItemId[0]) != 0 )
            {
               GXutil.writeLogln("menuversiones:[seudo value changed for attri]"+"MenuItemId");
               GXutil.writeLogRaw("Old: ",Z1937MenuItemId);
               GXutil.writeLogRaw("Current: ",T005V2_A1937MenuItemId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"MenuVersionesOpciones"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert5V256( )
   {
      beforeValidate5V256( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5V256( ) ;
      }
      if ( AnyError == 0 )
      {
         zm5V256( 0) ;
         checkOptimisticConcurrency5V256( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5V256( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert5V256( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005V28 */
                  A1942MenuItemImgExt = edtMenuItemImg_Filetype ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1942MenuItemImgExt", A1942MenuItemImgExt);
                  A1947MenuBienveImgExt = edtMenuBienveImg_Filetype ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1947MenuBienveImgExt", A1947MenuBienveImgExt);
                  A1943MenuItemImgNom = edtMenuItemImg_Filename ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1943MenuItemImgNom", A1943MenuItemImgNom);
                  A1948MenuBienveImgNom = edtMenuBienveImg_Filename ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1948MenuBienveImgNom", A1948MenuBienveImgNom);
                  pr_default.execute(26, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId), A1929MenuOpcCod, A1931MenuOpcTitulo, Boolean.valueOf(A1951MenuBienveVisible), Boolean.valueOf(n1933MenuOpcPadre), A1933MenuOpcPadre, Boolean.valueOf(A1934MenuHomeEs), Byte.valueOf(A1940MenuItemOrd), A1941MenuItemImg, A1946MenuBienveImg, A1949MenuBienveTitulo, A1950MenuBienveTexto, A2361MenuOpcObj, Boolean.valueOf(A2363MenuOpcInst), Boolean.valueOf(A2367MenuOpcForRet), A1942MenuItemImgExt, A1947MenuBienveImgExt, A1943MenuItemImgNom, A1948MenuBienveImgNom, Boolean.valueOf(n1935SVGId), A1935SVGId, Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), A1937MenuItemId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuVersionesOpciones");
                  if ( (pr_default.getStatus(26) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load5V256( ) ;
         }
         endLevel5V256( ) ;
      }
      closeExtendedTableCursors5V256( ) ;
   }

   public void update5V256( )
   {
      beforeValidate5V256( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5V256( ) ;
      }
      if ( ( nIsMod_256 != 0 ) || ( nIsDirty_256 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency5V256( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm5V256( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate5V256( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T005V29 */
                     A1942MenuItemImgExt = edtMenuItemImg_Filetype ;
                     httpContext.ajax_rsp_assign_attri("", false, "A1942MenuItemImgExt", A1942MenuItemImgExt);
                     A1947MenuBienveImgExt = edtMenuBienveImg_Filetype ;
                     httpContext.ajax_rsp_assign_attri("", false, "A1947MenuBienveImgExt", A1947MenuBienveImgExt);
                     A1943MenuItemImgNom = edtMenuItemImg_Filename ;
                     httpContext.ajax_rsp_assign_attri("", false, "A1943MenuItemImgNom", A1943MenuItemImgNom);
                     A1948MenuBienveImgNom = edtMenuBienveImg_Filename ;
                     httpContext.ajax_rsp_assign_attri("", false, "A1948MenuBienveImgNom", A1948MenuBienveImgNom);
                     pr_default.execute(27, new Object[] {A1931MenuOpcTitulo, Boolean.valueOf(A1951MenuBienveVisible), Boolean.valueOf(n1933MenuOpcPadre), A1933MenuOpcPadre, Boolean.valueOf(A1934MenuHomeEs), Byte.valueOf(A1940MenuItemOrd), A1949MenuBienveTitulo, A1950MenuBienveTexto, A2361MenuOpcObj, Boolean.valueOf(A2363MenuOpcInst), Boolean.valueOf(A2367MenuOpcForRet), A1942MenuItemImgExt, A1947MenuBienveImgExt, A1943MenuItemImgNom, A1948MenuBienveImgNom, Boolean.valueOf(n1935SVGId), A1935SVGId, A1937MenuItemId, Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId), A1929MenuOpcCod});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuVersionesOpciones");
                     if ( (pr_default.getStatus(27) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"MenuVersionesOpciones"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate5V256( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey5V256( ) ;
                        }
                     }
                     else
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                        AnyError = (short)(1) ;
                     }
                  }
               }
            }
            endLevel5V256( ) ;
         }
      }
      closeExtendedTableCursors5V256( ) ;
   }

   public void deferredUpdate5V256( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor T005V30 */
         pr_default.execute(28, new Object[] {A1941MenuItemImg, Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId), A1929MenuOpcCod});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuVersionesOpciones");
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T005V31 */
         pr_default.execute(29, new Object[] {A1946MenuBienveImg, Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId), A1929MenuOpcCod});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuVersionesOpciones");
      }
   }

   public void delete5V256( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate5V256( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5V256( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls5V256( ) ;
         afterConfirm5V256( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete5V256( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T005V32 */
               pr_default.execute(30, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId), A1929MenuOpcCod});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuVersionesOpciones");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode256 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel5V256( ) ;
      Gx_mode = sMode256 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls5V256( )
   {
      standaloneModal5V256( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         GXt_char4 = A2362MenuOpcHormiga ;
         GXv_char10[0] = "" ;
         GXv_char9[0] = "" ;
         GXv_char8[0] = "" ;
         GXv_char7[0] = GXt_char4 ;
         new web.gethtmlnewbreadcrumb(remoteHandle, context).execute( A1929MenuOpcCod, A1923RolId, A1925PerfilId, A1928MenuVerId, GXv_char10, GXv_char9, GXv_char8, GXv_char7) ;
         menuversiones_impl.this.GXt_char4 = GXv_char7[0] ;
         A2362MenuOpcHormiga = GXt_char4 ;
         httpContext.ajax_rsp_assign_attri("", false, "A2362MenuOpcHormiga", A2362MenuOpcHormiga);
         /* Using cursor T005V33 */
         pr_default.execute(31, new Object[] {Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), A1937MenuItemId});
         A1939MenuItemTitulo = T005V33_A1939MenuItemTitulo[0] ;
         pr_default.close(31);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T005V34 */
         pr_default.execute(32, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId), A1929MenuOpcCod});
         if ( (pr_default.getStatus(32) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "MenuVerOpcPermisos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(32);
      }
   }

   public void endLevel5V256( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart5V256( )
   {
      /* Scan By routine */
      /* Using cursor T005V35 */
      pr_default.execute(33, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1928MenuVerId), Long.valueOf(A1928MenuVerId)});
      RcdFound256 = (short)(0) ;
      if ( (pr_default.getStatus(33) != 101) )
      {
         RcdFound256 = (short)(1) ;
         A1929MenuOpcCod = T005V35_A1929MenuOpcCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext5V256( )
   {
      /* Scan next routine */
      pr_default.readNext(33);
      RcdFound256 = (short)(0) ;
      if ( (pr_default.getStatus(33) != 101) )
      {
         RcdFound256 = (short)(1) ;
         A1929MenuOpcCod = T005V35_A1929MenuOpcCod[0] ;
      }
   }

   public void scanEnd5V256( )
   {
      pr_default.close(33);
   }

   public void afterConfirm5V256( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert5V256( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate5V256( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete5V256( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete5V256( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate5V256( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes5V256( )
   {
      edtMenuOpcCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuOpcCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuOpcCod_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      edtMenuItemId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemId_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      edtMenuOpcTitulo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuOpcTitulo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuOpcTitulo_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      dynMenuOpcPadre.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynMenuOpcPadre.getInternalname(), "Enabled", GXutil.ltrimstr( dynMenuOpcPadre.getEnabled(), 5, 0), !bGXsfl_41_Refreshing);
      dynSVGId.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynSVGId.getInternalname(), "Enabled", GXutil.ltrimstr( dynSVGId.getEnabled(), 5, 0), !bGXsfl_41_Refreshing);
      edtMenuItemImg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemImg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemImg_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      chkMenuHomeEs.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkMenuHomeEs.getInternalname(), "Enabled", GXutil.ltrimstr( chkMenuHomeEs.getEnabled(), 5, 0), !bGXsfl_41_Refreshing);
      edtMenuItemOrd_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemOrd_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemOrd_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      edtMenuBienveTitulo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuBienveTitulo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuBienveTitulo_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      edtMenuBienveTexto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuBienveTexto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuBienveTexto_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      edtMenuBienveImg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuBienveImg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuBienveImg_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      chkMenuBienveVisible.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkMenuBienveVisible.getInternalname(), "Enabled", GXutil.ltrimstr( chkMenuBienveVisible.getEnabled(), 5, 0), !bGXsfl_41_Refreshing);
      chkMenuOpcInst.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkMenuOpcInst.getInternalname(), "Enabled", GXutil.ltrimstr( chkMenuOpcInst.getEnabled(), 5, 0), !bGXsfl_41_Refreshing);
      chkMenuOpcForRet.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkMenuOpcForRet.getInternalname(), "Enabled", GXutil.ltrimstr( chkMenuOpcForRet.getEnabled(), 5, 0), !bGXsfl_41_Refreshing);
   }

   public void send_integrity_lvl_hashes5V256( )
   {
   }

   public void send_integrity_lvl_hashes5V255( )
   {
   }

   public void subsflControlProps_41256( )
   {
      edtMenuOpcCod_Internalname = "MENUOPCCOD_"+sGXsfl_41_idx ;
      edtMenuItemId_Internalname = "MENUITEMID_"+sGXsfl_41_idx ;
      edtMenuOpcTitulo_Internalname = "MENUOPCTITULO_"+sGXsfl_41_idx ;
      dynMenuOpcPadre.setInternalname( "MENUOPCPADRE_"+sGXsfl_41_idx );
      dynSVGId.setInternalname( "SVGID_"+sGXsfl_41_idx );
      edtMenuItemImg_Internalname = "MENUITEMIMG_"+sGXsfl_41_idx ;
      chkMenuHomeEs.setInternalname( "MENUHOMEES_"+sGXsfl_41_idx );
      edtMenuItemOrd_Internalname = "MENUITEMORD_"+sGXsfl_41_idx ;
      edtMenuBienveTitulo_Internalname = "MENUBIENVETITULO_"+sGXsfl_41_idx ;
      edtMenuBienveTexto_Internalname = "MENUBIENVETEXTO_"+sGXsfl_41_idx ;
      edtMenuBienveImg_Internalname = "MENUBIENVEIMG_"+sGXsfl_41_idx ;
      chkMenuBienveVisible.setInternalname( "MENUBIENVEVISIBLE_"+sGXsfl_41_idx );
      chkMenuOpcInst.setInternalname( "MENUOPCINST_"+sGXsfl_41_idx );
      chkMenuOpcForRet.setInternalname( "MENUOPCFORRET_"+sGXsfl_41_idx );
   }

   public void subsflControlProps_fel_41256( )
   {
      edtMenuOpcCod_Internalname = "MENUOPCCOD_"+sGXsfl_41_fel_idx ;
      edtMenuItemId_Internalname = "MENUITEMID_"+sGXsfl_41_fel_idx ;
      edtMenuOpcTitulo_Internalname = "MENUOPCTITULO_"+sGXsfl_41_fel_idx ;
      dynMenuOpcPadre.setInternalname( "MENUOPCPADRE_"+sGXsfl_41_fel_idx );
      dynSVGId.setInternalname( "SVGID_"+sGXsfl_41_fel_idx );
      edtMenuItemImg_Internalname = "MENUITEMIMG_"+sGXsfl_41_fel_idx ;
      chkMenuHomeEs.setInternalname( "MENUHOMEES_"+sGXsfl_41_fel_idx );
      edtMenuItemOrd_Internalname = "MENUITEMORD_"+sGXsfl_41_fel_idx ;
      edtMenuBienveTitulo_Internalname = "MENUBIENVETITULO_"+sGXsfl_41_fel_idx ;
      edtMenuBienveTexto_Internalname = "MENUBIENVETEXTO_"+sGXsfl_41_fel_idx ;
      edtMenuBienveImg_Internalname = "MENUBIENVEIMG_"+sGXsfl_41_fel_idx ;
      chkMenuBienveVisible.setInternalname( "MENUBIENVEVISIBLE_"+sGXsfl_41_fel_idx );
      chkMenuOpcInst.setInternalname( "MENUOPCINST_"+sGXsfl_41_fel_idx );
      chkMenuOpcForRet.setInternalname( "MENUOPCFORRET_"+sGXsfl_41_fel_idx );
   }

   public void addRow5V256( )
   {
      nGXsfl_41_idx = (int)(nGXsfl_41_idx+1) ;
      sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_41256( ) ;
      sendRow5V256( ) ;
   }

   public void sendRow5V256( )
   {
      Gridlevel_opcionesRow = GXWebRow.GetNew(context) ;
      if ( subGridlevel_opciones_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel_opciones_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel_opciones_Class, "") != 0 )
         {
            subGridlevel_opciones_Linesclass = subGridlevel_opciones_Class+"Odd" ;
         }
      }
      else if ( subGridlevel_opciones_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel_opciones_Backstyle = (byte)(0) ;
         subGridlevel_opciones_Backcolor = subGridlevel_opciones_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel_opciones_Class, "") != 0 )
         {
            subGridlevel_opciones_Linesclass = subGridlevel_opciones_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel_opciones_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel_opciones_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel_opciones_Class, "") != 0 )
         {
            subGridlevel_opciones_Linesclass = subGridlevel_opciones_Class+"Odd" ;
         }
         subGridlevel_opciones_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel_opciones_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel_opciones_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_41_idx) % (2))) == 0 )
         {
            subGridlevel_opciones_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_opciones_Class, "") != 0 )
            {
               subGridlevel_opciones_Linesclass = subGridlevel_opciones_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel_opciones_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_opciones_Class, "") != 0 )
            {
               subGridlevel_opciones_Linesclass = subGridlevel_opciones_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_256_" + sGXsfl_41_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 42,'',false,'" + sGXsfl_41_idx + "',41)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_opcionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMenuOpcCod_Internalname,A1929MenuOpcCod,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMenuOpcCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtMenuOpcCod_Enabled),Integer.valueOf(1),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_256_" + sGXsfl_41_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 43,'',false,'" + sGXsfl_41_idx + "',41)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_opcionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMenuItemId_Internalname,A1937MenuItemId,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMenuItemId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtMenuItemId_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_256_" + sGXsfl_41_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 44,'',false,'" + sGXsfl_41_idx + "',41)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_opcionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMenuOpcTitulo_Internalname,A1931MenuOpcTitulo,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMenuOpcTitulo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtMenuOpcTitulo_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
      gxamenuopcpadre_html5V256( ) ;
      /* Subfile cell */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_256_" + sGXsfl_41_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 45,'',false,'" + sGXsfl_41_idx + "',41)\"" ;
      if ( ( dynMenuOpcPadre.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "MENUOPCPADRE_" + sGXsfl_41_idx ;
         dynMenuOpcPadre.setName( GXCCtl );
         dynMenuOpcPadre.setWebtags( "" );
      }
      /* ComboBox */
      Gridlevel_opcionesRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {dynMenuOpcPadre,dynMenuOpcPadre.getInternalname(),GXutil.rtrim( A1933MenuOpcPadre),Integer.valueOf(1),dynMenuOpcPadre.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(dynMenuOpcPadre.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","TrnColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,45);\"","",Boolean.valueOf(true),Integer.valueOf(0)});
      dynMenuOpcPadre.setValue( GXutil.rtrim( A1933MenuOpcPadre) );
      httpContext.ajax_rsp_assign_prop("", false, dynMenuOpcPadre.getInternalname(), "Values", dynMenuOpcPadre.ToJavascriptSource(), !bGXsfl_41_Refreshing);
      gxasvgid_html5V256( ) ;
      /* Subfile cell */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_256_" + sGXsfl_41_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 46,'',false,'" + sGXsfl_41_idx + "',41)\"" ;
      if ( ( dynSVGId.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "SVGID_" + sGXsfl_41_idx ;
         dynSVGId.setName( GXCCtl );
         dynSVGId.setWebtags( "" );
      }
      /* ComboBox */
      Gridlevel_opcionesRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {dynSVGId,dynSVGId.getInternalname(),GXutil.rtrim( A1935SVGId),Integer.valueOf(1),dynSVGId.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(dynSVGId.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","TrnColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,46);\"","",Boolean.valueOf(true),Integer.valueOf(0)});
      dynSVGId.setValue( GXutil.rtrim( A1935SVGId) );
      httpContext.ajax_rsp_assign_prop("", false, dynSVGId.getInternalname(), "Values", dynSVGId.ToJavascriptSource(), !bGXsfl_41_Refreshing);
      /* Subfile cell */
      ClassString = "Attribute" ;
      StyleString = "" ;
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_256_" + sGXsfl_41_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 47,'',false,'" + sGXsfl_41_idx + "',41)\"" ;
      edtMenuItemImg_Filename = A1943MenuItemImgNom ;
      edtMenuItemImg_Filetype = "" ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemImg_Internalname, "Filetype", edtMenuItemImg_Filetype, !bGXsfl_41_Refreshing);
      edtMenuItemImg_Filetype = A1942MenuItemImgExt ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemImg_Internalname, "Filetype", edtMenuItemImg_Filetype, !bGXsfl_41_Refreshing);
      if ( ! (GXutil.strcmp("", A1941MenuItemImg)==0) )
      {
         gxblobfileaux.setSource( A1941MenuItemImg );
         if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtMenuItemImg_Filetype, "tmp") != 0 ) )
         {
            gxblobfileaux.setExt(GXutil.trim( edtMenuItemImg_Filetype));
         }
         if ( gxblobfileaux.getErrCode() == 0 )
         {
            A1941MenuItemImg = gxblobfileaux.getURI() ;
            httpContext.ajax_rsp_assign_prop("", false, edtMenuItemImg_Internalname, "URL", httpContext.getResourceRelative(A1941MenuItemImg), !bGXsfl_41_Refreshing);
            edtMenuItemImg_Filetype = gxblobfileaux.getExtension() ;
            httpContext.ajax_rsp_assign_prop("", false, edtMenuItemImg_Internalname, "Filetype", edtMenuItemImg_Filetype, !bGXsfl_41_Refreshing);
            gxblobfileaux.setBlobToDelete();
         }
         httpContext.ajax_rsp_assign_prop("", false, edtMenuItemImg_Internalname, "URL", httpContext.getResourceRelative(A1941MenuItemImg), !bGXsfl_41_Refreshing);
      }
      Gridlevel_opcionesRow.AddColumnProperties("blob", 2, isAjaxCallMode( ), new Object[] {edtMenuItemImg_Internalname,GXutil.rtrim( A1941MenuItemImg),httpContext.getResourceRelative(A1941MenuItemImg),((GXutil.strcmp("", edtMenuItemImg_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtMenuItemImg_Filetype)==0) ? A1941MenuItemImg : edtMenuItemImg_Filetype)) : edtMenuItemImg_Contenttype),Boolean.valueOf(true),"",edtMenuItemImg_Parameters,Integer.valueOf(0),Integer.valueOf(edtMenuItemImg_Enabled),Integer.valueOf(-1),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(60),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),edtMenuItemImg_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'",StyleString,ClassString,"TrnColumn","",""+TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"","",""});
      /* Subfile cell */
      /* Check box */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_256_" + sGXsfl_41_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 48,'',false,'" + sGXsfl_41_idx + "',41)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      GXCCtl = "MENUHOMEES_" + sGXsfl_41_idx ;
      chkMenuHomeEs.setName( GXCCtl );
      chkMenuHomeEs.setWebtags( "" );
      chkMenuHomeEs.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkMenuHomeEs.getInternalname(), "TitleCaption", chkMenuHomeEs.getCaption(), !bGXsfl_41_Refreshing);
      chkMenuHomeEs.setCheckedValue( "false" );
      A1934MenuHomeEs = GXutil.strtobool( GXutil.booltostr( A1934MenuHomeEs)) ;
      Gridlevel_opcionesRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkMenuHomeEs.getInternalname(),GXutil.booltostr( A1934MenuHomeEs),"","",Integer.valueOf(-1),Integer.valueOf(chkMenuHomeEs.getEnabled()),"true","",StyleString,ClassString,"TrnColumn","",TempTags+" onclick="+"\"gx.fn.checkboxClick(48, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,48);\""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_256_" + sGXsfl_41_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 49,'',false,'" + sGXsfl_41_idx + "',41)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_opcionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMenuItemOrd_Internalname,GXutil.ltrim( localUtil.ntoc( A1940MenuItemOrd, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtMenuItemOrd_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1940MenuItemOrd), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1940MenuItemOrd), "Z9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,49);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMenuItemOrd_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtMenuItemOrd_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_256_" + sGXsfl_41_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 50,'',false,'" + sGXsfl_41_idx + "',41)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_opcionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMenuBienveTitulo_Internalname,A1949MenuBienveTitulo,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,50);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMenuBienveTitulo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtMenuBienveTitulo_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_256_" + sGXsfl_41_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 51,'',false,'" + sGXsfl_41_idx + "',41)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_opcionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMenuBienveTexto_Internalname,A1950MenuBienveTexto,A1950MenuBienveTexto,TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,51);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMenuBienveTexto_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtMenuBienveTexto_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
      /* Subfile cell */
      ClassString = "Attribute" ;
      StyleString = "" ;
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_256_" + sGXsfl_41_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 52,'',false,'" + sGXsfl_41_idx + "',41)\"" ;
      edtMenuBienveImg_Filename = A1948MenuBienveImgNom ;
      edtMenuBienveImg_Filetype = "" ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuBienveImg_Internalname, "Filetype", edtMenuBienveImg_Filetype, !bGXsfl_41_Refreshing);
      edtMenuBienveImg_Filetype = A1947MenuBienveImgExt ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuBienveImg_Internalname, "Filetype", edtMenuBienveImg_Filetype, !bGXsfl_41_Refreshing);
      if ( ! (GXutil.strcmp("", A1946MenuBienveImg)==0) )
      {
         gxblobfileaux.setSource( A1946MenuBienveImg );
         if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtMenuBienveImg_Filetype, "tmp") != 0 ) )
         {
            gxblobfileaux.setExt(GXutil.trim( edtMenuBienveImg_Filetype));
         }
         if ( gxblobfileaux.getErrCode() == 0 )
         {
            A1946MenuBienveImg = gxblobfileaux.getURI() ;
            httpContext.ajax_rsp_assign_prop("", false, edtMenuBienveImg_Internalname, "URL", httpContext.getResourceRelative(A1946MenuBienveImg), !bGXsfl_41_Refreshing);
            edtMenuBienveImg_Filetype = gxblobfileaux.getExtension() ;
            httpContext.ajax_rsp_assign_prop("", false, edtMenuBienveImg_Internalname, "Filetype", edtMenuBienveImg_Filetype, !bGXsfl_41_Refreshing);
            gxblobfileaux.setBlobToDelete();
         }
         httpContext.ajax_rsp_assign_prop("", false, edtMenuBienveImg_Internalname, "URL", httpContext.getResourceRelative(A1946MenuBienveImg), !bGXsfl_41_Refreshing);
      }
      Gridlevel_opcionesRow.AddColumnProperties("blob", 2, isAjaxCallMode( ), new Object[] {edtMenuBienveImg_Internalname,GXutil.rtrim( A1946MenuBienveImg),httpContext.getResourceRelative(A1946MenuBienveImg),((GXutil.strcmp("", edtMenuBienveImg_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtMenuBienveImg_Filetype)==0) ? A1946MenuBienveImg : edtMenuBienveImg_Filetype)) : edtMenuBienveImg_Contenttype),Boolean.valueOf(true),"",edtMenuBienveImg_Parameters,Integer.valueOf(0),Integer.valueOf(edtMenuBienveImg_Enabled),Integer.valueOf(-1),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(60),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),edtMenuBienveImg_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'",StyleString,ClassString,"TrnColumn","",""+TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,52);\"","",""});
      /* Subfile cell */
      /* Check box */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_256_" + sGXsfl_41_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 53,'',false,'" + sGXsfl_41_idx + "',41)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      GXCCtl = "MENUBIENVEVISIBLE_" + sGXsfl_41_idx ;
      chkMenuBienveVisible.setName( GXCCtl );
      chkMenuBienveVisible.setWebtags( "" );
      chkMenuBienveVisible.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkMenuBienveVisible.getInternalname(), "TitleCaption", chkMenuBienveVisible.getCaption(), !bGXsfl_41_Refreshing);
      chkMenuBienveVisible.setCheckedValue( "false" );
      if ( isIns( ) && (false==A1951MenuBienveVisible) )
      {
         A1951MenuBienveVisible = true ;
      }
      Gridlevel_opcionesRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkMenuBienveVisible.getInternalname(),GXutil.booltostr( A1951MenuBienveVisible),"","",Integer.valueOf(-1),Integer.valueOf(chkMenuBienveVisible.getEnabled()),"true","",StyleString,ClassString,"TrnColumn","",TempTags+" onclick="+"\"gx.fn.checkboxClick(53, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,53);\""});
      /* Subfile cell */
      /* Check box */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_256_" + sGXsfl_41_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 54,'',false,'" + sGXsfl_41_idx + "',41)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      GXCCtl = "MENUOPCINST_" + sGXsfl_41_idx ;
      chkMenuOpcInst.setName( GXCCtl );
      chkMenuOpcInst.setWebtags( "" );
      chkMenuOpcInst.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkMenuOpcInst.getInternalname(), "TitleCaption", chkMenuOpcInst.getCaption(), !bGXsfl_41_Refreshing);
      chkMenuOpcInst.setCheckedValue( "false" );
      A2363MenuOpcInst = GXutil.strtobool( GXutil.booltostr( A2363MenuOpcInst)) ;
      Gridlevel_opcionesRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkMenuOpcInst.getInternalname(),GXutil.booltostr( A2363MenuOpcInst),"","",Integer.valueOf(-1),Integer.valueOf(chkMenuOpcInst.getEnabled()),"true","",StyleString,ClassString,"TrnColumn","",TempTags+" onclick="+"\"gx.fn.checkboxClick(54, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,54);\""});
      /* Subfile cell */
      /* Check box */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_256_" + sGXsfl_41_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 55,'',false,'" + sGXsfl_41_idx + "',41)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      GXCCtl = "MENUOPCFORRET_" + sGXsfl_41_idx ;
      chkMenuOpcForRet.setName( GXCCtl );
      chkMenuOpcForRet.setWebtags( "" );
      chkMenuOpcForRet.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkMenuOpcForRet.getInternalname(), "TitleCaption", chkMenuOpcForRet.getCaption(), !bGXsfl_41_Refreshing);
      chkMenuOpcForRet.setCheckedValue( "false" );
      A2367MenuOpcForRet = GXutil.strtobool( GXutil.booltostr( A2367MenuOpcForRet)) ;
      Gridlevel_opcionesRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkMenuOpcForRet.getInternalname(),GXutil.booltostr( A2367MenuOpcForRet),"","",Integer.valueOf(-1),Integer.valueOf(chkMenuOpcForRet.getEnabled()),"true","",StyleString,ClassString,"TrnColumn","",TempTags+" onclick="+"\"gx.fn.checkboxClick(55, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,55);\""});
      httpContext.ajax_sending_grid_row(Gridlevel_opcionesRow);
      send_integrity_lvl_hashes5V256( ) ;
      GXCCtl = "Z1929MenuOpcCod_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z1929MenuOpcCod);
      GXCCtl = "Z1931MenuOpcTitulo_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z1931MenuOpcTitulo);
      GXCCtl = "Z1951MenuBienveVisible_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_boolean_hidden_field( httpContext, GXCCtl, Z1951MenuBienveVisible);
      GXCCtl = "Z1933MenuOpcPadre_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z1933MenuOpcPadre));
      GXCCtl = "Z1934MenuHomeEs_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_boolean_hidden_field( httpContext, GXCCtl, Z1934MenuHomeEs);
      GXCCtl = "Z1940MenuItemOrd_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1940MenuItemOrd, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1949MenuBienveTitulo_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z1949MenuBienveTitulo);
      GXCCtl = "Z2361MenuOpcObj_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z2361MenuOpcObj));
      GXCCtl = "Z2363MenuOpcInst_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_boolean_hidden_field( httpContext, GXCCtl, Z2363MenuOpcInst);
      GXCCtl = "Z2367MenuOpcForRet_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_boolean_hidden_field( httpContext, GXCCtl, Z2367MenuOpcForRet);
      GXCCtl = "Z1935SVGId_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z1935SVGId));
      GXCCtl = "Z1937MenuItemId_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z1937MenuItemId);
      GXCCtl = "nRcdDeleted_256_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_256, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_256_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_256, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_256_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_256, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vROLID_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7RolId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vPERFILID_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV8PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMENUVERID_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV9MenuVerId, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "MENUITEMIMG_" + sGXsfl_41_idx ;
      GXCCtlgxBlob = GXCCtl + "_gxBlob" ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A1941MenuItemImg);
      GXCCtl = "MENUBIENVEIMG_" + sGXsfl_41_idx ;
      GXCCtlgxBlob = GXCCtl + "_gxBlob" ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A1946MenuBienveImg);
      GXCCtl = "MENUITEMIMG_Filetype_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( edtMenuItemImg_Filetype));
      GXCCtl = "MENUBIENVEIMG_Filetype_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( edtMenuBienveImg_Filetype));
      GXCCtl = "MENUITEMIMG_Filename_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( edtMenuItemImg_Filename));
      GXCCtl = "MENUBIENVEIMG_Filename_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( edtMenuBienveImg_Filename));
      GXCCtl = "MENUITEMIMG_Filename_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( edtMenuItemImg_Filename));
      GXCCtl = "MENUBIENVEIMG_Filename_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( edtMenuBienveImg_Filename));
      GXCCtl = "MENUITEMIMG_Filetype_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( edtMenuItemImg_Filetype));
      GXCCtl = "MENUBIENVEIMG_Filetype_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( edtMenuBienveImg_Filetype));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUOPCCOD_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuOpcCod_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUITEMID_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuItemId_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUOPCTITULO_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuOpcTitulo_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUOPCPADRE_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynMenuOpcPadre.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "SVGID_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynSVGId.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUITEMIMG_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuItemImg_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUHOMEES_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkMenuHomeEs.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUITEMORD_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuItemOrd_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUBIENVETITULO_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuBienveTitulo_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUBIENVETEXTO_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuBienveTexto_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUBIENVEIMG_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuBienveImg_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUBIENVEVISIBLE_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkMenuBienveVisible.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUOPCINST_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkMenuOpcInst.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUOPCFORRET_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkMenuOpcForRet.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_opcionesContainer.AddRow(Gridlevel_opcionesRow);
   }

   public void readRow5V256( )
   {
      nGXsfl_41_idx = (int)(nGXsfl_41_idx+1) ;
      sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_41256( ) ;
      edtMenuOpcCod_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MENUOPCCOD_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtMenuItemId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MENUITEMID_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtMenuOpcTitulo_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MENUOPCTITULO_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      dynMenuOpcPadre.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "MENUOPCPADRE_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      dynSVGId.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "SVGID_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      edtMenuItemImg_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MENUITEMIMG_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      chkMenuHomeEs.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "MENUHOMEES_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      edtMenuItemOrd_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MENUITEMORD_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtMenuBienveTitulo_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MENUBIENVETITULO_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtMenuBienveTexto_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MENUBIENVETEXTO_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtMenuBienveImg_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MENUBIENVEIMG_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      chkMenuBienveVisible.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "MENUBIENVEVISIBLE_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      chkMenuOpcInst.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "MENUOPCINST_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      chkMenuOpcForRet.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "MENUOPCFORRET_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      GXCCtl = "MENUITEMIMG_Filetype_" + sGXsfl_41_idx ;
      edtMenuItemImg_Filetype = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "MENUBIENVEIMG_Filetype_" + sGXsfl_41_idx ;
      edtMenuBienveImg_Filetype = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "MENUITEMIMG_Filename_" + sGXsfl_41_idx ;
      edtMenuItemImg_Filename = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "MENUBIENVEIMG_Filename_" + sGXsfl_41_idx ;
      edtMenuBienveImg_Filename = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "MENUITEMIMG_Filename_" + sGXsfl_41_idx ;
      edtMenuItemImg_Filename = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "MENUBIENVEIMG_Filename_" + sGXsfl_41_idx ;
      edtMenuBienveImg_Filename = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "MENUITEMIMG_Filetype_" + sGXsfl_41_idx ;
      edtMenuItemImg_Filetype = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "MENUBIENVEIMG_Filetype_" + sGXsfl_41_idx ;
      edtMenuBienveImg_Filetype = httpContext.cgiGet( GXCCtl) ;
      A1929MenuOpcCod = httpContext.cgiGet( edtMenuOpcCod_Internalname) ;
      A1937MenuItemId = httpContext.cgiGet( edtMenuItemId_Internalname) ;
      A1931MenuOpcTitulo = httpContext.cgiGet( edtMenuOpcTitulo_Internalname) ;
      dynMenuOpcPadre.setName( dynMenuOpcPadre.getInternalname() );
      dynMenuOpcPadre.setValue( httpContext.cgiGet( dynMenuOpcPadre.getInternalname()) );
      A1933MenuOpcPadre = httpContext.cgiGet( dynMenuOpcPadre.getInternalname()) ;
      n1933MenuOpcPadre = false ;
      n1933MenuOpcPadre = ((GXutil.strcmp("", A1933MenuOpcPadre)==0) ? true : false) ;
      dynSVGId.setName( dynSVGId.getInternalname() );
      dynSVGId.setValue( httpContext.cgiGet( dynSVGId.getInternalname()) );
      A1935SVGId = httpContext.cgiGet( dynSVGId.getInternalname()) ;
      n1935SVGId = false ;
      n1935SVGId = ((GXutil.strcmp("", A1935SVGId)==0) ? true : false) ;
      A1941MenuItemImg = httpContext.cgiGet( edtMenuItemImg_Internalname) ;
      A1934MenuHomeEs = GXutil.strtobool( httpContext.cgiGet( chkMenuHomeEs.getInternalname())) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtMenuItemOrd_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtMenuItemOrd_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
      {
         GXCCtl = "MENUITEMORD_" + sGXsfl_41_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtMenuItemOrd_Internalname ;
         wbErr = true ;
         A1940MenuItemOrd = (byte)(0) ;
      }
      else
      {
         A1940MenuItemOrd = (byte)(localUtil.ctol( httpContext.cgiGet( edtMenuItemOrd_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      A1949MenuBienveTitulo = httpContext.cgiGet( edtMenuBienveTitulo_Internalname) ;
      A1950MenuBienveTexto = httpContext.cgiGet( edtMenuBienveTexto_Internalname) ;
      A1946MenuBienveImg = httpContext.cgiGet( edtMenuBienveImg_Internalname) ;
      A1951MenuBienveVisible = GXutil.strtobool( httpContext.cgiGet( chkMenuBienveVisible.getInternalname())) ;
      A2363MenuOpcInst = GXutil.strtobool( httpContext.cgiGet( chkMenuOpcInst.getInternalname())) ;
      A2367MenuOpcForRet = GXutil.strtobool( httpContext.cgiGet( chkMenuOpcForRet.getInternalname())) ;
      GXCCtl = "Z1929MenuOpcCod_" + sGXsfl_41_idx ;
      Z1929MenuOpcCod = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z1931MenuOpcTitulo_" + sGXsfl_41_idx ;
      Z1931MenuOpcTitulo = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z1951MenuBienveVisible_" + sGXsfl_41_idx ;
      Z1951MenuBienveVisible = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z1933MenuOpcPadre_" + sGXsfl_41_idx ;
      Z1933MenuOpcPadre = httpContext.cgiGet( GXCCtl) ;
      n1933MenuOpcPadre = ((GXutil.strcmp("", A1933MenuOpcPadre)==0) ? true : false) ;
      GXCCtl = "Z1934MenuHomeEs_" + sGXsfl_41_idx ;
      Z1934MenuHomeEs = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z1940MenuItemOrd_" + sGXsfl_41_idx ;
      Z1940MenuItemOrd = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1949MenuBienveTitulo_" + sGXsfl_41_idx ;
      Z1949MenuBienveTitulo = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z2361MenuOpcObj_" + sGXsfl_41_idx ;
      Z2361MenuOpcObj = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z2363MenuOpcInst_" + sGXsfl_41_idx ;
      Z2363MenuOpcInst = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z2367MenuOpcForRet_" + sGXsfl_41_idx ;
      Z2367MenuOpcForRet = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z1935SVGId_" + sGXsfl_41_idx ;
      Z1935SVGId = httpContext.cgiGet( GXCCtl) ;
      n1935SVGId = ((GXutil.strcmp("", A1935SVGId)==0) ? true : false) ;
      GXCCtl = "Z1937MenuItemId_" + sGXsfl_41_idx ;
      Z1937MenuItemId = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z2361MenuOpcObj_" + sGXsfl_41_idx ;
      A2361MenuOpcObj = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "nRcdDeleted_256_" + sGXsfl_41_idx ;
      nRcdDeleted_256 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_256_" + sGXsfl_41_idx ;
      nRcdExists_256 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_256_" + sGXsfl_41_idx ;
      nIsMod_256 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ( nRcdDeleted_256 == 0 ) && ( nIsMod_256 == 1 ) && ! (GXutil.strcmp("", A1941MenuItemImg)==0) )
      {
         edtMenuItemImg_Filename = httpContext.cgiGetFileName( edtMenuItemImg_Internalname) ;
         edtMenuItemImg_Filetype = httpContext.cgiGetFileType( edtMenuItemImg_Internalname) ;
      }
      A1942MenuItemImgExt = edtMenuItemImg_Filetype ;
      A1943MenuItemImgNom = edtMenuItemImg_Filename ;
      if ( (GXutil.strcmp("", A1941MenuItemImg)==0) )
      {
         GXCCtl = "MENUITEMIMG_" + sGXsfl_41_idx ;
         GXCCtlgxBlob = GXCCtl + "_gxBlob" ;
         A1941MenuItemImg = httpContext.cgiGet( GXCCtlgxBlob) ;
      }
      if ( ( nRcdDeleted_256 == 0 ) && ( nIsMod_256 == 1 ) && ! (GXutil.strcmp("", A1946MenuBienveImg)==0) )
      {
         edtMenuBienveImg_Filename = httpContext.cgiGetFileName( edtMenuBienveImg_Internalname) ;
         edtMenuBienveImg_Filetype = httpContext.cgiGetFileType( edtMenuBienveImg_Internalname) ;
      }
      A1947MenuBienveImgExt = edtMenuBienveImg_Filetype ;
      A1948MenuBienveImgNom = edtMenuBienveImg_Filename ;
      if ( (GXutil.strcmp("", A1946MenuBienveImg)==0) )
      {
         GXCCtl = "MENUBIENVEIMG_" + sGXsfl_41_idx ;
         GXCCtlgxBlob = GXCCtl + "_gxBlob" ;
         A1946MenuBienveImg = httpContext.cgiGet( GXCCtlgxBlob) ;
      }
   }

   public void assign_properties_default( )
   {
      defedtMenuOpcCod_Enabled = edtMenuOpcCod_Enabled ;
   }

   public void confirmValues5V0( )
   {
      nGXsfl_41_idx = 0 ;
      sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_41256( ) ;
      while ( nGXsfl_41_idx < nRC_GXsfl_41 )
      {
         nGXsfl_41_idx = (int)(nGXsfl_41_idx+1) ;
         sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_41256( ) ;
         httpContext.changePostValue( "Z1929MenuOpcCod_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z1929MenuOpcCod_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1929MenuOpcCod_"+sGXsfl_41_idx) ;
         httpContext.changePostValue( "Z1931MenuOpcTitulo_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z1931MenuOpcTitulo_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1931MenuOpcTitulo_"+sGXsfl_41_idx) ;
         httpContext.changePostValue( "Z1951MenuBienveVisible_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z1951MenuBienveVisible_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1951MenuBienveVisible_"+sGXsfl_41_idx) ;
         httpContext.changePostValue( "Z1933MenuOpcPadre_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z1933MenuOpcPadre_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1933MenuOpcPadre_"+sGXsfl_41_idx) ;
         httpContext.changePostValue( "Z1934MenuHomeEs_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z1934MenuHomeEs_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1934MenuHomeEs_"+sGXsfl_41_idx) ;
         httpContext.changePostValue( "Z1940MenuItemOrd_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z1940MenuItemOrd_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1940MenuItemOrd_"+sGXsfl_41_idx) ;
         httpContext.changePostValue( "Z1949MenuBienveTitulo_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z1949MenuBienveTitulo_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1949MenuBienveTitulo_"+sGXsfl_41_idx) ;
         httpContext.changePostValue( "Z2361MenuOpcObj_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z2361MenuOpcObj_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2361MenuOpcObj_"+sGXsfl_41_idx) ;
         httpContext.changePostValue( "Z2363MenuOpcInst_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z2363MenuOpcInst_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2363MenuOpcInst_"+sGXsfl_41_idx) ;
         httpContext.changePostValue( "Z2367MenuOpcForRet_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z2367MenuOpcForRet_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2367MenuOpcForRet_"+sGXsfl_41_idx) ;
         httpContext.changePostValue( "Z1935SVGId_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z1935SVGId_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1935SVGId_"+sGXsfl_41_idx) ;
         httpContext.changePostValue( "Z1937MenuItemId_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z1937MenuItemId_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1937MenuItemId_"+sGXsfl_41_idx) ;
      }
   }

   public void renderHtmlHeaders( )
   {
      web.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( Form.getCaption()) ;
      httpContext.writeTextNL( "</title>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( GXutil.len( sDynURL) > 0 )
      {
         httpContext.writeText( "<BASE href=\""+sDynURL+"\" />") ;
      }
      define_styles( ) ;
      MasterPageObj.master_styles();
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      bodyStyle += "-moz-opacity:0;opacity:0;" ;
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.menuversiones", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7RolId,2,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8PerfilId,2,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9MenuVerId,15,0))}, new String[] {"Gx_mode","RolId","PerfilId","MenuVerId"}) +"\">") ;
      web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"MenuVersiones");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("menuversiones:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z1923RolId", GXutil.ltrim( localUtil.ntoc( Z1923RolId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1925PerfilId", GXutil.ltrim( localUtil.ntoc( Z1925PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1928MenuVerId", GXutil.ltrim( localUtil.ntoc( Z1928MenuVerId, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1927MenuPais", GXutil.ltrim( localUtil.ntoc( Z1927MenuPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_41", GXutil.ltrim( localUtil.ntoc( nGXsfl_41_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N1927MenuPais", GXutil.ltrim( localUtil.ntoc( A1927MenuPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vROLID", GXutil.ltrim( localUtil.ntoc( AV7RolId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vROLID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7RolId), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPERFILID", GXutil.ltrim( localUtil.ntoc( AV8PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERFILID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8PerfilId), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUVERID", GXutil.ltrim( localUtil.ntoc( AV9MenuVerId, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUVERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9MenuVerId), "ZZZZZZZZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_MENUPAIS", GXutil.ltrim( localUtil.ntoc( AV15Insert_MenuPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV31Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUOPCHORMIGA", A2362MenuOpcHormiga);
      web.GxWebStd.gx_hidden_field( httpContext, "MENUITEMTITULO", A1939MenuItemTitulo);
      web.GxWebStd.gx_hidden_field( httpContext, "vMITEMICOIMG", AV21MitemIcoImg);
      web.GxWebStd.gx_hidden_field( httpContext, "vMITEMBIENIMGDEF", AV22MItemBienImgDef);
      web.GxWebStd.gx_hidden_field( httpContext, "vMITEMBIENTITDEF", AV23MItemBienTitDef);
      web.GxWebStd.gx_hidden_field( httpContext, "vMITEMBIENTEXTDEF", AV24MItemBienTextDef);
      web.GxWebStd.gx_hidden_field( httpContext, "vMITEMICOSVG", GXutil.rtrim( AV20MItemIcoSVG));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUOPCOBJ", GXutil.rtrim( A2361MenuOpcObj));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUITEMIMGEXT", GXutil.rtrim( A1942MenuItemImgExt));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUBIENVEIMGEXT", GXutil.rtrim( A1947MenuBienveImgExt));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUITEMIMGNOM", A1943MenuItemImgNom);
      web.GxWebStd.gx_hidden_field( httpContext, "MENUBIENVEIMGNOM", A1948MenuBienveImgNom);
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Objectcall", GXutil.rtrim( Dvpanel_tableattributes_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Enabled", GXutil.booltostr( Dvpanel_tableattributes_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
      httpContext.SendComponentObjects();
      httpContext.SendServerCommands();
      httpContext.SendState();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      httpContext.writeTextNL( "</form>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      include_jscripts( ) ;
      httpContext.writeText( "<script type=\"text/javascript\">") ;
      httpContext.writeText( "gx.setLanguageCode(\""+httpContext.getLanguageProperty( "code")+"\");") ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         httpContext.writeText( "gx.setDateFormat(\""+httpContext.getLanguageProperty( "date_fmt")+"\");") ;
         httpContext.writeText( "gx.setTimeFormat("+httpContext.getLanguageProperty( "time_fmt")+");") ;
         httpContext.writeText( "gx.setCenturyFirstYear("+40+");") ;
         httpContext.writeText( "gx.setDecimalPoint(\""+httpContext.getLanguageProperty( "decimal_point")+"\");") ;
         httpContext.writeText( "gx.setThousandSeparator(\""+httpContext.getLanguageProperty( "thousand_sep")+"\");") ;
         httpContext.writeText( "gx.StorageTimeZone = "+1+";") ;
      }
      httpContext.writeText( "</script>") ;
   }

   public byte executeStartEvent( )
   {
      standaloneStartup( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      return gxajaxcallmode ;
   }

   public void renderHtmlContent( )
   {
      httpContext.writeText( "<div") ;
      web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
      httpContext.writeText( ">") ;
      draw( ) ;
      httpContext.writeText( "</div>") ;
   }

   public void dispatchEvents( )
   {
      process( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.menuversiones", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7RolId,2,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8PerfilId,2,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9MenuVerId,15,0))}, new String[] {"Gx_mode","RolId","PerfilId","MenuVerId"})  ;
   }

   public String getPgmname( )
   {
      return "MenuVersiones" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Menu Versiones", "") ;
   }

   public void initializeNonKey5V255( )
   {
      A1927MenuPais = (short)(0) ;
      n1927MenuPais = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1927MenuPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1927MenuPais), 4, 0));
      n1927MenuPais = ((0==A1927MenuPais) ? true : false) ;
      Z1927MenuPais = (short)(0) ;
   }

   public void initAll5V255( )
   {
      A1923RolId = (byte)(1) ;
      n1923RolId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
      A1925PerfilId = (byte)(0) ;
      n1925PerfilId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
      A1928MenuVerId = 0 ;
      n1928MenuVerId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1928MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1928MenuVerId), 15, 0));
      initializeNonKey5V255( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey5V256( )
   {
      AV20MItemIcoSVG = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20MItemIcoSVG", AV20MItemIcoSVG);
      AV21MitemIcoImg = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21MitemIcoImg", AV21MitemIcoImg);
      AV22MItemBienImgDef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22MItemBienImgDef", AV22MItemBienImgDef);
      AV23MItemBienTitDef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23MItemBienTitDef", AV23MItemBienTitDef);
      AV24MItemBienTextDef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24MItemBienTextDef", AV24MItemBienTextDef);
      A2362MenuOpcHormiga = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2362MenuOpcHormiga", A2362MenuOpcHormiga);
      A1937MenuItemId = "" ;
      A1933MenuOpcPadre = "" ;
      n1933MenuOpcPadre = false ;
      A1934MenuHomeEs = false ;
      A1940MenuItemOrd = (byte)(0) ;
      A1939MenuItemTitulo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1939MenuItemTitulo", A1939MenuItemTitulo);
      A2361MenuOpcObj = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2361MenuOpcObj", A2361MenuOpcObj);
      A2363MenuOpcInst = false ;
      A2367MenuOpcForRet = false ;
      A1942MenuItemImgExt = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1942MenuItemImgExt", A1942MenuItemImgExt);
      A1947MenuBienveImgExt = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1947MenuBienveImgExt", A1947MenuBienveImgExt);
      A1943MenuItemImgNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1943MenuItemImgNom", A1943MenuItemImgNom);
      A1948MenuBienveImgNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1948MenuBienveImgNom", A1948MenuBienveImgNom);
      A1931MenuOpcTitulo = "" ;
      A1951MenuBienveVisible = true ;
      A1935SVGId = AV20MItemIcoSVG ;
      n1935SVGId = false ;
      A1941MenuItemImg = AV21MitemIcoImg ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemImg_Internalname, "URL", httpContext.getResourceRelative(A1941MenuItemImg), !bGXsfl_41_Refreshing);
      A1946MenuBienveImg = AV22MItemBienImgDef ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuBienveImg_Internalname, "URL", httpContext.getResourceRelative(A1946MenuBienveImg), !bGXsfl_41_Refreshing);
      A1949MenuBienveTitulo = AV23MItemBienTitDef ;
      A1950MenuBienveTexto = AV24MItemBienTextDef ;
      Z1931MenuOpcTitulo = "" ;
      Z1951MenuBienveVisible = false ;
      Z1933MenuOpcPadre = "" ;
      Z1934MenuHomeEs = false ;
      Z1940MenuItemOrd = (byte)(0) ;
      Z1949MenuBienveTitulo = "" ;
      Z2361MenuOpcObj = "" ;
      Z2363MenuOpcInst = false ;
      Z2367MenuOpcForRet = false ;
      Z1935SVGId = "" ;
      Z1937MenuItemId = "" ;
   }

   public void initAll5V256( )
   {
      A1929MenuOpcCod = "" ;
      initializeNonKey5V256( ) ;
   }

   public void standaloneModalInsert5V256( )
   {
      A1951MenuBienveVisible = i1951MenuBienveVisible ;
   }

   public void define_styles( )
   {
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025187483130", true, true);
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
      httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("menuversiones.js", "?2025187483131", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties256( )
   {
      edtMenuOpcCod_Enabled = defedtMenuOpcCod_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuOpcCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuOpcCod_Enabled), 5, 0), !bGXsfl_41_Refreshing);
   }

   public void startgridcontrol41( )
   {
      Gridlevel_opcionesContainer.AddObjectProperty("GridName", "Gridlevel_opciones");
      Gridlevel_opcionesContainer.AddObjectProperty("Header", subGridlevel_opciones_Header);
      Gridlevel_opcionesContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_opcionesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_opciones_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_opcionesContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_opcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_opcionesColumn.AddObjectProperty("Value", A1929MenuOpcCod);
      Gridlevel_opcionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuOpcCod_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddColumnProperties(Gridlevel_opcionesColumn);
      Gridlevel_opcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_opcionesColumn.AddObjectProperty("Value", A1937MenuItemId);
      Gridlevel_opcionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuItemId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddColumnProperties(Gridlevel_opcionesColumn);
      Gridlevel_opcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_opcionesColumn.AddObjectProperty("Value", A1931MenuOpcTitulo);
      Gridlevel_opcionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuOpcTitulo_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddColumnProperties(Gridlevel_opcionesColumn);
      Gridlevel_opcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_opcionesColumn.AddObjectProperty("Value", GXutil.rtrim( A1933MenuOpcPadre));
      Gridlevel_opcionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( dynMenuOpcPadre.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddColumnProperties(Gridlevel_opcionesColumn);
      Gridlevel_opcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_opcionesColumn.AddObjectProperty("Value", GXutil.rtrim( A1935SVGId));
      Gridlevel_opcionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( dynSVGId.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddColumnProperties(Gridlevel_opcionesColumn);
      Gridlevel_opcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_opcionesColumn.AddObjectProperty("Value", A1941MenuItemImg);
      Gridlevel_opcionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuItemImg_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddColumnProperties(Gridlevel_opcionesColumn);
      Gridlevel_opcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_opcionesColumn.AddObjectProperty("Value", GXutil.booltostr( A1934MenuHomeEs));
      Gridlevel_opcionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkMenuHomeEs.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddColumnProperties(Gridlevel_opcionesColumn);
      Gridlevel_opcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_opcionesColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1940MenuItemOrd, (byte)(2), (byte)(0), ".", "")));
      Gridlevel_opcionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuItemOrd_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddColumnProperties(Gridlevel_opcionesColumn);
      Gridlevel_opcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_opcionesColumn.AddObjectProperty("Value", A1949MenuBienveTitulo);
      Gridlevel_opcionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuBienveTitulo_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddColumnProperties(Gridlevel_opcionesColumn);
      Gridlevel_opcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_opcionesColumn.AddObjectProperty("Value", A1950MenuBienveTexto);
      Gridlevel_opcionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuBienveTexto_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddColumnProperties(Gridlevel_opcionesColumn);
      Gridlevel_opcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_opcionesColumn.AddObjectProperty("Value", A1946MenuBienveImg);
      Gridlevel_opcionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtMenuBienveImg_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddColumnProperties(Gridlevel_opcionesColumn);
      Gridlevel_opcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_opcionesColumn.AddObjectProperty("Value", GXutil.booltostr( A1951MenuBienveVisible));
      Gridlevel_opcionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkMenuBienveVisible.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddColumnProperties(Gridlevel_opcionesColumn);
      Gridlevel_opcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_opcionesColumn.AddObjectProperty("Value", GXutil.booltostr( A2363MenuOpcInst));
      Gridlevel_opcionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkMenuOpcInst.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddColumnProperties(Gridlevel_opcionesColumn);
      Gridlevel_opcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_opcionesColumn.AddObjectProperty("Value", GXutil.booltostr( A2367MenuOpcForRet));
      Gridlevel_opcionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkMenuOpcForRet.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddColumnProperties(Gridlevel_opcionesColumn);
      Gridlevel_opcionesContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_opciones_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_opciones_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_opciones_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_opciones_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_opciones_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_opciones_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_opciones_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      dynPerfilId.setInternalname( "PERFILID" );
      edtMenuVerId_Internalname = "MENUVERID" ;
      dynMenuPais.setInternalname( "MENUPAIS" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      edtMenuOpcCod_Internalname = "MENUOPCCOD" ;
      edtMenuItemId_Internalname = "MENUITEMID" ;
      edtMenuOpcTitulo_Internalname = "MENUOPCTITULO" ;
      dynMenuOpcPadre.setInternalname( "MENUOPCPADRE" );
      dynSVGId.setInternalname( "SVGID" );
      edtMenuItemImg_Internalname = "MENUITEMIMG" ;
      chkMenuHomeEs.setInternalname( "MENUHOMEES" );
      edtMenuItemOrd_Internalname = "MENUITEMORD" ;
      edtMenuBienveTitulo_Internalname = "MENUBIENVETITULO" ;
      edtMenuBienveTexto_Internalname = "MENUBIENVETEXTO" ;
      edtMenuBienveImg_Internalname = "MENUBIENVEIMG" ;
      chkMenuBienveVisible.setInternalname( "MENUBIENVEVISIBLE" );
      chkMenuOpcInst.setInternalname( "MENUOPCINST" );
      chkMenuOpcForRet.setInternalname( "MENUOPCFORRET" );
      divTableleaflevel_opciones_Internalname = "TABLELEAFLEVEL_OPCIONES" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtRolId_Internalname = "ROLID" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel_opciones_Internalname = "GRIDLEVEL_OPCIONES" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      subGridlevel_opciones_Allowcollapsing = (byte)(0) ;
      subGridlevel_opciones_Allowselection = (byte)(0) ;
      subGridlevel_opciones_Header = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Menu Versiones", "") );
      chkMenuOpcForRet.setCaption( "" );
      chkMenuOpcInst.setCaption( "" );
      chkMenuBienveVisible.setCaption( "" );
      edtMenuBienveImg_Jsonclick = "" ;
      edtMenuBienveImg_Parameters = "" ;
      edtMenuBienveImg_Contenttype = "" ;
      edtMenuBienveTexto_Jsonclick = "" ;
      edtMenuBienveTitulo_Jsonclick = "" ;
      edtMenuItemOrd_Jsonclick = "" ;
      chkMenuHomeEs.setCaption( "" );
      edtMenuItemImg_Jsonclick = "" ;
      edtMenuItemImg_Parameters = "" ;
      edtMenuItemImg_Contenttype = "" ;
      dynSVGId.setJsonclick( "" );
      dynMenuOpcPadre.setJsonclick( "" );
      edtMenuOpcTitulo_Jsonclick = "" ;
      edtMenuItemId_Jsonclick = "" ;
      edtMenuOpcCod_Jsonclick = "" ;
      subGridlevel_opciones_Class = "WorkWith" ;
      subGridlevel_opciones_Backcolorstyle = (byte)(0) ;
      edtMenuBienveImg_Filename = "" ;
      edtMenuItemImg_Filename = "" ;
      edtMenuBienveImg_Filetype = "" ;
      edtMenuItemImg_Filetype = "" ;
      edtRolId_Jsonclick = "" ;
      edtRolId_Enabled = 1 ;
      edtRolId_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      chkMenuOpcForRet.setEnabled( 1 );
      chkMenuOpcInst.setEnabled( 1 );
      chkMenuBienveVisible.setEnabled( 1 );
      edtMenuBienveImg_Enabled = 1 ;
      edtMenuBienveTexto_Enabled = 1 ;
      edtMenuBienveTitulo_Enabled = 1 ;
      edtMenuItemOrd_Enabled = 1 ;
      chkMenuHomeEs.setEnabled( 1 );
      edtMenuItemImg_Enabled = 1 ;
      dynSVGId.setEnabled( 1 );
      dynMenuOpcPadre.setEnabled( 1 );
      edtMenuOpcTitulo_Enabled = 1 ;
      edtMenuItemId_Enabled = 1 ;
      edtMenuOpcCod_Enabled = 1 ;
      dynMenuPais.setJsonclick( "" );
      dynMenuPais.setEnabled( 1 );
      edtMenuVerId_Jsonclick = "" ;
      edtMenuVerId_Enabled = 1 ;
      dynPerfilId.setJsonclick( "" );
      dynPerfilId.setEnabled( 1 );
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "WWP_TemplateDataPanelTitle", "") ;
      Dvpanel_tableattributes_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      divLayoutmaintable_Class = "Table" ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlaperfilid5V1( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaperfilid_data5V1( ) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxaperfilid_html5V1( )
   {
      byte gxdynajaxvalue;
      gxdlaperfilid_data5V1( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynPerfilId.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (byte)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynPerfilId.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 2, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaperfilid_data5V1( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T005V36 */
      pr_default.execute(34);
      while ( (pr_default.getStatus(34) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T005V36_A1925PerfilId[0], (byte)(2), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T005V36_A1926PerfilNombre[0]);
         pr_default.readNext(34);
      }
      pr_default.close(34);
   }

   public void gxdlamenupais5V255( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlamenupais_data5V255( ) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxamenupais_html5V255( )
   {
      short gxdynajaxvalue;
      gxdlamenupais_data5V255( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynMenuPais.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynMenuPais.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlamenupais_data5V255( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T005V37 */
      pr_default.execute(35);
      while ( (pr_default.getStatus(35) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T005V37_A1927MenuPais[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T005V37_A312PaiNom[0]);
         pr_default.readNext(35);
      }
      pr_default.close(35);
   }

   public void gxdlamenuopcpadre5V256( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlamenuopcpadre_data5V256( ) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxamenuopcpadre_html5V256( )
   {
      String gxdynajaxvalue;
      gxdlamenuopcpadre_data5V256( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynMenuOpcPadre.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynMenuOpcPadre.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlamenuopcpadre_data5V256( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T005V38 */
      pr_default.execute(36);
      while ( (pr_default.getStatus(36) != 101) )
      {
         gxdynajaxctrlcodr.add(T005V38_A1929MenuOpcCod[0]);
         gxdynajaxctrldescr.add(T005V38_A1929MenuOpcCod[0]);
         pr_default.readNext(36);
      }
      pr_default.close(36);
   }

   public void gxdlasvgid5V256( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlasvgid_data5V256( ) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxasvgid_html5V256( )
   {
      String gxdynajaxvalue;
      gxdlasvgid_data5V256( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynSVGId.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynSVGId.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlasvgid_data5V256( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T005V39 */
      pr_default.execute(37);
      while ( (pr_default.getStatus(37) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T005V39_A1935SVGId[0]));
         gxdynajaxctrldescr.add(GXutil.rtrim( T005V39_A1935SVGId[0]));
         pr_default.readNext(37);
      }
      pr_default.close(37);
   }

   public void gx16asamenuopchormiga5V256( String A1929MenuOpcCod ,
                                           byte A1923RolId ,
                                           byte A1925PerfilId ,
                                           long A1928MenuVerId )
   {
      GXt_char4 = A2362MenuOpcHormiga ;
      GXv_char10[0] = "" ;
      GXv_char9[0] = "" ;
      GXv_char8[0] = "" ;
      GXv_char7[0] = GXt_char4 ;
      new web.gethtmlnewbreadcrumb(remoteHandle, context).execute( A1929MenuOpcCod, A1923RolId, A1925PerfilId, A1928MenuVerId, GXv_char10, GXv_char9, GXv_char8, GXv_char7) ;
      menuversiones_impl.this.GXt_char4 = GXv_char7[0] ;
      A2362MenuOpcHormiga = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "A2362MenuOpcHormiga", A2362MenuOpcHormiga);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A2362MenuOpcHormiga)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_26_5V256( byte A1925PerfilId ,
                            String A1937MenuItemId )
   {
      GXv_char10[0] = "" ;
      GXv_char9[0] = AV20MItemIcoSVG ;
      GXv_char8[0] = AV21MitemIcoImg ;
      GXv_char7[0] = AV22MItemBienImgDef ;
      GXv_char6[0] = AV23MItemBienTitDef ;
      GXv_char5[0] = AV24MItemBienTextDef ;
      new web.getmenuitempredeterminados(remoteHandle, context).execute( A1925PerfilId, A1937MenuItemId, GXv_char10, GXv_char9, GXv_char8, GXv_char7, GXv_char6, GXv_char5) ;
      AV20MItemIcoSVG = GXv_char9[0] ;
      AV21MitemIcoImg = GXv_char8[0] ;
      AV22MItemBienImgDef = GXv_char7[0] ;
      AV23MItemBienTitDef = GXv_char6[0] ;
      AV24MItemBienTextDef = GXv_char5[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20MItemIcoSVG", AV20MItemIcoSVG);
      httpContext.ajax_rsp_assign_attri("", false, "AV21MitemIcoImg", AV21MitemIcoImg);
      httpContext.ajax_rsp_assign_attri("", false, "AV22MItemBienImgDef", AV22MItemBienImgDef);
      httpContext.ajax_rsp_assign_attri("", false, "AV23MItemBienTitDef", AV23MItemBienTitDef);
      httpContext.ajax_rsp_assign_attri("", false, "AV24MItemBienTextDef", AV24MItemBienTextDef);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( AV20MItemIcoSVG))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( AV21MitemIcoImg)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( AV22MItemBienImgDef)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( AV23MItemBienTitDef)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( AV24MItemBienTextDef)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gxnrgridlevel_opciones_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_41256( ) ;
      while ( nGXsfl_41_idx <= nRC_GXsfl_41 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal5V256( ) ;
         standaloneModal5V256( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow5V256( ) ;
         nGXsfl_41_idx = (int)(nGXsfl_41_idx+1) ;
         sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_41256( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_opcionesContainer)) ;
      /* End function gxnrGridlevel_opciones_newrow */
   }

   public void init_web_controls( )
   {
      dynPerfilId.setName( "PERFILID" );
      dynPerfilId.setWebtags( "" );
      dynPerfilId.removeAllItems();
      /* Using cursor T005V40 */
      pr_default.execute(38);
      while ( (pr_default.getStatus(38) != 101) )
      {
         dynPerfilId.addItem(GXutil.trim( GXutil.str( T005V40_A1925PerfilId[0], 2, 0)), T005V40_A1926PerfilNombre[0], (short)(0));
         pr_default.readNext(38);
      }
      pr_default.close(38);
      if ( dynPerfilId.getItemCount() > 0 )
      {
         A1925PerfilId = (byte)(GXutil.lval( dynPerfilId.getValidValue(GXutil.trim( GXutil.str( A1925PerfilId, 2, 0))))) ;
         n1925PerfilId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
      }
      dynMenuPais.setName( "MENUPAIS" );
      dynMenuPais.setWebtags( "" );
      GXCCtl = "MENUOPCPADRE_" + sGXsfl_41_idx ;
      dynMenuOpcPadre.setName( GXCCtl );
      dynMenuOpcPadre.setWebtags( "" );
      GXCCtl = "SVGID_" + sGXsfl_41_idx ;
      dynSVGId.setName( GXCCtl );
      dynSVGId.setWebtags( "" );
      GXCCtl = "MENUHOMEES_" + sGXsfl_41_idx ;
      chkMenuHomeEs.setName( GXCCtl );
      chkMenuHomeEs.setWebtags( "" );
      chkMenuHomeEs.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkMenuHomeEs.getInternalname(), "TitleCaption", chkMenuHomeEs.getCaption(), !bGXsfl_41_Refreshing);
      chkMenuHomeEs.setCheckedValue( "false" );
      A1934MenuHomeEs = GXutil.strtobool( GXutil.booltostr( A1934MenuHomeEs)) ;
      GXCCtl = "MENUBIENVEVISIBLE_" + sGXsfl_41_idx ;
      chkMenuBienveVisible.setName( GXCCtl );
      chkMenuBienveVisible.setWebtags( "" );
      chkMenuBienveVisible.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkMenuBienveVisible.getInternalname(), "TitleCaption", chkMenuBienveVisible.getCaption(), !bGXsfl_41_Refreshing);
      chkMenuBienveVisible.setCheckedValue( "false" );
      if ( isIns( ) && (false==A1951MenuBienveVisible) )
      {
         A1951MenuBienveVisible = true ;
      }
      GXCCtl = "MENUOPCINST_" + sGXsfl_41_idx ;
      chkMenuOpcInst.setName( GXCCtl );
      chkMenuOpcInst.setWebtags( "" );
      chkMenuOpcInst.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkMenuOpcInst.getInternalname(), "TitleCaption", chkMenuOpcInst.getCaption(), !bGXsfl_41_Refreshing);
      chkMenuOpcInst.setCheckedValue( "false" );
      A2363MenuOpcInst = GXutil.strtobool( GXutil.booltostr( A2363MenuOpcInst)) ;
      GXCCtl = "MENUOPCFORRET_" + sGXsfl_41_idx ;
      chkMenuOpcForRet.setName( GXCCtl );
      chkMenuOpcForRet.setWebtags( "" );
      chkMenuOpcForRet.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkMenuOpcForRet.getInternalname(), "TitleCaption", chkMenuOpcForRet.getCaption(), !bGXsfl_41_Refreshing);
      chkMenuOpcForRet.setCheckedValue( "false" );
      A2367MenuOpcForRet = GXutil.strtobool( GXutil.booltostr( A2367MenuOpcForRet)) ;
      /* End function init_web_controls */
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void valid_Perfilid( )
   {
      n1927MenuPais = false ;
      A1927MenuPais = (short)(GXutil.lval( dynMenuPais.getValue())) ;
      n1927MenuPais = false ;
      n1933MenuOpcPadre = false ;
      A1933MenuOpcPadre = dynMenuOpcPadre.getValue() ;
      n1933MenuOpcPadre = false ;
      n1935SVGId = false ;
      A1935SVGId = dynSVGId.getValue() ;
      n1935SVGId = false ;
      n1925PerfilId = false ;
      A1925PerfilId = (byte)(GXutil.lval( dynPerfilId.getValue())) ;
      n1925PerfilId = false ;
      /* Using cursor T005V41 */
      pr_default.execute(39, new Object[] {Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId)});
      if ( (pr_default.getStatus(39) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Perfil", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PERFILID");
         AnyError = (short)(1) ;
         GX_FocusControl = dynPerfilId.getInternalname() ;
      }
      pr_default.close(39);
      dynload_actions( ) ;
      if ( dynPerfilId.getItemCount() > 0 )
      {
         A1925PerfilId = (byte)(GXutil.lval( dynPerfilId.getValidValue(GXutil.trim( GXutil.str( A1925PerfilId, 2, 0))))) ;
         n1925PerfilId = false ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynPerfilId.setValue( GXutil.trim( GXutil.str( A1925PerfilId, 2, 0)) );
      }
      /*  Sending validation outputs */
   }

   public void valid_Rolid( )
   {
      n1923RolId = false ;
      n1927MenuPais = false ;
      A1927MenuPais = (short)(GXutil.lval( dynMenuPais.getValue())) ;
      n1927MenuPais = false ;
      n1933MenuOpcPadre = false ;
      A1933MenuOpcPadre = dynMenuOpcPadre.getValue() ;
      n1933MenuOpcPadre = false ;
      n1935SVGId = false ;
      A1935SVGId = dynSVGId.getValue() ;
      n1935SVGId = false ;
      n1925PerfilId = false ;
      A1925PerfilId = (byte)(GXutil.lval( dynPerfilId.getValue())) ;
      n1925PerfilId = false ;
      /* Using cursor T005V42 */
      pr_default.execute(40, new Object[] {Boolean.valueOf(n1923RolId), Byte.valueOf(A1923RolId)});
      if ( (pr_default.getStatus(40) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "RolUsuario", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ROLID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtRolId_Internalname ;
      }
      pr_default.close(40);
      dynload_actions( ) ;
      if ( dynPerfilId.getItemCount() > 0 )
      {
         A1925PerfilId = (byte)(GXutil.lval( dynPerfilId.getValidValue(GXutil.trim( GXutil.str( A1925PerfilId, 2, 0))))) ;
         n1925PerfilId = false ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynPerfilId.setValue( GXutil.trim( GXutil.str( A1925PerfilId, 2, 0)) );
      }
      /*  Sending validation outputs */
   }

   public void valid_Menupais( )
   {
      n1927MenuPais = false ;
      A1927MenuPais = (short)(GXutil.lval( dynMenuPais.getValue())) ;
      n1927MenuPais = false ;
      n1933MenuOpcPadre = false ;
      A1933MenuOpcPadre = dynMenuOpcPadre.getValue() ;
      n1933MenuOpcPadre = false ;
      n1935SVGId = false ;
      A1935SVGId = dynSVGId.getValue() ;
      n1935SVGId = false ;
      n1925PerfilId = false ;
      A1925PerfilId = (byte)(GXutil.lval( dynPerfilId.getValue())) ;
      n1925PerfilId = false ;
      /* Using cursor T005V43 */
      pr_default.execute(41, new Object[] {Boolean.valueOf(n1927MenuPais), Short.valueOf(A1927MenuPais)});
      if ( (pr_default.getStatus(41) == 101) )
      {
         if ( ! ( (0==A1927MenuPais) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais Menu", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MENUPAIS");
            AnyError = (short)(1) ;
            GX_FocusControl = dynMenuPais.getInternalname() ;
         }
      }
      pr_default.close(41);
      dynload_actions( ) ;
      if ( dynPerfilId.getItemCount() > 0 )
      {
         A1925PerfilId = (byte)(GXutil.lval( dynPerfilId.getValidValue(GXutil.trim( GXutil.str( A1925PerfilId, 2, 0))))) ;
         n1925PerfilId = false ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynPerfilId.setValue( GXutil.trim( GXutil.str( A1925PerfilId, 2, 0)) );
      }
      /*  Sending validation outputs */
   }

   public void valid_Menuopccod( )
   {
      n1923RolId = false ;
      n1928MenuVerId = false ;
      n1927MenuPais = false ;
      A1927MenuPais = (short)(GXutil.lval( dynMenuPais.getValue())) ;
      n1927MenuPais = false ;
      n1933MenuOpcPadre = false ;
      A1933MenuOpcPadre = dynMenuOpcPadre.getValue() ;
      n1933MenuOpcPadre = false ;
      n1935SVGId = false ;
      A1935SVGId = dynSVGId.getValue() ;
      n1935SVGId = false ;
      n1925PerfilId = false ;
      A1925PerfilId = (byte)(GXutil.lval( dynPerfilId.getValue())) ;
      n1925PerfilId = false ;
      GXt_char4 = A2362MenuOpcHormiga ;
      GXv_char10[0] = "" ;
      GXv_char9[0] = "" ;
      GXv_char8[0] = "" ;
      GXv_char7[0] = GXt_char4 ;
      new web.gethtmlnewbreadcrumb(remoteHandle, context).execute( A1929MenuOpcCod, A1923RolId, A1925PerfilId, A1928MenuVerId, GXv_char10, GXv_char9, GXv_char8, GXv_char7) ;
      menuversiones_impl.this.GXt_char4 = GXv_char7[0] ;
      A2362MenuOpcHormiga = GXt_char4 ;
      dynload_actions( ) ;
      if ( dynPerfilId.getItemCount() > 0 )
      {
         A1925PerfilId = (byte)(GXutil.lval( dynPerfilId.getValidValue(GXutil.trim( GXutil.str( A1925PerfilId, 2, 0))))) ;
         n1925PerfilId = false ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynPerfilId.setValue( GXutil.trim( GXutil.str( A1925PerfilId, 2, 0)) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A2362MenuOpcHormiga", A2362MenuOpcHormiga);
   }

   public void valid_Menuitemid( )
   {
      n1927MenuPais = false ;
      A1927MenuPais = (short)(GXutil.lval( dynMenuPais.getValue())) ;
      n1927MenuPais = false ;
      n1933MenuOpcPadre = false ;
      A1933MenuOpcPadre = dynMenuOpcPadre.getValue() ;
      n1933MenuOpcPadre = false ;
      n1935SVGId = false ;
      A1935SVGId = dynSVGId.getValue() ;
      n1935SVGId = false ;
      n1925PerfilId = false ;
      A1925PerfilId = (byte)(GXutil.lval( dynPerfilId.getValue())) ;
      n1925PerfilId = false ;
      /* Using cursor T005V33 */
      pr_default.execute(31, new Object[] {Boolean.valueOf(n1925PerfilId), Byte.valueOf(A1925PerfilId), A1937MenuItemId});
      if ( (pr_default.getStatus(31) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "MenuItem", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MENUITEMID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMenuItemId_Internalname ;
      }
      A1939MenuItemTitulo = T005V33_A1939MenuItemTitulo[0] ;
      pr_default.close(31);
      if ( isIns( )  && (GXutil.strcmp("", A1931MenuOpcTitulo)==0) && ( Gx_BScreen == 0 ) )
      {
         A1931MenuOpcTitulo = A1939MenuItemTitulo ;
      }
      GXv_char10[0] = "" ;
      GXv_char9[0] = AV20MItemIcoSVG ;
      GXv_char8[0] = AV21MitemIcoImg ;
      GXv_char7[0] = AV22MItemBienImgDef ;
      GXv_char6[0] = AV23MItemBienTitDef ;
      GXv_char5[0] = AV24MItemBienTextDef ;
      new web.getmenuitempredeterminados(remoteHandle, context).execute( A1925PerfilId, A1937MenuItemId, GXv_char10, GXv_char9, GXv_char8, GXv_char7, GXv_char6, GXv_char5) ;
      menuversiones_impl.this.AV20MItemIcoSVG = GXv_char9[0] ;
      AV20MItemIcoSVG = this.AV20MItemIcoSVG ;
      menuversiones_impl.this.AV21MitemIcoImg = GXv_char8[0] ;
      AV21MitemIcoImg = this.AV21MitemIcoImg ;
      menuversiones_impl.this.AV22MItemBienImgDef = GXv_char7[0] ;
      AV22MItemBienImgDef = this.AV22MItemBienImgDef ;
      menuversiones_impl.this.AV23MItemBienTitDef = GXv_char6[0] ;
      AV23MItemBienTitDef = this.AV23MItemBienTitDef ;
      menuversiones_impl.this.AV24MItemBienTextDef = GXv_char5[0] ;
      AV24MItemBienTextDef = this.AV24MItemBienTextDef ;
      if ( isIns( )  && (GXutil.strcmp("", A1935SVGId)==0) && ( Gx_BScreen == 0 ) )
      {
         A1935SVGId = AV20MItemIcoSVG ;
         n1935SVGId = false ;
      }
      if ( isIns( )  && (GXutil.strcmp("", A1941MenuItemImg)==0) && ( Gx_BScreen == 0 ) )
      {
         A1941MenuItemImg = AV21MitemIcoImg ;
      }
      if ( isIns( )  && (GXutil.strcmp("", A1946MenuBienveImg)==0) && ( Gx_BScreen == 0 ) )
      {
         A1946MenuBienveImg = AV22MItemBienImgDef ;
      }
      if ( isIns( )  && (GXutil.strcmp("", A1949MenuBienveTitulo)==0) && ( Gx_BScreen == 0 ) )
      {
         A1949MenuBienveTitulo = AV23MItemBienTitDef ;
      }
      if ( isIns( )  && (GXutil.strcmp("", A1950MenuBienveTexto)==0) && ( Gx_BScreen == 0 ) )
      {
         A1950MenuBienveTexto = AV24MItemBienTextDef ;
      }
      dynload_actions( ) ;
      if ( dynPerfilId.getItemCount() > 0 )
      {
         A1925PerfilId = (byte)(GXutil.lval( dynPerfilId.getValidValue(GXutil.trim( GXutil.str( A1925PerfilId, 2, 0))))) ;
         n1925PerfilId = false ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynPerfilId.setValue( GXutil.trim( GXutil.str( A1925PerfilId, 2, 0)) );
      }
      if ( dynSVGId.getItemCount() > 0 )
      {
         A1935SVGId = dynSVGId.getValidValue(A1935SVGId) ;
         n1935SVGId = false ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynSVGId.setValue( GXutil.rtrim( A1935SVGId) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1939MenuItemTitulo", A1939MenuItemTitulo);
      httpContext.ajax_rsp_assign_attri("", false, "A1931MenuOpcTitulo", A1931MenuOpcTitulo);
      httpContext.ajax_rsp_assign_attri("", false, "A1935SVGId", GXutil.rtrim( A1935SVGId));
      dynSVGId.setValue( GXutil.rtrim( A1935SVGId) );
      httpContext.ajax_rsp_assign_prop("", false, dynSVGId.getInternalname(), "Values", dynSVGId.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A1941MenuItemImg", httpContext.getResourceRelative(A1941MenuItemImg));
      httpContext.ajax_rsp_assign_attri("", false, "A1946MenuBienveImg", httpContext.getResourceRelative(A1946MenuBienveImg));
      httpContext.ajax_rsp_assign_attri("", false, "A1949MenuBienveTitulo", A1949MenuBienveTitulo);
      httpContext.ajax_rsp_assign_attri("", false, "A1950MenuBienveTexto", A1950MenuBienveTexto);
      httpContext.ajax_rsp_assign_attri("", false, "AV20MItemIcoSVG", GXutil.rtrim( AV20MItemIcoSVG));
      httpContext.ajax_rsp_assign_attri("", false, "AV21MitemIcoImg", httpContext.getResourceRelative(AV21MitemIcoImg));
      httpContext.ajax_rsp_assign_attri("", false, "AV22MItemBienImgDef", httpContext.getResourceRelative(AV22MItemBienImgDef));
      httpContext.ajax_rsp_assign_attri("", false, "AV23MItemBienTitDef", AV23MItemBienTitDef);
      httpContext.ajax_rsp_assign_attri("", false, "AV24MItemBienTextDef", AV24MItemBienTextDef);
   }

   public void valid_Svgid( )
   {
      n1927MenuPais = false ;
      A1927MenuPais = (short)(GXutil.lval( dynMenuPais.getValue())) ;
      n1927MenuPais = false ;
      n1933MenuOpcPadre = false ;
      A1933MenuOpcPadre = dynMenuOpcPadre.getValue() ;
      n1933MenuOpcPadre = false ;
      n1935SVGId = false ;
      A1935SVGId = dynSVGId.getValue() ;
      n1935SVGId = false ;
      n1925PerfilId = false ;
      A1925PerfilId = (byte)(GXutil.lval( dynPerfilId.getValue())) ;
      n1925PerfilId = false ;
      /* Using cursor T005V44 */
      pr_default.execute(42, new Object[] {Boolean.valueOf(n1935SVGId), A1935SVGId});
      if ( (pr_default.getStatus(42) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A1935SVGId)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "SVG", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SVGID");
            AnyError = (short)(1) ;
            GX_FocusControl = dynSVGId.getInternalname() ;
         }
      }
      pr_default.close(42);
      dynload_actions( ) ;
      if ( dynPerfilId.getItemCount() > 0 )
      {
         A1925PerfilId = (byte)(GXutil.lval( dynPerfilId.getValidValue(GXutil.trim( GXutil.str( A1925PerfilId, 2, 0))))) ;
         n1925PerfilId = false ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynPerfilId.setValue( GXutil.trim( GXutil.str( A1925PerfilId, 2, 0)) );
      }
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7RolId',fld:'vROLID',pic:'Z9',hsh:true},{av:'AV8PerfilId',fld:'vPERFILID',pic:'Z9',hsh:true},{av:'AV9MenuVerId',fld:'vMENUVERID',pic:'ZZZZZZZZZZZZZZ9',hsh:true},{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]");
      setEventMetadata("ENTER",",oparms:[{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7RolId',fld:'vROLID',pic:'Z9',hsh:true},{av:'AV8PerfilId',fld:'vPERFILID',pic:'Z9',hsh:true},{av:'AV9MenuVerId',fld:'vMENUVERID',pic:'ZZZZZZZZZZZZZZ9',hsh:true},{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]}");
      setEventMetadata("AFTER TRN","{handler:'e125V2',iparms:[{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]}");
      setEventMetadata("VALID_PERFILID","{handler:'valid_Perfilid',iparms:[{av:'dynMenuOpcPadre'},{av:'A1933MenuOpcPadre',fld:'MENUOPCPADRE',pic:''},{av:'dynSVGId'},{av:'A1935SVGId',fld:'SVGID',pic:''},{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]");
      setEventMetadata("VALID_PERFILID",",oparms:[{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]}");
      setEventMetadata("VALID_MENUVERID","{handler:'valid_Menuverid',iparms:[{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]");
      setEventMetadata("VALID_MENUVERID",",oparms:[{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]}");
      setEventMetadata("VALID_MENUPAIS","{handler:'valid_Menupais',iparms:[{av:'dynMenuOpcPadre'},{av:'A1933MenuOpcPadre',fld:'MENUOPCPADRE',pic:''},{av:'dynSVGId'},{av:'A1935SVGId',fld:'SVGID',pic:''},{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]");
      setEventMetadata("VALID_MENUPAIS",",oparms:[{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]}");
      setEventMetadata("VALID_ROLID","{handler:'valid_Rolid',iparms:[{av:'A1923RolId',fld:'ROLID',pic:'Z9'},{av:'dynMenuOpcPadre'},{av:'A1933MenuOpcPadre',fld:'MENUOPCPADRE',pic:''},{av:'dynSVGId'},{av:'A1935SVGId',fld:'SVGID',pic:''},{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]");
      setEventMetadata("VALID_ROLID",",oparms:[{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]}");
      setEventMetadata("VALID_MENUOPCCOD","{handler:'valid_Menuopccod',iparms:[{av:'A1929MenuOpcCod',fld:'MENUOPCCOD',pic:''},{av:'A1923RolId',fld:'ROLID',pic:'Z9'},{av:'A1928MenuVerId',fld:'MENUVERID',pic:'ZZZZZZZZZZZZZZ9'},{av:'dynMenuOpcPadre'},{av:'A1933MenuOpcPadre',fld:'MENUOPCPADRE',pic:''},{av:'dynSVGId'},{av:'A1935SVGId',fld:'SVGID',pic:''},{av:'A2362MenuOpcHormiga',fld:'MENUOPCHORMIGA',pic:''},{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]");
      setEventMetadata("VALID_MENUOPCCOD",",oparms:[{av:'A2362MenuOpcHormiga',fld:'MENUOPCHORMIGA',pic:''},{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]}");
      setEventMetadata("VALID_MENUITEMID","{handler:'valid_Menuitemid',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'A1937MenuItemId',fld:'MENUITEMID',pic:''},{av:'A1939MenuItemTitulo',fld:'MENUITEMTITULO',pic:''},{av:'Gx_BScreen',fld:'vGXBSCREEN',pic:'9'},{av:'AV20MItemIcoSVG',fld:'vMITEMICOSVG',pic:''},{av:'AV21MitemIcoImg',fld:'vMITEMICOIMG',pic:''},{av:'AV22MItemBienImgDef',fld:'vMITEMBIENIMGDEF',pic:''},{av:'AV23MItemBienTitDef',fld:'vMITEMBIENTITDEF',pic:''},{av:'AV24MItemBienTextDef',fld:'vMITEMBIENTEXTDEF',pic:''},{av:'dynMenuOpcPadre'},{av:'A1933MenuOpcPadre',fld:'MENUOPCPADRE',pic:''},{av:'dynSVGId'},{av:'A1935SVGId',fld:'SVGID',pic:''},{av:'A1931MenuOpcTitulo',fld:'MENUOPCTITULO',pic:''},{av:'A1941MenuItemImg',fld:'MENUITEMIMG',pic:''},{av:'A1946MenuBienveImg',fld:'MENUBIENVEIMG',pic:''},{av:'A1949MenuBienveTitulo',fld:'MENUBIENVETITULO',pic:''},{av:'A1950MenuBienveTexto',fld:'MENUBIENVETEXTO',pic:''},{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]");
      setEventMetadata("VALID_MENUITEMID",",oparms:[{av:'A1939MenuItemTitulo',fld:'MENUITEMTITULO',pic:''},{av:'A1931MenuOpcTitulo',fld:'MENUOPCTITULO',pic:''},{av:'dynSVGId'},{av:'A1935SVGId',fld:'SVGID',pic:''},{av:'A1941MenuItemImg',fld:'MENUITEMIMG',pic:''},{av:'A1946MenuBienveImg',fld:'MENUBIENVEIMG',pic:''},{av:'A1949MenuBienveTitulo',fld:'MENUBIENVETITULO',pic:''},{av:'A1950MenuBienveTexto',fld:'MENUBIENVETEXTO',pic:''},{av:'AV20MItemIcoSVG',fld:'vMITEMICOSVG',pic:''},{av:'AV21MitemIcoImg',fld:'vMITEMICOIMG',pic:''},{av:'AV22MItemBienImgDef',fld:'vMITEMBIENIMGDEF',pic:''},{av:'AV23MItemBienTitDef',fld:'vMITEMBIENTITDEF',pic:''},{av:'AV24MItemBienTextDef',fld:'vMITEMBIENTEXTDEF',pic:''},{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]}");
      setEventMetadata("VALID_SVGID","{handler:'valid_Svgid',iparms:[{av:'dynMenuOpcPadre'},{av:'A1933MenuOpcPadre',fld:'MENUOPCPADRE',pic:''},{av:'dynSVGId'},{av:'A1935SVGId',fld:'SVGID',pic:''},{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]");
      setEventMetadata("VALID_SVGID",",oparms:[{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]}");
      setEventMetadata("NULL","{handler:'valid_Menuopcforret',iparms:[{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]");
      setEventMetadata("NULL",",oparms:[{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]}");
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
      pr_default.close(42);
      pr_default.close(31);
      pr_default.close(40);
      pr_default.close(39);
      pr_default.close(41);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z1929MenuOpcCod = "" ;
      Z1931MenuOpcTitulo = "" ;
      Z1933MenuOpcPadre = "" ;
      Z1949MenuBienveTitulo = "" ;
      Z2361MenuOpcObj = "" ;
      Z1935SVGId = "" ;
      Z1937MenuItemId = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A1937MenuItemId = "" ;
      A1929MenuOpcCod = "" ;
      A1935SVGId = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      Gridlevel_opcionesContainer = new com.genexus.webpanels.GXWebGrid(context);
      sMode256 = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV31Pgmname = "" ;
      A2362MenuOpcHormiga = "" ;
      A1939MenuItemTitulo = "" ;
      AV21MitemIcoImg = "" ;
      AV22MItemBienImgDef = "" ;
      AV23MItemBienTitDef = "" ;
      AV24MItemBienTextDef = "" ;
      AV20MItemIcoSVG = "" ;
      A2361MenuOpcObj = "" ;
      A1942MenuItemImgExt = "" ;
      A1947MenuBienveImgExt = "" ;
      A1943MenuItemImgNom = "" ;
      A1948MenuBienveImgNom = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode255 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A1931MenuOpcTitulo = "" ;
      A1933MenuOpcPadre = "" ;
      A1941MenuItemImg = "" ;
      A1949MenuBienveTitulo = "" ;
      A1950MenuBienveTexto = "" ;
      A1946MenuBienveImg = "" ;
      AV10WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV13TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV14WebSession = httpContext.getWebSession();
      AV16TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      T005V11_A1928MenuVerId = new long[1] ;
      T005V11_n1928MenuVerId = new boolean[] {false} ;
      T005V11_A1923RolId = new byte[1] ;
      T005V11_n1923RolId = new boolean[] {false} ;
      T005V11_A1925PerfilId = new byte[1] ;
      T005V11_n1925PerfilId = new boolean[] {false} ;
      T005V11_A1927MenuPais = new short[1] ;
      T005V11_n1927MenuPais = new boolean[] {false} ;
      T005V8_A1923RolId = new byte[1] ;
      T005V8_n1923RolId = new boolean[] {false} ;
      T005V9_A1925PerfilId = new byte[1] ;
      T005V9_n1925PerfilId = new boolean[] {false} ;
      T005V10_A1927MenuPais = new short[1] ;
      T005V10_n1927MenuPais = new boolean[] {false} ;
      T005V12_A1923RolId = new byte[1] ;
      T005V12_n1923RolId = new boolean[] {false} ;
      T005V13_A1925PerfilId = new byte[1] ;
      T005V13_n1925PerfilId = new boolean[] {false} ;
      T005V14_A1927MenuPais = new short[1] ;
      T005V14_n1927MenuPais = new boolean[] {false} ;
      T005V15_A1923RolId = new byte[1] ;
      T005V15_n1923RolId = new boolean[] {false} ;
      T005V15_A1925PerfilId = new byte[1] ;
      T005V15_n1925PerfilId = new boolean[] {false} ;
      T005V15_A1928MenuVerId = new long[1] ;
      T005V15_n1928MenuVerId = new boolean[] {false} ;
      T005V7_A1928MenuVerId = new long[1] ;
      T005V7_n1928MenuVerId = new boolean[] {false} ;
      T005V7_A1923RolId = new byte[1] ;
      T005V7_n1923RolId = new boolean[] {false} ;
      T005V7_A1925PerfilId = new byte[1] ;
      T005V7_n1925PerfilId = new boolean[] {false} ;
      T005V7_A1927MenuPais = new short[1] ;
      T005V7_n1927MenuPais = new boolean[] {false} ;
      T005V16_A1923RolId = new byte[1] ;
      T005V16_n1923RolId = new boolean[] {false} ;
      T005V16_A1925PerfilId = new byte[1] ;
      T005V16_n1925PerfilId = new boolean[] {false} ;
      T005V16_A1928MenuVerId = new long[1] ;
      T005V16_n1928MenuVerId = new boolean[] {false} ;
      T005V17_A1923RolId = new byte[1] ;
      T005V17_n1923RolId = new boolean[] {false} ;
      T005V17_A1925PerfilId = new byte[1] ;
      T005V17_n1925PerfilId = new boolean[] {false} ;
      T005V17_A1928MenuVerId = new long[1] ;
      T005V17_n1928MenuVerId = new boolean[] {false} ;
      T005V6_A1928MenuVerId = new long[1] ;
      T005V6_n1928MenuVerId = new boolean[] {false} ;
      T005V6_A1923RolId = new byte[1] ;
      T005V6_n1923RolId = new boolean[] {false} ;
      T005V6_A1925PerfilId = new byte[1] ;
      T005V6_n1925PerfilId = new boolean[] {false} ;
      T005V6_A1927MenuPais = new short[1] ;
      T005V6_n1927MenuPais = new boolean[] {false} ;
      T005V21_A67SecUserId = new short[1] ;
      T005V22_A1923RolId = new byte[1] ;
      T005V22_n1923RolId = new boolean[] {false} ;
      T005V22_A1925PerfilId = new byte[1] ;
      T005V22_n1925PerfilId = new boolean[] {false} ;
      T005V22_A1928MenuVerId = new long[1] ;
      T005V22_n1928MenuVerId = new boolean[] {false} ;
      T005V22_A1929MenuOpcCod = new String[] {""} ;
      T005V22_A2365MenuOpcAcc = new String[] {""} ;
      T005V23_A1923RolId = new byte[1] ;
      T005V23_n1923RolId = new boolean[] {false} ;
      T005V23_A1925PerfilId = new byte[1] ;
      T005V23_n1925PerfilId = new boolean[] {false} ;
      T005V23_A1928MenuVerId = new long[1] ;
      T005V23_n1928MenuVerId = new boolean[] {false} ;
      Z1941MenuItemImg = "" ;
      Z1946MenuBienveImg = "" ;
      Z1950MenuBienveTexto = "" ;
      Z1942MenuItemImgExt = "" ;
      Z1947MenuBienveImgExt = "" ;
      Z1943MenuItemImgNom = "" ;
      Z1948MenuBienveImgNom = "" ;
      Z1939MenuItemTitulo = "" ;
      T005V24_A1923RolId = new byte[1] ;
      T005V24_n1923RolId = new boolean[] {false} ;
      T005V24_A1928MenuVerId = new long[1] ;
      T005V24_n1928MenuVerId = new boolean[] {false} ;
      T005V24_A1929MenuOpcCod = new String[] {""} ;
      T005V24_A1931MenuOpcTitulo = new String[] {""} ;
      T005V24_A1951MenuBienveVisible = new boolean[] {false} ;
      T005V24_A1933MenuOpcPadre = new String[] {""} ;
      T005V24_n1933MenuOpcPadre = new boolean[] {false} ;
      T005V24_A1934MenuHomeEs = new boolean[] {false} ;
      T005V24_A1940MenuItemOrd = new byte[1] ;
      T005V24_A1941MenuItemImg = new String[] {""} ;
      T005V24_A1939MenuItemTitulo = new String[] {""} ;
      T005V24_A1946MenuBienveImg = new String[] {""} ;
      T005V24_A1949MenuBienveTitulo = new String[] {""} ;
      T005V24_A1950MenuBienveTexto = new String[] {""} ;
      T005V24_A2361MenuOpcObj = new String[] {""} ;
      T005V24_A2363MenuOpcInst = new boolean[] {false} ;
      T005V24_A2367MenuOpcForRet = new boolean[] {false} ;
      T005V24_A1942MenuItemImgExt = new String[] {""} ;
      T005V24_A1947MenuBienveImgExt = new String[] {""} ;
      T005V24_A1943MenuItemImgNom = new String[] {""} ;
      T005V24_A1948MenuBienveImgNom = new String[] {""} ;
      T005V24_A1935SVGId = new String[] {""} ;
      T005V24_n1935SVGId = new boolean[] {false} ;
      T005V24_A1925PerfilId = new byte[1] ;
      T005V24_n1925PerfilId = new boolean[] {false} ;
      T005V24_A1937MenuItemId = new String[] {""} ;
      T005V5_A1939MenuItemTitulo = new String[] {""} ;
      T005V4_A1935SVGId = new String[] {""} ;
      T005V4_n1935SVGId = new boolean[] {false} ;
      T005V25_A1939MenuItemTitulo = new String[] {""} ;
      T005V26_A1935SVGId = new String[] {""} ;
      T005V26_n1935SVGId = new boolean[] {false} ;
      T005V27_A1923RolId = new byte[1] ;
      T005V27_n1923RolId = new boolean[] {false} ;
      T005V27_A1925PerfilId = new byte[1] ;
      T005V27_n1925PerfilId = new boolean[] {false} ;
      T005V27_A1928MenuVerId = new long[1] ;
      T005V27_n1928MenuVerId = new boolean[] {false} ;
      T005V27_A1929MenuOpcCod = new String[] {""} ;
      T005V3_A1923RolId = new byte[1] ;
      T005V3_n1923RolId = new boolean[] {false} ;
      T005V3_A1928MenuVerId = new long[1] ;
      T005V3_n1928MenuVerId = new boolean[] {false} ;
      T005V3_A1929MenuOpcCod = new String[] {""} ;
      T005V3_A1931MenuOpcTitulo = new String[] {""} ;
      T005V3_A1951MenuBienveVisible = new boolean[] {false} ;
      T005V3_A1933MenuOpcPadre = new String[] {""} ;
      T005V3_n1933MenuOpcPadre = new boolean[] {false} ;
      T005V3_A1934MenuHomeEs = new boolean[] {false} ;
      T005V3_A1940MenuItemOrd = new byte[1] ;
      T005V3_A1941MenuItemImg = new String[] {""} ;
      T005V3_A1946MenuBienveImg = new String[] {""} ;
      T005V3_A1949MenuBienveTitulo = new String[] {""} ;
      T005V3_A1950MenuBienveTexto = new String[] {""} ;
      T005V3_A2361MenuOpcObj = new String[] {""} ;
      T005V3_A2363MenuOpcInst = new boolean[] {false} ;
      T005V3_A2367MenuOpcForRet = new boolean[] {false} ;
      T005V3_A1942MenuItemImgExt = new String[] {""} ;
      T005V3_A1947MenuBienveImgExt = new String[] {""} ;
      T005V3_A1943MenuItemImgNom = new String[] {""} ;
      T005V3_A1948MenuBienveImgNom = new String[] {""} ;
      T005V3_A1935SVGId = new String[] {""} ;
      T005V3_n1935SVGId = new boolean[] {false} ;
      T005V3_A1925PerfilId = new byte[1] ;
      T005V3_n1925PerfilId = new boolean[] {false} ;
      T005V3_A1937MenuItemId = new String[] {""} ;
      T005V2_A1923RolId = new byte[1] ;
      T005V2_n1923RolId = new boolean[] {false} ;
      T005V2_A1928MenuVerId = new long[1] ;
      T005V2_n1928MenuVerId = new boolean[] {false} ;
      T005V2_A1929MenuOpcCod = new String[] {""} ;
      T005V2_A1931MenuOpcTitulo = new String[] {""} ;
      T005V2_A1951MenuBienveVisible = new boolean[] {false} ;
      T005V2_A1933MenuOpcPadre = new String[] {""} ;
      T005V2_n1933MenuOpcPadre = new boolean[] {false} ;
      T005V2_A1934MenuHomeEs = new boolean[] {false} ;
      T005V2_A1940MenuItemOrd = new byte[1] ;
      T005V2_A1941MenuItemImg = new String[] {""} ;
      T005V2_A1946MenuBienveImg = new String[] {""} ;
      T005V2_A1949MenuBienveTitulo = new String[] {""} ;
      T005V2_A1950MenuBienveTexto = new String[] {""} ;
      T005V2_A2361MenuOpcObj = new String[] {""} ;
      T005V2_A2363MenuOpcInst = new boolean[] {false} ;
      T005V2_A2367MenuOpcForRet = new boolean[] {false} ;
      T005V2_A1942MenuItemImgExt = new String[] {""} ;
      T005V2_A1947MenuBienveImgExt = new String[] {""} ;
      T005V2_A1943MenuItemImgNom = new String[] {""} ;
      T005V2_A1948MenuBienveImgNom = new String[] {""} ;
      T005V2_A1935SVGId = new String[] {""} ;
      T005V2_n1935SVGId = new boolean[] {false} ;
      T005V2_A1925PerfilId = new byte[1] ;
      T005V2_n1925PerfilId = new boolean[] {false} ;
      T005V2_A1937MenuItemId = new String[] {""} ;
      T005V33_A1939MenuItemTitulo = new String[] {""} ;
      T005V34_A1923RolId = new byte[1] ;
      T005V34_n1923RolId = new boolean[] {false} ;
      T005V34_A1925PerfilId = new byte[1] ;
      T005V34_n1925PerfilId = new boolean[] {false} ;
      T005V34_A1928MenuVerId = new long[1] ;
      T005V34_n1928MenuVerId = new boolean[] {false} ;
      T005V34_A1929MenuOpcCod = new String[] {""} ;
      T005V34_A2365MenuOpcAcc = new String[] {""} ;
      T005V35_A1923RolId = new byte[1] ;
      T005V35_n1923RolId = new boolean[] {false} ;
      T005V35_A1925PerfilId = new byte[1] ;
      T005V35_n1925PerfilId = new boolean[] {false} ;
      T005V35_A1928MenuVerId = new long[1] ;
      T005V35_n1928MenuVerId = new boolean[] {false} ;
      T005V35_A1929MenuOpcCod = new String[] {""} ;
      Gridlevel_opcionesRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_opciones_Linesclass = "" ;
      ROClassString = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      GXCCtlgxBlob = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridlevel_opcionesColumn = new com.genexus.webpanels.GXWebColumn();
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T005V36_A1925PerfilId = new byte[1] ;
      T005V36_n1925PerfilId = new boolean[] {false} ;
      T005V36_A1926PerfilNombre = new String[] {""} ;
      T005V37_A1927MenuPais = new short[1] ;
      T005V37_n1927MenuPais = new boolean[] {false} ;
      T005V37_A312PaiNom = new String[] {""} ;
      T005V37_n312PaiNom = new boolean[] {false} ;
      T005V38_A1923RolId = new byte[1] ;
      T005V38_n1923RolId = new boolean[] {false} ;
      T005V38_A1925PerfilId = new byte[1] ;
      T005V38_n1925PerfilId = new boolean[] {false} ;
      T005V38_A1928MenuVerId = new long[1] ;
      T005V38_n1928MenuVerId = new boolean[] {false} ;
      T005V38_A1929MenuOpcCod = new String[] {""} ;
      T005V39_A1935SVGId = new String[] {""} ;
      T005V39_n1935SVGId = new boolean[] {false} ;
      T005V40_A1925PerfilId = new byte[1] ;
      T005V40_n1925PerfilId = new boolean[] {false} ;
      T005V40_A1926PerfilNombre = new String[] {""} ;
      T005V41_A1925PerfilId = new byte[1] ;
      T005V41_n1925PerfilId = new boolean[] {false} ;
      T005V42_A1923RolId = new byte[1] ;
      T005V42_n1923RolId = new boolean[] {false} ;
      T005V43_A1927MenuPais = new short[1] ;
      T005V43_n1927MenuPais = new boolean[] {false} ;
      GXt_char4 = "" ;
      Z2362MenuOpcHormiga = "" ;
      GXv_char10 = new String[1] ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      GXv_char6 = new String[1] ;
      GXv_char5 = new String[1] ;
      ZV20MItemIcoSVG = "" ;
      ZV21MitemIcoImg = "" ;
      ZV22MItemBienImgDef = "" ;
      ZV23MItemBienTitDef = "" ;
      ZV24MItemBienTextDef = "" ;
      T005V44_A1935SVGId = new String[] {""} ;
      T005V44_n1935SVGId = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.menuversiones__default(),
         new Object[] {
             new Object[] {
            T005V2_A1923RolId, T005V2_A1928MenuVerId, T005V2_A1929MenuOpcCod, T005V2_A1931MenuOpcTitulo, T005V2_A1951MenuBienveVisible, T005V2_A1933MenuOpcPadre, T005V2_n1933MenuOpcPadre, T005V2_A1934MenuHomeEs, T005V2_A1940MenuItemOrd, T005V2_A1941MenuItemImg,
            T005V2_A1946MenuBienveImg, T005V2_A1949MenuBienveTitulo, T005V2_A1950MenuBienveTexto, T005V2_A2361MenuOpcObj, T005V2_A2363MenuOpcInst, T005V2_A2367MenuOpcForRet, T005V2_A1942MenuItemImgExt, T005V2_A1947MenuBienveImgExt, T005V2_A1943MenuItemImgNom, T005V2_A1948MenuBienveImgNom,
            T005V2_A1935SVGId, T005V2_n1935SVGId, T005V2_A1925PerfilId, T005V2_A1937MenuItemId
            }
            , new Object[] {
            T005V3_A1923RolId, T005V3_A1928MenuVerId, T005V3_A1929MenuOpcCod, T005V3_A1931MenuOpcTitulo, T005V3_A1951MenuBienveVisible, T005V3_A1933MenuOpcPadre, T005V3_n1933MenuOpcPadre, T005V3_A1934MenuHomeEs, T005V3_A1940MenuItemOrd, T005V3_A1941MenuItemImg,
            T005V3_A1946MenuBienveImg, T005V3_A1949MenuBienveTitulo, T005V3_A1950MenuBienveTexto, T005V3_A2361MenuOpcObj, T005V3_A2363MenuOpcInst, T005V3_A2367MenuOpcForRet, T005V3_A1942MenuItemImgExt, T005V3_A1947MenuBienveImgExt, T005V3_A1943MenuItemImgNom, T005V3_A1948MenuBienveImgNom,
            T005V3_A1935SVGId, T005V3_n1935SVGId, T005V3_A1925PerfilId, T005V3_A1937MenuItemId
            }
            , new Object[] {
            T005V4_A1935SVGId
            }
            , new Object[] {
            T005V5_A1939MenuItemTitulo
            }
            , new Object[] {
            T005V6_A1928MenuVerId, T005V6_A1923RolId, T005V6_A1925PerfilId, T005V6_A1927MenuPais, T005V6_n1927MenuPais
            }
            , new Object[] {
            T005V7_A1928MenuVerId, T005V7_A1923RolId, T005V7_A1925PerfilId, T005V7_A1927MenuPais, T005V7_n1927MenuPais
            }
            , new Object[] {
            T005V8_A1923RolId
            }
            , new Object[] {
            T005V9_A1925PerfilId
            }
            , new Object[] {
            T005V10_A1927MenuPais
            }
            , new Object[] {
            T005V11_A1928MenuVerId, T005V11_A1923RolId, T005V11_A1925PerfilId, T005V11_A1927MenuPais, T005V11_n1927MenuPais
            }
            , new Object[] {
            T005V12_A1923RolId
            }
            , new Object[] {
            T005V13_A1925PerfilId
            }
            , new Object[] {
            T005V14_A1927MenuPais
            }
            , new Object[] {
            T005V15_A1923RolId, T005V15_A1925PerfilId, T005V15_A1928MenuVerId
            }
            , new Object[] {
            T005V16_A1923RolId, T005V16_A1925PerfilId, T005V16_A1928MenuVerId
            }
            , new Object[] {
            T005V17_A1923RolId, T005V17_A1925PerfilId, T005V17_A1928MenuVerId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T005V21_A67SecUserId
            }
            , new Object[] {
            T005V22_A1923RolId, T005V22_A1925PerfilId, T005V22_A1928MenuVerId, T005V22_A1929MenuOpcCod, T005V22_A2365MenuOpcAcc
            }
            , new Object[] {
            T005V23_A1923RolId, T005V23_A1925PerfilId, T005V23_A1928MenuVerId
            }
            , new Object[] {
            T005V24_A1923RolId, T005V24_A1928MenuVerId, T005V24_A1929MenuOpcCod, T005V24_A1931MenuOpcTitulo, T005V24_A1951MenuBienveVisible, T005V24_A1933MenuOpcPadre, T005V24_n1933MenuOpcPadre, T005V24_A1934MenuHomeEs, T005V24_A1940MenuItemOrd, T005V24_A1941MenuItemImg,
            T005V24_A1939MenuItemTitulo, T005V24_A1946MenuBienveImg, T005V24_A1949MenuBienveTitulo, T005V24_A1950MenuBienveTexto, T005V24_A2361MenuOpcObj, T005V24_A2363MenuOpcInst, T005V24_A2367MenuOpcForRet, T005V24_A1942MenuItemImgExt, T005V24_A1947MenuBienveImgExt, T005V24_A1943MenuItemImgNom,
            T005V24_A1948MenuBienveImgNom, T005V24_A1935SVGId, T005V24_n1935SVGId, T005V24_A1925PerfilId, T005V24_A1937MenuItemId
            }
            , new Object[] {
            T005V25_A1939MenuItemTitulo
            }
            , new Object[] {
            T005V26_A1935SVGId
            }
            , new Object[] {
            T005V27_A1923RolId, T005V27_A1925PerfilId, T005V27_A1928MenuVerId, T005V27_A1929MenuOpcCod
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
            T005V33_A1939MenuItemTitulo
            }
            , new Object[] {
            T005V34_A1923RolId, T005V34_A1925PerfilId, T005V34_A1928MenuVerId, T005V34_A1929MenuOpcCod, T005V34_A2365MenuOpcAcc
            }
            , new Object[] {
            T005V35_A1923RolId, T005V35_A1925PerfilId, T005V35_A1928MenuVerId, T005V35_A1929MenuOpcCod
            }
            , new Object[] {
            T005V36_A1925PerfilId, T005V36_A1926PerfilNombre
            }
            , new Object[] {
            T005V37_A1927MenuPais, T005V37_A312PaiNom, T005V37_n312PaiNom
            }
            , new Object[] {
            T005V38_A1923RolId, T005V38_A1925PerfilId, T005V38_A1928MenuVerId, T005V38_A1929MenuOpcCod
            }
            , new Object[] {
            T005V39_A1935SVGId
            }
            , new Object[] {
            T005V40_A1925PerfilId, T005V40_A1926PerfilNombre
            }
            , new Object[] {
            T005V41_A1925PerfilId
            }
            , new Object[] {
            T005V42_A1923RolId
            }
            , new Object[] {
            T005V43_A1927MenuPais
            }
            , new Object[] {
            T005V44_A1935SVGId
            }
         }
      );
      AV31Pgmname = "MenuVersiones" ;
      Z1935SVGId = "" ;
      n1935SVGId = false ;
      A1935SVGId = "" ;
      n1935SVGId = false ;
      Z1951MenuBienveVisible = true ;
      A1951MenuBienveVisible = true ;
      i1951MenuBienveVisible = true ;
      A1950MenuBienveTexto = "" ;
      Z1950MenuBienveTexto = "" ;
      Z1949MenuBienveTitulo = "" ;
      A1949MenuBienveTitulo = "" ;
      A1946MenuBienveImg = "" ;
      Z1946MenuBienveImg = "" ;
      A1941MenuItemImg = "" ;
      Z1941MenuItemImg = "" ;
      Z1931MenuOpcTitulo = "" ;
      A1931MenuOpcTitulo = "" ;
      Z1923RolId = (byte)(1) ;
      n1923RolId = false ;
      A1923RolId = (byte)(1) ;
      n1923RolId = false ;
   }

   private byte wcpOAV7RolId ;
   private byte wcpOAV8PerfilId ;
   private byte Z1923RolId ;
   private byte Z1925PerfilId ;
   private byte Z1940MenuItemOrd ;
   private byte GxWebError ;
   private byte A1925PerfilId ;
   private byte A1923RolId ;
   private byte AV7RolId ;
   private byte AV8PerfilId ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte A1940MenuItemOrd ;
   private byte subGridlevel_opciones_Backcolorstyle ;
   private byte subGridlevel_opciones_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridlevel_opciones_Allowselection ;
   private byte subGridlevel_opciones_Allowhovering ;
   private byte subGridlevel_opciones_Allowcollapsing ;
   private byte subGridlevel_opciones_Collapsed ;
   private short Z1927MenuPais ;
   private short N1927MenuPais ;
   private short nRcdDeleted_256 ;
   private short nRcdExists_256 ;
   private short nIsMod_256 ;
   private short A1927MenuPais ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nBlankRcdCount256 ;
   private short RcdFound256 ;
   private short nBlankRcdUsr256 ;
   private short AV15Insert_MenuPais ;
   private short RcdFound255 ;
   private short nIsDirty_255 ;
   private short nIsDirty_256 ;
   private int nRC_GXsfl_41 ;
   private int nGXsfl_41_idx=1 ;
   private int trnEnded ;
   private int edtMenuVerId_Enabled ;
   private int edtMenuOpcCod_Enabled ;
   private int edtMenuItemId_Enabled ;
   private int edtMenuOpcTitulo_Enabled ;
   private int edtMenuItemImg_Enabled ;
   private int edtMenuItemOrd_Enabled ;
   private int edtMenuBienveTitulo_Enabled ;
   private int edtMenuBienveTexto_Enabled ;
   private int edtMenuBienveImg_Enabled ;
   private int fRowAdded ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtRolId_Visible ;
   private int edtRolId_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV32GXV1 ;
   private int GX_JID ;
   private int subGridlevel_opciones_Backcolor ;
   private int subGridlevel_opciones_Allbackcolor ;
   private int defedtMenuOpcCod_Enabled ;
   private int idxLst ;
   private int subGridlevel_opciones_Selectedindex ;
   private int subGridlevel_opciones_Selectioncolor ;
   private int subGridlevel_opciones_Hoveringcolor ;
   private int gxdynajaxindex ;
   private long wcpOAV9MenuVerId ;
   private long Z1928MenuVerId ;
   private long A1928MenuVerId ;
   private long AV9MenuVerId ;
   private long GRIDLEVEL_OPCIONES_nFirstRecordOnPage ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z1933MenuOpcPadre ;
   private String Z2361MenuOpcObj ;
   private String Z1935SVGId ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A1935SVGId ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String sGXsfl_41_idx="0001" ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String edtMenuVerId_Internalname ;
   private String edtMenuVerId_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String divTableleaflevel_opciones_Internalname ;
   private String sMode256 ;
   private String edtMenuOpcCod_Internalname ;
   private String edtMenuItemId_Internalname ;
   private String edtMenuOpcTitulo_Internalname ;
   private String edtMenuItemImg_Internalname ;
   private String edtMenuItemOrd_Internalname ;
   private String edtMenuBienveTitulo_Internalname ;
   private String edtMenuBienveTexto_Internalname ;
   private String edtMenuBienveImg_Internalname ;
   private String subGridlevel_opciones_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtRolId_Internalname ;
   private String edtRolId_Jsonclick ;
   private String AV31Pgmname ;
   private String AV20MItemIcoSVG ;
   private String A2361MenuOpcObj ;
   private String A1942MenuItemImgExt ;
   private String A1947MenuBienveImgExt ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode255 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String A1933MenuOpcPadre ;
   private String Z1942MenuItemImgExt ;
   private String Z1947MenuBienveImgExt ;
   private String edtMenuItemImg_Filetype ;
   private String edtMenuBienveImg_Filetype ;
   private String edtMenuItemImg_Filename ;
   private String edtMenuBienveImg_Filename ;
   private String sGXsfl_41_fel_idx="0001" ;
   private String subGridlevel_opciones_Class ;
   private String subGridlevel_opciones_Linesclass ;
   private String ROClassString ;
   private String edtMenuOpcCod_Jsonclick ;
   private String edtMenuItemId_Jsonclick ;
   private String edtMenuOpcTitulo_Jsonclick ;
   private String edtMenuItemImg_Contenttype ;
   private String edtMenuItemImg_Parameters ;
   private String edtMenuItemImg_Jsonclick ;
   private String edtMenuItemOrd_Jsonclick ;
   private String edtMenuBienveTitulo_Jsonclick ;
   private String edtMenuBienveTexto_Jsonclick ;
   private String edtMenuBienveImg_Contenttype ;
   private String edtMenuBienveImg_Parameters ;
   private String edtMenuBienveImg_Jsonclick ;
   private String GXCCtlgxBlob ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel_opciones_Header ;
   private String gxwrpcisep ;
   private String GXt_char4 ;
   private String GXv_char10[] ;
   private String GXv_char9[] ;
   private String GXv_char8[] ;
   private String GXv_char7[] ;
   private String GXv_char6[] ;
   private String GXv_char5[] ;
   private String ZV20MItemIcoSVG ;
   private boolean Z1951MenuBienveVisible ;
   private boolean Z1934MenuHomeEs ;
   private boolean Z2363MenuOpcInst ;
   private boolean Z2367MenuOpcForRet ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n1925PerfilId ;
   private boolean n1923RolId ;
   private boolean n1928MenuVerId ;
   private boolean n1927MenuPais ;
   private boolean n1935SVGId ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean bGXsfl_41_Refreshing=false ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean A1934MenuHomeEs ;
   private boolean A1951MenuBienveVisible ;
   private boolean A2363MenuOpcInst ;
   private boolean A2367MenuOpcForRet ;
   private boolean returnInSub ;
   private boolean AV11IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean n1933MenuOpcPadre ;
   private boolean Gx_longc ;
   private boolean i1951MenuBienveVisible ;
   private boolean gxdyncontrolsrefreshing ;
   private String AV24MItemBienTextDef ;
   private String A1950MenuBienveTexto ;
   private String Z1950MenuBienveTexto ;
   private String ZV24MItemBienTextDef ;
   private String AV21MitemIcoImg ;
   private String AV22MItemBienImgDef ;
   private String A1941MenuItemImg ;
   private String A1946MenuBienveImg ;
   private String Z1941MenuItemImg ;
   private String Z1946MenuBienveImg ;
   private String ZV21MitemIcoImg ;
   private String ZV22MItemBienImgDef ;
   private String Z1929MenuOpcCod ;
   private String Z1931MenuOpcTitulo ;
   private String Z1949MenuBienveTitulo ;
   private String Z1937MenuItemId ;
   private String A1937MenuItemId ;
   private String A1929MenuOpcCod ;
   private String A2362MenuOpcHormiga ;
   private String A1939MenuItemTitulo ;
   private String AV23MItemBienTitDef ;
   private String A1943MenuItemImgNom ;
   private String A1948MenuBienveImgNom ;
   private String A1931MenuOpcTitulo ;
   private String A1949MenuBienveTitulo ;
   private String Z1943MenuItemImgNom ;
   private String Z1948MenuBienveImgNom ;
   private String Z1939MenuItemTitulo ;
   private String Z2362MenuOpcHormiga ;
   private String ZV23MItemBienTitDef ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_opcionesContainer ;
   private com.genexus.webpanels.GXWebRow Gridlevel_opcionesRow ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_opcionesColumn ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynPerfilId ;
   private HTMLChoice dynMenuPais ;
   private HTMLChoice dynMenuOpcPadre ;
   private HTMLChoice dynSVGId ;
   private ICheckbox chkMenuHomeEs ;
   private ICheckbox chkMenuBienveVisible ;
   private ICheckbox chkMenuOpcInst ;
   private ICheckbox chkMenuOpcForRet ;
   private IDataStoreProvider pr_default ;
   private long[] T005V11_A1928MenuVerId ;
   private boolean[] T005V11_n1928MenuVerId ;
   private byte[] T005V11_A1923RolId ;
   private boolean[] T005V11_n1923RolId ;
   private byte[] T005V11_A1925PerfilId ;
   private boolean[] T005V11_n1925PerfilId ;
   private short[] T005V11_A1927MenuPais ;
   private boolean[] T005V11_n1927MenuPais ;
   private byte[] T005V8_A1923RolId ;
   private boolean[] T005V8_n1923RolId ;
   private byte[] T005V9_A1925PerfilId ;
   private boolean[] T005V9_n1925PerfilId ;
   private short[] T005V10_A1927MenuPais ;
   private boolean[] T005V10_n1927MenuPais ;
   private byte[] T005V12_A1923RolId ;
   private boolean[] T005V12_n1923RolId ;
   private byte[] T005V13_A1925PerfilId ;
   private boolean[] T005V13_n1925PerfilId ;
   private short[] T005V14_A1927MenuPais ;
   private boolean[] T005V14_n1927MenuPais ;
   private byte[] T005V15_A1923RolId ;
   private boolean[] T005V15_n1923RolId ;
   private byte[] T005V15_A1925PerfilId ;
   private boolean[] T005V15_n1925PerfilId ;
   private long[] T005V15_A1928MenuVerId ;
   private boolean[] T005V15_n1928MenuVerId ;
   private long[] T005V7_A1928MenuVerId ;
   private boolean[] T005V7_n1928MenuVerId ;
   private byte[] T005V7_A1923RolId ;
   private boolean[] T005V7_n1923RolId ;
   private byte[] T005V7_A1925PerfilId ;
   private boolean[] T005V7_n1925PerfilId ;
   private short[] T005V7_A1927MenuPais ;
   private boolean[] T005V7_n1927MenuPais ;
   private byte[] T005V16_A1923RolId ;
   private boolean[] T005V16_n1923RolId ;
   private byte[] T005V16_A1925PerfilId ;
   private boolean[] T005V16_n1925PerfilId ;
   private long[] T005V16_A1928MenuVerId ;
   private boolean[] T005V16_n1928MenuVerId ;
   private byte[] T005V17_A1923RolId ;
   private boolean[] T005V17_n1923RolId ;
   private byte[] T005V17_A1925PerfilId ;
   private boolean[] T005V17_n1925PerfilId ;
   private long[] T005V17_A1928MenuVerId ;
   private boolean[] T005V17_n1928MenuVerId ;
   private long[] T005V6_A1928MenuVerId ;
   private boolean[] T005V6_n1928MenuVerId ;
   private byte[] T005V6_A1923RolId ;
   private boolean[] T005V6_n1923RolId ;
   private byte[] T005V6_A1925PerfilId ;
   private boolean[] T005V6_n1925PerfilId ;
   private short[] T005V6_A1927MenuPais ;
   private boolean[] T005V6_n1927MenuPais ;
   private short[] T005V21_A67SecUserId ;
   private byte[] T005V22_A1923RolId ;
   private boolean[] T005V22_n1923RolId ;
   private byte[] T005V22_A1925PerfilId ;
   private boolean[] T005V22_n1925PerfilId ;
   private long[] T005V22_A1928MenuVerId ;
   private boolean[] T005V22_n1928MenuVerId ;
   private String[] T005V22_A1929MenuOpcCod ;
   private String[] T005V22_A2365MenuOpcAcc ;
   private byte[] T005V23_A1923RolId ;
   private boolean[] T005V23_n1923RolId ;
   private byte[] T005V23_A1925PerfilId ;
   private boolean[] T005V23_n1925PerfilId ;
   private long[] T005V23_A1928MenuVerId ;
   private boolean[] T005V23_n1928MenuVerId ;
   private byte[] T005V24_A1923RolId ;
   private boolean[] T005V24_n1923RolId ;
   private long[] T005V24_A1928MenuVerId ;
   private boolean[] T005V24_n1928MenuVerId ;
   private String[] T005V24_A1929MenuOpcCod ;
   private String[] T005V24_A1931MenuOpcTitulo ;
   private boolean[] T005V24_A1951MenuBienveVisible ;
   private String[] T005V24_A1933MenuOpcPadre ;
   private boolean[] T005V24_n1933MenuOpcPadre ;
   private boolean[] T005V24_A1934MenuHomeEs ;
   private byte[] T005V24_A1940MenuItemOrd ;
   private String[] T005V24_A1941MenuItemImg ;
   private String[] T005V24_A1939MenuItemTitulo ;
   private String[] T005V24_A1946MenuBienveImg ;
   private String[] T005V24_A1949MenuBienveTitulo ;
   private String[] T005V24_A1950MenuBienveTexto ;
   private String[] T005V24_A2361MenuOpcObj ;
   private boolean[] T005V24_A2363MenuOpcInst ;
   private boolean[] T005V24_A2367MenuOpcForRet ;
   private String[] T005V24_A1942MenuItemImgExt ;
   private String[] T005V24_A1947MenuBienveImgExt ;
   private String[] T005V24_A1943MenuItemImgNom ;
   private String[] T005V24_A1948MenuBienveImgNom ;
   private String[] T005V24_A1935SVGId ;
   private boolean[] T005V24_n1935SVGId ;
   private byte[] T005V24_A1925PerfilId ;
   private boolean[] T005V24_n1925PerfilId ;
   private String[] T005V24_A1937MenuItemId ;
   private String[] T005V5_A1939MenuItemTitulo ;
   private String[] T005V4_A1935SVGId ;
   private boolean[] T005V4_n1935SVGId ;
   private String[] T005V25_A1939MenuItemTitulo ;
   private String[] T005V26_A1935SVGId ;
   private boolean[] T005V26_n1935SVGId ;
   private byte[] T005V27_A1923RolId ;
   private boolean[] T005V27_n1923RolId ;
   private byte[] T005V27_A1925PerfilId ;
   private boolean[] T005V27_n1925PerfilId ;
   private long[] T005V27_A1928MenuVerId ;
   private boolean[] T005V27_n1928MenuVerId ;
   private String[] T005V27_A1929MenuOpcCod ;
   private byte[] T005V3_A1923RolId ;
   private boolean[] T005V3_n1923RolId ;
   private long[] T005V3_A1928MenuVerId ;
   private boolean[] T005V3_n1928MenuVerId ;
   private String[] T005V3_A1929MenuOpcCod ;
   private String[] T005V3_A1931MenuOpcTitulo ;
   private boolean[] T005V3_A1951MenuBienveVisible ;
   private String[] T005V3_A1933MenuOpcPadre ;
   private boolean[] T005V3_n1933MenuOpcPadre ;
   private boolean[] T005V3_A1934MenuHomeEs ;
   private byte[] T005V3_A1940MenuItemOrd ;
   private String[] T005V3_A1941MenuItemImg ;
   private String[] T005V3_A1946MenuBienveImg ;
   private String[] T005V3_A1949MenuBienveTitulo ;
   private String[] T005V3_A1950MenuBienveTexto ;
   private String[] T005V3_A2361MenuOpcObj ;
   private boolean[] T005V3_A2363MenuOpcInst ;
   private boolean[] T005V3_A2367MenuOpcForRet ;
   private String[] T005V3_A1942MenuItemImgExt ;
   private String[] T005V3_A1947MenuBienveImgExt ;
   private String[] T005V3_A1943MenuItemImgNom ;
   private String[] T005V3_A1948MenuBienveImgNom ;
   private String[] T005V3_A1935SVGId ;
   private boolean[] T005V3_n1935SVGId ;
   private byte[] T005V3_A1925PerfilId ;
   private boolean[] T005V3_n1925PerfilId ;
   private String[] T005V3_A1937MenuItemId ;
   private byte[] T005V2_A1923RolId ;
   private boolean[] T005V2_n1923RolId ;
   private long[] T005V2_A1928MenuVerId ;
   private boolean[] T005V2_n1928MenuVerId ;
   private String[] T005V2_A1929MenuOpcCod ;
   private String[] T005V2_A1931MenuOpcTitulo ;
   private boolean[] T005V2_A1951MenuBienveVisible ;
   private String[] T005V2_A1933MenuOpcPadre ;
   private boolean[] T005V2_n1933MenuOpcPadre ;
   private boolean[] T005V2_A1934MenuHomeEs ;
   private byte[] T005V2_A1940MenuItemOrd ;
   private String[] T005V2_A1941MenuItemImg ;
   private String[] T005V2_A1946MenuBienveImg ;
   private String[] T005V2_A1949MenuBienveTitulo ;
   private String[] T005V2_A1950MenuBienveTexto ;
   private String[] T005V2_A2361MenuOpcObj ;
   private boolean[] T005V2_A2363MenuOpcInst ;
   private boolean[] T005V2_A2367MenuOpcForRet ;
   private String[] T005V2_A1942MenuItemImgExt ;
   private String[] T005V2_A1947MenuBienveImgExt ;
   private String[] T005V2_A1943MenuItemImgNom ;
   private String[] T005V2_A1948MenuBienveImgNom ;
   private String[] T005V2_A1935SVGId ;
   private boolean[] T005V2_n1935SVGId ;
   private byte[] T005V2_A1925PerfilId ;
   private boolean[] T005V2_n1925PerfilId ;
   private String[] T005V2_A1937MenuItemId ;
   private String[] T005V33_A1939MenuItemTitulo ;
   private byte[] T005V34_A1923RolId ;
   private boolean[] T005V34_n1923RolId ;
   private byte[] T005V34_A1925PerfilId ;
   private boolean[] T005V34_n1925PerfilId ;
   private long[] T005V34_A1928MenuVerId ;
   private boolean[] T005V34_n1928MenuVerId ;
   private String[] T005V34_A1929MenuOpcCod ;
   private String[] T005V34_A2365MenuOpcAcc ;
   private byte[] T005V35_A1923RolId ;
   private boolean[] T005V35_n1923RolId ;
   private byte[] T005V35_A1925PerfilId ;
   private boolean[] T005V35_n1925PerfilId ;
   private long[] T005V35_A1928MenuVerId ;
   private boolean[] T005V35_n1928MenuVerId ;
   private String[] T005V35_A1929MenuOpcCod ;
   private byte[] T005V36_A1925PerfilId ;
   private boolean[] T005V36_n1925PerfilId ;
   private String[] T005V36_A1926PerfilNombre ;
   private short[] T005V37_A1927MenuPais ;
   private boolean[] T005V37_n1927MenuPais ;
   private String[] T005V37_A312PaiNom ;
   private boolean[] T005V37_n312PaiNom ;
   private byte[] T005V38_A1923RolId ;
   private boolean[] T005V38_n1923RolId ;
   private byte[] T005V38_A1925PerfilId ;
   private boolean[] T005V38_n1925PerfilId ;
   private long[] T005V38_A1928MenuVerId ;
   private boolean[] T005V38_n1928MenuVerId ;
   private String[] T005V38_A1929MenuOpcCod ;
   private String[] T005V39_A1935SVGId ;
   private boolean[] T005V39_n1935SVGId ;
   private byte[] T005V40_A1925PerfilId ;
   private boolean[] T005V40_n1925PerfilId ;
   private String[] T005V40_A1926PerfilNombre ;
   private byte[] T005V41_A1925PerfilId ;
   private boolean[] T005V41_n1925PerfilId ;
   private byte[] T005V42_A1923RolId ;
   private boolean[] T005V42_n1923RolId ;
   private short[] T005V43_A1927MenuPais ;
   private boolean[] T005V43_n1927MenuPais ;
   private String[] T005V44_A1935SVGId ;
   private boolean[] T005V44_n1935SVGId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV16TrnContextAtt ;
}

final  class menuversiones__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T005V2", "SELECT RolId, MenuVerId, MenuOpcCod, MenuOpcTitulo, MenuBienveVisible, MenuOpcPadre, MenuHomeEs, MenuItemOrd, MenuItemImg, MenuBienveImg, MenuBienveTitulo, MenuBienveTexto, MenuOpcObj, MenuOpcInst, MenuOpcForRet, MenuItemImgExt, MenuBienveImgExt, MenuItemImgNom, MenuBienveImgNom, SVGId, PerfilId, MenuItemId FROM MenuVersionesOpciones WHERE RolId = ? AND PerfilId = ? AND MenuVerId = ? AND MenuOpcCod = ?  FOR UPDATE OF MenuVersionesOpciones NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V3", "SELECT RolId, MenuVerId, MenuOpcCod, MenuOpcTitulo, MenuBienveVisible, MenuOpcPadre, MenuHomeEs, MenuItemOrd, MenuItemImg, MenuBienveImg, MenuBienveTitulo, MenuBienveTexto, MenuOpcObj, MenuOpcInst, MenuOpcForRet, MenuItemImgExt, MenuBienveImgExt, MenuItemImgNom, MenuBienveImgNom, SVGId, PerfilId, MenuItemId FROM MenuVersionesOpciones WHERE RolId = ? AND PerfilId = ? AND MenuVerId = ? AND MenuOpcCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V4", "SELECT SVGId FROM SVG WHERE SVGId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V5", "SELECT MenuItemTitulo FROM MenuItem WHERE PerfilId = ? AND MenuItemId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V6", "SELECT MenuVerId, RolId, PerfilId, MenuPais FROM MenuVersiones WHERE RolId = ? AND PerfilId = ? AND MenuVerId = ?  FOR UPDATE OF MenuVersiones NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V7", "SELECT MenuVerId, RolId, PerfilId, MenuPais FROM MenuVersiones WHERE RolId = ? AND PerfilId = ? AND MenuVerId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V8", "SELECT RolId FROM RolUsuario WHERE RolId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V9", "SELECT PerfilId FROM Perfil WHERE PerfilId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V10", "SELECT PaiCod AS MenuPais FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V11", "SELECT TM1.MenuVerId, TM1.RolId, TM1.PerfilId, TM1.MenuPais AS MenuPais FROM MenuVersiones TM1 WHERE TM1.RolId = ? and TM1.PerfilId = ? and TM1.MenuVerId = ? ORDER BY TM1.RolId, TM1.PerfilId, TM1.MenuVerId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V12", "SELECT RolId FROM RolUsuario WHERE RolId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V13", "SELECT PerfilId FROM Perfil WHERE PerfilId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V14", "SELECT PaiCod AS MenuPais FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V15", "SELECT RolId, PerfilId, MenuVerId FROM MenuVersiones WHERE RolId = ? AND PerfilId = ? AND MenuVerId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V16", "SELECT RolId, PerfilId, MenuVerId FROM MenuVersiones WHERE ( RolId > ? or RolId = ? and PerfilId > ? or PerfilId = ? and RolId = ? and MenuVerId > ?) ORDER BY RolId, PerfilId, MenuVerId  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005V17", "SELECT RolId, PerfilId, MenuVerId FROM MenuVersiones WHERE ( RolId < ? or RolId = ? and PerfilId < ? or PerfilId = ? and RolId = ? and MenuVerId < ?) ORDER BY RolId DESC, PerfilId DESC, MenuVerId DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T005V18", "SAVEPOINT gxupdate;INSERT INTO MenuVersiones(MenuVerId, RolId, PerfilId, MenuPais) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005V19", "SAVEPOINT gxupdate;UPDATE MenuVersiones SET MenuPais=?  WHERE RolId = ? AND PerfilId = ? AND MenuVerId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005V20", "SAVEPOINT gxupdate;DELETE FROM MenuVersiones  WHERE RolId = ? AND PerfilId = ? AND MenuVerId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005V21", "SELECT SecUserId FROM SecUser WHERE RolId = ? AND PerfilId = ? AND MenuVerId = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005V22", "SELECT RolId, PerfilId, MenuVerId, MenuOpcCod, MenuOpcAcc FROM MenuVerOpcPermisos WHERE RolId = ? AND PerfilId = ? AND MenuVerId = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005V23", "SELECT RolId, PerfilId, MenuVerId FROM MenuVersiones ORDER BY RolId, PerfilId, MenuVerId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V24", "SELECT T1.RolId, T1.MenuVerId, T1.MenuOpcCod, T1.MenuOpcTitulo, T1.MenuBienveVisible, T1.MenuOpcPadre, T1.MenuHomeEs, T1.MenuItemOrd, T1.MenuItemImg, T2.MenuItemTitulo, T1.MenuBienveImg, T1.MenuBienveTitulo, T1.MenuBienveTexto, T1.MenuOpcObj, T1.MenuOpcInst, T1.MenuOpcForRet, T1.MenuItemImgExt, T1.MenuBienveImgExt, T1.MenuItemImgNom, T1.MenuBienveImgNom, T1.SVGId, T1.PerfilId, T1.MenuItemId FROM (MenuVersionesOpciones T1 INNER JOIN MenuItem T2 ON T2.PerfilId = T1.PerfilId AND T2.MenuItemId = T1.MenuItemId) WHERE T1.RolId = ? and T1.PerfilId = ? and T1.MenuVerId = ? and T1.MenuOpcCod = ( ?) ORDER BY T1.RolId, T1.PerfilId, T1.MenuVerId, T1.MenuOpcCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V25", "SELECT MenuItemTitulo FROM MenuItem WHERE PerfilId = ? AND MenuItemId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V26", "SELECT SVGId FROM SVG WHERE SVGId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V27", "SELECT RolId, PerfilId, MenuVerId, MenuOpcCod FROM MenuVersionesOpciones WHERE RolId = ? AND PerfilId = ? AND MenuVerId = ? AND MenuOpcCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T005V28", "SAVEPOINT gxupdate;INSERT INTO MenuVersionesOpciones(RolId, MenuVerId, MenuOpcCod, MenuOpcTitulo, MenuBienveVisible, MenuOpcPadre, MenuHomeEs, MenuItemOrd, MenuItemImg, MenuBienveImg, MenuBienveTitulo, MenuBienveTexto, MenuOpcObj, MenuOpcInst, MenuOpcForRet, MenuItemImgExt, MenuBienveImgExt, MenuItemImgNom, MenuBienveImgNom, SVGId, PerfilId, MenuItemId) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005V29", "SAVEPOINT gxupdate;UPDATE MenuVersionesOpciones SET MenuOpcTitulo=?, MenuBienveVisible=?, MenuOpcPadre=?, MenuHomeEs=?, MenuItemOrd=?, MenuBienveTitulo=?, MenuBienveTexto=?, MenuOpcObj=?, MenuOpcInst=?, MenuOpcForRet=?, MenuItemImgExt=?, MenuBienveImgExt=?, MenuItemImgNom=?, MenuBienveImgNom=?, SVGId=?, MenuItemId=?  WHERE RolId = ? AND PerfilId = ? AND MenuVerId = ? AND MenuOpcCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005V30", "SAVEPOINT gxupdate;UPDATE MenuVersionesOpciones SET MenuItemImg=?  WHERE RolId = ? AND PerfilId = ? AND MenuVerId = ? AND MenuOpcCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005V31", "SAVEPOINT gxupdate;UPDATE MenuVersionesOpciones SET MenuBienveImg=?  WHERE RolId = ? AND PerfilId = ? AND MenuVerId = ? AND MenuOpcCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005V32", "SAVEPOINT gxupdate;DELETE FROM MenuVersionesOpciones  WHERE RolId = ? AND PerfilId = ? AND MenuVerId = ? AND MenuOpcCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005V33", "SELECT MenuItemTitulo FROM MenuItem WHERE PerfilId = ? AND MenuItemId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V34", "SELECT RolId, PerfilId, MenuVerId, MenuOpcCod, MenuOpcAcc FROM MenuVerOpcPermisos WHERE RolId = ? AND PerfilId = ? AND MenuVerId = ? AND MenuOpcCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005V35", "SELECT RolId, PerfilId, MenuVerId, MenuOpcCod FROM MenuVersionesOpciones WHERE RolId = ? and PerfilId = ? and MenuVerId = ? ORDER BY RolId, PerfilId, MenuVerId, MenuOpcCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V36", "SELECT PerfilId, PerfilNombre FROM Perfil ORDER BY PerfilNombre ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V37", "SELECT PaiCod AS MenuPais, PaiNom FROM Pais ORDER BY PaiNom ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V38", "SELECT RolId, PerfilId, MenuVerId, MenuOpcCod FROM MenuVersionesOpciones ORDER BY MenuOpcCod ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V39", "SELECT SVGId FROM SVG ORDER BY SVGId ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V40", "SELECT PerfilId, PerfilNombre FROM Perfil ORDER BY PerfilNombre ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V41", "SELECT PerfilId FROM Perfil WHERE PerfilId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V42", "SELECT RolId FROM RolUsuario WHERE RolId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V43", "SELECT PaiCod AS MenuPais FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005V44", "SELECT SVGId FROM SVG WHERE SVGId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(7);
               ((byte[]) buf[8])[0] = rslt.getByte(8);
               ((String[]) buf[9])[0] = rslt.getBLOBFile(9, rslt.getString(16, 20), rslt.getVarchar(18));
               ((String[]) buf[10])[0] = rslt.getBLOBFile(10, rslt.getString(17, 20), rslt.getVarchar(19));
               ((String[]) buf[11])[0] = rslt.getVarchar(11);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(12);
               ((String[]) buf[13])[0] = rslt.getString(13, 128);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(15);
               ((String[]) buf[16])[0] = rslt.getString(16, 20);
               ((String[]) buf[17])[0] = rslt.getString(17, 20);
               ((String[]) buf[18])[0] = rslt.getVarchar(18);
               ((String[]) buf[19])[0] = rslt.getVarchar(19);
               ((String[]) buf[20])[0] = rslt.getString(20, 20);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((byte[]) buf[22])[0] = rslt.getByte(21);
               ((String[]) buf[23])[0] = rslt.getVarchar(22);
               return;
            case 1 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(7);
               ((byte[]) buf[8])[0] = rslt.getByte(8);
               ((String[]) buf[9])[0] = rslt.getBLOBFile(9, rslt.getString(16, 20), rslt.getVarchar(18));
               ((String[]) buf[10])[0] = rslt.getBLOBFile(10, rslt.getString(17, 20), rslt.getVarchar(19));
               ((String[]) buf[11])[0] = rslt.getVarchar(11);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(12);
               ((String[]) buf[13])[0] = rslt.getString(13, 128);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(15);
               ((String[]) buf[16])[0] = rslt.getString(16, 20);
               ((String[]) buf[17])[0] = rslt.getString(17, 20);
               ((String[]) buf[18])[0] = rslt.getVarchar(18);
               ((String[]) buf[19])[0] = rslt.getVarchar(19);
               ((String[]) buf[20])[0] = rslt.getString(20, 20);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((byte[]) buf[22])[0] = rslt.getByte(21);
               ((String[]) buf[23])[0] = rslt.getVarchar(22);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 6 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 7 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 9 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 10 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 11 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 13 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 14 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 15 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 19 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 20 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 21 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 22 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(7);
               ((byte[]) buf[8])[0] = rslt.getByte(8);
               ((String[]) buf[9])[0] = rslt.getBLOBFile(9, rslt.getString(17, 20), rslt.getVarchar(19));
               ((String[]) buf[10])[0] = rslt.getVarchar(10);
               ((String[]) buf[11])[0] = rslt.getBLOBFile(11, rslt.getString(18, 20), rslt.getVarchar(20));
               ((String[]) buf[12])[0] = rslt.getVarchar(12);
               ((String[]) buf[13])[0] = rslt.getLongVarchar(13);
               ((String[]) buf[14])[0] = rslt.getString(14, 128);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[16])[0] = rslt.getBoolean(16);
               ((String[]) buf[17])[0] = rslt.getString(17, 20);
               ((String[]) buf[18])[0] = rslt.getString(18, 20);
               ((String[]) buf[19])[0] = rslt.getVarchar(19);
               ((String[]) buf[20])[0] = rslt.getVarchar(20);
               ((String[]) buf[21])[0] = rslt.getString(21, 20);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((byte[]) buf[23])[0] = rslt.getByte(22);
               ((String[]) buf[24])[0] = rslt.getVarchar(23);
               return;
            case 23 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 24 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 25 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 31 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 32 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 33 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 34 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 35 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 36 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 37 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 38 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 39 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 40 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 41 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 42 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(3, ((Number) parms[5]).longValue());
               }
               stmt.setVarchar(4, (String)parms[6], 100, false);
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(3, ((Number) parms[5]).longValue());
               }
               stmt.setVarchar(4, (String)parms[6], 100, false);
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               stmt.setVarchar(2, (String)parms[2], 40, false);
               return;
            case 4 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(3, ((Number) parms[5]).longValue());
               }
               return;
            case 5 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(3, ((Number) parms[5]).longValue());
               }
               return;
            case 6 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               return;
            case 7 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(3, ((Number) parms[5]).longValue());
               }
               return;
            case 10 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               return;
            case 11 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               return;
            case 12 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 13 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(3, ((Number) parms[5]).longValue());
               }
               return;
            case 14 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(3, ((Number) parms[5]).byteValue());
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(4, ((Number) parms[7]).byteValue());
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(5, ((Number) parms[9]).byteValue());
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(6, ((Number) parms[11]).longValue());
               }
               return;
            case 15 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(3, ((Number) parms[5]).byteValue());
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(4, ((Number) parms[7]).byteValue());
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(5, ((Number) parms[9]).byteValue());
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(6, ((Number) parms[11]).longValue());
               }
               return;
            case 16 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(3, ((Number) parms[5]).byteValue());
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(4, ((Number) parms[7]).shortValue());
               }
               return;
            case 17 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(3, ((Number) parms[5]).byteValue());
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(4, ((Number) parms[7]).longValue());
               }
               return;
            case 18 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(3, ((Number) parms[5]).longValue());
               }
               return;
            case 19 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(3, ((Number) parms[5]).longValue());
               }
               return;
            case 20 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(3, ((Number) parms[5]).longValue());
               }
               return;
            case 22 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(3, ((Number) parms[5]).longValue());
               }
               stmt.setVarchar(4, (String)parms[6], 100, false);
               return;
            case 23 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               stmt.setVarchar(2, (String)parms[2], 40, false);
               return;
            case 24 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 25 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(3, ((Number) parms[5]).longValue());
               }
               stmt.setVarchar(4, (String)parms[6], 100, false);
               return;
            case 26 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(2, ((Number) parms[3]).longValue());
               }
               stmt.setVarchar(3, (String)parms[4], 100, false);
               stmt.setVarchar(4, (String)parms[5], 400, false);
               stmt.setBoolean(5, ((Boolean) parms[6]).booleanValue());
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[8], 40);
               }
               stmt.setBoolean(7, ((Boolean) parms[9]).booleanValue());
               stmt.setByte(8, ((Number) parms[10]).byteValue());
               stmt.setBLOBFile(9, (String)parms[11]);
               stmt.setBLOBFile(10, (String)parms[12]);
               stmt.setVarchar(11, (String)parms[13], 400, false);
               stmt.setNLongVarchar(12, (String)parms[14], false);
               stmt.setString(13, (String)parms[15], 128);
               stmt.setBoolean(14, ((Boolean) parms[16]).booleanValue());
               stmt.setBoolean(15, ((Boolean) parms[17]).booleanValue());
               stmt.setString(16, (String)parms[18], 20);
               stmt.setString(17, (String)parms[19], 20);
               stmt.setVarchar(18, (String)parms[20], 400, false);
               stmt.setVarchar(19, (String)parms[21], 400, false);
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 20 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(20, (String)parms[23], 20);
               }
               if ( ((Boolean) parms[24]).booleanValue() )
               {
                  stmt.setNull( 21 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(21, ((Number) parms[25]).byteValue());
               }
               stmt.setVarchar(22, (String)parms[26], 40, false);
               return;
            case 27 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 40);
               }
               stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               stmt.setByte(5, ((Number) parms[5]).byteValue());
               stmt.setVarchar(6, (String)parms[6], 400, false);
               stmt.setNLongVarchar(7, (String)parms[7], false);
               stmt.setString(8, (String)parms[8], 128);
               stmt.setBoolean(9, ((Boolean) parms[9]).booleanValue());
               stmt.setBoolean(10, ((Boolean) parms[10]).booleanValue());
               stmt.setString(11, (String)parms[11], 20);
               stmt.setString(12, (String)parms[12], 20);
               stmt.setVarchar(13, (String)parms[13], 400, false);
               stmt.setVarchar(14, (String)parms[14], 400, false);
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(15, (String)parms[16], 20);
               }
               stmt.setVarchar(16, (String)parms[17], 40, false);
               if ( ((Boolean) parms[18]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(17, ((Number) parms[19]).byteValue());
               }
               if ( ((Boolean) parms[20]).booleanValue() )
               {
                  stmt.setNull( 18 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(18, ((Number) parms[21]).byteValue());
               }
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 19 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(19, ((Number) parms[23]).longValue());
               }
               stmt.setVarchar(20, (String)parms[24], 100, false);
               return;
            case 28 :
               stmt.setBLOBFile(1, (String)parms[0]);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[2]).byteValue());
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(3, ((Number) parms[4]).byteValue());
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(4, ((Number) parms[6]).longValue());
               }
               stmt.setVarchar(5, (String)parms[7], 100, false);
               return;
            case 29 :
               stmt.setBLOBFile(1, (String)parms[0]);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[2]).byteValue());
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(3, ((Number) parms[4]).byteValue());
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(4, ((Number) parms[6]).longValue());
               }
               stmt.setVarchar(5, (String)parms[7], 100, false);
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(3, ((Number) parms[5]).longValue());
               }
               stmt.setVarchar(4, (String)parms[6], 100, false);
               return;
            case 31 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               stmt.setVarchar(2, (String)parms[2], 40, false);
               return;
            case 32 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(3, ((Number) parms[5]).longValue());
               }
               stmt.setVarchar(4, (String)parms[6], 100, false);
               return;
            case 33 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(3, ((Number) parms[5]).longValue());
               }
               return;
            case 39 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               return;
            case 40 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(1, ((Number) parms[1]).byteValue());
               }
               return;
            case 41 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 42 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
      }
   }

}

