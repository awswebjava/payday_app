package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipoliquidaciongeneral", "/web.tipoliquidaciongeneral"})
public final  class tipoliquidaciongeneral extends GXWebObjectStub
{
   public tipoliquidaciongeneral( )
   {
   }

   public tipoliquidaciongeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipoliquidaciongeneral.class ));
   }

   public tipoliquidaciongeneral( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipoliquidaciongeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipoliquidaciongeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo Liquidacion General";
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

