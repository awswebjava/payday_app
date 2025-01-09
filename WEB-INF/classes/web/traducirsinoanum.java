package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class traducirsinoanum extends GXProcedure
{
   public traducirsinoanum( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( traducirsinoanum.class ), "" );
   }

   public traducirsinoanum( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String aP2 ,
                              short[] aP3 ,
                              GXSimpleCollection<String>[] aP4 ,
                              String[] aP5 )
   {
      traducirsinoanum.this.aP6 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        short[] aP3 ,
                        GXSimpleCollection<String>[] aP4 ,
                        String[] aP5 ,
                        boolean[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             short[] aP3 ,
                             GXSimpleCollection<String>[] aP4 ,
                             String[] aP5 ,
                             boolean[] aP6 )
   {
      traducirsinoanum.this.AV18CliCod = aP0;
      traducirsinoanum.this.AV13valor = aP1;
      traducirsinoanum.this.AV16palabra = aP2;
      traducirsinoanum.this.aP3 = aP3;
      traducirsinoanum.this.AV17errores = aP4[0];
      this.aP4 = aP4;
      traducirsinoanum.this.aP5 = aP5;
      traducirsinoanum.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV13valor ;
      GXv_char2[0] = GXt_char1 ;
      new web.defaulttextomigr(remoteHandle, context).execute( AV18CliCod, GXv_char2) ;
      traducirsinoanum.this.GXt_char1 = GXv_char2[0] ;
      AV13valor = GXutil.strReplace( AV13valor, GXt_char1, "") ;
      if ( ! (GXutil.strcmp("", AV13valor)==0) )
      {
         if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV13valor)), httpContext.getMessage( "S", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV13valor)), httpContext.getMessage( "SI", "")) == 0 ) || ( GXutil.strcmp(GXutil.trim( AV13valor), "1") == 0 ) )
         {
            AV15traducido = (short)(1) ;
            AV8encontro = true ;
         }
         else
         {
            if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV13valor)), httpContext.getMessage( "N", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV13valor)), httpContext.getMessage( "NO", "")) == 0 ) || ( GXutil.strcmp(GXutil.trim( AV13valor), "0") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV13valor), "-") == 0 ) )
            {
               AV15traducido = (short)(0) ;
               AV8encontro = true ;
            }
            else
            {
               GXt_char1 = AV9error ;
               GXv_char2[0] = GXt_char1 ;
               new web.mensajemigrvalorinvalido(remoteHandle, context).execute( AV18CliCod, AV16palabra, AV13valor, (short)(1), GXv_char2) ;
               traducirsinoanum.this.GXt_char1 = GXv_char2[0] ;
               AV9error = GXt_char1 ;
               AV17errores.add(AV9error, 0);
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = traducirsinoanum.this.AV15traducido;
      this.aP4[0] = traducirsinoanum.this.AV17errores;
      this.aP5[0] = traducirsinoanum.this.AV9error;
      this.aP6[0] = traducirsinoanum.this.AV8encontro;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9error = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV15traducido ;
   private short Gx_err ;
   private int AV18CliCod ;
   private String AV13valor ;
   private String AV16palabra ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private boolean AV8encontro ;
   private String AV9error ;
   private boolean[] aP6 ;
   private short[] aP3 ;
   private GXSimpleCollection<String>[] aP4 ;
   private String[] aP5 ;
   private GXSimpleCollection<String> AV17errores ;
}

