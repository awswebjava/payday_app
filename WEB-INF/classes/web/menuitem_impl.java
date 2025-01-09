package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class menuitem_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"MITEMICOSVG") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlamitemicosvg5X258( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_19") == 0 )
      {
         A1925PerfilId = (byte)(GXutil.lval( httpContext.GetPar( "PerfilId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
         A1944MItemPadreDef = httpContext.GetPar( "MItemPadreDef") ;
         n1944MItemPadreDef = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1944MItemPadreDef", A1944MItemPadreDef);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_19( A1925PerfilId, A1944MItemPadreDef) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_18") == 0 )
      {
         A1957MItemIcoSVG = httpContext.GetPar( "MItemIcoSVG") ;
         n1957MItemIcoSVG = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1957MItemIcoSVG", A1957MItemIcoSVG);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_18( A1957MItemIcoSVG) ;
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
            AV13PerfilId = (byte)(GXutil.lval( httpContext.GetPar( "PerfilId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13PerfilId), 2, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERFILID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13PerfilId), "Z9")));
            AV7MenuItemId = httpContext.GetPar( "MenuItemId") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7MenuItemId", AV7MenuItemId);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUITEMID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7MenuItemId, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Menu Item", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtPerfilId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public menuitem_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public menuitem_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( menuitem_impl.class ));
   }

   public menuitem_impl( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynMItemIcoSVG = new HTMLChoice();
      chkMItemEsMenu = UIFactory.getCheckbox(this);
      chkMItemPadreObl = UIFactory.getCheckbox(this);
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
      if ( dynMItemIcoSVG.getItemCount() > 0 )
      {
         A1957MItemIcoSVG = dynMItemIcoSVG.getValidValue(A1957MItemIcoSVG) ;
         n1957MItemIcoSVG = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1957MItemIcoSVG", A1957MItemIcoSVG);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynMItemIcoSVG.setValue( GXutil.rtrim( A1957MItemIcoSVG) );
         httpContext.ajax_rsp_assign_prop("", false, dynMItemIcoSVG.getInternalname(), "Values", dynMItemIcoSVG.ToJavascriptSource(), true);
      }
      A1938MItemEsMenu = GXutil.strtobool( GXutil.booltostr( A1938MItemEsMenu)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1938MItemEsMenu", A1938MItemEsMenu);
      A1945MItemPadreObl = GXutil.strtobool( GXutil.booltostr( A1945MItemPadreObl)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1945MItemPadreObl", A1945MItemPadreObl);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPerfilId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPerfilId_Internalname, httpContext.getMessage( "Perfil", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPerfilId_Internalname, GXutil.ltrim( localUtil.ntoc( A1925PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1925PerfilId), "Z9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPerfilId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPerfilId_Enabled, 1, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_MenuItem.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMenuItemId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMenuItemId_Internalname, httpContext.getMessage( "Menú item ID", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMenuItemId_Internalname, A1937MenuItemId, GXutil.rtrim( localUtil.format( A1937MenuItemId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMenuItemId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMenuItemId_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MenuItem.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMenuItemTitulo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMenuItemTitulo_Internalname, httpContext.getMessage( "Título por defecto", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMenuItemTitulo_Internalname, A1939MenuItemTitulo, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", (short)(0), 1, edtMenuItemTitulo_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MenuItem.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynMItemIcoSVG.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynMItemIcoSVG.getInternalname(), httpContext.getMessage( "SVG de ícono por defecto", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynMItemIcoSVG, dynMItemIcoSVG.getInternalname(), GXutil.rtrim( A1957MItemIcoSVG), 1, dynMItemIcoSVG.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynMItemIcoSVG.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "", true, (byte)(0), "HLP_MenuItem.htm");
      dynMItemIcoSVG.setValue( GXutil.rtrim( A1957MItemIcoSVG) );
      httpContext.ajax_rsp_assign_prop("", false, dynMItemIcoSVG.getInternalname(), "Values", dynMItemIcoSVG.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMitemIcoImg_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMitemIcoImg_Internalname, httpContext.getMessage( "Img de ícono por defecto", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      ClassString = "Attribute" ;
      StyleString = "" ;
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      edtMitemIcoImg_Filename = A1960MitemIcoImgNom ;
      edtMitemIcoImg_Filetype = "" ;
      httpContext.ajax_rsp_assign_prop("", false, edtMitemIcoImg_Internalname, "Filetype", edtMitemIcoImg_Filetype, true);
      edtMitemIcoImg_Filetype = A1959MItemIcoImgExt ;
      httpContext.ajax_rsp_assign_prop("", false, edtMitemIcoImg_Internalname, "Filetype", edtMitemIcoImg_Filetype, true);
      if ( ! (GXutil.strcmp("", A1958MitemIcoImg)==0) )
      {
         gxblobfileaux.setSource( A1958MitemIcoImg );
         if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtMitemIcoImg_Filetype, "tmp") != 0 ) )
         {
            gxblobfileaux.setExt(GXutil.trim( edtMitemIcoImg_Filetype));
         }
         if ( gxblobfileaux.getErrCode() == 0 )
         {
            A1958MitemIcoImg = gxblobfileaux.getURI() ;
            httpContext.ajax_rsp_assign_attri("", false, "A1958MitemIcoImg", A1958MitemIcoImg);
            httpContext.ajax_rsp_assign_prop("", false, edtMitemIcoImg_Internalname, "URL", httpContext.getResourceRelative(A1958MitemIcoImg), true);
            edtMitemIcoImg_Filetype = gxblobfileaux.getExtension() ;
            httpContext.ajax_rsp_assign_prop("", false, edtMitemIcoImg_Internalname, "Filetype", edtMitemIcoImg_Filetype, true);
            gxblobfileaux.setBlobToDelete();
         }
         httpContext.ajax_rsp_assign_prop("", false, edtMitemIcoImg_Internalname, "URL", httpContext.getResourceRelative(A1958MitemIcoImg), true);
      }
      web.GxWebStd.gx_blob_field( httpContext, edtMitemIcoImg_Internalname, GXutil.rtrim( A1958MitemIcoImg), httpContext.getResourceRelative(A1958MitemIcoImg), ((GXutil.strcmp("", edtMitemIcoImg_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtMitemIcoImg_Filetype)==0) ? A1958MitemIcoImg : edtMitemIcoImg_Filetype)) : edtMitemIcoImg_Contenttype), true, "", edtMitemIcoImg_Parameters, 0, edtMitemIcoImg_Enabled, 1, "", "", 0, -1, 250, "px", 60, "px", 0, 0, 0, edtMitemIcoImg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", StyleString, ClassString, "", "", ""+TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "", "", "HLP_MenuItem.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkMItemEsMenu.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkMItemEsMenu.getInternalname(), httpContext.getMessage( "Es menú", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkMItemEsMenu.getInternalname(), GXutil.booltostr( A1938MItemEsMenu), "", httpContext.getMessage( "Es menú", ""), 1, chkMItemEsMenu.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(47, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,47);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMItemPadreDef_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMItemPadreDef_Internalname, httpContext.getMessage( "Padre default", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMItemPadreDef_Internalname, A1944MItemPadreDef, GXutil.rtrim( localUtil.format( A1944MItemPadreDef, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMItemPadreDef_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMItemPadreDef_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MenuItem.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkMItemPadreObl.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkMItemPadreObl.getInternalname(), httpContext.getMessage( "Padre default es obligatorio", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkMItemPadreObl.getInternalname(), GXutil.booltostr( A1945MItemPadreObl), "", httpContext.getMessage( "Padre default es obligatorio", ""), 1, chkMItemPadreObl.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(57, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,57);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMItemBienTitDef_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMItemBienTitDef_Internalname, httpContext.getMessage( "Título de bienvenida por defecto", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMItemBienTitDef_Internalname, A1955MItemBienTitDef, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,62);\"", (short)(0), 1, edtMItemBienTitDef_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MenuItem.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMItemBienTextDef_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMItemBienTextDef_Internalname, httpContext.getMessage( "Texto de bienvenida por defecto", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMItemBienTextDef_Internalname, A1956MItemBienTextDef, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,67);\"", (short)(0), 1, edtMItemBienTextDef_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MenuItem.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMItemBienImgDef_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMItemBienImgDef_Internalname, httpContext.getMessage( "Imagen de bienvenida por defecto", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      ClassString = "Attribute" ;
      StyleString = "" ;
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
      edtMItemBienImgDef_Filename = A1954MItemBienImgNom ;
      edtMItemBienImgDef_Filetype = "" ;
      httpContext.ajax_rsp_assign_prop("", false, edtMItemBienImgDef_Internalname, "Filetype", edtMItemBienImgDef_Filetype, true);
      edtMItemBienImgDef_Filetype = A1953MItemBienImgExt ;
      httpContext.ajax_rsp_assign_prop("", false, edtMItemBienImgDef_Internalname, "Filetype", edtMItemBienImgDef_Filetype, true);
      if ( ! (GXutil.strcmp("", A1952MItemBienImgDef)==0) )
      {
         gxblobfileaux.setSource( A1952MItemBienImgDef );
         if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtMItemBienImgDef_Filetype, "tmp") != 0 ) )
         {
            gxblobfileaux.setExt(GXutil.trim( edtMItemBienImgDef_Filetype));
         }
         if ( gxblobfileaux.getErrCode() == 0 )
         {
            A1952MItemBienImgDef = gxblobfileaux.getURI() ;
            httpContext.ajax_rsp_assign_attri("", false, "A1952MItemBienImgDef", A1952MItemBienImgDef);
            httpContext.ajax_rsp_assign_prop("", false, edtMItemBienImgDef_Internalname, "URL", httpContext.getResourceRelative(A1952MItemBienImgDef), true);
            edtMItemBienImgDef_Filetype = gxblobfileaux.getExtension() ;
            httpContext.ajax_rsp_assign_prop("", false, edtMItemBienImgDef_Internalname, "Filetype", edtMItemBienImgDef_Filetype, true);
            gxblobfileaux.setBlobToDelete();
         }
         httpContext.ajax_rsp_assign_prop("", false, edtMItemBienImgDef_Internalname, "URL", httpContext.getResourceRelative(A1952MItemBienImgDef), true);
      }
      web.GxWebStd.gx_blob_field( httpContext, edtMItemBienImgDef_Internalname, GXutil.rtrim( A1952MItemBienImgDef), httpContext.getResourceRelative(A1952MItemBienImgDef), ((GXutil.strcmp("", edtMItemBienImgDef_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtMItemBienImgDef_Filetype)==0) ? A1952MItemBienImgDef : edtMItemBienImgDef_Filetype)) : edtMItemBienImgDef_Contenttype), true, "", edtMItemBienImgDef_Parameters, 0, edtMItemBienImgDef_Enabled, 1, "", "", 0, -1, 250, "px", 60, "px", 0, 0, 0, edtMItemBienImgDef_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", StyleString, ClassString, "", "", ""+TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,72);\"", "", "", "HLP_MenuItem.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMItemHelp_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMItemHelp_Internalname, httpContext.getMessage( "Help", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMItemHelp_Internalname, A1961MItemHelp, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,77);\"", (short)(0), 1, edtMItemHelp_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MenuItem.htm");
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
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_MenuItem.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_MenuItem.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_MenuItem.htm");
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
      e115X2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z1925PerfilId = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1925PerfilId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1937MenuItemId = httpContext.cgiGet( "Z1937MenuItemId") ;
            Z1939MenuItemTitulo = httpContext.cgiGet( "Z1939MenuItemTitulo") ;
            Z1938MItemEsMenu = GXutil.strtobool( httpContext.cgiGet( "Z1938MItemEsMenu")) ;
            Z1945MItemPadreObl = GXutil.strtobool( httpContext.cgiGet( "Z1945MItemPadreObl")) ;
            Z1955MItemBienTitDef = httpContext.cgiGet( "Z1955MItemBienTitDef") ;
            Z1957MItemIcoSVG = httpContext.cgiGet( "Z1957MItemIcoSVG") ;
            n1957MItemIcoSVG = ((GXutil.strcmp("", A1957MItemIcoSVG)==0) ? true : false) ;
            Z1944MItemPadreDef = httpContext.cgiGet( "Z1944MItemPadreDef") ;
            n1944MItemPadreDef = ((GXutil.strcmp("", A1944MItemPadreDef)==0) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N1944MItemPadreDef = httpContext.cgiGet( "N1944MItemPadreDef") ;
            n1944MItemPadreDef = ((GXutil.strcmp("", A1944MItemPadreDef)==0) ? true : false) ;
            N1957MItemIcoSVG = httpContext.cgiGet( "N1957MItemIcoSVG") ;
            n1957MItemIcoSVG = ((GXutil.strcmp("", A1957MItemIcoSVG)==0) ? true : false) ;
            AV13PerfilId = (byte)(localUtil.ctol( httpContext.cgiGet( "vPERFILID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7MenuItemId = httpContext.cgiGet( "vMENUITEMID") ;
            AV20Insert_MItemPadreDef = httpContext.cgiGet( "vINSERT_MITEMPADREDEF") ;
            AV22Insert_MItemIcoSVG = httpContext.cgiGet( "vINSERT_MITEMICOSVG") ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1959MItemIcoImgExt = httpContext.cgiGet( "MITEMICOIMGEXT") ;
            A1953MItemBienImgExt = httpContext.cgiGet( "MITEMBIENIMGEXT") ;
            A1960MitemIcoImgNom = httpContext.cgiGet( "MITEMICOIMGNOM") ;
            A1954MItemBienImgNom = httpContext.cgiGet( "MITEMBIENIMGNOM") ;
            AV26Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            edtMitemIcoImg_Filetype = httpContext.cgiGet( "MITEMICOIMG_Filetype") ;
            edtMItemBienImgDef_Filetype = httpContext.cgiGet( "MITEMBIENIMGDEF_Filetype") ;
            edtMitemIcoImg_Filename = httpContext.cgiGet( "MITEMICOIMG_Filename") ;
            edtMItemBienImgDef_Filename = httpContext.cgiGet( "MITEMBIENIMGDEF_Filename") ;
            edtMitemIcoImg_Filename = httpContext.cgiGet( "MITEMICOIMG_Filename") ;
            edtMItemBienImgDef_Filename = httpContext.cgiGet( "MITEMBIENIMGDEF_Filename") ;
            edtMitemIcoImg_Filetype = httpContext.cgiGet( "MITEMICOIMG_Filetype") ;
            edtMItemBienImgDef_Filetype = httpContext.cgiGet( "MITEMBIENIMGDEF_Filetype") ;
            /* Read variables values. */
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPerfilId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPerfilId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PERFILID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPerfilId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1925PerfilId = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
            }
            else
            {
               A1925PerfilId = (byte)(localUtil.ctol( httpContext.cgiGet( edtPerfilId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
            }
            A1937MenuItemId = httpContext.cgiGet( edtMenuItemId_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1937MenuItemId", A1937MenuItemId);
            A1939MenuItemTitulo = httpContext.cgiGet( edtMenuItemTitulo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1939MenuItemTitulo", A1939MenuItemTitulo);
            dynMItemIcoSVG.setValue( httpContext.cgiGet( dynMItemIcoSVG.getInternalname()) );
            A1957MItemIcoSVG = httpContext.cgiGet( dynMItemIcoSVG.getInternalname()) ;
            n1957MItemIcoSVG = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1957MItemIcoSVG", A1957MItemIcoSVG);
            n1957MItemIcoSVG = ((GXutil.strcmp("", A1957MItemIcoSVG)==0) ? true : false) ;
            A1958MitemIcoImg = httpContext.cgiGet( edtMitemIcoImg_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1958MitemIcoImg", A1958MitemIcoImg);
            A1938MItemEsMenu = GXutil.strtobool( httpContext.cgiGet( chkMItemEsMenu.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1938MItemEsMenu", A1938MItemEsMenu);
            A1944MItemPadreDef = httpContext.cgiGet( edtMItemPadreDef_Internalname) ;
            n1944MItemPadreDef = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1944MItemPadreDef", A1944MItemPadreDef);
            n1944MItemPadreDef = ((GXutil.strcmp("", A1944MItemPadreDef)==0) ? true : false) ;
            A1945MItemPadreObl = GXutil.strtobool( httpContext.cgiGet( chkMItemPadreObl.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1945MItemPadreObl", A1945MItemPadreObl);
            A1955MItemBienTitDef = httpContext.cgiGet( edtMItemBienTitDef_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1955MItemBienTitDef", A1955MItemBienTitDef);
            A1956MItemBienTextDef = httpContext.cgiGet( edtMItemBienTextDef_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1956MItemBienTextDef", A1956MItemBienTextDef);
            A1952MItemBienImgDef = httpContext.cgiGet( edtMItemBienImgDef_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1952MItemBienImgDef", A1952MItemBienImgDef);
            A1961MItemHelp = httpContext.cgiGet( edtMItemHelp_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1961MItemHelp", A1961MItemHelp);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            if ( ! (GXutil.strcmp("", A1958MitemIcoImg)==0) )
            {
               edtMitemIcoImg_Filename = httpContext.cgiGetFileName( edtMitemIcoImg_Internalname) ;
               edtMitemIcoImg_Filetype = httpContext.cgiGetFileType( edtMitemIcoImg_Internalname) ;
            }
            A1959MItemIcoImgExt = edtMitemIcoImg_Filetype ;
            httpContext.ajax_rsp_assign_attri("", false, "A1959MItemIcoImgExt", A1959MItemIcoImgExt);
            A1960MitemIcoImgNom = edtMitemIcoImg_Filename ;
            httpContext.ajax_rsp_assign_attri("", false, "A1960MitemIcoImgNom", A1960MitemIcoImgNom);
            if ( (GXutil.strcmp("", A1958MitemIcoImg)==0) )
            {
               GXCCtlgxBlob = "MITEMICOIMG" + "_gxBlob" ;
               A1958MitemIcoImg = httpContext.cgiGet( GXCCtlgxBlob) ;
            }
            if ( ! (GXutil.strcmp("", A1952MItemBienImgDef)==0) )
            {
               edtMItemBienImgDef_Filename = httpContext.cgiGetFileName( edtMItemBienImgDef_Internalname) ;
               edtMItemBienImgDef_Filetype = httpContext.cgiGetFileType( edtMItemBienImgDef_Internalname) ;
            }
            A1953MItemBienImgExt = edtMItemBienImgDef_Filetype ;
            httpContext.ajax_rsp_assign_attri("", false, "A1953MItemBienImgExt", A1953MItemBienImgExt);
            A1954MItemBienImgNom = edtMItemBienImgDef_Filename ;
            httpContext.ajax_rsp_assign_attri("", false, "A1954MItemBienImgNom", A1954MItemBienImgNom);
            if ( (GXutil.strcmp("", A1952MItemBienImgDef)==0) )
            {
               GXCCtlgxBlob = "MITEMBIENIMGDEF" + "_gxBlob" ;
               A1952MItemBienImgDef = httpContext.cgiGet( GXCCtlgxBlob) ;
            }
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"MenuItem");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A1925PerfilId != Z1925PerfilId ) || ( GXutil.strcmp(A1937MenuItemId, Z1937MenuItemId) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("menuitem:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A1925PerfilId = (byte)(GXutil.lval( httpContext.GetPar( "PerfilId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
               A1937MenuItemId = httpContext.GetPar( "MenuItemId") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1937MenuItemId", A1937MenuItemId);
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode258 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode258 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound258 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_5X0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "PERFILID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtPerfilId_Internalname ;
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
                        e115X2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e125X2 ();
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
         e125X2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll5X258( ) ;
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
         disableAttributes5X258( ) ;
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

   public void confirm_5X0( )
   {
      beforeValidate5X258( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls5X258( ) ;
         }
         else
         {
            checkExtendedTable5X258( ) ;
            closeExtendedTableCursors5X258( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption5X0( )
   {
   }

   public void e115X2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV9IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMenuItem_Insert", GXv_boolean3) ;
         menuitem_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMenuItem_Update", GXv_boolean3) ;
         menuitem_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMenuItem_Delete", GXv_boolean3) ;
         menuitem_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( ! AV9IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV26Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV11TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV26Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV27GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27GXV1), 8, 0));
         while ( AV27GXV1 <= AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV21TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV27GXV1));
            if ( GXutil.strcmp(AV21TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "MItemPadreDef") == 0 )
            {
               AV20Insert_MItemPadreDef = AV21TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20Insert_MItemPadreDef", AV20Insert_MItemPadreDef);
            }
            else if ( GXutil.strcmp(AV21TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "MItemIcoSVG") == 0 )
            {
               AV22Insert_MItemIcoSVG = AV21TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV22Insert_MItemIcoSVG", AV22Insert_MItemIcoSVG);
            }
            AV27GXV1 = (int)(AV27GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27GXV1), 8, 0));
         }
      }
   }

   public void e125X2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm5X258( int GX_JID )
   {
      if ( ( GX_JID == 17 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1939MenuItemTitulo = T005X3_A1939MenuItemTitulo[0] ;
            Z1938MItemEsMenu = T005X3_A1938MItemEsMenu[0] ;
            Z1945MItemPadreObl = T005X3_A1945MItemPadreObl[0] ;
            Z1955MItemBienTitDef = T005X3_A1955MItemBienTitDef[0] ;
            Z1957MItemIcoSVG = T005X3_A1957MItemIcoSVG[0] ;
            Z1944MItemPadreDef = T005X3_A1944MItemPadreDef[0] ;
         }
         else
         {
            Z1939MenuItemTitulo = A1939MenuItemTitulo ;
            Z1938MItemEsMenu = A1938MItemEsMenu ;
            Z1945MItemPadreObl = A1945MItemPadreObl ;
            Z1955MItemBienTitDef = A1955MItemBienTitDef ;
            Z1957MItemIcoSVG = A1957MItemIcoSVG ;
            Z1944MItemPadreDef = A1944MItemPadreDef ;
         }
      }
      if ( GX_JID == -17 )
      {
         Z1937MenuItemId = A1937MenuItemId ;
         Z1939MenuItemTitulo = A1939MenuItemTitulo ;
         Z1938MItemEsMenu = A1938MItemEsMenu ;
         Z1945MItemPadreObl = A1945MItemPadreObl ;
         Z1958MitemIcoImg = A1958MitemIcoImg ;
         Z1952MItemBienImgDef = A1952MItemBienImgDef ;
         Z1955MItemBienTitDef = A1955MItemBienTitDef ;
         Z1956MItemBienTextDef = A1956MItemBienTextDef ;
         Z1961MItemHelp = A1961MItemHelp ;
         Z1959MItemIcoImgExt = A1959MItemIcoImgExt ;
         Z1953MItemBienImgExt = A1953MItemBienImgExt ;
         Z1960MitemIcoImgNom = A1960MitemIcoImgNom ;
         Z1954MItemBienImgNom = A1954MItemBienImgNom ;
         Z1925PerfilId = A1925PerfilId ;
         Z1957MItemIcoSVG = A1957MItemIcoSVG ;
         Z1944MItemPadreDef = A1944MItemPadreDef ;
      }
   }

   public void standaloneNotModal( )
   {
      gxamitemicosvg_html5X258( ) ;
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV13PerfilId) )
      {
         A1925PerfilId = AV13PerfilId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
      }
      if ( ! (0==AV13PerfilId) )
      {
         edtPerfilId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPerfilId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPerfilId_Enabled), 5, 0), true);
      }
      else
      {
         edtPerfilId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPerfilId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPerfilId_Enabled), 5, 0), true);
      }
      if ( ! (0==AV13PerfilId) )
      {
         edtPerfilId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPerfilId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPerfilId_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV7MenuItemId)==0) )
      {
         A1937MenuItemId = AV7MenuItemId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1937MenuItemId", A1937MenuItemId);
      }
      if ( ! (GXutil.strcmp("", AV7MenuItemId)==0) )
      {
         edtMenuItemId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuItemId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemId_Enabled), 5, 0), true);
      }
      else
      {
         edtMenuItemId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuItemId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemId_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV7MenuItemId)==0) )
      {
         edtMenuItemId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMenuItemId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV20Insert_MItemPadreDef)==0) )
      {
         edtMItemPadreDef_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMItemPadreDef_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMItemPadreDef_Enabled), 5, 0), true);
      }
      else
      {
         edtMItemPadreDef_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMItemPadreDef_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMItemPadreDef_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV22Insert_MItemIcoSVG)==0) )
      {
         dynMItemIcoSVG.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynMItemIcoSVG.getInternalname(), "Enabled", GXutil.ltrimstr( dynMItemIcoSVG.getEnabled(), 5, 0), true);
      }
      else
      {
         dynMItemIcoSVG.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynMItemIcoSVG.getInternalname(), "Enabled", GXutil.ltrimstr( dynMItemIcoSVG.getEnabled(), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV22Insert_MItemIcoSVG)==0) )
      {
         A1957MItemIcoSVG = AV22Insert_MItemIcoSVG ;
         n1957MItemIcoSVG = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1957MItemIcoSVG", A1957MItemIcoSVG);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV20Insert_MItemPadreDef)==0) )
      {
         A1944MItemPadreDef = AV20Insert_MItemPadreDef ;
         n1944MItemPadreDef = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1944MItemPadreDef", A1944MItemPadreDef);
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
      if ( isIns( )  && (false==A1938MItemEsMenu) && ( Gx_BScreen == 0 ) )
      {
         A1938MItemEsMenu = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A1938MItemEsMenu", A1938MItemEsMenu);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV26Pgmname = "MenuItem" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
      }
   }

   public void load5X258( )
   {
      /* Using cursor T005X6 */
      pr_default.execute(4, new Object[] {Byte.valueOf(A1925PerfilId), A1937MenuItemId});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound258 = (short)(1) ;
         A1939MenuItemTitulo = T005X6_A1939MenuItemTitulo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1939MenuItemTitulo", A1939MenuItemTitulo);
         A1938MItemEsMenu = T005X6_A1938MItemEsMenu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1938MItemEsMenu", A1938MItemEsMenu);
         A1945MItemPadreObl = T005X6_A1945MItemPadreObl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1945MItemPadreObl", A1945MItemPadreObl);
         A1958MitemIcoImg = T005X6_A1958MitemIcoImg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1958MitemIcoImg", A1958MitemIcoImg);
         httpContext.ajax_rsp_assign_prop("", false, edtMitemIcoImg_Internalname, "URL", httpContext.getResourceRelative(A1958MitemIcoImg), true);
         A1952MItemBienImgDef = T005X6_A1952MItemBienImgDef[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1952MItemBienImgDef", A1952MItemBienImgDef);
         httpContext.ajax_rsp_assign_prop("", false, edtMItemBienImgDef_Internalname, "URL", httpContext.getResourceRelative(A1952MItemBienImgDef), true);
         A1955MItemBienTitDef = T005X6_A1955MItemBienTitDef[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1955MItemBienTitDef", A1955MItemBienTitDef);
         A1956MItemBienTextDef = T005X6_A1956MItemBienTextDef[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1956MItemBienTextDef", A1956MItemBienTextDef);
         A1961MItemHelp = T005X6_A1961MItemHelp[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1961MItemHelp", A1961MItemHelp);
         A1959MItemIcoImgExt = T005X6_A1959MItemIcoImgExt[0] ;
         edtMitemIcoImg_Filetype = A1959MItemIcoImgExt ;
         httpContext.ajax_rsp_assign_prop("", false, edtMitemIcoImg_Internalname, "Filetype", edtMitemIcoImg_Filetype, true);
         A1953MItemBienImgExt = T005X6_A1953MItemBienImgExt[0] ;
         edtMItemBienImgDef_Filetype = A1953MItemBienImgExt ;
         httpContext.ajax_rsp_assign_prop("", false, edtMItemBienImgDef_Internalname, "Filetype", edtMItemBienImgDef_Filetype, true);
         A1960MitemIcoImgNom = T005X6_A1960MitemIcoImgNom[0] ;
         edtMitemIcoImg_Filename = A1960MitemIcoImgNom ;
         A1954MItemBienImgNom = T005X6_A1954MItemBienImgNom[0] ;
         edtMItemBienImgDef_Filename = A1954MItemBienImgNom ;
         A1957MItemIcoSVG = T005X6_A1957MItemIcoSVG[0] ;
         n1957MItemIcoSVG = T005X6_n1957MItemIcoSVG[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1957MItemIcoSVG", A1957MItemIcoSVG);
         A1944MItemPadreDef = T005X6_A1944MItemPadreDef[0] ;
         n1944MItemPadreDef = T005X6_n1944MItemPadreDef[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1944MItemPadreDef", A1944MItemPadreDef);
         zm5X258( -17) ;
      }
      pr_default.close(4);
      onLoadActions5X258( ) ;
   }

   public void onLoadActions5X258( )
   {
      AV26Pgmname = "MenuItem" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
   }

   public void checkExtendedTable5X258( )
   {
      nIsDirty_258 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV26Pgmname = "MenuItem" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
      /* Using cursor T005X5 */
      pr_default.execute(3, new Object[] {Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1944MItemPadreDef), A1944MItemPadreDef});
      if ( (pr_default.getStatus(3) == 101) )
      {
         if ( ! ( (0==A1925PerfilId) || (GXutil.strcmp("", A1944MItemPadreDef)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Menu Item Padre Def", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MITEMPADREDEF");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPerfilId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(3);
      /* Using cursor T005X4 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n1957MItemIcoSVG), A1957MItemIcoSVG});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A1957MItemIcoSVG)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Item SVG", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MITEMICOSVG");
            AnyError = (short)(1) ;
            GX_FocusControl = dynMItemIcoSVG.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(2);
   }

   public void closeExtendedTableCursors5X258( )
   {
      pr_default.close(3);
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_19( byte A1925PerfilId ,
                          String A1944MItemPadreDef )
   {
      /* Using cursor T005X7 */
      pr_default.execute(5, new Object[] {Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1944MItemPadreDef), A1944MItemPadreDef});
      if ( (pr_default.getStatus(5) == 101) )
      {
         if ( ! ( (0==A1925PerfilId) || (GXutil.strcmp("", A1944MItemPadreDef)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Menu Item Padre Def", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MITEMPADREDEF");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPerfilId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(5) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(5);
   }

   public void gxload_18( String A1957MItemIcoSVG )
   {
      /* Using cursor T005X8 */
      pr_default.execute(6, new Object[] {Boolean.valueOf(n1957MItemIcoSVG), A1957MItemIcoSVG});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A1957MItemIcoSVG)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Item SVG", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MITEMICOSVG");
            AnyError = (short)(1) ;
            GX_FocusControl = dynMItemIcoSVG.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey5X258( )
   {
      /* Using cursor T005X9 */
      pr_default.execute(7, new Object[] {Byte.valueOf(A1925PerfilId), A1937MenuItemId});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound258 = (short)(1) ;
      }
      else
      {
         RcdFound258 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T005X3 */
      pr_default.execute(1, new Object[] {Byte.valueOf(A1925PerfilId), A1937MenuItemId});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm5X258( 17) ;
         RcdFound258 = (short)(1) ;
         A1937MenuItemId = T005X3_A1937MenuItemId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1937MenuItemId", A1937MenuItemId);
         A1939MenuItemTitulo = T005X3_A1939MenuItemTitulo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1939MenuItemTitulo", A1939MenuItemTitulo);
         A1938MItemEsMenu = T005X3_A1938MItemEsMenu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1938MItemEsMenu", A1938MItemEsMenu);
         A1945MItemPadreObl = T005X3_A1945MItemPadreObl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1945MItemPadreObl", A1945MItemPadreObl);
         A1958MitemIcoImg = T005X3_A1958MitemIcoImg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1958MitemIcoImg", A1958MitemIcoImg);
         httpContext.ajax_rsp_assign_prop("", false, edtMitemIcoImg_Internalname, "URL", httpContext.getResourceRelative(A1958MitemIcoImg), true);
         A1952MItemBienImgDef = T005X3_A1952MItemBienImgDef[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1952MItemBienImgDef", A1952MItemBienImgDef);
         httpContext.ajax_rsp_assign_prop("", false, edtMItemBienImgDef_Internalname, "URL", httpContext.getResourceRelative(A1952MItemBienImgDef), true);
         A1955MItemBienTitDef = T005X3_A1955MItemBienTitDef[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1955MItemBienTitDef", A1955MItemBienTitDef);
         A1956MItemBienTextDef = T005X3_A1956MItemBienTextDef[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1956MItemBienTextDef", A1956MItemBienTextDef);
         A1961MItemHelp = T005X3_A1961MItemHelp[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1961MItemHelp", A1961MItemHelp);
         A1959MItemIcoImgExt = T005X3_A1959MItemIcoImgExt[0] ;
         edtMitemIcoImg_Filetype = A1959MItemIcoImgExt ;
         httpContext.ajax_rsp_assign_prop("", false, edtMitemIcoImg_Internalname, "Filetype", edtMitemIcoImg_Filetype, true);
         A1953MItemBienImgExt = T005X3_A1953MItemBienImgExt[0] ;
         edtMItemBienImgDef_Filetype = A1953MItemBienImgExt ;
         httpContext.ajax_rsp_assign_prop("", false, edtMItemBienImgDef_Internalname, "Filetype", edtMItemBienImgDef_Filetype, true);
         A1960MitemIcoImgNom = T005X3_A1960MitemIcoImgNom[0] ;
         edtMitemIcoImg_Filename = A1960MitemIcoImgNom ;
         A1954MItemBienImgNom = T005X3_A1954MItemBienImgNom[0] ;
         edtMItemBienImgDef_Filename = A1954MItemBienImgNom ;
         A1925PerfilId = T005X3_A1925PerfilId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
         A1957MItemIcoSVG = T005X3_A1957MItemIcoSVG[0] ;
         n1957MItemIcoSVG = T005X3_n1957MItemIcoSVG[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1957MItemIcoSVG", A1957MItemIcoSVG);
         A1944MItemPadreDef = T005X3_A1944MItemPadreDef[0] ;
         n1944MItemPadreDef = T005X3_n1944MItemPadreDef[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1944MItemPadreDef", A1944MItemPadreDef);
         Z1925PerfilId = A1925PerfilId ;
         Z1937MenuItemId = A1937MenuItemId ;
         sMode258 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load5X258( ) ;
         if ( AnyError == 1 )
         {
            RcdFound258 = (short)(0) ;
            initializeNonKey5X258( ) ;
         }
         Gx_mode = sMode258 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound258 = (short)(0) ;
         initializeNonKey5X258( ) ;
         sMode258 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode258 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey5X258( ) ;
      if ( RcdFound258 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound258 = (short)(0) ;
      /* Using cursor T005X10 */
      pr_default.execute(8, new Object[] {Byte.valueOf(A1925PerfilId), Byte.valueOf(A1925PerfilId), A1937MenuItemId});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T005X10_A1925PerfilId[0] < A1925PerfilId ) || ( T005X10_A1925PerfilId[0] == A1925PerfilId ) && ( GXutil.strcmp(T005X10_A1937MenuItemId[0], A1937MenuItemId) < 0 ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T005X10_A1925PerfilId[0] > A1925PerfilId ) || ( T005X10_A1925PerfilId[0] == A1925PerfilId ) && ( GXutil.strcmp(T005X10_A1937MenuItemId[0], A1937MenuItemId) > 0 ) ) )
         {
            A1925PerfilId = T005X10_A1925PerfilId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
            A1937MenuItemId = T005X10_A1937MenuItemId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1937MenuItemId", A1937MenuItemId);
            RcdFound258 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound258 = (short)(0) ;
      /* Using cursor T005X11 */
      pr_default.execute(9, new Object[] {Byte.valueOf(A1925PerfilId), Byte.valueOf(A1925PerfilId), A1937MenuItemId});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T005X11_A1925PerfilId[0] > A1925PerfilId ) || ( T005X11_A1925PerfilId[0] == A1925PerfilId ) && ( GXutil.strcmp(T005X11_A1937MenuItemId[0], A1937MenuItemId) > 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T005X11_A1925PerfilId[0] < A1925PerfilId ) || ( T005X11_A1925PerfilId[0] == A1925PerfilId ) && ( GXutil.strcmp(T005X11_A1937MenuItemId[0], A1937MenuItemId) < 0 ) ) )
         {
            A1925PerfilId = T005X11_A1925PerfilId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
            A1937MenuItemId = T005X11_A1937MenuItemId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1937MenuItemId", A1937MenuItemId);
            RcdFound258 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey5X258( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtPerfilId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert5X258( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound258 == 1 )
         {
            if ( ( A1925PerfilId != Z1925PerfilId ) || ( GXutil.strcmp(A1937MenuItemId, Z1937MenuItemId) != 0 ) )
            {
               A1925PerfilId = Z1925PerfilId ;
               httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
               A1937MenuItemId = Z1937MenuItemId ;
               httpContext.ajax_rsp_assign_attri("", false, "A1937MenuItemId", A1937MenuItemId);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PERFILID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPerfilId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtPerfilId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update5X258( ) ;
               GX_FocusControl = edtPerfilId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A1925PerfilId != Z1925PerfilId ) || ( GXutil.strcmp(A1937MenuItemId, Z1937MenuItemId) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtPerfilId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert5X258( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "PERFILID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtPerfilId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtPerfilId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert5X258( ) ;
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
      if ( ( A1925PerfilId != Z1925PerfilId ) || ( GXutil.strcmp(A1937MenuItemId, Z1937MenuItemId) != 0 ) )
      {
         A1925PerfilId = Z1925PerfilId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
         A1937MenuItemId = Z1937MenuItemId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1937MenuItemId", A1937MenuItemId);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PERFILID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPerfilId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtPerfilId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency5X258( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T005X2 */
         pr_default.execute(0, new Object[] {Byte.valueOf(A1925PerfilId), A1937MenuItemId});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"MenuItem"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z1939MenuItemTitulo, T005X2_A1939MenuItemTitulo[0]) != 0 ) || ( Z1938MItemEsMenu != T005X2_A1938MItemEsMenu[0] ) || ( Z1945MItemPadreObl != T005X2_A1945MItemPadreObl[0] ) || ( GXutil.strcmp(Z1955MItemBienTitDef, T005X2_A1955MItemBienTitDef[0]) != 0 ) || ( GXutil.strcmp(Z1957MItemIcoSVG, T005X2_A1957MItemIcoSVG[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1944MItemPadreDef, T005X2_A1944MItemPadreDef[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z1939MenuItemTitulo, T005X2_A1939MenuItemTitulo[0]) != 0 )
            {
               GXutil.writeLogln("menuitem:[seudo value changed for attri]"+"MenuItemTitulo");
               GXutil.writeLogRaw("Old: ",Z1939MenuItemTitulo);
               GXutil.writeLogRaw("Current: ",T005X2_A1939MenuItemTitulo[0]);
            }
            if ( Z1938MItemEsMenu != T005X2_A1938MItemEsMenu[0] )
            {
               GXutil.writeLogln("menuitem:[seudo value changed for attri]"+"MItemEsMenu");
               GXutil.writeLogRaw("Old: ",Z1938MItemEsMenu);
               GXutil.writeLogRaw("Current: ",T005X2_A1938MItemEsMenu[0]);
            }
            if ( Z1945MItemPadreObl != T005X2_A1945MItemPadreObl[0] )
            {
               GXutil.writeLogln("menuitem:[seudo value changed for attri]"+"MItemPadreObl");
               GXutil.writeLogRaw("Old: ",Z1945MItemPadreObl);
               GXutil.writeLogRaw("Current: ",T005X2_A1945MItemPadreObl[0]);
            }
            if ( GXutil.strcmp(Z1955MItemBienTitDef, T005X2_A1955MItemBienTitDef[0]) != 0 )
            {
               GXutil.writeLogln("menuitem:[seudo value changed for attri]"+"MItemBienTitDef");
               GXutil.writeLogRaw("Old: ",Z1955MItemBienTitDef);
               GXutil.writeLogRaw("Current: ",T005X2_A1955MItemBienTitDef[0]);
            }
            if ( GXutil.strcmp(Z1957MItemIcoSVG, T005X2_A1957MItemIcoSVG[0]) != 0 )
            {
               GXutil.writeLogln("menuitem:[seudo value changed for attri]"+"MItemIcoSVG");
               GXutil.writeLogRaw("Old: ",Z1957MItemIcoSVG);
               GXutil.writeLogRaw("Current: ",T005X2_A1957MItemIcoSVG[0]);
            }
            if ( GXutil.strcmp(Z1944MItemPadreDef, T005X2_A1944MItemPadreDef[0]) != 0 )
            {
               GXutil.writeLogln("menuitem:[seudo value changed for attri]"+"MItemPadreDef");
               GXutil.writeLogRaw("Old: ",Z1944MItemPadreDef);
               GXutil.writeLogRaw("Current: ",T005X2_A1944MItemPadreDef[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"MenuItem"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert5X258( )
   {
      beforeValidate5X258( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5X258( ) ;
      }
      if ( AnyError == 0 )
      {
         zm5X258( 0) ;
         checkOptimisticConcurrency5X258( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5X258( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert5X258( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005X12 */
                  A1959MItemIcoImgExt = edtMitemIcoImg_Filetype ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1959MItemIcoImgExt", A1959MItemIcoImgExt);
                  A1953MItemBienImgExt = edtMItemBienImgDef_Filetype ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1953MItemBienImgExt", A1953MItemBienImgExt);
                  A1960MitemIcoImgNom = edtMitemIcoImg_Filename ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1960MitemIcoImgNom", A1960MitemIcoImgNom);
                  A1954MItemBienImgNom = edtMItemBienImgDef_Filename ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1954MItemBienImgNom", A1954MItemBienImgNom);
                  pr_default.execute(10, new Object[] {A1937MenuItemId, A1939MenuItemTitulo, Boolean.valueOf(A1938MItemEsMenu), Boolean.valueOf(A1945MItemPadreObl), A1958MitemIcoImg, A1952MItemBienImgDef, A1955MItemBienTitDef, A1956MItemBienTextDef, A1961MItemHelp, A1959MItemIcoImgExt, A1953MItemBienImgExt, A1960MitemIcoImgNom, A1954MItemBienImgNom, Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1957MItemIcoSVG), A1957MItemIcoSVG, Boolean.valueOf(n1944MItemPadreDef), A1944MItemPadreDef});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuItem");
                  if ( (pr_default.getStatus(10) == 1) )
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
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption5X0( ) ;
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
            load5X258( ) ;
         }
         endLevel5X258( ) ;
      }
      closeExtendedTableCursors5X258( ) ;
   }

   public void update5X258( )
   {
      beforeValidate5X258( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5X258( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5X258( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5X258( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate5X258( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005X13 */
                  A1959MItemIcoImgExt = edtMitemIcoImg_Filetype ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1959MItemIcoImgExt", A1959MItemIcoImgExt);
                  A1953MItemBienImgExt = edtMItemBienImgDef_Filetype ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1953MItemBienImgExt", A1953MItemBienImgExt);
                  A1960MitemIcoImgNom = edtMitemIcoImg_Filename ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1960MitemIcoImgNom", A1960MitemIcoImgNom);
                  A1954MItemBienImgNom = edtMItemBienImgDef_Filename ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1954MItemBienImgNom", A1954MItemBienImgNom);
                  pr_default.execute(11, new Object[] {A1939MenuItemTitulo, Boolean.valueOf(A1938MItemEsMenu), Boolean.valueOf(A1945MItemPadreObl), A1955MItemBienTitDef, A1956MItemBienTextDef, A1961MItemHelp, A1959MItemIcoImgExt, A1953MItemBienImgExt, A1960MitemIcoImgNom, A1954MItemBienImgNom, Boolean.valueOf(n1957MItemIcoSVG), A1957MItemIcoSVG, Boolean.valueOf(n1944MItemPadreDef), A1944MItemPadreDef, Byte.valueOf(A1925PerfilId), A1937MenuItemId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuItem");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"MenuItem"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate5X258( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
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
         endLevel5X258( ) ;
      }
      closeExtendedTableCursors5X258( ) ;
   }

   public void deferredUpdate5X258( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor T005X14 */
         pr_default.execute(12, new Object[] {A1958MitemIcoImg, Byte.valueOf(A1925PerfilId), A1937MenuItemId});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuItem");
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T005X15 */
         pr_default.execute(13, new Object[] {A1952MItemBienImgDef, Byte.valueOf(A1925PerfilId), A1937MenuItemId});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuItem");
      }
   }

   public void delete( )
   {
      beforeValidate5X258( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5X258( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls5X258( ) ;
         afterConfirm5X258( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete5X258( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T005X16 */
               pr_default.execute(14, new Object[] {Byte.valueOf(A1925PerfilId), A1937MenuItemId});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuItem");
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
      sMode258 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel5X258( ) ;
      Gx_mode = sMode258 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls5X258( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV26Pgmname = "MenuItem" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T005X17 */
         pr_default.execute(15, new Object[] {Byte.valueOf(A1925PerfilId), A1937MenuItemId});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "MenuItem", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
         /* Using cursor T005X18 */
         pr_default.execute(16, new Object[] {Byte.valueOf(A1925PerfilId), A1937MenuItemId});
         if ( (pr_default.getStatus(16) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "MenuVersionesOpciones", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
      }
   }

   public void endLevel5X258( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete5X258( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "menuitem");
         if ( AnyError == 0 )
         {
            confirmValues5X0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "menuitem");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart5X258( )
   {
      /* Scan By routine */
      /* Using cursor T005X19 */
      pr_default.execute(17);
      RcdFound258 = (short)(0) ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound258 = (short)(1) ;
         A1925PerfilId = T005X19_A1925PerfilId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
         A1937MenuItemId = T005X19_A1937MenuItemId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1937MenuItemId", A1937MenuItemId);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext5X258( )
   {
      /* Scan next routine */
      pr_default.readNext(17);
      RcdFound258 = (short)(0) ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound258 = (short)(1) ;
         A1925PerfilId = T005X19_A1925PerfilId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
         A1937MenuItemId = T005X19_A1937MenuItemId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1937MenuItemId", A1937MenuItemId);
      }
   }

   public void scanEnd5X258( )
   {
      pr_default.close(17);
   }

   public void afterConfirm5X258( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert5X258( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate5X258( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete5X258( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete5X258( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate5X258( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes5X258( )
   {
      edtPerfilId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPerfilId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPerfilId_Enabled), 5, 0), true);
      edtMenuItemId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemId_Enabled), 5, 0), true);
      edtMenuItemTitulo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMenuItemTitulo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMenuItemTitulo_Enabled), 5, 0), true);
      dynMItemIcoSVG.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynMItemIcoSVG.getInternalname(), "Enabled", GXutil.ltrimstr( dynMItemIcoSVG.getEnabled(), 5, 0), true);
      edtMitemIcoImg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMitemIcoImg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMitemIcoImg_Enabled), 5, 0), true);
      chkMItemEsMenu.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkMItemEsMenu.getInternalname(), "Enabled", GXutil.ltrimstr( chkMItemEsMenu.getEnabled(), 5, 0), true);
      edtMItemPadreDef_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMItemPadreDef_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMItemPadreDef_Enabled), 5, 0), true);
      chkMItemPadreObl.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkMItemPadreObl.getInternalname(), "Enabled", GXutil.ltrimstr( chkMItemPadreObl.getEnabled(), 5, 0), true);
      edtMItemBienTitDef_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMItemBienTitDef_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMItemBienTitDef_Enabled), 5, 0), true);
      edtMItemBienTextDef_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMItemBienTextDef_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMItemBienTextDef_Enabled), 5, 0), true);
      edtMItemBienImgDef_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMItemBienImgDef_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMItemBienImgDef_Enabled), 5, 0), true);
      edtMItemHelp_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMItemHelp_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMItemHelp_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes5X258( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues5X0( )
   {
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.menuitem", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV13PerfilId,2,0)),GXutil.URLEncode(GXutil.rtrim(AV7MenuItemId))}, new String[] {"Gx_mode","PerfilId","MenuItemId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"MenuItem");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("menuitem:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z1925PerfilId", GXutil.ltrim( localUtil.ntoc( Z1925PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1937MenuItemId", Z1937MenuItemId);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1939MenuItemTitulo", Z1939MenuItemTitulo);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1938MItemEsMenu", Z1938MItemEsMenu);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1945MItemPadreObl", Z1945MItemPadreObl);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1955MItemBienTitDef", Z1955MItemBienTitDef);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1957MItemIcoSVG", GXutil.rtrim( Z1957MItemIcoSVG));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1944MItemPadreDef", Z1944MItemPadreDef);
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N1944MItemPadreDef", A1944MItemPadreDef);
      web.GxWebStd.gx_hidden_field( httpContext, "N1957MItemIcoSVG", GXutil.rtrim( A1957MItemIcoSVG));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPERFILID", GXutil.ltrim( localUtil.ntoc( AV13PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERFILID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13PerfilId), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUITEMID", AV7MenuItemId);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUITEMID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7MenuItemId, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_MITEMPADREDEF", AV20Insert_MItemPadreDef);
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_MITEMICOSVG", GXutil.rtrim( AV22Insert_MItemIcoSVG));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MITEMICOIMGEXT", GXutil.rtrim( A1959MItemIcoImgExt));
      web.GxWebStd.gx_hidden_field( httpContext, "MITEMBIENIMGEXT", GXutil.rtrim( A1953MItemBienImgExt));
      web.GxWebStd.gx_hidden_field( httpContext, "MITEMICOIMGNOM", A1960MitemIcoImgNom);
      web.GxWebStd.gx_hidden_field( httpContext, "MITEMBIENIMGNOM", A1954MItemBienImgNom);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV26Pgmname));
      GXCCtlgxBlob = "MITEMICOIMG" + "_gxBlob" ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A1958MitemIcoImg);
      GXCCtlgxBlob = "MITEMBIENIMGDEF" + "_gxBlob" ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A1952MItemBienImgDef);
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
      web.GxWebStd.gx_hidden_field( httpContext, "MITEMICOIMG_Filetype", GXutil.rtrim( edtMitemIcoImg_Filetype));
      web.GxWebStd.gx_hidden_field( httpContext, "MITEMBIENIMGDEF_Filetype", GXutil.rtrim( edtMItemBienImgDef_Filetype));
      web.GxWebStd.gx_hidden_field( httpContext, "MITEMICOIMG_Filename", GXutil.rtrim( edtMitemIcoImg_Filename));
      web.GxWebStd.gx_hidden_field( httpContext, "MITEMBIENIMGDEF_Filename", GXutil.rtrim( edtMItemBienImgDef_Filename));
      web.GxWebStd.gx_hidden_field( httpContext, "MITEMICOIMG_Filename", GXutil.rtrim( edtMitemIcoImg_Filename));
      web.GxWebStd.gx_hidden_field( httpContext, "MITEMBIENIMGDEF_Filename", GXutil.rtrim( edtMItemBienImgDef_Filename));
      web.GxWebStd.gx_hidden_field( httpContext, "MITEMICOIMG_Filetype", GXutil.rtrim( edtMitemIcoImg_Filetype));
      web.GxWebStd.gx_hidden_field( httpContext, "MITEMBIENIMGDEF_Filetype", GXutil.rtrim( edtMItemBienImgDef_Filetype));
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
      return formatLink("web.menuitem", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV13PerfilId,2,0)),GXutil.URLEncode(GXutil.rtrim(AV7MenuItemId))}, new String[] {"Gx_mode","PerfilId","MenuItemId"})  ;
   }

   public String getPgmname( )
   {
      return "MenuItem" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Menu Item", "") ;
   }

   public void initializeNonKey5X258( )
   {
      A1944MItemPadreDef = "" ;
      n1944MItemPadreDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1944MItemPadreDef", A1944MItemPadreDef);
      n1944MItemPadreDef = ((GXutil.strcmp("", A1944MItemPadreDef)==0) ? true : false) ;
      A1957MItemIcoSVG = "" ;
      n1957MItemIcoSVG = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1957MItemIcoSVG", A1957MItemIcoSVG);
      n1957MItemIcoSVG = ((GXutil.strcmp("", A1957MItemIcoSVG)==0) ? true : false) ;
      A1939MenuItemTitulo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1939MenuItemTitulo", A1939MenuItemTitulo);
      A1945MItemPadreObl = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1945MItemPadreObl", A1945MItemPadreObl);
      A1958MitemIcoImg = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1958MitemIcoImg", A1958MitemIcoImg);
      httpContext.ajax_rsp_assign_prop("", false, edtMitemIcoImg_Internalname, "URL", httpContext.getResourceRelative(A1958MitemIcoImg), true);
      A1952MItemBienImgDef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1952MItemBienImgDef", A1952MItemBienImgDef);
      httpContext.ajax_rsp_assign_prop("", false, edtMItemBienImgDef_Internalname, "URL", httpContext.getResourceRelative(A1952MItemBienImgDef), true);
      A1955MItemBienTitDef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1955MItemBienTitDef", A1955MItemBienTitDef);
      A1956MItemBienTextDef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1956MItemBienTextDef", A1956MItemBienTextDef);
      A1961MItemHelp = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1961MItemHelp", A1961MItemHelp);
      A1959MItemIcoImgExt = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1959MItemIcoImgExt", A1959MItemIcoImgExt);
      A1953MItemBienImgExt = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1953MItemBienImgExt", A1953MItemBienImgExt);
      A1960MitemIcoImgNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1960MitemIcoImgNom", A1960MitemIcoImgNom);
      A1954MItemBienImgNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1954MItemBienImgNom", A1954MItemBienImgNom);
      A1938MItemEsMenu = true ;
      httpContext.ajax_rsp_assign_attri("", false, "A1938MItemEsMenu", A1938MItemEsMenu);
      Z1939MenuItemTitulo = "" ;
      Z1938MItemEsMenu = false ;
      Z1945MItemPadreObl = false ;
      Z1955MItemBienTitDef = "" ;
      Z1957MItemIcoSVG = "" ;
      Z1944MItemPadreDef = "" ;
   }

   public void initAll5X258( )
   {
      A1925PerfilId = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
      A1937MenuItemId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1937MenuItemId", A1937MenuItemId);
      initializeNonKey5X258( ) ;
   }

   public void standaloneModalInsert( )
   {
      A1938MItemEsMenu = i1938MItemEsMenu ;
      httpContext.ajax_rsp_assign_attri("", false, "A1938MItemEsMenu", A1938MItemEsMenu);
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025187482780", true, true);
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
      httpContext.AddJavascriptSource("menuitem.js", "?2025187482780", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtPerfilId_Internalname = "PERFILID" ;
      edtMenuItemId_Internalname = "MENUITEMID" ;
      edtMenuItemTitulo_Internalname = "MENUITEMTITULO" ;
      dynMItemIcoSVG.setInternalname( "MITEMICOSVG" );
      edtMitemIcoImg_Internalname = "MITEMICOIMG" ;
      chkMItemEsMenu.setInternalname( "MITEMESMENU" );
      edtMItemPadreDef_Internalname = "MITEMPADREDEF" ;
      chkMItemPadreObl.setInternalname( "MITEMPADREOBL" );
      edtMItemBienTitDef_Internalname = "MITEMBIENTITDEF" ;
      edtMItemBienTextDef_Internalname = "MITEMBIENTEXTDEF" ;
      edtMItemBienImgDef_Internalname = "MITEMBIENIMGDEF" ;
      edtMItemHelp_Internalname = "MITEMHELP" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
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
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Menu Item", "") );
      edtMItemBienImgDef_Filename = "" ;
      edtMitemIcoImg_Filename = "" ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtMItemHelp_Enabled = 1 ;
      edtMItemBienImgDef_Jsonclick = "" ;
      edtMItemBienImgDef_Parameters = "" ;
      edtMItemBienImgDef_Contenttype = "" ;
      edtMItemBienImgDef_Filetype = "" ;
      edtMItemBienImgDef_Enabled = 1 ;
      edtMItemBienTextDef_Enabled = 1 ;
      edtMItemBienTitDef_Enabled = 1 ;
      chkMItemPadreObl.setEnabled( 1 );
      edtMItemPadreDef_Jsonclick = "" ;
      edtMItemPadreDef_Enabled = 1 ;
      chkMItemEsMenu.setEnabled( 1 );
      edtMitemIcoImg_Jsonclick = "" ;
      edtMitemIcoImg_Parameters = "" ;
      edtMitemIcoImg_Contenttype = "" ;
      edtMitemIcoImg_Filetype = "" ;
      edtMitemIcoImg_Enabled = 1 ;
      dynMItemIcoSVG.setJsonclick( "" );
      dynMItemIcoSVG.setEnabled( 1 );
      edtMenuItemTitulo_Enabled = 1 ;
      edtMenuItemId_Jsonclick = "" ;
      edtMenuItemId_Enabled = 1 ;
      edtPerfilId_Jsonclick = "" ;
      edtPerfilId_Enabled = 1 ;
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

   public void gxdlamitemicosvg5X258( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlamitemicosvg_data5X258( ) ;
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

   public void gxamitemicosvg_html5X258( )
   {
      String gxdynajaxvalue;
      gxdlamitemicosvg_data5X258( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynMItemIcoSVG.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynMItemIcoSVG.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlamitemicosvg_data5X258( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T005X20 */
      pr_default.execute(18);
      while ( (pr_default.getStatus(18) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T005X20_A1957MItemIcoSVG[0]));
         gxdynajaxctrldescr.add(GXutil.rtrim( T005X20_A1957MItemIcoSVG[0]));
         pr_default.readNext(18);
      }
      pr_default.close(18);
   }

   public void init_web_controls( )
   {
      dynMItemIcoSVG.setName( "MITEMICOSVG" );
      dynMItemIcoSVG.setWebtags( "" );
      chkMItemEsMenu.setName( "MITEMESMENU" );
      chkMItemEsMenu.setWebtags( "" );
      chkMItemEsMenu.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkMItemEsMenu.getInternalname(), "TitleCaption", chkMItemEsMenu.getCaption(), true);
      chkMItemEsMenu.setCheckedValue( "false" );
      if ( isIns( ) && (false==A1938MItemEsMenu) )
      {
         A1938MItemEsMenu = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A1938MItemEsMenu", A1938MItemEsMenu);
      }
      chkMItemPadreObl.setName( "MITEMPADREOBL" );
      chkMItemPadreObl.setWebtags( "" );
      chkMItemPadreObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkMItemPadreObl.getInternalname(), "TitleCaption", chkMItemPadreObl.getCaption(), true);
      chkMItemPadreObl.setCheckedValue( "false" );
      A1945MItemPadreObl = GXutil.strtobool( GXutil.booltostr( A1945MItemPadreObl)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1945MItemPadreObl", A1945MItemPadreObl);
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

   public void valid_Mitemicosvg( )
   {
      n1957MItemIcoSVG = false ;
      A1957MItemIcoSVG = dynMItemIcoSVG.getValue() ;
      n1957MItemIcoSVG = false ;
      /* Using cursor T005X21 */
      pr_default.execute(19, new Object[] {Boolean.valueOf(n1957MItemIcoSVG), A1957MItemIcoSVG});
      if ( (pr_default.getStatus(19) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A1957MItemIcoSVG)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Item SVG", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MITEMICOSVG");
            AnyError = (short)(1) ;
            GX_FocusControl = dynMItemIcoSVG.getInternalname() ;
         }
      }
      pr_default.close(19);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Mitempadredef( )
   {
      n1944MItemPadreDef = false ;
      n1957MItemIcoSVG = false ;
      A1957MItemIcoSVG = dynMItemIcoSVG.getValue() ;
      n1957MItemIcoSVG = false ;
      /* Using cursor T005X22 */
      pr_default.execute(20, new Object[] {Byte.valueOf(A1925PerfilId), Boolean.valueOf(n1944MItemPadreDef), A1944MItemPadreDef});
      if ( (pr_default.getStatus(20) == 101) )
      {
         if ( ! ( (0==A1925PerfilId) || (GXutil.strcmp("", A1944MItemPadreDef)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Menu Item Padre Def", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MITEMPADREDEF");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPerfilId_Internalname ;
         }
      }
      pr_default.close(20);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV13PerfilId',fld:'vPERFILID',pic:'Z9',hsh:true},{av:'AV7MenuItemId',fld:'vMENUITEMID',pic:'',hsh:true},{av:'dynMItemIcoSVG'},{av:'A1957MItemIcoSVG',fld:'MITEMICOSVG',pic:''},{av:'A1938MItemEsMenu',fld:'MITEMESMENU',pic:''},{av:'A1945MItemPadreObl',fld:'MITEMPADREOBL',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'dynMItemIcoSVG'},{av:'A1957MItemIcoSVG',fld:'MITEMICOSVG',pic:''},{av:'A1938MItemEsMenu',fld:'MITEMESMENU',pic:''},{av:'A1945MItemPadreObl',fld:'MITEMPADREOBL',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV13PerfilId',fld:'vPERFILID',pic:'Z9',hsh:true},{av:'AV7MenuItemId',fld:'vMENUITEMID',pic:'',hsh:true},{av:'dynMItemIcoSVG'},{av:'A1957MItemIcoSVG',fld:'MITEMICOSVG',pic:''},{av:'A1938MItemEsMenu',fld:'MITEMESMENU',pic:''},{av:'A1945MItemPadreObl',fld:'MITEMPADREOBL',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'dynMItemIcoSVG'},{av:'A1957MItemIcoSVG',fld:'MITEMICOSVG',pic:''},{av:'A1938MItemEsMenu',fld:'MITEMESMENU',pic:''},{av:'A1945MItemPadreObl',fld:'MITEMPADREOBL',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e125X2',iparms:[{av:'dynMItemIcoSVG'},{av:'A1957MItemIcoSVG',fld:'MITEMICOSVG',pic:''},{av:'A1938MItemEsMenu',fld:'MITEMESMENU',pic:''},{av:'A1945MItemPadreObl',fld:'MITEMPADREOBL',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'dynMItemIcoSVG'},{av:'A1957MItemIcoSVG',fld:'MITEMICOSVG',pic:''},{av:'A1938MItemEsMenu',fld:'MITEMESMENU',pic:''},{av:'A1945MItemPadreObl',fld:'MITEMPADREOBL',pic:''}]}");
      setEventMetadata("VALID_PERFILID","{handler:'valid_Perfilid',iparms:[{av:'dynMItemIcoSVG'},{av:'A1957MItemIcoSVG',fld:'MITEMICOSVG',pic:''},{av:'A1938MItemEsMenu',fld:'MITEMESMENU',pic:''},{av:'A1945MItemPadreObl',fld:'MITEMPADREOBL',pic:''}]");
      setEventMetadata("VALID_PERFILID",",oparms:[{av:'dynMItemIcoSVG'},{av:'A1957MItemIcoSVG',fld:'MITEMICOSVG',pic:''},{av:'A1938MItemEsMenu',fld:'MITEMESMENU',pic:''},{av:'A1945MItemPadreObl',fld:'MITEMPADREOBL',pic:''}]}");
      setEventMetadata("VALID_MENUITEMID","{handler:'valid_Menuitemid',iparms:[{av:'dynMItemIcoSVG'},{av:'A1957MItemIcoSVG',fld:'MITEMICOSVG',pic:''},{av:'A1938MItemEsMenu',fld:'MITEMESMENU',pic:''},{av:'A1945MItemPadreObl',fld:'MITEMPADREOBL',pic:''}]");
      setEventMetadata("VALID_MENUITEMID",",oparms:[{av:'dynMItemIcoSVG'},{av:'A1957MItemIcoSVG',fld:'MITEMICOSVG',pic:''},{av:'A1938MItemEsMenu',fld:'MITEMESMENU',pic:''},{av:'A1945MItemPadreObl',fld:'MITEMPADREOBL',pic:''}]}");
      setEventMetadata("VALID_MITEMICOSVG","{handler:'valid_Mitemicosvg',iparms:[{av:'dynMItemIcoSVG'},{av:'A1957MItemIcoSVG',fld:'MITEMICOSVG',pic:''},{av:'A1938MItemEsMenu',fld:'MITEMESMENU',pic:''},{av:'A1945MItemPadreObl',fld:'MITEMPADREOBL',pic:''}]");
      setEventMetadata("VALID_MITEMICOSVG",",oparms:[{av:'dynMItemIcoSVG'},{av:'A1957MItemIcoSVG',fld:'MITEMICOSVG',pic:''},{av:'A1938MItemEsMenu',fld:'MITEMESMENU',pic:''},{av:'A1945MItemPadreObl',fld:'MITEMPADREOBL',pic:''}]}");
      setEventMetadata("VALID_MITEMPADREDEF","{handler:'valid_Mitempadredef',iparms:[{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'},{av:'A1944MItemPadreDef',fld:'MITEMPADREDEF',pic:''},{av:'dynMItemIcoSVG'},{av:'A1957MItemIcoSVG',fld:'MITEMICOSVG',pic:''},{av:'A1938MItemEsMenu',fld:'MITEMESMENU',pic:''},{av:'A1945MItemPadreObl',fld:'MITEMPADREOBL',pic:''}]");
      setEventMetadata("VALID_MITEMPADREDEF",",oparms:[{av:'dynMItemIcoSVG'},{av:'A1957MItemIcoSVG',fld:'MITEMICOSVG',pic:''},{av:'A1938MItemEsMenu',fld:'MITEMESMENU',pic:''},{av:'A1945MItemPadreObl',fld:'MITEMPADREOBL',pic:''}]}");
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
      pr_default.close(19);
      pr_default.close(20);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV7MenuItemId = "" ;
      Z1937MenuItemId = "" ;
      Z1939MenuItemTitulo = "" ;
      Z1955MItemBienTitDef = "" ;
      Z1957MItemIcoSVG = "" ;
      Z1944MItemPadreDef = "" ;
      N1944MItemPadreDef = "" ;
      N1957MItemIcoSVG = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A1944MItemPadreDef = "" ;
      A1957MItemIcoSVG = "" ;
      Gx_mode = "" ;
      AV7MenuItemId = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A1937MenuItemId = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A1939MenuItemTitulo = "" ;
      A1960MitemIcoImgNom = "" ;
      A1959MItemIcoImgExt = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      A1958MitemIcoImg = "" ;
      A1955MItemBienTitDef = "" ;
      A1956MItemBienTextDef = "" ;
      A1954MItemBienImgNom = "" ;
      A1953MItemBienImgExt = "" ;
      A1952MItemBienImgDef = "" ;
      A1961MItemHelp = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV20Insert_MItemPadreDef = "" ;
      AV22Insert_MItemIcoSVG = "" ;
      AV26Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      GXCCtlgxBlob = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode258 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV8WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV11TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      AV21TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z1958MitemIcoImg = "" ;
      Z1952MItemBienImgDef = "" ;
      Z1956MItemBienTextDef = "" ;
      Z1961MItemHelp = "" ;
      Z1959MItemIcoImgExt = "" ;
      Z1953MItemBienImgExt = "" ;
      Z1960MitemIcoImgNom = "" ;
      Z1954MItemBienImgNom = "" ;
      T005X6_A1937MenuItemId = new String[] {""} ;
      T005X6_A1939MenuItemTitulo = new String[] {""} ;
      T005X6_A1938MItemEsMenu = new boolean[] {false} ;
      T005X6_A1945MItemPadreObl = new boolean[] {false} ;
      T005X6_A1958MitemIcoImg = new String[] {""} ;
      T005X6_A1952MItemBienImgDef = new String[] {""} ;
      T005X6_A1955MItemBienTitDef = new String[] {""} ;
      T005X6_A1956MItemBienTextDef = new String[] {""} ;
      T005X6_A1961MItemHelp = new String[] {""} ;
      T005X6_A1959MItemIcoImgExt = new String[] {""} ;
      T005X6_A1953MItemBienImgExt = new String[] {""} ;
      T005X6_A1960MitemIcoImgNom = new String[] {""} ;
      T005X6_A1954MItemBienImgNom = new String[] {""} ;
      T005X6_A1925PerfilId = new byte[1] ;
      T005X6_A1957MItemIcoSVG = new String[] {""} ;
      T005X6_n1957MItemIcoSVG = new boolean[] {false} ;
      T005X6_A1944MItemPadreDef = new String[] {""} ;
      T005X6_n1944MItemPadreDef = new boolean[] {false} ;
      T005X5_A1925PerfilId = new byte[1] ;
      T005X4_A1957MItemIcoSVG = new String[] {""} ;
      T005X4_n1957MItemIcoSVG = new boolean[] {false} ;
      T005X7_A1925PerfilId = new byte[1] ;
      T005X8_A1957MItemIcoSVG = new String[] {""} ;
      T005X8_n1957MItemIcoSVG = new boolean[] {false} ;
      T005X9_A1925PerfilId = new byte[1] ;
      T005X9_A1937MenuItemId = new String[] {""} ;
      T005X3_A1937MenuItemId = new String[] {""} ;
      T005X3_A1939MenuItemTitulo = new String[] {""} ;
      T005X3_A1938MItemEsMenu = new boolean[] {false} ;
      T005X3_A1945MItemPadreObl = new boolean[] {false} ;
      T005X3_A1958MitemIcoImg = new String[] {""} ;
      T005X3_A1952MItemBienImgDef = new String[] {""} ;
      T005X3_A1955MItemBienTitDef = new String[] {""} ;
      T005X3_A1956MItemBienTextDef = new String[] {""} ;
      T005X3_A1961MItemHelp = new String[] {""} ;
      T005X3_A1959MItemIcoImgExt = new String[] {""} ;
      T005X3_A1953MItemBienImgExt = new String[] {""} ;
      T005X3_A1960MitemIcoImgNom = new String[] {""} ;
      T005X3_A1954MItemBienImgNom = new String[] {""} ;
      T005X3_A1925PerfilId = new byte[1] ;
      T005X3_A1957MItemIcoSVG = new String[] {""} ;
      T005X3_n1957MItemIcoSVG = new boolean[] {false} ;
      T005X3_A1944MItemPadreDef = new String[] {""} ;
      T005X3_n1944MItemPadreDef = new boolean[] {false} ;
      T005X10_A1925PerfilId = new byte[1] ;
      T005X10_A1937MenuItemId = new String[] {""} ;
      T005X11_A1925PerfilId = new byte[1] ;
      T005X11_A1937MenuItemId = new String[] {""} ;
      T005X2_A1937MenuItemId = new String[] {""} ;
      T005X2_A1939MenuItemTitulo = new String[] {""} ;
      T005X2_A1938MItemEsMenu = new boolean[] {false} ;
      T005X2_A1945MItemPadreObl = new boolean[] {false} ;
      T005X2_A1958MitemIcoImg = new String[] {""} ;
      T005X2_A1952MItemBienImgDef = new String[] {""} ;
      T005X2_A1955MItemBienTitDef = new String[] {""} ;
      T005X2_A1956MItemBienTextDef = new String[] {""} ;
      T005X2_A1961MItemHelp = new String[] {""} ;
      T005X2_A1959MItemIcoImgExt = new String[] {""} ;
      T005X2_A1953MItemBienImgExt = new String[] {""} ;
      T005X2_A1960MitemIcoImgNom = new String[] {""} ;
      T005X2_A1954MItemBienImgNom = new String[] {""} ;
      T005X2_A1925PerfilId = new byte[1] ;
      T005X2_A1957MItemIcoSVG = new String[] {""} ;
      T005X2_n1957MItemIcoSVG = new boolean[] {false} ;
      T005X2_A1944MItemPadreDef = new String[] {""} ;
      T005X2_n1944MItemPadreDef = new boolean[] {false} ;
      T005X17_A1925PerfilId = new byte[1] ;
      T005X17_A1944MItemPadreDef = new String[] {""} ;
      T005X17_n1944MItemPadreDef = new boolean[] {false} ;
      T005X18_A1923RolId = new byte[1] ;
      T005X18_A1925PerfilId = new byte[1] ;
      T005X18_A1928MenuVerId = new long[1] ;
      T005X18_A1929MenuOpcCod = new String[] {""} ;
      T005X19_A1925PerfilId = new byte[1] ;
      T005X19_A1937MenuItemId = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T005X20_A1957MItemIcoSVG = new String[] {""} ;
      T005X20_n1957MItemIcoSVG = new boolean[] {false} ;
      T005X21_A1957MItemIcoSVG = new String[] {""} ;
      T005X21_n1957MItemIcoSVG = new boolean[] {false} ;
      T005X22_A1925PerfilId = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.menuitem__default(),
         new Object[] {
             new Object[] {
            T005X2_A1937MenuItemId, T005X2_A1939MenuItemTitulo, T005X2_A1938MItemEsMenu, T005X2_A1945MItemPadreObl, T005X2_A1958MitemIcoImg, T005X2_A1952MItemBienImgDef, T005X2_A1955MItemBienTitDef, T005X2_A1956MItemBienTextDef, T005X2_A1961MItemHelp, T005X2_A1959MItemIcoImgExt,
            T005X2_A1953MItemBienImgExt, T005X2_A1960MitemIcoImgNom, T005X2_A1954MItemBienImgNom, T005X2_A1925PerfilId, T005X2_A1957MItemIcoSVG, T005X2_n1957MItemIcoSVG, T005X2_A1944MItemPadreDef, T005X2_n1944MItemPadreDef
            }
            , new Object[] {
            T005X3_A1937MenuItemId, T005X3_A1939MenuItemTitulo, T005X3_A1938MItemEsMenu, T005X3_A1945MItemPadreObl, T005X3_A1958MitemIcoImg, T005X3_A1952MItemBienImgDef, T005X3_A1955MItemBienTitDef, T005X3_A1956MItemBienTextDef, T005X3_A1961MItemHelp, T005X3_A1959MItemIcoImgExt,
            T005X3_A1953MItemBienImgExt, T005X3_A1960MitemIcoImgNom, T005X3_A1954MItemBienImgNom, T005X3_A1925PerfilId, T005X3_A1957MItemIcoSVG, T005X3_n1957MItemIcoSVG, T005X3_A1944MItemPadreDef, T005X3_n1944MItemPadreDef
            }
            , new Object[] {
            T005X4_A1957MItemIcoSVG
            }
            , new Object[] {
            T005X5_A1925PerfilId
            }
            , new Object[] {
            T005X6_A1937MenuItemId, T005X6_A1939MenuItemTitulo, T005X6_A1938MItemEsMenu, T005X6_A1945MItemPadreObl, T005X6_A1958MitemIcoImg, T005X6_A1952MItemBienImgDef, T005X6_A1955MItemBienTitDef, T005X6_A1956MItemBienTextDef, T005X6_A1961MItemHelp, T005X6_A1959MItemIcoImgExt,
            T005X6_A1953MItemBienImgExt, T005X6_A1960MitemIcoImgNom, T005X6_A1954MItemBienImgNom, T005X6_A1925PerfilId, T005X6_A1957MItemIcoSVG, T005X6_n1957MItemIcoSVG, T005X6_A1944MItemPadreDef, T005X6_n1944MItemPadreDef
            }
            , new Object[] {
            T005X7_A1925PerfilId
            }
            , new Object[] {
            T005X8_A1957MItemIcoSVG
            }
            , new Object[] {
            T005X9_A1925PerfilId, T005X9_A1937MenuItemId
            }
            , new Object[] {
            T005X10_A1925PerfilId, T005X10_A1937MenuItemId
            }
            , new Object[] {
            T005X11_A1925PerfilId, T005X11_A1937MenuItemId
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
            T005X17_A1925PerfilId, T005X17_A1944MItemPadreDef
            }
            , new Object[] {
            T005X18_A1923RolId, T005X18_A1925PerfilId, T005X18_A1928MenuVerId, T005X18_A1929MenuOpcCod
            }
            , new Object[] {
            T005X19_A1925PerfilId, T005X19_A1937MenuItemId
            }
            , new Object[] {
            T005X20_A1957MItemIcoSVG
            }
            , new Object[] {
            T005X21_A1957MItemIcoSVG
            }
            , new Object[] {
            T005X22_A1925PerfilId
            }
         }
      );
      AV26Pgmname = "MenuItem" ;
      Z1938MItemEsMenu = true ;
      A1938MItemEsMenu = true ;
      i1938MItemEsMenu = true ;
   }

   private byte wcpOAV13PerfilId ;
   private byte Z1925PerfilId ;
   private byte GxWebError ;
   private byte A1925PerfilId ;
   private byte AV13PerfilId ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound258 ;
   private short nIsDirty_258 ;
   private int trnEnded ;
   private int edtPerfilId_Enabled ;
   private int edtMenuItemId_Enabled ;
   private int edtMenuItemTitulo_Enabled ;
   private int edtMitemIcoImg_Enabled ;
   private int edtMItemPadreDef_Enabled ;
   private int edtMItemBienTitDef_Enabled ;
   private int edtMItemBienTextDef_Enabled ;
   private int edtMItemBienImgDef_Enabled ;
   private int edtMItemHelp_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV27GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z1957MItemIcoSVG ;
   private String N1957MItemIcoSVG ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A1957MItemIcoSVG ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtPerfilId_Internalname ;
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
   private String edtPerfilId_Jsonclick ;
   private String edtMenuItemId_Internalname ;
   private String edtMenuItemId_Jsonclick ;
   private String edtMenuItemTitulo_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtMitemIcoImg_Internalname ;
   private String edtMitemIcoImg_Filename ;
   private String edtMitemIcoImg_Filetype ;
   private String A1959MItemIcoImgExt ;
   private String edtMitemIcoImg_Contenttype ;
   private String edtMitemIcoImg_Parameters ;
   private String edtMitemIcoImg_Jsonclick ;
   private String edtMItemPadreDef_Internalname ;
   private String edtMItemPadreDef_Jsonclick ;
   private String edtMItemBienTitDef_Internalname ;
   private String edtMItemBienTextDef_Internalname ;
   private String edtMItemBienImgDef_Internalname ;
   private String edtMItemBienImgDef_Filename ;
   private String edtMItemBienImgDef_Filetype ;
   private String A1953MItemBienImgExt ;
   private String edtMItemBienImgDef_Contenttype ;
   private String edtMItemBienImgDef_Parameters ;
   private String edtMItemBienImgDef_Jsonclick ;
   private String edtMItemHelp_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String AV22Insert_MItemIcoSVG ;
   private String AV26Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String GXCCtlgxBlob ;
   private String hsh ;
   private String sMode258 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z1959MItemIcoImgExt ;
   private String Z1953MItemBienImgExt ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String gxwrpcisep ;
   private boolean Z1938MItemEsMenu ;
   private boolean Z1945MItemPadreObl ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n1944MItemPadreDef ;
   private boolean n1957MItemIcoSVG ;
   private boolean wbErr ;
   private boolean A1938MItemEsMenu ;
   private boolean A1945MItemPadreObl ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Gx_longc ;
   private boolean i1938MItemEsMenu ;
   private boolean gxdyncontrolsrefreshing ;
   private String A1956MItemBienTextDef ;
   private String A1961MItemHelp ;
   private String Z1956MItemBienTextDef ;
   private String Z1961MItemHelp ;
   private String A1958MitemIcoImg ;
   private String A1952MItemBienImgDef ;
   private String Z1958MitemIcoImg ;
   private String Z1952MItemBienImgDef ;
   private String wcpOAV7MenuItemId ;
   private String Z1937MenuItemId ;
   private String Z1939MenuItemTitulo ;
   private String Z1955MItemBienTitDef ;
   private String Z1944MItemPadreDef ;
   private String N1944MItemPadreDef ;
   private String A1944MItemPadreDef ;
   private String AV7MenuItemId ;
   private String A1937MenuItemId ;
   private String A1939MenuItemTitulo ;
   private String A1960MitemIcoImgNom ;
   private String A1955MItemBienTitDef ;
   private String A1954MItemBienImgNom ;
   private String AV20Insert_MItemPadreDef ;
   private String Z1960MitemIcoImgNom ;
   private String Z1954MItemBienImgNom ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynMItemIcoSVG ;
   private ICheckbox chkMItemEsMenu ;
   private ICheckbox chkMItemPadreObl ;
   private IDataStoreProvider pr_default ;
   private String[] T005X6_A1937MenuItemId ;
   private String[] T005X6_A1939MenuItemTitulo ;
   private boolean[] T005X6_A1938MItemEsMenu ;
   private boolean[] T005X6_A1945MItemPadreObl ;
   private String[] T005X6_A1958MitemIcoImg ;
   private String[] T005X6_A1952MItemBienImgDef ;
   private String[] T005X6_A1955MItemBienTitDef ;
   private String[] T005X6_A1956MItemBienTextDef ;
   private String[] T005X6_A1961MItemHelp ;
   private String[] T005X6_A1959MItemIcoImgExt ;
   private String[] T005X6_A1953MItemBienImgExt ;
   private String[] T005X6_A1960MitemIcoImgNom ;
   private String[] T005X6_A1954MItemBienImgNom ;
   private byte[] T005X6_A1925PerfilId ;
   private String[] T005X6_A1957MItemIcoSVG ;
   private boolean[] T005X6_n1957MItemIcoSVG ;
   private String[] T005X6_A1944MItemPadreDef ;
   private boolean[] T005X6_n1944MItemPadreDef ;
   private byte[] T005X5_A1925PerfilId ;
   private String[] T005X4_A1957MItemIcoSVG ;
   private boolean[] T005X4_n1957MItemIcoSVG ;
   private byte[] T005X7_A1925PerfilId ;
   private String[] T005X8_A1957MItemIcoSVG ;
   private boolean[] T005X8_n1957MItemIcoSVG ;
   private byte[] T005X9_A1925PerfilId ;
   private String[] T005X9_A1937MenuItemId ;
   private String[] T005X3_A1937MenuItemId ;
   private String[] T005X3_A1939MenuItemTitulo ;
   private boolean[] T005X3_A1938MItemEsMenu ;
   private boolean[] T005X3_A1945MItemPadreObl ;
   private String[] T005X3_A1958MitemIcoImg ;
   private String[] T005X3_A1952MItemBienImgDef ;
   private String[] T005X3_A1955MItemBienTitDef ;
   private String[] T005X3_A1956MItemBienTextDef ;
   private String[] T005X3_A1961MItemHelp ;
   private String[] T005X3_A1959MItemIcoImgExt ;
   private String[] T005X3_A1953MItemBienImgExt ;
   private String[] T005X3_A1960MitemIcoImgNom ;
   private String[] T005X3_A1954MItemBienImgNom ;
   private byte[] T005X3_A1925PerfilId ;
   private String[] T005X3_A1957MItemIcoSVG ;
   private boolean[] T005X3_n1957MItemIcoSVG ;
   private String[] T005X3_A1944MItemPadreDef ;
   private boolean[] T005X3_n1944MItemPadreDef ;
   private byte[] T005X10_A1925PerfilId ;
   private String[] T005X10_A1937MenuItemId ;
   private byte[] T005X11_A1925PerfilId ;
   private String[] T005X11_A1937MenuItemId ;
   private String[] T005X2_A1937MenuItemId ;
   private String[] T005X2_A1939MenuItemTitulo ;
   private boolean[] T005X2_A1938MItemEsMenu ;
   private boolean[] T005X2_A1945MItemPadreObl ;
   private String[] T005X2_A1958MitemIcoImg ;
   private String[] T005X2_A1952MItemBienImgDef ;
   private String[] T005X2_A1955MItemBienTitDef ;
   private String[] T005X2_A1956MItemBienTextDef ;
   private String[] T005X2_A1961MItemHelp ;
   private String[] T005X2_A1959MItemIcoImgExt ;
   private String[] T005X2_A1953MItemBienImgExt ;
   private String[] T005X2_A1960MitemIcoImgNom ;
   private String[] T005X2_A1954MItemBienImgNom ;
   private byte[] T005X2_A1925PerfilId ;
   private String[] T005X2_A1957MItemIcoSVG ;
   private boolean[] T005X2_n1957MItemIcoSVG ;
   private String[] T005X2_A1944MItemPadreDef ;
   private boolean[] T005X2_n1944MItemPadreDef ;
   private byte[] T005X17_A1925PerfilId ;
   private String[] T005X17_A1944MItemPadreDef ;
   private boolean[] T005X17_n1944MItemPadreDef ;
   private byte[] T005X18_A1923RolId ;
   private byte[] T005X18_A1925PerfilId ;
   private long[] T005X18_A1928MenuVerId ;
   private String[] T005X18_A1929MenuOpcCod ;
   private byte[] T005X19_A1925PerfilId ;
   private String[] T005X19_A1937MenuItemId ;
   private String[] T005X20_A1957MItemIcoSVG ;
   private boolean[] T005X20_n1957MItemIcoSVG ;
   private String[] T005X21_A1957MItemIcoSVG ;
   private boolean[] T005X21_n1957MItemIcoSVG ;
   private byte[] T005X22_A1925PerfilId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV21TrnContextAtt ;
}

final  class menuitem__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T005X2", "SELECT MenuItemId, MenuItemTitulo, MItemEsMenu, MItemPadreObl, MitemIcoImg, MItemBienImgDef, MItemBienTitDef, MItemBienTextDef, MItemHelp, MItemIcoImgExt, MItemBienImgExt, MitemIcoImgNom, MItemBienImgNom, PerfilId, MItemIcoSVG, MItemPadreDef FROM MenuItem WHERE PerfilId = ? AND MenuItemId = ?  FOR UPDATE OF MenuItem NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005X3", "SELECT MenuItemId, MenuItemTitulo, MItemEsMenu, MItemPadreObl, MitemIcoImg, MItemBienImgDef, MItemBienTitDef, MItemBienTextDef, MItemHelp, MItemIcoImgExt, MItemBienImgExt, MitemIcoImgNom, MItemBienImgNom, PerfilId, MItemIcoSVG, MItemPadreDef FROM MenuItem WHERE PerfilId = ? AND MenuItemId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005X4", "SELECT SVGId AS MItemIcoSVG FROM SVG WHERE SVGId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005X5", "SELECT PerfilId FROM MenuItem WHERE PerfilId = ? AND MenuItemId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005X6", "SELECT TM1.MenuItemId, TM1.MenuItemTitulo, TM1.MItemEsMenu, TM1.MItemPadreObl, TM1.MitemIcoImg, TM1.MItemBienImgDef, TM1.MItemBienTitDef, TM1.MItemBienTextDef, TM1.MItemHelp, TM1.MItemIcoImgExt, TM1.MItemBienImgExt, TM1.MitemIcoImgNom, TM1.MItemBienImgNom, TM1.PerfilId, TM1.MItemIcoSVG AS MItemIcoSVG, TM1.MItemPadreDef AS MItemPadreDef FROM MenuItem TM1 WHERE TM1.PerfilId = ? and TM1.MenuItemId = ( ?) ORDER BY TM1.PerfilId, TM1.MenuItemId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005X7", "SELECT PerfilId FROM MenuItem WHERE PerfilId = ? AND MenuItemId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005X8", "SELECT SVGId AS MItemIcoSVG FROM SVG WHERE SVGId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005X9", "SELECT PerfilId, MenuItemId FROM MenuItem WHERE PerfilId = ? AND MenuItemId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005X10", "SELECT PerfilId, MenuItemId FROM MenuItem WHERE ( PerfilId > ? or PerfilId = ? and MenuItemId > ( ?)) ORDER BY PerfilId, MenuItemId  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005X11", "SELECT PerfilId, MenuItemId FROM MenuItem WHERE ( PerfilId < ? or PerfilId = ? and MenuItemId < ( ?)) ORDER BY PerfilId DESC, MenuItemId DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T005X12", "SAVEPOINT gxupdate;INSERT INTO MenuItem(MenuItemId, MenuItemTitulo, MItemEsMenu, MItemPadreObl, MitemIcoImg, MItemBienImgDef, MItemBienTitDef, MItemBienTextDef, MItemHelp, MItemIcoImgExt, MItemBienImgExt, MitemIcoImgNom, MItemBienImgNom, PerfilId, MItemIcoSVG, MItemPadreDef) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005X13", "SAVEPOINT gxupdate;UPDATE MenuItem SET MenuItemTitulo=?, MItemEsMenu=?, MItemPadreObl=?, MItemBienTitDef=?, MItemBienTextDef=?, MItemHelp=?, MItemIcoImgExt=?, MItemBienImgExt=?, MitemIcoImgNom=?, MItemBienImgNom=?, MItemIcoSVG=?, MItemPadreDef=?  WHERE PerfilId = ? AND MenuItemId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005X14", "SAVEPOINT gxupdate;UPDATE MenuItem SET MitemIcoImg=?  WHERE PerfilId = ? AND MenuItemId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005X15", "SAVEPOINT gxupdate;UPDATE MenuItem SET MItemBienImgDef=?  WHERE PerfilId = ? AND MenuItemId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005X16", "SAVEPOINT gxupdate;DELETE FROM MenuItem  WHERE PerfilId = ? AND MenuItemId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005X17", "SELECT PerfilId, MenuItemId AS MItemPadreDef FROM MenuItem WHERE PerfilId = ? AND MItemPadreDef = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005X18", "SELECT RolId, PerfilId, MenuVerId, MenuOpcCod FROM MenuVersionesOpciones WHERE PerfilId = ? AND MenuItemId = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005X19", "SELECT PerfilId, MenuItemId FROM MenuItem ORDER BY PerfilId, MenuItemId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005X20", "SELECT SVGId AS MItemIcoSVG FROM SVG ORDER BY SVGId ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005X21", "SELECT SVGId AS MItemIcoSVG FROM SVG WHERE SVGId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005X22", "SELECT PerfilId FROM MenuItem WHERE PerfilId = ? AND MenuItemId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getBLOBFile(5, rslt.getString(10, 20), rslt.getVarchar(12));
               ((String[]) buf[5])[0] = rslt.getBLOBFile(6, rslt.getString(11, 20), rslt.getVarchar(13));
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getString(15, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getVarchar(16);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getBLOBFile(5, rslt.getString(10, 20), rslt.getVarchar(12));
               ((String[]) buf[5])[0] = rslt.getBLOBFile(6, rslt.getString(11, 20), rslt.getVarchar(13));
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getString(15, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getVarchar(16);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 3 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getBLOBFile(5, rslt.getString(10, 20), rslt.getVarchar(12));
               ((String[]) buf[5])[0] = rslt.getBLOBFile(6, rslt.getString(11, 20), rslt.getVarchar(13));
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getString(15, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getVarchar(16);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               return;
            case 5 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 7 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 8 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 9 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 15 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 16 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 17 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 19 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 20 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
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
               stmt.setVarchar(2, (String)parms[1], 40, false);
               return;
            case 1 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
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
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(2, (String)parms[2], 40, false);
               }
               return;
            case 4 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               return;
            case 5 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(2, (String)parms[2], 40, false);
               }
               return;
            case 6 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 7 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               return;
            case 8 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setVarchar(3, (String)parms[2], 40, false);
               return;
            case 9 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setVarchar(3, (String)parms[2], 40, false);
               return;
            case 10 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setBLOBFile(5, (String)parms[4]);
               stmt.setBLOBFile(6, (String)parms[5]);
               stmt.setVarchar(7, (String)parms[6], 400, false);
               stmt.setNLongVarchar(8, (String)parms[7], false);
               stmt.setNLongVarchar(9, (String)parms[8], false);
               stmt.setString(10, (String)parms[9], 20);
               stmt.setString(11, (String)parms[10], 20);
               stmt.setVarchar(12, (String)parms[11], 400, false);
               stmt.setVarchar(13, (String)parms[12], 400, false);
               stmt.setByte(14, ((Number) parms[13]).byteValue());
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(15, (String)parms[15], 20);
               }
               if ( ((Boolean) parms[16]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(16, (String)parms[17], 40);
               }
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setNLongVarchar(5, (String)parms[4], false);
               stmt.setNLongVarchar(6, (String)parms[5], false);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setString(8, (String)parms[7], 20);
               stmt.setVarchar(9, (String)parms[8], 400, false);
               stmt.setVarchar(10, (String)parms[9], 400, false);
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(11, (String)parms[11], 20);
               }
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(12, (String)parms[13], 40);
               }
               stmt.setByte(13, ((Number) parms[14]).byteValue());
               stmt.setVarchar(14, (String)parms[15], 40, false);
               return;
            case 12 :
               stmt.setBLOBFile(1, (String)parms[0]);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setVarchar(3, (String)parms[2], 40, false);
               return;
            case 13 :
               stmt.setBLOBFile(1, (String)parms[0]);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setVarchar(3, (String)parms[2], 40, false);
               return;
            case 14 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               return;
            case 15 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setVarchar(2, (String)parms[1], 40);
               return;
            case 16 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               return;
            case 19 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 20 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(2, (String)parms[2], 40, false);
               }
               return;
      }
   }

}

