package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtEmpresaOrigenes extends GxSilentTrnSdt
{
   public SdtEmpresaOrigenes( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtEmpresaOrigenes.class));
   }

   public SdtEmpresaOrigenes( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle, context, "SdtEmpresaOrigenes");
      initialize( remoteHandle) ;
   }

   public SdtEmpresaOrigenes( int remoteHandle ,
                              StructSdtEmpresaOrigenes struct )
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
                     String AV1238EmpOrigen )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1EmpCod),AV1238EmpOrigen});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"EmpCod", short.class}, new Object[]{"EmpOrigen", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "EmpresaOrigenes");
      metadata.set("BT", "Empresanolaborables_origen");
      metadata.set("PK", "[ \"CliCod\",\"EmpCod\",\"EmpOrigen\" ]");
      metadata.set("PKAssigned", "[ \"CliCod\",\"EmpOrigen\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"OrigId\" ],\"FKMap\":[ \"EmpOrigen-OrigId\" ] } ]");
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
               gxTv_SdtEmpresaOrigenes_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_SdtEmpresaOrigenes_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpOrigen") )
            {
               gxTv_SdtEmpresaOrigenes_Emporigen = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtEmpresaOrigenes_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtEmpresaOrigenes_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtEmpresaOrigenes_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_SdtEmpresaOrigenes_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpOrigen_Z") )
            {
               gxTv_SdtEmpresaOrigenes_Emporigen_Z = oReader.getValue() ;
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
         sName = "EmpresaOrigenes" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtEmpresaOrigenes_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_SdtEmpresaOrigenes_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpOrigen", gxTv_SdtEmpresaOrigenes_Emporigen);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtEmpresaOrigenes_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtEmpresaOrigenes_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresaOrigenes_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresaOrigenes_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpOrigen_Z", gxTv_SdtEmpresaOrigenes_Emporigen_Z);
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
      AddObjectProperty("CliCod", gxTv_SdtEmpresaOrigenes_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_SdtEmpresaOrigenes_Empcod, false, includeNonInitialized);
      AddObjectProperty("EmpOrigen", gxTv_SdtEmpresaOrigenes_Emporigen, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtEmpresaOrigenes_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtEmpresaOrigenes_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtEmpresaOrigenes_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_SdtEmpresaOrigenes_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpOrigen_Z", gxTv_SdtEmpresaOrigenes_Emporigen_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtEmpresaOrigenes sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtEmpresaOrigenes_N = (byte)(0) ;
         gxTv_SdtEmpresaOrigenes_Clicod = sdt.getgxTv_SdtEmpresaOrigenes_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_SdtEmpresaOrigenes_N = (byte)(0) ;
         gxTv_SdtEmpresaOrigenes_Empcod = sdt.getgxTv_SdtEmpresaOrigenes_Empcod() ;
      }
      if ( sdt.IsDirty("EmpOrigen") )
      {
         gxTv_SdtEmpresaOrigenes_N = (byte)(0) ;
         gxTv_SdtEmpresaOrigenes_Emporigen = sdt.getgxTv_SdtEmpresaOrigenes_Emporigen() ;
      }
   }

   public int getgxTv_SdtEmpresaOrigenes_Clicod( )
   {
      return gxTv_SdtEmpresaOrigenes_Clicod ;
   }

   public void setgxTv_SdtEmpresaOrigenes_Clicod( int value )
   {
      gxTv_SdtEmpresaOrigenes_N = (byte)(0) ;
      if ( gxTv_SdtEmpresaOrigenes_Clicod != value )
      {
         gxTv_SdtEmpresaOrigenes_Mode = "INS" ;
         this.setgxTv_SdtEmpresaOrigenes_Clicod_Z_SetNull( );
         this.setgxTv_SdtEmpresaOrigenes_Empcod_Z_SetNull( );
         this.setgxTv_SdtEmpresaOrigenes_Emporigen_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_SdtEmpresaOrigenes_Clicod = value ;
   }

   public short getgxTv_SdtEmpresaOrigenes_Empcod( )
   {
      return gxTv_SdtEmpresaOrigenes_Empcod ;
   }

   public void setgxTv_SdtEmpresaOrigenes_Empcod( short value )
   {
      gxTv_SdtEmpresaOrigenes_N = (byte)(0) ;
      if ( gxTv_SdtEmpresaOrigenes_Empcod != value )
      {
         gxTv_SdtEmpresaOrigenes_Mode = "INS" ;
         this.setgxTv_SdtEmpresaOrigenes_Clicod_Z_SetNull( );
         this.setgxTv_SdtEmpresaOrigenes_Empcod_Z_SetNull( );
         this.setgxTv_SdtEmpresaOrigenes_Emporigen_Z_SetNull( );
      }
      SetDirty("Empcod");
      gxTv_SdtEmpresaOrigenes_Empcod = value ;
   }

   public String getgxTv_SdtEmpresaOrigenes_Emporigen( )
   {
      return gxTv_SdtEmpresaOrigenes_Emporigen ;
   }

   public void setgxTv_SdtEmpresaOrigenes_Emporigen( String value )
   {
      gxTv_SdtEmpresaOrigenes_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtEmpresaOrigenes_Emporigen, value) != 0 )
      {
         gxTv_SdtEmpresaOrigenes_Mode = "INS" ;
         this.setgxTv_SdtEmpresaOrigenes_Clicod_Z_SetNull( );
         this.setgxTv_SdtEmpresaOrigenes_Empcod_Z_SetNull( );
         this.setgxTv_SdtEmpresaOrigenes_Emporigen_Z_SetNull( );
      }
      SetDirty("Emporigen");
      gxTv_SdtEmpresaOrigenes_Emporigen = value ;
   }

   public String getgxTv_SdtEmpresaOrigenes_Mode( )
   {
      return gxTv_SdtEmpresaOrigenes_Mode ;
   }

   public void setgxTv_SdtEmpresaOrigenes_Mode( String value )
   {
      gxTv_SdtEmpresaOrigenes_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtEmpresaOrigenes_Mode = value ;
   }

   public void setgxTv_SdtEmpresaOrigenes_Mode_SetNull( )
   {
      gxTv_SdtEmpresaOrigenes_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtEmpresaOrigenes_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresaOrigenes_Initialized( )
   {
      return gxTv_SdtEmpresaOrigenes_Initialized ;
   }

   public void setgxTv_SdtEmpresaOrigenes_Initialized( short value )
   {
      gxTv_SdtEmpresaOrigenes_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtEmpresaOrigenes_Initialized = value ;
   }

   public void setgxTv_SdtEmpresaOrigenes_Initialized_SetNull( )
   {
      gxTv_SdtEmpresaOrigenes_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtEmpresaOrigenes_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtEmpresaOrigenes_Clicod_Z( )
   {
      return gxTv_SdtEmpresaOrigenes_Clicod_Z ;
   }

   public void setgxTv_SdtEmpresaOrigenes_Clicod_Z( int value )
   {
      gxTv_SdtEmpresaOrigenes_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtEmpresaOrigenes_Clicod_Z = value ;
   }

   public void setgxTv_SdtEmpresaOrigenes_Clicod_Z_SetNull( )
   {
      gxTv_SdtEmpresaOrigenes_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtEmpresaOrigenes_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresaOrigenes_Empcod_Z( )
   {
      return gxTv_SdtEmpresaOrigenes_Empcod_Z ;
   }

   public void setgxTv_SdtEmpresaOrigenes_Empcod_Z( short value )
   {
      gxTv_SdtEmpresaOrigenes_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_SdtEmpresaOrigenes_Empcod_Z = value ;
   }

   public void setgxTv_SdtEmpresaOrigenes_Empcod_Z_SetNull( )
   {
      gxTv_SdtEmpresaOrigenes_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_SdtEmpresaOrigenes_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresaOrigenes_Emporigen_Z( )
   {
      return gxTv_SdtEmpresaOrigenes_Emporigen_Z ;
   }

   public void setgxTv_SdtEmpresaOrigenes_Emporigen_Z( String value )
   {
      gxTv_SdtEmpresaOrigenes_N = (byte)(0) ;
      SetDirty("Emporigen_Z");
      gxTv_SdtEmpresaOrigenes_Emporigen_Z = value ;
   }

   public void setgxTv_SdtEmpresaOrigenes_Emporigen_Z_SetNull( )
   {
      gxTv_SdtEmpresaOrigenes_Emporigen_Z = "" ;
      SetDirty("Emporigen_Z");
   }

   public boolean getgxTv_SdtEmpresaOrigenes_Emporigen_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.empresaorigenes_bc obj;
      obj = new web.empresaorigenes_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtEmpresaOrigenes_N = (byte)(1) ;
      gxTv_SdtEmpresaOrigenes_Emporigen = "" ;
      gxTv_SdtEmpresaOrigenes_Mode = "" ;
      gxTv_SdtEmpresaOrigenes_Emporigen_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtEmpresaOrigenes_N ;
   }

   public web.SdtEmpresaOrigenes Clone( )
   {
      web.SdtEmpresaOrigenes sdt;
      web.empresaorigenes_bc obj;
      sdt = (web.SdtEmpresaOrigenes)(clone()) ;
      obj = (web.empresaorigenes_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtEmpresaOrigenes struct )
   {
      setgxTv_SdtEmpresaOrigenes_Clicod(struct.getClicod());
      setgxTv_SdtEmpresaOrigenes_Empcod(struct.getEmpcod());
      setgxTv_SdtEmpresaOrigenes_Emporigen(struct.getEmporigen());
      setgxTv_SdtEmpresaOrigenes_Mode(struct.getMode());
      setgxTv_SdtEmpresaOrigenes_Initialized(struct.getInitialized());
      setgxTv_SdtEmpresaOrigenes_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtEmpresaOrigenes_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_SdtEmpresaOrigenes_Emporigen_Z(struct.getEmporigen_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtEmpresaOrigenes getStruct( )
   {
      web.StructSdtEmpresaOrigenes struct = new web.StructSdtEmpresaOrigenes ();
      struct.setClicod(getgxTv_SdtEmpresaOrigenes_Clicod());
      struct.setEmpcod(getgxTv_SdtEmpresaOrigenes_Empcod());
      struct.setEmporigen(getgxTv_SdtEmpresaOrigenes_Emporigen());
      struct.setMode(getgxTv_SdtEmpresaOrigenes_Mode());
      struct.setInitialized(getgxTv_SdtEmpresaOrigenes_Initialized());
      struct.setClicod_Z(getgxTv_SdtEmpresaOrigenes_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_SdtEmpresaOrigenes_Empcod_Z());
      struct.setEmporigen_Z(getgxTv_SdtEmpresaOrigenes_Emporigen_Z());
      return struct ;
   }

   private byte gxTv_SdtEmpresaOrigenes_N ;
   private short gxTv_SdtEmpresaOrigenes_Empcod ;
   private short gxTv_SdtEmpresaOrigenes_Initialized ;
   private short gxTv_SdtEmpresaOrigenes_Empcod_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtEmpresaOrigenes_Clicod ;
   private int gxTv_SdtEmpresaOrigenes_Clicod_Z ;
   private String gxTv_SdtEmpresaOrigenes_Emporigen ;
   private String gxTv_SdtEmpresaOrigenes_Mode ;
   private String gxTv_SdtEmpresaOrigenes_Emporigen_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
}

