package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getnextsiglaos extends GXProcedure
{
   public getnextsiglaos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getnextsiglaos.class ), "" );
   }

   public getnextsiglaos( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      getnextsiglaos.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      getnextsiglaos.this.AV9CliCod = aP0;
      getnextsiglaos.this.AV11Descrip = aP1;
      getnextsiglaos.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV17seguir = true ;
      AV15next = (short)(0) ;
      /* Execute user subroutine: 'ARMAR SIGLAS' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV18OsoSigla = GXutil.trim( AV19Siglas) ;
      while ( AV17seguir )
      {
         if ( AV15next > 0 )
         {
            AV18OsoSigla += GXutil.trim( GXutil.str( AV15next, 4, 0)) ;
         }
         GXv_char1[0] = "" ;
         GXv_boolean2[0] = AV17seguir ;
         new web.getobrasocialporsigla(remoteHandle, context).execute( AV9CliCod, AV18OsoSigla, GXv_char1, GXv_boolean2) ;
         getnextsiglaos.this.AV17seguir = GXv_boolean2[0] ;
         AV15next = (short)(AV15next+1) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'ARMAR SIGLAS' Routine */
      returnInSub = false ;
      AV20palabras = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV11Descrip," ")) ;
      AV19Siglas = "" ;
      if ( AV20palabras.size() > 0 )
      {
         AV21s = (short)(1) ;
         while ( AV21s <= AV20palabras.size() )
         {
            AV19Siglas += GXutil.substring( (String)AV20palabras.elementAt(-1+AV21s), 1, 1) ;
            AV21s = (short)(AV21s+1) ;
         }
         AV19Siglas = GXutil.upper( AV19Siglas) ;
      }
   }

   protected void cleanup( )
   {
      this.aP2[0] = getnextsiglaos.this.AV18OsoSigla;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18OsoSigla = "" ;
      AV19Siglas = "" ;
      GXv_char1 = new String[1] ;
      GXv_boolean2 = new boolean[1] ;
      AV20palabras = new GXSimpleCollection<String>(String.class, "internal", "");
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV15next ;
   private short AV21s ;
   private short Gx_err ;
   private int AV9CliCod ;
   private String AV18OsoSigla ;
   private String AV19Siglas ;
   private String GXv_char1[] ;
   private boolean AV17seguir ;
   private boolean returnInSub ;
   private boolean GXv_boolean2[] ;
   private String AV11Descrip ;
   private String[] aP2 ;
   private GXSimpleCollection<String> AV20palabras ;
}

