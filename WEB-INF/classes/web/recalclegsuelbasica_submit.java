package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class recalclegsuelbasica_submit extends GXProcedure
{
   public recalclegsuelbasica_submit( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( recalclegsuelbasica_submit.class ), "" );
   }

   public recalclegsuelbasica_submit( int remoteHandle ,
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
      recalclegsuelbasica_submit.this.AV8parametros = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9parm_recLegSuelBas.fromJSonString(AV8parametros, null);
      new web.recalcularlegsuelbasicaporlegupd(remoteHandle, context).execute( AV9parm_recLegSuelBas.getgxTv_Sdtparm_recLegSuelBas_Clipaicod(), AV9parm_recLegSuelBas.getgxTv_Sdtparm_recLegSuelBas_Clicod(), AV9parm_recLegSuelBas.getgxTv_Sdtparm_recLegSuelBas_Empcod(), AV9parm_recLegSuelBas.getgxTv_Sdtparm_recLegSuelBas_Parmlegnumero(), AV9parm_recLegSuelBas.getgxTv_Sdtparm_recLegSuelBas_Trnpalabra()) ;
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
      AV9parm_recLegSuelBas = new web.Sdtparm_recLegSuelBas(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8parametros ;
   private web.Sdtparm_recLegSuelBas AV9parm_recLegSuelBas ;
}

