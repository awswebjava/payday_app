package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class f1357_mostrardeterminado_impl extends GXDataArea
{
   public f1357_mostrardeterminado_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public f1357_mostrardeterminado_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( f1357_mostrardeterminado_impl.class ));
   }

   public f1357_mostrardeterminado_impl( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbF1357LCAliApli = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
         {
            httpContext.setAjaxEventMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
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
            A3CliCod = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A784F1357CTipoPre = (byte)(GXutil.lval( httpContext.GetPar( "F1357CTipoPre"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
               A777F1357CPer = httpContext.GetPar( "F1357CPer") ;
               httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
               A778F1357CSec = (byte)(GXutil.lval( httpContext.GetPar( "F1357CSec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
               A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            }
         }
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.workwithplusmasterpageprompt");
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

   public byte executeStartEvent( )
   {
      pa9T2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start9T2( ) ;
      }
      return gxajaxcallmode ;
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
      if ( nGXWrapped != 1 )
      {
         MasterPageObj.master_styles();
      }
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
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = ((nGXWrapped==0) ? " data-HasEnter=\"false\" data-Skiponenter=\"false\"" : "") ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.f1357_mostrardeterminado", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A784F1357CTipoPre,1,0)),GXutil.URLEncode(GXutil.rtrim(A777F1357CPer)),GXutil.URLEncode(GXutil.ltrimstr(A778F1357CSec,2,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0))}, new String[] {"CliCod","EmpCod","F1357CTipoPre","F1357CPer","F1357CSec","LegNumero"}) +"\">") ;
         web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      }
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPCOD", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "F1357CTIPOPRE", GXutil.ltrim( localUtil.ntoc( A784F1357CTipoPre, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "F1357CPER", GXutil.rtrim( A777F1357CPer));
      web.GxWebStd.gx_hidden_field( httpContext, "F1357CSEC", GXutil.ltrim( localUtil.ntoc( A778F1357CSec, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGNUMERO", GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "</form>") ;
      }
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

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we9T2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt9T2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return false ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.f1357_mostrardeterminado", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A784F1357CTipoPre,1,0)),GXutil.URLEncode(GXutil.rtrim(A777F1357CPer)),GXutil.URLEncode(GXutil.ltrimstr(A778F1357CSec,2,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0))}, new String[] {"CliCod","EmpCod","F1357CTipoPre","F1357CPer","F1357CSec","LegNumero"})  ;
   }

   public String getPgmname( )
   {
      return "F1357_MostrarDeterminado" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Composición del impuesto determinado", "") ;
   }

   public void wb9T0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( nGXWrapped == 1 )
         {
            renderHtmlHeaders( ) ;
            renderHtmlOpenForm( ) ;
         }
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", "", "false");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainPopover", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LC_Cuota_fija_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtF1357LC_Cuota_fija_Internalname, httpContext.getMessage( "CUOTA FIJA (ANUAL)", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LC_Cuota_fija_Internalname, GXutil.ltrim( localUtil.ntoc( A871F1357LC_Cuota_fija, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LC_Cuota_fija_Enabled!=0) ? localUtil.format( A871F1357LC_Cuota_fija, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A871F1357LC_Cuota_fija, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LC_Cuota_fija_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LC_Cuota_fija_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357_MostrarDeterminado.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LC_GNSI_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtF1357LC_GNSI_Internalname, httpContext.getMessage( "GNSI", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LC_GNSI_Internalname, GXutil.ltrim( localUtil.ntoc( A866F1357LC_GNSI, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LC_GNSI_Enabled!=0) ? localUtil.format( A866F1357LC_GNSI, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A866F1357LC_GNSI, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LC_GNSI_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LC_GNSI_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357_MostrarDeterminado.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LC_MesesTributados_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtF1357LC_MesesTributados_Internalname, httpContext.getMessage( "CANTIDAD DE MESES TRIBUTADOS", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LC_MesesTributados_Internalname, GXutil.ltrim( localUtil.ntoc( A872F1357LC_MesesTributados, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LC_MesesTributados_Enabled!=0) ? localUtil.format( A872F1357LC_MesesTributados, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A872F1357LC_MesesTributados, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LC_MesesTributados_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LC_MesesTributados_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357_MostrarDeterminado.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LC_Tope_anterior_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtF1357LC_Tope_anterior_Internalname, httpContext.getMessage( "ESCALA TOPE ANTERIOR (ANUAL)", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LC_Tope_anterior_Internalname, GXutil.ltrim( localUtil.ntoc( A873F1357LC_Tope_anterior, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LC_Tope_anterior_Enabled!=0) ? localUtil.format( A873F1357LC_Tope_anterior, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A873F1357LC_Tope_anterior, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LC_Tope_anterior_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LC_Tope_anterior_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357_MostrarDeterminado.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbF1357LCAliApli.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbF1357LCAliApli.getInternalname(), httpContext.getMessage( "ALÍCUOTA APLICABLE (SIN INCLUIR HORAS EXTRAS)", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbF1357LCAliApli, cmbF1357LCAliApli.getInternalname(), GXutil.trim( GXutil.str( A845F1357LCAliApli, 2, 0)), 1, cmbF1357LCAliApli.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbF1357LCAliApli.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_F1357_MostrarDeterminado.htm");
         cmbF1357LCAliApli.setValue( GXutil.trim( GXutil.str( A845F1357LCAliApli, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbF1357LCAliApli.getInternalname(), "Values", cmbF1357LCAliApli.ToJavascriptSource(), true);
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
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start9T2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "Composición del impuesto determinado", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup9T0( ) ;
   }

   public void ws9T2( )
   {
      start9T2( ) ;
      evt9T2( ) ;
   }

   public void evt9T2( )
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
               if ( GXutil.strcmp(sEvtType, "M") != 0 )
               {
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e119T2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e129T2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
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
                           dynload_actions( ) ;
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
   }

   public void we9T2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            if ( nGXWrapped == 1 )
            {
               renderHtmlCloseForm( ) ;
            }
         }
      }
   }

   public void pa9T2( )
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
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
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
      if ( cmbF1357LCAliApli.getItemCount() > 0 )
      {
         A845F1357LCAliApli = (byte)(GXutil.lval( cmbF1357LCAliApli.getValidValue(GXutil.trim( GXutil.str( A845F1357LCAliApli, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A845F1357LCAliApli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A845F1357LCAliApli), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbF1357LCAliApli.setValue( GXutil.trim( GXutil.str( A845F1357LCAliApli, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbF1357LCAliApli.getInternalname(), "Values", cmbF1357LCAliApli.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf9T2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   public void rf9T2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H009T2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A845F1357LCAliApli = H009T2_A845F1357LCAliApli[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A845F1357LCAliApli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A845F1357LCAliApli), 2, 0));
            A873F1357LC_Tope_anterior = H009T2_A873F1357LC_Tope_anterior[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A873F1357LC_Tope_anterior", GXutil.ltrimstr( A873F1357LC_Tope_anterior, 16, 2));
            A872F1357LC_MesesTributados = H009T2_A872F1357LC_MesesTributados[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A872F1357LC_MesesTributados", GXutil.ltrimstr( A872F1357LC_MesesTributados, 16, 2));
            A866F1357LC_GNSI = H009T2_A866F1357LC_GNSI[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A866F1357LC_GNSI", GXutil.ltrimstr( A866F1357LC_GNSI, 16, 2));
            A871F1357LC_Cuota_fija = H009T2_A871F1357LC_Cuota_fija[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A871F1357LC_Cuota_fija", GXutil.ltrimstr( A871F1357LC_Cuota_fija, 16, 2));
            /* Execute user event: Load */
            e129T2 ();
            pr_default.readNext(0);
         }
         pr_default.close(0);
         wb9T0( ) ;
      }
   }

   public void send_integrity_lvl_hashes9T2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup9T0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e119T2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         /* Read variables values. */
         A871F1357LC_Cuota_fija = localUtil.ctond( httpContext.cgiGet( edtF1357LC_Cuota_fija_Internalname)) ;
         httpContext.ajax_rsp_assign_attri("", false, "A871F1357LC_Cuota_fija", GXutil.ltrimstr( A871F1357LC_Cuota_fija, 16, 2));
         A866F1357LC_GNSI = localUtil.ctond( httpContext.cgiGet( edtF1357LC_GNSI_Internalname)) ;
         httpContext.ajax_rsp_assign_attri("", false, "A866F1357LC_GNSI", GXutil.ltrimstr( A866F1357LC_GNSI, 16, 2));
         A872F1357LC_MesesTributados = localUtil.ctond( httpContext.cgiGet( edtF1357LC_MesesTributados_Internalname)) ;
         httpContext.ajax_rsp_assign_attri("", false, "A872F1357LC_MesesTributados", GXutil.ltrimstr( A872F1357LC_MesesTributados, 16, 2));
         A873F1357LC_Tope_anterior = localUtil.ctond( httpContext.cgiGet( edtF1357LC_Tope_anterior_Internalname)) ;
         httpContext.ajax_rsp_assign_attri("", false, "A873F1357LC_Tope_anterior", GXutil.ltrimstr( A873F1357LC_Tope_anterior, 16, 2));
         cmbF1357LCAliApli.setValue( httpContext.cgiGet( cmbF1357LCAliApli.getInternalname()) );
         A845F1357LCAliApli = (byte)(GXutil.lval( httpContext.cgiGet( cmbF1357LCAliApli.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A845F1357LCAliApli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A845F1357LCAliApli), 2, 0));
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
      e119T2 ();
      if (returnInSub) return;
   }

   public void e119T2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
   }

   protected void nextLoad( )
   {
   }

   protected void e129T2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A784F1357CTipoPre = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
      A777F1357CPer = (String)getParm(obj,3) ;
      httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
      A778F1357CSec = ((Number) GXutil.testNumericType( getParm(obj,4), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
      A6LegNumero = ((Number) GXutil.testNumericType( getParm(obj,5), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
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
      pa9T2( ) ;
      ws9T2( ) ;
      we9T2( ) ;
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412202054498", true, true);
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
      if ( nGXWrapped != 1 )
      {
         httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
         httpContext.AddJavascriptSource("gxdec.js", "?"+httpContext.getBuildNumber( 214800), false, true);
         httpContext.AddJavascriptSource("f1357_mostrardeterminado.js", "?202412202054499", false, true);
      }
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtF1357LC_Cuota_fija_Internalname = "F1357LC_CUOTA_FIJA" ;
      edtF1357LC_GNSI_Internalname = "F1357LC_GNSI" ;
      edtF1357LC_MesesTributados_Internalname = "F1357LC_MESESTRIBUTADOS" ;
      edtF1357LC_Tope_anterior_Internalname = "F1357LC_TOPE_ANTERIOR" ;
      cmbF1357LCAliApli.setInternalname( "F1357LCALIAPLI" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
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
      cmbF1357LCAliApli.setJsonclick( "" );
      cmbF1357LCAliApli.setEnabled( 0 );
      edtF1357LC_Tope_anterior_Jsonclick = "" ;
      edtF1357LC_Tope_anterior_Enabled = 0 ;
      edtF1357LC_MesesTributados_Jsonclick = "" ;
      edtF1357LC_MesesTributados_Enabled = 0 ;
      edtF1357LC_GNSI_Jsonclick = "" ;
      edtF1357LC_GNSI_Enabled = 0 ;
      edtF1357LC_Cuota_fija_Jsonclick = "" ;
      edtF1357LC_Cuota_fija_Enabled = 0 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Composición del impuesto determinado", "") );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbF1357LCAliApli.setName( "F1357LCALIAPLI" );
      cmbF1357LCAliApli.setWebtags( "" );
      cmbF1357LCAliApli.addItem("0", "0%", (short)(0));
      cmbF1357LCAliApli.addItem("1", "5%", (short)(0));
      cmbF1357LCAliApli.addItem("2", "9%", (short)(0));
      cmbF1357LCAliApli.addItem("3", "12%", (short)(0));
      cmbF1357LCAliApli.addItem("4", "15%", (short)(0));
      cmbF1357LCAliApli.addItem("5", "19%", (short)(0));
      cmbF1357LCAliApli.addItem("6", "23%", (short)(0));
      cmbF1357LCAliApli.addItem("7", "27%", (short)(0));
      cmbF1357LCAliApli.addItem("8", "31%", (short)(0));
      cmbF1357LCAliApli.addItem("9", "35%", (short)(0));
      if ( cmbF1357LCAliApli.getItemCount() > 0 )
      {
         A845F1357LCAliApli = (byte)(GXutil.lval( cmbF1357LCAliApli.getValidValue(GXutil.trim( GXutil.str( A845F1357LCAliApli, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A845F1357LCAliApli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A845F1357LCAliApli), 2, 0));
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A784F1357CTipoPre',fld:'F1357CTIPOPRE',pic:'9'},{av:'A777F1357CPer',fld:'F1357CPER',pic:''},{av:'A778F1357CSec',fld:'F1357CSEC',pic:'Z9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
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
      wcpOA777F1357CPer = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A777F1357CPer = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      A871F1357LC_Cuota_fija = DecimalUtil.ZERO ;
      A866F1357LC_GNSI = DecimalUtil.ZERO ;
      A872F1357LC_MesesTributados = DecimalUtil.ZERO ;
      A873F1357LC_Tope_anterior = DecimalUtil.ZERO ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      scmdbuf = "" ;
      H009T2_A861F1357LCTipReg = new String[] {""} ;
      H009T2_A3CliCod = new int[1] ;
      H009T2_A1EmpCod = new short[1] ;
      H009T2_A784F1357CTipoPre = new byte[1] ;
      H009T2_A777F1357CPer = new String[] {""} ;
      H009T2_A778F1357CSec = new byte[1] ;
      H009T2_A6LegNumero = new int[1] ;
      H009T2_A845F1357LCAliApli = new byte[1] ;
      H009T2_A873F1357LC_Tope_anterior = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009T2_A872F1357LC_MesesTributados = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009T2_A866F1357LC_GNSI = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009T2_A871F1357LC_Cuota_fija = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.f1357_mostrardeterminado__default(),
         new Object[] {
             new Object[] {
            H009T2_A861F1357LCTipReg, H009T2_A3CliCod, H009T2_A1EmpCod, H009T2_A784F1357CTipoPre, H009T2_A777F1357CPer, H009T2_A778F1357CSec, H009T2_A6LegNumero, H009T2_A845F1357LCAliApli, H009T2_A873F1357LC_Tope_anterior, H009T2_A872F1357LC_MesesTributados,
            H009T2_A866F1357LC_GNSI, H009T2_A871F1357LC_Cuota_fija
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte wcpOA784F1357CTipoPre ;
   private byte wcpOA778F1357CSec ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte A784F1357CTipoPre ;
   private byte A778F1357CSec ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte A845F1357LCAliApli ;
   private byte nDonePA ;
   private short wcpOA1EmpCod ;
   private short A1EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOA3CliCod ;
   private int wcpOA6LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int edtF1357LC_Cuota_fija_Enabled ;
   private int edtF1357LC_GNSI_Enabled ;
   private int edtF1357LC_MesesTributados_Enabled ;
   private int edtF1357LC_Tope_anterior_Enabled ;
   private int idxLst ;
   private java.math.BigDecimal A871F1357LC_Cuota_fija ;
   private java.math.BigDecimal A866F1357LC_GNSI ;
   private java.math.BigDecimal A872F1357LC_MesesTributados ;
   private java.math.BigDecimal A873F1357LC_Tope_anterior ;
   private String wcpOA777F1357CPer ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A777F1357CPer ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String divTableattributes_Internalname ;
   private String edtF1357LC_Cuota_fija_Internalname ;
   private String edtF1357LC_Cuota_fija_Jsonclick ;
   private String edtF1357LC_GNSI_Internalname ;
   private String edtF1357LC_GNSI_Jsonclick ;
   private String edtF1357LC_MesesTributados_Internalname ;
   private String edtF1357LC_MesesTributados_Jsonclick ;
   private String edtF1357LC_Tope_anterior_Internalname ;
   private String edtF1357LC_Tope_anterior_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String scmdbuf ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private HTMLChoice cmbF1357LCAliApli ;
   private IDataStoreProvider pr_default ;
   private String[] H009T2_A861F1357LCTipReg ;
   private int[] H009T2_A3CliCod ;
   private short[] H009T2_A1EmpCod ;
   private byte[] H009T2_A784F1357CTipoPre ;
   private String[] H009T2_A777F1357CPer ;
   private byte[] H009T2_A778F1357CSec ;
   private int[] H009T2_A6LegNumero ;
   private byte[] H009T2_A845F1357LCAliApli ;
   private java.math.BigDecimal[] H009T2_A873F1357LC_Tope_anterior ;
   private java.math.BigDecimal[] H009T2_A872F1357LC_MesesTributados ;
   private java.math.BigDecimal[] H009T2_A866F1357LC_GNSI ;
   private java.math.BigDecimal[] H009T2_A871F1357LC_Cuota_fija ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class f1357_mostrardeterminado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H009T2", "SELECT F1357LCTipReg, CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LCAliApli, F1357LC_Tope_anterior, F1357LC_MesesTributados, F1357LC_GNSI, F1357LC_Cuota_fija FROM F1357LCalculo WHERE CliCod = ? and EmpCod = ? and F1357CTipoPre = ? and F1357CPer = ( ?) and F1357CSec = ? and LegNumero = ? ORDER BY CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 2);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 6);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
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
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
      }
   }

}

