package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class fixcolumnsselector extends GXProcedure
{
   public fixcolumnsselector( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( fixcolumnsselector.class ), "" );
   }

   public fixcolumnsselector( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public web.wwpbaseobjects.SdtWWPColumnsSelector executeUdp( int aP0 )
   {
      fixcolumnsselector.this.aP1 = new web.wwpbaseobjects.SdtWWPColumnsSelector[] {new web.wwpbaseobjects.SdtWWPColumnsSelector()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        web.wwpbaseobjects.SdtWWPColumnsSelector[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             web.wwpbaseobjects.SdtWWPColumnsSelector[] aP1 )
   {
      fixcolumnsselector.this.AV8CliCod = aP0;
      fixcolumnsselector.this.AV9ColumnsSelector = aP1[0];
      this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10i = (short)(1) ;
      while ( AV10i <= AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         if ( ( GXutil.strSearch( ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV10i)).getgxTv_SdtWWPColumnsSelector_Column_Columnname(), httpContext.getMessage( "&VerSVG", ""), 1) != 0 ) || ( GXutil.strSearch( ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV10i)).getgxTv_SdtWWPColumnsSelector_Column_Columnname(), httpContext.getMessage( "&ModificarSVG", ""), 1) != 0 ) || ( GXutil.strSearch( ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV10i)).getgxTv_SdtWWPColumnsSelector_Column_Columnname(), httpContext.getMessage( "&EliminarVG", ""), 1) != 0 ) )
         {
            ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV10i)).setgxTv_SdtWWPColumnsSelector_Column_Columnname( "" );
         }
         AV10i = (short)(AV10i+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = fixcolumnsselector.this.AV9ColumnsSelector;
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

   private short AV10i ;
   private short Gx_err ;
   private int AV8CliCod ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector[] aP1 ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV9ColumnsSelector ;
}

