package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class invocar_chequearliquidacionfin extends GXProcedure
{
   public invocar_chequearliquidacionfin( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( invocar_chequearliquidacionfin.class ), "" );
   }

   public invocar_chequearliquidacionfin( int remoteHandle ,
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
      invocar_chequearliquidacionfin.this.AV14bodyJSON = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15body_chequearLiquidacionFin.fromJSonString(AV14bodyJSON, null);
      AV19daemonUUID = AV15body_chequearLiquidacionFin.getgxTv_Sdtbody_chequearLiquidacionFin_Daemonuuid() ;
      AV8CliCod = AV15body_chequearLiquidacionFin.getgxTv_Sdtbody_chequearLiquidacionFin_Clicod() ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV22Pgmname, "1") ;
      GXv_boolean1[0] = AV16RestLocHab ;
      GXv_char2[0] = AV17error ;
      new web.invocar_rest(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "chequearLiquidacionFin", ""), AV14bodyJSON, GXv_boolean1, GXv_char2) ;
      invocar_chequearliquidacionfin.this.AV16RestLocHab = GXv_boolean1[0] ;
      invocar_chequearliquidacionfin.this.AV17error = GXv_char2[0] ;
      AV9EmpCod = AV15body_chequearLiquidacionFin.getgxTv_Sdtbody_chequearLiquidacionFin_Empcod() ;
      AV10LiqNro = AV15body_chequearLiquidacionFin.getgxTv_Sdtbody_chequearLiquidacionFin_Liqnro() ;
      if ( ! AV16RestLocHab )
      {
         AV11cantidadPorLote = AV15body_chequearLiquidacionFin.getgxTv_Sdtbody_chequearLiquidacionFin_Cantidadporlote() ;
         AV12cantidadDeLotes = AV15body_chequearLiquidacionFin.getgxTv_Sdtbody_chequearLiquidacionFin_Cantidaddelotes() ;
         AV13clientId = AV15body_chequearLiquidacionFin.getgxTv_Sdtbody_chequearLiquidacionFin_Clientid() ;
         callSubmit( 1 , new Object[]{ Integer.valueOf(AV8CliCod),Short.valueOf(AV9EmpCod),Integer.valueOf(AV10LiqNro),Short.valueOf(AV11cantidadPorLote),Short.valueOf(AV12cantidadDeLotes),AV13clientId,AV19daemonUUID });
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV17error)==0) )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV22Pgmname, httpContext.getMessage( "&error ", "")+AV17error) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV22Pgmname, httpContext.getMessage( "&&CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " &EmpCod ", "")+GXutil.trim( GXutil.str( AV9EmpCod, 4, 0))+httpContext.getMessage( " &LiqNro ", "")+GXutil.trim( GXutil.str( AV10LiqNro, 8, 0))) ;
            GXv_boolean1[0] = false ;
            new web.liqseteaestadoyerror(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro, AV17error, (byte)(2), (byte)(2), GXv_boolean1) ;
            new web.setliqcancel(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro, true) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV22Pgmname, "&2 ") ;
         }
      }
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
                  new web.orquestaliquidacion(remoteHandle, submitContext).execute( ((Number) submitParms[0]).intValue(), ((Number) submitParms[1]).shortValue(), ((Number) submitParms[2]).intValue(), ((Number) submitParms[3]).shortValue(), ((Number) submitParms[4]).shortValue(), (String)submitParms[5], (String)submitParms[6]) ;
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
      AV15body_chequearLiquidacionFin = new web.Sdtbody_chequearLiquidacionFin(remoteHandle, context);
      AV19daemonUUID = "" ;
      AV22Pgmname = "" ;
      AV17error = "" ;
      GXv_char2 = new String[1] ;
      AV13clientId = "" ;
      GXv_boolean1 = new boolean[1] ;
      AV22Pgmname = "invocar_chequearLiquidacionFin" ;
      /* GeneXus formulas. */
      AV22Pgmname = "invocar_chequearLiquidacionFin" ;
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV11cantidadPorLote ;
   private short AV12cantidadDeLotes ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LiqNro ;
   private String AV19daemonUUID ;
   private String AV22Pgmname ;
   private String GXv_char2[] ;
   private boolean AV16RestLocHab ;
   private boolean GXv_boolean1[] ;
   private String AV14bodyJSON ;
   private String AV17error ;
   private String AV13clientId ;
   private web.Sdtbody_chequearLiquidacionFin AV15body_chequearLiquidacionFin ;
}

