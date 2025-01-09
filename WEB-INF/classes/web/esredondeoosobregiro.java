package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class esredondeoosobregiro extends GXProcedure
{
   public esredondeoosobregiro( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( esredondeoosobregiro.class ), "" );
   }

   public esredondeoosobregiro( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 )
   {
      esredondeoosobregiro.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             boolean[] aP2 )
   {
      esredondeoosobregiro.this.AV8clicod = aP0;
      esredondeoosobregiro.this.AV10concodigo = aP1;
      esredondeoosobregiro.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV9redondeo ;
      GXv_char2[0] = "x" ;
      new web.conceptoredondeo(remoteHandle, context).execute( AV8clicod, GXv_char1, GXv_char2) ;
      esredondeoosobregiro.this.AV9redondeo = GXv_char1[0] ;
      if ( GXutil.strcmp(AV10concodigo, AV9redondeo) == 0 )
      {
         AV11esRedondeoOSobregiro = true ;
      }
      else
      {
         GXv_char2[0] = AV12sobregiro ;
         GXv_char1[0] = "x" ;
         new web.conceptosobregiro(remoteHandle, context).execute( AV8clicod, GXv_char2, GXv_char1) ;
         esredondeoosobregiro.this.AV12sobregiro = GXv_char2[0] ;
         if ( GXutil.strcmp(AV10concodigo, AV12sobregiro) == 0 )
         {
            AV11esRedondeoOSobregiro = true ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = esredondeoosobregiro.this.AV11esRedondeoOSobregiro;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9redondeo = "" ;
      AV12sobregiro = "" ;
      GXv_char2 = new String[1] ;
      GXv_char1 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8clicod ;
   private String AV10concodigo ;
   private String AV9redondeo ;
   private String AV12sobregiro ;
   private String GXv_char2[] ;
   private String GXv_char1[] ;
   private boolean AV11esRedondeoOSobregiro ;
   private boolean[] aP2 ;
}

