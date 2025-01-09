package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtporc_contr extends GxUserType
{
   public Sdtporc_contr( )
   {
      this(  new ModelContext(Sdtporc_contr.class));
   }

   public Sdtporc_contr( ModelContext context )
   {
      super( context, "Sdtporc_contr");
   }

   public Sdtporc_contr( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle, context, "Sdtporc_contr");
   }

   public Sdtporc_contr( StructSdtporc_contr struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "jub_A") )
            {
               gxTv_Sdtporc_contr_Jub_a = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "jub_B") )
            {
               gxTv_Sdtporc_contr_Jub_b = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "os_A") )
            {
               gxTv_Sdtporc_contr_Os_a = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "os_B") )
            {
               gxTv_Sdtporc_contr_Os_b = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "aaff_A") )
            {
               gxTv_Sdtporc_contr_Aaff_a = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "aaff_B") )
            {
               gxTv_Sdtporc_contr_Aaff_b = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "pami_A") )
            {
               gxTv_Sdtporc_contr_Pami_a = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "pami_B") )
            {
               gxTv_Sdtporc_contr_Pami_b = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "fne_A") )
            {
               gxTv_Sdtporc_contr_Fne_a = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "fne_B") )
            {
               gxTv_Sdtporc_contr_Fne_b = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "porc_contr" ;
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
      oWriter.writeElement("jub_A", GXutil.trim( GXutil.strNoRound( gxTv_Sdtporc_contr_Jub_a, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("jub_B", GXutil.trim( GXutil.strNoRound( gxTv_Sdtporc_contr_Jub_b, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("os_A", GXutil.trim( GXutil.strNoRound( gxTv_Sdtporc_contr_Os_a, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("os_B", GXutil.trim( GXutil.strNoRound( gxTv_Sdtporc_contr_Os_b, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("aaff_A", GXutil.trim( GXutil.strNoRound( gxTv_Sdtporc_contr_Aaff_a, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("aaff_B", GXutil.trim( GXutil.strNoRound( gxTv_Sdtporc_contr_Aaff_b, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("pami_A", GXutil.trim( GXutil.strNoRound( gxTv_Sdtporc_contr_Pami_a, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("pami_B", GXutil.trim( GXutil.strNoRound( gxTv_Sdtporc_contr_Pami_b, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("fne_A", GXutil.trim( GXutil.strNoRound( gxTv_Sdtporc_contr_Fne_a, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("fne_B", GXutil.trim( GXutil.strNoRound( gxTv_Sdtporc_contr_Fne_b, 6, 4)));
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
      AddObjectProperty("jub_A", gxTv_Sdtporc_contr_Jub_a, false, false);
      AddObjectProperty("jub_B", gxTv_Sdtporc_contr_Jub_b, false, false);
      AddObjectProperty("os_A", gxTv_Sdtporc_contr_Os_a, false, false);
      AddObjectProperty("os_B", gxTv_Sdtporc_contr_Os_b, false, false);
      AddObjectProperty("aaff_A", gxTv_Sdtporc_contr_Aaff_a, false, false);
      AddObjectProperty("aaff_B", gxTv_Sdtporc_contr_Aaff_b, false, false);
      AddObjectProperty("pami_A", gxTv_Sdtporc_contr_Pami_a, false, false);
      AddObjectProperty("pami_B", gxTv_Sdtporc_contr_Pami_b, false, false);
      AddObjectProperty("fne_A", gxTv_Sdtporc_contr_Fne_a, false, false);
      AddObjectProperty("fne_B", gxTv_Sdtporc_contr_Fne_b, false, false);
   }

   public java.math.BigDecimal getgxTv_Sdtporc_contr_Jub_a( )
   {
      return gxTv_Sdtporc_contr_Jub_a ;
   }

   public void setgxTv_Sdtporc_contr_Jub_a( java.math.BigDecimal value )
   {
      gxTv_Sdtporc_contr_N = (byte)(0) ;
      gxTv_Sdtporc_contr_Jub_a = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtporc_contr_Jub_b( )
   {
      return gxTv_Sdtporc_contr_Jub_b ;
   }

   public void setgxTv_Sdtporc_contr_Jub_b( java.math.BigDecimal value )
   {
      gxTv_Sdtporc_contr_N = (byte)(0) ;
      gxTv_Sdtporc_contr_Jub_b = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtporc_contr_Os_a( )
   {
      return gxTv_Sdtporc_contr_Os_a ;
   }

   public void setgxTv_Sdtporc_contr_Os_a( java.math.BigDecimal value )
   {
      gxTv_Sdtporc_contr_N = (byte)(0) ;
      gxTv_Sdtporc_contr_Os_a = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtporc_contr_Os_b( )
   {
      return gxTv_Sdtporc_contr_Os_b ;
   }

   public void setgxTv_Sdtporc_contr_Os_b( java.math.BigDecimal value )
   {
      gxTv_Sdtporc_contr_N = (byte)(0) ;
      gxTv_Sdtporc_contr_Os_b = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtporc_contr_Aaff_a( )
   {
      return gxTv_Sdtporc_contr_Aaff_a ;
   }

   public void setgxTv_Sdtporc_contr_Aaff_a( java.math.BigDecimal value )
   {
      gxTv_Sdtporc_contr_N = (byte)(0) ;
      gxTv_Sdtporc_contr_Aaff_a = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtporc_contr_Aaff_b( )
   {
      return gxTv_Sdtporc_contr_Aaff_b ;
   }

   public void setgxTv_Sdtporc_contr_Aaff_b( java.math.BigDecimal value )
   {
      gxTv_Sdtporc_contr_N = (byte)(0) ;
      gxTv_Sdtporc_contr_Aaff_b = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtporc_contr_Pami_a( )
   {
      return gxTv_Sdtporc_contr_Pami_a ;
   }

   public void setgxTv_Sdtporc_contr_Pami_a( java.math.BigDecimal value )
   {
      gxTv_Sdtporc_contr_N = (byte)(0) ;
      gxTv_Sdtporc_contr_Pami_a = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtporc_contr_Pami_b( )
   {
      return gxTv_Sdtporc_contr_Pami_b ;
   }

   public void setgxTv_Sdtporc_contr_Pami_b( java.math.BigDecimal value )
   {
      gxTv_Sdtporc_contr_N = (byte)(0) ;
      gxTv_Sdtporc_contr_Pami_b = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtporc_contr_Fne_a( )
   {
      return gxTv_Sdtporc_contr_Fne_a ;
   }

   public void setgxTv_Sdtporc_contr_Fne_a( java.math.BigDecimal value )
   {
      gxTv_Sdtporc_contr_N = (byte)(0) ;
      gxTv_Sdtporc_contr_Fne_a = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtporc_contr_Fne_b( )
   {
      return gxTv_Sdtporc_contr_Fne_b ;
   }

   public void setgxTv_Sdtporc_contr_Fne_b( java.math.BigDecimal value )
   {
      gxTv_Sdtporc_contr_N = (byte)(0) ;
      gxTv_Sdtporc_contr_Fne_b = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtporc_contr_Jub_a = DecimalUtil.ZERO ;
      gxTv_Sdtporc_contr_N = (byte)(1) ;
      gxTv_Sdtporc_contr_Jub_b = DecimalUtil.ZERO ;
      gxTv_Sdtporc_contr_Os_a = DecimalUtil.ZERO ;
      gxTv_Sdtporc_contr_Os_b = DecimalUtil.ZERO ;
      gxTv_Sdtporc_contr_Aaff_a = DecimalUtil.ZERO ;
      gxTv_Sdtporc_contr_Aaff_b = DecimalUtil.ZERO ;
      gxTv_Sdtporc_contr_Pami_a = DecimalUtil.ZERO ;
      gxTv_Sdtporc_contr_Pami_b = DecimalUtil.ZERO ;
      gxTv_Sdtporc_contr_Fne_a = DecimalUtil.ZERO ;
      gxTv_Sdtporc_contr_Fne_b = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtporc_contr_N ;
   }

   public web.Sdtporc_contr Clone( )
   {
      return (web.Sdtporc_contr)(clone()) ;
   }

   public void setStruct( web.StructSdtporc_contr struct )
   {
      setgxTv_Sdtporc_contr_Jub_a(struct.getJub_a());
      setgxTv_Sdtporc_contr_Jub_b(struct.getJub_b());
      setgxTv_Sdtporc_contr_Os_a(struct.getOs_a());
      setgxTv_Sdtporc_contr_Os_b(struct.getOs_b());
      setgxTv_Sdtporc_contr_Aaff_a(struct.getAaff_a());
      setgxTv_Sdtporc_contr_Aaff_b(struct.getAaff_b());
      setgxTv_Sdtporc_contr_Pami_a(struct.getPami_a());
      setgxTv_Sdtporc_contr_Pami_b(struct.getPami_b());
      setgxTv_Sdtporc_contr_Fne_a(struct.getFne_a());
      setgxTv_Sdtporc_contr_Fne_b(struct.getFne_b());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtporc_contr getStruct( )
   {
      web.StructSdtporc_contr struct = new web.StructSdtporc_contr ();
      struct.setJub_a(getgxTv_Sdtporc_contr_Jub_a());
      struct.setJub_b(getgxTv_Sdtporc_contr_Jub_b());
      struct.setOs_a(getgxTv_Sdtporc_contr_Os_a());
      struct.setOs_b(getgxTv_Sdtporc_contr_Os_b());
      struct.setAaff_a(getgxTv_Sdtporc_contr_Aaff_a());
      struct.setAaff_b(getgxTv_Sdtporc_contr_Aaff_b());
      struct.setPami_a(getgxTv_Sdtporc_contr_Pami_a());
      struct.setPami_b(getgxTv_Sdtporc_contr_Pami_b());
      struct.setFne_a(getgxTv_Sdtporc_contr_Fne_a());
      struct.setFne_b(getgxTv_Sdtporc_contr_Fne_b());
      return struct ;
   }

   protected byte gxTv_Sdtporc_contr_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdtporc_contr_Jub_a ;
   protected java.math.BigDecimal gxTv_Sdtporc_contr_Jub_b ;
   protected java.math.BigDecimal gxTv_Sdtporc_contr_Os_a ;
   protected java.math.BigDecimal gxTv_Sdtporc_contr_Os_b ;
   protected java.math.BigDecimal gxTv_Sdtporc_contr_Aaff_a ;
   protected java.math.BigDecimal gxTv_Sdtporc_contr_Aaff_b ;
   protected java.math.BigDecimal gxTv_Sdtporc_contr_Pami_a ;
   protected java.math.BigDecimal gxTv_Sdtporc_contr_Pami_b ;
   protected java.math.BigDecimal gxTv_Sdtporc_contr_Fne_a ;
   protected java.math.BigDecimal gxTv_Sdtporc_contr_Fne_b ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

