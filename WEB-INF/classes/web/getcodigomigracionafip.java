package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcodigomigracionafip extends GXProcedure
{
   public getcodigomigracionafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcodigomigracionafip.class ), "" );
   }

   public getcodigomigracionafip( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      getcodigomigracionafip.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      getcodigomigracionafip.this.AV9DescripcionEnorme = aP0;
      getcodigomigracionafip.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8i = (short)(1) ;
      while ( true )
      {
         gxexitloop = false ;
         if ( gxexitloop )
         {
            break;
         }
         AV10caracter = GXutil.substring( AV9DescripcionEnorme, AV8i, 1) ;
         GXv_boolean1[0] = AV11numeroEs ;
         new web.esnumero(remoteHandle, context).execute( AV10caracter, GXv_boolean1) ;
         getcodigomigracionafip.this.AV11numeroEs = GXv_boolean1[0] ;
         if ( AV11numeroEs )
         {
            AV12palabra += AV10caracter ;
         }
         else
         {
            if (true) break;
         }
         AV8i = (short)(AV8i+1) ;
         if ( AV8i == 10 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "LOOOOOOOOOOOOOOOOP", "")) ;
            if (true) break;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getcodigomigracionafip.this.AV12palabra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12palabra = "" ;
      AV10caracter = "" ;
      GXv_boolean1 = new boolean[1] ;
      AV15Pgmname = "" ;
      AV15Pgmname = "getCodigoMigracionAFIP" ;
      /* GeneXus formulas. */
      AV15Pgmname = "getCodigoMigracionAFIP" ;
      Gx_err = (short)(0) ;
   }

   private short AV8i ;
   private short Gx_err ;
   private String AV12palabra ;
   private String AV10caracter ;
   private String AV15Pgmname ;
   private boolean gxexitloop ;
   private boolean AV11numeroEs ;
   private boolean GXv_boolean1[] ;
   private String AV9DescripcionEnorme ;
   private String[] aP1 ;
}

