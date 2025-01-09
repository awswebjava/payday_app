package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtley_27541_ali extends GxUserType
{
   public Sdtley_27541_ali( )
   {
      this(  new ModelContext(Sdtley_27541_ali.class));
   }

   public Sdtley_27541_ali( ModelContext context )
   {
      super( context, "Sdtley_27541_ali");
   }

   public Sdtley_27541_ali( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle, context, "Sdtley_27541_ali");
   }

   public Sdtley_27541_ali( StructSdtley_27541_ali struct )
   {
      this();
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "jubilacion_A") )
            {
               gxTv_Sdtley_27541_ali_Jubilacion_a = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "jubilacion_B") )
            {
               gxTv_Sdtley_27541_ali_Jubilacion_b = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "inssjyp_A") )
            {
               gxTv_Sdtley_27541_ali_Inssjyp_a = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "inssjyp_B") )
            {
               gxTv_Sdtley_27541_ali_Inssjyp_b = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "aaff_A") )
            {
               gxTv_Sdtley_27541_ali_Aaff_a = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "aaff_B") )
            {
               gxTv_Sdtley_27541_ali_Aaff_b = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "fne_A") )
            {
               gxTv_Sdtley_27541_ali_Fne_a = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "fne_B") )
            {
               gxTv_Sdtley_27541_ali_Fne_b = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "ley_27541_ali" ;
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
      oWriter.writeElement("jubilacion_A", GXutil.trim( GXutil.strNoRound( gxTv_Sdtley_27541_ali_Jubilacion_a, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("jubilacion_B", GXutil.trim( GXutil.strNoRound( gxTv_Sdtley_27541_ali_Jubilacion_b, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("inssjyp_A", GXutil.trim( GXutil.strNoRound( gxTv_Sdtley_27541_ali_Inssjyp_a, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("inssjyp_B", GXutil.trim( GXutil.strNoRound( gxTv_Sdtley_27541_ali_Inssjyp_b, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("aaff_A", GXutil.trim( GXutil.strNoRound( gxTv_Sdtley_27541_ali_Aaff_a, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("aaff_B", GXutil.trim( GXutil.strNoRound( gxTv_Sdtley_27541_ali_Aaff_b, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("fne_A", GXutil.trim( GXutil.strNoRound( gxTv_Sdtley_27541_ali_Fne_a, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("fne_B", GXutil.trim( GXutil.strNoRound( gxTv_Sdtley_27541_ali_Fne_b, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("jubilacion_A", gxTv_Sdtley_27541_ali_Jubilacion_a, false, false);
      AddObjectProperty("jubilacion_B", gxTv_Sdtley_27541_ali_Jubilacion_b, false, false);
      AddObjectProperty("inssjyp_A", gxTv_Sdtley_27541_ali_Inssjyp_a, false, false);
      AddObjectProperty("inssjyp_B", gxTv_Sdtley_27541_ali_Inssjyp_b, false, false);
      AddObjectProperty("aaff_A", gxTv_Sdtley_27541_ali_Aaff_a, false, false);
      AddObjectProperty("aaff_B", gxTv_Sdtley_27541_ali_Aaff_b, false, false);
      AddObjectProperty("fne_A", gxTv_Sdtley_27541_ali_Fne_a, false, false);
      AddObjectProperty("fne_B", gxTv_Sdtley_27541_ali_Fne_b, false, false);
   }

   public java.math.BigDecimal getgxTv_Sdtley_27541_ali_Jubilacion_a( )
   {
      return gxTv_Sdtley_27541_ali_Jubilacion_a ;
   }

   public void setgxTv_Sdtley_27541_ali_Jubilacion_a( java.math.BigDecimal value )
   {
      gxTv_Sdtley_27541_ali_N = (byte)(0) ;
      gxTv_Sdtley_27541_ali_Jubilacion_a = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtley_27541_ali_Jubilacion_b( )
   {
      return gxTv_Sdtley_27541_ali_Jubilacion_b ;
   }

   public void setgxTv_Sdtley_27541_ali_Jubilacion_b( java.math.BigDecimal value )
   {
      gxTv_Sdtley_27541_ali_N = (byte)(0) ;
      gxTv_Sdtley_27541_ali_Jubilacion_b = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtley_27541_ali_Inssjyp_a( )
   {
      return gxTv_Sdtley_27541_ali_Inssjyp_a ;
   }

   public void setgxTv_Sdtley_27541_ali_Inssjyp_a( java.math.BigDecimal value )
   {
      gxTv_Sdtley_27541_ali_N = (byte)(0) ;
      gxTv_Sdtley_27541_ali_Inssjyp_a = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtley_27541_ali_Inssjyp_b( )
   {
      return gxTv_Sdtley_27541_ali_Inssjyp_b ;
   }

   public void setgxTv_Sdtley_27541_ali_Inssjyp_b( java.math.BigDecimal value )
   {
      gxTv_Sdtley_27541_ali_N = (byte)(0) ;
      gxTv_Sdtley_27541_ali_Inssjyp_b = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtley_27541_ali_Aaff_a( )
   {
      return gxTv_Sdtley_27541_ali_Aaff_a ;
   }

   public void setgxTv_Sdtley_27541_ali_Aaff_a( java.math.BigDecimal value )
   {
      gxTv_Sdtley_27541_ali_N = (byte)(0) ;
      gxTv_Sdtley_27541_ali_Aaff_a = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtley_27541_ali_Aaff_b( )
   {
      return gxTv_Sdtley_27541_ali_Aaff_b ;
   }

   public void setgxTv_Sdtley_27541_ali_Aaff_b( java.math.BigDecimal value )
   {
      gxTv_Sdtley_27541_ali_N = (byte)(0) ;
      gxTv_Sdtley_27541_ali_Aaff_b = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtley_27541_ali_Fne_a( )
   {
      return gxTv_Sdtley_27541_ali_Fne_a ;
   }

   public void setgxTv_Sdtley_27541_ali_Fne_a( java.math.BigDecimal value )
   {
      gxTv_Sdtley_27541_ali_N = (byte)(0) ;
      gxTv_Sdtley_27541_ali_Fne_a = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtley_27541_ali_Fne_b( )
   {
      return gxTv_Sdtley_27541_ali_Fne_b ;
   }

   public void setgxTv_Sdtley_27541_ali_Fne_b( java.math.BigDecimal value )
   {
      gxTv_Sdtley_27541_ali_N = (byte)(0) ;
      gxTv_Sdtley_27541_ali_Fne_b = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtley_27541_ali_Jubilacion_a = DecimalUtil.ZERO ;
      gxTv_Sdtley_27541_ali_N = (byte)(1) ;
      gxTv_Sdtley_27541_ali_Jubilacion_b = DecimalUtil.ZERO ;
      gxTv_Sdtley_27541_ali_Inssjyp_a = DecimalUtil.ZERO ;
      gxTv_Sdtley_27541_ali_Inssjyp_b = DecimalUtil.ZERO ;
      gxTv_Sdtley_27541_ali_Aaff_a = DecimalUtil.ZERO ;
      gxTv_Sdtley_27541_ali_Aaff_b = DecimalUtil.ZERO ;
      gxTv_Sdtley_27541_ali_Fne_a = DecimalUtil.ZERO ;
      gxTv_Sdtley_27541_ali_Fne_b = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtley_27541_ali_N ;
   }

   public web.Sdtley_27541_ali Clone( )
   {
      return (web.Sdtley_27541_ali)(clone()) ;
   }

   public void setStruct( web.StructSdtley_27541_ali struct )
   {
      setgxTv_Sdtley_27541_ali_Jubilacion_a(struct.getJubilacion_a());
      setgxTv_Sdtley_27541_ali_Jubilacion_b(struct.getJubilacion_b());
      setgxTv_Sdtley_27541_ali_Inssjyp_a(struct.getInssjyp_a());
      setgxTv_Sdtley_27541_ali_Inssjyp_b(struct.getInssjyp_b());
      setgxTv_Sdtley_27541_ali_Aaff_a(struct.getAaff_a());
      setgxTv_Sdtley_27541_ali_Aaff_b(struct.getAaff_b());
      setgxTv_Sdtley_27541_ali_Fne_a(struct.getFne_a());
      setgxTv_Sdtley_27541_ali_Fne_b(struct.getFne_b());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtley_27541_ali getStruct( )
   {
      web.StructSdtley_27541_ali struct = new web.StructSdtley_27541_ali ();
      struct.setJubilacion_a(getgxTv_Sdtley_27541_ali_Jubilacion_a());
      struct.setJubilacion_b(getgxTv_Sdtley_27541_ali_Jubilacion_b());
      struct.setInssjyp_a(getgxTv_Sdtley_27541_ali_Inssjyp_a());
      struct.setInssjyp_b(getgxTv_Sdtley_27541_ali_Inssjyp_b());
      struct.setAaff_a(getgxTv_Sdtley_27541_ali_Aaff_a());
      struct.setAaff_b(getgxTv_Sdtley_27541_ali_Aaff_b());
      struct.setFne_a(getgxTv_Sdtley_27541_ali_Fne_a());
      struct.setFne_b(getgxTv_Sdtley_27541_ali_Fne_b());
      return struct ;
   }

   protected byte gxTv_Sdtley_27541_ali_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdtley_27541_ali_Jubilacion_a ;
   protected java.math.BigDecimal gxTv_Sdtley_27541_ali_Jubilacion_b ;
   protected java.math.BigDecimal gxTv_Sdtley_27541_ali_Inssjyp_a ;
   protected java.math.BigDecimal gxTv_Sdtley_27541_ali_Inssjyp_b ;
   protected java.math.BigDecimal gxTv_Sdtley_27541_ali_Aaff_a ;
   protected java.math.BigDecimal gxTv_Sdtley_27541_ali_Aaff_b ;
   protected java.math.BigDecimal gxTv_Sdtley_27541_ali_Fne_a ;
   protected java.math.BigDecimal gxTv_Sdtley_27541_ali_Fne_b ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

