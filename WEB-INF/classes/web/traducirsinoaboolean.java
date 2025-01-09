package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class traducirsinoaboolean extends GXProcedure
{
   public traducirsinoaboolean( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( traducirsinoaboolean.class ), "" );
   }

   public traducirsinoaboolean( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String aP2 ,
                              boolean[] aP3 ,
                              GXSimpleCollection<String>[] aP4 ,
                              String[] aP5 )
   {
      traducirsinoaboolean.this.aP6 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        boolean[] aP3 ,
                        GXSimpleCollection<String>[] aP4 ,
                        String[] aP5 ,
                        boolean[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             boolean[] aP3 ,
                             GXSimpleCollection<String>[] aP4 ,
                             String[] aP5 ,
                             boolean[] aP6 )
   {
      traducirsinoaboolean.this.AV17CliCod = aP0;
      traducirsinoaboolean.this.AV13valor = aP1;
      traducirsinoaboolean.this.AV16palabra = aP2;
      traducirsinoaboolean.this.aP3 = aP3;
      traducirsinoaboolean.this.AV18errores = aP4[0];
      this.aP4 = aP4;
      traducirsinoaboolean.this.aP5 = aP5;
      traducirsinoaboolean.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV13valor ;
      GXv_char2[0] = GXt_char1 ;
      new web.defaulttextomigr(remoteHandle, context).execute( AV17CliCod, GXv_char2) ;
      traducirsinoaboolean.this.GXt_char1 = GXv_char2[0] ;
      AV13valor = GXutil.strReplace( AV13valor, GXt_char1, "") ;
      if ( ! (GXutil.strcmp("", AV13valor)==0) )
      {
         if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV13valor)), httpContext.getMessage( "S", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV13valor)), httpContext.getMessage( "SI", "")) == 0 ) || ( GXutil.strcmp(GXutil.trim( AV13valor), "1") == 0 ) )
         {
            AV15traducido = true ;
            AV8encontro = true ;
         }
         else
         {
            if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV13valor)), httpContext.getMessage( "N", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV13valor)), httpContext.getMessage( "NO", "")) == 0 ) || ( GXutil.strcmp(GXutil.trim( AV13valor), "0") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV13valor), "-") == 0 ) )
            {
               AV15traducido = false ;
               AV8encontro = true ;
            }
            else
            {
               GXt_char1 = AV9error ;
               GXv_char2[0] = GXt_char1 ;
               new web.mensajemigrvalorinvalido(remoteHandle, context).execute( AV17CliCod, AV16palabra, AV13valor, (short)(1), GXv_char2) ;
               traducirsinoaboolean.this.GXt_char1 = GXv_char2[0] ;
               AV9error = GXt_char1 ;
               AV18errores.add(AV9error, 0);
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = traducirsinoaboolean.this.AV15traducido;
      this.aP4[0] = traducirsinoaboolean.this.AV18errores;
      this.aP5[0] = traducirsinoaboolean.this.AV9error;
      this.aP6[0] = traducirsinoaboolean.this.AV8encontro;
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

   private short Gx_err ;
   private int AV17CliCod ;
   private String AV13valor ;
   private String AV16palabra ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private boolean AV15traducido ;
   private boolean AV8encontro ;
   private String AV9error ;
   private boolean[] aP6 ;
   private boolean[] aP3 ;
   private GXSimpleCollection<String>[] aP4 ;
   private String[] aP5 ;
   private GXSimpleCollection<String> AV18errores ;
}

