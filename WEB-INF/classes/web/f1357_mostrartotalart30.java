package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.f1357_mostrartotalart30", "/web.f1357_mostrartotalart30"})
public final  class f1357_mostrartotalart30 extends GXWebObjectStub
{
   public f1357_mostrartotalart30( )
   {
   }

   public f1357_mostrartotalart30( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( f1357_mostrartotalart30.class ));
   }

   public f1357_mostrartotalart30( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new f1357_mostrartotalart30_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new f1357_mostrartotalart30_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Composición de total deducciones art. 30";
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

