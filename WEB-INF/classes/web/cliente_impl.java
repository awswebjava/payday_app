package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class cliente_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_9") == 0 )
      {
         A4CliPaiCod = (short)(GXutil.lval( httpContext.GetPar( "CliPaiCod"))) ;
         n4CliPaiCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A4CliPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4CliPaiCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_9( A4CliPaiCod) ;
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
            AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Cliente", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCliNom_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public cliente_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public cliente_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cliente_impl.class ));
   }

   public cliente_impl( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkCliMultiEmp = UIFactory.getCheckbox(this);
      chkClienteConveniador = UIFactory.getCheckbox(this);
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
      A366CliMultiEmp = GXutil.strtobool( GXutil.booltostr( A366CliMultiEmp)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A366CliMultiEmp", A366CliMultiEmp);
      A1605ClienteConveniador = GXutil.strtobool( GXutil.booltostr( A1605ClienteConveniador)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1605ClienteConveniador", A1605ClienteConveniador);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliCod_Internalname, httpContext.getMessage( "Cod", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliCod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cliente.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliNom_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliNom_Internalname, httpContext.getMessage( "Nom", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliNom_Internalname, A344CliNom, GXutil.rtrim( localUtil.format( A344CliNom, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliNom_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliNom_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionLarga", "left", true, "", "HLP_Cliente.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliCUIT_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliCUIT_Internalname, httpContext.getMessage( "CUIT", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCUIT_Internalname, GXutil.ltrim( localUtil.ntoc( A345CliCUIT, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliCUIT_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A345CliCUIT), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A345CliCUIT), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCUIT_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliCUIT_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cliente.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliFecAlta_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliFecAlta_Internalname, httpContext.getMessage( "Fec Alta", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtCliFecAlta_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliFecAlta_Internalname, localUtil.format(A346CliFecAlta, "99/99/9999"), localUtil.format( A346CliFecAlta, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliFecAlta_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtCliFecAlta_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_Cliente.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtCliFecAlta_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtCliFecAlta_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Cliente.htm");
      httpContext.writeTextNL( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkCliMultiEmp.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkCliMultiEmp.getInternalname(), httpContext.getMessage( "Multi Emp", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkCliMultiEmp.getInternalname(), GXutil.booltostr( A366CliMultiEmp), "", httpContext.getMessage( "Multi Emp", ""), 1, chkCliMultiEmp.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(42, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,42);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClientePadre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtClientePadre_Internalname, httpContext.getMessage( "Padre", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtClientePadre_Internalname, GXutil.ltrim( localUtil.ntoc( A546ClientePadre, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtClientePadre_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A546ClientePadre), "ZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A546ClientePadre), "ZZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClientePadre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtClientePadre_Enabled, 0, "text", "1", 12, "chr", 1, "row", 12, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cliente.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedclipaicod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockclipaicod_Internalname, httpContext.getMessage( "Pai Cod", ""), "", "", lblTextblockclipaicod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Cliente.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_clipaicod.setProperty("Caption", Combo_clipaicod_Caption);
      ucCombo_clipaicod.setProperty("Cls", Combo_clipaicod_Cls);
      ucCombo_clipaicod.setProperty("DataListProc", Combo_clipaicod_Datalistproc);
      ucCombo_clipaicod.setProperty("DataListProcParametersPrefix", Combo_clipaicod_Datalistprocparametersprefix);
      ucCombo_clipaicod.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
      ucCombo_clipaicod.setProperty("DropDownOptionsData", AV15CliPaiCod_Data);
      ucCombo_clipaicod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_clipaicod_Internalname, "COMBO_CLIPAICODContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliPaiCod_Internalname, httpContext.getMessage( "Cli Pai Cod", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A4CliPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A4CliPaiCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,58);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliPaiCod_Visible, edtCliPaiCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Cliente.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClienteSistema_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtClienteSistema_Internalname, httpContext.getMessage( "Sistema", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtClienteSistema_Internalname, GXutil.booltostr( A747ClienteSistema), GXutil.booltostr( A747ClienteSistema), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,63);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClienteSistema_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtClienteSistema_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "", "right", false, "", "HLP_Cliente.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkClienteConveniador.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkClienteConveniador.getInternalname(), httpContext.getMessage( "Conveniador", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkClienteConveniador.getInternalname(), GXutil.booltostr( A1605ClienteConveniador), "", httpContext.getMessage( "Conveniador", ""), 1, chkClienteConveniador.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(68, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,68);\"");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 76,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Cliente.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Cliente.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 80,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Cliente.htm");
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
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_clipaicod_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboclipaicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV20ComboCliPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavComboclipaicod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV20ComboCliPaiCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV20ComboCliPaiCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboclipaicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboclipaicod_Visible, edtavComboclipaicod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cliente.htm");
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
      e111H2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV16DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCLIPAICOD_DATA"), AV15CliPaiCod_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z344CliNom = httpContext.cgiGet( "Z344CliNom") ;
            Z345CliCUIT = localUtil.ctol( httpContext.cgiGet( "Z345CliCUIT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z346CliFecAlta = localUtil.ctod( httpContext.cgiGet( "Z346CliFecAlta"), 0) ;
            Z366CliMultiEmp = GXutil.strtobool( httpContext.cgiGet( "Z366CliMultiEmp")) ;
            Z546ClientePadre = localUtil.ctol( httpContext.cgiGet( "Z546ClientePadre"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            n546ClientePadre = ((0==A546ClientePadre) ? true : false) ;
            Z747ClienteSistema = GXutil.strtobool( httpContext.cgiGet( "Z747ClienteSistema")) ;
            Z1605ClienteConveniador = GXutil.strtobool( httpContext.cgiGet( "Z1605ClienteConveniador")) ;
            Z1741ClienteTipo = httpContext.cgiGet( "Z1741ClienteTipo") ;
            n1741ClienteTipo = ((GXutil.strcmp("", A1741ClienteTipo)==0) ? true : false) ;
            Z2023CliManten = GXutil.strtobool( httpContext.cgiGet( "Z2023CliManten")) ;
            Z4CliPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z4CliPaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n4CliPaiCod = ((0==A4CliPaiCod) ? true : false) ;
            A1741ClienteTipo = httpContext.cgiGet( "Z1741ClienteTipo") ;
            n1741ClienteTipo = false ;
            n1741ClienteTipo = ((GXutil.strcmp("", A1741ClienteTipo)==0) ? true : false) ;
            A2023CliManten = GXutil.strtobool( httpContext.cgiGet( "Z2023CliManten")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N4CliPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "N4CliPaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n4CliPaiCod = ((0==A4CliPaiCod) ? true : false) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV13Insert_CliPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_CLIPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1741ClienteTipo = httpContext.cgiGet( "CLIENTETIPO") ;
            n1741ClienteTipo = ((GXutil.strcmp("", A1741ClienteTipo)==0) ? true : false) ;
            A2023CliManten = GXutil.strtobool( httpContext.cgiGet( "CLIMANTEN")) ;
            AV22Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_clipaicod_Objectcall = httpContext.cgiGet( "COMBO_CLIPAICOD_Objectcall") ;
            Combo_clipaicod_Class = httpContext.cgiGet( "COMBO_CLIPAICOD_Class") ;
            Combo_clipaicod_Icontype = httpContext.cgiGet( "COMBO_CLIPAICOD_Icontype") ;
            Combo_clipaicod_Icon = httpContext.cgiGet( "COMBO_CLIPAICOD_Icon") ;
            Combo_clipaicod_Caption = httpContext.cgiGet( "COMBO_CLIPAICOD_Caption") ;
            Combo_clipaicod_Tooltip = httpContext.cgiGet( "COMBO_CLIPAICOD_Tooltip") ;
            Combo_clipaicod_Cls = httpContext.cgiGet( "COMBO_CLIPAICOD_Cls") ;
            Combo_clipaicod_Selectedvalue_set = httpContext.cgiGet( "COMBO_CLIPAICOD_Selectedvalue_set") ;
            Combo_clipaicod_Selectedvalue_get = httpContext.cgiGet( "COMBO_CLIPAICOD_Selectedvalue_get") ;
            Combo_clipaicod_Selectedtext_set = httpContext.cgiGet( "COMBO_CLIPAICOD_Selectedtext_set") ;
            Combo_clipaicod_Selectedtext_get = httpContext.cgiGet( "COMBO_CLIPAICOD_Selectedtext_get") ;
            Combo_clipaicod_Gamoauthtoken = httpContext.cgiGet( "COMBO_CLIPAICOD_Gamoauthtoken") ;
            Combo_clipaicod_Ddointernalname = httpContext.cgiGet( "COMBO_CLIPAICOD_Ddointernalname") ;
            Combo_clipaicod_Titlecontrolalign = httpContext.cgiGet( "COMBO_CLIPAICOD_Titlecontrolalign") ;
            Combo_clipaicod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CLIPAICOD_Dropdownoptionstype") ;
            Combo_clipaicod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIPAICOD_Enabled")) ;
            Combo_clipaicod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIPAICOD_Visible")) ;
            Combo_clipaicod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CLIPAICOD_Titlecontrolidtoreplace") ;
            Combo_clipaicod_Datalisttype = httpContext.cgiGet( "COMBO_CLIPAICOD_Datalisttype") ;
            Combo_clipaicod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIPAICOD_Allowmultipleselection")) ;
            Combo_clipaicod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CLIPAICOD_Datalistfixedvalues") ;
            Combo_clipaicod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIPAICOD_Isgriditem")) ;
            Combo_clipaicod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIPAICOD_Hasdescription")) ;
            Combo_clipaicod_Datalistproc = httpContext.cgiGet( "COMBO_CLIPAICOD_Datalistproc") ;
            Combo_clipaicod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CLIPAICOD_Datalistprocparametersprefix") ;
            Combo_clipaicod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CLIPAICOD_Remoteservicesparameters") ;
            Combo_clipaicod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CLIPAICOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_clipaicod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIPAICOD_Includeonlyselectedoption")) ;
            Combo_clipaicod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIPAICOD_Includeselectalloption")) ;
            Combo_clipaicod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIPAICOD_Emptyitem")) ;
            Combo_clipaicod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLIPAICOD_Includeaddnewoption")) ;
            Combo_clipaicod_Htmltemplate = httpContext.cgiGet( "COMBO_CLIPAICOD_Htmltemplate") ;
            Combo_clipaicod_Multiplevaluestype = httpContext.cgiGet( "COMBO_CLIPAICOD_Multiplevaluestype") ;
            Combo_clipaicod_Loadingdata = httpContext.cgiGet( "COMBO_CLIPAICOD_Loadingdata") ;
            Combo_clipaicod_Noresultsfound = httpContext.cgiGet( "COMBO_CLIPAICOD_Noresultsfound") ;
            Combo_clipaicod_Emptyitemtext = httpContext.cgiGet( "COMBO_CLIPAICOD_Emptyitemtext") ;
            Combo_clipaicod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CLIPAICOD_Onlyselectedvalues") ;
            Combo_clipaicod_Selectalltext = httpContext.cgiGet( "COMBO_CLIPAICOD_Selectalltext") ;
            Combo_clipaicod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CLIPAICOD_Multiplevaluesseparator") ;
            Combo_clipaicod_Addnewoptiontext = httpContext.cgiGet( "COMBO_CLIPAICOD_Addnewoptiontext") ;
            Combo_clipaicod_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CLIPAICOD_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n3CliCod = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A344CliNom = GXutil.upper( httpContext.cgiGet( edtCliNom_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A344CliNom", A344CliNom);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliCUIT_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliCUIT_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLICUIT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCUIT_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A345CliCUIT = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A345CliCUIT", GXutil.ltrimstr( DecimalUtil.doubleToDec(A345CliCUIT), 11, 0));
            }
            else
            {
               A345CliCUIT = localUtil.ctol( httpContext.cgiGet( edtCliCUIT_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A345CliCUIT", GXutil.ltrimstr( DecimalUtil.doubleToDec(A345CliCUIT), 11, 0));
            }
            if ( localUtil.vcdate( httpContext.cgiGet( edtCliFecAlta_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "CLIFECALTA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliFecAlta_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A346CliFecAlta = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A346CliFecAlta", localUtil.format(A346CliFecAlta, "99/99/9999"));
            }
            else
            {
               A346CliFecAlta = localUtil.ctod( httpContext.cgiGet( edtCliFecAlta_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A346CliFecAlta", localUtil.format(A346CliFecAlta, "99/99/9999"));
            }
            A366CliMultiEmp = GXutil.strtobool( httpContext.cgiGet( chkCliMultiEmp.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A366CliMultiEmp", A366CliMultiEmp);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtClientePadre_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtClientePadre_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLIENTEPADRE");
               AnyError = (short)(1) ;
               GX_FocusControl = edtClientePadre_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A546ClientePadre = 0 ;
               n546ClientePadre = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A546ClientePadre", GXutil.ltrimstr( DecimalUtil.doubleToDec(A546ClientePadre), 12, 0));
            }
            else
            {
               A546ClientePadre = localUtil.ctol( httpContext.cgiGet( edtClientePadre_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               n546ClientePadre = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A546ClientePadre", GXutil.ltrimstr( DecimalUtil.doubleToDec(A546ClientePadre), 12, 0));
            }
            n546ClientePadre = ((0==A546ClientePadre) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLIPAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A4CliPaiCod = (short)(0) ;
               n4CliPaiCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A4CliPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4CliPaiCod), 4, 0));
            }
            else
            {
               A4CliPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtCliPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n4CliPaiCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A4CliPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4CliPaiCod), 4, 0));
            }
            n4CliPaiCod = ((0==A4CliPaiCod) ? true : false) ;
            A747ClienteSistema = GXutil.strtobool( httpContext.cgiGet( edtClienteSistema_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A747ClienteSistema", A747ClienteSistema);
            A1605ClienteConveniador = GXutil.strtobool( httpContext.cgiGet( chkClienteConveniador.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1605ClienteConveniador", A1605ClienteConveniador);
            AV20ComboCliPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtavComboclipaicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ComboCliPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboCliPaiCod), 4, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Cliente");
            A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n3CliCod = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            forbiddenHiddens.add("CliCod", localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("ClienteTipo", GXutil.rtrim( localUtil.format( A1741ClienteTipo, "")));
            forbiddenHiddens.add("CliManten", GXutil.booltostr( A2023CliManten));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("cliente:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               n3CliCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
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
                  sMode49 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode49 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound49 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_1H0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "CLICOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCliCod_Internalname ;
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
                        e111H2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e121H2 ();
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
         e121H2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1H49( ) ;
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
         disableAttributes1H49( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboclipaicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboclipaicod_Enabled), 5, 0), true);
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

   public void confirm_1H0( )
   {
      beforeValidate1H49( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1H49( ) ;
         }
         else
         {
            checkExtendedTable1H49( ) ;
            closeExtendedTableCursors1H49( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption1H0( )
   {
   }

   public void e111H2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV16DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV16DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtCliPaiCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiCod_Visible), 5, 0), true);
      AV20ComboCliPaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboCliPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboCliPaiCod), 4, 0));
      edtavComboclipaicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboclipaicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboclipaicod_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOCLIPAICOD' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV9IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCliente_Insert", GXv_boolean5) ;
         cliente_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCliente_Update", GXv_boolean5) ;
         cliente_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCliente_Delete", GXv_boolean5) ;
         cliente_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( ! AV9IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV22Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV11TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV22Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV23GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GXV1), 8, 0));
         while ( AV23GXV1 <= AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV23GXV1));
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CliPaiCod") == 0 )
            {
               AV13Insert_CliPaiCod = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_CliPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_CliPaiCod), 4, 0));
               if ( ! (0==AV13Insert_CliPaiCod) )
               {
                  AV20ComboCliPaiCod = AV13Insert_CliPaiCod ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20ComboCliPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboCliPaiCod), 4, 0));
                  Combo_clipaicod_Selectedvalue_set = GXutil.trim( GXutil.str( AV20ComboCliPaiCod, 4, 0)) ;
                  ucCombo_clipaicod.sendProperty(context, "", false, Combo_clipaicod_Internalname, "SelectedValue_set", Combo_clipaicod_Selectedvalue_set);
                  GXt_char6 = AV19Combo_DataJson ;
                  GXv_char7[0] = AV17ComboSelectedValue ;
                  GXv_char8[0] = AV18ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new web.clienteloaddvcombo(remoteHandle, context).execute( "CliPaiCod", "GET", false, AV7CliCod, AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  cliente_impl.this.AV17ComboSelectedValue = GXv_char7[0] ;
                  cliente_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
                  cliente_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedValue", AV17ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedText", AV18ComboSelectedText);
                  AV19Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV19Combo_DataJson", AV19Combo_DataJson);
                  Combo_clipaicod_Selectedtext_set = AV18ComboSelectedText ;
                  ucCombo_clipaicod.sendProperty(context, "", false, Combo_clipaicod_Internalname, "SelectedText_set", Combo_clipaicod_Selectedtext_set);
                  Combo_clipaicod_Enabled = false ;
                  ucCombo_clipaicod.sendProperty(context, "", false, Combo_clipaicod_Internalname, "Enabled", GXutil.booltostr( Combo_clipaicod_Enabled));
               }
            }
            AV23GXV1 = (int)(AV23GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GXV1), 8, 0));
         }
      }
   }

   public void e121H2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S112( )
   {
      /* 'LOADCOMBOCLIPAICOD' Routine */
      returnInSub = false ;
      GXt_char6 = AV19Combo_DataJson ;
      GXv_char9[0] = AV17ComboSelectedValue ;
      GXv_char8[0] = AV18ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.clienteloaddvcombo(remoteHandle, context).execute( "CliPaiCod", Gx_mode, false, AV7CliCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      cliente_impl.this.AV17ComboSelectedValue = GXv_char9[0] ;
      cliente_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
      cliente_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedValue", AV17ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedText", AV18ComboSelectedText);
      AV19Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19Combo_DataJson", AV19Combo_DataJson);
      Combo_clipaicod_Selectedvalue_set = AV17ComboSelectedValue ;
      ucCombo_clipaicod.sendProperty(context, "", false, Combo_clipaicod_Internalname, "SelectedValue_set", Combo_clipaicod_Selectedvalue_set);
      Combo_clipaicod_Selectedtext_set = AV18ComboSelectedText ;
      ucCombo_clipaicod.sendProperty(context, "", false, Combo_clipaicod_Internalname, "SelectedText_set", Combo_clipaicod_Selectedtext_set);
      AV20ComboCliPaiCod = (short)(GXutil.lval( AV17ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboCliPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboCliPaiCod), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_clipaicod_Enabled = false ;
         ucCombo_clipaicod.sendProperty(context, "", false, Combo_clipaicod_Internalname, "Enabled", GXutil.booltostr( Combo_clipaicod_Enabled));
      }
   }

   public void zm1H49( int GX_JID )
   {
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z344CliNom = T001H3_A344CliNom[0] ;
            Z345CliCUIT = T001H3_A345CliCUIT[0] ;
            Z346CliFecAlta = T001H3_A346CliFecAlta[0] ;
            Z366CliMultiEmp = T001H3_A366CliMultiEmp[0] ;
            Z546ClientePadre = T001H3_A546ClientePadre[0] ;
            Z747ClienteSistema = T001H3_A747ClienteSistema[0] ;
            Z1605ClienteConveniador = T001H3_A1605ClienteConveniador[0] ;
            Z1741ClienteTipo = T001H3_A1741ClienteTipo[0] ;
            Z2023CliManten = T001H3_A2023CliManten[0] ;
            Z4CliPaiCod = T001H3_A4CliPaiCod[0] ;
         }
         else
         {
            Z344CliNom = A344CliNom ;
            Z345CliCUIT = A345CliCUIT ;
            Z346CliFecAlta = A346CliFecAlta ;
            Z366CliMultiEmp = A366CliMultiEmp ;
            Z546ClientePadre = A546ClientePadre ;
            Z747ClienteSistema = A747ClienteSistema ;
            Z1605ClienteConveniador = A1605ClienteConveniador ;
            Z1741ClienteTipo = A1741ClienteTipo ;
            Z2023CliManten = A2023CliManten ;
            Z4CliPaiCod = A4CliPaiCod ;
         }
      }
      if ( GX_JID == -8 )
      {
         Z3CliCod = A3CliCod ;
         Z344CliNom = A344CliNom ;
         Z345CliCUIT = A345CliCUIT ;
         Z346CliFecAlta = A346CliFecAlta ;
         Z366CliMultiEmp = A366CliMultiEmp ;
         Z546ClientePadre = A546ClientePadre ;
         Z747ClienteSistema = A747ClienteSistema ;
         Z1605ClienteConveniador = A1605ClienteConveniador ;
         Z1741ClienteTipo = A1741ClienteTipo ;
         Z2023CliManten = A2023CliManten ;
         Z4CliPaiCod = A4CliPaiCod ;
      }
   }

   public void standaloneNotModal( )
   {
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         n3CliCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_CliPaiCod) )
      {
         edtCliPaiCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiCod_Enabled), 5, 0), true);
      }
      else
      {
         edtCliPaiCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiCod_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_CliPaiCod) )
      {
         A4CliPaiCod = AV13Insert_CliPaiCod ;
         n4CliPaiCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A4CliPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4CliPaiCod), 4, 0));
      }
      else
      {
         if ( (0==AV20ComboCliPaiCod) )
         {
            A4CliPaiCod = (short)(0) ;
            n4CliPaiCod = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A4CliPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4CliPaiCod), 4, 0));
            n4CliPaiCod = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A4CliPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4CliPaiCod), 4, 0));
         }
         else
         {
            if ( ! (0==AV20ComboCliPaiCod) )
            {
               A4CliPaiCod = AV20ComboCliPaiCod ;
               n4CliPaiCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A4CliPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4CliPaiCod), 4, 0));
            }
         }
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
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV22Pgmname = "Cliente" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      }
   }

   public void load1H49( )
   {
      /* Using cursor T001H5 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound49 = (short)(1) ;
         A344CliNom = T001H5_A344CliNom[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A344CliNom", A344CliNom);
         A345CliCUIT = T001H5_A345CliCUIT[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A345CliCUIT", GXutil.ltrimstr( DecimalUtil.doubleToDec(A345CliCUIT), 11, 0));
         A346CliFecAlta = T001H5_A346CliFecAlta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A346CliFecAlta", localUtil.format(A346CliFecAlta, "99/99/9999"));
         A366CliMultiEmp = T001H5_A366CliMultiEmp[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A366CliMultiEmp", A366CliMultiEmp);
         A546ClientePadre = T001H5_A546ClientePadre[0] ;
         n546ClientePadre = T001H5_n546ClientePadre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A546ClientePadre", GXutil.ltrimstr( DecimalUtil.doubleToDec(A546ClientePadre), 12, 0));
         A747ClienteSistema = T001H5_A747ClienteSistema[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A747ClienteSistema", A747ClienteSistema);
         A1605ClienteConveniador = T001H5_A1605ClienteConveniador[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1605ClienteConveniador", A1605ClienteConveniador);
         A1741ClienteTipo = T001H5_A1741ClienteTipo[0] ;
         n1741ClienteTipo = T001H5_n1741ClienteTipo[0] ;
         A2023CliManten = T001H5_A2023CliManten[0] ;
         A4CliPaiCod = T001H5_A4CliPaiCod[0] ;
         n4CliPaiCod = T001H5_n4CliPaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A4CliPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4CliPaiCod), 4, 0));
         zm1H49( -8) ;
      }
      pr_default.close(3);
      onLoadActions1H49( ) ;
   }

   public void onLoadActions1H49( )
   {
      AV22Pgmname = "Cliente" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
   }

   public void checkExtendedTable1H49( )
   {
      nIsDirty_49 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV22Pgmname = "Cliente" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      /* Using cursor T001H4 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n4CliPaiCod), Short.valueOf(A4CliPaiCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (0==A4CliPaiCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLIPAICOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliPaiCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(2);
   }

   public void closeExtendedTableCursors1H49( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_9( short A4CliPaiCod )
   {
      /* Using cursor T001H6 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n4CliPaiCod), Short.valueOf(A4CliPaiCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         if ( ! ( (0==A4CliPaiCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLIPAICOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliPaiCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(4) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(4);
   }

   public void getKey1H49( )
   {
      /* Using cursor T001H7 */
      pr_default.execute(5, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound49 = (short)(1) ;
      }
      else
      {
         RcdFound49 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T001H3 */
      pr_default.execute(1, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1H49( 8) ;
         RcdFound49 = (short)(1) ;
         A3CliCod = T001H3_A3CliCod[0] ;
         n3CliCod = T001H3_n3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A344CliNom = T001H3_A344CliNom[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A344CliNom", A344CliNom);
         A345CliCUIT = T001H3_A345CliCUIT[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A345CliCUIT", GXutil.ltrimstr( DecimalUtil.doubleToDec(A345CliCUIT), 11, 0));
         A346CliFecAlta = T001H3_A346CliFecAlta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A346CliFecAlta", localUtil.format(A346CliFecAlta, "99/99/9999"));
         A366CliMultiEmp = T001H3_A366CliMultiEmp[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A366CliMultiEmp", A366CliMultiEmp);
         A546ClientePadre = T001H3_A546ClientePadre[0] ;
         n546ClientePadre = T001H3_n546ClientePadre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A546ClientePadre", GXutil.ltrimstr( DecimalUtil.doubleToDec(A546ClientePadre), 12, 0));
         A747ClienteSistema = T001H3_A747ClienteSistema[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A747ClienteSistema", A747ClienteSistema);
         A1605ClienteConveniador = T001H3_A1605ClienteConveniador[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1605ClienteConveniador", A1605ClienteConveniador);
         A1741ClienteTipo = T001H3_A1741ClienteTipo[0] ;
         n1741ClienteTipo = T001H3_n1741ClienteTipo[0] ;
         A2023CliManten = T001H3_A2023CliManten[0] ;
         A4CliPaiCod = T001H3_A4CliPaiCod[0] ;
         n4CliPaiCod = T001H3_n4CliPaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A4CliPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4CliPaiCod), 4, 0));
         Z3CliCod = A3CliCod ;
         sMode49 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1H49( ) ;
         if ( AnyError == 1 )
         {
            RcdFound49 = (short)(0) ;
            initializeNonKey1H49( ) ;
         }
         Gx_mode = sMode49 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound49 = (short)(0) ;
         initializeNonKey1H49( ) ;
         sMode49 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode49 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1H49( ) ;
      if ( RcdFound49 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound49 = (short)(0) ;
      /* Using cursor T001H8 */
      pr_default.execute(6, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T001H8_A3CliCod[0] < A3CliCod ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T001H8_A3CliCod[0] > A3CliCod ) ) )
         {
            A3CliCod = T001H8_A3CliCod[0] ;
            n3CliCod = T001H8_n3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            RcdFound49 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound49 = (short)(0) ;
      /* Using cursor T001H9 */
      pr_default.execute(7, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T001H9_A3CliCod[0] > A3CliCod ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T001H9_A3CliCod[0] < A3CliCod ) ) )
         {
            A3CliCod = T001H9_A3CliCod[0] ;
            n3CliCod = T001H9_n3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            RcdFound49 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1H49( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliNom_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1H49( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound49 == 1 )
         {
            if ( A3CliCod != Z3CliCod )
            {
               A3CliCod = Z3CliCod ;
               n3CliCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtCliNom_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1H49( ) ;
               GX_FocusControl = edtCliNom_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A3CliCod != Z3CliCod )
            {
               /* Insert record */
               GX_FocusControl = edtCliNom_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1H49( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CLICOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCliCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtCliNom_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1H49( ) ;
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
      if ( A3CliCod != Z3CliCod )
      {
         A3CliCod = Z3CliCod ;
         n3CliCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtCliNom_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1H49( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T001H2 */
         pr_default.execute(0, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Cliente"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z344CliNom, T001H2_A344CliNom[0]) != 0 ) || ( Z345CliCUIT != T001H2_A345CliCUIT[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z346CliFecAlta), GXutil.resetTime(T001H2_A346CliFecAlta[0])) ) || ( Z366CliMultiEmp != T001H2_A366CliMultiEmp[0] ) || ( Z546ClientePadre != T001H2_A546ClientePadre[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z747ClienteSistema != T001H2_A747ClienteSistema[0] ) || ( Z1605ClienteConveniador != T001H2_A1605ClienteConveniador[0] ) || ( GXutil.strcmp(Z1741ClienteTipo, T001H2_A1741ClienteTipo[0]) != 0 ) || ( Z2023CliManten != T001H2_A2023CliManten[0] ) || ( Z4CliPaiCod != T001H2_A4CliPaiCod[0] ) )
         {
            if ( GXutil.strcmp(Z344CliNom, T001H2_A344CliNom[0]) != 0 )
            {
               GXutil.writeLogln("cliente:[seudo value changed for attri]"+"CliNom");
               GXutil.writeLogRaw("Old: ",Z344CliNom);
               GXutil.writeLogRaw("Current: ",T001H2_A344CliNom[0]);
            }
            if ( Z345CliCUIT != T001H2_A345CliCUIT[0] )
            {
               GXutil.writeLogln("cliente:[seudo value changed for attri]"+"CliCUIT");
               GXutil.writeLogRaw("Old: ",Z345CliCUIT);
               GXutil.writeLogRaw("Current: ",T001H2_A345CliCUIT[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z346CliFecAlta), GXutil.resetTime(T001H2_A346CliFecAlta[0])) ) )
            {
               GXutil.writeLogln("cliente:[seudo value changed for attri]"+"CliFecAlta");
               GXutil.writeLogRaw("Old: ",Z346CliFecAlta);
               GXutil.writeLogRaw("Current: ",T001H2_A346CliFecAlta[0]);
            }
            if ( Z366CliMultiEmp != T001H2_A366CliMultiEmp[0] )
            {
               GXutil.writeLogln("cliente:[seudo value changed for attri]"+"CliMultiEmp");
               GXutil.writeLogRaw("Old: ",Z366CliMultiEmp);
               GXutil.writeLogRaw("Current: ",T001H2_A366CliMultiEmp[0]);
            }
            if ( Z546ClientePadre != T001H2_A546ClientePadre[0] )
            {
               GXutil.writeLogln("cliente:[seudo value changed for attri]"+"ClientePadre");
               GXutil.writeLogRaw("Old: ",Z546ClientePadre);
               GXutil.writeLogRaw("Current: ",T001H2_A546ClientePadre[0]);
            }
            if ( Z747ClienteSistema != T001H2_A747ClienteSistema[0] )
            {
               GXutil.writeLogln("cliente:[seudo value changed for attri]"+"ClienteSistema");
               GXutil.writeLogRaw("Old: ",Z747ClienteSistema);
               GXutil.writeLogRaw("Current: ",T001H2_A747ClienteSistema[0]);
            }
            if ( Z1605ClienteConveniador != T001H2_A1605ClienteConveniador[0] )
            {
               GXutil.writeLogln("cliente:[seudo value changed for attri]"+"ClienteConveniador");
               GXutil.writeLogRaw("Old: ",Z1605ClienteConveniador);
               GXutil.writeLogRaw("Current: ",T001H2_A1605ClienteConveniador[0]);
            }
            if ( GXutil.strcmp(Z1741ClienteTipo, T001H2_A1741ClienteTipo[0]) != 0 )
            {
               GXutil.writeLogln("cliente:[seudo value changed for attri]"+"ClienteTipo");
               GXutil.writeLogRaw("Old: ",Z1741ClienteTipo);
               GXutil.writeLogRaw("Current: ",T001H2_A1741ClienteTipo[0]);
            }
            if ( Z2023CliManten != T001H2_A2023CliManten[0] )
            {
               GXutil.writeLogln("cliente:[seudo value changed for attri]"+"CliManten");
               GXutil.writeLogRaw("Old: ",Z2023CliManten);
               GXutil.writeLogRaw("Current: ",T001H2_A2023CliManten[0]);
            }
            if ( Z4CliPaiCod != T001H2_A4CliPaiCod[0] )
            {
               GXutil.writeLogln("cliente:[seudo value changed for attri]"+"CliPaiCod");
               GXutil.writeLogRaw("Old: ",Z4CliPaiCod);
               GXutil.writeLogRaw("Current: ",T001H2_A4CliPaiCod[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Cliente"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1H49( )
   {
      beforeValidate1H49( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1H49( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1H49( 0) ;
         checkOptimisticConcurrency1H49( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1H49( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1H49( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001H10 */
                  pr_default.execute(8, new Object[] {A344CliNom, Long.valueOf(A345CliCUIT), A346CliFecAlta, Boolean.valueOf(A366CliMultiEmp), Boolean.valueOf(n546ClientePadre), Long.valueOf(A546ClientePadre), Boolean.valueOf(A747ClienteSistema), Boolean.valueOf(A1605ClienteConveniador), Boolean.valueOf(n1741ClienteTipo), A1741ClienteTipo, Boolean.valueOf(A2023CliManten), Boolean.valueOf(n4CliPaiCod), Short.valueOf(A4CliPaiCod)});
                  /* Retrieving last key number assigned */
                  /* Using cursor T001H11 */
                  pr_default.execute(9);
                  A3CliCod = T001H11_A3CliCod[0] ;
                  n3CliCod = T001H11_n3CliCod[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
                  pr_default.close(9);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Cliente");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption1H0( ) ;
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
            load1H49( ) ;
         }
         endLevel1H49( ) ;
      }
      closeExtendedTableCursors1H49( ) ;
   }

   public void update1H49( )
   {
      beforeValidate1H49( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1H49( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1H49( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1H49( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1H49( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001H12 */
                  pr_default.execute(10, new Object[] {A344CliNom, Long.valueOf(A345CliCUIT), A346CliFecAlta, Boolean.valueOf(A366CliMultiEmp), Boolean.valueOf(n546ClientePadre), Long.valueOf(A546ClientePadre), Boolean.valueOf(A747ClienteSistema), Boolean.valueOf(A1605ClienteConveniador), Boolean.valueOf(n1741ClienteTipo), A1741ClienteTipo, Boolean.valueOf(A2023CliManten), Boolean.valueOf(n4CliPaiCod), Short.valueOf(A4CliPaiCod), Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Cliente");
                  if ( (pr_default.getStatus(10) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Cliente"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1H49( ) ;
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
         endLevel1H49( ) ;
      }
      closeExtendedTableCursors1H49( ) ;
   }

   public void deferredUpdate1H49( )
   {
   }

   public void delete( )
   {
      beforeValidate1H49( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1H49( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1H49( ) ;
         afterConfirm1H49( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1H49( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001H13 */
               pr_default.execute(11, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Cliente");
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
      sMode49 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1H49( ) ;
      Gx_mode = sMode49 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1H49( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV22Pgmname = "Cliente" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T001H14 */
         pr_default.execute(12, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos remuneración actual", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
         /* Using cursor T001H15 */
         pr_default.execute(13, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "conceptos_horanormal_mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
         /* Using cursor T001H16 */
         pr_default.execute(14, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "conceptos_horanormal_jornalizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
         /* Using cursor T001H17 */
         pr_default.execute(15, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "User", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
         /* Using cursor T001H18 */
         pr_default.execute(16, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(16) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Debug", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
         /* Using cursor T001H19 */
         pr_default.execute(17, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(17) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "rest_location", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(17);
         /* Using cursor T001H20 */
         pr_default.execute(18, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(18) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "soap_location", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(18);
         /* Using cursor T001H21 */
         pr_default.execute(19, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(19) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "concepto_operandos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(19);
         /* Using cursor T001H22 */
         pr_default.execute(20, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(20) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Cliente_Update", "")+" ("+httpContext.getMessage( "Cliente Release", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(20);
         /* Using cursor T001H23 */
         pr_default.execute(21, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(21) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Cliente_Update", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(21);
         /* Using cursor T001H24 */
         pr_default.execute(22, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(22) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(22);
         /* Using cursor T001H25 */
         pr_default.execute(23, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(23) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Logins_registro", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(23);
         /* Using cursor T001H26 */
         pr_default.execute(24, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(24) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(24);
         /* Using cursor T001H27 */
         pr_default.execute(25, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(25) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Cliente Convenios", "")+" ("+httpContext.getMessage( "Convenio Cliente Version", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(25);
         /* Using cursor T001H28 */
         pr_default.execute(26, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(26) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Cliente Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(26);
         /* Using cursor T001H29 */
         pr_default.execute(27, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(27) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(27);
         /* Using cursor T001H30 */
         pr_default.execute(28, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(28) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Mot Egr Tipo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(28);
         /* Using cursor T001H31 */
         pr_default.execute(29, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(29) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "tipo aplicacion ganancias", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(29);
         /* Using cursor T001H32 */
         pr_default.execute(30, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(30) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "condicion_exencion_iigg", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(30);
         /* Using cursor T001H33 */
         pr_default.execute(31, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(31) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "siradig_codigos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(31);
         /* Using cursor T001H34 */
         pr_default.execute(32, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(32) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Variable", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(32);
         /* Using cursor T001H35 */
         pr_default.execute(33, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(33) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Tipo Liquidacion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(33);
         /* Using cursor T001H36 */
         pr_default.execute(34, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(34) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Seccion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(34);
         /* Using cursor T001H37 */
         pr_default.execute(35, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(35) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Plan Medico", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(35);
         /* Using cursor T001H38 */
         pr_default.execute(36, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(36) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Parentesco", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(36);
         /* Using cursor T001H39 */
         pr_default.execute(37, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(37) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Valores Predeterminados y Otros Parámetros", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(37);
         /* Using cursor T001H40 */
         pr_default.execute(38, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(38) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "ObraSocial", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(38);
         /* Using cursor T001H41 */
         pr_default.execute(39, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(39) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Motivo Egreso", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(39);
         /* Using cursor T001H42 */
         pr_default.execute(40, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(40) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Lugarde Pago", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(40);
         /* Using cursor T001H43 */
         pr_default.execute(41, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(41) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Log", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(41);
         /* Using cursor T001H44 */
         pr_default.execute(42, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(42) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Importacion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(42);
         /* Using cursor T001H45 */
         pr_default.execute(43, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(43) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Tabla de Escalas", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(43);
         /* Using cursor T001H46 */
         pr_default.execute(44, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(44) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Excel", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(44);
         /* Using cursor T001H47 */
         pr_default.execute(45, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(45) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Escolaridad", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(45);
         /* Using cursor T001H48 */
         pr_default.execute(46, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(46) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(46);
         /* Using cursor T001H49 */
         pr_default.execute(47, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(47) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto AFIP", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(47);
         /* Using cursor T001H50 */
         pr_default.execute(48, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(48) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(48);
         /* Using cursor T001H51 */
         pr_default.execute(49, new Object[] {Boolean.valueOf(n3CliCod), Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(49) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Banco", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(49);
      }
   }

   public void endLevel1H49( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1H49( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "cliente");
         if ( AnyError == 0 )
         {
            confirmValues1H0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "cliente");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1H49( )
   {
      /* Scan By routine */
      /* Using cursor T001H52 */
      pr_default.execute(50);
      RcdFound49 = (short)(0) ;
      if ( (pr_default.getStatus(50) != 101) )
      {
         RcdFound49 = (short)(1) ;
         A3CliCod = T001H52_A3CliCod[0] ;
         n3CliCod = T001H52_n3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1H49( )
   {
      /* Scan next routine */
      pr_default.readNext(50);
      RcdFound49 = (short)(0) ;
      if ( (pr_default.getStatus(50) != 101) )
      {
         RcdFound49 = (short)(1) ;
         A3CliCod = T001H52_A3CliCod[0] ;
         n3CliCod = T001H52_n3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
   }

   public void scanEnd1H49( )
   {
      pr_default.close(50);
   }

   public void afterConfirm1H49( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1H49( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1H49( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1H49( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1H49( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1H49( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1H49( )
   {
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtCliNom_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliNom_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliNom_Enabled), 5, 0), true);
      edtCliCUIT_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCUIT_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCUIT_Enabled), 5, 0), true);
      edtCliFecAlta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliFecAlta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliFecAlta_Enabled), 5, 0), true);
      chkCliMultiEmp.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkCliMultiEmp.getInternalname(), "Enabled", GXutil.ltrimstr( chkCliMultiEmp.getEnabled(), 5, 0), true);
      edtClientePadre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClientePadre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClientePadre_Enabled), 5, 0), true);
      edtCliPaiCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiCod_Enabled), 5, 0), true);
      edtClienteSistema_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClienteSistema_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClienteSistema_Enabled), 5, 0), true);
      chkClienteConveniador.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkClienteConveniador.getInternalname(), "Enabled", GXutil.ltrimstr( chkClienteConveniador.getEnabled(), 5, 0), true);
      edtavComboclipaicod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboclipaicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboclipaicod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes1H49( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues1H0( )
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
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.cliente", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0))}, new String[] {"Gx_mode","CliCod"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Cliente");
      forbiddenHiddens.add("CliCod", localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("ClienteTipo", GXutil.rtrim( localUtil.format( A1741ClienteTipo, "")));
      forbiddenHiddens.add("CliManten", GXutil.booltostr( A2023CliManten));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("cliente:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z344CliNom", Z344CliNom);
      web.GxWebStd.gx_hidden_field( httpContext, "Z345CliCUIT", GXutil.ltrim( localUtil.ntoc( Z345CliCUIT, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z346CliFecAlta", localUtil.dtoc( Z346CliFecAlta, 0, "/"));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z366CliMultiEmp", Z366CliMultiEmp);
      web.GxWebStd.gx_hidden_field( httpContext, "Z546ClientePadre", GXutil.ltrim( localUtil.ntoc( Z546ClientePadre, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z747ClienteSistema", Z747ClienteSistema);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1605ClienteConveniador", Z1605ClienteConveniador);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1741ClienteTipo", GXutil.rtrim( Z1741ClienteTipo));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2023CliManten", Z2023CliManten);
      web.GxWebStd.gx_hidden_field( httpContext, "Z4CliPaiCod", GXutil.ltrim( localUtil.ntoc( Z4CliPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N4CliPaiCod", GXutil.ltrim( localUtil.ntoc( A4CliPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV16DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV16DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCLIPAICOD_DATA", AV15CliPaiCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCLIPAICOD_DATA", AV15CliPaiCod_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CLIPAICOD", GXutil.ltrim( localUtil.ntoc( AV13Insert_CliPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLIENTETIPO", GXutil.rtrim( A1741ClienteTipo));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "CLIMANTEN", A2023CliManten);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV22Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIPAICOD_Objectcall", GXutil.rtrim( Combo_clipaicod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIPAICOD_Cls", GXutil.rtrim( Combo_clipaicod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIPAICOD_Selectedvalue_set", GXutil.rtrim( Combo_clipaicod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIPAICOD_Selectedtext_set", GXutil.rtrim( Combo_clipaicod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIPAICOD_Enabled", GXutil.booltostr( Combo_clipaicod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIPAICOD_Datalistproc", GXutil.rtrim( Combo_clipaicod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLIPAICOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_clipaicod_Datalistprocparametersprefix));
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
      return formatLink("web.cliente", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0))}, new String[] {"Gx_mode","CliCod"})  ;
   }

   public String getPgmname( )
   {
      return "Cliente" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Cliente", "") ;
   }

   public void initializeNonKey1H49( )
   {
      A4CliPaiCod = (short)(0) ;
      n4CliPaiCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A4CliPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4CliPaiCod), 4, 0));
      n4CliPaiCod = ((0==A4CliPaiCod) ? true : false) ;
      A344CliNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A344CliNom", A344CliNom);
      A345CliCUIT = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A345CliCUIT", GXutil.ltrimstr( DecimalUtil.doubleToDec(A345CliCUIT), 11, 0));
      A346CliFecAlta = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A346CliFecAlta", localUtil.format(A346CliFecAlta, "99/99/9999"));
      A366CliMultiEmp = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A366CliMultiEmp", A366CliMultiEmp);
      A546ClientePadre = 0 ;
      n546ClientePadre = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A546ClientePadre", GXutil.ltrimstr( DecimalUtil.doubleToDec(A546ClientePadre), 12, 0));
      n546ClientePadre = ((0==A546ClientePadre) ? true : false) ;
      A747ClienteSistema = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A747ClienteSistema", A747ClienteSistema);
      A1605ClienteConveniador = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1605ClienteConveniador", A1605ClienteConveniador);
      A1741ClienteTipo = "" ;
      n1741ClienteTipo = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1741ClienteTipo", A1741ClienteTipo);
      A2023CliManten = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2023CliManten", A2023CliManten);
      Z344CliNom = "" ;
      Z345CliCUIT = 0 ;
      Z346CliFecAlta = GXutil.nullDate() ;
      Z366CliMultiEmp = false ;
      Z546ClientePadre = 0 ;
      Z747ClienteSistema = false ;
      Z1605ClienteConveniador = false ;
      Z1741ClienteTipo = "" ;
      Z2023CliManten = false ;
      Z4CliPaiCod = (short)(0) ;
   }

   public void initAll1H49( )
   {
      A3CliCod = 0 ;
      n3CliCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      initializeNonKey1H49( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251816582156", true, true);
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
      httpContext.AddJavascriptSource("gxdec.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("cliente.js", "?20251816582157", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtCliCod_Internalname = "CLICOD" ;
      edtCliNom_Internalname = "CLINOM" ;
      edtCliCUIT_Internalname = "CLICUIT" ;
      edtCliFecAlta_Internalname = "CLIFECALTA" ;
      chkCliMultiEmp.setInternalname( "CLIMULTIEMP" );
      edtClientePadre_Internalname = "CLIENTEPADRE" ;
      lblTextblockclipaicod_Internalname = "TEXTBLOCKCLIPAICOD" ;
      Combo_clipaicod_Internalname = "COMBO_CLIPAICOD" ;
      edtCliPaiCod_Internalname = "CLIPAICOD" ;
      divTablesplittedclipaicod_Internalname = "TABLESPLITTEDCLIPAICOD" ;
      edtClienteSistema_Internalname = "CLIENTESISTEMA" ;
      chkClienteConveniador.setInternalname( "CLIENTECONVENIADOR" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavComboclipaicod_Internalname = "vCOMBOCLIPAICOD" ;
      divSectionattribute_clipaicod_Internalname = "SECTIONATTRIBUTE_CLIPAICOD" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
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
      Form.setCaption( httpContext.getMessage( "Cliente", "") );
      edtavComboclipaicod_Jsonclick = "" ;
      edtavComboclipaicod_Enabled = 0 ;
      edtavComboclipaicod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      chkClienteConveniador.setEnabled( 1 );
      edtClienteSistema_Jsonclick = "" ;
      edtClienteSistema_Enabled = 1 ;
      edtCliPaiCod_Jsonclick = "" ;
      edtCliPaiCod_Enabled = 1 ;
      edtCliPaiCod_Visible = 1 ;
      Combo_clipaicod_Datalistprocparametersprefix = " \"ComboName\": \"CliPaiCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0" ;
      Combo_clipaicod_Datalistproc = "ClienteLoadDVCombo" ;
      Combo_clipaicod_Cls = "ExtendedCombo Attribute" ;
      Combo_clipaicod_Caption = "" ;
      Combo_clipaicod_Enabled = GXutil.toBoolean( -1) ;
      edtClientePadre_Jsonclick = "" ;
      edtClientePadre_Enabled = 1 ;
      chkCliMultiEmp.setEnabled( 1 );
      edtCliFecAlta_Jsonclick = "" ;
      edtCliFecAlta_Enabled = 1 ;
      edtCliCUIT_Jsonclick = "" ;
      edtCliCUIT_Enabled = 1 ;
      edtCliNom_Jsonclick = "" ;
      edtCliNom_Enabled = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 0 ;
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

   public void init_web_controls( )
   {
      chkCliMultiEmp.setName( "CLIMULTIEMP" );
      chkCliMultiEmp.setWebtags( "" );
      chkCliMultiEmp.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkCliMultiEmp.getInternalname(), "TitleCaption", chkCliMultiEmp.getCaption(), true);
      chkCliMultiEmp.setCheckedValue( "false" );
      A366CliMultiEmp = GXutil.strtobool( GXutil.booltostr( A366CliMultiEmp)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A366CliMultiEmp", A366CliMultiEmp);
      chkClienteConveniador.setName( "CLIENTECONVENIADOR" );
      chkClienteConveniador.setWebtags( "" );
      chkClienteConveniador.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkClienteConveniador.getInternalname(), "TitleCaption", chkClienteConveniador.getCaption(), true);
      chkClienteConveniador.setCheckedValue( "false" );
      A1605ClienteConveniador = GXutil.strtobool( GXutil.booltostr( A1605ClienteConveniador)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1605ClienteConveniador", A1605ClienteConveniador);
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

   public void valid_Clipaicod( )
   {
      n4CliPaiCod = false ;
      /* Using cursor T001H53 */
      pr_default.execute(51, new Object[] {Boolean.valueOf(n4CliPaiCod), Short.valueOf(A4CliPaiCod)});
      if ( (pr_default.getStatus(51) == 101) )
      {
         if ( ! ( (0==A4CliPaiCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLIPAICOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliPaiCod_Internalname ;
         }
      }
      pr_default.close(51);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'A366CliMultiEmp',fld:'CLIMULTIEMP',pic:''},{av:'A1605ClienteConveniador',fld:'CLIENTECONVENIADOR',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A366CliMultiEmp',fld:'CLIMULTIEMP',pic:''},{av:'A1605ClienteConveniador',fld:'CLIENTECONVENIADOR',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1741ClienteTipo',fld:'CLIENTETIPO',pic:''},{av:'A2023CliManten',fld:'CLIMANTEN',pic:''},{av:'A366CliMultiEmp',fld:'CLIMULTIEMP',pic:''},{av:'A1605ClienteConveniador',fld:'CLIENTECONVENIADOR',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A366CliMultiEmp',fld:'CLIMULTIEMP',pic:''},{av:'A1605ClienteConveniador',fld:'CLIENTECONVENIADOR',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e121H2',iparms:[{av:'A366CliMultiEmp',fld:'CLIMULTIEMP',pic:''},{av:'A1605ClienteConveniador',fld:'CLIENTECONVENIADOR',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A366CliMultiEmp',fld:'CLIMULTIEMP',pic:''},{av:'A1605ClienteConveniador',fld:'CLIENTECONVENIADOR',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A366CliMultiEmp',fld:'CLIMULTIEMP',pic:''},{av:'A1605ClienteConveniador',fld:'CLIENTECONVENIADOR',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A366CliMultiEmp',fld:'CLIMULTIEMP',pic:''},{av:'A1605ClienteConveniador',fld:'CLIENTECONVENIADOR',pic:''}]}");
      setEventMetadata("VALID_CLIPAICOD","{handler:'valid_Clipaicod',iparms:[{av:'A4CliPaiCod',fld:'CLIPAICOD',pic:'ZZZ9'},{av:'A366CliMultiEmp',fld:'CLIMULTIEMP',pic:''},{av:'A1605ClienteConveniador',fld:'CLIENTECONVENIADOR',pic:''}]");
      setEventMetadata("VALID_CLIPAICOD",",oparms:[{av:'A366CliMultiEmp',fld:'CLIMULTIEMP',pic:''},{av:'A1605ClienteConveniador',fld:'CLIENTECONVENIADOR',pic:''}]}");
      setEventMetadata("VALIDV_COMBOCLIPAICOD","{handler:'validv_Comboclipaicod',iparms:[{av:'A366CliMultiEmp',fld:'CLIMULTIEMP',pic:''},{av:'A1605ClienteConveniador',fld:'CLIENTECONVENIADOR',pic:''}]");
      setEventMetadata("VALIDV_COMBOCLIPAICOD",",oparms:[{av:'A366CliMultiEmp',fld:'CLIMULTIEMP',pic:''},{av:'A1605ClienteConveniador',fld:'CLIENTECONVENIADOR',pic:''}]}");
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
      pr_default.close(51);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z344CliNom = "" ;
      Z346CliFecAlta = GXutil.nullDate() ;
      Z1741ClienteTipo = "" ;
      Combo_clipaicod_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A344CliNom = "" ;
      A346CliFecAlta = GXutil.nullDate() ;
      ClassString = "" ;
      StyleString = "" ;
      lblTextblockclipaicod_Jsonclick = "" ;
      ucCombo_clipaicod = new com.genexus.webpanels.GXUserControl();
      AV16DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV15CliPaiCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A1741ClienteTipo = "" ;
      AV22Pgmname = "" ;
      Combo_clipaicod_Objectcall = "" ;
      Combo_clipaicod_Class = "" ;
      Combo_clipaicod_Icontype = "" ;
      Combo_clipaicod_Icon = "" ;
      Combo_clipaicod_Tooltip = "" ;
      Combo_clipaicod_Selectedvalue_set = "" ;
      Combo_clipaicod_Selectedtext_set = "" ;
      Combo_clipaicod_Selectedtext_get = "" ;
      Combo_clipaicod_Gamoauthtoken = "" ;
      Combo_clipaicod_Ddointernalname = "" ;
      Combo_clipaicod_Titlecontrolalign = "" ;
      Combo_clipaicod_Dropdownoptionstype = "" ;
      Combo_clipaicod_Titlecontrolidtoreplace = "" ;
      Combo_clipaicod_Datalisttype = "" ;
      Combo_clipaicod_Datalistfixedvalues = "" ;
      Combo_clipaicod_Remoteservicesparameters = "" ;
      Combo_clipaicod_Htmltemplate = "" ;
      Combo_clipaicod_Multiplevaluestype = "" ;
      Combo_clipaicod_Loadingdata = "" ;
      Combo_clipaicod_Noresultsfound = "" ;
      Combo_clipaicod_Emptyitemtext = "" ;
      Combo_clipaicod_Onlyselectedvalues = "" ;
      Combo_clipaicod_Selectalltext = "" ;
      Combo_clipaicod_Multiplevaluesseparator = "" ;
      Combo_clipaicod_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode49 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV8WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV11TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      AV14TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV19Combo_DataJson = "" ;
      AV17ComboSelectedValue = "" ;
      AV18ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      T001H5_A3CliCod = new int[1] ;
      T001H5_n3CliCod = new boolean[] {false} ;
      T001H5_A344CliNom = new String[] {""} ;
      T001H5_A345CliCUIT = new long[1] ;
      T001H5_A346CliFecAlta = new java.util.Date[] {GXutil.nullDate()} ;
      T001H5_A366CliMultiEmp = new boolean[] {false} ;
      T001H5_A546ClientePadre = new long[1] ;
      T001H5_n546ClientePadre = new boolean[] {false} ;
      T001H5_A747ClienteSistema = new boolean[] {false} ;
      T001H5_A1605ClienteConveniador = new boolean[] {false} ;
      T001H5_A1741ClienteTipo = new String[] {""} ;
      T001H5_n1741ClienteTipo = new boolean[] {false} ;
      T001H5_A2023CliManten = new boolean[] {false} ;
      T001H5_A4CliPaiCod = new short[1] ;
      T001H5_n4CliPaiCod = new boolean[] {false} ;
      T001H4_A4CliPaiCod = new short[1] ;
      T001H4_n4CliPaiCod = new boolean[] {false} ;
      T001H6_A4CliPaiCod = new short[1] ;
      T001H6_n4CliPaiCod = new boolean[] {false} ;
      T001H7_A3CliCod = new int[1] ;
      T001H7_n3CliCod = new boolean[] {false} ;
      T001H3_A3CliCod = new int[1] ;
      T001H3_n3CliCod = new boolean[] {false} ;
      T001H3_A344CliNom = new String[] {""} ;
      T001H3_A345CliCUIT = new long[1] ;
      T001H3_A346CliFecAlta = new java.util.Date[] {GXutil.nullDate()} ;
      T001H3_A366CliMultiEmp = new boolean[] {false} ;
      T001H3_A546ClientePadre = new long[1] ;
      T001H3_n546ClientePadre = new boolean[] {false} ;
      T001H3_A747ClienteSistema = new boolean[] {false} ;
      T001H3_A1605ClienteConveniador = new boolean[] {false} ;
      T001H3_A1741ClienteTipo = new String[] {""} ;
      T001H3_n1741ClienteTipo = new boolean[] {false} ;
      T001H3_A2023CliManten = new boolean[] {false} ;
      T001H3_A4CliPaiCod = new short[1] ;
      T001H3_n4CliPaiCod = new boolean[] {false} ;
      T001H8_A3CliCod = new int[1] ;
      T001H8_n3CliCod = new boolean[] {false} ;
      T001H9_A3CliCod = new int[1] ;
      T001H9_n3CliCod = new boolean[] {false} ;
      T001H2_A3CliCod = new int[1] ;
      T001H2_n3CliCod = new boolean[] {false} ;
      T001H2_A344CliNom = new String[] {""} ;
      T001H2_A345CliCUIT = new long[1] ;
      T001H2_A346CliFecAlta = new java.util.Date[] {GXutil.nullDate()} ;
      T001H2_A366CliMultiEmp = new boolean[] {false} ;
      T001H2_A546ClientePadre = new long[1] ;
      T001H2_n546ClientePadre = new boolean[] {false} ;
      T001H2_A747ClienteSistema = new boolean[] {false} ;
      T001H2_A1605ClienteConveniador = new boolean[] {false} ;
      T001H2_A1741ClienteTipo = new String[] {""} ;
      T001H2_n1741ClienteTipo = new boolean[] {false} ;
      T001H2_A2023CliManten = new boolean[] {false} ;
      T001H2_A4CliPaiCod = new short[1] ;
      T001H2_n4CliPaiCod = new boolean[] {false} ;
      T001H11_A3CliCod = new int[1] ;
      T001H11_n3CliCod = new boolean[] {false} ;
      T001H14_A46PaiCod = new short[1] ;
      T001H14_A1440PaiBaseClaseLeg = new byte[1] ;
      T001H14_A1441PaiBaseTipo = new String[] {""} ;
      T001H14_A1442PaiBaseCod1 = new String[] {""} ;
      T001H14_A1443PaiBaseCod2 = new String[] {""} ;
      T001H14_A1445PaiBaseCliCod = new int[1] ;
      T001H14_A1446PaiBaseConCodigo = new String[] {""} ;
      T001H15_A46PaiCod = new short[1] ;
      T001H15_A1356PaiMenCliCod = new int[1] ;
      T001H15_A1358PaiMesConCodigo = new String[] {""} ;
      T001H16_A46PaiCod = new short[1] ;
      T001H16_A1354PaiJorCliCod = new int[1] ;
      T001H16_A1355PaiJorConCodigo = new String[] {""} ;
      T001H17_A67SecUserId = new short[1] ;
      T001H18_A3CliCod = new int[1] ;
      T001H18_n3CliCod = new boolean[] {false} ;
      T001H18_A1754DebugPgm = new String[] {""} ;
      T001H19_A3CliCod = new int[1] ;
      T001H19_n3CliCod = new boolean[] {false} ;
      T001H19_A2171RestLocId = new String[] {""} ;
      T001H20_A3CliCod = new int[1] ;
      T001H20_n3CliCod = new boolean[] {false} ;
      T001H20_A2162SoapLocId = new String[] {""} ;
      T001H21_A3CliCod = new int[1] ;
      T001H21_n3CliCod = new boolean[] {false} ;
      T001H21_A26ConCodigo = new String[] {""} ;
      T001H21_A2119ConOpeId = new String[] {""} ;
      T001H21_A923ConOperFor = new String[] {""} ;
      T001H22_A3CliCod = new int[1] ;
      T001H22_n3CliCod = new boolean[] {false} ;
      T001H22_A1881CliUpdCliCod = new int[1] ;
      T001H22_A1887CliUpdRelSec = new int[1] ;
      T001H23_A3CliCod = new int[1] ;
      T001H23_n3CliCod = new boolean[] {false} ;
      T001H23_A1881CliUpdCliCod = new int[1] ;
      T001H23_A1887CliUpdRelSec = new int[1] ;
      T001H24_A3CliCod = new int[1] ;
      T001H24_n3CliCod = new boolean[] {false} ;
      T001H24_A1885CliRelSec = new int[1] ;
      T001H25_A3CliCod = new int[1] ;
      T001H25_n3CliCod = new boolean[] {false} ;
      T001H25_A1839LogRegUsu = new String[] {""} ;
      T001H25_A1840LogRegFec = new java.util.Date[] {GXutil.nullDate()} ;
      T001H26_A3CliCod = new int[1] ;
      T001H26_n3CliCod = new boolean[] {false} ;
      T001H26_A1564CliPaiConve = new short[1] ;
      T001H26_A1565CliConvenio = new String[] {""} ;
      T001H26_A1381ConveMenCliCod = new int[1] ;
      T001H26_A1375ConveMenConCodigo = new String[] {""} ;
      T001H27_A3CliCod = new int[1] ;
      T001H27_n3CliCod = new boolean[] {false} ;
      T001H27_A1564CliPaiConve = new short[1] ;
      T001H27_A1565CliConvenio = new String[] {""} ;
      T001H28_A3CliCod = new int[1] ;
      T001H28_n3CliCod = new boolean[] {false} ;
      T001H28_A1564CliPaiConve = new short[1] ;
      T001H28_A1565CliConvenio = new String[] {""} ;
      T001H29_A3CliCod = new int[1] ;
      T001H29_n3CliCod = new boolean[] {false} ;
      T001H29_A1EmpCod = new short[1] ;
      T001H29_A1562EmpConvePai = new short[1] ;
      T001H29_A1561EmpConveCod = new String[] {""} ;
      T001H30_A3CliCod = new int[1] ;
      T001H30_n3CliCod = new boolean[] {false} ;
      T001H30_A1525MegTipo = new String[] {""} ;
      T001H31_A3CliCod = new int[1] ;
      T001H31_n3CliCod = new boolean[] {false} ;
      T001H31_A1112AplIIGG = new short[1] ;
      T001H32_A3CliCod = new int[1] ;
      T001H32_n3CliCod = new boolean[] {false} ;
      T001H32_A1105CondExenIIGG = new String[] {""} ;
      T001H33_A3CliCod = new int[1] ;
      T001H33_n3CliCod = new boolean[] {false} ;
      T001H33_A1101SiraTipo = new String[] {""} ;
      T001H33_A1102SiraCodigo = new String[] {""} ;
      T001H34_A3CliCod = new int[1] ;
      T001H34_n3CliCod = new boolean[] {false} ;
      T001H34_A82OpeCliId = new String[] {""} ;
      T001H35_A3CliCod = new int[1] ;
      T001H35_n3CliCod = new boolean[] {false} ;
      T001H35_A32TLiqCod = new String[] {""} ;
      T001H36_A3CliCod = new int[1] ;
      T001H36_n3CliCod = new boolean[] {false} ;
      T001H36_A13SecCodigo = new String[] {""} ;
      T001H37_A3CliCod = new int[1] ;
      T001H37_n3CliCod = new boolean[] {false} ;
      T001H37_A12PmedCod = new String[] {""} ;
      T001H38_A3CliCod = new int[1] ;
      T001H38_n3CliCod = new boolean[] {false} ;
      T001H38_A30ParCod = new String[] {""} ;
      T001H39_A3CliCod = new int[1] ;
      T001H39_n3CliCod = new boolean[] {false} ;
      T001H39_A61ParmCod = new String[] {""} ;
      T001H40_A3CliCod = new int[1] ;
      T001H40_n3CliCod = new boolean[] {false} ;
      T001H40_A5OsoCod = new String[] {""} ;
      T001H41_A3CliCod = new int[1] ;
      T001H41_n3CliCod = new boolean[] {false} ;
      T001H41_A11MegCodigo = new String[] {""} ;
      T001H42_A3CliCod = new int[1] ;
      T001H42_n3CliCod = new boolean[] {false} ;
      T001H42_A10LpgCodigo = new String[] {""} ;
      T001H43_A3CliCod = new int[1] ;
      T001H43_n3CliCod = new boolean[] {false} ;
      T001H43_A57LogId = new long[1] ;
      T001H44_A3CliCod = new int[1] ;
      T001H44_n3CliCod = new boolean[] {false} ;
      T001H44_A52ImpSec = new long[1] ;
      T001H45_A3CliCod = new int[1] ;
      T001H45_n3CliCod = new boolean[] {false} ;
      T001H45_A55EscalaAnio = new short[1] ;
      T001H45_A56EscalaIDReg = new long[1] ;
      T001H46_A3CliCod = new int[1] ;
      T001H46_n3CliCod = new boolean[] {false} ;
      T001H46_A50ExcelId = new long[1] ;
      T001H47_A3CliCod = new int[1] ;
      T001H47_n3CliCod = new boolean[] {false} ;
      T001H47_A49EscCod = new String[] {""} ;
      T001H48_A3CliCod = new int[1] ;
      T001H48_n3CliCod = new boolean[] {false} ;
      T001H48_A1EmpCod = new short[1] ;
      T001H49_A3CliCod = new int[1] ;
      T001H49_n3CliCod = new boolean[] {false} ;
      T001H49_A73ConCodPropio = new String[] {""} ;
      T001H50_A3CliCod = new int[1] ;
      T001H50_n3CliCod = new boolean[] {false} ;
      T001H50_A26ConCodigo = new String[] {""} ;
      T001H51_A3CliCod = new int[1] ;
      T001H51_n3CliCod = new boolean[] {false} ;
      T001H51_A7BanCod = new String[] {""} ;
      T001H52_A3CliCod = new int[1] ;
      T001H52_n3CliCod = new boolean[] {false} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T001H53_A4CliPaiCod = new short[1] ;
      T001H53_n4CliPaiCod = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cliente__default(),
         new Object[] {
             new Object[] {
            T001H2_A3CliCod, T001H2_A344CliNom, T001H2_A345CliCUIT, T001H2_A346CliFecAlta, T001H2_A366CliMultiEmp, T001H2_A546ClientePadre, T001H2_n546ClientePadre, T001H2_A747ClienteSistema, T001H2_A1605ClienteConveniador, T001H2_A1741ClienteTipo,
            T001H2_n1741ClienteTipo, T001H2_A2023CliManten, T001H2_A4CliPaiCod, T001H2_n4CliPaiCod
            }
            , new Object[] {
            T001H3_A3CliCod, T001H3_A344CliNom, T001H3_A345CliCUIT, T001H3_A346CliFecAlta, T001H3_A366CliMultiEmp, T001H3_A546ClientePadre, T001H3_n546ClientePadre, T001H3_A747ClienteSistema, T001H3_A1605ClienteConveniador, T001H3_A1741ClienteTipo,
            T001H3_n1741ClienteTipo, T001H3_A2023CliManten, T001H3_A4CliPaiCod, T001H3_n4CliPaiCod
            }
            , new Object[] {
            T001H4_A4CliPaiCod
            }
            , new Object[] {
            T001H5_A3CliCod, T001H5_A344CliNom, T001H5_A345CliCUIT, T001H5_A346CliFecAlta, T001H5_A366CliMultiEmp, T001H5_A546ClientePadre, T001H5_n546ClientePadre, T001H5_A747ClienteSistema, T001H5_A1605ClienteConveniador, T001H5_A1741ClienteTipo,
            T001H5_n1741ClienteTipo, T001H5_A2023CliManten, T001H5_A4CliPaiCod, T001H5_n4CliPaiCod
            }
            , new Object[] {
            T001H6_A4CliPaiCod
            }
            , new Object[] {
            T001H7_A3CliCod
            }
            , new Object[] {
            T001H8_A3CliCod
            }
            , new Object[] {
            T001H9_A3CliCod
            }
            , new Object[] {
            }
            , new Object[] {
            T001H11_A3CliCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001H14_A46PaiCod, T001H14_A1440PaiBaseClaseLeg, T001H14_A1441PaiBaseTipo, T001H14_A1442PaiBaseCod1, T001H14_A1443PaiBaseCod2, T001H14_A1445PaiBaseCliCod, T001H14_A1446PaiBaseConCodigo
            }
            , new Object[] {
            T001H15_A46PaiCod, T001H15_A1356PaiMenCliCod, T001H15_A1358PaiMesConCodigo
            }
            , new Object[] {
            T001H16_A46PaiCod, T001H16_A1354PaiJorCliCod, T001H16_A1355PaiJorConCodigo
            }
            , new Object[] {
            T001H17_A67SecUserId
            }
            , new Object[] {
            T001H18_A3CliCod, T001H18_A1754DebugPgm
            }
            , new Object[] {
            T001H19_A3CliCod, T001H19_A2171RestLocId
            }
            , new Object[] {
            T001H20_A3CliCod, T001H20_A2162SoapLocId
            }
            , new Object[] {
            T001H21_A3CliCod, T001H21_A26ConCodigo, T001H21_A2119ConOpeId, T001H21_A923ConOperFor
            }
            , new Object[] {
            T001H22_A3CliCod, T001H22_A1881CliUpdCliCod, T001H22_A1887CliUpdRelSec
            }
            , new Object[] {
            T001H23_A3CliCod, T001H23_A1881CliUpdCliCod, T001H23_A1887CliUpdRelSec
            }
            , new Object[] {
            T001H24_A3CliCod, T001H24_A1885CliRelSec
            }
            , new Object[] {
            T001H25_A3CliCod, T001H25_A1839LogRegUsu, T001H25_A1840LogRegFec
            }
            , new Object[] {
            T001H26_A3CliCod, T001H26_A1564CliPaiConve, T001H26_A1565CliConvenio, T001H26_A1381ConveMenCliCod, T001H26_A1375ConveMenConCodigo
            }
            , new Object[] {
            T001H27_A3CliCod, T001H27_A1564CliPaiConve, T001H27_A1565CliConvenio
            }
            , new Object[] {
            T001H28_A3CliCod, T001H28_A1564CliPaiConve, T001H28_A1565CliConvenio
            }
            , new Object[] {
            T001H29_A3CliCod, T001H29_A1EmpCod, T001H29_A1562EmpConvePai, T001H29_A1561EmpConveCod
            }
            , new Object[] {
            T001H30_A3CliCod, T001H30_A1525MegTipo
            }
            , new Object[] {
            T001H31_A3CliCod, T001H31_A1112AplIIGG
            }
            , new Object[] {
            T001H32_A3CliCod, T001H32_A1105CondExenIIGG
            }
            , new Object[] {
            T001H33_A3CliCod, T001H33_A1101SiraTipo, T001H33_A1102SiraCodigo
            }
            , new Object[] {
            T001H34_A3CliCod, T001H34_A82OpeCliId
            }
            , new Object[] {
            T001H35_A3CliCod, T001H35_A32TLiqCod
            }
            , new Object[] {
            T001H36_A3CliCod, T001H36_A13SecCodigo
            }
            , new Object[] {
            T001H37_A3CliCod, T001H37_A12PmedCod
            }
            , new Object[] {
            T001H38_A3CliCod, T001H38_A30ParCod
            }
            , new Object[] {
            T001H39_A3CliCod, T001H39_A61ParmCod
            }
            , new Object[] {
            T001H40_A3CliCod, T001H40_A5OsoCod
            }
            , new Object[] {
            T001H41_A3CliCod, T001H41_A11MegCodigo
            }
            , new Object[] {
            T001H42_A3CliCod, T001H42_A10LpgCodigo
            }
            , new Object[] {
            T001H43_A3CliCod, T001H43_A57LogId
            }
            , new Object[] {
            T001H44_A3CliCod, T001H44_A52ImpSec
            }
            , new Object[] {
            T001H45_A3CliCod, T001H45_A55EscalaAnio, T001H45_A56EscalaIDReg
            }
            , new Object[] {
            T001H46_A3CliCod, T001H46_A50ExcelId
            }
            , new Object[] {
            T001H47_A3CliCod, T001H47_A49EscCod
            }
            , new Object[] {
            T001H48_A3CliCod, T001H48_A1EmpCod
            }
            , new Object[] {
            T001H49_A3CliCod, T001H49_A73ConCodPropio
            }
            , new Object[] {
            T001H50_A3CliCod, T001H50_A26ConCodigo
            }
            , new Object[] {
            T001H51_A3CliCod, T001H51_A7BanCod
            }
            , new Object[] {
            T001H52_A3CliCod
            }
            , new Object[] {
            T001H53_A4CliPaiCod
            }
         }
      );
      AV22Pgmname = "Cliente" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z4CliPaiCod ;
   private short N4CliPaiCod ;
   private short A4CliPaiCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short AV20ComboCliPaiCod ;
   private short AV13Insert_CliPaiCod ;
   private short RcdFound49 ;
   private short nIsDirty_49 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int AV7CliCod ;
   private int trnEnded ;
   private int A3CliCod ;
   private int edtCliCod_Enabled ;
   private int edtCliNom_Enabled ;
   private int edtCliCUIT_Enabled ;
   private int edtCliFecAlta_Enabled ;
   private int edtClientePadre_Enabled ;
   private int edtCliPaiCod_Visible ;
   private int edtCliPaiCod_Enabled ;
   private int edtClienteSistema_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavComboclipaicod_Enabled ;
   private int edtavComboclipaicod_Visible ;
   private int Combo_clipaicod_Datalistupdateminimumcharacters ;
   private int Combo_clipaicod_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV23GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private long Z345CliCUIT ;
   private long Z546ClientePadre ;
   private long A345CliCUIT ;
   private long A546ClientePadre ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z1741ClienteTipo ;
   private String Combo_clipaicod_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCliNom_Internalname ;
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
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String TempTags ;
   private String edtCliNom_Jsonclick ;
   private String edtCliCUIT_Internalname ;
   private String edtCliCUIT_Jsonclick ;
   private String edtCliFecAlta_Internalname ;
   private String edtCliFecAlta_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String edtClientePadre_Internalname ;
   private String edtClientePadre_Jsonclick ;
   private String divTablesplittedclipaicod_Internalname ;
   private String lblTextblockclipaicod_Internalname ;
   private String lblTextblockclipaicod_Jsonclick ;
   private String Combo_clipaicod_Caption ;
   private String Combo_clipaicod_Cls ;
   private String Combo_clipaicod_Datalistproc ;
   private String Combo_clipaicod_Datalistprocparametersprefix ;
   private String Combo_clipaicod_Internalname ;
   private String edtCliPaiCod_Internalname ;
   private String edtCliPaiCod_Jsonclick ;
   private String edtClienteSistema_Internalname ;
   private String edtClienteSistema_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_clipaicod_Internalname ;
   private String edtavComboclipaicod_Internalname ;
   private String edtavComboclipaicod_Jsonclick ;
   private String A1741ClienteTipo ;
   private String AV22Pgmname ;
   private String Combo_clipaicod_Objectcall ;
   private String Combo_clipaicod_Class ;
   private String Combo_clipaicod_Icontype ;
   private String Combo_clipaicod_Icon ;
   private String Combo_clipaicod_Tooltip ;
   private String Combo_clipaicod_Selectedvalue_set ;
   private String Combo_clipaicod_Selectedtext_set ;
   private String Combo_clipaicod_Selectedtext_get ;
   private String Combo_clipaicod_Gamoauthtoken ;
   private String Combo_clipaicod_Ddointernalname ;
   private String Combo_clipaicod_Titlecontrolalign ;
   private String Combo_clipaicod_Dropdownoptionstype ;
   private String Combo_clipaicod_Titlecontrolidtoreplace ;
   private String Combo_clipaicod_Datalisttype ;
   private String Combo_clipaicod_Datalistfixedvalues ;
   private String Combo_clipaicod_Remoteservicesparameters ;
   private String Combo_clipaicod_Htmltemplate ;
   private String Combo_clipaicod_Multiplevaluestype ;
   private String Combo_clipaicod_Loadingdata ;
   private String Combo_clipaicod_Noresultsfound ;
   private String Combo_clipaicod_Emptyitemtext ;
   private String Combo_clipaicod_Onlyselectedvalues ;
   private String Combo_clipaicod_Selectalltext ;
   private String Combo_clipaicod_Multiplevaluesseparator ;
   private String Combo_clipaicod_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode49 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXt_char6 ;
   private String GXv_char9[] ;
   private String GXv_char8[] ;
   private String GXv_char7[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private java.util.Date Z346CliFecAlta ;
   private java.util.Date A346CliFecAlta ;
   private boolean Z366CliMultiEmp ;
   private boolean Z747ClienteSistema ;
   private boolean Z1605ClienteConveniador ;
   private boolean Z2023CliManten ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n4CliPaiCod ;
   private boolean wbErr ;
   private boolean A366CliMultiEmp ;
   private boolean A1605ClienteConveniador ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean A747ClienteSistema ;
   private boolean n546ClientePadre ;
   private boolean n1741ClienteTipo ;
   private boolean A2023CliManten ;
   private boolean Combo_clipaicod_Enabled ;
   private boolean Combo_clipaicod_Visible ;
   private boolean Combo_clipaicod_Allowmultipleselection ;
   private boolean Combo_clipaicod_Isgriditem ;
   private boolean Combo_clipaicod_Hasdescription ;
   private boolean Combo_clipaicod_Includeonlyselectedoption ;
   private boolean Combo_clipaicod_Includeselectalloption ;
   private boolean Combo_clipaicod_Emptyitem ;
   private boolean Combo_clipaicod_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean n3CliCod ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private String AV19Combo_DataJson ;
   private String Z344CliNom ;
   private String A344CliNom ;
   private String AV17ComboSelectedValue ;
   private String AV18ComboSelectedText ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_clipaicod ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private ICheckbox chkCliMultiEmp ;
   private ICheckbox chkClienteConveniador ;
   private IDataStoreProvider pr_default ;
   private int[] T001H5_A3CliCod ;
   private boolean[] T001H5_n3CliCod ;
   private String[] T001H5_A344CliNom ;
   private long[] T001H5_A345CliCUIT ;
   private java.util.Date[] T001H5_A346CliFecAlta ;
   private boolean[] T001H5_A366CliMultiEmp ;
   private long[] T001H5_A546ClientePadre ;
   private boolean[] T001H5_n546ClientePadre ;
   private boolean[] T001H5_A747ClienteSistema ;
   private boolean[] T001H5_A1605ClienteConveniador ;
   private String[] T001H5_A1741ClienteTipo ;
   private boolean[] T001H5_n1741ClienteTipo ;
   private boolean[] T001H5_A2023CliManten ;
   private short[] T001H5_A4CliPaiCod ;
   private boolean[] T001H5_n4CliPaiCod ;
   private short[] T001H4_A4CliPaiCod ;
   private boolean[] T001H4_n4CliPaiCod ;
   private short[] T001H6_A4CliPaiCod ;
   private boolean[] T001H6_n4CliPaiCod ;
   private int[] T001H7_A3CliCod ;
   private boolean[] T001H7_n3CliCod ;
   private int[] T001H3_A3CliCod ;
   private boolean[] T001H3_n3CliCod ;
   private String[] T001H3_A344CliNom ;
   private long[] T001H3_A345CliCUIT ;
   private java.util.Date[] T001H3_A346CliFecAlta ;
   private boolean[] T001H3_A366CliMultiEmp ;
   private long[] T001H3_A546ClientePadre ;
   private boolean[] T001H3_n546ClientePadre ;
   private boolean[] T001H3_A747ClienteSistema ;
   private boolean[] T001H3_A1605ClienteConveniador ;
   private String[] T001H3_A1741ClienteTipo ;
   private boolean[] T001H3_n1741ClienteTipo ;
   private boolean[] T001H3_A2023CliManten ;
   private short[] T001H3_A4CliPaiCod ;
   private boolean[] T001H3_n4CliPaiCod ;
   private int[] T001H8_A3CliCod ;
   private boolean[] T001H8_n3CliCod ;
   private int[] T001H9_A3CliCod ;
   private boolean[] T001H9_n3CliCod ;
   private int[] T001H2_A3CliCod ;
   private boolean[] T001H2_n3CliCod ;
   private String[] T001H2_A344CliNom ;
   private long[] T001H2_A345CliCUIT ;
   private java.util.Date[] T001H2_A346CliFecAlta ;
   private boolean[] T001H2_A366CliMultiEmp ;
   private long[] T001H2_A546ClientePadre ;
   private boolean[] T001H2_n546ClientePadre ;
   private boolean[] T001H2_A747ClienteSistema ;
   private boolean[] T001H2_A1605ClienteConveniador ;
   private String[] T001H2_A1741ClienteTipo ;
   private boolean[] T001H2_n1741ClienteTipo ;
   private boolean[] T001H2_A2023CliManten ;
   private short[] T001H2_A4CliPaiCod ;
   private boolean[] T001H2_n4CliPaiCod ;
   private int[] T001H11_A3CliCod ;
   private boolean[] T001H11_n3CliCod ;
   private short[] T001H14_A46PaiCod ;
   private byte[] T001H14_A1440PaiBaseClaseLeg ;
   private String[] T001H14_A1441PaiBaseTipo ;
   private String[] T001H14_A1442PaiBaseCod1 ;
   private String[] T001H14_A1443PaiBaseCod2 ;
   private int[] T001H14_A1445PaiBaseCliCod ;
   private String[] T001H14_A1446PaiBaseConCodigo ;
   private short[] T001H15_A46PaiCod ;
   private int[] T001H15_A1356PaiMenCliCod ;
   private String[] T001H15_A1358PaiMesConCodigo ;
   private short[] T001H16_A46PaiCod ;
   private int[] T001H16_A1354PaiJorCliCod ;
   private String[] T001H16_A1355PaiJorConCodigo ;
   private short[] T001H17_A67SecUserId ;
   private int[] T001H18_A3CliCod ;
   private boolean[] T001H18_n3CliCod ;
   private String[] T001H18_A1754DebugPgm ;
   private int[] T001H19_A3CliCod ;
   private boolean[] T001H19_n3CliCod ;
   private String[] T001H19_A2171RestLocId ;
   private int[] T001H20_A3CliCod ;
   private boolean[] T001H20_n3CliCod ;
   private String[] T001H20_A2162SoapLocId ;
   private int[] T001H21_A3CliCod ;
   private boolean[] T001H21_n3CliCod ;
   private String[] T001H21_A26ConCodigo ;
   private String[] T001H21_A2119ConOpeId ;
   private String[] T001H21_A923ConOperFor ;
   private int[] T001H22_A3CliCod ;
   private boolean[] T001H22_n3CliCod ;
   private int[] T001H22_A1881CliUpdCliCod ;
   private int[] T001H22_A1887CliUpdRelSec ;
   private int[] T001H23_A3CliCod ;
   private boolean[] T001H23_n3CliCod ;
   private int[] T001H23_A1881CliUpdCliCod ;
   private int[] T001H23_A1887CliUpdRelSec ;
   private int[] T001H24_A3CliCod ;
   private boolean[] T001H24_n3CliCod ;
   private int[] T001H24_A1885CliRelSec ;
   private int[] T001H25_A3CliCod ;
   private boolean[] T001H25_n3CliCod ;
   private String[] T001H25_A1839LogRegUsu ;
   private java.util.Date[] T001H25_A1840LogRegFec ;
   private int[] T001H26_A3CliCod ;
   private boolean[] T001H26_n3CliCod ;
   private short[] T001H26_A1564CliPaiConve ;
   private String[] T001H26_A1565CliConvenio ;
   private int[] T001H26_A1381ConveMenCliCod ;
   private String[] T001H26_A1375ConveMenConCodigo ;
   private int[] T001H27_A3CliCod ;
   private boolean[] T001H27_n3CliCod ;
   private short[] T001H27_A1564CliPaiConve ;
   private String[] T001H27_A1565CliConvenio ;
   private int[] T001H28_A3CliCod ;
   private boolean[] T001H28_n3CliCod ;
   private short[] T001H28_A1564CliPaiConve ;
   private String[] T001H28_A1565CliConvenio ;
   private int[] T001H29_A3CliCod ;
   private boolean[] T001H29_n3CliCod ;
   private short[] T001H29_A1EmpCod ;
   private short[] T001H29_A1562EmpConvePai ;
   private String[] T001H29_A1561EmpConveCod ;
   private int[] T001H30_A3CliCod ;
   private boolean[] T001H30_n3CliCod ;
   private String[] T001H30_A1525MegTipo ;
   private int[] T001H31_A3CliCod ;
   private boolean[] T001H31_n3CliCod ;
   private short[] T001H31_A1112AplIIGG ;
   private int[] T001H32_A3CliCod ;
   private boolean[] T001H32_n3CliCod ;
   private String[] T001H32_A1105CondExenIIGG ;
   private int[] T001H33_A3CliCod ;
   private boolean[] T001H33_n3CliCod ;
   private String[] T001H33_A1101SiraTipo ;
   private String[] T001H33_A1102SiraCodigo ;
   private int[] T001H34_A3CliCod ;
   private boolean[] T001H34_n3CliCod ;
   private String[] T001H34_A82OpeCliId ;
   private int[] T001H35_A3CliCod ;
   private boolean[] T001H35_n3CliCod ;
   private String[] T001H35_A32TLiqCod ;
   private int[] T001H36_A3CliCod ;
   private boolean[] T001H36_n3CliCod ;
   private String[] T001H36_A13SecCodigo ;
   private int[] T001H37_A3CliCod ;
   private boolean[] T001H37_n3CliCod ;
   private String[] T001H37_A12PmedCod ;
   private int[] T001H38_A3CliCod ;
   private boolean[] T001H38_n3CliCod ;
   private String[] T001H38_A30ParCod ;
   private int[] T001H39_A3CliCod ;
   private boolean[] T001H39_n3CliCod ;
   private String[] T001H39_A61ParmCod ;
   private int[] T001H40_A3CliCod ;
   private boolean[] T001H40_n3CliCod ;
   private String[] T001H40_A5OsoCod ;
   private int[] T001H41_A3CliCod ;
   private boolean[] T001H41_n3CliCod ;
   private String[] T001H41_A11MegCodigo ;
   private int[] T001H42_A3CliCod ;
   private boolean[] T001H42_n3CliCod ;
   private String[] T001H42_A10LpgCodigo ;
   private int[] T001H43_A3CliCod ;
   private boolean[] T001H43_n3CliCod ;
   private long[] T001H43_A57LogId ;
   private int[] T001H44_A3CliCod ;
   private boolean[] T001H44_n3CliCod ;
   private long[] T001H44_A52ImpSec ;
   private int[] T001H45_A3CliCod ;
   private boolean[] T001H45_n3CliCod ;
   private short[] T001H45_A55EscalaAnio ;
   private long[] T001H45_A56EscalaIDReg ;
   private int[] T001H46_A3CliCod ;
   private boolean[] T001H46_n3CliCod ;
   private long[] T001H46_A50ExcelId ;
   private int[] T001H47_A3CliCod ;
   private boolean[] T001H47_n3CliCod ;
   private String[] T001H47_A49EscCod ;
   private int[] T001H48_A3CliCod ;
   private boolean[] T001H48_n3CliCod ;
   private short[] T001H48_A1EmpCod ;
   private int[] T001H49_A3CliCod ;
   private boolean[] T001H49_n3CliCod ;
   private String[] T001H49_A73ConCodPropio ;
   private int[] T001H50_A3CliCod ;
   private boolean[] T001H50_n3CliCod ;
   private String[] T001H50_A26ConCodigo ;
   private int[] T001H51_A3CliCod ;
   private boolean[] T001H51_n3CliCod ;
   private String[] T001H51_A7BanCod ;
   private int[] T001H52_A3CliCod ;
   private boolean[] T001H52_n3CliCod ;
   private short[] T001H53_A4CliPaiCod ;
   private boolean[] T001H53_n4CliPaiCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV15CliPaiCod_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV16DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class cliente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T001H2", "SELECT CliCod, CliNom, CliCUIT, CliFecAlta, CliMultiEmp, ClientePadre, ClienteSistema, ClienteConveniador, ClienteTipo, CliManten, CliPaiCod FROM Cliente WHERE CliCod = ?  FOR UPDATE OF Cliente NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001H3", "SELECT CliCod, CliNom, CliCUIT, CliFecAlta, CliMultiEmp, ClientePadre, ClienteSistema, ClienteConveniador, ClienteTipo, CliManten, CliPaiCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001H4", "SELECT PaiCod AS CliPaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001H5", "SELECT TM1.CliCod, TM1.CliNom, TM1.CliCUIT, TM1.CliFecAlta, TM1.CliMultiEmp, TM1.ClientePadre, TM1.ClienteSistema, TM1.ClienteConveniador, TM1.ClienteTipo, TM1.CliManten, TM1.CliPaiCod AS CliPaiCod FROM Cliente TM1 WHERE TM1.CliCod = ? ORDER BY TM1.CliCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001H6", "SELECT PaiCod AS CliPaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001H7", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001H8", "SELECT CliCod FROM Cliente WHERE ( CliCod > ?) ORDER BY CliCod  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H9", "SELECT CliCod FROM Cliente WHERE ( CliCod < ?) ORDER BY CliCod DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001H10", "SAVEPOINT gxupdate;INSERT INTO Cliente(CliNom, CliCUIT, CliFecAlta, CliMultiEmp, ClientePadre, ClienteSistema, ClienteConveniador, ClienteTipo, CliManten, CliPaiCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001H11", "SELECT currval('CliCod') ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T001H12", "SAVEPOINT gxupdate;UPDATE Cliente SET CliNom=?, CliCUIT=?, CliFecAlta=?, CliMultiEmp=?, ClientePadre=?, ClienteSistema=?, ClienteConveniador=?, ClienteTipo=?, CliManten=?, CliPaiCod=?  WHERE CliCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001H13", "SAVEPOINT gxupdate;DELETE FROM Cliente  WHERE CliCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001H14", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBaseCliCod, PaiBaseConCodigo FROM Paisbase_calculoactual WHERE PaiBaseCliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H15", "SELECT PaiCod, PaiMenCliCod, PaiMesConCodigo FROM Paisconceptos_horanormal_mensualizados WHERE PaiMenCliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H16", "SELECT PaiCod, PaiJorCliCod, PaiJorConCodigo FROM Paisconceptos_horanormal_jornalizados WHERE PaiJorCliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H17", "SELECT SecUserId FROM SecUser WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H18", "SELECT CliCod, DebugPgm FROM Debug WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H19", "SELECT CliCod, RestLocId FROM rest_location WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H20", "SELECT CliCod, SoapLocId FROM soap_location WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H21", "SELECT CliCod, ConCodigo, ConOpeId, ConOperFor FROM concepto_operandos WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H22", "SELECT CliCod, CliUpdCliCod, CliUpdRelSec FROM Cliente_Update WHERE CliUpdCliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H23", "SELECT CliCod, CliUpdCliCod, CliUpdRelSec FROM Cliente_Update WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H24", "SELECT CliCod, CliRelSec FROM Cliente_Release WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H25", "SELECT CliCod, LogRegUsu, LogRegFec FROM Logins_registro WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H26", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE ConveMenCliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H27", "SELECT CliCod, CliPaiConve, CliConvenio FROM ClienteConvenios WHERE CliConveVer = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H28", "SELECT CliCod, CliPaiConve, CliConvenio FROM ClienteConvenios WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H29", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE EmpConveVer = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H30", "SELECT CliCod, MegTipo FROM MotEgrTipo WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H31", "SELECT CliCod, AplIIGG FROM tipo_aplicacion_ganancias WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H32", "SELECT CliCod, CondExenIIGG FROM condicion_exencion_iigg WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H33", "SELECT CliCod, SiraTipo, SiraCodigo FROM siradig_codigos WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H34", "SELECT CliCod, OpeCliId FROM Variable WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H35", "SELECT CliCod, TLiqCod FROM TipoLiquidacion WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H36", "SELECT CliCod, SecCodigo FROM Seccion WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H37", "SELECT CliCod, PmedCod FROM PlanMedico WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H38", "SELECT CliCod, ParCod FROM Parentesco WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H39", "SELECT CliCod, ParmCod FROM Param WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H40", "SELECT CliCod, OsoCod FROM ObraSocial WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H41", "SELECT CliCod, MegCodigo FROM MotivoEgreso WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H42", "SELECT CliCod, LpgCodigo FROM LugardePago WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H43", "SELECT CliCod, LogId FROM Log WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H44", "SELECT CliCod, ImpSec FROM Importacion WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H45", "SELECT CliCod, EscalaAnio, EscalaIDReg FROM GanTablaEscalas WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H46", "SELECT CliCod, ExcelId FROM Excel WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H47", "SELECT CliCod, EscCod FROM Escolaridad WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H48", "SELECT CliCod, EmpCod FROM Empresa WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H49", "SELECT CliCod, ConCodPropio FROM ConceptoAFIP WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H50", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliPadre = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H51", "SELECT CliCod, BanCod FROM Banco WHERE CliCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001H52", "SELECT CliCod FROM Cliente ORDER BY CliCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001H53", "SELECT PaiCod AS CliPaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(8);
               ((String[]) buf[9])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((boolean[]) buf[11])[0] = rslt.getBoolean(10);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(8);
               ((String[]) buf[9])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((boolean[]) buf[11])[0] = rslt.getBoolean(10);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(8);
               ((String[]) buf[9])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((boolean[]) buf[11])[0] = rslt.getBoolean(10);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 20 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 21 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 22 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 23 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               return;
            case 24 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 25 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 26 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 27 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 28 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 29 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 31 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 3);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 32 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 33 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 34 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 35 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 36 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 37 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 30);
               return;
            case 38 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 39 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 40 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 41 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 42 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 43 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 44 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 45 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 46 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 47 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 48 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 49 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               return;
            case 50 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 51 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 4 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 5 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 6 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 7 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 8 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(5, ((Number) parms[5]).longValue());
               }
               stmt.setBoolean(6, ((Boolean) parms[6]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[7]).booleanValue());
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(8, (String)parms[9], 20);
               }
               stmt.setBoolean(9, ((Boolean) parms[10]).booleanValue());
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(10, ((Number) parms[12]).shortValue());
               }
               return;
            case 10 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(5, ((Number) parms[5]).longValue());
               }
               stmt.setBoolean(6, ((Boolean) parms[6]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[7]).booleanValue());
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(8, (String)parms[9], 20);
               }
               stmt.setBoolean(9, ((Boolean) parms[10]).booleanValue());
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(10, ((Number) parms[12]).shortValue());
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(11, ((Number) parms[14]).intValue());
               }
               return;
            case 11 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 12 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 13 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 14 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 15 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 16 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 17 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 18 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 19 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 20 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 21 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 22 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 23 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 24 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 25 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 26 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 27 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 28 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 29 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
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
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 31 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 32 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 33 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 34 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 35 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 36 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 37 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 38 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 39 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 40 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 41 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 42 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 43 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 44 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 45 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 46 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 47 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 48 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 49 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 51 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
      }
   }

}

