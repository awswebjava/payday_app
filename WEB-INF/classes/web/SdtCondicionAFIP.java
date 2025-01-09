package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtCondicionAFIP extends GxSilentTrnSdt
{
   public SdtCondicionAFIP( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtCondicionAFIP.class));
   }

   public SdtCondicionAFIP( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle, context, "SdtCondicionAFIP");
      initialize( remoteHandle) ;
   }

   public SdtCondicionAFIP( int remoteHandle ,
                            StructSdtCondicionAFIP struct )
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

   public void Load( short AV17CondiCodigo )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Short.valueOf(AV17CondiCodigo)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CondiCodigo", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "CondicionAFIP");
      metadata.set("BT", "CondicionAFIP");
      metadata.set("PK", "[ \"CondiCodigo\" ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CondiCodigo") )
            {
               gxTv_SdtCondicionAFIP_Condicodigo = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CondiDescri") )
            {
               gxTv_SdtCondicionAFIP_Condidescri = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CondiDescriSinAc") )
            {
               gxTv_SdtCondicionAFIP_Condidescrisinac = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtCondicionAFIP_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtCondicionAFIP_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CondiCodigo_Z") )
            {
               gxTv_SdtCondicionAFIP_Condicodigo_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CondiDescri_Z") )
            {
               gxTv_SdtCondicionAFIP_Condidescri_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CondiDescriSinAc_Z") )
            {
               gxTv_SdtCondicionAFIP_Condidescrisinac_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CondiCodigo_N") )
            {
               gxTv_SdtCondicionAFIP_Condicodigo_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "CondicionAFIP" ;
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
      oWriter.writeElement("CondiCodigo", GXutil.trim( GXutil.str( gxTv_SdtCondicionAFIP_Condicodigo, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CondiDescri", gxTv_SdtCondicionAFIP_Condidescri);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CondiDescriSinAc", gxTv_SdtCondicionAFIP_Condidescrisinac);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtCondicionAFIP_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtCondicionAFIP_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CondiCodigo_Z", GXutil.trim( GXutil.str( gxTv_SdtCondicionAFIP_Condicodigo_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CondiDescri_Z", gxTv_SdtCondicionAFIP_Condidescri_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CondiDescriSinAc_Z", gxTv_SdtCondicionAFIP_Condidescrisinac_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CondiCodigo_N", GXutil.trim( GXutil.str( gxTv_SdtCondicionAFIP_Condicodigo_N, 1, 0)));
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
      AddObjectProperty("CondiCodigo", gxTv_SdtCondicionAFIP_Condicodigo, false, includeNonInitialized);
      AddObjectProperty("CondiCodigo_N", gxTv_SdtCondicionAFIP_Condicodigo_N, false, includeNonInitialized);
      AddObjectProperty("CondiDescri", gxTv_SdtCondicionAFIP_Condidescri, false, includeNonInitialized);
      AddObjectProperty("CondiDescriSinAc", gxTv_SdtCondicionAFIP_Condidescrisinac, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtCondicionAFIP_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtCondicionAFIP_Initialized, false, includeNonInitialized);
         AddObjectProperty("CondiCodigo_Z", gxTv_SdtCondicionAFIP_Condicodigo_Z, false, includeNonInitialized);
         AddObjectProperty("CondiDescri_Z", gxTv_SdtCondicionAFIP_Condidescri_Z, false, includeNonInitialized);
         AddObjectProperty("CondiDescriSinAc_Z", gxTv_SdtCondicionAFIP_Condidescrisinac_Z, false, includeNonInitialized);
         AddObjectProperty("CondiCodigo_N", gxTv_SdtCondicionAFIP_Condicodigo_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtCondicionAFIP sdt )
   {
      if ( sdt.IsDirty("CondiCodigo") )
      {
         gxTv_SdtCondicionAFIP_N = (byte)(0) ;
         gxTv_SdtCondicionAFIP_Condicodigo = sdt.getgxTv_SdtCondicionAFIP_Condicodigo() ;
      }
      if ( sdt.IsDirty("CondiDescri") )
      {
         gxTv_SdtCondicionAFIP_N = (byte)(0) ;
         gxTv_SdtCondicionAFIP_Condidescri = sdt.getgxTv_SdtCondicionAFIP_Condidescri() ;
      }
      if ( sdt.IsDirty("CondiDescriSinAc") )
      {
         gxTv_SdtCondicionAFIP_N = (byte)(0) ;
         gxTv_SdtCondicionAFIP_Condidescrisinac = sdt.getgxTv_SdtCondicionAFIP_Condidescrisinac() ;
      }
   }

   public short getgxTv_SdtCondicionAFIP_Condicodigo( )
   {
      return gxTv_SdtCondicionAFIP_Condicodigo ;
   }

   public void setgxTv_SdtCondicionAFIP_Condicodigo( short value )
   {
      gxTv_SdtCondicionAFIP_N = (byte)(0) ;
      if ( gxTv_SdtCondicionAFIP_Condicodigo != value )
      {
         gxTv_SdtCondicionAFIP_Mode = "INS" ;
         this.setgxTv_SdtCondicionAFIP_Condicodigo_Z_SetNull( );
         this.setgxTv_SdtCondicionAFIP_Condidescri_Z_SetNull( );
         this.setgxTv_SdtCondicionAFIP_Condidescrisinac_Z_SetNull( );
      }
      SetDirty("Condicodigo");
      gxTv_SdtCondicionAFIP_Condicodigo = value ;
   }

   public String getgxTv_SdtCondicionAFIP_Condidescri( )
   {
      return gxTv_SdtCondicionAFIP_Condidescri ;
   }

   public void setgxTv_SdtCondicionAFIP_Condidescri( String value )
   {
      gxTv_SdtCondicionAFIP_N = (byte)(0) ;
      SetDirty("Condidescri");
      gxTv_SdtCondicionAFIP_Condidescri = value ;
   }

   public String getgxTv_SdtCondicionAFIP_Condidescrisinac( )
   {
      return gxTv_SdtCondicionAFIP_Condidescrisinac ;
   }

   public void setgxTv_SdtCondicionAFIP_Condidescrisinac( String value )
   {
      gxTv_SdtCondicionAFIP_N = (byte)(0) ;
      SetDirty("Condidescrisinac");
      gxTv_SdtCondicionAFIP_Condidescrisinac = value ;
   }

   public String getgxTv_SdtCondicionAFIP_Mode( )
   {
      return gxTv_SdtCondicionAFIP_Mode ;
   }

   public void setgxTv_SdtCondicionAFIP_Mode( String value )
   {
      gxTv_SdtCondicionAFIP_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtCondicionAFIP_Mode = value ;
   }

   public void setgxTv_SdtCondicionAFIP_Mode_SetNull( )
   {
      gxTv_SdtCondicionAFIP_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtCondicionAFIP_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCondicionAFIP_Initialized( )
   {
      return gxTv_SdtCondicionAFIP_Initialized ;
   }

   public void setgxTv_SdtCondicionAFIP_Initialized( short value )
   {
      gxTv_SdtCondicionAFIP_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtCondicionAFIP_Initialized = value ;
   }

   public void setgxTv_SdtCondicionAFIP_Initialized_SetNull( )
   {
      gxTv_SdtCondicionAFIP_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtCondicionAFIP_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCondicionAFIP_Condicodigo_Z( )
   {
      return gxTv_SdtCondicionAFIP_Condicodigo_Z ;
   }

   public void setgxTv_SdtCondicionAFIP_Condicodigo_Z( short value )
   {
      gxTv_SdtCondicionAFIP_N = (byte)(0) ;
      SetDirty("Condicodigo_Z");
      gxTv_SdtCondicionAFIP_Condicodigo_Z = value ;
   }

   public void setgxTv_SdtCondicionAFIP_Condicodigo_Z_SetNull( )
   {
      gxTv_SdtCondicionAFIP_Condicodigo_Z = (short)(0) ;
      SetDirty("Condicodigo_Z");
   }

   public boolean getgxTv_SdtCondicionAFIP_Condicodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCondicionAFIP_Condidescri_Z( )
   {
      return gxTv_SdtCondicionAFIP_Condidescri_Z ;
   }

   public void setgxTv_SdtCondicionAFIP_Condidescri_Z( String value )
   {
      gxTv_SdtCondicionAFIP_N = (byte)(0) ;
      SetDirty("Condidescri_Z");
      gxTv_SdtCondicionAFIP_Condidescri_Z = value ;
   }

   public void setgxTv_SdtCondicionAFIP_Condidescri_Z_SetNull( )
   {
      gxTv_SdtCondicionAFIP_Condidescri_Z = "" ;
      SetDirty("Condidescri_Z");
   }

   public boolean getgxTv_SdtCondicionAFIP_Condidescri_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCondicionAFIP_Condidescrisinac_Z( )
   {
      return gxTv_SdtCondicionAFIP_Condidescrisinac_Z ;
   }

   public void setgxTv_SdtCondicionAFIP_Condidescrisinac_Z( String value )
   {
      gxTv_SdtCondicionAFIP_N = (byte)(0) ;
      SetDirty("Condidescrisinac_Z");
      gxTv_SdtCondicionAFIP_Condidescrisinac_Z = value ;
   }

   public void setgxTv_SdtCondicionAFIP_Condidescrisinac_Z_SetNull( )
   {
      gxTv_SdtCondicionAFIP_Condidescrisinac_Z = "" ;
      SetDirty("Condidescrisinac_Z");
   }

   public boolean getgxTv_SdtCondicionAFIP_Condidescrisinac_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCondicionAFIP_Condicodigo_N( )
   {
      return gxTv_SdtCondicionAFIP_Condicodigo_N ;
   }

   public void setgxTv_SdtCondicionAFIP_Condicodigo_N( byte value )
   {
      gxTv_SdtCondicionAFIP_N = (byte)(0) ;
      SetDirty("Condicodigo_N");
      gxTv_SdtCondicionAFIP_Condicodigo_N = value ;
   }

   public void setgxTv_SdtCondicionAFIP_Condicodigo_N_SetNull( )
   {
      gxTv_SdtCondicionAFIP_Condicodigo_N = (byte)(0) ;
      SetDirty("Condicodigo_N");
   }

   public boolean getgxTv_SdtCondicionAFIP_Condicodigo_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.condicionafip_bc obj;
      obj = new web.condicionafip_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtCondicionAFIP_N = (byte)(1) ;
      gxTv_SdtCondicionAFIP_Condidescri = "" ;
      gxTv_SdtCondicionAFIP_Condidescrisinac = "" ;
      gxTv_SdtCondicionAFIP_Mode = "" ;
      gxTv_SdtCondicionAFIP_Condidescri_Z = "" ;
      gxTv_SdtCondicionAFIP_Condidescrisinac_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtCondicionAFIP_N ;
   }

   public web.SdtCondicionAFIP Clone( )
   {
      web.SdtCondicionAFIP sdt;
      web.condicionafip_bc obj;
      sdt = (web.SdtCondicionAFIP)(clone()) ;
      obj = (web.condicionafip_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtCondicionAFIP struct )
   {
      setgxTv_SdtCondicionAFIP_Condicodigo(struct.getCondicodigo());
      setgxTv_SdtCondicionAFIP_Condidescri(struct.getCondidescri());
      setgxTv_SdtCondicionAFIP_Condidescrisinac(struct.getCondidescrisinac());
      setgxTv_SdtCondicionAFIP_Mode(struct.getMode());
      setgxTv_SdtCondicionAFIP_Initialized(struct.getInitialized());
      setgxTv_SdtCondicionAFIP_Condicodigo_Z(struct.getCondicodigo_Z());
      setgxTv_SdtCondicionAFIP_Condidescri_Z(struct.getCondidescri_Z());
      setgxTv_SdtCondicionAFIP_Condidescrisinac_Z(struct.getCondidescrisinac_Z());
      setgxTv_SdtCondicionAFIP_Condicodigo_N(struct.getCondicodigo_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtCondicionAFIP getStruct( )
   {
      web.StructSdtCondicionAFIP struct = new web.StructSdtCondicionAFIP ();
      struct.setCondicodigo(getgxTv_SdtCondicionAFIP_Condicodigo());
      struct.setCondidescri(getgxTv_SdtCondicionAFIP_Condidescri());
      struct.setCondidescrisinac(getgxTv_SdtCondicionAFIP_Condidescrisinac());
      struct.setMode(getgxTv_SdtCondicionAFIP_Mode());
      struct.setInitialized(getgxTv_SdtCondicionAFIP_Initialized());
      struct.setCondicodigo_Z(getgxTv_SdtCondicionAFIP_Condicodigo_Z());
      struct.setCondidescri_Z(getgxTv_SdtCondicionAFIP_Condidescri_Z());
      struct.setCondidescrisinac_Z(getgxTv_SdtCondicionAFIP_Condidescrisinac_Z());
      struct.setCondicodigo_N(getgxTv_SdtCondicionAFIP_Condicodigo_N());
      return struct ;
   }

   private byte gxTv_SdtCondicionAFIP_N ;
   private byte gxTv_SdtCondicionAFIP_Condicodigo_N ;
   private short gxTv_SdtCondicionAFIP_Condicodigo ;
   private short gxTv_SdtCondicionAFIP_Initialized ;
   private short gxTv_SdtCondicionAFIP_Condicodigo_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtCondicionAFIP_Mode ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtCondicionAFIP_Condidescri ;
   private String gxTv_SdtCondicionAFIP_Condidescrisinac ;
   private String gxTv_SdtCondicionAFIP_Condidescri_Z ;
   private String gxTv_SdtCondicionAFIP_Condidescrisinac_Z ;
}

