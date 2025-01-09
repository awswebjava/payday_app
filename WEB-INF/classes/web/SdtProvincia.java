package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtProvincia extends GxSilentTrnSdt
{
   public SdtProvincia( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtProvincia.class));
   }

   public SdtProvincia( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle, context, "SdtProvincia");
      initialize( remoteHandle) ;
   }

   public SdtProvincia( int remoteHandle ,
                        StructSdtProvincia struct )
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

   public void Load( short AV46PaiCod ,
                     short AV47ProvCod )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Short.valueOf(AV46PaiCod),Short.valueOf(AV47ProvCod)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"PaiCod", short.class}, new Object[]{"ProvCod", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Provincia");
      metadata.set("BT", "Provincia");
      metadata.set("PK", "[ \"PaiCod\",\"ProvCod\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"PaiCod\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiCod") )
            {
               gxTv_SdtProvincia_Paicod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiNom") )
            {
               gxTv_SdtProvincia_Painom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProvCod") )
            {
               gxTv_SdtProvincia_Provcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProvNom") )
            {
               gxTv_SdtProvincia_Provnom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProvSiradig") )
            {
               gxTv_SdtProvincia_Provsiradig = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtProvincia_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtProvincia_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiCod_Z") )
            {
               gxTv_SdtProvincia_Paicod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiNom_Z") )
            {
               gxTv_SdtProvincia_Painom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProvCod_Z") )
            {
               gxTv_SdtProvincia_Provcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProvNom_Z") )
            {
               gxTv_SdtProvincia_Provnom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProvSiradig_Z") )
            {
               gxTv_SdtProvincia_Provsiradig_Z = (short)(getnumericvalue(oReader.getValue())) ;
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
         sName = "Provincia" ;
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
      oWriter.writeElement("PaiCod", GXutil.trim( GXutil.str( gxTv_SdtProvincia_Paicod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiNom", gxTv_SdtProvincia_Painom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ProvCod", GXutil.trim( GXutil.str( gxTv_SdtProvincia_Provcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ProvNom", gxTv_SdtProvincia_Provnom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ProvSiradig", GXutil.trim( GXutil.str( gxTv_SdtProvincia_Provsiradig, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtProvincia_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtProvincia_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiCod_Z", GXutil.trim( GXutil.str( gxTv_SdtProvincia_Paicod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiNom_Z", gxTv_SdtProvincia_Painom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ProvCod_Z", GXutil.trim( GXutil.str( gxTv_SdtProvincia_Provcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ProvNom_Z", gxTv_SdtProvincia_Provnom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ProvSiradig_Z", GXutil.trim( GXutil.str( gxTv_SdtProvincia_Provsiradig_Z, 4, 0)));
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
      AddObjectProperty("PaiCod", gxTv_SdtProvincia_Paicod, false, includeNonInitialized);
      AddObjectProperty("PaiNom", gxTv_SdtProvincia_Painom, false, includeNonInitialized);
      AddObjectProperty("ProvCod", gxTv_SdtProvincia_Provcod, false, includeNonInitialized);
      AddObjectProperty("ProvNom", gxTv_SdtProvincia_Provnom, false, includeNonInitialized);
      AddObjectProperty("ProvSiradig", gxTv_SdtProvincia_Provsiradig, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtProvincia_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtProvincia_Initialized, false, includeNonInitialized);
         AddObjectProperty("PaiCod_Z", gxTv_SdtProvincia_Paicod_Z, false, includeNonInitialized);
         AddObjectProperty("PaiNom_Z", gxTv_SdtProvincia_Painom_Z, false, includeNonInitialized);
         AddObjectProperty("ProvCod_Z", gxTv_SdtProvincia_Provcod_Z, false, includeNonInitialized);
         AddObjectProperty("ProvNom_Z", gxTv_SdtProvincia_Provnom_Z, false, includeNonInitialized);
         AddObjectProperty("ProvSiradig_Z", gxTv_SdtProvincia_Provsiradig_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtProvincia sdt )
   {
      if ( sdt.IsDirty("PaiCod") )
      {
         gxTv_SdtProvincia_N = (byte)(0) ;
         gxTv_SdtProvincia_Paicod = sdt.getgxTv_SdtProvincia_Paicod() ;
      }
      if ( sdt.IsDirty("PaiNom") )
      {
         gxTv_SdtProvincia_N = (byte)(0) ;
         gxTv_SdtProvincia_Painom = sdt.getgxTv_SdtProvincia_Painom() ;
      }
      if ( sdt.IsDirty("ProvCod") )
      {
         gxTv_SdtProvincia_N = (byte)(0) ;
         gxTv_SdtProvincia_Provcod = sdt.getgxTv_SdtProvincia_Provcod() ;
      }
      if ( sdt.IsDirty("ProvNom") )
      {
         gxTv_SdtProvincia_N = (byte)(0) ;
         gxTv_SdtProvincia_Provnom = sdt.getgxTv_SdtProvincia_Provnom() ;
      }
      if ( sdt.IsDirty("ProvSiradig") )
      {
         gxTv_SdtProvincia_N = (byte)(0) ;
         gxTv_SdtProvincia_Provsiradig = sdt.getgxTv_SdtProvincia_Provsiradig() ;
      }
   }

   public short getgxTv_SdtProvincia_Paicod( )
   {
      return gxTv_SdtProvincia_Paicod ;
   }

   public void setgxTv_SdtProvincia_Paicod( short value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      if ( gxTv_SdtProvincia_Paicod != value )
      {
         gxTv_SdtProvincia_Mode = "INS" ;
         this.setgxTv_SdtProvincia_Paicod_Z_SetNull( );
         this.setgxTv_SdtProvincia_Painom_Z_SetNull( );
         this.setgxTv_SdtProvincia_Provcod_Z_SetNull( );
         this.setgxTv_SdtProvincia_Provnom_Z_SetNull( );
         this.setgxTv_SdtProvincia_Provsiradig_Z_SetNull( );
      }
      SetDirty("Paicod");
      gxTv_SdtProvincia_Paicod = value ;
   }

   public String getgxTv_SdtProvincia_Painom( )
   {
      return gxTv_SdtProvincia_Painom ;
   }

   public void setgxTv_SdtProvincia_Painom( String value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      SetDirty("Painom");
      gxTv_SdtProvincia_Painom = value ;
   }

   public short getgxTv_SdtProvincia_Provcod( )
   {
      return gxTv_SdtProvincia_Provcod ;
   }

   public void setgxTv_SdtProvincia_Provcod( short value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      if ( gxTv_SdtProvincia_Provcod != value )
      {
         gxTv_SdtProvincia_Mode = "INS" ;
         this.setgxTv_SdtProvincia_Paicod_Z_SetNull( );
         this.setgxTv_SdtProvincia_Painom_Z_SetNull( );
         this.setgxTv_SdtProvincia_Provcod_Z_SetNull( );
         this.setgxTv_SdtProvincia_Provnom_Z_SetNull( );
         this.setgxTv_SdtProvincia_Provsiradig_Z_SetNull( );
      }
      SetDirty("Provcod");
      gxTv_SdtProvincia_Provcod = value ;
   }

   public String getgxTv_SdtProvincia_Provnom( )
   {
      return gxTv_SdtProvincia_Provnom ;
   }

   public void setgxTv_SdtProvincia_Provnom( String value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      SetDirty("Provnom");
      gxTv_SdtProvincia_Provnom = value ;
   }

   public short getgxTv_SdtProvincia_Provsiradig( )
   {
      return gxTv_SdtProvincia_Provsiradig ;
   }

   public void setgxTv_SdtProvincia_Provsiradig( short value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      SetDirty("Provsiradig");
      gxTv_SdtProvincia_Provsiradig = value ;
   }

   public String getgxTv_SdtProvincia_Mode( )
   {
      return gxTv_SdtProvincia_Mode ;
   }

   public void setgxTv_SdtProvincia_Mode( String value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtProvincia_Mode = value ;
   }

   public void setgxTv_SdtProvincia_Mode_SetNull( )
   {
      gxTv_SdtProvincia_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtProvincia_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtProvincia_Initialized( )
   {
      return gxTv_SdtProvincia_Initialized ;
   }

   public void setgxTv_SdtProvincia_Initialized( short value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtProvincia_Initialized = value ;
   }

   public void setgxTv_SdtProvincia_Initialized_SetNull( )
   {
      gxTv_SdtProvincia_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtProvincia_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtProvincia_Paicod_Z( )
   {
      return gxTv_SdtProvincia_Paicod_Z ;
   }

   public void setgxTv_SdtProvincia_Paicod_Z( short value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      SetDirty("Paicod_Z");
      gxTv_SdtProvincia_Paicod_Z = value ;
   }

   public void setgxTv_SdtProvincia_Paicod_Z_SetNull( )
   {
      gxTv_SdtProvincia_Paicod_Z = (short)(0) ;
      SetDirty("Paicod_Z");
   }

   public boolean getgxTv_SdtProvincia_Paicod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProvincia_Painom_Z( )
   {
      return gxTv_SdtProvincia_Painom_Z ;
   }

   public void setgxTv_SdtProvincia_Painom_Z( String value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      SetDirty("Painom_Z");
      gxTv_SdtProvincia_Painom_Z = value ;
   }

   public void setgxTv_SdtProvincia_Painom_Z_SetNull( )
   {
      gxTv_SdtProvincia_Painom_Z = "" ;
      SetDirty("Painom_Z");
   }

   public boolean getgxTv_SdtProvincia_Painom_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtProvincia_Provcod_Z( )
   {
      return gxTv_SdtProvincia_Provcod_Z ;
   }

   public void setgxTv_SdtProvincia_Provcod_Z( short value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      SetDirty("Provcod_Z");
      gxTv_SdtProvincia_Provcod_Z = value ;
   }

   public void setgxTv_SdtProvincia_Provcod_Z_SetNull( )
   {
      gxTv_SdtProvincia_Provcod_Z = (short)(0) ;
      SetDirty("Provcod_Z");
   }

   public boolean getgxTv_SdtProvincia_Provcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtProvincia_Provnom_Z( )
   {
      return gxTv_SdtProvincia_Provnom_Z ;
   }

   public void setgxTv_SdtProvincia_Provnom_Z( String value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      SetDirty("Provnom_Z");
      gxTv_SdtProvincia_Provnom_Z = value ;
   }

   public void setgxTv_SdtProvincia_Provnom_Z_SetNull( )
   {
      gxTv_SdtProvincia_Provnom_Z = "" ;
      SetDirty("Provnom_Z");
   }

   public boolean getgxTv_SdtProvincia_Provnom_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtProvincia_Provsiradig_Z( )
   {
      return gxTv_SdtProvincia_Provsiradig_Z ;
   }

   public void setgxTv_SdtProvincia_Provsiradig_Z( short value )
   {
      gxTv_SdtProvincia_N = (byte)(0) ;
      SetDirty("Provsiradig_Z");
      gxTv_SdtProvincia_Provsiradig_Z = value ;
   }

   public void setgxTv_SdtProvincia_Provsiradig_Z_SetNull( )
   {
      gxTv_SdtProvincia_Provsiradig_Z = (short)(0) ;
      SetDirty("Provsiradig_Z");
   }

   public boolean getgxTv_SdtProvincia_Provsiradig_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.provincia_bc obj;
      obj = new web.provincia_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtProvincia_N = (byte)(1) ;
      gxTv_SdtProvincia_Painom = "" ;
      gxTv_SdtProvincia_Provnom = "" ;
      gxTv_SdtProvincia_Mode = "" ;
      gxTv_SdtProvincia_Painom_Z = "" ;
      gxTv_SdtProvincia_Provnom_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtProvincia_N ;
   }

   public web.SdtProvincia Clone( )
   {
      web.SdtProvincia sdt;
      web.provincia_bc obj;
      sdt = (web.SdtProvincia)(clone()) ;
      obj = (web.provincia_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtProvincia struct )
   {
      setgxTv_SdtProvincia_Paicod(struct.getPaicod());
      setgxTv_SdtProvincia_Painom(struct.getPainom());
      setgxTv_SdtProvincia_Provcod(struct.getProvcod());
      setgxTv_SdtProvincia_Provnom(struct.getProvnom());
      setgxTv_SdtProvincia_Provsiradig(struct.getProvsiradig());
      setgxTv_SdtProvincia_Mode(struct.getMode());
      setgxTv_SdtProvincia_Initialized(struct.getInitialized());
      setgxTv_SdtProvincia_Paicod_Z(struct.getPaicod_Z());
      setgxTv_SdtProvincia_Painom_Z(struct.getPainom_Z());
      setgxTv_SdtProvincia_Provcod_Z(struct.getProvcod_Z());
      setgxTv_SdtProvincia_Provnom_Z(struct.getProvnom_Z());
      setgxTv_SdtProvincia_Provsiradig_Z(struct.getProvsiradig_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtProvincia getStruct( )
   {
      web.StructSdtProvincia struct = new web.StructSdtProvincia ();
      struct.setPaicod(getgxTv_SdtProvincia_Paicod());
      struct.setPainom(getgxTv_SdtProvincia_Painom());
      struct.setProvcod(getgxTv_SdtProvincia_Provcod());
      struct.setProvnom(getgxTv_SdtProvincia_Provnom());
      struct.setProvsiradig(getgxTv_SdtProvincia_Provsiradig());
      struct.setMode(getgxTv_SdtProvincia_Mode());
      struct.setInitialized(getgxTv_SdtProvincia_Initialized());
      struct.setPaicod_Z(getgxTv_SdtProvincia_Paicod_Z());
      struct.setPainom_Z(getgxTv_SdtProvincia_Painom_Z());
      struct.setProvcod_Z(getgxTv_SdtProvincia_Provcod_Z());
      struct.setProvnom_Z(getgxTv_SdtProvincia_Provnom_Z());
      struct.setProvsiradig_Z(getgxTv_SdtProvincia_Provsiradig_Z());
      return struct ;
   }

   private byte gxTv_SdtProvincia_N ;
   private short gxTv_SdtProvincia_Paicod ;
   private short gxTv_SdtProvincia_Provcod ;
   private short gxTv_SdtProvincia_Provsiradig ;
   private short gxTv_SdtProvincia_Initialized ;
   private short gxTv_SdtProvincia_Paicod_Z ;
   private short gxTv_SdtProvincia_Provcod_Z ;
   private short gxTv_SdtProvincia_Provsiradig_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtProvincia_Mode ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtProvincia_Painom ;
   private String gxTv_SdtProvincia_Provnom ;
   private String gxTv_SdtProvincia_Painom_Z ;
   private String gxTv_SdtProvincia_Provnom_Z ;
}

