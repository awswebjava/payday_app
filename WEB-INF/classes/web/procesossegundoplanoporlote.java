package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class procesossegundoplanoporlote extends GXProcedure
{
   public procesossegundoplanoporlote( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( procesossegundoplanoporlote.class ), "" );
   }

   public procesossegundoplanoporlote( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        GXSimpleCollection<Integer> aP3 ,
                        String aP4 ,
                        boolean aP5 ,
                        String aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        String aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 ,
                             String aP4 ,
                             boolean aP5 ,
                             String aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             String aP9 )
   {
      procesossegundoplanoporlote.this.AV8CliCod = aP0;
      procesossegundoplanoporlote.this.AV10EmpCod = aP1;
      procesossegundoplanoporlote.this.AV15LiqNro = aP2;
      procesossegundoplanoporlote.this.AV14LegNumero = aP3;
      procesossegundoplanoporlote.this.AV9ClientId = aP4;
      procesossegundoplanoporlote.this.AV23importacionEs = aP5;
      procesossegundoplanoporlote.this.AV24LiqLote = aP6;
      procesossegundoplanoporlote.this.AV25palabra = aP7;
      procesossegundoplanoporlote.this.AV26forzarSincrono = aP8;
      procesossegundoplanoporlote.this.AV27daemonUUID = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV30Pgmname, httpContext.getMessage( "&ClientId ", "")+GXutil.trim( AV9ClientId)+httpContext.getMessage( " palabra ", "")+AV25palabra) ;
      GXv_char1[0] = AV16ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.conceptos_aux_metodo_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
      procesossegundoplanoporlote.this.AV16ParmValue = GXv_char1[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV30Pgmname, httpContext.getMessage( "&ParmValue ", "")+AV16ParmValue) ;
      if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV16ParmValue)), httpContext.getMessage( "SUBMIT", "")) == 0 ) && ! AV23importacionEs && ! AV26forzarSincrono )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV30Pgmname, httpContext.getMessage( "submit 1", "")) ;
         callSubmit( 1 , new Object[]{ Integer.valueOf(AV8CliCod),Short.valueOf(AV10EmpCod),AV14LegNumero,Integer.valueOf(AV15LiqNro),AV9ClientId,AV24LiqLote,AV25palabra,AV27daemonUUID });
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV30Pgmname, httpContext.getMessage( "submit 2", "")) ;
      }
      else
      {
         new web.generarconceptosauxiliaresporlote(remoteHandle, context).execute( AV8CliCod, AV10EmpCod, AV14LegNumero, AV15LiqNro, AV9ClientId, AV24LiqLote, AV25palabra, AV27daemonUUID) ;
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
                  new web.generarconceptosauxiliaresporlote(remoteHandle, submitContext).execute( ((Number) submitParms[0]).intValue(), ((Number) submitParms[1]).shortValue(), (GXSimpleCollection<Integer>)submitParms[2], ((Number) submitParms[3]).intValue(), (String)submitParms[4], (String)submitParms[5], (String)submitParms[6], (String)submitParms[7]) ;
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
      AV30Pgmname = "" ;
      AV16ParmValue = "" ;
      GXv_char1 = new String[1] ;
      AV30Pgmname = "procesosSegundoPlanoPorLote" ;
      /* GeneXus formulas. */
      AV30Pgmname = "procesosSegundoPlanoPorLote" ;
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV15LiqNro ;
   private String AV25palabra ;
   private String AV27daemonUUID ;
   private String AV30Pgmname ;
   private String GXv_char1[] ;
   private boolean AV23importacionEs ;
   private boolean AV26forzarSincrono ;
   private String AV16ParmValue ;
   private String AV9ClientId ;
   private String AV24LiqLote ;
   private GXSimpleCollection<Integer> AV14LegNumero ;
}

