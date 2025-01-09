package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.wizardconceptosafipsteps", "/web.wwpbaseobjects.wizardconceptosafipsteps"})
public final  class wizardconceptosafipsteps extends GXWebObjectStub
{
   public wizardconceptosafipsteps( )
   {
   }

   public wizardconceptosafipsteps( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wizardconceptosafipsteps.class ));
   }

   public wizardconceptosafipsteps( int remoteHandle ,
                                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wizardconceptosafipsteps_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wizardconceptosafipsteps_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Wizard Conceptos Afip Steps";
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

