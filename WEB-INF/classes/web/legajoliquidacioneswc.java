package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.legajoliquidacioneswc", "/web.legajoliquidacioneswc"})
public final  class legajoliquidacioneswc extends GXWebObjectStub
{
   public legajoliquidacioneswc( )
   {
   }

   public legajoliquidacioneswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( legajoliquidacioneswc.class ));
   }

   public legajoliquidacioneswc( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new legajoliquidacioneswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new legajoliquidacioneswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Legajo Liquidaciones WC";
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

