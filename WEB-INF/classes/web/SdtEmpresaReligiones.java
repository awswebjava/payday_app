package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtEmpresaReligiones extends GxSilentTrnSdt
{
   public SdtEmpresaReligiones( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtEmpresaReligiones.class));
   }

   public SdtEmpresaReligiones( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle, context, "SdtEmpresaReligiones");
      initialize( remoteHandle) ;
   }

   public SdtEmpresaReligiones( int remoteHandle ,
                                StructSdtEmpresaReligiones struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public void Load( int AV3CliCod ,
                     short AV1EmpCod ,
                     String AV1237EmpReligion )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1EmpCod),AV1237EmpReligion});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"EmpCod", short.class}, new Object[]{"EmpReligion", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "EmpresaReligiones");
      metadata.set("BT", "Empresanolaborables_religion");
      metadata.set("PK", "[ \"CliCod\",\"EmpCod\",\"EmpReligion\" ]");
      metadata.set("PKAssigned", "[ \"CliCod\",\"EmpReligion\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"ReligId\" ],\"FKMap\":[ \"EmpReligion-ReligId\" ] } ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod") )
            {
               gxTv_SdtEmpresaReligiones_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_SdtEmpresaReligiones_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpReligion") )
            {
               gxTv_SdtEmpresaReligiones_Empreligion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtEmpresaReligiones_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtEmpresaReligiones_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtEmpresaReligiones_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_SdtEmpresaReligiones_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpReligion_Z") )
            {
               gxTv_SdtEmpresaReligiones_Empreligion_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "EmpresaReligiones" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtEmpresaReligiones_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_SdtEmpresaReligiones_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpReligion", gxTv_SdtEmpresaReligiones_Empreligion);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtEmpresaReligiones_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtEmpresaReligiones_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresaReligiones_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresaReligiones_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpReligion_Z", gxTv_SdtEmpresaReligiones_Empreligion_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("CliCod", gxTv_SdtEmpresaReligiones_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_SdtEmpresaReligiones_Empcod, false, includeNonInitialized);
      AddObjectProperty("EmpReligion", gxTv_SdtEmpresaReligiones_Empreligion, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtEmpresaReligiones_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtEmpresaReligiones_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtEmpresaReligiones_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_SdtEmpresaReligiones_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpReligion_Z", gxTv_SdtEmpresaReligiones_Empreligion_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtEmpresaReligiones sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtEmpresaReligiones_N = (byte)(0) ;
         gxTv_SdtEmpresaReligiones_Clicod = sdt.getgxTv_SdtEmpresaReligiones_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_SdtEmpresaReligiones_N = (byte)(0) ;
         gxTv_SdtEmpresaReligiones_Empcod = sdt.getgxTv_SdtEmpresaReligiones_Empcod() ;
      }
      if ( sdt.IsDirty("EmpReligion") )
      {
         gxTv_SdtEmpresaReligiones_N = (byte)(0) ;
         gxTv_SdtEmpresaReligiones_Empreligion = sdt.getgxTv_SdtEmpresaReligiones_Empreligion() ;
      }
   }

   public int getgxTv_SdtEmpresaReligiones_Clicod( )
   {
      return gxTv_SdtEmpresaReligiones_Clicod ;
   }

   public void setgxTv_SdtEmpresaReligiones_Clicod( int value )
   {
      gxTv_SdtEmpresaReligiones_N = (byte)(0) ;
      if ( gxTv_SdtEmpresaReligiones_Clicod != value )
      {
         gxTv_SdtEmpresaReligiones_Mode = "INS" ;
         this.setgxTv_SdtEmpresaReligiones_Clicod_Z_SetNull( );
         this.setgxTv_SdtEmpresaReligiones_Empcod_Z_SetNull( );
         this.setgxTv_SdtEmpresaReligiones_Empreligion_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_SdtEmpresaReligiones_Clicod = value ;
   }

   public short getgxTv_SdtEmpresaReligiones_Empcod( )
   {
      return gxTv_SdtEmpresaReligiones_Empcod ;
   }

   public void setgxTv_SdtEmpresaReligiones_Empcod( short value )
   {
      gxTv_SdtEmpresaReligiones_N = (byte)(0) ;
      if ( gxTv_SdtEmpresaReligiones_Empcod != value )
      {
         gxTv_SdtEmpresaReligiones_Mode = "INS" ;
         this.setgxTv_SdtEmpresaReligiones_Clicod_Z_SetNull( );
         this.setgxTv_SdtEmpresaReligiones_Empcod_Z_SetNull( );
         this.setgxTv_SdtEmpresaReligiones_Empreligion_Z_SetNull( );
      }
      SetDirty("Empcod");
      gxTv_SdtEmpresaReligiones_Empcod = value ;
   }

   public String getgxTv_SdtEmpresaReligiones_Empreligion( )
   {
      return gxTv_SdtEmpresaReligiones_Empreligion ;
   }

   public void setgxTv_SdtEmpresaReligiones_Empreligion( String value )
   {
      gxTv_SdtEmpresaReligiones_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtEmpresaReligiones_Empreligion, value) != 0 )
      {
         gxTv_SdtEmpresaReligiones_Mode = "INS" ;
         this.setgxTv_SdtEmpresaReligiones_Clicod_Z_SetNull( );
         this.setgxTv_SdtEmpresaReligiones_Empcod_Z_SetNull( );
         this.setgxTv_SdtEmpresaReligiones_Empreligion_Z_SetNull( );
      }
      SetDirty("Empreligion");
      gxTv_SdtEmpresaReligiones_Empreligion = value ;
   }

   public String getgxTv_SdtEmpresaReligiones_Mode( )
   {
      return gxTv_SdtEmpresaReligiones_Mode ;
   }

   public void setgxTv_SdtEmpresaReligiones_Mode( String value )
   {
      gxTv_SdtEmpresaReligiones_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtEmpresaReligiones_Mode = value ;
   }

   public void setgxTv_SdtEmpresaReligiones_Mode_SetNull( )
   {
      gxTv_SdtEmpresaReligiones_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtEmpresaReligiones_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresaReligiones_Initialized( )
   {
      return gxTv_SdtEmpresaReligiones_Initialized ;
   }

   public void setgxTv_SdtEmpresaReligiones_Initialized( short value )
   {
      gxTv_SdtEmpresaReligiones_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtEmpresaReligiones_Initialized = value ;
   }

   public void setgxTv_SdtEmpresaReligiones_Initialized_SetNull( )
   {
      gxTv_SdtEmpresaReligiones_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtEmpresaReligiones_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtEmpresaReligiones_Clicod_Z( )
   {
      return gxTv_SdtEmpresaReligiones_Clicod_Z ;
   }

   public void setgxTv_SdtEmpresaReligiones_Clicod_Z( int value )
   {
      gxTv_SdtEmpresaReligiones_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtEmpresaReligiones_Clicod_Z = value ;
   }

   public void setgxTv_SdtEmpresaReligiones_Clicod_Z_SetNull( )
   {
      gxTv_SdtEmpresaReligiones_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtEmpresaReligiones_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresaReligiones_Empcod_Z( )
   {
      return gxTv_SdtEmpresaReligiones_Empcod_Z ;
   }

   public void setgxTv_SdtEmpresaReligiones_Empcod_Z( short value )
   {
      gxTv_SdtEmpresaReligiones_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_SdtEmpresaReligiones_Empcod_Z = value ;
   }

   public void setgxTv_SdtEmpresaReligiones_Empcod_Z_SetNull( )
   {
      gxTv_SdtEmpresaReligiones_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_SdtEmpresaReligiones_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresaReligiones_Empreligion_Z( )
   {
      return gxTv_SdtEmpresaReligiones_Empreligion_Z ;
   }

   public void setgxTv_SdtEmpresaReligiones_Empreligion_Z( String value )
   {
      gxTv_SdtEmpresaReligiones_N = (byte)(0) ;
      SetDirty("Empreligion_Z");
      gxTv_SdtEmpresaReligiones_Empreligion_Z = value ;
   }

   public void setgxTv_SdtEmpresaReligiones_Empreligion_Z_SetNull( )
   {
      gxTv_SdtEmpresaReligiones_Empreligion_Z = "" ;
      SetDirty("Empreligion_Z");
   }

   public boolean getgxTv_SdtEmpresaReligiones_Empreligion_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.empresareligiones_bc obj;
      obj = new web.empresareligiones_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtEmpresaReligiones_N = (byte)(1) ;
      gxTv_SdtEmpresaReligiones_Empreligion = "" ;
      gxTv_SdtEmpresaReligiones_Mode = "" ;
      gxTv_SdtEmpresaReligiones_Empreligion_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtEmpresaReligiones_N ;
   }

   public web.SdtEmpresaReligiones Clone( )
   {
      web.SdtEmpresaReligiones sdt;
      web.empresareligiones_bc obj;
      sdt = (web.SdtEmpresaReligiones)(clone()) ;
      obj = (web.empresareligiones_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtEmpresaReligiones struct )
   {
      setgxTv_SdtEmpresaReligiones_Clicod(struct.getClicod());
      setgxTv_SdtEmpresaReligiones_Empcod(struct.getEmpcod());
      setgxTv_SdtEmpresaReligiones_Empreligion(struct.getEmpreligion());
      setgxTv_SdtEmpresaReligiones_Mode(struct.getMode());
      setgxTv_SdtEmpresaReligiones_Initialized(struct.getInitialized());
      setgxTv_SdtEmpresaReligiones_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtEmpresaReligiones_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_SdtEmpresaReligiones_Empreligion_Z(struct.getEmpreligion_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtEmpresaReligiones getStruct( )
   {
      web.StructSdtEmpresaReligiones struct = new web.StructSdtEmpresaReligiones ();
      struct.setClicod(getgxTv_SdtEmpresaReligiones_Clicod());
      struct.setEmpcod(getgxTv_SdtEmpresaReligiones_Empcod());
      struct.setEmpreligion(getgxTv_SdtEmpresaReligiones_Empreligion());
      struct.setMode(getgxTv_SdtEmpresaReligiones_Mode());
      struct.setInitialized(getgxTv_SdtEmpresaReligiones_Initialized());
      struct.setClicod_Z(getgxTv_SdtEmpresaReligiones_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_SdtEmpresaReligiones_Empcod_Z());
      struct.setEmpreligion_Z(getgxTv_SdtEmpresaReligiones_Empreligion_Z());
      return struct ;
   }

   private byte gxTv_SdtEmpresaReligiones_N ;
   private short gxTv_SdtEmpresaReligiones_Empcod ;
   private short gxTv_SdtEmpresaReligiones_Initialized ;
   private short gxTv_SdtEmpresaReligiones_Empcod_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtEmpresaReligiones_Clicod ;
   private int gxTv_SdtEmpresaReligiones_Clicod_Z ;
   private String gxTv_SdtEmpresaReligiones_Empreligion ;
   private String gxTv_SdtEmpresaReligiones_Mode ;
   private String gxTv_SdtEmpresaReligiones_Empreligion_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
}

