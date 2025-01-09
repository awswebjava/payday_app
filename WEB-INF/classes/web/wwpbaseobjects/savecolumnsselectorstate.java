package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class savecolumnsselectorstate extends GXProcedure
{
   public savecolumnsselectorstate( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( savecolumnsselectorstate.class ), "" );
   }

   public savecolumnsselectorstate( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 ,
                        String aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String aP1 )
   {
      savecolumnsselectorstate.this.AV8UserCustomKey = aP0;
      savecolumnsselectorstate.this.AV9UserCustomValue = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.wwpbaseobjects.saveuserkeyvalue(remoteHandle, context).execute( AV8UserCustomKey, AV9UserCustomValue) ;
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
   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8UserCustomKey ;
   private String AV9UserCustomValue ;
}

