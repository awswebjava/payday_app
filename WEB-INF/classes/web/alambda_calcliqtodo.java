package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class alambda_calcliqtodo extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(web.GXcfg.class);
      alambda_calcliqtodo pgm = new alambda_calcliqtodo (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      String aP0 = "";
      com.genexus.genexusserverlessapi.SdtEventMessageResponse[] aP1 = new com.genexus.genexusserverlessapi.SdtEventMessageResponse[] {new com.genexus.genexusserverlessapi.SdtEventMessageResponse()};

      try
      {
         aP0 = (String) args[0];
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0, aP1);
   }

   public alambda_calcliqtodo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( alambda_calcliqtodo.class ), "" );
   }

   public alambda_calcliqtodo( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.genexus.genexusserverlessapi.SdtEventMessageResponse executeUdp( String aP0 )
   {
      alambda_calcliqtodo.this.aP1 = new com.genexus.genexusserverlessapi.SdtEventMessageResponse[] {new com.genexus.genexusserverlessapi.SdtEventMessageResponse()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        com.genexus.genexusserverlessapi.SdtEventMessageResponse[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             com.genexus.genexusserverlessapi.SdtEventMessageResponse[] aP1 )
   {
      alambda_calcliqtodo.this.AV36RawData = aP0;
      alambda_calcliqtodo.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_objcol_vchar1[0] = AV41cuerpos ;
      GXv_char2[0] = AV15error ;
      new web.parseawsparms(remoteHandle, context).execute( AV36RawData, GXv_objcol_vchar1, GXv_char2) ;
      AV41cuerpos = GXv_objcol_vchar1[0] ;
      alambda_calcliqtodo.this.AV15error = GXv_char2[0] ;
      if ( ! (GXutil.strcmp("", AV15error)==0) )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV42i = (short)(1) ;
      while ( AV42i <= AV41cuerpos.size() )
      {
         AV40body = (String)AV41cuerpos.elementAt(-1+AV42i) ;
         AV37sdt_datos_liq = (web.Sdtsdt_datos_liq)new web.Sdtsdt_datos_liq(remoteHandle, context);
         AV37sdt_datos_liq.fromJSonString(AV40body, null);
         AV9CliCod = AV37sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Clicod() ;
         GXv_char2[0] = AV34MetaParmValue ;
         new web.getmetaparmvalue(remoteHandle, context).execute( httpContext.getMessage( "env", ""), GXv_char2) ;
         alambda_calcliqtodo.this.AV34MetaParmValue = GXv_char2[0] ;
         System.out.println( httpContext.getMessage( "&i ", "")+GXutil.trim( GXutil.str( AV42i, 4, 0))+httpContext.getMessage( " &clicod ", "")+GXutil.trim( GXutil.str( AV9CliCod, 6, 0)) );
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV45Pgmname, httpContext.getMessage( "&MetaParmValue ", "")+GXutil.upper( GXutil.trim( AV34MetaParmValue))+httpContext.getMessage( " &sdt_datos_liq.env ", "")+GXutil.upper( GXutil.trim( AV37sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Env()))) ;
         if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV34MetaParmValue)), GXutil.upper( GXutil.trim( AV37sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Env()))) != 0 )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( (0==AV9CliCod) )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV45Pgmname, httpContext.getMessage( "antes!", "")) ;
         new web.invocar_guardaliquidacion2(remoteHandle, context).execute( AV37sdt_datos_liq, httpContext.getMessage( "LAMBDA", "")) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV45Pgmname, httpContext.getMessage( "despues!", "")) ;
         AV42i = (short)(AV42i+1) ;
      }
      cleanup();
   }

   public static Object refClasses( )
   {
      GXutil.refClasses(lambda_calcliqtodo.class);
      return new web.GXcfg();
   }

   protected void cleanup( )
   {
      this.aP1[0] = alambda_calcliqtodo.this.AV16EventMessageResponse;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16EventMessageResponse = new com.genexus.genexusserverlessapi.SdtEventMessageResponse(remoteHandle, context);
      AV41cuerpos = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_vchar1 = new GXSimpleCollection[1] ;
      AV15error = "" ;
      AV40body = "" ;
      AV37sdt_datos_liq = new web.Sdtsdt_datos_liq(remoteHandle, context);
      AV34MetaParmValue = "" ;
      GXv_char2 = new String[1] ;
      AV45Pgmname = "" ;
      AV45Pgmname = "Alambda_calcLiqTodo" ;
      /* GeneXus formulas. */
      AV45Pgmname = "Alambda_calcLiqTodo" ;
      Gx_err = (short)(0) ;
   }

   private short AV42i ;
   private short Gx_err ;
   private int AV9CliCod ;
   private String GXv_char2[] ;
   private String AV45Pgmname ;
   private boolean returnInSub ;
   private String AV36RawData ;
   private String AV40body ;
   private String AV15error ;
   private String AV34MetaParmValue ;
   private com.genexus.genexusserverlessapi.SdtEventMessageResponse[] aP1 ;
   private GXSimpleCollection<String> AV41cuerpos ;
   private GXSimpleCollection<String> GXv_objcol_vchar1[] ;
   private com.genexus.genexusserverlessapi.SdtEventMessageResponse AV16EventMessageResponse ;
   private web.Sdtsdt_datos_liq AV37sdt_datos_liq ;
}

