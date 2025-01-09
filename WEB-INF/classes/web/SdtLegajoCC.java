package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtLegajoCC extends GxSilentTrnSdt
{
   public SdtLegajoCC( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtLegajoCC.class));
   }

   public SdtLegajoCC( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle, context, "SdtLegajoCC");
      initialize( remoteHandle) ;
   }

   public SdtLegajoCC( int remoteHandle ,
                       StructSdtLegajoCC struct )
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
                     int AV6LegNumero ,
                     short AV77CenCodigo )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1EmpCod),Integer.valueOf(AV6LegNumero),Short.valueOf(AV77CenCodigo)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"EmpCod", short.class}, new Object[]{"LegNumero", int.class}, new Object[]{"CenCodigo", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "LegajoCC");
      metadata.set("BT", "LegajoCC");
      metadata.set("PK", "[ \"CliCod\",\"EmpCod\",\"LegNumero\",\"CenCodigo\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"CenCodigo\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"LegNumero\" ],\"FKMap\":[  ] } ]");
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
               gxTv_SdtLegajoCC_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_SdtLegajoCC_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero") )
            {
               gxTv_SdtLegajoCC_Legnumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CenCodigo") )
            {
               gxTv_SdtLegajoCC_Cencodigo = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegCenPrc") )
            {
               gxTv_SdtLegajoCC_Legcenprc = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CenDescripcion") )
            {
               gxTv_SdtLegajoCC_Cendescripcion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtLegajoCC_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtLegajoCC_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtLegajoCC_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_SdtLegajoCC_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero_Z") )
            {
               gxTv_SdtLegajoCC_Legnumero_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CenCodigo_Z") )
            {
               gxTv_SdtLegajoCC_Cencodigo_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegCenPrc_Z") )
            {
               gxTv_SdtLegajoCC_Legcenprc_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CenDescripcion_Z") )
            {
               gxTv_SdtLegajoCC_Cendescripcion_Z = oReader.getValue() ;
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
         sName = "LegajoCC" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtLegajoCC_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_SdtLegajoCC_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNumero", GXutil.trim( GXutil.str( gxTv_SdtLegajoCC_Legnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CenCodigo", GXutil.trim( GXutil.str( gxTv_SdtLegajoCC_Cencodigo, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegCenPrc", GXutil.trim( GXutil.strNoRound( gxTv_SdtLegajoCC_Legcenprc, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CenDescripcion", gxTv_SdtLegajoCC_Cendescripcion);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtLegajoCC_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtLegajoCC_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajoCC_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajoCC_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegNumero_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajoCC_Legnumero_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CenCodigo_Z", GXutil.trim( GXutil.str( gxTv_SdtLegajoCC_Cencodigo_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegCenPrc_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLegajoCC_Legcenprc_Z, 6, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CenDescripcion_Z", gxTv_SdtLegajoCC_Cendescripcion_Z);
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
      AddObjectProperty("CliCod", gxTv_SdtLegajoCC_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_SdtLegajoCC_Empcod, false, includeNonInitialized);
      AddObjectProperty("LegNumero", gxTv_SdtLegajoCC_Legnumero, false, includeNonInitialized);
      AddObjectProperty("CenCodigo", gxTv_SdtLegajoCC_Cencodigo, false, includeNonInitialized);
      AddObjectProperty("LegCenPrc", gxTv_SdtLegajoCC_Legcenprc, false, includeNonInitialized);
      AddObjectProperty("CenDescripcion", gxTv_SdtLegajoCC_Cendescripcion, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtLegajoCC_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtLegajoCC_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtLegajoCC_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_SdtLegajoCC_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("LegNumero_Z", gxTv_SdtLegajoCC_Legnumero_Z, false, includeNonInitialized);
         AddObjectProperty("CenCodigo_Z", gxTv_SdtLegajoCC_Cencodigo_Z, false, includeNonInitialized);
         AddObjectProperty("LegCenPrc_Z", gxTv_SdtLegajoCC_Legcenprc_Z, false, includeNonInitialized);
         AddObjectProperty("CenDescripcion_Z", gxTv_SdtLegajoCC_Cendescripcion_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtLegajoCC sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtLegajoCC_N = (byte)(0) ;
         gxTv_SdtLegajoCC_Clicod = sdt.getgxTv_SdtLegajoCC_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_SdtLegajoCC_N = (byte)(0) ;
         gxTv_SdtLegajoCC_Empcod = sdt.getgxTv_SdtLegajoCC_Empcod() ;
      }
      if ( sdt.IsDirty("LegNumero") )
      {
         gxTv_SdtLegajoCC_N = (byte)(0) ;
         gxTv_SdtLegajoCC_Legnumero = sdt.getgxTv_SdtLegajoCC_Legnumero() ;
      }
      if ( sdt.IsDirty("CenCodigo") )
      {
         gxTv_SdtLegajoCC_N = (byte)(0) ;
         gxTv_SdtLegajoCC_Cencodigo = sdt.getgxTv_SdtLegajoCC_Cencodigo() ;
      }
      if ( sdt.IsDirty("LegCenPrc") )
      {
         gxTv_SdtLegajoCC_N = (byte)(0) ;
         gxTv_SdtLegajoCC_Legcenprc = sdt.getgxTv_SdtLegajoCC_Legcenprc() ;
      }
      if ( sdt.IsDirty("CenDescripcion") )
      {
         gxTv_SdtLegajoCC_N = (byte)(0) ;
         gxTv_SdtLegajoCC_Cendescripcion = sdt.getgxTv_SdtLegajoCC_Cendescripcion() ;
      }
   }

   public int getgxTv_SdtLegajoCC_Clicod( )
   {
      return gxTv_SdtLegajoCC_Clicod ;
   }

   public void setgxTv_SdtLegajoCC_Clicod( int value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      if ( gxTv_SdtLegajoCC_Clicod != value )
      {
         gxTv_SdtLegajoCC_Mode = "INS" ;
         this.setgxTv_SdtLegajoCC_Clicod_Z_SetNull( );
         this.setgxTv_SdtLegajoCC_Empcod_Z_SetNull( );
         this.setgxTv_SdtLegajoCC_Legnumero_Z_SetNull( );
         this.setgxTv_SdtLegajoCC_Cencodigo_Z_SetNull( );
         this.setgxTv_SdtLegajoCC_Legcenprc_Z_SetNull( );
         this.setgxTv_SdtLegajoCC_Cendescripcion_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_SdtLegajoCC_Clicod = value ;
   }

   public short getgxTv_SdtLegajoCC_Empcod( )
   {
      return gxTv_SdtLegajoCC_Empcod ;
   }

   public void setgxTv_SdtLegajoCC_Empcod( short value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      if ( gxTv_SdtLegajoCC_Empcod != value )
      {
         gxTv_SdtLegajoCC_Mode = "INS" ;
         this.setgxTv_SdtLegajoCC_Clicod_Z_SetNull( );
         this.setgxTv_SdtLegajoCC_Empcod_Z_SetNull( );
         this.setgxTv_SdtLegajoCC_Legnumero_Z_SetNull( );
         this.setgxTv_SdtLegajoCC_Cencodigo_Z_SetNull( );
         this.setgxTv_SdtLegajoCC_Legcenprc_Z_SetNull( );
         this.setgxTv_SdtLegajoCC_Cendescripcion_Z_SetNull( );
      }
      SetDirty("Empcod");
      gxTv_SdtLegajoCC_Empcod = value ;
   }

   public int getgxTv_SdtLegajoCC_Legnumero( )
   {
      return gxTv_SdtLegajoCC_Legnumero ;
   }

   public void setgxTv_SdtLegajoCC_Legnumero( int value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      if ( gxTv_SdtLegajoCC_Legnumero != value )
      {
         gxTv_SdtLegajoCC_Mode = "INS" ;
         this.setgxTv_SdtLegajoCC_Clicod_Z_SetNull( );
         this.setgxTv_SdtLegajoCC_Empcod_Z_SetNull( );
         this.setgxTv_SdtLegajoCC_Legnumero_Z_SetNull( );
         this.setgxTv_SdtLegajoCC_Cencodigo_Z_SetNull( );
         this.setgxTv_SdtLegajoCC_Legcenprc_Z_SetNull( );
         this.setgxTv_SdtLegajoCC_Cendescripcion_Z_SetNull( );
      }
      SetDirty("Legnumero");
      gxTv_SdtLegajoCC_Legnumero = value ;
   }

   public short getgxTv_SdtLegajoCC_Cencodigo( )
   {
      return gxTv_SdtLegajoCC_Cencodigo ;
   }

   public void setgxTv_SdtLegajoCC_Cencodigo( short value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      if ( gxTv_SdtLegajoCC_Cencodigo != value )
      {
         gxTv_SdtLegajoCC_Mode = "INS" ;
         this.setgxTv_SdtLegajoCC_Clicod_Z_SetNull( );
         this.setgxTv_SdtLegajoCC_Empcod_Z_SetNull( );
         this.setgxTv_SdtLegajoCC_Legnumero_Z_SetNull( );
         this.setgxTv_SdtLegajoCC_Cencodigo_Z_SetNull( );
         this.setgxTv_SdtLegajoCC_Legcenprc_Z_SetNull( );
         this.setgxTv_SdtLegajoCC_Cendescripcion_Z_SetNull( );
      }
      SetDirty("Cencodigo");
      gxTv_SdtLegajoCC_Cencodigo = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLegajoCC_Legcenprc( )
   {
      return gxTv_SdtLegajoCC_Legcenprc ;
   }

   public void setgxTv_SdtLegajoCC_Legcenprc( java.math.BigDecimal value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      SetDirty("Legcenprc");
      gxTv_SdtLegajoCC_Legcenprc = value ;
   }

   public String getgxTv_SdtLegajoCC_Cendescripcion( )
   {
      return gxTv_SdtLegajoCC_Cendescripcion ;
   }

   public void setgxTv_SdtLegajoCC_Cendescripcion( String value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      SetDirty("Cendescripcion");
      gxTv_SdtLegajoCC_Cendescripcion = value ;
   }

   public String getgxTv_SdtLegajoCC_Mode( )
   {
      return gxTv_SdtLegajoCC_Mode ;
   }

   public void setgxTv_SdtLegajoCC_Mode( String value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtLegajoCC_Mode = value ;
   }

   public void setgxTv_SdtLegajoCC_Mode_SetNull( )
   {
      gxTv_SdtLegajoCC_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtLegajoCC_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajoCC_Initialized( )
   {
      return gxTv_SdtLegajoCC_Initialized ;
   }

   public void setgxTv_SdtLegajoCC_Initialized( short value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtLegajoCC_Initialized = value ;
   }

   public void setgxTv_SdtLegajoCC_Initialized_SetNull( )
   {
      gxTv_SdtLegajoCC_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtLegajoCC_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtLegajoCC_Clicod_Z( )
   {
      return gxTv_SdtLegajoCC_Clicod_Z ;
   }

   public void setgxTv_SdtLegajoCC_Clicod_Z( int value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtLegajoCC_Clicod_Z = value ;
   }

   public void setgxTv_SdtLegajoCC_Clicod_Z_SetNull( )
   {
      gxTv_SdtLegajoCC_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtLegajoCC_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajoCC_Empcod_Z( )
   {
      return gxTv_SdtLegajoCC_Empcod_Z ;
   }

   public void setgxTv_SdtLegajoCC_Empcod_Z( short value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_SdtLegajoCC_Empcod_Z = value ;
   }

   public void setgxTv_SdtLegajoCC_Empcod_Z_SetNull( )
   {
      gxTv_SdtLegajoCC_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_SdtLegajoCC_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtLegajoCC_Legnumero_Z( )
   {
      return gxTv_SdtLegajoCC_Legnumero_Z ;
   }

   public void setgxTv_SdtLegajoCC_Legnumero_Z( int value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      SetDirty("Legnumero_Z");
      gxTv_SdtLegajoCC_Legnumero_Z = value ;
   }

   public void setgxTv_SdtLegajoCC_Legnumero_Z_SetNull( )
   {
      gxTv_SdtLegajoCC_Legnumero_Z = 0 ;
      SetDirty("Legnumero_Z");
   }

   public boolean getgxTv_SdtLegajoCC_Legnumero_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajoCC_Cencodigo_Z( )
   {
      return gxTv_SdtLegajoCC_Cencodigo_Z ;
   }

   public void setgxTv_SdtLegajoCC_Cencodigo_Z( short value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      SetDirty("Cencodigo_Z");
      gxTv_SdtLegajoCC_Cencodigo_Z = value ;
   }

   public void setgxTv_SdtLegajoCC_Cencodigo_Z_SetNull( )
   {
      gxTv_SdtLegajoCC_Cencodigo_Z = (short)(0) ;
      SetDirty("Cencodigo_Z");
   }

   public boolean getgxTv_SdtLegajoCC_Cencodigo_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLegajoCC_Legcenprc_Z( )
   {
      return gxTv_SdtLegajoCC_Legcenprc_Z ;
   }

   public void setgxTv_SdtLegajoCC_Legcenprc_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      SetDirty("Legcenprc_Z");
      gxTv_SdtLegajoCC_Legcenprc_Z = value ;
   }

   public void setgxTv_SdtLegajoCC_Legcenprc_Z_SetNull( )
   {
      gxTv_SdtLegajoCC_Legcenprc_Z = DecimalUtil.ZERO ;
      SetDirty("Legcenprc_Z");
   }

   public boolean getgxTv_SdtLegajoCC_Legcenprc_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajoCC_Cendescripcion_Z( )
   {
      return gxTv_SdtLegajoCC_Cendescripcion_Z ;
   }

   public void setgxTv_SdtLegajoCC_Cendescripcion_Z( String value )
   {
      gxTv_SdtLegajoCC_N = (byte)(0) ;
      SetDirty("Cendescripcion_Z");
      gxTv_SdtLegajoCC_Cendescripcion_Z = value ;
   }

   public void setgxTv_SdtLegajoCC_Cendescripcion_Z_SetNull( )
   {
      gxTv_SdtLegajoCC_Cendescripcion_Z = "" ;
      SetDirty("Cendescripcion_Z");
   }

   public boolean getgxTv_SdtLegajoCC_Cendescripcion_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.legajocc_bc obj;
      obj = new web.legajocc_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtLegajoCC_N = (byte)(1) ;
      gxTv_SdtLegajoCC_Legcenprc = DecimalUtil.ZERO ;
      gxTv_SdtLegajoCC_Cendescripcion = "" ;
      gxTv_SdtLegajoCC_Mode = "" ;
      gxTv_SdtLegajoCC_Legcenprc_Z = DecimalUtil.ZERO ;
      gxTv_SdtLegajoCC_Cendescripcion_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtLegajoCC_N ;
   }

   public web.SdtLegajoCC Clone( )
   {
      web.SdtLegajoCC sdt;
      web.legajocc_bc obj;
      sdt = (web.SdtLegajoCC)(clone()) ;
      obj = (web.legajocc_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtLegajoCC struct )
   {
      setgxTv_SdtLegajoCC_Clicod(struct.getClicod());
      setgxTv_SdtLegajoCC_Empcod(struct.getEmpcod());
      setgxTv_SdtLegajoCC_Legnumero(struct.getLegnumero());
      setgxTv_SdtLegajoCC_Cencodigo(struct.getCencodigo());
      setgxTv_SdtLegajoCC_Legcenprc(struct.getLegcenprc());
      setgxTv_SdtLegajoCC_Cendescripcion(struct.getCendescripcion());
      setgxTv_SdtLegajoCC_Mode(struct.getMode());
      setgxTv_SdtLegajoCC_Initialized(struct.getInitialized());
      setgxTv_SdtLegajoCC_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtLegajoCC_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_SdtLegajoCC_Legnumero_Z(struct.getLegnumero_Z());
      setgxTv_SdtLegajoCC_Cencodigo_Z(struct.getCencodigo_Z());
      setgxTv_SdtLegajoCC_Legcenprc_Z(struct.getLegcenprc_Z());
      setgxTv_SdtLegajoCC_Cendescripcion_Z(struct.getCendescripcion_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtLegajoCC getStruct( )
   {
      web.StructSdtLegajoCC struct = new web.StructSdtLegajoCC ();
      struct.setClicod(getgxTv_SdtLegajoCC_Clicod());
      struct.setEmpcod(getgxTv_SdtLegajoCC_Empcod());
      struct.setLegnumero(getgxTv_SdtLegajoCC_Legnumero());
      struct.setCencodigo(getgxTv_SdtLegajoCC_Cencodigo());
      struct.setLegcenprc(getgxTv_SdtLegajoCC_Legcenprc());
      struct.setCendescripcion(getgxTv_SdtLegajoCC_Cendescripcion());
      struct.setMode(getgxTv_SdtLegajoCC_Mode());
      struct.setInitialized(getgxTv_SdtLegajoCC_Initialized());
      struct.setClicod_Z(getgxTv_SdtLegajoCC_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_SdtLegajoCC_Empcod_Z());
      struct.setLegnumero_Z(getgxTv_SdtLegajoCC_Legnumero_Z());
      struct.setCencodigo_Z(getgxTv_SdtLegajoCC_Cencodigo_Z());
      struct.setLegcenprc_Z(getgxTv_SdtLegajoCC_Legcenprc_Z());
      struct.setCendescripcion_Z(getgxTv_SdtLegajoCC_Cendescripcion_Z());
      return struct ;
   }

   private byte gxTv_SdtLegajoCC_N ;
   private short gxTv_SdtLegajoCC_Empcod ;
   private short gxTv_SdtLegajoCC_Cencodigo ;
   private short gxTv_SdtLegajoCC_Initialized ;
   private short gxTv_SdtLegajoCC_Empcod_Z ;
   private short gxTv_SdtLegajoCC_Cencodigo_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtLegajoCC_Clicod ;
   private int gxTv_SdtLegajoCC_Legnumero ;
   private int gxTv_SdtLegajoCC_Clicod_Z ;
   private int gxTv_SdtLegajoCC_Legnumero_Z ;
   private java.math.BigDecimal gxTv_SdtLegajoCC_Legcenprc ;
   private java.math.BigDecimal gxTv_SdtLegajoCC_Legcenprc_Z ;
   private String gxTv_SdtLegajoCC_Mode ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtLegajoCC_Cendescripcion ;
   private String gxTv_SdtLegajoCC_Cendescripcion_Z ;
}

