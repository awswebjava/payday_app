package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.legajofamilia", "/web.legajofamilia"})
public final  class legajofamilia extends GXWebObjectStub
{
   public legajofamilia( )
   {
   }

   public legajofamilia( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( legajofamilia.class ));
   }

   public legajofamilia( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new legajofamilia_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new legajofamilia_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Legajo Familia";
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
      return "legajofamilia_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

