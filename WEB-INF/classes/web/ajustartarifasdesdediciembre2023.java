package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ajustartarifasdesdediciembre2023 extends GXProcedure
{
   public ajustartarifasdesdediciembre2023( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ajustartarifasdesdediciembre2023.class ), "" );
   }

   public ajustartarifasdesdediciembre2023( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      ajustartarifasdesdediciembre2023.this.AV9CliCod = aP0;
      ajustartarifasdesdediciembre2023.this.AV8CliPaiConve = aP1;
      ajustartarifasdesdediciembre2023.this.AV10CliRelSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.ajustartarifas(remoteHandle, context).execute( AV9CliCod, AV8CliPaiConve, new web.conveniouocra(remoteHandle, context).executeUdp( ), localUtil.ymdtod( 2023, 11, 1), DecimalUtil.stringToDec("1.11"), localUtil.ymdtod( 2023, 12, 1), httpContext.getMessage( "Redondear", ""), AV10CliRelSec) ;
      new web.ajustartarifas(remoteHandle, context).execute( AV9CliCod, AV8CliPaiConve, new web.conveniouocra(remoteHandle, context).executeUdp( ), localUtil.ymdtod( 2023, 12, 1), DecimalUtil.stringToDec("1.20"), localUtil.ymdtod( 2024, 1, 1), httpContext.getMessage( "Redondear", ""), AV10CliRelSec) ;
      new web.ajustartarifas(remoteHandle, context).execute( AV9CliCod, AV8CliPaiConve, new web.conveniouocra(remoteHandle, context).executeUdp( ), localUtil.ymdtod( 2024, 1, 1), DecimalUtil.stringToDec("1.14"), localUtil.ymdtod( 2024, 2, 1), httpContext.getMessage( "Redondear", ""), AV10CliRelSec) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, "1") ;
      new web.ajustartarifas(remoteHandle, context).execute( AV9CliCod, AV8CliPaiConve, new web.conveniouocra(remoteHandle, context).executeUdp( ), localUtil.ymdtod( 2024, 2, 1), DecimalUtil.stringToDec("1.14"), localUtil.ymdtod( 2024, 3, 1), httpContext.getMessage( "Redondear", ""), AV10CliRelSec) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, "2") ;
      new web.ajustartarifas(remoteHandle, context).execute( AV9CliCod, AV8CliPaiConve, new web.conveniouocra(remoteHandle, context).executeUdp( ), localUtil.ymdtod( 2024, 3, 1), DecimalUtil.doubleToDec(1), localUtil.ymdtod( 2024, 4, 1), httpContext.getMessage( "Redondear", ""), AV10CliRelSec) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, "3") ;
      new web.ajustartarifas(remoteHandle, context).execute( AV9CliCod, AV8CliPaiConve, new web.conveniouocra(remoteHandle, context).executeUdp( ), localUtil.ymdtod( 2024, 4, 1), DecimalUtil.stringToDec("1.11"), localUtil.ymdtod( 2024, 5, 1), httpContext.getMessage( "Redondear", ""), AV10CliRelSec) ;
      new web.ajustartarifas(remoteHandle, context).execute( AV9CliCod, AV8CliPaiConve, new web.conveniouocra(remoteHandle, context).executeUdp( ), localUtil.ymdtod( 2024, 5, 1), DecimalUtil.stringToDec("1.11"), localUtil.ymdtod( 2024, 6, 1), httpContext.getMessage( "Redondear", ""), AV10CliRelSec) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, "4") ;
      new web.ajustartarifas(remoteHandle, context).execute( AV9CliCod, AV8CliPaiConve, new web.conveniouecara(remoteHandle, context).executeUdp( ), localUtil.ymdtod( 2023, 12, 1), DecimalUtil.stringToDec("1.20"), localUtil.ymdtod( 2024, 1, 1), httpContext.getMessage( "Redondear", ""), AV10CliRelSec) ;
      new web.ajustartarifas(remoteHandle, context).execute( AV9CliCod, AV8CliPaiConve, new web.conveniouecara(remoteHandle, context).executeUdp( ), localUtil.ymdtod( 2024, 1, 1), DecimalUtil.stringToDec("1.14"), localUtil.ymdtod( 2024, 2, 1), httpContext.getMessage( "Redondear", ""), AV10CliRelSec) ;
      new web.ajustartarifas(remoteHandle, context).execute( AV9CliCod, AV8CliPaiConve, new web.conveniouecara(remoteHandle, context).executeUdp( ), localUtil.ymdtod( 2024, 2, 1), DecimalUtil.stringToDec("1.1"), localUtil.ymdtod( 2024, 3, 1), httpContext.getMessage( "Redondear", ""), AV10CliRelSec) ;
      new web.ajustartarifas(remoteHandle, context).execute( AV9CliCod, AV8CliPaiConve, new web.conveniouecara(remoteHandle, context).executeUdp( ), localUtil.ymdtod( 2024, 3, 1), DecimalUtil.stringToDec("1.14"), localUtil.ymdtod( 2024, 4, 1), httpContext.getMessage( "Redondear", ""), AV10CliRelSec) ;
      new web.ajustartarifas(remoteHandle, context).execute( AV9CliCod, AV8CliPaiConve, new web.conveniouecara(remoteHandle, context).executeUdp( ), localUtil.ymdtod( 2024, 4, 1), DecimalUtil.stringToDec("1.11"), localUtil.ymdtod( 2024, 5, 1), httpContext.getMessage( "Redondear", ""), AV10CliRelSec) ;
      new web.ajustartarifas(remoteHandle, context).execute( AV9CliCod, AV8CliPaiConve, new web.conveniouecara(remoteHandle, context).executeUdp( ), localUtil.ymdtod( 2024, 5, 1), DecimalUtil.stringToDec("1.11"), localUtil.ymdtod( 2024, 6, 1), httpContext.getMessage( "Redondear", ""), AV10CliRelSec) ;
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
      AV13Pgmname = "" ;
      AV13Pgmname = "ajustarTarifasDesdeDiciembre2023" ;
      /* GeneXus formulas. */
      AV13Pgmname = "ajustarTarifasDesdeDiciembre2023" ;
      Gx_err = (short)(0) ;
   }

   private short AV8CliPaiConve ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV10CliRelSec ;
   private String AV13Pgmname ;
}

