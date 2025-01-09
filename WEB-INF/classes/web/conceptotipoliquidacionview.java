package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.conceptotipoliquidacionview", "/web.conceptotipoliquidacionview"})
public final  class conceptotipoliquidacionview extends GXWebObjectStub
{
   public conceptotipoliquidacionview( )
   {
   }

   public conceptotipoliquidacionview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( conceptotipoliquidacionview.class ));
   }

   public conceptotipoliquidacionview( int remoteHandle ,
                                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new conceptotipoliquidacionview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new conceptotipoliquidacionview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Concepto Tipo Liquidacion View";
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

}

