package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class devuelveurlfoto extends GXProcedure
{
   public devuelveurlfoto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( devuelveurlfoto.class ), "" );
   }

   public devuelveurlfoto( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String aP4 )
   {
      devuelveurlfoto.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String[] aP5 )
   {
      devuelveurlfoto.this.AV8CliCod = aP0;
      devuelveurlfoto.this.AV11EmpCod = aP1;
      devuelveurlfoto.this.AV25LegNumero = aP2;
      devuelveurlfoto.this.AV28tipoPalabra = aP3;
      devuelveurlfoto.this.AV24FotoNom = aP4;
      devuelveurlfoto.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! (GXutil.strcmp("", AV24FotoNom)==0) )
      {
         GXv_char1[0] = AV21ParmValue ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.a3lutilitiesesdocker_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
         devuelveurlfoto.this.AV21ParmValue = GXv_char1[0] ;
         AV23dockerizadoEs = GXutil.boolval( AV21ParmValue) ;
         if ( true || ( AV23dockerizadoEs ) )
         {
            GXv_char1[0] = AV21ParmValue ;
            new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.modoahorros3_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
            devuelveurlfoto.this.AV21ParmValue = GXv_char1[0] ;
            AV27modoAhorroS3Es = GXutil.boolval( AV21ParmValue) ;
            if ( AV27modoAhorroS3Es )
            {
               if ( ! (0==AV25LegNumero) )
               {
                  AV10url = httpContext.convertURL( context.getHttpContext().getImagePath( "3a2bb037-746f-4ca9-85b6-8a9333319398", "", context.getHttpContext().getTheme( ))) ;
               }
               else
               {
                  GXt_char2 = AV17protocoloPalabra ;
                  GXt_char3 = AV17protocoloPalabra ;
                  GXv_char1[0] = GXt_char3 ;
                  new web.protocolo_codigoparam(remoteHandle, context).execute( GXv_char1) ;
                  devuelveurlfoto.this.GXt_char3 = GXv_char1[0] ;
                  GXv_char4[0] = GXt_char2 ;
                  new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char3, GXv_char4) ;
                  devuelveurlfoto.this.GXt_char2 = GXv_char4[0] ;
                  AV17protocoloPalabra = GXt_char2 ;
                  GXv_char4[0] = AV18dominioPalabra ;
                  new web.getdominio(remoteHandle, context).execute( AV8CliCod, GXv_char4) ;
                  devuelveurlfoto.this.AV18dominioPalabra = GXv_char4[0] ;
                  GXv_int5[0] = AV19puerto ;
                  new web.getpuerto(remoteHandle, context).execute( AV8CliCod, GXv_int5) ;
                  devuelveurlfoto.this.AV19puerto = GXv_int5[0] ;
                  if ( GXutil.strcmp(AV28tipoPalabra, httpContext.getMessage( "logo", "")) == 0 )
                  {
                     AV10url = GXutil.trim( AV17protocoloPalabra) + "://" + GXutil.trim( AV18dominioPalabra) + ":" + GXutil.trim( GXutil.str( AV19puerto, 8, 0)) + httpContext.convertURL( context.getHttpContext().getImagePath( "76359733-d133-4eeb-8fa0-7d83575ab670", "", context.getHttpContext().getTheme( ))) ;
                  }
                  else
                  {
                     AV10url = GXutil.trim( AV17protocoloPalabra) + "://" + GXutil.trim( AV18dominioPalabra) + ":" + GXutil.trim( GXutil.str( AV19puerto, 8, 0)) + httpContext.convertURL( context.getHttpContext().getImagePath( "020bf9f5-0b54-4bd7-bb82-64007809bb0f", "", context.getHttpContext().getTheme( ))) ;
                  }
               }
            }
            else
            {
               GXv_char4[0] = AV10url ;
               new web.geturlbases3(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "IMG", ""), GXv_char4) ;
               devuelveurlfoto.this.AV10url = GXv_char4[0] ;
               GXv_char4[0] = AV14rutaRelativaUploads ;
               new web.getnombrecarpetaennode(remoteHandle, context).execute( AV8CliCod, AV11EmpCod, AV25LegNumero, GXv_char4) ;
               devuelveurlfoto.this.AV14rutaRelativaUploads = GXv_char4[0] ;
               AV10url += "/" + GXutil.trim( AV14rutaRelativaUploads) + "/" + GXutil.trim( AV24FotoNom) ;
            }
         }
         else
         {
            GXv_char4[0] = AV13destinationDir ;
            GXv_char1[0] = AV14rutaRelativaUploads ;
            new web.devuelverutauploadsleg(remoteHandle, context).execute( AV8CliCod, AV11EmpCod, AV25LegNumero, GXv_char4, GXv_char1) ;
            devuelveurlfoto.this.AV13destinationDir = GXv_char4[0] ;
            devuelveurlfoto.this.AV14rutaRelativaUploads = GXv_char1[0] ;
            AV10url = AV14rutaRelativaUploads ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = devuelveurlfoto.this.AV10url;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10url = "" ;
      AV21ParmValue = "" ;
      AV17protocoloPalabra = "" ;
      GXt_char2 = "" ;
      GXt_char3 = "" ;
      AV18dominioPalabra = "" ;
      GXv_int5 = new int[1] ;
      AV14rutaRelativaUploads = "" ;
      AV13destinationDir = "" ;
      GXv_char4 = new String[1] ;
      GXv_char1 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV25LegNumero ;
   private int AV19puerto ;
   private int GXv_int5[] ;
   private String AV28tipoPalabra ;
   private String AV17protocoloPalabra ;
   private String GXt_char2 ;
   private String GXt_char3 ;
   private String AV18dominioPalabra ;
   private String GXv_char4[] ;
   private String GXv_char1[] ;
   private boolean AV23dockerizadoEs ;
   private boolean AV27modoAhorroS3Es ;
   private String AV21ParmValue ;
   private String AV24FotoNom ;
   private String AV10url ;
   private String AV14rutaRelativaUploads ;
   private String AV13destinationDir ;
   private String[] aP5 ;
}

