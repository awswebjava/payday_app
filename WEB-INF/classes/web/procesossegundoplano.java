package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class procesossegundoplano extends GXProcedure
{
   public procesossegundoplano( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( procesossegundoplano.class ), "" );
   }

   public procesossegundoplano( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        GXSimpleCollection<Integer> aP3 ,
                        String aP4 ,
                        boolean aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 ,
                             String aP4 ,
                             boolean aP5 )
   {
      procesossegundoplano.this.AV8CliCod = aP0;
      procesossegundoplano.this.AV9EmpCod = aP1;
      procesossegundoplano.this.AV10LiqNro = aP2;
      procesossegundoplano.this.AV11LegNumero = aP3;
      procesossegundoplano.this.AV17ClientId = aP4;
      procesossegundoplano.this.AV23importacionEs = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "&ClientId ", "")+GXutil.trim( AV17ClientId)) ;
      GXv_boolean1[0] = AV19SoapLocHab ;
      GXv_char2[0] = AV18error ;
      new web.soap_location_set(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "generarConceptosAuxiliares_soap", ""), GXv_boolean1, GXv_char2) ;
      procesossegundoplano.this.AV19SoapLocHab = GXv_boolean1[0] ;
      procesossegundoplano.this.AV18error = GXv_char2[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "1 &SoapLocHab ", "")+GXutil.trim( GXutil.booltostr( AV19SoapLocHab))) ;
      if ( ! AV19SoapLocHab )
      {
         GXv_char2[0] = AV14ParmValue ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.conceptos_aux_metodo_codigoparam(remoteHandle, context).executeUdp( ), GXv_char2) ;
         procesossegundoplano.this.AV14ParmValue = GXv_char2[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "&ParmValue ", "")+AV14ParmValue) ;
         if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV14ParmValue)), httpContext.getMessage( "SUBMIT", "")) == 0 ) && ! AV23importacionEs )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "submit 1", "")) ;
            callSubmit( 1 , new Object[]{ Integer.valueOf(AV8CliCod),Short.valueOf(AV9EmpCod),Integer.valueOf(0),Integer.valueOf(AV10LiqNro),AV17ClientId });
            new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "submit 2", "")) ;
         }
         else
         {
            new web.generarconceptosauxiliares(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, 0, AV10LiqNro, AV17ClientId) ;
         }
      }
      else
      {
         AV22generarConceptosAuxiliares_soap.execute(AV8CliCod, AV9EmpCod, 0, AV10LiqNro, AV17ClientId);
         AV20errNumber = context.globals.getSoapErr( ) ;
         if ( AV20errNumber != 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "!!GetSOAPErrMsg() ", "")+context.globals.getSoapErrMsg( )) ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, "!!3") ;
      }
      if ( ! AV23importacionEs )
      {
         GXv_boolean1[0] = AV19SoapLocHab ;
         GXv_char2[0] = AV18error ;
         new web.soap_location_set(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "procesosSegundoPlanoPDF_soap", ""), GXv_boolean1, GXv_char2) ;
         procesossegundoplano.this.AV19SoapLocHab = GXv_boolean1[0] ;
         procesossegundoplano.this.AV18error = GXv_char2[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "pdf &SoapLocHab ", "")+GXutil.trim( GXutil.booltostr( AV19SoapLocHab))) ;
         if ( ! AV19SoapLocHab )
         {
            new web.procesossegundoplanopdf(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro, AV11LegNumero, AV17ClientId, "", AV26Pgmname) ;
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "pdf 1", "")) ;
            if ( ! (GXutil.strcmp("", AV18error)==0) )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, AV18error) ;
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "pdf 2!", "")) ;
               AV21procesosSegundoPlanoPDF_soap.execute(AV8CliCod, AV9EmpCod, AV10LiqNro, AV11LegNumero, AV17ClientId);
               new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "pdf 3!", "")) ;
               AV20errNumber = context.globals.getSoapErr( ) ;
               if ( AV20errNumber != 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "pdf GetSOAPErrMsg() ", "")+context.globals.getSoapErrMsg( )) ;
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, "3") ;
            }
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
                  new web.generarconceptosauxiliares(remoteHandle, submitContext).execute( ((Number) submitParms[0]).intValue(), ((Number) submitParms[1]).shortValue(), ((Number) submitParms[2]).intValue(), ((Number) submitParms[3]).intValue(), (String)submitParms[4]) ;
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
      AV26Pgmname = "" ;
      AV18error = "" ;
      AV14ParmValue = "" ;
      AV22generarConceptosAuxiliares_soap = new web.SdtgenerarConceptosAuxiliares_soap(remoteHandle, context);
      GXv_boolean1 = new boolean[1] ;
      GXv_char2 = new String[1] ;
      AV21procesosSegundoPlanoPDF_soap = new web.SdtprocesosSegundoPlanoPDF_soap(remoteHandle, context);
      AV26Pgmname = "procesosSegundoPlano" ;
      /* GeneXus formulas. */
      AV26Pgmname = "procesosSegundoPlano" ;
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LiqNro ;
   private int AV20errNumber ;
   private String AV26Pgmname ;
   private String GXv_char2[] ;
   private boolean AV23importacionEs ;
   private boolean AV19SoapLocHab ;
   private boolean GXv_boolean1[] ;
   private String AV14ParmValue ;
   private String AV17ClientId ;
   private String AV18error ;
   private GXSimpleCollection<Integer> AV11LegNumero ;
   private web.SdtprocesosSegundoPlanoPDF_soap AV21procesosSegundoPlanoPDF_soap ;
   private web.SdtgenerarConceptosAuxiliares_soap AV22generarConceptosAuxiliares_soap ;
}

