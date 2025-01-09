package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class procliquidacionsegundaparteasync extends GXProcedure
{
   public procliquidacionsegundaparteasync( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( procliquidacionsegundaparteasync.class ), "" );
   }

   public procliquidacionsegundaparteasync( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        GXSimpleCollection<Integer> aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 )
   {
      procliquidacionsegundaparteasync.this.AV8CliCod = aP0;
      procliquidacionsegundaparteasync.this.AV9EmpCod = aP1;
      procliquidacionsegundaparteasync.this.AV10LiqNro = aP2;
      procliquidacionsegundaparteasync.this.AV28LegNumero = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV34Pgmname, httpContext.getMessage( "1 &CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " &EmpCod ", "")+GXutil.trim( GXutil.str( AV9EmpCod, 4, 0))+httpContext.getMessage( " &LiqNro ", "")+GXutil.trim( GXutil.str( AV10LiqNro, 8, 0))) ;
      GXv_char1[0] = AV25TLiqCod ;
      new web.gettipoliq(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro, GXv_char1) ;
      procliquidacionsegundaparteasync.this.AV25TLiqCod = GXv_char1[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV34Pgmname, "2") ;
      callSubmit( 1 , new Object[]{ Integer.valueOf(AV8CliCod),Short.valueOf(AV9EmpCod),Integer.valueOf(AV10LiqNro),AV28LegNumero });
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV34Pgmname, "3") ;
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
   public void submit( int submitId ,
                       Object [] submitParms ,
                       ModelContext submitContext )
   {
      UserInformation submitUI = (UserInformation) GXObjectHelper.getUserInformation(context, -1);
      int remoteHandle = submitUI.getHandle();
      try
      {
         switch ( submitId )
         {
               case 1 :
                  new web.calculaimporteliquidacionlegajoasync(remoteHandle, submitContext).execute( ((Number) submitParms[0]).intValue(), ((Number) submitParms[1]).shortValue(), ((Number) submitParms[2]).intValue(), (GXSimpleCollection<Integer>)submitParms[3]) ;
                  try { Application.getConnectionManager().disconnect(remoteHandle); } catch(Exception submitExc) { ; }
                  break;
         }
      }
      catch ( Exception e )
      {
         Application.cleanupConnection(remoteHandle);
         e.printStackTrace();
      }
   }

   public void initialize( )
   {
      AV34Pgmname = "" ;
      AV25TLiqCod = "" ;
      GXv_char1 = new String[1] ;
      AV34Pgmname = "ProcLiquidacionSegundaParteAsync" ;
      /* GeneXus formulas. */
      AV34Pgmname = "ProcLiquidacionSegundaParteAsync" ;
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LiqNro ;
   private String AV34Pgmname ;
   private String AV25TLiqCod ;
   private String GXv_char1[] ;
   private GXSimpleCollection<Integer> AV28LegNumero ;
}

