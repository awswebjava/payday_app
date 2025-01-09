package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inipercclic_submit extends GXProcedure
{
   public inipercclic_submit( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inipercclic_submit.class ), "" );
   }

   public inipercclic_submit( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String aP0 )
   {
      inipercclic_submit.this.AV9parametros = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8parm_iniPerCCLic.fromJSonString(AV9parametros, null);
      new web.inicializarperiodoscclic(remoteHandle, context).execute( AV8parm_iniPerCCLic.getgxTv_Sdtparm_iniPerCCLic_Clicod(), AV8parm_iniPerCCLic.getgxTv_Sdtparm_iniPerCCLic_Empcod(), AV8parm_iniPerCCLic.getgxTv_Sdtparm_iniPerCCLic_Legnumero(), AV8parm_iniPerCCLic.getgxTv_Sdtparm_iniPerCCLic_Desdeanio()) ;
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8parm_iniPerCCLic = new web.Sdtparm_iniPerCCLic(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9parametros ;
   private web.Sdtparm_iniPerCCLic AV8parm_iniPerCCLic ;
}

