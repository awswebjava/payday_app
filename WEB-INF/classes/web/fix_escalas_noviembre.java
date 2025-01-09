package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class fix_escalas_noviembre extends GXProcedure
{
   public fix_escalas_noviembre( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( fix_escalas_noviembre.class ), "" );
   }

   public fix_escalas_noviembre( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set CatValorHora = (CatValorHora + 1) WHERE cliconvenio = '76/75' and CatVigencia = '20231101' and CatValorHora = 1221; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set catadihora = (catadihora + 1) where cliconvenio = '76/75' and CatVigencia = '20231101' and catadihora = 1042; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set catadihora = (catadihora + 1) where cliconvenio = '76/75' and CatVigencia = '20231101' and catadihora = 1221; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set CatValorHora = (CatValorHora + 1) where cliconvenio = '76/75' and CatVigencia = '20231101' and CatValorHora = 1330; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set catadihora = (catadihora - 1) where cliconvenio = '76/75' and CatVigencia = '20231101' and catadihora = 145; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set catadihora = (catadihora + 1) where cliconvenio = '76/75' and CatVigencia = '20231101' and catadihora = 1007; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set catadihora = (catadihora + 1) where cliconvenio = '76/75' and CatVigencia = '20231101' and catadihora = 1330; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set CatValorHora = (CatValorHora + 1) WHERE cliconvenio = '76/75' and CatVigencia = '20231101' and CatValorHora = 1443; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set catadihora = (catadihora + 2) WHERE cliconvenio = '76/75' and CatVigencia = '20231101' and catadihora = 158; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set catadihora = (catadihora - 1) WHERE cliconvenio = '76/75' and CatVigencia = '20231101' and catadihora = 986; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set catadihora = (catadihora + 1) WHERE cliconvenio = '76/75' and CatVigencia = '20231101' and catadihora = 1443; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set CatValorHora = (CatValorHora - 1) WHERE cliconvenio = '76/75' and CatVigencia = '20231101' and CatValorHora = 1695; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set catadihora = (catadihora + 1) WHERE cliconvenio = '76/75' and CatVigencia = '20231101' and catadihora = 185; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set catadihora = (catadihora - 1) WHERE cliconvenio = '76/75' and CatVigencia = '20231101' and catadihora = 908; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set catadihora = (catadihora - 1) WHERE cliconvenio = '76/75' and CatVigencia = '20231101' and catadihora = 1695; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set CatBasico = CatBasico + 2 WHERE cliconvenio = '76/75' and CatVigencia = '20231101' and CatBasico = 221707; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set CatAdicional = CatAdicional + 2 WHERE cliconvenio = '76/75' and CatVigencia = '20231101' and CatAdicional = 148938; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set CatAdicional = CatAdicional + 2 WHERE cliconvenio = '76/75' and CatVigencia = '20231101' and CatAdicional = 221707; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set CatBasico = CatBasico - 1 WHERE cliconvenio = '660/13' and CatVigencia = '20231101' and CatBasico = 454292; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set CatAdicional = CatAdicional - 1 WHERE cliconvenio = '660/13' and CatVigencia = '20231101' and CatAdicional = 454292; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set CatBasico = CatBasico - 1 WHERE cliconvenio = '660/13' and CatVigencia = '20231101' and CatBasico = 393375; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set CatAdicional = CatAdicional - 1 WHERE cliconvenio = '660/13' and CatVigencia = '20231101' and CatAdicional = 393375; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set CatBasico = CatBasico + 1 WHERE cliconvenio = '660/13' and CatVigencia = '20231101' and CatBasico = 430121; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set CatAdicional = CatAdicional + 1 WHERE cliconvenio = '660/13' and CatVigencia = '20231101' and CatAdicional = 430121; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set CatBasico = CatBasico - 2 WHERE cliconvenio = '660/13' and CatVigencia = '20231101' and CatBasico = 363145; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* User SQL Command. */
      cmdBuffer = "  update Categoriavalores1 set CatAdicional = CatAdicional - 2 WHERE cliconvenio = '660/13' and CatVigencia = '20231101' and CatAdicional = 363145; commit; ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
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
      cmdBuffer = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String cmdBuffer ;
}

