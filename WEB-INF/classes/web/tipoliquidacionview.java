package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipoliquidacionview", "/web.tipoliquidacionview"})
public final  class tipoliquidacionview extends GXWebObjectStub
{
   public tipoliquidacionview( )
   {
   }

   public tipoliquidacionview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipoliquidacionview.class ));
   }

   public tipoliquidacionview( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipoliquidacionview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipoliquidacionview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo Liquidacion View";
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

