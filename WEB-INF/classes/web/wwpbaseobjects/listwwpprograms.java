package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class listwwpprograms extends GXProcedure
{
   public listwwpprograms( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( listwwpprograms.class ), "" );
   }

   public listwwpprograms( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.wwpbaseobjects.SdtProgramNames_ProgramName> executeUdp( )
   {
      listwwpprograms.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<web.wwpbaseobjects.SdtProgramNames_ProgramName>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<web.wwpbaseobjects.SdtProgramNames_ProgramName>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<web.wwpbaseobjects.SdtProgramNames_ProgramName>[] aP0 )
   {
      listwwpprograms.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9ProgramNames = new GXBaseCollection<web.wwpbaseobjects.SdtProgramNames_ProgramName>(web.wwpbaseobjects.SdtProgramNames_ProgramName.class, "ProgramName", "PayDay", remoteHandle) ;
      GXv_SdtWWPContext1[0] = AV16WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV16WWPContext = GXv_SdtWWPContext1[0] ;
      AV13name = "WWPBaseObjects.SecFunctionalityWW" ;
      AV14description = httpContext.getMessage( " Functionality", "") ;
      AV15link = formatLink("web.wwpbaseobjects.secfunctionalityww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "LiqImportarAuxTrnWW" ;
      AV14description = httpContext.getMessage( " Liq Importar Aux Trn", "") ;
      AV15link = formatLink("web.liqimportarauxtrnww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "WWPBaseObjects.SecRoleWW" ;
      AV14description = httpContext.getMessage( " Role", "") ;
      AV15link = formatLink("web.wwpbaseobjects.secroleww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'ADDPROGRAM' Routine */
      returnInSub = false ;
      AV8IsAuthorized = true ;
      if ( AV8IsAuthorized )
      {
         AV10ProgramName = (web.wwpbaseobjects.SdtProgramNames_ProgramName)new web.wwpbaseobjects.SdtProgramNames_ProgramName(remoteHandle, context);
         AV10ProgramName.setgxTv_SdtProgramNames_ProgramName_Name( AV13name );
         AV10ProgramName.setgxTv_SdtProgramNames_ProgramName_Description( AV14description );
         AV10ProgramName.setgxTv_SdtProgramNames_ProgramName_Link( AV15link );
         AV9ProgramNames.add(AV10ProgramName, 0);
      }
   }

   protected void cleanup( )
   {
      this.aP0[0] = listwwpprograms.this.AV9ProgramNames;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ProgramNames = new GXBaseCollection<web.wwpbaseobjects.SdtProgramNames_ProgramName>(web.wwpbaseobjects.SdtProgramNames_ProgramName.class, "ProgramName", "PayDay", remoteHandle);
      AV16WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV13name = "" ;
      AV14description = "" ;
      AV15link = "" ;
      AV10ProgramName = new web.wwpbaseobjects.SdtProgramNames_ProgramName(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private String AV13name ;
   private String AV14description ;
   private String AV15link ;
   private GXBaseCollection<web.wwpbaseobjects.SdtProgramNames_ProgramName>[] aP0 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtProgramNames_ProgramName> AV9ProgramNames ;
   private web.wwpbaseobjects.SdtProgramNames_ProgramName AV10ProgramName ;
   private web.wwpbaseobjects.SdtWWPContext AV16WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

