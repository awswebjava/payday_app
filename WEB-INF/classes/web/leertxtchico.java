package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class leertxtchico extends GXProcedure
{
   public leertxtchico( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( leertxtchico.class ), "" );
   }

   public leertxtchico( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      leertxtchico.this.aP1 = new String[] {""};
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
      leertxtchico.this.AV9source = aP0;
      leertxtchico.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "source ", "")+GXutil.trim( AV9source)) ;
      AV8File.setSource( AV9source );
      if ( AV8File.exists() )
      {
         AV10varcharcollection = new GXSimpleCollection<String>(String.class, "internal", "", AV8File.readAllLines()) ;
         AV16GXV1 = 1 ;
         while ( AV16GXV1 <= AV10varcharcollection.size() )
         {
            AV12fileLine = (String)AV10varcharcollection.elementAt(-1+AV16GXV1) ;
            AV11longVarchar += AV12fileLine + GXutil.newLine( ) ;
            AV16GXV1 = (int)(AV16GXV1+1) ;
         }
      }
      else
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "No se encuentra el archivo ", "")+GXutil.trim( AV9source));
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = leertxtchico.this.AV11longVarchar;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11longVarchar = "" ;
      AV15Pgmname = "" ;
      AV8File = new com.genexus.util.GXFile();
      AV10varcharcollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12fileLine = "" ;
      AV15Pgmname = "LeerTxtChico" ;
      /* GeneXus formulas. */
      AV15Pgmname = "LeerTxtChico" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV16GXV1 ;
   private String AV15Pgmname ;
   private String AV12fileLine ;
   private String AV11longVarchar ;
   private String AV9source ;
   private com.genexus.util.GXFile AV8File ;
   private String[] aP1 ;
   private GXSimpleCollection<String> AV10varcharcollection ;
}

