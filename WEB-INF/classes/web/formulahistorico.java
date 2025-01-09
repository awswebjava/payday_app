package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.formulahistorico", "/web.formulahistorico"})
public final  class formulahistorico extends GXWebObjectStub
{
   public formulahistorico( )
   {
   }

   public formulahistorico( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( formulahistorico.class ));
   }

   public formulahistorico( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new formulahistorico_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new formulahistorico_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Formula Historico";
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

